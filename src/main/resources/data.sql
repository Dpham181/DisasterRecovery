insert into end_user(email,password) values
("admin@gmail.com","$2a$10$xkpl86kt4nhVFoC8XYyq6egRF8WmHL4zp4af6P610wBYoqhW8mTci"),
("user@gmail.com","$2a$10$xkpl86kt4nhVFoC8XYyq6egRF8WmHL4zp4af6P610wBYoqhW8mTci");

insert into role(role) values("Admin"),("User");

insert into user_roles values
(1,1),
(2,2);

insert into job(code,description,rate,hours) values
("Plumber","Fix The Plumbing",65, 6),
("Carpenter","Wood Work",50, 4),
("Electrician","Electric Work",45, 4),
("General Labor","General Work",30, 8);


insert into machine(code,description,rent,hours) values
("HT-100","han Truck with 1000LBS",12,8),
("AT-800","Appliance",8, 4),
("AirComp","Air Compressor",10, 4),
("Power Tools","Power Tools",6, 8);

insert into time_card(code, contractor, hours, amount, status) values
("PA-120", "Mike Fernandez", 80, 2400, "Review"),
("Nj-080", "Robin Gaze", 120, 3000, "Review"),
("MA-340", "Adam Su", 100, 2800, "Finalized"),
("KC-140", "David Rowly", 140, 3200, "Finalized");

insert into timecard_machine values
(2,1), 
(3,2);

insert into timecard_job values
(1,1), 
(1,2);


