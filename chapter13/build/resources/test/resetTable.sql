drop table users;
CREATE TABLE users (
  id INT AUTO_INCREMENT,
  name VARCHAR(50) NOT NULL,
  password VARCHAR(50) NOT NULL,
  email VARCHAR(50) NOT NULL,
  PRIMARY KEY(id)

);