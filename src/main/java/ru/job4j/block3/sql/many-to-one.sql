create table country(
    id serial primary key,
    name varchar(255)
);


create table cityes(
    id serial primary key,
    name varchar(255),
    country_id int references country(id)
);

insert into country(name) values ('Russia');
insert into country(name) values ('England');
insert into cityes(name, country_id) values ('Moscow', 1);
insert into cityes(name, country_id) values ('Kurgan', 1);
insert into cityes(name, country_id) values ('London', 2);
insert into cityes(name, country_id) values ('Manchester', 2);