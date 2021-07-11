-- relacionado tabelas

-- criando um campo na tabela de quadra para usar como chave estrangeira
alter table quadra add proprietarioQuadra bigint not null;

-- Usando o campo criado como uma chave estrangeira referenciando a tabela de usuario
alter table quadra add constraint proprietarioQuadra foreign key(proprietarioQuadra) references usuario(id); 
-- Um usuario pode ser dono de muitas quadras, um para muitos

-- criando um campo na tabela de quadra para usar como chave estrangeira de infoquadra
alter table quadra add infoQuadra_id bigint not null;

-- Usando o campo criado como uma chave estrangeira referenciando a tabela infoQuadra
alter table quadra add constraint infoQuadra_id foreign key(infoQuadra_id) references infoQuadra(id); 
-- Uma quadra pode estar disponível em varias datas diferentes, uma quadra para muitas datas

-- Criando a tabela de relacionamento muitos para muitos, onde muitos jogadores podem estar em muitas datas de quadra
create table jogadores_na_infoQuadra(
    jogador_id bigint not null,
    infoQuadra_id bigint not null,
    
    foreign key(jogador_id) references usuario(id),
    foreign key(infoQuadra_id) references infoQuadra(id)
    
);
