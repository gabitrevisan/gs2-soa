package com.fiap.ergomind.api.repository;

import com.fiap.ergomind.api.model.TrilhaDeAprendizagem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TrilhaRepository extends JpaRepository<TrilhaDeAprendizagem, Long> {
}