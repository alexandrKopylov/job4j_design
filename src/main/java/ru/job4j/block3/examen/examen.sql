CREATE TABLE company
(
    id integer NOT NULL,
    name character varying,
    CONSTRAINT company_pkey PRIMARY KEY (id)
);

CREATE TABLE person
(
    id integer NOT NULL,
    name character varying,
    company_id integer references company(id),
    CONSTRAINT person_pkey PRIMARY KEY (id)
);

INSERT INTO company (id, name) VALUES (1, 'company1');
INSERT INTO company (id, name) VALUES (2, 'company2');
INSERT INTO company (id, name) VALUES (3, 'company3');
INSERT INTO company (id, name) VALUES (4, 'company4');
INSERT INTO company (id, name) VALUES (5, 'company5');


INSERT INTO person(id, name, company_id) VALUES (1, 'name1', 1);
INSERT INTO person(id, name, company_id) VALUES (2, 'name2', 2), (3, 'name3', 2);
INSERT INTO person(id, name, company_id) VALUES (4, 'name4', 3), (5, 'name5', 3), (6, 'name6', 3);
INSERT INTO person(id, name, company_id) VALUES (7, 'name7', 4), (8, 'name8', 4), (9, 'name9', 4), (10, 'name10', 4);
INSERT INTO person(id, name, company_id) VALUES (11, 'name11', 5), (12, 'name12', 5), (13, 'name13', 5),  (14, 'name14', 5), (15, 'name15', 5);


-- имена всех person, которые не состоят в компании с id = 5;
select * from person where company_id != 5;

-- название компании для каждого человека.
select p.name as name_person, c.name as name_company from person as p join company as c  on  p.company_id = c.id;

-- Необходимо выбрать название компании с максимальным количеством человек + количество человек в этой компании.
select c.name as company_name, p.max_number as count_of_person
from  company as c  join (select company_id , count (*) as max_number from person
                            group by company_id
                            order by  company_id desc
                            limit 1
                            ) as  p on c.id = p.company_id;

