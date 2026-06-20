BEGIN
 FOR c IN (SELECT CustomerID,DOB FROM Customers) LOOP
  IF TRUNC(MONTHS_BETWEEN(SYSDATE,c.DOB)/12) > 60 THEN
   UPDATE Loans SET InterestRate=InterestRate-1 WHERE CustomerID=c.CustomerID;
  END IF;
 END LOOP;

 FOR v IN (SELECT CustomerID,Balance FROM Customers) LOOP
  IF v.Balance > 10000 THEN
   UPDATE Customers SET IsVIP='TRUE' WHERE CustomerID=v.CustomerID;
  END IF;
 END LOOP;

 FOR l IN (SELECT LoanID,CustomerID FROM Loans WHERE EndDate BETWEEN SYSDATE AND SYSDATE+30) LOOP
   DBMS_OUTPUT.PUT_LINE('Reminder for Customer '||l.CustomerID);
 END LOOP;
END;
/
SELECT * FROM Customers;
SELECT * FROM Loans;
