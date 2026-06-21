package com.mvc;
public class MVCPatternTest {
    public static void main(String[] args) {

        Student model = new Student();
        model.setName("John");
        model.setId("S101");

        StudentView view = new StudentView();

        StudentController controller =
                new StudentController(model, view);

        System.out.println("Initial Data:");
        controller.updateView();

        System.out.println();

        controller.setStudentName("David");
        controller.setStudentId("S102");

        System.out.println("Updated Data:");
        controller.updateView();
    }
}