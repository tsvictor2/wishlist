create table WISH
(
    ID          INTEGER GENERATED ALWAYS AS IDENTITY PRIMARY KEY NOT NULL,
    TITLE       VARCHAR(200)                                     NOT NULL,
    DESCRIPTION VARCHAR(4000)                                    NOT NULL,
    PRODUCT     VARCHAR(30)                                      NOT NULL,
    STATUS      VARCHAR(30)                                      NOT NULL,
    CREATED     TIMESTAMP WITH TIME ZONE DEFAULT NOW()           NOT NULL
);

create table LIKE_
(
    EMAIL   VARCHAR(100) PRIMARY KEY               NOT NULL,
    WISH_ID INTEGER                                NOT NULL,
    CREATED TIMESTAMP WITH TIME ZONE DEFAULT NOW() NOT NULL
);

create table SUBSCRIPTION
(
    EMAIL   VARCHAR(100) PRIMARY KEY               NOT NULL,
    WISH_ID INTEGER                                NOT NULL,
    CREATED TIMESTAMP WITH TIME ZONE DEFAULT NOW() NOT NULL
);
