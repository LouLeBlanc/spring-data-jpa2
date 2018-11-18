CREATE USER IF NOT EXISTS 'prospring5' IDENTIFIED BY 'prospring5';

DROP DATABASE IF EXISTS publishing_jpa2;

CREATE SCHEMA publishing_jpa2;

GRANT ALL PRIVILEGES ON publishing_jpa2.* TO 'prospring5';
FLUSH PRIVILEGES;

/* Clarify timezone in case of java.sql.SQLException */
SET GLOBAL time_zone = '+5:00';

