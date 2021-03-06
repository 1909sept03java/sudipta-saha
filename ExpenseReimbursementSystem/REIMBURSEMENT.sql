--Drop table
DROP TABLE REIMBURSEMENT_TABLE;
/
DROP TABLE EMPLOYEE_TABLE;
/

--CREATING TABLE
CREATE TABLE EMPLOYEE_TABLE (
    EMPLOYEE_ID INTEGER PRIMARY KEY,
    USERNAME VARCHAR2(100) UNIQUE NOT NULL,
    USERPASSWORD VARCHAR2(100) NOT NULL,
    FIRSTNAME VARCHAR2(100) NOT NULL,
    LASTNAME VARCHAR2(100) NOT NULL,
    ISADMIN INTEGER DEFAULT 0 NOT NULL,
    MANAGER_ID NUMBER(4) REFERENCES EMPLOYEE_TABLE(EMPLOYEE_ID) NOT NULL
);
/
CREATE TABLE REIMBURSEMENT_TABLE (
    REIMBURSEMENT_ID INTEGER PRIMARY KEY,
    DETAILS VARCHAR2(100) NOT NULL,
    BALANCE NUMBER DEFAULT 0.00,
    STATUS VARCHAR2(100) NOT NULL,
    EMPLOYEE_ID INTEGER NOT NULL,
    S_DATE DATE  NOT NULL
);
/

--FOREIGN KEY CONSTRAINTS 
ALTER TABLE REIMBURSEMENT_TABLE
ADD CONSTRAINT FK_REIM_TABLE_EMPLOYEE_TABLE
FOREIGN KEY (EMPLOYEE_ID) REFERENCES EMPLOYEE_TABLE(EMPLOYEE_ID);
/

--DROPING SEQUENCE
DROP SEQUENCE SQ_EMPLOYEE_PRIMARY_KEYS;
DROP SEQUENCE SQ_REIM_PRIMARY_KEYS;
/

--SET UP SEQUENCES TO PRODUCE PRIMARY KEYS 
CREATE SEQUENCE SQ_EMPLOYEE_PRIMARY_KEYS
START WITH 1000
INCREMENT BY 1;
/

CREATE SEQUENCE SQ_REIM_PRIMARY_KEYS
START WITH 1000
INCREMENT BY 1;
/

--TRIGGER
CREATE OR REPLACE TRIGGER TR_INSERT_EMPLOYEE_TABLE
BEFORE INSERT ON EMPLOYEE_TABLE
FOR EACH ROW
BEGIN
    SELECT SQ_EMPLOYEE_PRIMARY_KEYS.NEXTVAL INTO :NEW.EMPLOYEE_ID FROM DUAL;
END;
/

CREATE OR REPLACE TRIGGER TR_INSERT_REIMBURSEMENT_TABLE
BEFORE INSERT ON REIMBURSEMENT_TABLE
FOR EACH ROW
BEGIN
    SELECT SQ_REIM_PRIMARY_KEYS.NEXTVAL INTO :NEW.REIMBURSEMENT_ID FROM DUAL;
END;
/

--DEMO INSERT
INSERT INTO EMPLOYEE_TABLE VALUES(1,'user1','user1','John','Adam',1 ,1000);
INSERT INTO EMPLOYEE_TABLE VALUES(1,'user2','user2','Johny','Cash',0 ,1000);
INSERT INTO EMPLOYEE_TABLE VALUES(1,'user3','user3','Cathy','Adam',0 ,1000);

INSERT INTO REIMBURSEMENT_TABLE VALUES(1,'MTA',128,'Approved',1000,TO_DATE('1958-08-18', 'yyyy-mm-dd'));
INSERT INTO REIMBURSEMENT_TABLE VALUES(1,'Food',50,'Rejected',1001,TO_DATE('1958-08-18', 'yyyy-mm-dd'));

SELECT EMPLOYEE_ID FROM EMPLOYEE_TABLE WHERE USERNAME = 'user1' AND USERPASSWORD = 'user1';
SELECT * FROM EMPLOYEE_TABLE WHERE USERNAME = 'user2' AND USERPASSWORD = 'user2';
SELECT * FROM REIMBURSEMENT_TABLE WHERE EMPLOYEE_ID = 1000;

SELECT * FROM EMPLOYEE_TABLE E
JOIN REIMBURSEMENT_TABLE R
ON E.EMPLOYEE_ID = R.EMPLOYEE_ID;

--JOIN OF TWO TABLE
SELECT E.FIRSTNAME AS M_F, E.LASTNAME AS M_L, E.EMPLOYEE_ID AS ID_D
FROM EMPLOYEE_TABLE E
RIGHT JOIN REIMBURSEMENT_TABLE R
ON E.EMPLOYEE_ID = R.EMPLOYEE_ID
WHERE E.MANAGER_ID = E.EMPLOYEE_ID;

--GETTING THE MANAGER NAME
SELECT E.EMPLOYEE_ID ,E.FIRSTNAME, E.LASTNAME, E.ISADMIN, E.MANAGER_ID, M.FIRSTNAME AS M_F, M.LASTNAME AS M_L
FROM EMPLOYEE_TABLE E, EMPLOYEE_TABLE M
WHERE E.MANAGER_ID = M.EMPLOYEE_ID;

--JOIN OF TWO TABLE WITH MANAGER NAME
SELECT * FROM (SELECT E.EMPLOYEE_ID ,E.FIRSTNAME, E.LASTNAME, E.ISADMIN, E.MANAGER_ID, M.FIRSTNAME AS M_F, M.LASTNAME AS M_L
FROM EMPLOYEE_TABLE E, EMPLOYEE_TABLE M
WHERE E.MANAGER_ID = M.EMPLOYEE_ID) E
JOIN REIMBURSEMENT_TABLE R
ON E.EMPLOYEE_ID = R.EMPLOYEE_ID
ORDER
BY REIMBURSEMENT_ID DESC;


--DETAILS FOR USERS UNDER A MANAGER
SELECT * FROM (SELECT * FROM (SELECT E.EMPLOYEE_ID ,E.FIRSTNAME, E.LASTNAME, E.ISADMIN, E.MANAGER_ID, M.FIRSTNAME AS M_F, M.LASTNAME AS M_L
FROM EMPLOYEE_TABLE E, EMPLOYEE_TABLE M
WHERE E.MANAGER_ID = M.EMPLOYEE_ID) E
JOIN REIMBURSEMENT_TABLE R
ON E.EMPLOYEE_ID = R.EMPLOYEE_ID)
WHERE MANAGER_ID = 1000
ORDER
BY REIMBURSEMENT_ID DESC;

--UPDATING STATUS
UPDATE REIMBURSEMENT_TABLE
SET STATUS = 'Accepted'
WHERE REIMBURSEMENT_ID = 1020;

UPDATE REIMBURSEMENT_TABLE
SET STATUS = 'Rejected'
WHERE REIMBURSEMENT_ID = 1020;

---UPDATING USER INFO
UPDATE EMPLOYEE_TABLE
SET FIRSTNAME = 'TEST' , LASTNAME = 'TEST'
WHERE EMPLOYEE_ID = 1022;

SELECT FIRSTNAME,LASTNAME FROM EMPLOYEE_TABLE WHERE EMPLOYEE_ID = 1022;
