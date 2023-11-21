package com.api.gestao_vagas.modules.exceptions;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ErrorMessageDto {

  private String field;
  private String message;

}
