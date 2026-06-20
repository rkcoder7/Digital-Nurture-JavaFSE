package com.cognizant.DataStructure;

public class TaskManagement {

    Task head;
    public void addTask(
            int id,
            String name,
            String status) {

        Task newTask =
                new Task(id,name,status);

        newTask.next = head;

        head = newTask;
    }

    public void displayTasks() {

        Task temp = head;

        while(temp != null) {

            System.out.println(
                    temp.taskId + " "
                    + temp.taskName + " "
                    + temp.status);

            temp = temp.next;
        }
    }

    public Task searchTask(int id) {

        Task temp = head;

        while(temp != null) {

            if(temp.taskId == id)
                return temp;

            temp = temp.next;
        }

        return null;
    }

    // Delete
    public void deleteTask(int id) {

        if(head == null)
            return;

        if(head.taskId == id) {
            head = head.next;
            return;
        }

        Task temp = head;

        while(temp.next != null) {

            if(temp.next.taskId == id) {

                temp.next =
                        temp.next.next;

                return;
            }

            temp = temp.next;
        }
    }

    public static void main(String[] args) {

        TaskManagement tm =
                new TaskManagement();

        tm.addTask(
                1,
                "Coding",
                "Pending");

        tm.addTask(
                2,
                "Testing",
                "Completed");

        tm.displayTasks();

        System.out.println("\nSearch");

        Task t =
                tm.searchTask(1);

        if(t != null)
            System.out.println(t.taskName);

        tm.deleteTask(1);

        System.out.println("\nAfter Delete");

        tm.displayTasks();
    }
}