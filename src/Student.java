import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.OptionalDouble;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class Student {

    public static ArrayList<Student> students = new ArrayList<>();

    public int age;
    private double grade;
    public HashMap<String, Double> subjects = new HashMap<>();
    public String[] subjectNames = new String[]{
            "Maths", "Physics", "IT", "Chemistry", "Biology", "Foreign Language", "Literature", "Philosophy", "Music"
    };

    public Student() {
        Student.students.add(this);
        for (String subject : subjectNames) {
            subjects.put(subject, 0.0);
        }
    }

    public void setGrade(double grade) {
        this.grade = grade;
    }

    public void setAVG(double grade) {
        for (String subject : subjectNames) {
            subjects.put(subject, grade);
        }
    }

    private boolean validGrade(double grade) {
        return grade > 0 && grade <= 10;
    }

    public Double getAVG() {
        return subjects.values().stream().mapToDouble(Double::doubleValue).average().getAsDouble();
    }

    private boolean isCourseAproved() {
        return subjects.values().stream().noneMatch(s -> s < 5.0);
    }

    public void setSubjectGrade(String subject, Double grade) {
        if(validGrade(grade)) {
            subjects.replace(subject, grade);
        }
    }

    public double getGrade() {
        return grade;
    }

    public boolean isPrepared() {
        return isCourseAproved() && getAVG() > 7.0;
    }

    /**
     * Get the first student from the list that has greater average grade than this.
     * @return
     */
    public Student isMorePrepared() {
        return Student.students.stream().filter(s -> s.getAVG() > this.getAVG()).findFirst().get();
    }

    /**
     * Get the grades from this student, get the grades from the "compare" student and return the comparison value.
     * @param compare
     * @return
     */
    public boolean sameGradesAs(Student compare) {
        ArrayList<Double> grades = this.subjects.values().stream().collect(Collectors.toCollection(ArrayList::new));
        ArrayList<Double> gradesToCompare = compare.subjects.values().stream().collect(Collectors.toCollection(ArrayList::new));
        return grades.equals(gradesToCompare);
    }

}
