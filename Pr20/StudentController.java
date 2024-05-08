// Controller
public class StudentController {
    private Student model;
    private StudentView view;

    public StudentController(Student model, StudentView view) {
        this.model = model;
        this.view = view;
    }

    public void addStudent(String studentId, String enrollmentNumber, String semester, double[] grades) {
        Student student = new Student(studentId, enrollmentNumber, semester);
        student.calculateSpi(grades);
        model = student;
    }

    public void getStudent(String studentId) {
        if (model.getStudentId().equals(studentId)) {
            view.displayStudentDetails(model);
        } else {
            view.displayErrorMessage("Student not found.");
        }
    }
}
