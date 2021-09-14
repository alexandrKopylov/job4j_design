create table devices(
    id serial primary key,
    name varchar(255),
    price float
);

create table people(
    id serial primary key,
    name varchar(255)
);

create table devices_people(
    id serial primary key,
    device_id int references devices(id),
    people_id int references people(id)
);


insert into devices(name, price) values ('devices1',1000), ('devices2',2000), ('devices3',3000),('devices4',4000), ('devices5',5000), ('devices6',6000);
insert into people(name) values ('Саша'), ('Маша'), ('Дима'), ('Алена'), ('Вася');
insert into devices_people(device_id, people_id) values (1, 1), (2, 1), (3, 1), (4, 1), (5, 1);
insert into devices_people(device_id, people_id) values  (5, 2), (6, 2);
insert into devices_people(device_id, people_id) values (1, 3), (2, 3), (3, 3);
insert into devices_people(device_id, people_id) values  (4, 4),(2, 4);
insert into devices_people(device_id, people_id) values  (3, 5),(6, 5);


select avg(price) from devices;

select p.name, avg(d.price) from devices_people as dp join people as p on dp.people_id = p.id
							join devices as d on dp.device_id = d.id
group by p.name
having avg(d.price) > 5000;