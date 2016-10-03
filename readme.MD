
Database Naming Requirements
Use the following database names:

Production Database: delivery_service;
Development Database: delivery_service_test
Table Names: customers, ...

![Database Setup] (screenshot.png)

In PSQL:
CREATE DATABASE delivery_service;
CREATE TABLE customers(id serial PRIMARY KEY, name varchar, phone varchar, ordertime timestamp);
