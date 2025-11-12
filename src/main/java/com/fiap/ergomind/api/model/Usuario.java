package com.fiap.ergomind.api.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data; // Usando Lombok para Getters/Setters (opcional)

@Entity
@Table(name = "usuarios")
@Data // Gera Getters/Setters via Lombok
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "O nome é obrigatório.")
    @Size(min = 3, max = 100)
    private String nome; 

    @NotBlank(message = "O email é obrigatório.")
    @Email(message = "Email inválido.")
    @Column(unique = true) // Garante unicidade do email no banco
    private String email;

    private String areaAtuacao; 
    private String nivelCarreira; 
    // Data de cadastro pode ser gerada automaticamente (omito a lógica aqui por brevidade)
}