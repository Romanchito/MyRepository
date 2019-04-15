/*insert the data to the table of countries.*/
INSERT INTO Country (id, version, country_name, code)
VALUES (1, 0, 'США', '840');
INSERT INTO Country (id, version, country_name, code)
VALUES (2, 0, 'Чехия', '203');
INSERT INTO Country (id, version, country_name, code)
VALUES (3, 0, 'Россия', '643');

/*insert the data to the table of documents types.*/
INSERT INTO Documents_types(id, version, doc_type_name, code)
VALUES (1, 0, 'Паспорт гражданина Российской Федерации', '21');
INSERT INTO Documents_types(id, version, doc_type_name, code)
VALUES (2, 0, 'Паспорт иностранного гражданина', '10');
INSERT INTO Documents_types(id, version, doc_type_name, code)
VALUES (3, 0, 'Военный билет', '07');

/*insert the data to the table of documents.*/
INSERT INTO Document (id, version, document_type_id, doc_number, doc_date)
VALUES (1, 0, 1, '123123123', '12-10-2015');
INSERT INTO Document (id, version, document_type_id, doc_number, doc_date)
VALUES (2, 0, 2, '112222000', '13-10-2015');
INSERT INTO Document (id, version, document_type_id, doc_number, doc_date)
VALUES (3, 0, 3, '000666454', '22-02-2018');
INSERT INTO Document (id, version, document_type_id, doc_number, doc_date)
VALUES (4, 0, 2, '000333454', '21-03-2015');

/*insert the data to the table of organisations.*/
INSERT INTO Organisation (id, version, organisation_name, organisation_full_name, kpp, inn, address, phone, is_active)
VALUES (1, 0, 'Роскосмос', 'Роскосмос', '770201001', '7702388027', 'Россия, г.Москва, ул.Щепкина, 42, стр.1',
        '+74956602323', true);
INSERT INTO Organisation (id, version, organisation_name, organisation_full_name, kpp, inn, address, phone, is_active)
VALUES (2, 0, 'NASA', 'National Aeronautics and Space Administration', '770401001', '7717150958',
        'USA, 300 E. Street SW, Suite 5R30 Washington, DC 20546', '+12023580001', true);
INSERT INTO Organisation (id, version, organisation_name, organisation_full_name, kpp, inn, address, phone, is_active)
VALUES (3, 0, 'SpaceX', 'Space Exploration Technologies Corporation', '	775678099', '7000000007',
        'USA Rocket Road Hawthorne, California', '+13103636000', true);

/*insert the data to the table of offices.*/
INSERT INTO Office (id, version, organisation_id, office_name, address, phone, is_active)
VALUES (1, 0, 1, 'RK Moscow', 'Россия , г.Москва, ул.Щепкина, 42', '+78005553535', true);
INSERT INTO Office (id, version, organisation_id, office_name, address, phone, is_active)
VALUES (2, 0, 1, 'NASA Washington Office', 'USA, Street SW, Suite Z44 Washington, DC 04', '+18005553535', true);
INSERT INTO Office (id, version, organisation_id, office_name, address, phone, is_active)
VALUES (3, 0, 1, 'SpaceX in Texas', 'USA, Royall Street , Huston, PP 12304', '+12023334545', true);

/*insert the data to the table of users.*/
INSERT INTO User (id, version, office_id, first_name, second_name, middle_name,
                  user_position, phone, is_identified)
VALUES (1, 0, 1, 'Dmitry', 'Rogozin', 'Olegovich', 'general manager', '+79883456677', true);

INSERT INTO User (id, version, office_id, first_name, second_name, middle_name,
                  user_position, phone, is_identified)
VALUES (2, 0, 2, 'Andrey', 'Dorogin', 'Alexandrovich', 'engineer', '+79773236677', true);

INSERT INTO User (id, version, office_id, first_name, second_name, user_position,
                  phone, is_identified)
VALUES (3, 0, 3, 'Elon', 'Mask', 'general manager', '+79883456677', true);

INSERT INTO User (id, version, office_id, first_name, second_name, user_position,
                  phone, is_identified)
VALUES (4, 0, 3, 'Cap', 'Price', 'engineer', '+19334256609', true);


/*insert the data to the user_country table.*/
INSERT INTO User_Country (user_id, country_id)
VALUES (1, 2);
INSERT INTO User_Country (user_id, country_id)
VALUES (2, 1);
INSERT INTO User_Country (user_id, country_id)
VALUES (3, 3);
INSERT INTO User_Country (user_id, country_id)
VALUES (4, 1);
