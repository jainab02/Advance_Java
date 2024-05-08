public class Main {
    public static void main(String[] args) {
        Student model = new Student("", "", "");
        StudentView view = new StudentView();
        StudentController controller = new StudentController(model, view);

        // Add a new student
        double[] grades = {9,8,4,6,6.8,7,6};
        controller.addStudent("02", "200180107002", "6th", grades);

        // Retrieve a student's information
        controller.getStudent("02");
    }
}
