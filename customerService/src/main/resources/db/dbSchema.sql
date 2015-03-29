drop table customer if exists;

create table customer (
  id int IDENTITY,
  firstname varchar(100) not null,
  lastname varchar(100) not null,
  email varchar(100) not null,
  phone varchar(100) not null unique);