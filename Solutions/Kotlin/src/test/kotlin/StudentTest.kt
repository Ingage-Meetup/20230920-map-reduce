import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

class StudentTest {

    @Nested
    inner class `Student Class` {
        @Test
        fun `should calculate the average grade correctly`() {
            val mikey = Student("Mikey", listOf(85, 90, 78))
            assertEquals(84.33, mikey.averageGrade, 0.01)
        }

        @Test
        fun `should return the correct letter grade`() {
            val mikey = Student("Mikey", listOf(95, 92, 98))
            val brand = Student("Brand", listOf(80, 88, 76))
            val chunk = Student("Chunk", listOf(75, 70, 68))
            val mouth = Student("Mouth", listOf(65, 61, 58))
            val troy = Student("Troy", listOf(55, 62, 59))

            assertEquals("A", mikey.letterGrade)
            assertEquals("B", brand.letterGrade)
            assertEquals("C", chunk.letterGrade)
            assertEquals("D", mouth.letterGrade)
            assertEquals("F", troy.letterGrade)
        }
    }

    @Nested
    inner class `StudentTracker Class` {
        @Test
        fun `should add a student to the tracker`() {
            val tracker = StudentTracker()
            tracker.addStudent("Andy", listOf(92, 88, 95))
            assertEquals(1, tracker.studentCount)
        }

        @Test
        fun `should get students with a specific letter grade`() {
            val tracker = StudentTracker()
            val mikey = tracker.addStudent("Mikey", listOf(95, 92, 98))
            val chunk = tracker.addStudent("Chunk", listOf(75, 70, 68))
            val mouth = tracker.addStudent("Mouth", listOf(65, 61, 58))
            val brand = tracker.addStudent("Brand", listOf(85, 82, 88))
            val stef = tracker.addStudent("Stef", listOf(91, 89, 93))
            val troy = tracker.addStudent("Troy", listOf(55, 62, 59))

            val gradeAStudents = tracker.getStudentsWithLetterGrade("A")
            val gradeBStudents = tracker.getStudentsWithLetterGrade("B")
            val gradeCStudents = tracker.getStudentsWithLetterGrade("C")
            val gradeDStudents = tracker.getStudentsWithLetterGrade("D")
            val gradeFStudents = tracker.getStudentsWithLetterGrade("F")

            assertEquals(2, gradeAStudents.size)
            assertEquals(true, gradeAStudents.contains(mikey))
            assertEquals(true, gradeAStudents.contains(stef))

            assertEquals(1, gradeBStudents.size)
            assertEquals(true, gradeBStudents.contains(brand))

            assertEquals(1, gradeCStudents.size)
            assertEquals(true, gradeCStudents.contains(chunk))

            assertEquals(1, gradeDStudents.size)
            assertEquals(true, gradeDStudents.contains(mouth))

            assertEquals(1, gradeFStudents.size)
            assertEquals(true, gradeFStudents.contains(troy))
        }
    }
}
