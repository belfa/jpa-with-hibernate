/*create table person
(
    id integer not null,
    name varchar(255) not null,
    location varchar(255),
    birth_date timestamp,
    primary key (id)
);
  */

INSERT INTO person (id, name, location, birth_date)
VALUES
(10001,'Ranga', 'Hyderabad', sysdate()),
(10002,'James', 'New York', sysdate()),
(10003,'Pieter', 'Amsterdam', sysdate());