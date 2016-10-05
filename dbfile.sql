--
-- PostgreSQL database dump
--

-- Dumped from database version 9.5.4
-- Dumped by pg_dump version 9.5.4

SET statement_timeout = 0;
SET lock_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SET check_function_bodies = false;
SET client_min_messages = warning;
SET row_security = off;

--
-- Name: plpgsql; Type: EXTENSION; Schema: -; Owner: 
--

CREATE EXTENSION IF NOT EXISTS plpgsql WITH SCHEMA pg_catalog;


--
-- Name: EXTENSION plpgsql; Type: COMMENT; Schema: -; Owner: 
--

COMMENT ON EXTENSION plpgsql IS 'PL/pgSQL procedural language';


SET search_path = public, pg_catalog;

SET default_tablespace = '';

SET default_with_oids = false;

--
-- Name: customers; Type: TABLE; Schema: public; Owner: Guest
--

CREATE TABLE customers (
    id integer NOT NULL,
    customername character varying,
    phone character varying,
    address character varying
);


ALTER TABLE customers OWNER TO "Guest";

--
-- Name: customers_id_seq; Type: SEQUENCE; Schema: public; Owner: Guest
--

CREATE SEQUENCE customers_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE customers_id_seq OWNER TO "Guest";

--
-- Name: customers_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: Guest
--

ALTER SEQUENCE customers_id_seq OWNED BY customers.id;


--
-- Name: menuitems; Type: TABLE; Schema: public; Owner: Guest
--

CREATE TABLE menuitems (
    restaurantid integer,
    price double precision,
    itemname character varying,
    id integer
);


ALTER TABLE menuitems OWNER TO "Guest";

--
-- Name: orderitems; Type: TABLE; Schema: public; Owner: Guest
--

CREATE TABLE orderitems (
    id integer NOT NULL,
    menuitem_id character varying,
    quantity integer,
    ordertime timestamp without time zone
);


ALTER TABLE orderitems OWNER TO "Guest";

--
-- Name: orderitems_id_seq; Type: SEQUENCE; Schema: public; Owner: Guest
--

CREATE SEQUENCE orderitems_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE orderitems_id_seq OWNER TO "Guest";

--
-- Name: orderitems_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: Guest
--

ALTER SEQUENCE orderitems_id_seq OWNED BY orderitems.id;


--
-- Name: orders; Type: TABLE; Schema: public; Owner: Guest
--

CREATE TABLE orders (
    id integer NOT NULL,
    customer_id integer,
    orderitems_id integer
);


ALTER TABLE orders OWNER TO "Guest";

--
-- Name: orders_id_seq; Type: SEQUENCE; Schema: public; Owner: Guest
--

CREATE SEQUENCE orders_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE orders_id_seq OWNER TO "Guest";

--
-- Name: orders_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: Guest
--

ALTER SEQUENCE orders_id_seq OWNED BY orders.id;


--
-- Name: restaurants; Type: TABLE; Schema: public; Owner: Guest
--

CREATE TABLE restaurants (
    name character varying,
    cuisine character varying,
    hours character varying,
    address character varying,
    price character varying,
    id integer
);


ALTER TABLE restaurants OWNER TO "Guest";

--
-- Name: id; Type: DEFAULT; Schema: public; Owner: Guest
--

ALTER TABLE ONLY customers ALTER COLUMN id SET DEFAULT nextval('customers_id_seq'::regclass);


--
-- Name: id; Type: DEFAULT; Schema: public; Owner: Guest
--

ALTER TABLE ONLY orderitems ALTER COLUMN id SET DEFAULT nextval('orderitems_id_seq'::regclass);


--
-- Name: id; Type: DEFAULT; Schema: public; Owner: Guest
--

ALTER TABLE ONLY orders ALTER COLUMN id SET DEFAULT nextval('orders_id_seq'::regclass);


--
-- Data for Name: customers; Type: TABLE DATA; Schema: public; Owner: Guest
--

COPY customers (id, customername, phone, address) FROM stdin;
\.


--
-- Name: customers_id_seq; Type: SEQUENCE SET; Schema: public; Owner: Guest
--

SELECT pg_catalog.setval('customers_id_seq', 474, true);


--
-- Data for Name: menuitems; Type: TABLE DATA; Schema: public; Owner: Guest
--

COPY menuitems (restaurantid, price, itemname, id) FROM stdin;
\.


--
-- Data for Name: orderitems; Type: TABLE DATA; Schema: public; Owner: Guest
--

COPY orderitems (id, menuitem_id, quantity, ordertime) FROM stdin;
\.


--
-- Name: orderitems_id_seq; Type: SEQUENCE SET; Schema: public; Owner: Guest
--

SELECT pg_catalog.setval('orderitems_id_seq', 1, false);


--
-- Data for Name: orders; Type: TABLE DATA; Schema: public; Owner: Guest
--

COPY orders (id, customer_id, orderitems_id) FROM stdin;
\.


--
-- Name: orders_id_seq; Type: SEQUENCE SET; Schema: public; Owner: Guest
--

SELECT pg_catalog.setval('orders_id_seq', 1, false);


--
-- Data for Name: restaurants; Type: TABLE DATA; Schema: public; Owner: Guest
--

COPY restaurants (name, cuisine, hours, address, price, id) FROM stdin;
Happy Panda	Chinese	Lunch-Dinner	1234 N Wilcox Rd	$$	1
Casa Lola	Mexican	Lunch-Dinner	1234 N Homer St.	$$	2
Subs Station	American	Lunch-Dinner	1234 N Marge St.	$	3
DU KUH BEE	Chinese	Lunch-Dinner	1234 N Bart St.	$$	4
Decarli	Itallian	Lunch-Dinner	1234 N lisa St.	$$$	5
Swagat	Indian	Lunch-Dinner	1234 N Magy St.	$$$	6
Pho Van	Vietnamese	Lunch-Dinner	1234 N Magy St.	$	7
Thai Bloom	Thai	Lunch-Dinner	1234 N Magy St.	$$$	8
\.


--
-- Name: customers_pkey; Type: CONSTRAINT; Schema: public; Owner: Guest
--

ALTER TABLE ONLY customers
    ADD CONSTRAINT customers_pkey PRIMARY KEY (id);


--
-- Name: orderitems_pkey; Type: CONSTRAINT; Schema: public; Owner: Guest
--

ALTER TABLE ONLY orderitems
    ADD CONSTRAINT orderitems_pkey PRIMARY KEY (id);


--
-- Name: orders_pkey; Type: CONSTRAINT; Schema: public; Owner: Guest
--

ALTER TABLE ONLY orders
    ADD CONSTRAINT orders_pkey PRIMARY KEY (id);


--
-- Name: public; Type: ACL; Schema: -; Owner: epicodus
--

REVOKE ALL ON SCHEMA public FROM PUBLIC;
REVOKE ALL ON SCHEMA public FROM epicodus;
GRANT ALL ON SCHEMA public TO epicodus;
GRANT ALL ON SCHEMA public TO PUBLIC;


--
-- PostgreSQL database dump complete
--

