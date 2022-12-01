create table if not exists cachorro(

    id SERIAL,
    name varchar(100) not null,
    cor varchar(100) not null,
    raca_id integer not null,

    constraint pk_cachorro primary key (id),
    constraint fk_cachorro_raca foreign key(raca_id) references raca(id)

);