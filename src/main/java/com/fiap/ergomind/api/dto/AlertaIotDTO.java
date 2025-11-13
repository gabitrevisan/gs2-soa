package com.fiap.ergomind.api.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import java.time.LocalDateTime;

@Data
public class AlertaIotDTO {

    @NotNull(message = "O ID do usuário é obrigatório.")
    private Long usuarioId;

    @NotBlank(message = "O tipo de alerta é obrigatório (ex: inatividade, má-postura).")
    private String tipoAlerta;

    // A data/hora do alerta, idealmente enviada pelo sensor
    private LocalDateTime timestamp = LocalDateTime.now();
    
    // Outros campos relevantes (ex: 'duracaoInatividade')
}