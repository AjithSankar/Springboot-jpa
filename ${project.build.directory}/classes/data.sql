create table employee(
id int AUTO_INCREMENT PRIMARY KEY,
firstname varchar(100) not null,
lastname varchar(100) not null,
email varchar(100) not null
);

insert into employee(firstname,lastname,email)
values
('Ajith','Sankar','ajith.sankar@gmail.com'),
('Ravi','Kumar','ravi.kumar@gmail.com'),
('kavinesh','kavin','Kavinesh@gmail.com');

