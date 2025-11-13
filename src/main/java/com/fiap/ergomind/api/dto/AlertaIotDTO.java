package com.fiap.ergomind.api.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import java.time.LocalDateTime;

@Data
public class AlertaIotDTO {

    @NotNull(message = "O ID do usuário é obrigatório.")
    private Long usuarioId;

    @NotBlank(message = "O tipo de alerta é obrigatório (ex: inatividade, ma-postura).")
    private String tipoAlerta;

    private LocalDateTime timestamp;
}