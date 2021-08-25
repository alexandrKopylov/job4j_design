CREATE DATABASE university;

create table students(
	id serial primary key,
	name CHARACTER VARYING(30),
    course INTEGER,
	birthday Date,
    scholarship money,
	cathedra text
);


insert into students(name, course, birthday, scholarship, cathedra)
		values('Sasha', 2, '2000-01-01', 100, 'GM' );


update students set course = 3;

delete from students;