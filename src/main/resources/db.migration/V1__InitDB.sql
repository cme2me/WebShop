create table if not exists products p
(
    id
    uuid
    not
    null,
    p
    .
    name
    varchar
(
    255
), double price, primary key
(
    id
));

create table if not exists users
(
    id
    uuid
    not
    null,
    login
    varchar
(
    255
), password varchar/* change to byte type*/
(
    225
), role_type varchar
(
    225
), constraint fk_roles foreign key
(
    id
) references roles
(
    role_type
)
    );

create table if not exists roles
(
    primary key
(
    id
), role_type varchar
(
    225
)
    );

create table if not exists basket
(
    id
    uuid
    not
    null,
    product
    varchar
(
    225
), constraint product_id foreign key (id) references products p (p.name)
    );


