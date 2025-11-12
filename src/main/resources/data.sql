-- Seeds para a entidade Trilhas (Exemplo)
INSERT INTO trilhas (nome, descricao, nivel, carga_horaria, foco_principal) 
VALUES ('Ergonomia no Home Office', 'Aprenda a configurar seu espaço para evitar fadiga.', 'INICIANTE', 10, 'Bem-Estar Físico');

INSERT INTO trilhas (nome, descricao, nivel, carga_horaria, foco_principal) 
VALUES ('Mindfulness Corporativo', 'Técnicas de foco e redução de estresse e ansiedade.', 'INTERMEDIARIO', 8, 'Competência Humana');

-- Seeds para Usuários de Exemplo
INSERT INTO usuarios (nome, email, area_atuacao, nivel_carreira) 
VALUES ('Aluno Exemplo', 'aluno@fiap.com.br', 'Tecnologia', 'INICIANTE');