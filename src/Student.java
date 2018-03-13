import org.w3c.dom.ranges.RangeException;

import java.util.*;
import java.util.stream.Collectors;

public class Student {

    public static ArrayList<Student> students = new ArrayList<>();

    public int age;
    private double grade;
    private GregorianCalendar atSchoolSince;
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


    /**
     * Set the same grade for every subject.
     * @param grade double
     */
    public void setAVG(double grade) {
        if(!validGrade(grade)) return;
        for (String subject : subjectNames) {
            subjects.put(subject, grade);
        }
    }

    public void setAtSchoolSince(int day, int month, int year) {
        this.atSchoolSince = new GregorianCalendar(year, month - 1, day);
    }

    public void setSubjectGrade(String subject, Double grade) {
        if(validGrade(grade)) {
            subjects.replace(subject, grade);
        }
    }

    /**
     * Get the average of the subjects from a student.
     * @return double
     */
    public double getAVG() {
        return subjects.values().stream().mapToDouble(Double::doubleValue).average().getAsDouble();
    }

    public double getGrade() {
        return grade;
    }

    private boolean validGrade(double grade) {
        return grade > 0.00 && grade <= 10.00;
    }

    /**
     * Check if a student's course is approved.
     * @return boolean
     */
    protected boolean isCourseApproved() {
        return subjects.values().stream().noneMatch(s -> s < 5.0);
    }

    /**
     * Check if a student is prepared.
     * @return boolean
     */
    public boolean isPrepared() {
        return isCourseApproved() && getAVG() > 7.0 && getAVG() <= 10.0;
    }

    /**
     * Get the first student from the list that has greater average grade than this.
     * @return Student
     */
    public Student isMorePrepared() {
        try {
            return Student.students.stream()
                    .filter(Objects::nonNull)
                    .filter(s -> s.getAVG() > this.getAVG()).findFirst().get();
        } catch (NoSuchElementException e) {
            return null;
        }
    }

    /**
     * Get the grades from this student, get the grades from the "compare" student and return the comparison value.
     * @param compare Student
     * @return boolean
     */
    public boolean sameGradesAs(Student compare) {
        ArrayList<Double> grades = this.subjects.values().stream().collect(Collectors.toCollection(ArrayList::new));
        ArrayList<Double> gradesToCompare = compare.subjects.values().stream().collect(Collectors.toCollection(ArrayList::new));
        return grades.equals(gradesToCompare);
    }

    /**
     * Calculates how many days has been a student in the school.
     * @param date Given date
     * @return String
     */
    public String howLongInSchool(GregorianCalendar date) {
        if(atSchoolSince == null) return null;
        int daysStart = (int) (atSchoolSince.getTimeInMillis() / (1000 * 60 * 60 * 24));
        int daysEnd = (int) (date.getTimeInMillis() / (1000 * 60 * 60 * 24));
        int diff = daysEnd - daysStart < 0 ? 0 : daysEnd - daysStart;
        return diff > 1 ? diff + " days" : diff + " day";
    }

}
