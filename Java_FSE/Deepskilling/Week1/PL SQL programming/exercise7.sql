CREATE OR REPLACE PACKAGE CustomerManagement AS
PROCEDURE AddCustomer(p_id NUMBER,p_name VARCHAR2);
PROCEDURE UpdateCustomer(p_id NUMBER,p_name VARCHAR2);
FUNCTION GetBalance(p_id NUMBER) RETURN NUMBER;
END;
/
CREATE OR REPLACE PACKAGE BODY CustomerManagement AS
PROCEDURE AddCustomer(p_id NUMBER,p_name VARCHAR2) IS BEGIN INSERT INTO Customers(CustomerID,Name) VALUES(p_id,p_name); END;
PROCEDURE UpdateCustomer(p_id NUMBER,p_name VARCHAR2) IS BEGIN UPDATE Customers SET Name=p_name WHERE CustomerID=p_id; END;
FUNCTION GetBalance(p_id NUMBER) RETURN NUMBER IS v NUMBER; BEGIN SELECT Balance INTO v FROM Customers WHERE CustomerID=p_id; RETURN v; END;
END;
/
SELECT * FROM Customers;
