package com.fiap.ergomind.api.controller;

import com.fiap.ergomind.api.dto.AlertaIotDTO;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/monitoramento") // Rota conforme requisito do GS
public class MonitoramentoController {

    // POST /monitoramento - Recebe o alerta do dispositivo IoT
    @PostMapping
    public ResponseEntity<String> receberAlerta(@Valid @RequestBody AlertaIotDTO alerta) {
        
        // Simulação da Lógica de Serviço (Processamento do Alerta)
        // 1. O AlertaIotDTO é validado pelo @Valid
        // 2. Aqui a API (SOA) processaria a informação:
        //    a. Logar o alerta no banco de dados.
        //    b. Verificar regras de negócio (ex: 'inatividade' > 75 minutos [cite: 141]).
        //    c. Acionar a notificação de pausa para o usuário.
        
        System.out.println("Alerta IoT recebido para o Usuário ID: " + alerta.getUsuarioId());
        System.out.println("Tipo: " + alerta.getTipoAlerta());
        
        // Retorna Status 201 CREATED (Critério de Aceite: O dispositivo IoT deve enviar dados para o endpoint /monitoramento da API com sucesso (status 201) [cite: 141])
        return ResponseEntity.status(HttpStatus.CREATED).body("Alerta de " + alerta.getTipoAlerta() + " registrado com sucesso. Pausa recomendada.");
    }
}