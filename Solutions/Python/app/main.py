class Student:
    def __init__(self, name, grades):
        self.name = name
        self.grades = grades

    @property
    def average_grade(self):
        if not self.grades:
            return 0
        total = 0
        for grade in self.grades:
            total += grade
        return total / len(self.grades)

    @property
    def letter_grade(self):
        average_grade = self.average_grade
        if average_grade >= 90:
            return 'A'
        elif average_grade >= 80:
            return 'B'
        elif average_grade >= 70:
            return 'C'
        elif average_grade >= 60:
            return 'D'
        else:
            return 'F'


class StudentTracker:
    def __init__(self):
        self.students = []

    def add_student(self, name, grades):
        student = Student(name, grades)
        self.students.append(student)
        return student

    def get_students_with_letter_grade(self, letter_grade):
        students_with_letter_grade = []
        for student in self.students:
            if student.letter_grade == letter_grade:
                students_with_letter_grade.append(student)
        return students_with_letter_grade
