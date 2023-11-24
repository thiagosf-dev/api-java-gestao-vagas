package com.api.gestao_vagas.modules.company.repositories;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.api.gestao_vagas.modules.company.entities.CompanyEntity;

@Repository
public interface CompanyRepository
    extends JpaRepository<CompanyEntity, UUID> {

  Optional<CompanyEntity> findByUsernameOrEmail(String username, String email);

}
