CREATE TABLE customer ( id INT PRIMARY KEY, name VARCHAR(255));
CREATE TABLE purchase_details ( id INT PRIMARY KEY,customer_id INT,trans_date DATE,amount DOUBLE,FOREIGN KEY (customer_id) REFERENCES customer(id));
