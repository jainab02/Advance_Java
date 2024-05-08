// Model
public class Student {
    private String studentId;
    private String enrollmentNumber;
    private String semester;
    private double spi;

    public Student(String studentId, String enrollmentNumber, String semester) {
        this.studentId = studentId;
        this.enrollmentNumber = enrollmentNumber;
        this.semester = semester;
        this.spi = 0.0;
    }

    public void calculateSpi(double[] grades) {
        double totalGradePoints = 0;
        for (double grade : grades) {
            totalGradePoints += grade;
        }
        this.spi = totalGradePoints / grades.length;
    }

    // Getters and Setters
    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getEnrollmentNumber() {
        return enrollmentNumber;
    }

    public void setEnrollmentNumber(String enrollmentNumber) {
        this.enrollmentNumber = enrollmentNumber;
    }

    public String getSemester() {
        return semester;
    }

    public void setSemester(String semester) {
        this.semester = semester;
    }

    public double getSpi() {
        return spi;
    }

    public void setSpi(double spi) {
        this.spi = spi;
    }
}

