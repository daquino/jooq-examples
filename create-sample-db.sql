create table movie(
  id           INTEGER,
  title        TEXT,
  release_date DATE,
  gross        NUMERIC(9),
  primary key (id)
);

create table actor(
  id         INTEGER,
  first_name TEXT,
  last_name  TEXT,
  primary key (id)
);

create table cast_member(
  movie_id       INTEGER references movie(id),
  actor_id       INTEGER references actor(id),
  character_name TEXT,
  primary key (actor_id, movie_id)
);

insert into movie(id, title, release_date, gross) values (1, 'Jurassic World', '06/12/2015', 208806270);
insert into movie(id, title, release_date, gross) values (2, 'The Avengers', '05/04/2012', 207438708);
insert into movie(id, title, release_date, gross) values (3, 'Avengers: Age of Ultron', '05/01/2015', 191271109);
insert into movie(id, title, release_date, gross) values (4, 'Iron Man 3', '05/03/2013', 174144585);
insert into movie(id, title, release_date, gross) values (5, 'Harry Potter and the Deathly Hallows: Part II', '07/15/2011', 169189427);
insert into movie(id, title, release_date, gross) values (6, 'The Dark Knight Rises', '07/20/2012', 160887295);
insert into movie(id, title, release_date, gross) values (7, 'The Dark Knight', '07/18/2008', 158411483);
insert into movie(id, title, release_date, gross) values (8, 'The Hunger Games: Catching Fire', '11/22/2013', 158074286);
insert into movie(id, title, release_date, gross) values (9, 'The Hunger Games', '03/23/2012', 152535747);
insert into movie(id, title, release_date, gross) values (10, 'Spider Man 3', '05/04/2007', 151116516);

insert into actor(id, first_name, last_name) values (1, 'Chris', 'Pratt');
insert into actor(id, first_name, last_name) values (2, 'Bryce', 'Howard');
insert into actor(id, first_name, last_name) values (3, 'Robert', 'Downey Jr.');
insert into actor(id, first_name, last_name) values (4, 'Scarlett', ' Johansson');
insert into actor(id, first_name, last_name) values (5, 'Daniel', 'Radcliffe');
insert into actor(id, first_name, last_name) values (6, 'Emma', 'Watson');
insert into actor(id, first_name, last_name) values (7, 'Christian', 'Bale');
insert into actor(id, first_name, last_name) values (8, 'Michael', 'Caine');
insert into actor(id, first_name, last_name) values (9, 'Morgan', 'Freeman');
insert into actor(id, first_name, last_name) values (10, 'Jennifer', 'Lawrence');
insert into actor(id, first_name, last_name) values (11, 'Woody', 'Harrelson');
insert into actor(id, first_name, last_name) values (12, 'Tobey', 'Macguire');
insert into actor(id, first_name, last_name) values (13, 'Kirsten', 'Dunst');

insert into cast_member(movie_id, actor_id, character_name)
  values(1, 1, 'Owen Grady');
insert into cast_member(movie_id, actor_id, character_name)
  values(1, 2, 'Claire Dearing');
insert into cast_member(movie_id, actor_id, character_name)
  values(2, 3, 'Tony Stark');
insert into cast_member(movie_id, actor_id, character_name)
  values(2, 4, 'Black Widow');
insert into cast_member(movie_id, actor_id, character_name)
  values(3, 3, 'Tony Stark');
insert into cast_member(movie_id, actor_id, character_name)
  values(3, 4, 'Black Widow');
insert into cast_member(movie_id, actor_id, character_name)
  values(4, 3, 'Tony Stark');
insert into cast_member(movie_id, actor_id, character_name)
  values(5, 5, 'Harry Potter');
insert into cast_member(movie_id, actor_id, character_name)
  values(5, 6, 'Hermione Granger');
insert into cast_member(movie_id, actor_id, character_name)
  values(6, 7, 'Bruce Wayne');
insert into cast_member(movie_id, actor_id, character_name)
  values(6, 8, 'Alfred Pennyworth');
insert into cast_member(movie_id, actor_id, character_name)
  values(6, 9, 'Lucius Fox');
insert into cast_member(movie_id, actor_id, character_name)
  values(7, 7, 'Bruce Wayne');
insert into cast_member(movie_id, actor_id, character_name)
  values(7, 8, 'Alfred Pennyworth');
insert into cast_member(movie_id, actor_id, character_name)
  values(7, 9, 'Lucius Fox');
insert into cast_member(movie_id, actor_id, character_name)
  values(8, 10, 'Katniss Everdeen');
insert into cast_member(movie_id, actor_id, character_name)
  values(8, 11, 'Haymitch Abernathy');
insert into cast_member(movie_id, actor_id, character_name)
  values(9, 10, 'Katniss Everdeen');
insert into cast_member(movie_id, actor_id, character_name)
  values(9, 11, 'Haymitch Abernathy');
insert into cast_member(movie_id, actor_id, character_name)
  values(10, 12, 'Peter Parker');
insert into cast_member(movie_id, actor_id, character_name)
  values(10, 13, 'Mary Jane Watson');
insert into cast_member(movie_id, actor_id, character_name)
  values(10, 2, 'Gwen Stacy');
