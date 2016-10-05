--
-- PostgreSQL database dump
--

SET statement_timeout = 0;
SET lock_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SET check_function_bodies = false;
SET client_min_messages = warning;

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
-- Name: customerdetails; Type: TABLE; Schema: public; Owner: Guest; Tablespace: 
--

CREATE TABLE customerdetails (
    id integer NOT NULL,
    customername character varying,
    customerphone character varying,
    customeraddress character varying,
    ordertime timestamp without time zone
);


ALTER TABLE customerdetails OWNER TO "Guest";

--
-- Name: customerdetails_id_seq; Type: SEQUENCE; Schema: public; Owner: Guest
--

CREATE SEQUENCE customerdetails_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE customerdetails_id_seq OWNER TO "Guest";

--
-- Name: customerdetails_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: Guest
--

ALTER SEQUENCE customerdetails_id_seq OWNED BY customerdetails.id;


--
-- Name: finalorders; Type: TABLE; Schema: public; Owner: Guest; Tablespace: 
--

CREATE TABLE finalorders (
    id integer NOT NULL,
    ordereditems_id integer,
    customerdetails_id integer
);


ALTER TABLE finalorders OWNER TO "Guest";

--
-- Name: finalorders_id_seq; Type: SEQUENCE; Schema: public; Owner: Guest
--

CREATE SEQUENCE finalorders_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE finalorders_id_seq OWNER TO "Guest";

--
-- Name: finalorders_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: Guest
--

ALTER SEQUENCE finalorders_id_seq OWNED BY finalorders.id;


--
-- Name: menuitems; Type: TABLE; Schema: public; Owner: Guest; Tablespace: 
--

CREATE TABLE menuitems (
    restaurantid integer,
    price double precision,
    itemname character varying,
    id integer
);


ALTER TABLE menuitems OWNER TO "Guest";

--
-- Name: ordereditems; Type: TABLE; Schema: public; Owner: Guest; Tablespace: 
--

CREATE TABLE ordereditems (
    id integer NOT NULL,
    menuitem_id integer,
    quantity integer,
    subtotal integer
);


ALTER TABLE ordereditems OWNER TO "Guest";

--
-- Name: ordereditems_id_seq; Type: SEQUENCE; Schema: public; Owner: Guest
--

CREATE SEQUENCE ordereditems_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE ordereditems_id_seq OWNER TO "Guest";

--
-- Name: ordereditems_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: Guest
--

ALTER SEQUENCE ordereditems_id_seq OWNED BY ordereditems.id;


--
-- Name: restaurants; Type: TABLE; Schema: public; Owner: Guest; Tablespace: 
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

ALTER TABLE ONLY customerdetails ALTER COLUMN id SET DEFAULT nextval('customerdetails_id_seq'::regclass);


--
-- Name: id; Type: DEFAULT; Schema: public; Owner: Guest
--

ALTER TABLE ONLY finalorders ALTER COLUMN id SET DEFAULT nextval('finalorders_id_seq'::regclass);


--
-- Name: id; Type: DEFAULT; Schema: public; Owner: Guest
--

ALTER TABLE ONLY ordereditems ALTER COLUMN id SET DEFAULT nextval('ordereditems_id_seq'::regclass);


--
-- Data for Name: customerdetails; Type: TABLE DATA; Schema: public; Owner: Guest
--

COPY customerdetails (id, customername, customerphone, customeraddress, ordertime) FROM stdin;
\.


--
-- Name: customerdetails_id_seq; Type: SEQUENCE SET; Schema: public; Owner: Guest
--

SELECT pg_catalog.setval('customerdetails_id_seq', 1, false);


--
-- Data for Name: finalorders; Type: TABLE DATA; Schema: public; Owner: Guest
--

COPY finalorders (id, ordereditems_id, customerdetails_id) FROM stdin;
\.


--
-- Name: finalorders_id_seq; Type: SEQUENCE SET; Schema: public; Owner: Guest
--

SELECT pg_catalog.setval('finalorders_id_seq', 1, false);


--
-- Data for Name: menuitems; Type: TABLE DATA; Schema: public; Owner: Guest
--

COPY menuitems (restaurantid, price, itemname, id) FROM stdin;
\.


--
-- Data for Name: ordereditems; Type: TABLE DATA; Schema: public; Owner: Guest
--

COPY ordereditems (id, menuitem_id, quantity, subtotal) FROM stdin;
\.


--
-- Name: ordereditems_id_seq; Type: SEQUENCE SET; Schema: public; Owner: Guest
--

SELECT pg_catalog.setval('ordereditems_id_seq', 1, false);


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
-- Name: customerdetails_pkey; Type: CONSTRAINT; Schema: public; Owner: Guest; Tablespace: 
--

ALTER TABLE ONLY customerdetails
    ADD CONSTRAINT customerdetails_pkey PRIMARY KEY (id);


--
-- Name: finalorders_pkey; Type: CONSTRAINT; Schema: public; Owner: Guest; Tablespace: 
--

ALTER TABLE ONLY finalorders
    ADD CONSTRAINT finalorders_pkey PRIMARY KEY (id);


--
-- Name: ordereditems_pkey; Type: CONSTRAINT; Schema: public; Owner: Guest; Tablespace: 
--

ALTER TABLE ONLY ordereditems
    ADD CONSTRAINT ordereditems_pkey PRIMARY KEY (id);


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

