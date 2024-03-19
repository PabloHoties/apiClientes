--Criar a tabela de planos
create table plano(
	id		uuid			primary key,
	nome	varchar(25)		not null unique
);

--Criar a tabela de clientes
create table cliente(
	id			uuid			primary key,
	nome		varchar(150)	not null,
	telefone	varchar(15)		not null,
	email		varchar(50)		not null,
	plano_id	uuid			not null,
	foreign key(plano_id)
		references plano(id)
);

--Cadastrar planos
insert into plano(id, nome) values(gen_random_uuid(), 'Plano pessoa física');
insert into plano(id, nome) values(gen_random_uuid(), 'Plano pessoa jurídica');
insert into plano(id, nome) values(gen_random_uuid(), 'Plano pessoa preferencial');
insert into plano(id, nome) values(gen_random_uuid(), 'Plano pessoa vip');

select * from plano;
