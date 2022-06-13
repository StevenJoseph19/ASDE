CREATE TABLE performance
(
	fl_date date,
	mkt_carrier character varying(2),
	mkt_carrier_fl_num character varying(4),
	origin character varying(3),
	origin_city_name character varying(45),
	origin_state_abr character varying(2),
	dest character varying(3),
	dest_city_name character varying(45),
	dest_state_abr character varying(2),
	dep_delay_new numeric,
	arr_delay_new numeric,
	cancelled numeric,
	cancellation_code character varying(2),
	diverted numeric,
	carrier_delay numeric,
	weather_delay numeric,
	nas_delay numeric,
	security_delay numeric,
	late_aircraft_delay numeric
);

COPY public.performance (fl_date, mkt_carrier, mkt_carrier_fl_num, origin, origin_city_name, origin_state_abr, dest, dest_city_name, dest_state_abr, dep_delay_new, arr_delay_new, cancelled, cancellation_code, diverted, carrier_delay, weather_delay, nas_delay, security_delay, late_aircraft_delay) 
FROM 'C:/Training/Virtual Training/ACE/ASDE/Training Materials/Week 1/Day 5/1. Querying Data from PostgreSQL/Demonstration Tables/OntimeCarrier.csv' 
DELIMITER ',' 
CSV HEADER ENCODING 'UTF8' 
QUOTE '"' 
ESCAPE '''';

CREATE TABLE codes_cancellation
(
	cancellation_code character varying(2),
           cancel_desc character varying(45)
);

INSERT INTO codes_cancellation (cancellation_code, cancel_desc)
VALUES
	('A','Carrier'),
	('B','Weather'),
	('C','National Air System'),
	('D','Security');

CREATE TABLE codes_carrier
(
	carrier_code character varying(2),
	carrier_desc character varying(45)
);

INSERT INTO codes_carrier (carrier_code, carrier_desc)
VALUES
	('AA','American Airlines'),
	('AS','Alaska Airlines'),
	('B6','JetBlue Airways'),
	('DL','Delta Air Lines'),
	('F9','Frontier Airlines'),
	('G4','Allegiant Air'),
	('HA','Hawaiian Airlines'),
	('NK','Spirit Air Lines'),
	('UA','United Air Lines'),
	('VX','Virgin America'),
	('WN','Southwest Airlines');




















