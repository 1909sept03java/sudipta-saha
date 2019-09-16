--2.1 SELECT
--Task – Select all records from the Employee table.
SELECT * FROM EMPLOYEE;
--Task – Select all records from the Employee table where last name is King.
SELECT * FROM EMPLOYEE
WHERE LASTNAME = 'King';
--Task – Select all records from the Employee table where first name is Andrew and REPORTSTO is NULL.
SELECT * FROM EMPLOYEE
WHERE FIRSTNAME = 'Andrew' AND REPORTSTO IS NULL;

--2.2 ORDER BY
--Task – Select all albums in Album table and sort result set in descending order by title.
SELECT * FROM ALBUM
ORDER BY TITLE DESC;
--Task – Select first name from Customer and sort result set in ascending order by city
SELECT FIRSTNAME
FROM CUSTOMER
ORDER BY CITY;
--2.3 INSERT INTO
--Task – Insert two new records into Genre table 
INSERT INTO GENRE(GENREID,NAME)
VALUES('26','DEMO1');
INSERT INTO GENRE
VALUES('27','DEMO2');
--Task – Insert two new records into Employee table
INSERT ALL
  INTO EMPLOYEE (EMPLOYEEID,LASTNAME, FIRSTNAME) VALUES ('9','JOHN','ADAM')
  INTO EMPLOYEE (EMPLOYEEID,LASTNAME, FIRSTNAME) VALUES ('10','DEMOEMP','DEMOEMP')
SELECT * FROM DUAL;
--Task – Insert two new records into Customer table
INSERT ALL
  INTO CUSTOMER (CUSTOMERID,LASTNAME, FIRSTNAME,EMAIL) VALUES ('1000','JOHN','ADAM','A@B.COM')
  INTO CUSTOMER (CUSTOMERID,LASTNAME, FIRSTNAME,EMAIL) VALUES ('1001','DEMOEMP','DEMOEMP','B@C.COM')
SELECT * FROM DUAL;

--2.4 UPDATE
--Task – Update Aaron Mitchell in Customer table to Robert Walter
UPDATE CUSTOMER
SET FIRSTNAME = 'Robert', LASTNAME = 'Walter'
WHERE FIRSTNAME = 'Aaron' AND LASTNAME = 'Mitchell';
--Task – Update name of artist in the Artist table “Creedence Clearwater Revival” to “CCR”
UPDATE ARTIST
SET NAME = 'CCR'
WHERE NAME = 'Creedence Clearwater Revival';

--2.5 LIKE
--Task – Select all invoices with a billing address like “T%” 
SELECT * FROM INVOICE
WHERE BILLINGADDRESS LIKE 'T%';

--2.6 BETWEEN
--Task – Select all invoices that have a total between 15 and 50
SELECT * FROM INVOICE
WHERE TOTAL BETWEEN 15 AND 50;
--Task – Select all employees hired between 1st of June 2003 and 1st of March 2004
SELECT * FROM EMPLOYEE
WHERE HIREDATE BETWEEN '01-JUN-03' AND '01-MAR-04';

--2.7 DELETE
--Task – Delete a record in Customer table where the name is Robert Walter (There may be constraints that rely on this, find out how to resolve them).
DELETE INVOICELINE WHERE INVOICEID =(
SELECT INVOICEID FROM INVOICE WHERE CUSTOMERID =
(SELECT CUSTOMERID FROM CUSTOMER
WHERE FIRSTNAME = 'Robert' AND LASTNAME = 'Walter') AND ROWNUM = 1);
/   
DELETE INVOICE WHERE CUSTOMERID =
(SELECT CUSTOMERID FROM CUSTOMER
WHERE FIRSTNAME = 'Robert' AND LASTNAME = 'Walter') AND ROWNUM = 1;
/  
DELETE CUSTOMER WHERE FIRSTNAME = 'Robert' AND LASTNAME = 'Walter';

--3.1 System Defined Functions
--Task – Create a function that returns the current time.
CREATE OR REPLACE FUNCTION GETDATE
RETURN DATE
IS
D DATE;
BEGIN
    D := SYSDATE;
    RETURN (D);
END;
/
SELECT GETDATE() FROM DUAL; 
--Task – create a function that returns the length of name in MEDIATYPE table 

CREATE OR REPLACE FUNCTION NAMELENGTH(MEDIA_ID IN NUMBER)
RETURN NUMBER IS
NAME_L NUMBER;
BEGIN
    SELECT LENGTH(NAME) INTO NAME_L FROM MEDIATYPE 
    WHERE MEDIATYPEID = MEDIA_ID;
    RETURN (NAME_L);
END;
/
SELECT NAMELENGTH(1) FROM DUAL;

