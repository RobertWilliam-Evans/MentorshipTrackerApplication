create table ADVISOR(
            user_id UUID PRIMARY KEY REFERENCES USER_DETAILS (id),
            country VARCHAR(255),
            city VARCHAR(255),
            birth_date DATE,
            FOREIGN KEY (user_id) REFERENCES USER_DETAILS (id)

);

create table ADVISEE(
        user_id UUID PRIMARY KEY REFERENCES USER_DETAILS (id ),
        country VARCHAR(255),
        city VARCHAR(255),
        birth_date DATE,
        advisor_id  UUID REFERENCES ADVISOR (user_id),
        FOREIGN KEY (user_id) REFERENCES USER_DETAILS (id),
        FOREIGN KEY (advisor_id) REFERENCES ADVISOR (user_id)

);

