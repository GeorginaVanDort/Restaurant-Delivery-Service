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
-- Name: customerdetails; Type: TABLE; Schema: public; Owner: Guest
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
-- Name: finalorders; Type: TABLE; Schema: public; Owner: Guest
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
-- Name: ordereditems; Type: TABLE; Schema: public; Owner: Guest
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
1	5.75	Crab Cream	1
1	3.25	Spring Rolls	2
1	3.75	Fried Wonton	3
1	6.75	B.B.Q Pork	4
1	5.5	Pot Sticker	5
1	5.5	French Fries	6
1	5.5	Fries Prawns	7
1	10.5	Wonton Soup	9
1	7.75	Veggies Roll	9
2	5	Ensalada de Jicama	1
2	5	Tostadaas de Tinga	2
2	5	Nachos	3
2	5	Taquitos de Pollo	4
2	5	Two Tacos	5
3	6	Deluxe	1
3	5	French Dip	2
3	5	Tuna	3
3	5	Egg Salad	4
3	5	MeatBall	5
3	5	Bbq Beef	6
3	5	Hawaiian	7
3	5	Reugen	8
3	5	Seafood	9
4	6	Korean Bbq	1
4	5	Grilled Meat	2
4	5	Salad	3
4	5	Egg Salad	4
4	5	House special Soup	5
4	5	Korean special bbq	6
5	3	Truffled	1
5	3.5	French Fries	2
5	5	MeatBalls	3
5	5	Caesar Salad	4
5	6	Prosciutto panini	5
5	7	Decarli burger	6
5	5	Pizzetta	7
5	6	Short rib sandwich	8
6	3	Methu Vada	1
6	3.5	Rava Dosa	2
6	5	Plate idli	3
6	5	Rava Masala	4
6	6	Plain Dosa	5
6	7	Andhra Dosa	6
6	5	Onion Dosa	7
6	6	Utappam	8
7	3	An Choi	1
7	3.5	Goi	2
7	5	Rice Noodle	3
7	5	Egg Noodle	4
7	6	Pho	5
7	7	Cuon	6
7	5	Com	7
7	6	Ca Nuong	8
8	5	Panang Curry	1
8	6.5	Seafood Medley	2
8	5	Cashew Chicken	3
8	8	Ginger Chicken	4
8	6	Crispy Duck	5
8	7	Pad Prik	6
8	9	Drunken Halibut	7
8	7	Spicy Chicken basil	8
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
-- Name: customerdetails_pkey; Type: CONSTRAINT; Schema: public; Owner: Guest
--

ALTER TABLE ONLY customerdetails
    ADD CONSTRAINT customerdetails_pkey PRIMARY KEY (id);


--
-- Name: finalorders_pkey; Type: CONSTRAINT; Schema: public; Owner: Guest
--

ALTER TABLE ONLY finalorders
    ADD CONSTRAINT finalorders_pkey PRIMARY KEY (id);


--
-- Name: ordereditems_pkey; Type: CONSTRAINT; Schema: public; Owner: Guest
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

