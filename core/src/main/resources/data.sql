insert into eptituders (name, side, password)
VALUES ('Bloodyslav', 'evil', '$2a$10$2X2ATtXkPTNUGGFM3rhQYOq9QVp77bjr9BmzIJh9YAkouhL81W9qi');
insert into eptituder_roles values ('Bloodyslav', 'ROLE_USER');

insert into eptituders (name, side, password)
VALUES ('Danuke', 'evil', '$2a$10$2X2ATtXkPTNUGGFM3rhQYOq9QVp77bjr9BmzIJh9YAkouhL81W9qi');
insert into eptituder_roles values ('Danuke', 'ROLE_USER');
insert into eptituder_roles values ('Danuke', 'ROLE_ADMIN');

insert into eptituders (name, side, password)
VALUES ('Alethunder', 'good', '$2a$10$2X2ATtXkPTNUGGFM3rhQYOq9QVp77bjr9BmzIJh9YAkouhL81W9qi');
insert into eptituder_roles values ('Alethunder', 'ROLE_USER');

INSERT INTO clans (name, side) VALUES ('akatsuke', 'evil');
UPDATE eptituders SET clan_id = 1 WHERE id=2;

INSERT INTO events (name, description, date, status)
VALUES ('Avenger\'s creation',
        'Loki gains access to the Tesseract, Nick Fury creates Avengers to save Earth',
        DATE '2012-5-1',
        'finished');
INSERT INTO eptituders_events
VALUES (1, 1);

INSERT INTO questions (question) VALUES ('Question #1');
INSERT INTO questions (question) VALUES ('Question #2');
INSERT INTO questions (question) VALUES ('Question #3');