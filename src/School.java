import java.util.ArrayList;
import java.util.Objects;
import java.util.OptionalDouble;
import java.util.stream.Collectors;

public class School {

    /**
     * Returns an array of two arrays that contains the below and above grades
     * from a given grade.
     * @param grade double
     * @return Array of arrays of students
     */
    public ArrayList<ArrayList<Student>> sortByGrade(double grade) {
        ArrayList<ArrayList<Student>> sortedStudents = new ArrayList<>();

        ArrayList<Student> above = Student.students.stream()
                                    .filter(Objects::nonNull)
                                    .filter(student -> student.getGrade() < grade)
                                    .collect(Collectors.toCollection(ArrayList::new));
        ArrayList<Student> below = Student.students.stream()
                                    .filter(Objects::nonNull)
                                    .filter(student -> student.getGrade() > grade)
                                    .collect(Collectors.toCollection(ArrayList::new));

        sortedStudents.add(above);
        sortedStudents.add(below);

        return sortedStudents;
    }

    /**
     * Check if there are students who are not prepared and are older or equal to 18.
     * @return boolean
     */
    public boolean studentsNotPreparedAndShould() {
        return Student.students.stream().filter(Objects::nonNull).anyMatch(student -> !student.isPrepared() && student.age >= 18);
    }

    /**
     * Returns an array of students who passed a subject between two grades.
     * @param subject String
     * @param min int
     * @param max int
     * @return ArrayList of Student
     */
    public ArrayList<Student> passedSubjectBetween(String subject, double min, double max) {
        return Student.students.stream()
                .filter(s -> s.subjects.get(subject) >= min && s.subjects.get(subject) <= max )
                .collect(Collectors.toCollection(ArrayList::new));
    }

    /**
     * Calculate if the students in the given school have at max 2 points less in the avg
     * than the students that are prepared.
     * @return boolean
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
        } else return !avgFromNotPrepared.isPresent() && avgFromPrepared.isPresent();
    }
}
