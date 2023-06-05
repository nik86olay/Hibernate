create schema person

    create table person.PERSONS
    (
        id           serial primary key,
        name         varchar(30),
        surname      varchar(30),
        age          int not null check ( age > 0 ),
        phone_number varchar(30),
        city_of_living varchar(30)
    );

-- create table person.ORDERS
-- (
--     id           serial primary key,
--     date         date not null,
--     customer_id  int  not null,
--     product_name varchar(30),
--     amount       int  not null check ( amount >= 0 ),
--
--     foreign key (customer_id) references person.PERSONS (id)
-- );

insert into person.PERSONS (name, surname, age, phone_number, city_of_living)
values ('AleXey', 'Pupkin', 2, '+999', 'Moscow'),
       ('Lex', 'Luter', 33, '+564', 'Podolsk'),
       ('Ivan', 'Karasev', 20, '', 'Ryzan'),
       ('Toniy', 'Okroshkina', 45, '+123', 'Kolomna'),
       ('Alexey', 'Vich', 40, '+', 'Dubna'),
       ('alexey', 'Valtarenovich', 77, '+666', 'Moscow');