--
-- PostgreSQL database dump
--

-- Dumped from database version 9.5.3
-- Dumped by pg_dump version 9.5.3

SET statement_timeout = 0;
SET lock_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SET check_function_bodies = false;
SET client_min_messages = warning;
SET row_security = off;

--
-- Name: jpavsnative; Type: SCHEMA; Schema: -; Owner: postgres
--

CREATE SCHEMA jpavsnative;


ALTER SCHEMA jpavsnative OWNER TO postgres;

SET search_path = jpavsnative, pg_catalog;

--
-- Name: truncate_tables(); Type: FUNCTION; Schema: jpavsnative; Owner: postgres
--

CREATE FUNCTION truncate_tables() RETURNS void
    LANGUAGE plpgsql
    AS $$
DECLARE
    statements CURSOR FOR
        SELECT tablename FROM pg_tables
        WHERE schemaname = 'jpavsnative';
BEGIN
    FOR stmt IN statements LOOP
        EXECUTE 'TRUNCATE TABLE jpavsnative.' || quote_ident(stmt.tablename) || ' CASCADE;';
    END LOOP;
END;
$$;


ALTER FUNCTION jpavsnative.truncate_tables() OWNER TO postgres;

SET default_tablespace = '';

SET default_with_oids = false;

--
-- Name: car; Type: TABLE; Schema: jpavsnative; Owner: postgres
--

CREATE TABLE car (
    id integer NOT NULL,
    car_type integer,
    registration_nr text,
    production_year timestamp without time zone
);


ALTER TABLE car OWNER TO postgres;

--
-- Name: car_client; Type: TABLE; Schema: jpavsnative; Owner: postgres
--

CREATE TABLE car_client (
    car_id integer,
    client_id integer
);


ALTER TABLE car_client OWNER TO postgres;

--
-- Name: car_id_seq; Type: SEQUENCE; Schema: jpavsnative; Owner: postgres
--

CREATE SEQUENCE car_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE car_id_seq OWNER TO postgres;

--
-- Name: car_id_seq; Type: SEQUENCE OWNED BY; Schema: jpavsnative; Owner: postgres
--

ALTER SEQUENCE car_id_seq OWNED BY car.id;


--
-- Name: car_type; Type: TABLE; Schema: jpavsnative; Owner: postgres
--

CREATE TABLE car_type (
    id integer NOT NULL,
    doors integer NOT NULL,
    model text NOT NULL,
    available_year timestamp without time zone
);


ALTER TABLE car_type OWNER TO postgres;

--
-- Name: car_type_id_seq; Type: SEQUENCE; Schema: jpavsnative; Owner: postgres
--

CREATE SEQUENCE car_type_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE car_type_id_seq OWNER TO postgres;

--
-- Name: car_type_id_seq; Type: SEQUENCE OWNED BY; Schema: jpavsnative; Owner: postgres
--

ALTER SEQUENCE car_type_id_seq OWNED BY car_type.id;


--
-- Name: client; Type: TABLE; Schema: jpavsnative; Owner: postgres
--

CREATE TABLE client (
    id integer NOT NULL,
    name text NOT NULL,
    surname text NOT NULL
);


ALTER TABLE client OWNER TO postgres;

--
-- Name: client_id_seq; Type: SEQUENCE; Schema: jpavsnative; Owner: postgres
--

CREATE SEQUENCE client_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE client_id_seq OWNER TO postgres;

--
-- Name: client_id_seq; Type: SEQUENCE OWNED BY; Schema: jpavsnative; Owner: postgres
--

ALTER SEQUENCE client_id_seq OWNED BY client.id;


--
-- Name: id; Type: DEFAULT; Schema: jpavsnative; Owner: postgres
--

ALTER TABLE ONLY car ALTER COLUMN id SET DEFAULT nextval('car_id_seq'::regclass);


--
-- Name: id; Type: DEFAULT; Schema: jpavsnative; Owner: postgres
--

ALTER TABLE ONLY car_type ALTER COLUMN id SET DEFAULT nextval('car_type_id_seq'::regclass);


--
-- Name: id; Type: DEFAULT; Schema: jpavsnative; Owner: postgres
--

ALTER TABLE ONLY client ALTER COLUMN id SET DEFAULT nextval('client_id_seq'::regclass);


--
-- Name: CarType_pkey; Type: CONSTRAINT; Schema: jpavsnative; Owner: postgres
--

ALTER TABLE ONLY car_type
    ADD CONSTRAINT "CarType_pkey" PRIMARY KEY (id);


--
-- Name: Car_pkey; Type: CONSTRAINT; Schema: jpavsnative; Owner: postgres
--

ALTER TABLE ONLY car
    ADD CONSTRAINT "Car_pkey" PRIMARY KEY (id);


--
-- Name: Client_pkey; Type: CONSTRAINT; Schema: jpavsnative; Owner: postgres
--

ALTER TABLE ONLY client
    ADD CONSTRAINT "Client_pkey" PRIMARY KEY (id);


--
-- Name: fki_CarIdForeign; Type: INDEX; Schema: jpavsnative; Owner: postgres
--

CREATE INDEX "fki_CarIdForeign" ON car_client USING btree (car_id);


--
-- Name: fki_CarToCarType; Type: INDEX; Schema: jpavsnative; Owner: postgres
--

CREATE INDEX "fki_CarToCarType" ON car USING btree (car_type);


--
-- Name: fki_ClientIdForeign; Type: INDEX; Schema: jpavsnative; Owner: postgres
--

CREATE INDEX "fki_ClientIdForeign" ON car_client USING btree (client_id);


--
-- Name: CarIdForeign; Type: FK CONSTRAINT; Schema: jpavsnative; Owner: postgres
--

ALTER TABLE ONLY car_client
    ADD CONSTRAINT "CarIdForeign" FOREIGN KEY (car_id) REFERENCES car(id);


--
-- Name: CarToCarType; Type: FK CONSTRAINT; Schema: jpavsnative; Owner: postgres
--

ALTER TABLE ONLY car
    ADD CONSTRAINT "CarToCarType" FOREIGN KEY (car_type) REFERENCES car_type(id);


--
-- Name: ClientIdForeign; Type: FK CONSTRAINT; Schema: jpavsnative; Owner: postgres
--

ALTER TABLE ONLY car_client
    ADD CONSTRAINT "ClientIdForeign" FOREIGN KEY (client_id) REFERENCES client(id);


--
-- PostgreSQL database dump complete
--

