CREATE TABLE Car (
    id INT PRIMARY KEY,
    brand VARCHAR2(20),
    model VARCHAR2(10),
    price INT
);

ALTER TABLE Car 
    ADD (description CLOB, image BLOB);

INSERT INTO Car (
    id, brand, model, price
) VALUES (
    1, 'Volkswagen', 'Golf', 25000
);

INSERT INTO Car (
    id, brand, model, price
) VALUES (
    2, 'Renault', 'Clio', 18000
);

INSERT INTO Car (
    id, brand, model, price
) VALUES (
    3, 'Peugeot', '308', 23000
);
/

DROP TABLE Car;

CREATE OR REPLACE PROCEDURE get_car
    (in_model IN CAR.model%type, out_id OUT Car.id%type, out_brand OUT Car.brand%type, out_price OUT Car.price%type, out_description OUT Car.description%type, out_image OUT Car.image%type)
AS
    BEGIN
        SELECT id, brand, price, description, image
        INTO out_id, out_brand, out_price, out_description, out_image
        FROM Car
        WHERE model = in_model;
    END;

CREATE OR REPLACE FUNCTION get_car_brand
    (in_model IN CAR.model%type)
    RETURN CAR.brand%type
AS
    out_brand CAR.brand%type;
    BEGIN
        SELECT brand
        INTO out_brand
        FROM Car
        WHERE model = in_model;
        RETURN out_brand;
    END;