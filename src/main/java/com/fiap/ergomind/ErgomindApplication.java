package com.fiap.ergomind;

import com.fiap.ergomind.api.model.TrilhaDeAprendizagem;
import com.fiap.ergomind.api.model.Usuario;
import com.fiap.ergomind.api.service.TrilhaService;
import com.fiap.ergomind.api.service.UsuarioService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ErgomindApplication {

	public static void main(String[] args) {
		SpringApplication.run(ErgomindApplication.class, args);
	}

	// NOVO MÉTODO: Data Seeding via CommandLineRunner para garantir que a inserção
	// ocorra APÓS a criação das tabelas pelo Hibernate.
	@Bean
	public CommandLineRunner dataSeeder(UsuarioService usuarioService, TrilhaService trilhaService) {
		return args -> {
			
			// ------------------------------------------
			// SEEDING TRILHAS
			// ------------------------------------------
			TrilhaDeAprendizagem trilha1 = new TrilhaDeAprendizagem();
			trilha1.setNome("Ergonomia no Home Office");
			trilha1.setDescricao("Aprenda a configurar seu espaço para evitar fadiga.");
			trilha1.setNivel("INICIANTE");
			trilha1.setCargaHoraria(10);
			trilha1.setFocoPrincipal("Bem-Estar Físico");
			trilhaService.criar(trilha1);

			TrilhaDeAprendizagem trilha2 = new TrilhaDeAprendizagem();
			trilha2.setNome("Mindfulness Corporativo");
			trilha2.setDescricao("Técnicas de foco e redução de estresse e ansiedade.");
			trilha2.setNivel("INTERMEDIARIO");
			trilha2.setCargaHoraria(8);
			trilha2.setFocoPrincipal("Competência Humana");
			trilhaService.criar(trilha2);

			// ------------------------------------------
			// SEEDING USUÁRIOS
			// ------------------------------------------
			Usuario usuario1 = new Usuario();
			usuario1.setNome("Aluno Exemplo");
			usuario1.setEmail("aluno@fiap.com.br");
			usuario1.setAreaAtuacao("Tecnologia");
			usuario1.setNivelCarreira("INICIANTE");
			usuarioService.criar(usuario1);
			
			System.out.println(">>> SEEDING COMPLETO: 2 Trilhas e 1 Usuário criados.");
		};
	}
}