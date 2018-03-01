import java.util.ArrayList;

public class Student {

    public static ArrayList<Student> students = new ArrayList<>();

    private double grade;

    public Student() {
        students.add(this);
    }

    public void setGrade(double grade) {
        this.grade = grade;
    }

    public double getGrade() {
        return grade;
    }

}
