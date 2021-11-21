insert into users (id, user_name, email_address, password, biography)
values (1, 'Christina', 'christina@gmail.com', 'xxx', 'Hoi ik ben'),
       (2, 'Jacques', 'jacques@gmail.com', 'xxx', 'Hoi ik ben J'),
       (3, 'Merlin', 'm@gmail.com', 'xxx', 'Hoi ik ben een kat');

insert into recipes (title, ingredients, description, is_private, user_id)
values ('kip pasta', 'kip, pasta, water, zout', 'maak de pasta en kip', false, 1),
       ('Citroen taart', 'citroenen 6x, meel, water, eieren', 'zet de oven aan en maak de citroenen schoon', true, 2),
       ('kippensoep', 'kip, wortel, water, zout', 'zet het water op en maak de wortel schoon', true, 3),
       ('zuurvlees', 'sukadelappen, suiker, peperkoek, zout', 'verhit de pan en braad het vlees', false, 1);