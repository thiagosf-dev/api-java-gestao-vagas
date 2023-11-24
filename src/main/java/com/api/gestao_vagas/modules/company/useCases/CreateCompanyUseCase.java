package com.api.gestao_vagas.modules.company.useCases;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.gestao_vagas.modules.company.entities.CompanyEntity;
import com.api.gestao_vagas.modules.company.repositories.CompanyRepository;
import com.api.gestao_vagas.modules.exceptions.UserFoundException;

@Service
public class CreateCompanyUseCase {

  @Autowired
  private CompanyRepository companyRepository;

  public CompanyEntity execute(CompanyEntity companyEntity) {
    this.companyRepository.findByUsernameOrEmail(companyEntity.getUsername(), companyEntity.getEmail())
        .ifPresent(user -> {
          throw new UserFoundException();
        });

    return this.companyRepository.save(companyEntity);
  }

}