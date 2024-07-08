CREATE TABLE tbl_jersey (
    id BIGSERIAL PRIMARY KEY,
    team VARCHAR(255) NOT NULL,
    name VARCHAR(255) UNIQUE,
    number INT,
    price FLOAT,
    picture BYTEA
);
