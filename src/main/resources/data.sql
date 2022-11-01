
insert into Role(role) values("Admin");
insert into Role(role) values("User");

insert into user_roles values
(1,1),
(2,2);

insert into job(description,job_code,hourly_rate,max_hours_per_day) values
("Plumber","Fix The Plumbing",65, 6),
("Carpenter","Wood Work",50, 4),
("Electrician","Electric Work",45, 4),
("General Labor","General Work",30, 8);



insert into machine(machine_code,description,hourly_rent,max_hours_per_day) values
("HT-100","han Truck with 1000LBS",12,8),
("AT-800","Appliance",8, 4),
("AirComp","Air Compressor",10, 4),
("Power Tools","Power Tools",6, 8);