package com.api.gestao_vagas.modules.candidate.controllers;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.gestao_vagas.modules.candidate.CandidateEntity;

import jakarta.validation.Valid;

@RestController
@RequestMapping(path = "/candidate")
public class CandidateController {

  @PostMapping(path = "")
  public void create(@RequestBody @Valid CandidateEntity candidateEntity) {
    System.out.println(candidateEntity.getName());
  }

}
