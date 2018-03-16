insert into eptituders (name, side)
VALUES ('Bloodyslav', 'evil');
insert into eptituders (name, side)
VALUES ('Danuke', 'evil');
insert into eptituders (name, side)
VALUES ('Alethunder', 'good');

INSERT INTO clans (name, side) VALUES ('akatsuke', 'evil');
UPDATE eptituders SET clan_id = 1 WHERE id=2;

INSERT INTO events (name, description, date, status)
VALUES ('Avenger\'s creation',
        'Loki gains access to the Tesseract, Nick Fury creates Avengers to save Earth',
        DATE '2012-5-1',
        'finished');
INSERT INTO eptituders_events
VALUES (1, 1);