package com.cognizant.DataStructure;

public class EmployeeManagement {

    static Employee[] employees =
            new Employee[100];

    static int count = 0;

    // Add Employee
    public static void addEmployee(Employee emp) {

        employees[count++] = emp;
    }

    // Display Employees
    public static void displayEmployees() {

        for(int i=0;i<count;i++) {
            System.out.println(employees[i]);
        }
    }

    // Search Employee
    public static Employee searchEmployee(int id) {

        for(int i=0;i<count;i++) {

            if(employees[i].employeeId == id)
                return employees[i];
        }

        return null;
    }

    // Delete Employee
    public static void deleteEmployee(int id) {

        int index = -1;

        for(int i=0;i<count;i++) {

            if(employees[i].employeeId == id) {
                index = i;
                break;
            }
        }

        if(index != -1) {

            for(int i=index;i<count-1;i++) {
                employees[i] = employees[i+1];
            }

            count--;
        }
    }

    public static void main(String[] args) {

        addEmployee(
                new Employee(101,
                        "Ram",
                        "Developer",
                        50000));

        addEmployee(
                new Employee(102,
                        "Arun",
                        "Tester",
                        40000));

        System.out.println("Employees");

        displayEmployees();

        System.out.println("\nSearch");

        System.out.println(
                searchEmployee(102));

        deleteEmployee(101);

        System.out.println("\nAfter Delete");

        displayEmployees();
    }
}