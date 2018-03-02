import java.util.ArrayList;
import java.util.stream.Collectors;

public class School {

    public ArrayList<ArrayList<Student>> sortByGrade(double grade) {
        ArrayList<ArrayList<Student>> sortedStudents = new ArrayList<>();

        ArrayList<Student> above = Student.students.stream()
                                    .filter(student -> student.getGrade() < grade)
                                    .collect(Collectors.toCollection(ArrayList::new));
        ArrayList<Student> below = Student.students.stream()
                                    .filter(student -> student.getGrade() > grade)
                                    .collect(Collectors.toCollection(ArrayList::new));

        sortedStudents.add(above);
        sortedStudents.add(below);

        return sortedStudents;
    }

    public boolean studentsNotPreparedAndShould() {
        return Student.students.stream().anyMatch(student -> !student.isPrepared() && student.age >= 18);
    }

    public ArrayList<Student> passedSubjectBetweent(String subject, double min, double max) {
        return Student.students.stream()
                .filter(s -> s.subjects.get(subject) >= min && s.subjects.get(subject) <= max )
                .collect(Collectors.toCollection(ArrayList::new));
    }
}
