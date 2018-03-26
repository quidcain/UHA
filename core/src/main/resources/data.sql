insert into eptituders (name, side, role, password)
VALUES ('Bloodyslav', 'evil', 'user',
        '$2a$10$2X2ATtXkPTNUGGFM3rhQYOq9QVp77bjr9BmzIJh9YAkouhL81W9qi');
insert into eptituders (name, side, role, password)
VALUES ('Danuke', 'evil', 'admin',
        '$2a$10$2X2ATtXkPTNUGGFM3rhQYOq9QVp77bjr9BmzIJh9YAkouhL81W9qi');
insert into eptituders (name, side, role, password)
VALUES ('Alethunder', 'good', 'user',
        '$2a$10$2X2ATtXkPTNUGGFM3rhQYOq9QVp77bjr9BmzIJh9YAkouhL81W9qi');

INSERT INTO clans (name, side) VALUES ('akatsuke', 'evil');
UPDATE eptituders SET clan_id = 1 WHERE id=2;

INSERT INTO events (name, description, date, status)
VALUES ('Avenger\'s creation',
        'Loki gains access to the Tesseract, Nick Fury creates Avengers to save Earth',
        DATE '2012-5-1',
        'finished');
INSERT INTO eptituders_events
VALUES (1, 1);