create table men(
    id serial primary key,
    name varchar(255)
);

create table women(
    id serial primary key,
    name varchar(255)
);

create table married(
    id serial primary key,
    men_id int references men(id) unique,
    women_id int references women(id) unique
);


insert into men(name) values ('Ivan');
insert into men(name) values ('Kirill');
insert into men(name) values ('Roman');

insert into women(name) values ('Masha');
insert into women(name) values ('Alena');
insert into women(name) values ('Olga');

insert into married(men_id, women_id) values (1, 1);
insert into married(men_id, women_id) values (2, 2);
insert into married(men_id, women_id) values (3, 3);

