create table if not exists post (
    id serial primary key,
    title text,
    link varchar(500) unique,
    description text,
    created timestamp
);