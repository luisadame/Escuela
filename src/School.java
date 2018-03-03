import java.util.ArrayList;
import java.util.OptionalDouble;
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

    /**
     * Calculate if the students in the given school have at max 2 points less in the avg
     * than the students that are prepared.
     * @return
     */
    public boolean isLeveledHighSchool() {
        // Get the average from those who are prepared.
        OptionalDouble avgFromPrepared = Student.students.stream().filter(Student::isPrepared)
                                    .mapToDouble(Student::getAVG).average();
        // Get the average from those who are not prepared.
        OptionalDouble avgFromNotPrepared = Student.students.stream().filter(s -> !s.isPrepared())
                .mapToDouble(Student::getAVG).average();
        // See if they differ more than two points between.
        if (avgFromPrepared.isPresent() && avgFromNotPrepared.isPresent()) {
            return (avgFromPrepared.getAsDouble() - avgFromNotPrepared.getAsDouble()) < 2.0;
        }
        return false;
    }
}
