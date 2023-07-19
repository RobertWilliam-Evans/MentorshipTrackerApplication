create table ROLE(
                     id UUID PRIMARY KEY NOT NULL ,
                     name VARCHAR(255) NOT NULL ,
                     description VARCHAR(255) NOT NULL
);

create table PERMISSION(
                           id UUID PRIMARY KEY NOT NULL ,
                           name VARCHAR(255) NOT NULL,
                           description VARCHAR(255) NOT NULL

);

create table ROLE_PERMISSION(
        role_id UUID NOT NULL,
        permission_id UUID NOT NULL,
        PRIMARY KEY (role_id, permission_id),
        FOREIGN KEY (role_id) REFERENCES ROLE (id),
        FOREIGN KEY (permission_id) REFERENCES PERMISSION (id)
);

create table USER_DETAILS(
         id UUID PRIMARY KEY NOT NULL,
         username VARCHAR(255) NOT NULL,
         firstname VARCHAR(255) NOT NULL,
         email VARCHAR(255) NOT NULL,
         role_id UUID,
         password VARCHAR(255) NOT NULL,
         FOREIGN KEY (role_id) REFERENCES ROLE (id)
)