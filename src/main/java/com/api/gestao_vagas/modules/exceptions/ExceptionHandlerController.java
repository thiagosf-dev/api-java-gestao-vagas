package com.api.gestao_vagas.modules.exceptions;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionHandlerController {

  private MessageSource messageSource;

  ExceptionHandlerController(MessageSource message) {
    this.messageSource = message;
  }

  @ExceptionHandler(MethodArgumentNotValidException.class)
  public ResponseEntity<List<ErrorMessageDto>> handleMethodArgumentNotValidException(
      MethodArgumentNotValidException e) {
    List<ErrorMessageDto> messagesDto = new ArrayList<>();

    e.getBindingResult().getFieldErrors().forEach(err -> {
      String message = messageSource.getMessage(err, LocaleContextHolder.getLocale());

      var error = new ErrorMessageDto(err.getField(), message);

      messagesDto.add(error);
    });

    return new ResponseEntity<>(messagesDto, HttpStatus.BAD_REQUEST);
  }

}
