-- пример 1
create table numbers(
    num int unique
);

insert into numbers(num) values (1);
insert into numbers(num) values (2);
insert into numbers(num) values (3);

select n1.num as a, n2.num as b, (n1.num * n2.num) as "a*b=" from numbers n1 cross join numbers n2

-- пример 2
create table  teens(
    id serial primary key,
    name varchar(50) unique,
    gender varchar(50)
);

insert into teens(name, gender) values ('Вася','male'), ('Дима','male'), ('Саша','male'), ('Катя','female'), ('Яна','female');

select n1.name as a, n2.name as b  from teens n1 cross join teens n2
where  n1.gender = 'male' and  n2.gender = 'female' ;