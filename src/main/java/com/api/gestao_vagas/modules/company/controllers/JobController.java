package com.api.gestao_vagas.modules.company.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.gestao_vagas.modules.company.entities.JobEntity;
import com.api.gestao_vagas.modules.company.useCases.CreateJobUseCase;

import jakarta.validation.Valid;

@RestController
@RequestMapping(path = "/job")
public class JobController {

  @Autowired
  private CreateJobUseCase createJobUseCase;

  @PostMapping(path = "")
  public ResponseEntity<JobEntity> create(@RequestBody @Valid JobEntity jobEntity) {
    return ResponseEntity.status(HttpStatus.CREATED).body(this.createJobUseCase.execute(jobEntity));
  }

}
