package com.api.gestao_vagas.modules.candidate;

import java.util.UUID;

import org.hibernate.validator.constraints.Length;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
public class CandidateEntity {

  private UUID id;

  private String curriculum;

  private String description;

  @Email(message = "Campo inválido.")
  private String email;

  private String name;

  @Length(min = 3, max = 20, message = "Campo deve ter entre 3 e 20 caracteres.")
  private String password;

  @NotBlank(message = "Campo não pode ser vazio.")
  @Pattern(regexp = "\\S+", message = "Campo não pode conter espaço.")
  private String username;

}
