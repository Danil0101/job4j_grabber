create table if not exists post (
    id serial primary key,
    name text,
    text text,
    link varchar(500) unique,
    created timestamp
);