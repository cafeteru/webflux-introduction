CREATE TABLE IF NOT EXISTS product (
    id BIGINT PRIMARY KEY,
    name VARCHAR(255),
    price FLOAT
);

-- Insert data
INSERT INTO product (id, name, price)
SELECT 1, 'Product A', 10.99
WHERE NOT EXISTS (SELECT 1 FROM product WHERE id = 1);

INSERT INTO product (id, name, price)
SELECT 2, 'Product B', 20.50
WHERE NOT EXISTS (SELECT 1 FROM product WHERE id = 2);

INSERT INTO product (id, name, price)
SELECT 3, 'Product C', 15.75
WHERE NOT EXISTS (SELECT 1 FROM product WHERE id = 3);