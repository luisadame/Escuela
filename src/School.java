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

}
