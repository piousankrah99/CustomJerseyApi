CREATE TABLE tbl_jersey (
    id UUID PRIMARY KEY,
    team VARCHAR(255) NOT NULL,
    name VARCHAR(255) UNIQUE,
    number INT,
    price FLOAT,
    jersey_type VARCHAR(255),
    picture BYTEA
);
