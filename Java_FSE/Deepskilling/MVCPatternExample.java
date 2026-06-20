
public class MVCPatternExample {
    public static void main(String[] args) {
        // Create model
        Student student = new Student();
        student.setName("Mohan B");
        student.setId(102);
        student.setGrade("A");
        StudentView view = new StudentView();
        StudentController controller = new StudentController(student, view);
        controller.updateView();

        System.out.println("\nUpdating student record through the controller...\n");
        controller.setStudentName("Mohan B Updated");
        controller.setStudentGrade("A+");
        controller.updateView();
    }
}
class Student {

    private String name;
    private long id;
    private String grade;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }
}

/** View - responsible only for presenting data, has no idea where the data came from. */
class StudentView {

    public void displayStudentDetails(String name, long id, String grade) {
        System.out.println("Student Details");
        System.out.println("----------------");
        System.out.println("Name  : " + name);
        System.out.println("ID    : " + id);
        System.out.println("Grade : " + grade);
    }
}

/** Controller - mediates between Model and View; the only piece that talks to both. */
class StudentController {

    private final Student model;
    private final StudentView view;

    public StudentController(Student model, StudentView view) {
        this.model = model;
        this.view = view;
    }

    public void setStudentName(String name) {
        model.setName(name);
    }

    public void setStudentId(long id) {
        model.setId(id);
    }

    public void setStudentGrade(String grade) {
        model.setGrade(grade);
    }

    public String getStudentName() {
        return model.getName();
    }

    public long getStudentId() {
        return model.getId();
    }

    public String getStudentGrade() {
        return model.getGrade();
    }

    public void updateView() {
        view.displayStudentDetails(model.getName(), model.getId(), model.getGrade());
    }
}
