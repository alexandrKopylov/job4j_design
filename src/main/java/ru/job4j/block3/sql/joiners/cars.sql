create table body(
    id serial primary key,
    name varchar(50)
);

create table engine(
    id serial primary key,
    name varchar(50)
);


create table transmission(
    id serial primary key,
    name varchar(50)
);


create table cars(
    id serial primary key,
    name varchar(100),
    body_id int references body(id),
    engine_id int references engine(id),
    transmission_id int references transmission(id)
);

insert into body(name) values ('седан'),('хэтчбек'),('универсал'),('джип'),('микроавтобус');
insert into engine(name) values ('бензин'),('дизель'),('гибрид'),('газ'),('электрический');
insert into transmission(name) values ('механическая'),('автомат'),('робот'),('вариатор');

insert into cars(name,  body_id, engine_id,  transmission_id )
values ('Ваз-2101',1,1,1),('Ваз-2104',3,1,1),('шевроле Круз',2,1,2 ),('ауди',4,2,4), ('тесла',1,5,3);


--Вывести список всех машин и все привязанные к ним детали.
select  c.name marka , b.name body, e.name engine, t.name transmission from cars c
                    join body b on c.body_id = b.id
                    join engine e on c.engine_id = e.id
                    join transmission  t on c.transmission_id = t.id;

--  Вывести отдельно детали , которые не используются НИ в одной машине, кузов
select  b.name from cars as c right join body  b on c.body_id = b.id
where c.name is null;

--  Вывести отдельно детали , которые не используются НИ в одной машине, двигатель
select e.name from cars c right join engine e on c.engine_id = e.id
where c.name is null;

--  Вывести отдельно детали , которые не используются НИ в одной машине, коробка передач
select t.name from cars c right join transmission t on c.transmission_id = t.id
where c.name is null;