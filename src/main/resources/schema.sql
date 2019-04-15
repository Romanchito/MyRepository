/*This table contains the parameters of organizations.*/
CREATE TABLE IF NOT EXISTS Organisation
(
    id                     INTEGER      NOT NULL PRIMARY KEY AUTO_INCREMENT,
    version                INTEGER      NOT NULL,
    organisation_name      VARCHAR(50)  NOT NULL,
    organisation_full_name VARCHAR(100) NOT NULL,
    kpp                    VARCHAR(20)  NOT NULL,
    inn                    VARCHAR(20)  NOT NULL,
    address                VARCHAR(60)  NOT NULL,
    phone                  VARCHAR(20),
    is_active              BOOLEAN
);

/*This table contains the parameters of offices.This table has many-to-one relationship with table of organisations*/
CREATE TABLE IF NOT EXISTS Office
(
    id              INTEGER     NOT NULL PRIMARY KEY AUTO_INCREMENT,
    version         INTEGER     NOT NULL,
    organisation_id INTEGER,
    office_name     VARCHAR(50) NOT NULL,
    address         VARCHAR(50) NOT NULL,
    phone           VARCHAR(20),
    is_active       BOOLEAN,
    FOREIGN KEY (organisation_id) REFERENCES Organisation (id)
);
CREATE INDEX IX_Office_Organisation_Id ON Office (organisation_id);

/*This table contains the parameters of countries.This table has many-to-many relationship with table of users
by table User_Country*/
CREATE TABLE IF NOT EXISTS Country
(
    id           INTEGER     NOT NULL PRIMARY KEY AUTO_INCREMENT,
    version      INTEGER     NOT NULL,
    country_name VARCHAR(50) NOT NULL,
    code         VARCHAR(20) NOT NULL,

);

/*This table contains the parameters of documents types.*/
CREATE TABLE IF NOT EXISTS Documents_types
(
    id            INTEGER     NOT NULL PRIMARY KEY AUTO_INCREMENT,
    version       INTEGER     NOT NULL,
    doc_type_name VARCHAR(50),
    code          VARCHAR(20) NOT NULL
);

/*This table contains the parameters of documents.This table has many-to-one relationship with table of documents types*/
CREATE TABLE IF NOT EXISTS Document
(
    id               INTEGER NOT NULL PRIMARY KEY AUTO_INCREMENT,
    document_type_id INTEGER,
    version          INTEGER NOT NULL,
    doc_number       VARCHAR(30),
    doc_date         VARCHAR(20),

    FOREIGN KEY (document_type_id) REFERENCES Documents_types (id)
);
CREATE INDEX IX_Document_Doc_Type ON Document (document_type_id);

/*This table contains the parameters of users.This table has many-to-one relationship with table of offices,
has one-to-one relationship with table of documents and has many-to-many with table of countries by table User_Country*/
CREATE TABLE IF NOT EXISTS User
(
    id            INTEGER     NOT NULL PRIMARY KEY AUTO_INCREMENT,
    version       INTEGER     NOT NULL,
    office_id     INTEGER,
    first_name    VARCHAR(50) NOT NULL,
    second_name   VARCHAR(50),
    middle_name   VARCHAR(50),
    user_position VARCHAR(20) NOT NULL,
    phone         VARCHAR(20) NOT NULL,
    is_identified BOOLEAN,

    FOREIGN KEY (office_id) REFERENCES Office (id),
    FOREIGN KEY (id) REFERENCES Document (id)

);
CREATE INDEX IX_User_Office_Id ON User (office_id);

/*This table for many-to-many relationship of countries and users.*/
CREATE TABLE IF NOT EXISTS User_Country
(
    user_id    INTEGER NOT NULL,
    country_id INTEGER NOT NULL,
    PRIMARY KEY (user_id, country_id),
    FOREIGN KEY (user_id) REFERENCES User (id),
    FOREIGN KEY (country_id) REFERENCES Country (id)
);
CREATE INDEX IX_Country_User_Id ON User_Country (country_id, user_id);



