create table  departments(
    id serial primary key,
    name varchar(50)
);

 insert into departments(name) values ('Бухгалтерия'), ('Отдел снабжение'), ('Отдел Кадров'), ('Отдел Главного Механика'), ('Отдел Главного Конструктора') ;

 create table  emploees(
    id serial primary key,
    name varchar(50),
    departments_id int references departments(id)
);



insert into emploees(name, departments_id )
         values ('Георгий Джикия', 1), (' Юрий Жирков', 1), (' Федор Кудряшов', 2), (' Андрей Семенов', 2),
                (' Марио Фернандес', 2), (' Александр Головин', 4), (' Рифат Жемалетдинов', 4), (' Далер Кузяев', 4),
                (' Магомед Оздоев',5), (' Антон Шунин', 5);

-- Выполнить запросы с left
select * from departments d left join emploees e  on e.departments_id = d.id;

---- Выполнить запросы с right
select * from departments d right join emploees e  on e.departments_id = d.id;

-- Выполнить запросы с outer
select * from departments d full join emploees e  on e.departments_id = d.id;

-- Выполнить запросы с cross
select * from departments d cross join emploees e

-- Используя left join найти департаменты, у которых нет работников
select d.name, e.name  from departments d left join emploees e on    d.id = e.departments_id  where e.name is null

-- Используя left и right join написать запросы, которые давали бы одинаковый результат.
select d.name, e.name from departments d left join emploees e  on e.departments_id = d.id;
select d.name, e.name from emploees e   right join departments d  on e.departments_id = d.id;


-- Создать таблицу teens с атрибутами name, gender и заполнить ее. Используя cross join составить все возможные разнополые пары

create table  teens(
    id serial primary key,
    name varchar(50) unique,
    gender varchar(50)
);

insert into teens(name, gender) values ('Вася','male'), ('Дима','male'), ('Саша','male'), ('Катя','female'), ('Яна','female');

select n1.name as a, n2.name as b  from teens n1 cross join teens n2
where  n1.gender = 'male' and  n2.gender = 'female' ;