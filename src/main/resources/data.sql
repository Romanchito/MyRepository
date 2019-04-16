/*insert the data to the table of countries.*/
INSERT INTO Country (code, version, name)
VALUES (840, 0, 'США');
INSERT INTO Country (code, version, name)
VALUES (203, 0, 'Чехия');
INSERT INTO Country (code, version, name)
VALUES (643, 0, 'Россия');

/*insert the data to the table of documents types.*/
INSERT INTO Documents_types(code, version, name)
VALUES (21, 0, 'Паспорт гражданина Российской Федерации');
INSERT INTO Documents_types(code, version, name)
VALUES (10, 0, 'Паспорт иностранного гражданина');
INSERT INTO Documents_types(code, version, name)
VALUES (7, 0, 'Военный билет');

/*insert the data to the table of organisations.*/
INSERT INTO Organisation (id, version, name, full_name, kpp, inn, address, phone, is_active)
VALUES (NEXTVAL('ID_GENERATE_SEQ'), 0, 'Роскосмос', 'Роскосмос', '770201001', '7702388027',
        'Россия, г.Москва, ул.Щепкина, 42, стр.1', '+74956602323', true);
INSERT INTO Organisation (id, version, name, full_name, kpp, inn, address, phone, is_active)
VALUES (NEXTVAL('ID_GENERATE_SEQ'), 0, 'NASA', 'National Aeronautics and Space Administration', '770401001',
        '7717150958', 'USA, 300 E. Street SW, Suite 5R30 Washington, DC 20546', '+12023580001', true);
INSERT INTO Organisation (id, version, name, full_name, kpp, inn, address, phone, is_active)
VALUES (NEXTVAL('ID_GENERATE_SEQ'), 0, 'SpaceX', 'Space Exploration Technologies Corporation', '	775678099',
        '7000000007', 'USA Rocket Road Hawthorne, California', '+13103636000', true);

/*insert the data to the table of offices.*/
INSERT INTO Office (id, version, organisation_id, name, address, phone, is_active)
VALUES (NEXTVAL('ID_GENERATE_SEQ'), 0, SELECT id FROM Organisation WHERE name = 'Роскосмос', 'RK Moscow',
        'Россия , г.Москва, ул.Щепкина, 42', '+78005553535', true);
INSERT INTO Office (id, version, organisation_id, name, address, phone, is_active)
VALUES (NEXTVAL('ID_GENERATE_SEQ'), 0, SELECT id FROM Organisation WHERE name = 'NASA', 'NASA Washington Office',
        'USA, Street SW, Suite Z44 Washington, DC 04', '+18005553535', true);
INSERT INTO Office (id, version, organisation_id, name, address, phone, is_active)
VALUES (NEXTVAL('ID_GENERATE_SEQ'), 0, SELECT id FROM Organisation WHERE name = 'SpaceX', 'SpaceX in Texas',
        'USA, Royall Street , Huston, PP 12304', '+12023334545', true);

/*insert the data to the table of users.*/
INSERT INTO User (id, version, office_id, first_name, second_name, middle_name, user_position, phone, is_identified)
VALUES (NEXTVAL('ID_GENERATE_SEQ'), 0, SELECT id FROM Office WHERE name = 'RK Moscow', 'Dmitry', 'Rogozin',
        'Olegovich', 'general manager', '+79883456677', true);

INSERT INTO User (id, version, office_id, first_name, second_name, middle_name, user_position, phone, is_identified)
VALUES (NEXTVAL('ID_GENERATE_SEQ'), 0, SELECT id FROM Office WHERE name = 'RK Moscow', 'Andrey', 'Dorogin',
        'Alexandrovich', 'engineer', '+79773236677', true);

INSERT INTO User (id, version, office_id, first_name, second_name, user_position, phone, is_identified)
VALUES (NEXTVAL('ID_GENERATE_SEQ'), 0, SELECT id FROM Office WHERE name = 'NASA Washington Office', 'Elon', 'Mask',
        'general manager', '+78005553535', true);

INSERT INTO User (id, version, office_id, first_name, second_name, user_position, phone, is_identified)
VALUES (NEXTVAL('ID_GENERATE_SEQ'), 0, SELECT id FROM Office WHERE name = 'SpaceX in Texas', 'Cap', 'Price', 'engineer',
        '+19334256609', true);

/*insert the data to the table of documents.*/
INSERT INTO Document (id, version, document_type_id, doc_number, doc_date)
VALUES (SELECT id FROM User WHERE phone = '+79883456677', 0, 21, '123123123', '12-10-2015');
INSERT INTO Document (id, version, document_type_id, doc_number, doc_date)
VALUES (SELECT id FROM User WHERE phone = '+79773236677', 0, 10, '112222000', '13-10-2015');
INSERT INTO Document (id, version, document_type_id, doc_number, doc_date)
VALUES (SELECT id FROM User WHERE phone = '+78005553535', 0, 7, '000666454', '22-02-2018');
INSERT INTO Document (id, version, document_type_id, doc_number, doc_date)
VALUES (SELECT id FROM User WHERE phone = '+19334256609', 0, 7, '000333454', '21-03-2015');


/*insert the data to the user_country table.*/
INSERT INTO User_Country (user_id, country_id, version)
VALUES (SELECT id FROM User WHERE phone = '+79883456677', SELECT code FROM Country WHERE name = 'Россия', 0);
INSERT INTO User_Country (user_id, country_id, version)
VALUES (SELECT id FROM User WHERE phone = '+79773236677', SELECT code FROM Country WHERE name = 'Россия', 0);
INSERT INTO User_Country (user_id, country_id, version)
VALUES (SELECT id FROM User WHERE phone = '+78005553535', SELECT code FROM Country WHERE name = 'США', 0);
INSERT INTO User_Country (user_id, country_id, version)
VALUES (SELECT id FROM User WHERE phone = '+19334256609', SELECT code FROM Country WHERE name = 'Чехия', 0);
