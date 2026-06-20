CREATE OR REPLACE PROCEDURE SafeTransferFunds(p_from NUMBER,p_to NUMBER,p_amt NUMBER) AS
v_bal NUMBER;
BEGIN
SELECT Balance INTO v_bal FROM Accounts WHERE AccountID=p_from;
IF v_bal<p_amt THEN
RAISE_APPLICATION_ERROR(-20001,'Insufficient Funds');
END IF;
UPDATE Accounts SET Balance=Balance-p_amt WHERE AccountID=p_from;
UPDATE Accounts SET Balance=Balance+p_amt WHERE AccountID=p_to;
COMMIT;
EXCEPTION
WHEN OTHERS THEN
ROLLBACK;
DBMS_OUTPUT.PUT_LINE(SQLERRM);
END;
/
CREATE OR REPLACE PROCEDURE UpdateSalary(p_emp NUMBER,p_pct NUMBER) AS
BEGIN
UPDATE Employees SET Salary=Salary+(Salary*p_pct/100) WHERE EmployeeID=p_emp;
IF SQL%ROWCOUNT=0 THEN
RAISE NO_DATA_FOUND;
END IF;
EXCEPTION
WHEN NO_DATA_FOUND THEN
DBMS_OUTPUT.PUT_LINE('Employee not found');
END;
/
CREATE OR REPLACE PROCEDURE AddNewCustomer(p_id NUMBER,p_name VARCHAR2) AS
BEGIN
INSERT INTO Customers(CustomerID,Name) VALUES(p_id,p_name);
EXCEPTION
WHEN DUP_VAL_ON_INDEX THEN
DBMS_OUTPUT.PUT_LINE('Customer already exists');
END;
/
BEGIN
UpdateSalary(1,10);
END;
/
SELECT * FROM Employees;
