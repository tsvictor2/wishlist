create table WISH
(
    ID          NUMBER GENERATED ALWAYS AS IDENTITY PRIMARY KEY            NOT NULL,
    TITLE       VARCHAR2(200)                                              NOT NULL,
    DESCRIPTION VARCHAR2(4000)                                             NOT NULL,
    PRODUCT     VARCHAR2(30)                                               NOT NULL,
    STATUS      VARCHAR2(30)                                               NOT NULL,
    CREATED     TIMESTAMP WITH TIME ZONE DEFAULT ON NULL CURRENT_TIMESTAMP NOT NULL
);

create table LIKE_
(
    EMAIL   VARCHAR2(100) PRIMARY KEY                                  NOT NULL,
    WISH_ID NUMBER                                                     NOT NULL,
    CREATED TIMESTAMP WITH TIME ZONE DEFAULT ON NULL CURRENT_TIMESTAMP NOT NULL
);

create table SUBSCRIPTION
(
    EMAIL   VARCHAR2(100) PRIMARY KEY                                  NOT NULL,
    WISH_ID NUMBER                                                     NOT NULL,
    CREATED TIMESTAMP WITH TIME ZONE DEFAULT ON NULL CURRENT_TIMESTAMP NOT NULL
);