--3.2 System Defined Aggregate Functions
--Task – Create a function that returns the most expensive track
CREATE OR REPLACE FUNCTION MOST_EXP
RETURN NUMBER
IS 
MAX_PRICE NUMBER;
BEGIN
    SELECT MAX(UNITPRICE) INTO MAX_PRICE FROM TRACK;
    RETURN (MAX_PRICE);
END;
/
SELECT MOST_EXP() FROM DUAL;

--3.3 User Defined Scalar Functions
--Task – Create a function that returns the average price of invoice line items in the invoiceline table

CREATE OR REPLACE FUNCTION AVG_PRICE
RETURN NUMBER
IS
AVG_P NUMBER;
BEGIN
    SELECT AVG(UNITPRICE) INTO AVG_P FROM INVOICELINE;
    RETURN (AVG_P);
END;
/
SELECT AVG_PRICE() FROM DUAL;

--3.4 User Defined Table Valued Functions
--Task – Create a function that returns all employees who were born after 1968.
CREATE OR REPLACE FUNCTION EMPLOYEE_LIST
RETURN SYS_REFCURSOR
IS
EMPLOYEE_L SYS_REFCURSOR;
BEGIN
    OPEN EMPLOYEE_L FOR
    SELECT * FROM  EMPLOYEE
    WHERE BIRTHDATE > '31-DEC-68';
    RETURN EMPLOYEE_L;
END;
/
SELECT EMPLOYEE_LIST() FROM DUAL;

--4.1 Basic Stored Procedure
--Task – Create a stored procedure that selects the first and last names of all the employees.
CREATE OR REPLACE PROCEDURE EMPLOYEE_NAME( NAMES OUT SYS_REFCURSOR)
IS
BEGIN 
    OPEN NAMES FOR SELECT FIRSTNAME, LASTNAME FROM EMPLOYEE;
END;
/

--TESTING THE PROCEDURE
DECLARE
NAMES SYS_REFCURSOR;
FIRSTNAME EMPLOYEE.FIRSTNAME%TYPE; 
LASTNAME EMPLOYEE.LASTNAME%TYPE;
BEGIN
    EMPLOYEE_NAME(NAMES);
    LOOP
    FETCH NAMES INTO FIRSTNAME, LASTNAME; 
    EXIT WHEN NAMES%NOTFOUND;
    DBMS_OUTPUT.PUT_LINE('First Name : '||FIRSTNAME||', Last Name: '||LASTNAME);
    END LOOP;
    CLOSE NAMES;
END;

--4.2 Stored Procedure Input Parameters
--Task – Create a stored procedure that updates the personal information of an employee.
CREATE OR REPLACE PROCEDURE UPDATE_EMPLOYEE(EMP_ID IN NUMBER, LAST_NAME IN VARCHAR2, FIRST_NAME IN VARCHAR2, EMP_ADD IN VARCHAR2, EMP_CITY IN VARCHAR2, EMP_STATE IN VARCHAR2, EMP_COUNTRY IN VARCHAR2, EMP_ZIPCODE IN VARCHAR2, EMP_PNUM IN VARCHAR2, EMP_FAX IN VARCHAR2, EMP_EMAIL IN VARCHAR2)
IS
BEGIN
    UPDATE EMPLOYEE SET LASTNAME = LAST_NAME, FIRSTNAME = FIRST_NAME, 
        ADDRESS = EMP_ADD, CITY =  EMP_CITY, STATE = EMP_STATE, COUNTRY = EMP_COUNTRY, POSTALCODE = EMP_ZIPCODE, PHONE = EMP_PNUM, FAX = EMP_FAX, EMAIL = EMP_EMAIL
        WHERE EMPLOYEEID = EMP_ID;
        COMMIT;
END;
/
--Task – Create a stored procedure that returns the managers of an employee.
CREATE OR REPLACE PROCEDURE GET_MANAGER (EMP_ID IN NUMBER, MEN_ID OUT NUMBER)
IS
BEGIN 
    SELECT REPORTSTO INTO MEN_ID FROM EMPLOYEE
    WHERE EMPLOYEEID = EMP_ID;
END;
--CHEHCKING THE GET_MANAGER
DECLARE
    EMP_ID EMPLOYEE.EMPLOYEEID%TYPE;
    MEN_ID EMPLOYEE.REPORTSTO%TYPE;
BEGIN
    GET_MANAGER(2,MEN_ID);
    DBMS_OUTPUT.PUT_LINE(MEN_ID);
