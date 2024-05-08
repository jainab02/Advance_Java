public class StudentView {
    public void displayStudentDetails(Student student) {
        System.out.println("Student ID: " + student.getStudentId());
        System.out.println("Enrollment Number: " + student.getEnrollmentNumber());
        System.out.println("Semester: " + student.getSemester());
        System.out.println("SPI: " + student.getSpi());
    }

    public void displayErrorMessage(String message) {
        System.out.println("Error: " + message);
    }
}