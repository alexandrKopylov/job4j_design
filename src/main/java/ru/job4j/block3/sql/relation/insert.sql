insert into state(name) values ('state1');
insert into state(name) values ('state2');
insert into state(name) values ('state3');

insert into role(name) values ('role1');
insert into role(name) values ('role2');
insert into role(name) values ('role3');

insert into category(name) values ('category1');
insert into category(name) values ('category2');
insert into category(name) values ('category3');

insert into users(name, role_id) values ('Sasha', 1);
insert into users(name, role_id) values ('Masha', 2);
insert into users(name, role_id) values ('Dima', 3);
insert into users(name, role_id) values ('Alena', 1);

insert into rules(name) values ('rules1');
insert into rules(name) values ('rules2');
insert into rules(name) values ('rules3');

insert into item(name, users_id, category_id, state_id) values ('item1', 3,2,1);
insert into item(name, users_id, category_id, state_id) values ('item2', 1,1,3);
insert into item(name, users_id, category_id, state_id) values ('item3', 2,3,3);
insert into item(name, users_id, category_id, state_id) values ('item4', 4,1,2);

insert into comments(name, item_id) values ('comments1', 1);
insert into comments(name, item_id) values ('comments2', 1);
insert into comments(name, item_id) values ('comments2', 3);

insert into attachs(name, item_id) values ('attachs1', 1);
insert into attachs(name, item_id) values ('attachs2', 3);
insert into attachs(name, item_id) values ('attachs3', 2);
insert into attachs(name, item_id) values ('attachs4', 2);

insert into role_rules(role_id, rules_id) values (1, 1);
insert into role_rules(role_id, rules_id) values (1, 2);
insert into role_rules(role_id, rules_id) values (2, 3);
insert into role_rules(role_id, rules_id) values (3, 1);

