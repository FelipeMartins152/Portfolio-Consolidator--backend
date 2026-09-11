DROP DATABASE IF EXISTS portfolio_consolidator_db;

CREATE DATABASE portfolio_consolidator_db;

USE portfolio_consolidator_db;

CREATE TABLE users(
	user_id BIGINT AUTO_INCREMENT NOT NULL,
    full_name VARCHAR(100) NOT NULL,
    email VARCHAR(100) NOT NULL UNIQUE,
    phone VARCHAR(30) NOT NULL,
    password VARCHAR(255) NOT NULL,
    birth_date DATE NOT NULL,
    is_active BOOLEAN NOT NULL,
    PRIMARY KEY (user_id));
    
CREATE TABLE goals(
	goal_id BIGINT AUTO_INCREMENT NOT NULL,
    title VARCHAR(200) NOT NULL,
    description VARCHAR(200),
    target_amount DECIMAL(15,2) NOT NULL,
    is_active BOOLEAN NOT NULL,
    user_id BIGINT NOT NULL,
    PRIMARY KEY (goal_id),
    FOREIGN KEY (user_id) REFERENCES users(user_id));
    
CREATE TABLE assets(
	asset_id BIGINT AUTO_INCREMENT NOT NULL,
    name VARCHAR(200) NOT NULL,
    type VARCHAR(100) NOT NULL,
    current_price DECIMAL(15,2) NOT NULL,
    ticker VARCHAR(20) NOT NULL,
    is_active BOOLEAN NOT NULL,
    PRIMARY KEY (asset_id));
    
CREATE TABLE transactions(
	transaction_id BIGINT AUTO_INCREMENT NOT NULL,
    type VARCHAR(100) NOT NULL,
    quantity DECIMAL(15,8) NOT NULL,
    unit_price DECIMAL(15,2) NOT NULL,
    transaction_date DATE NOT NULL,
    is_active BOOLEAN NOT NULL,
    user_id BIGINT NOT NULL,
    asset_id BIGINT NOT NULL,
    PRIMARY KEY (transaction_id),
    FOREIGN KEY (user_id) REFERENCES users(user_id),
    FOREIGN KEY (asset_id) REFERENCES assets(asset_id));
    
CREATE TABLE price_histories(
	history_id BIGINT AUTO_INCREMENT NOT NULL,
    closing_price DECIMAL(15,2) NOT NULL,
    quote_date DATE NOT NULL,
    asset_id BIGINT NOT NULL,
    PRIMARY KEY (history_id),
    FOREIGN KEY (asset_id) REFERENCES assets(asset_id));