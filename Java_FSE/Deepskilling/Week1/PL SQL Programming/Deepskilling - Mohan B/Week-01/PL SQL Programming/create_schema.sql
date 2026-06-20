CREATE TABLE Customers (
    CustomerID   NUMBER PRIMARY KEY,
    Name         VARCHAR2(100),
    DOB          DATE,
    Balance      NUMBER(15,2),
    LastModified DATE
);
 
CREATE TABLE Accounts (
    AccountID    NUMBER PRIMARY KEY,
    CustomerID   NUMBER,
    AccountType  VARCHAR2(20),
    Balance      NUMBER(15,2),
    LastModified DATE,
    FOREIGN KEY (CustomerID) REFERENCES Customers(CustomerID)
);
 
CREATE TABLE Transactions (
    TransactionID   NUMBER PRIMARY KEY,
    AccountID       NUMBER,
    TransactionDate DATE,
    Amount          NUMBER(15,2),
    TransactionType VARCHAR2(10),
    FOREIGN KEY (AccountID) REFERENCES Accounts(AccountID)
);
 
CREATE TABLE Loans (
    LoanID       NUMBER PRIMARY KEY,
    CustomerID   NUMBER,
    LoanAmount   NUMBER(15,2),
    InterestRate NUMBER(5,2),
    StartDate    DATE,
    EndDate      DATE,
    FOREIGN KEY (CustomerID) REFERENCES Customers(CustomerID)
);
 
CREATE TABLE Employees (
    EmployeeID NUMBER PRIMARY KEY,
    Name       VARCHAR2(100),
    Position   VARCHAR2(50),
    Salary     NUMBER(15,2),
    Department VARCHAR2(50),
    HireDate   DATE
);
 
CREATE TABLE AuditLog (
    LogID           NUMBER GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    TransactionID   NUMBER,
    AccountID       NUMBER,
    TransactionDate DATE,
    Amount          NUMBER(15,2),
    TransactionType VARCHAR2(10),
    LoggedAt        DATE
);
