CREATE table vehicle(
    id INTEGER PRIMARY KEY AUTOINCREMENT,
    plate TEXT NOT NULL,
    active INTEGER NOT NULL,
    category TEXT NOT NULL,
    age INTEGER DEFAULT 0
);

INSERT INTO vehicle(plate, active, category, age)
VALUES('ABC123',1,'CAR', 5);

INSERT INTO vehicle(plate, active, category, age)
VALUES('YYZ981',0,'CAR', 10);

INSERT INTO vehicle(plate, active, category, age)
VALUES('XXY111',1,'BIKE', 2);

INSERT INTO vehicle(plate, active, category, age)
VALUES('FDF100',1,'TRUCK', 8);

INSERT INTO vehicle(plate, active, category, age)
VALUES('GMP565',1,'CAR', 3);