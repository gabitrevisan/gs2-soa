package com.fiap.ergomind.api.controller;

import com.fiap.ergomind.api.dto.AlertaIotDTO;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/monitoramento") // Endpoint conforme o critério de aceite
public class MonitoramentoController {

    /**
     * Simula o recebimento de dados do dispositivo IoT (Sensor de Postura/Fadiga).
     * Este endpoint é o ponto de entrada da arquitetura SOA para a Feature 1.
     * Retorna 201 Created conforme o critério de aceite.
     * @param alerta Dados do sensor
     * @return Resposta com status 201
     */
    @PostMapping
    public ResponseEntity<String> receberAlerta(@Valid @RequestBody AlertaIotDTO alerta) {
        
        // Simulação da lógica de negócio (Service Layer):
        // 1. O AlertaIotDTO é validado pelo @Valid.
        // 2. Aqui, a API (SOA) processaria a informação, por exemplo:
        //    - Logar o alerta (Alerta: inatividade do usuário ID 1)
        //    - Acionar a notificação de pausa para o usuário (Chamada a outro serviço/mecanismo)
        
        System.out.println("--- Alerta IoT Recebido ---");
        System.out.println("Usuário ID: " + alerta.getUsuarioId());
        System.out.println("Tipo de Alerta: " + alerta.getTipoAlerta());
        System.out.println("Timestamp: " + alerta.getTimestamp());
        System.out.println("---------------------------");
        
        // Retorna Status 201 CREATED (Critério de Aceite: O dispositivo loT deve enviar dados com sucesso - status 201)
        return ResponseEntity.status(HttpStatus.CREATED).body("Alerta de " + alerta.getTipoAlerta() + " registrado com sucesso. Próxima ação: Notificação de pausa acionada.");
    }
}