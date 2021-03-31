create table materials
(
    ID int auto_increment
        primary key
);

create table food
(
    idMaterials   int           null,
    fruits        int default 0 not null,
    vegetables    int default 0 not null,
    meat          int default 0 not null,
    dairyProducts int default 0 not null,
    water         int default 0 not null,
    constraint generalizationFood
        foreign key (idMaterials) references materials (ID)
);

create table others
(
    idMaterials int           null,
    clothes     int default 0 not null,
    tools       int default 0 not null,
    houseHold   int default 0 not null,
    constraint generalizationOthers
        foreign key (idMaterials) references materials (ID)
);

create table sanitary
(
    idMaterials      int           null,
    masks            int default 0 not null,
    sanitarySolution int default 0 not null,
    gloves           int default 0 not null,
    pills            int default 0 not null,
    constraint generalizationSanitary
        foreign key (idMaterials) references materials (ID)
);

create table user
(
    ID        int auto_increment
        primary key,
    username  varchar(30)  not null,
    firstName varchar(20)  not null,
    lastName  varchar(20)  not null,
    adress    varchar(100) not null,
    telephone varchar(10)  not null,
    constraint User_telephone_uindex
        unique (telephone),
    constraint User_username_uindex
        unique (username)
);

create table helper
(
    idUser           int                  null,
    disponibility    tinyint(1) default 0 not null,
    distanceAccepted double               null,
    constraint generalizationHelper
        foreign key (idUser) references user (ID)
);

create table needer
(
    idUser     int                  null,
    isIsolated tinyint(1) default 0 not null,
    constraint generalizationNeeder
        foreign key (idUser) references user (ID)
);

create table matching
(
    idNeeder int         not null,
    idHelper int         not null,
    distance double      null,
    weather  varchar(15) not null,
    constraint refHelper
        foreign key (idHelper) references helper (idUser),
    constraint refNeeder
        foreign key (idNeeder) references needer (idUser)
);
