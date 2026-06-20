CREATE OR REPLACE TRIGGER UpdateCustomerLastModified
BEFORE UPDATE ON Customers
FOR EACH ROW
BEGIN
:NEW.LastModified:=SYSDATE;
END;
/
CREATE OR REPLACE TRIGGER LogTransaction
AFTER INSERT ON Transactions
FOR EACH ROW
BEGIN
INSERT INTO AuditLog(TransactionID,LogDate,Action)
VALUES(:NEW.TransactionID,SYSDATE,'Transaction Inserted');
END;
/
CREATE OR REPLACE TRIGGER CheckTransactionRules
BEFORE INSERT ON Transactions
FOR EACH ROW
DECLARE
v_bal NUMBER;
BEGIN
SELECT Balance INTO v_bal FROM Accounts WHERE AccountID=:NEW.AccountID;
IF :NEW.TransactionType='Withdrawal' AND :NEW.Amount>v_bal THEN
RAISE_APPLICATION_ERROR(-20002,'Withdrawal exceeds balance');
END IF;
IF :NEW.TransactionType='Deposit' AND :NEW.Amount<=0 THEN
RAISE_APPLICATION_ERROR(-20003,'Invalid deposit');
END IF;
END;
/
UPDATE Customers SET Balance=Balance+100 WHERE CustomerID=1;
INSERT INTO Transactions VALUES(10,1,SYSDATE,100,'Deposit');
SELECT * FROM Customers;
SELECT * FROM AuditLog;
