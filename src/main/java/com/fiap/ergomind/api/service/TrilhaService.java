package com.fiap.ergomind.api.service;

import com.fiap.ergomind.api.model.TrilhaDeAprendizagem;
import com.fiap.ergomind.api.repository.TrilhaRepository;
import com.fiap.ergomind.api.service.exception.TrilhaNaoEncontradaException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TrilhaService {

    @Autowired
    private TrilhaRepository trilhaRepository;

    public List<TrilhaDeAprendizagem> listarTodos() {
        return trilhaRepository.findAll();
    }

    public Optional<TrilhaDeAprendizagem> buscarPorId(Long id) {
        return trilhaRepository.findById(id);
    }

    public TrilhaDeAprendizagem criar(TrilhaDeAprendizagem trilha) {
        return trilhaRepository.save(trilha);
    }

    public TrilhaDeAprendizagem atualizar(Long id, TrilhaDeAprendizagem trilhaAtualizada) {
        return trilhaRepository.findById(id).map(trilha -> {
            trilha.setNome(trilhaAtualizada.getNome());
            trilha.setDescricao(trilhaAtualizada.getDescricao());
            trilha.setNivel(trilhaAtualizada.getNivel());
            trilha.setCargaHoraria(trilhaAtualizada.getCargaHoraria());
            trilha.setFocoPrincipal(trilhaAtualizada.getFocoPrincipal());
            return trilhaRepository.save(trilha);
        }).orElseThrow(() -> new TrilhaNaoEncontradaException("Trilha de Aprendizagem não encontrada para atualização (ID: " + id + ")."));
    }

    public void deletar(Long id) {
        if (!trilhaRepository.existsById(id)) {
            throw new TrilhaNaoEncontradaException("Trilha de Aprendizagem não encontrada para exclusão (ID: " + id + ").");
        }
        trilhaRepository.deleteById(id);
    }
}