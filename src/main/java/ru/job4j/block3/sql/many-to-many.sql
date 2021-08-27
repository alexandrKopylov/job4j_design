 create table readers(
     id serial primary key,
     name varchar(255)
 );

 create table books(
     id serial primary key,
     name varchar(255)
 );

 create table readers_books(
     id serial primary key,
     reader_id int references readers(id),
     book_id int references books(id)
 );

insert into readers(name) values ('Sasha');
insert into readers(name) values ('Dima');
insert into readers(name) values ('Masha');

insert into books(name) values ('Java ');
insert into books(name) values ('C++');
insert into books(name) values ('Python');

insert into readers_books(reader_id, book_id) values (1, 1);
insert into readers_books(reader_id, book_id) values (1, 2);
insert into readers_books(reader_id, book_id) values (1, 3);
insert into readers_books(reader_id, book_id) values (2, 1);
insert into readers_books(reader_id, book_id) values (2, 2);
insert into readers_books(reader_id, book_id) values (3, 3);
