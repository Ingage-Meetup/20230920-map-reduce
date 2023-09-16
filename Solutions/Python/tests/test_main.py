import unittest
from app.main import Student, StudentTracker

class TestStudentClass(unittest.TestCase):
    def test_calculate_average_grade(self):
        mikey = Student('Mikey', [85, 90, 78])
        self.assertAlmostEqual(mikey.average_grade, 84.33, 2)

    def test_return_correct_letter_grade(self):
        mikey = Student('Mikey', [95, 92, 98])
        brand = Student('Brand', [80, 88, 76])
        chunk = Student('Chunk', [75, 70, 68])
        mouth = Student('Mouth', [65, 61, 58])
        troy = Student('Troy', [55, 62, 59])

        self.assertEqual(mikey.letter_grade, 'A')
        self.assertEqual(brand.letter_grade, 'B')
        self.assertEqual(chunk.letter_grade, 'C')
        self.assertEqual(mouth.letter_grade, 'D')
        self.assertEqual(troy.letter_grade, 'F')

class TestStudentTrackerClass(unittest.TestCase):
    def test_add_student_to_tracker(self):
        tracker = StudentTracker()
        tracker.add_student('Andy', [92, 88, 95])
        self.assertEqual(len(tracker.students), 1)

    def test_get_students_with_specific_letter_grade(self):
        tracker = StudentTracker()
        mikey = tracker.add_student('Mikey', [95, 92, 98])
        chunk = tracker.add_student('Chunk', [75, 70, 68])
        mouth = tracker.add_student('Mouth', [65, 61, 58])
        brand = tracker.add_student('Brand', [85, 82, 88])
        stef = tracker.add_student('Stef', [91, 89, 93])
        troy = tracker.add_student('Troy', [55, 62, 59])

        grade_a_students = tracker.get_students_with_letter_grade('A')
        grade_b_students = tracker.get_students_with_letter_grade('B')
        grade_c_students = tracker.get_students_with_letter_grade('C')
        grade_d_students = tracker.get_students_with_letter_grade('D')
        grade_f_students = tracker.get_students_with_letter_grade('F')

        self.assertEqual(len(grade_a_students), 2)
        self.assertIn(mikey, grade_a_students)
        self.assertIn(stef, grade_a_students)

        self.assertEqual(len(grade_b_students), 1)
        self.assertIn(brand, grade_b_students)

        self.assertEqual(len(grade_c_students), 1)
        self.assertIn(chunk, grade_c_students)

        self.assertEqual(len(grade_d_students), 1)
        self.assertIn(mouth, grade_d_students)

        self.assertEqual(len(grade_f_students), 1)
        self.assertIn(troy, grade_f_students)

if __name__ == '__main__':
    unittest.main()