END;
--4.3 Stored Procedure Output Parameters
--Task – Create a stored procedure that returns the name and company of a customer.
CREATE OR REPLACE PROCEDURE CUSTOMER_INFO (CUS_ID IN NUMBER, CUS_F_NAME OUT VARCHAR2, CUS_L_NAME OUT VARCHAR2, COM_NAME OUT VARCHAR2)
IS
BEGIN
    SELECT FIRSTNAME INTO CUS_F_NAME FROM CUSTOMER
    WHERE CUSTOMERID = CUS_ID;
    SELECT LASTNAME INTO CUS_L_NAME FROM CUSTOMER
    WHERE CUSTOMERID = CUS_ID;
    SELECT COMPANY INTO COM_NAME FROM CUSTOMER
    WHERE CUSTOMERID = CUS_ID;
END;
/
--TESTING THE CUSTOMER_INFO
DECLARE
    CUS_ID CUSTOMER.CUSTOMERID%TYPE;
    CUS_F_NAME CUSTOMER.FIRSTNAME%TYPE;
    CUS_L_NAME CUSTOMER.LASTNAME%TYPE;
    COM_NAME CUSTOMER.COMPANY%TYPE;
BEGIN
    CUSTOMER_INFO(1, CUS_F_NAME, CUS_L_NAME, COM_NAME);
    DBMS_OUTPUT.PUT_LINE('Customer Name: '||CUS_F_NAME||' '||CUS_L_NAME||' Company: '||COM_NAME); --To test it. 
END;

--5.0 Transactions
--In this section you will be working with transactions. Transactions are usually nested within a stored procedure.
--Task – Create a transaction that given a invoiceId will delete that invoice (There may be constraints that rely on this, find out how to resolve them).
CREATE OR REPLACE PROCEDURE DELETE_INVOICE (INV_ID IN NUMBER)
IS
BEGIN
    DELETE FROM INVOICELINE
    WHERE INVOICEID = INV_ID;
    
    DELETE FROM INVOICE
    WHERE INVOICEID = INV_ID;
END;
/
EXECUTE DELETE_INVOICE (213);
--6.1 AFTER/FOR
--Task - Create an after insert trigger on the employee table fired after a new record is inserted into the table.
CREATE OR REPLACE TRIGGER AFTER_INSERT
AFTER INSERT ON EMPLOYEE
BEGIN
    DBMS_OUTPUT.PUT_LINE('a new record is inserted into the table!');
END;
--TESTING AFTER_INSERT
INSERT INTO EMPLOYEE(EMPLOYEEID,LASTNAME,FIRSTNAME) VALUES (10001,'TEST','TEST');
--Task – Create an after update trigger on the album table that fires after a row is inserted in the table
CREATE OR REPLACE TRIGGER AFTER_INSERT_ALBUM
AFTER INSERT ON ALBUM
BEGIN
    DBMS_OUTPUT.PUT_LINE('A new record is inserted into the table!');
END;
--TESTING AFTER_INSERT
INSERT INTO ALBUM VALUES (779,'TEST',1);
--Task – Create an after delete trigger on the customer table that fires after a row is deleted from the table.
CREATE OR REPLACE TRIGGER AFTER_DELETE
AFTER DELETE ON CUSTOMER
BEGIN
    DBMS_OUTPUT.PUT_LINE('A new record has been deleted!');
END;
--TESTING AFTER_DELETE
DELETE FROM CUSTOMER
WHERE CUSTOMERID = 10001;
--7.1 INNER
--Task – Create an inner join that joins customers and orders and specifies the name of the customer and the invoiceId.X

SELECT FIRSTNAME , LASTNAME , INVOICEID FROM CUSTOMER C_ID
    JOIN INVOICE I_ID ON C_ID.CUSTOMERID = I_ID.CUSTOMERID;

--7.2 OUTER
--Task – Create an outer join that joins the customer and invoice table, specifying the CustomerId, firstname, lastname, invoiceId, and total.
SELECT FIRSTNAME, LASTNAME, INVOICEID, TOTAL FROM CUSTOMER C_ID
    FULL JOIN INVOICE I_ID ON C_ID.CUSTOMERID = I_ID.CUSTOMERID;
--7.3 RIGHT
--Task – Create a right join that joins album and artist specifying artist name and title.
SELECT NAME, TITLE FROM ALBUM A_ID
RIGHT JOIN ARTIST AR_ID ON A_ID.ARTISTID = AR_ID.ARTISTID;
--7.4 CROSS
--Task – Create a cross join that joins album and artist and sorts by artist name in ascending order.
SELECT NAME, TITLE FROM ALBUM  A_ID
CROSS JOIN ARTIST AR_ID;
--7.5 SELF
--Task – Perform a self-join on the employee table, joining on the reportsto column.
SELECT
    (A.FIRSTNAME || ' ' || A.LASTNAME) EMPLOYEE,
    (B.FIRSTNAME || ' ' || B.LASTNAME) REPORTSTO
    FROM EMPLOYEE A
    LEFT JOIN EMPLOYEE B ON A.REPORTSTO = B.EMPLOYEEID;
