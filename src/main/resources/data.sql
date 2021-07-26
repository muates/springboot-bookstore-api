INSERT IGNORE INTO genders (id, gender) VALUES (1 , 'Male'), (2, 'Female'), (3, 'no gender');

INSERT IGNORE INTO countries (id, country_name) VALUES (1, 'Turkey'), (2, 'Germany');

INSERT IGNORE INTO cities (id, city_name, country_id) VALUES (1, 'Istanbul', 1), (2, 'Ankara', 1), (3, 'Berlin', 2);

INSERT IGNORE INTO publishers (id, name) VALUES (1, 'Pegasus'), (2, 'Parodi'), (3, 'Beyaz Balina'), (4, 'Altın Kitapları');

INSERT IGNORE INTO authors (id, first_name, last_name) VALUES (1, 'Stephen', 'King'), (2, 'John Ronald Reuel', 'Tolkien');

INSERT IGNORE INTO books (id, cost, isbn, title, author_id, publisher_id) VALUE (1, 15 , 2315, 'It', 1, 2);
INSERT IGNORE INTO books (id, cost, isbn, title, author_id, publisher_id) VALUE (2, 8, 1245, 'Medium', 1, 1);
INSERT IGNORE INTO books (id, cost, isbn, title, author_id, publisher_id) VALUE (3, 12, 2415, 'Dark Tower: Swordsman', 1, 4);
INSERT IGNORE INTO books (id, cost, isbn, title, author_id, publisher_id) VALUE (4, 5, 9456, 'Fear Network', 1, 2);
INSERT IGNORE INTO books (id, cost, isbn, title, author_id, publisher_id) VALUE (5, 25, 7314, 'Lord of Rings', 2, 1);
INSERT IGNORE INTO books (id, cost, isbn, title, author_id, publisher_id) VALUE (6, 11, 8410, 'Hobbit', 2, 3);
INSERT IGNORE INTO books (id, cost, isbn, title, author_id, publisher_id) VALUE (7, 18, 6402, 'Silmarillion', 2 ,2);
