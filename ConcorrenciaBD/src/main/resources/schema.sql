create table contas_bancarias (
    id serial primary key,
    numero_conta varchar(255),
    saldo NUMERIC(15, 2),
    titular varchar(255)
);

create table contas_bancarias_versionada (
    id serial primary key,
    numero_conta varchar(255),
    saldo NUMERIC(15, 2),
    version integer,
    titular varchar(255)
);