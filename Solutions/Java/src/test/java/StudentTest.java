import java.util.List;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import static org.junit.jupiter.api.Assertions.*;

class StudentTest {

    @Nested
    class StudentClassTests {
        Student mikey;

        @BeforeEach
        void setUp() {
            mikey = new Student("Mikey", List.of(85, 90, 78));
        }

        @Test
        void shouldCalculateAverageGradeCorrectly() {
            assertEquals(84.33, mikey.getAverageGrade(), 0.01);
        }

        @Test
        void shouldReturnCorrectLetterGrade() {
            assertEquals("B", mikey.getLetterGrade());
        }
    }

    @Nested
    class StudentTrackerClassTests {
        StudentTracker tracker;

        @BeforeEach
        void setUp() {
            tracker = new StudentTracker();
        }

        @Test
        void shouldAddStudentToTracker() {
            tracker.addStudent("Andy", List.of(92, 88, 95));
            assertEquals(1, tracker.getStudentCount());
        }

        @Test
        void shouldGetStudentsWithSpecificLetterGrade() {
            Student mikey = tracker.addStudent("Mikey", List.of(95, 92, 98));
            Student chunk = tracker.addStudent("Chunk", List.of(75, 70, 68));
            Student mouth = tracker.addStudent("Mouth", List.of(65, 61, 58));
            Student brand = tracker.addStudent("Brand", List.of(85, 82, 88));
            Student stef = tracker.addStudent("Stef", List.of(91, 89, 93));
            Student troy = tracker.addStudent("Troy", List.of(55, 62, 59));

            assertEquals(2, tracker.getStudentsWithLetterGrade("A").size());
            assertTrue(tracker.getStudentsWithLetterGrade("A").contains(mikey));
            assertTrue(tracker.getStudentsWithLetterGrade("A").contains(stef));

            assertEquals(1, tracker.getStudentsWithLetterGrade("B").size());
            assertTrue(tracker.getStudentsWithLetterGrade("B").contains(brand));

            assertEquals(1, tracker.getStudentsWithLetterGrade("C").size());
            assertTrue(tracker.getStudentsWithLetterGrade("C").contains(chunk));

            assertEquals(1, tracker.getStudentsWithLetterGrade("D").size());
            assertTrue(tracker.getStudentsWithLetterGrade("D").contains(mouth));

            assertEquals(1, tracker.getStudentsWithLetterGrade("F").size());
            assertTrue(tracker.getStudentsWithLetterGrade("F").contains(troy));
        }
    }
}
