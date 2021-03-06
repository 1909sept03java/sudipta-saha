--DB CREATION SCRIPTS OFTEN BEGIN WITH DROP STATEMENTS
--AVOID CLASHES WITH TABLES

DROP TABLE BEAR;
/
DROP TABLE BEAR_TYPE;
/
DROP TABLE CAVE;
/
DROP TABLE BEEHIVE;
/
DROP TABLE BEAR_BEEHIVE;
/

--TABLE CREATION WITH PRIMARY KEYS

CREATE TABLE BEAR (
    BEAR_ID INTEGER PRIMARY KEY,
    BEAR_NAME VARCHAR2(100), --100 CHARACTERS OF SPACE
    --VARCHAR2 INTERPRETS NULL AND EMPTY STRING AS THE SAME VALUE, UNLIKE VARCHAR
    BIRTHDAY DATE,
    WEIGHT NUMBER(6,2) DEFAULT 200.00,
    BEAR_TYPE_ID INTEGER NOT NULL, --APPYLING A NOT NULL CONSTRAINT TO THIS COLUMN, WILL BE FK
    CAVE_ID INTEGER --WILL BE A NULLABLE CHAR
);
/
CREATE TABLE CAVE(
    CAVE_ID INTEGER PRIMARY KEY,
    CAVE_NAME VARCHAR(100),
    MAX_BEARS INTEGER DEFAULT 4
);
/
CREATE TABLE BEEHIVE (
    BEEHIVE_ID INTEGER PRIMARY KEY,
    HONEY_AMT NUMBER(5,2) DEFAULT 75.00
);
/
CREATE TABLE BEAR_BEEHIVE (
    BEAR_ID INTEGER,
    BEEHIVE_ID INTEGER,
    PRIMARY KEY (BEAR_ID, BEEHIVE_ID) --COMPOSITE PRIMARY KEY
);
/

--FOREIGN KEY CONSTRAINTS

--CONSTRAINTS: RULE PLACED ON THE CONTENTS OF A TABLE, LIMITING WHAT MAY BE INSERTED
--TYPES OF CONSTRAINTS: CHECK (INCLUDES NOT NULL), UNIQUE, PRIMARY KEY, FOREIGN KEY

ALTER TABLE BEAR
ADD CONSTRAINT FK_BEAR_BEAR_TYPE
FOREIGN KEY (BEAR_TYPE_ID) REFERENCES BEAR_TYPE(BEAR_TYPE_ID);
/

ALTER TABLE BEAR
ADD CONSTRAINT FK_BEAR_CAVE
FOREIGN KEY (CAVE_ID) REFERENCES CAVE(CAVE_ID);
/

ALTER TABLE BEAR_BEEHIVE
ADD CONSTRAINT FK_BEAR_BEEHIVE_BEAR
FOREIGN KEY (BEAR_ID) REFERENCES BEAR(BEAR_ID);
/

ALTER TABLE BEAR_BEEHIVE
ADD CONSTRAINT FK_BEAR_BEEHIVE_BEEHIEV
FOREIGN KEY (BEEHIVE_ID) REFERENCES BEEHIVE(BEEHIVE_ID);
/