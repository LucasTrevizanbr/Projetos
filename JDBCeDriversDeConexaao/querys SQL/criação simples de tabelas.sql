-- Criando um banco de dados
create database sharefields;

-- Acessando banco
use sharefields;

-- Cria a tabela com seus tipos e constraints
create table usuario(
	id bigint auto_increment not null,
    disponibilizadorDeQuadra boolean,
    nome varchar(250) not null,
    avatar varchar(500) ,
    apelido varchar (100),
    email varchar(250),
    senha varchar(100),
    primary key(id) -- Define qual atributo é a chave primária da tabela
);

create table quadra(
	id bigint(5) auto_increment not null,
    nome varchar(250) not null,
    modalidade varchar(150) not null,
    qtdJogadoresMax tinyint not null,
    descricao varchar(250) not null,
    primary key (id)
);

create table infoQuadra(
	id bigint(5) auto_increment not null,
    data DATE,
    horaInicio datetime,
    horaFim datetime,
    primary key (id)
);




