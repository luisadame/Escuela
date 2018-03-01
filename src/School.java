import java.util.ArrayList;

public class School {

    public ArrayList<ArrayList<Student>> sortByGrade(double grade) {
        ArrayList<ArrayList<Student>> sortedStudents = new ArrayList<>();
        ArrayList<Student> above = new ArrayList<>();
        ArrayList<Student> below = new ArrayList<>();

        for (Student student : Student.students) {
            if(student.getGrade() < grade) {
                below.add(student);
            } else if (student.getGrade() > grade) {
                above.add(student);
            }
        }

        sortedStudents.add(above);
        sortedStudents.add(below);

        return sortedStudents;
    }

}
