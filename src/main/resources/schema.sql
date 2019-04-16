CREATE TABLE IF NOT EXISTS Organisation
(
    id        INTEGER      NOT NULL COMMENT 'Уникальный идентификатор' PRIMARY KEY AUTO_INCREMENT,
    version   INTEGER      NOT NULL COMMENT 'Служебное поле hibernate',
    name      VARCHAR(50)  NOT NULL COMMENT 'Наименование организации',
    full_name VARCHAR(100) NOT NULL COMMENT 'Полное наименование организации',
    kpp       VARCHAR(20)  NOT NULL COMMENT 'КПП',
    inn       VARCHAR(20)  NOT NULL COMMENT 'ИНН',
    address   VARCHAR(60)  NOT NULL COMMENT 'Адрес организации',
    phone     VARCHAR(20) COMMENT 'Телефон организации',
    is_active BOOLEAN COMMENT 'Активность организации'
);
COMMENT ON TABLE Organisation IS 'Данные организаций';


CREATE TABLE IF NOT EXISTS Office
(
    id              INTEGER     NOT NULL COMMENT 'Уникальный идентификатор' PRIMARY KEY AUTO_INCREMENT,
    version         INTEGER     NOT NULL COMMENT 'Служебное поле hibernate',
    organisation_id INTEGER COMMENT 'Внешний ключ для связи с таблицей Organisation',
    name            VARCHAR(50) NOT NULL COMMENT 'Наименование офиса',
    address         VARCHAR(50) NOT NULL COMMENT 'Адрес офиса',
    phone           VARCHAR(20) COMMENT 'Телефон офиса',
    is_active       BOOLEAN COMMENT 'Активность организации',
    FOREIGN KEY (organisation_id) REFERENCES Organisation (id)
);
CREATE INDEX IX_Office_Organisation_Id ON Office (organisation_id);
COMMENT ON TABLE Office IS 'Данные офисов';


CREATE TABLE IF NOT EXISTS Country
(
    code    INTEGER     NOT NULL COMMENT 'ISO - Код страны , уникальный идентификатор' PRIMARY KEY,
    version INTEGER     NOT NULL COMMENT 'Служебное поле hibernate',
    name    VARCHAR(50) NOT NULL COMMENT 'Наименование страны',
);
COMMENT ON TABLE Country IS 'Данные стран';


CREATE TABLE IF NOT EXISTS Documents_types
(
    code    INTEGER     NOT NULL COMMENT 'Код типа документов, уникальный идентификатор' PRIMARY KEY,
    version INTEGER     NOT NULL COMMENT 'Служебное поле hibernate',
    name    VARCHAR(50) NOT NULL COMMENT 'Наименование типа документов'
);
COMMENT ON TABLE Documents_types IS 'Данные типов документов';


CREATE TABLE IF NOT EXISTS User
(
    id            INTEGER     NOT NULL COMMENT 'Уникальный идентификатор' PRIMARY KEY AUTO_INCREMENT,
    version       INTEGER     NOT NULL COMMENT 'Служебное поле hibernate',
    office_id     INTEGER COMMENT 'Внешний ключ для связи с таблицей Office',
    first_name    VARCHAR(50) NOT NULL COMMENT 'Имя пользователя',
    second_name   VARCHAR(50) NOT NULL COMMENT 'Фамилия пользователя',
    middle_name   VARCHAR(50) COMMENT 'Отчество пользователя',
    user_position VARCHAR(20) NOT NULL COMMENT 'Должность пользователя',
    phone         VARCHAR(20) NOT NULL COMMENT 'Телефон пользователя',
    is_identified BOOLEAN COMMENT 'Идентификация пользователя',

    FOREIGN KEY (office_id) REFERENCES Office (id)
);
CREATE INDEX IX_User_Office_Id ON User (office_id);
COMMENT ON TABLE User IS 'Данные пользователей';

CREATE TABLE IF NOT EXISTS Document
(
    id               INTEGER NOT NULL COMMENT 'Уникальный идентификатор' PRIMARY KEY AUTO_INCREMENT,
    document_type_id INTEGER COMMENT 'Внешний ключ для связи с таблицей Documents_types',
    version          INTEGER NOT NULL COMMENT 'Служебное поле hibernate',
    doc_number       VARCHAR(30) COMMENT 'Номер документа',
    doc_date         VARCHAR(20) COMMENT 'Дата документа',

    FOREIGN KEY (document_type_id) REFERENCES Documents_types (code),
    FOREIGN KEY (id) REFERENCES User (id)
);
CREATE INDEX IX_Document_Doc_Type ON Document (document_type_id);
COMMENT ON TABLE Document IS 'Данные документов';

CREATE TABLE IF NOT EXISTS User_Country
(
    user_id    INTEGER NOT NULL COMMENT 'Уникальный идентификатор пользователя',
    country_id INTEGER NOT NULL COMMENT 'Уникальный идентификатор страны',
    version    INTEGER NOT NULL COMMENT 'Служебное поле hibernate',
    PRIMARY KEY (user_id, country_id),
    FOREIGN KEY (user_id) REFERENCES User (id),
    FOREIGN KEY (country_id) REFERENCES Country (code)
);
CREATE INDEX IX_Country_User_Id ON User_Country (country_id, user_id);
COMMENT ON TABLE User_Country IS 'join-таблица для связи страны и пользователя';


CREATE SEQUENCE ID_GENERATE_SEQ START WITH 1 INCREMENT BY 1;