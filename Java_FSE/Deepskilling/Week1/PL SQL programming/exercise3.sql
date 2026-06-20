CREATE OR REPLACE PROCEDURE ProcessMonthlyInterest AS
BEGIN
UPDATE Accounts SET Balance=Balance*1.01 WHERE AccountType='Savings';
END;
/
CREATE OR REPLACE PROCEDURE UpdateEmployeeBonus(p_dept VARCHAR2,p_bonus NUMBER) AS
BEGIN
UPDATE Employees SET Salary=Salary+(Salary*p_bonus/100) WHERE Department=p_dept;
END;
/
CREATE OR REPLACE PROCEDURE TransferFunds(p_from NUMBER,p_to NUMBER,p_amt NUMBER) AS
v_bal NUMBER;
BEGIN
SELECT Balance INTO v_bal FROM Accounts WHERE AccountID=p_from;
IF v_bal>=p_amt THEN
UPDATE Accounts SET Balance=Balance-p_amt WHERE AccountID=p_from;
UPDATE Accounts SET Balance=Balance+p_amt WHERE AccountID=p_to;
END IF;
END;
/
BEGIN
ProcessMonthlyInterest;
UpdateEmployeeBonus('IT',5);
TransferFunds(1,2,100);
END;
/
SELECT * FROM Accounts;
SELECT * FROM Employees;
