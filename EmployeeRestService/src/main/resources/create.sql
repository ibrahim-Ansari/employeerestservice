CREATE TABLE user_details (
	id INT NOT NULL,
	first_Name VARCHAR(20),
	last_name VARCHAR(20),
	lastmodifiedstamp TIMESTAMP DEFAULT 'CURRENT_TIMESTAMP' NOT NULL,
	PRIMARY KEY (id)
) ENGINE=InnoDB;
