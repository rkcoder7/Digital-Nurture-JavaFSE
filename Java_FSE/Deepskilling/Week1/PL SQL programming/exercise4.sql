CREATE OR REPLACE FUNCTION CalculateAge(p_dob DATE) RETURN NUMBER IS
BEGIN
RETURN TRUNC(MONTHS_BETWEEN(SYSDATE,p_dob)/12);
END;
/
CREATE OR REPLACE FUNCTION CalculateMonthlyInstallment(p_amt NUMBER,p_rate NUMBER,p_years NUMBER) RETURN NUMBER IS
BEGIN
RETURN (p_amt+(p_amt*p_rate*p_years/100))/(p_years*12);
END;
/
CREATE OR REPLACE FUNCTION HasSufficientBalance(p_acc NUMBER,p_amt NUMBER) RETURN VARCHAR2 IS
v_bal NUMBER;
BEGIN
SELECT Balance INTO v_bal FROM Accounts WHERE AccountID=p_acc;
IF v_bal>=p_amt THEN RETURN 'TRUE'; ELSE RETURN 'FALSE'; END IF;
END;
/
SELECT CustomerID,CalculateAge(DOB) AGE FROM Customers;
SELECT AccountID,Balance FROM Accounts;
