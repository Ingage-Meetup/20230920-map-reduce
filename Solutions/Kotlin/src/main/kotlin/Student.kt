class Student(val name: String, val grades: List<Int>) {
    val averageGrade: Double
        get() {
            if (grades.isEmpty()) {
                return 0.0
            }
            var sum = 0.0
            for (grade in grades) {
                sum += grade
            }
            return sum / grades.size
        }

    val letterGrade: String
        get() {
            val averageGrade = averageGrade
            return when {
                averageGrade >= 90 -> "A"
                averageGrade >= 80 -> "B"
                averageGrade >= 70 -> "C"
                averageGrade >= 60 -> "D"
                else -> "F"
            }
        }
}

class StudentTracker {
    private val students = mutableListOf<Student>()

    val studentCount: Int
        get() = students.size

    fun addStudent(name: String, grades: List<Int>): Student {
        val student = Student(name, grades)
        students.add(student)
        return student
    }

    fun getStudentsWithLetterGrade(letterGrade: String): List<Student> {
        val studentsWithLetterGrade = mutableListOf<Student>()
        for (student in students) {
            if (student.letterGrade == letterGrade) {
                studentsWithLetterGrade.add(student)
            }
        }
        return studentsWithLetterGrade
    }
}
