import java.util.ArrayList;
import java.util.List;

public class StudentTracker {
    private List<Student> students;

    public StudentTracker() {
        this.students = new ArrayList<>();
    }

    public int getStudentCount() {
        return students.size();
    }

    public Student addStudent(String name, List<Integer> grades) {
        Student student = new Student(name, grades);
        students.add(student);
        return student;
    }

    public List<Student> getStudentsWithLetterGrade(String letterGrade) {
        List<Student> studentsWithLetterGrade = new ArrayList<>();
        for (Student student : students) {
            if (student.getLetterGrade().equals(letterGrade)) {
                studentsWithLetterGrade.add(student);
            }
        }
        return studentsWithLetterGrade;
    }
}
