
CREATE TABLE tbl_job(
	id INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY PRIMARY KEY
	, job_number CHAR(32)
	, job_customer_address_id INTEGER
	, job_address_id INTEGER
	, job_start_date TIMESTAMP
	, job_end_date TIMESTAMP
	, job_per_id INTEGER
	, note LONG VARCHAR
	, job_description LONG VARCHAR
	, planing LONG VARCHAR
	, employee_pull_id INTEGER
	, billing_category_id INTEGER
);

CREATE TABLE tbl_address(
	id INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY PRIMARY KEY
	, street_1 CHAR(254)
	, street_2 CHAR(254)
	, home_number CHAR(32)
	, zip_code CHAR(12)
	, city CHAR(128)
	, country_iso2code CHAR(2)
	, phone_1 CHAR(32)
	, phone_2 CHAR(32)
	, mobile_1 CHAR(32)
	, mobile_2 CHAR(32)
	, fax_1 CHAR(32)
	, fax_2 CHAR(32)
	, web_1 CHAR(254)
	, web_2 CHAR(254)
	, email_1 CHAR(254)
	, email_2 CHAR(254)
);

CREATE TABLE tbl_country
(
	iso2code CHAR(2) NOT NULL PRIMARY KEY
	, contry_name CHAR(128)
	, currensy_symbol CHAR(3)
	, currency_iso3code CHAR(3)
);


CREATE TABLE tbl_customer(
	id INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY PRIMARY KEY
	, customer_name LONG VARCHAR
	, default_address_id INTEGER
	, CONSTRAINT address_id_fkey FOREIGN KEY(default_address_id) REFERENCES address(id)
);

CREATE TABLE tbl_customer_address(
	id INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY PRIMARY KEY
	, customer_id INTEGER NOT NULL
	, address_id INTEGER NOT NULL
	, CONSTRAINT ca_customer_id_fkey FOREIGN KEY(customer_id) REFERENCES tbl_customer(id)
	, CONSTRAINT ca_address_id_fkey FOREIGN KEY(address_id) REFERENCES tbl_address(id)
);

ALTER TABLE tbl_job
	ADD CONSTRAINT j_customer_address_id_fkey FOREIGN KEY(job_customer_address_id) REFERENCES tbl_customer_address(id)
;

ALTER TABLE tbl_address
	ADD CONSTRAINT a_country_iso2code_fkey FOREIGN KEY(country_iso2code) REFERENCES tbl_country(iso2code)
;

INSERT INTO TBL_COUNTRY(ISO2CODE, CONTRY_NAME, CURRENSY_SYMBOL, CURRENCY_ISO3CODE)
VALUES
	('DE', 'Deutschland', '€', 'EUR')
;
