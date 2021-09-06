create table type(
    id serial primary key,
    name varchar(50)
);

insert into type(name) values ('Молочные продукты'), ('Хлебные продукты'), ('Сырные продукты');


create table product(
    id serial primary key,
    name varchar(100),
    type_id int references type(id),
    expired_date timestamp ,
    price float
);

insert into product(name, type_id, expired_date, price)
values ('молоко', 1, now() + interval '30 days', 55.5 );

insert into product(name, type_id, expired_date, price)
values ('кефир', 1, now() + interval '30 days', 60.5 );

insert into product(name, type_id, expired_date, price)
values ('йогурт', 1, now() + interval '30 days', 30.5 );

insert into product(name, type_id, expired_date, price)
values ('ряженка', 1, now() + interval '30 days', 47.5 );

insert into product(name, type_id, expired_date, price)
values ('творог', 1, now() + interval '30 days', 67.5 );

insert into product(name, type_id, expired_date, price)
values ('мороженое пломбир', 1, now() + interval '30 days', 54.5 );

insert into product(name, type_id, expired_date, price)
values ('мороженое молочное', 1, now() + interval '30 days', 25.5 );

insert into product(name, type_id, expired_date, price)
values ('простокваша', 1, now() + interval '30 days', 35.5 );

insert into product(name, type_id, expired_date, price)
values ('Сметана ', 1, now() + interval '30 days', 52.5 );

insert into product(name, type_id, expired_date, price)
values ('Творожок ', 1, now() + interval '30 days', 53.0 );

insert into product(name, type_id, expired_date, price)
values ('Сливочные масло ', 1, now() + interval '30 days', 100.5 );

insert into product(name, type_id, expired_date, price)
values ('Маргарин ', 1, now() + interval '30 days', 32.5 );






insert into product(name, type_id, expired_date, price)
values ('хлеб', 2, now() + interval '30 days', 22.5 );

insert into product(name, type_id, expired_date, price)
values ('булочка', 2, now() + interval '30 days', 15.5 );

insert into product(name, type_id, expired_date, price)
values ('батон', 2, now() + interval '30 days', 37.5 );

insert into product(name, type_id, expired_date, price)
values ('лепешка', 2, now() + interval '30 days', 25.5 );

insert into product(name, type_id, expired_date, price)
values ('лаваш', 2, now() + interval '30 days', 44.5 );



insert into product(name, type_id, expired_date, price)
values ('сыр моцарелла', 3, now() + interval '30 days', 152.5 );

insert into product(name, type_id, expired_date, price)
values ('сыр масдам', 3, now() + interval '30 days', 170.5 );

insert into product(name, type_id, expired_date, price)
values ('сыр с дырками', 3, now() + interval '30 days',222.5 );

insert into product(name, type_id, expired_date, price)
values ('сыр с плесенью', 3, now(), 289.5 );

insert into product(name, type_id, expired_date, price)
values ('сыр ламберт', 3, now() + interval '30 days', 170.5 );




--1. Написать запрос получение всех продуктов с типом "СЫР"
select * from product join type on product.type_id = type.id
where type.name = 'Сырные продукты';

--2. Написать запрос получения всех продуктов, у кого в имени есть слово "мороженое"
select * from product where name like '%мороженое%';

--3. Написать запрос, который выводит все продукты, срок годности которых уже истек
select * from product where expired_date < now();

--4. Написать запрос, который выводит самый дорогой продукт.
select name, price from product where price = (select max(price) from product);

--5. Написать запрос, который выводит для каждого типа количество продуктов к нему принадлежащих. В виде имя_типа, количество
select type.name , count(*) from product join type on product.type_id = type.id
group by type.name ;

--6. Написать запрос получение всех продуктов с типом "СЫР" и "МОЛОКО"
select * from product join type on product.type_id = type.id
where type.name = 'Сырные продукты' or type.name = 'Молочные продукты';

--7. Написать запрос, который выводит тип продуктов, которых осталось меньше 10 штук
select  type.name, count(*) from product join type on product.type_id = type.id
group by type.name
having count(*) < 10;

--8. Вывести все продукты и их тип.
select  type.name, product.name from product join type on product.type_id = type.id





