create table if not exists orders (
    id serial primary key not null,
    customer_id int,
    status varchar(50)
);