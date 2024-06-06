/*==============================================================*/
/* Service: HOTEL-SERVICE                                       */
/*==============================================================*/
-- Schema for hotel_service
CREATE SCHEMA hotel_service AUTHORIZATION superadmin;
GRANT ALL ON SCHEMA hotel_service TO superadmin;

-- TODO не создавать пароль в открытом виде!
-- User for schema hotel_service
CREATE ROLE hotel_service_user WITH
    LOGIN
    NOSUPERUSER
    INHERIT
    NOCREATEDB
    NOCREATEROLE
    NOREPLICATION
    PASSWORD 'password';

-- Grant usage on the schema to the role
GRANT USAGE ON SCHEMA hotel_service TO hotel_service_user;

-- Grant select, insert, update, delete permissions on all tables in the schema
GRANT SELECT, INSERT, UPDATE, DELETE ON ALL TABLES IN SCHEMA hotel_service TO hotel_service_user;

-- To automatically grant the permissions on new tables in the future
ALTER DEFAULT PRIVILEGES IN SCHEMA hotel_service
GRANT SELECT, INSERT, UPDATE, DELETE ON TABLES TO hotel_service_user;

-- Revoke access to other schemas from the role
REVOKE ALL PRIVILEGES ON SCHEMA public FROM hotel_service_user;
REVOKE ALL PRIVILEGES ON
ALL tables IN SCHEMA public
FROM
hotel_service_user;

/*==============================================================*/
/* Table: Hotel                                                 */
/*==============================================================*/
CREATE TABLE hotel_service.hotel (
   id         UUID 	     		 NOT NULL PRIMARY KEY,
   name         VARCHAR(200)              NOT NULL,
   star_rating         SMALLINT         NOT NULL CHECK (star_rating BETWEEN 1 AND 5),
   description            TEXT            NULL,
   address VARCHAR(200)                 NOT NULL,
   addition_date TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP
);

/*==============================================================*/
/* Table: Hotel_contact_type                                    */
/*==============================================================*/
CREATE TABLE hotel_service.hotel_contact_type (
   id         SMALLINT 	     		 NOT NULL PRIMARY KEY,
   name VARCHAR(200)                 NOT NULL
);

/*==============================================================*/
/* Table: Hotel_contact                                         */
/*==============================================================*/
CREATE TABLE hotel_service.hotel_contact (
   id         UUID 	     		 NOT NULL PRIMARY KEY,
   id_hotel UUID                 NOT NULL REFERENCES hotel_service.hotel(id),
   id_hotel_contact_type SMALLINT NOT NULL REFERENCES hotel_service.hotel_contact_type(id),
   contact_value VARCHAR(200) NOT NULL
);

/*==============================================================*/
/* Table: Hotel_room_type                                       */
/*==============================================================*/
CREATE TABLE hotel_service.hotel_room_type (
   id         SMALLINT 	     		 NOT NULL PRIMARY KEY,
   name VARCHAR(200)                 NOT NULL,
   description TEXT NULL,
   cost INTEGER NOT NULL
);

/*==============================================================*/
/* Table: Hotel_room                                            */
/*==============================================================*/
CREATE TABLE hotel_service.hotel_room (
   id         UUID 	     		 NOT NULL PRIMARY KEY,
   id_hotel UUID                 NOT NULL REFERENCES hotel_service.hotel(id),
   room_number SMALLINT NOT NULL,
   description TEXT NULL,
   id_hotel_room_type SMALLINT NOT NULL REFERENCES hotel_service.hotel_room_type(id)
);

/*==============================================================*/
/* Table: Hotel_reservation                                     */
/*==============================================================*/
CREATE TABLE hotel_service.hotel_reservation (
   id         UUID 	     		 NOT NULL PRIMARY KEY,
   id_hotel UUID                 NOT NULL REFERENCES hotel_service.hotel(id),
   id_hotel_room UUID NOT NULL REFERENCES hotel_service.hotel_room(id),
   start_date TIMESTAMP NOT NULL,
   end_date TIMESTAMP NOT NULL
);

/*==============================================================*/
/* Table: Person                                                */
/*==============================================================*/
CREATE TABLE hotel_service.person (
   id         UUID 	     		 NOT NULL PRIMARY KEY,
   name VARCHAR(200)                 NOT NULL,
   last_name VARCHAR(200)                 NOT NULL,
   passport VARCHAR(200)                 NOT NULL,
   phone_number VARCHAR(200)                 NOT NULL,
   email VARCHAR(200)                 NULL
);

/*==============================================================*/
/* Table: Hotel_reservation_person                              */
/*==============================================================*/
CREATE TABLE hotel_service.hotel_reservation_person (
   id         UUID 	     		 NOT NULL PRIMARY KEY,
   id_hotel_reservation UUID                NOT NULL REFERENCES hotel_service.hotel_reservation(id),
   id_person UUID                NOT NULL REFERENCES hotel_service.person(id)
);