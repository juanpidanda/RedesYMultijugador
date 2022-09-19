CREATE DATABASE myNewDataBase;
use myNewDataBase;

CREATE TABLE Player(
	PersonID int,
    Name varchar(255),
    Score int,
    Level int
);

CREATE TABLE Bots(
	BotID int,
    Name varchar(255),
    Level int,
    Difficult int,
    Score int
);

insert into Player(PersonID, Name, Score, Level) values (0, "Juanpi", 666, 20);
insert into Player(PersonID, Name, Score, Level) values (1, "Carlos", 356, 13);

insert into Bots(BotID, Name, Level, Difficult, Score) values (0, "Bot00", 0, 0, 0);
insert into Bots(BotID, Name, Level, Difficult, Score) values (1, "Bot01", 10, 2, 70);
insert into Bots(BotID, Name, Level, Difficult, Score) values (2, "Bot02", 7, 3, 300);
insert into Bots(BotID, Name, Level, Difficult, Score) values (3, "Bot03", 20, 1, 100);
insert into Bots(BotID, Name, Level, Difficult, Score) values (4, "Bot04", 35, 1, 750);
insert into Bots(BotID, Name, Level, Difficult, Score) values (5, "Bot05", 4, 3, 95);
insert into Bots(BotID, Name, Level, Difficult, Score) values (6, "Bot06", 14, 1, 2);
insert into Bots(BotID, Name, Level, Difficult, Score) values (7, "Bot07", 27, 2, 456);
insert into Bots(BotID, Name, Level, Difficult, Score) values (8, "Bot08", 37, 3, 4567);

UPDATE Player
SET Name = 'Shin On', Score = 3737
Where PersonID = 0;
DELETE FROM Player Where PersonID = 0;

UPDATE Bots
SET Name = 'Easy Bot', Level = 5, Difficult = 1
Where Score <= 100;
UPDATE Bots
SET Name = 'Mid Bot', Level = 17, Difficult = 2
Where Score > 100 && Score <= 300;
UPDATE Bots
SET Name = 'Hard Bot', Level = 30, Difficult = 3
Where Score > 300;

DELETE FROM Bots Where Score = 0;
DELETE FROM Bots Where Difficult = 1;
DELETE FROM Bots Where Difficult = 2;
DELETE FROM Bots Where Difficult = 3;

select * from Player;
select * from Bots;