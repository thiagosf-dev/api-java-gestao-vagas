package com.api.gestao_vagas.modules.candidate.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.gestao_vagas.modules.candidate.CandidateEntity;
import com.api.gestao_vagas.modules.candidate.useCases.CreateCandidateUseCase;

import jakarta.validation.Valid;

@RestController
@RequestMapping(path = "/candidate")
public class CandidateController {

  @Autowired
  private CreateCandidateUseCase createCandidateUseCase;

  @PostMapping(path = "")
  public ResponseEntity<Object> create(@RequestBody @Valid CandidateEntity candidateEntity) {
    try {
      var result = createCandidateUseCase.execute(candidateEntity);
      return ResponseEntity.status(HttpStatus.CREATED).body(result);
    } catch (Exception e) {
      return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
    }
  }

}
