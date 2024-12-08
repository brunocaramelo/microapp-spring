CREATE TABLE users (
    user_id INT PRIMARY KEY,
    username VARCHAR(255),
    first_name VARCHAR(255),
    last_name VARCHAR(255),
    city VARCHAR(100),
    state VARCHAR(100),
    email VARCHAR(255),
    phone VARCHAR(20),
    sports BOOLEAN,
    theatre BOOLEAN,
    concerts BOOLEAN,
    jazz BOOLEAN,
    classical BOOLEAN,
    opera BOOLEAN,
    rock BOOLEAN,
    vegas BOOLEAN,
    broadway BOOLEAN,
    musicals BOOLEAN
);

CREATE TABLE venues (
    venue_id INT PRIMARY KEY,
    venue_name VARCHAR(255),
    city VARCHAR(100),
    state VARCHAR(100),
    seating_capacity INT
);

CREATE TABLE categories (
    category_id INT PRIMARY KEY,
    category_group VARCHAR(100),
    category_name VARCHAR(255),
    category_description TEXT
);

CREATE TABLE dates (
    id INT PRIMARY KEY,
    calendar_date DATE,
    day INT,
    week INT,
    month INT,
    quarter INT,
    year INT,
    holiday_flag BOOLEAN
);

CREATE TABLE events (
    event_id INT PRIMARY KEY,
    venue_id INT,
    category_id INT,
    date_id INT,
    event_name VARCHAR(255),
    event_start_time DATETIME,
    FOREIGN KEY (venue_id) REFERENCES venues(venue_id),
    FOREIGN KEY (category_id) REFERENCES categories(category_id),
    FOREIGN KEY (date_id) REFERENCES dates(id)
);


CREATE TABLE listings (
    listing_id INT PRIMARY KEY,
    seller_id INT,
    event_id INT,
    date_id INT,
    number_of_tickets INT,
    price_per_ticket DECIMAL(10, 2),
    total_price DECIMAL(10, 2),
    listing_timestamp TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (seller_id) REFERENCES users(user_id),
    FOREIGN KEY (event_id) REFERENCES events(event_id),
    FOREIGN KEY (date_id) REFERENCES dates(id)
);

CREATE TABLE sales (
    sale_id INT PRIMARY KEY,
    listing_id INT,
    seller_id INT,
    buyer_id INT,
    event_id INT,
    date_id INT,
    quantity_sold INT,
    price_paid DECIMAL(10, 2),
    commission_amount DECIMAL(10, 2),
    sale_timestamp TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (listing_id) REFERENCES listings(listing_id),
    FOREIGN KEY (seller_id) REFERENCES users(user_id),
    FOREIGN KEY (buyer_id) REFERENCES users(user_id),
    FOREIGN KEY (event_id) REFERENCES events(event_id),
    FOREIGN KEY (date_id) REFERENCES dates(id)
);
