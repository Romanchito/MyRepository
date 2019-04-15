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

CREATE TABLE IF NOT EXISTS Country
(
    id           INTEGER     NOT NULL PRIMARY KEY AUTO_INCREMENT,
    version      INTEGER     NOT NULL,
    country_name VARCHAR(50) NOT NULL,
    code         VARCHAR(20) NOT NULL,

);

CREATE TABLE IF NOT EXISTS Doc_Type
(
    id            INTEGER     NOT NULL PRIMARY KEY AUTO_INCREMENT,
    version       INTEGER     NOT NULL,
    doc_type_name VARCHAR(50),
    code          VARCHAR(20) NOT NULL
);

CREATE TABLE IF NOT EXISTS Document
(
    id               INTEGER NOT NULL PRIMARY KEY AUTO_INCREMENT,
    document_type_id INTEGER,
    version          INTEGER NOT NULL,
    doc_number       VARCHAR(30),
    doc_date         VARCHAR(20),

    FOREIGN KEY (document_type_id) REFERENCES Doc_Type (id)
);
CREATE INDEX IX_Document_Doc_Type ON Document (document_type_id);

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

CREATE TABLE IF NOT EXISTS User_Country
(
    user_id    INTEGER NOT NULL,
    country_id INTEGER NOT NULL,
    PRIMARY KEY (user_id, country_id),
    FOREIGN KEY (user_id) REFERENCES User (id),
    FOREIGN KEY (country_id) REFERENCES Country (id)
);
CREATE INDEX IX_Country_User_Id ON User_Country (country_id, user_id);



