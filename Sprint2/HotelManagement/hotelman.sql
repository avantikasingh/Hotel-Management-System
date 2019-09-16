drop table room;
drop table hotel;
drop table booking;
drop table loggedin_user;



CREATE TABLE IF NOT EXISTS loggedin_user
	(
		user_id bigint AUTO_INCREMENT,
		user_name varchar(50) NOT NULL ,
		email_id varchar(50) NOT NULL ,
		dob datetime,
		user_mobile bigint,
		gender VARCHAR(1),
		aadhar_number varchar(12),
		delete_flag bit,
		CONSTRAINT PRIMARY KEY(user_id)
	);
CREATE TABLE IF NOT EXISTS city
	(
		city_id bigint AUTO_INCREMENT,
		city_name varchar(50) NOT NULL ,
		delete_flag bit,
		CONSTRAINT PRIMARY KEY(city_id)
	);
	

	
CREATE TABLE IF NOT EXISTS booking 
	(
		booking_id bigint PRIMARY KEY AUTO_INCREMENT,
		booking_status varchar(50),
		booking_date date,
		checkin_date date,
		checkout_date date,
		booking_cost double, 
		hotel_id bigint,
		user_id bigint,
		delete_flag bit,
		CONSTRAINT
		FOREIGN KEY (hotel_id) REFERENCES hotel(hotel_id),
		FOREIGN KEY (user_id) REFERENCES loggedin_user(user_id)
	);


	
	
	CREATE TABLE IF NOT EXISTS hotel 
	(
		
		hotel_id bigint PRIMARY KEY AUTO_INCREMENT,
		hotel_name varchar(50) NOT NULL ,
		hotel_address double NOT NULL ,
		hotel_phone_number bigint not null,
		hotel_rating double,
		delete_flag bit,
		city_id bigint(100), FOREIGN KEY(city_id) REFERENCES city(city_id)
	);
	


	CREATE TABLE IF NOT EXISTS room 
	(
		room_id bigint AUTO_INCREMENT,
		room_type varchar(50) NOT NULL ,
		room_rent double NOT NULL ,
		room_number bigint,
		hotel_id bigint,
		delete_flag bit,
		CONSTRAINT PRIMARY KEY(room_id),
		FOREIGN KEY (hotel_id) REFERENCES hotel(hotel_id)
	);

