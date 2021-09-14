create table faculty(
    id serial primary key,
     name varchar(50)
);


create table  students(
    id serial primary key,
    first_name varchar(50),
    last_name varchar(50),
    faculty_id int references course(id)
);

insert into faculty(name) values ('Math');
insert into faculty(name) values ('Programmer');
insert into faculty(name) values ('history');

insert into students(first_name, last_name, faculty) values ('Sasha', 'Kopylov', 1);
insert into students(first_name, last_name, faculty) values ('Masha', 'Kopylova', 2);
insert into students(first_name, last_name, faculty) values ('Dima', 'Kopylov', 3);
insert into students(first_name, last_name) values ('Jenya', 'Karpov');
insert into students(first_name, last_name) values ('Sergei', 'Medvedev');

select * from students join faculty on faculty_id = faculty.id;
select s.first_name, f.name  from students s join faculty f on s.faculty_id = f.id;
select s.last_name as фамилия, f.name as факультет from students s join faculty f on s.faculty_id = f.id;
