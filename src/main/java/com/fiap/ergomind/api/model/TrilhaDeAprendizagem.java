package com.fiap.ergomind.api.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Entity
@Table(name = "trilhas")
@Data
public class TrilhaDeAprendizagem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "O nome da trilha é obrigatório.")
    private String nome;

    // CORREÇÃO: Adiciona @Lob para mapear a String para CLOB (TEXTO LONGO) no Oracle.
    @Lob 
    private String descricao;
    
    @NotBlank(message = "O nível é obrigatório.")
    private String nivel; // Valores permitidos: INICIANTE, INTERMEDIARIO, AVANCADO

    @Min(value = 1, message = "A carga horária deve ser positiva.") // Validação de carga horária positiva
    private int cargaHoraria; 

    private String focoPrincipal; 
}