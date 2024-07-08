CREATE EXTENSION IF NOT EXISTS "uuid-ossp";


CREATE TABLE tbl_jersey (
    id UUID PRIMARY KEY DEFAULT uuid_generate_v4(),
    team VARCHAR(255) NOT NULL,
    name VARCHAR(255) UNIQUE,
    number INT,
    price FLOAT,
    jersey_type VARCHAR(255),
    picture BYTEA
);
