class Student {
    constructor(name, grades) {
        this.name = name
        this.grades = grades
    }

    get averageGrade() {
        if (this.grades.length === 0) {
            return 0
        }
        let sum = 0
        for (const grade of this.grades) {
            sum += grade
        }
        return sum / this.grades.length
    }

    get letterGrade() {
        const averageGrade = this.averageGrade
        if (averageGrade >= 90) {
            return 'A'
        } else if (averageGrade >= 80) {
            return 'B'
        } else if (averageGrade >= 70) {
            return 'C'
        } else if (averageGrade >= 60) {
            return 'D'
        } else {
            return 'F'
        }
    }
}

class StudentTracker {
    constructor() {
        this.students = []
    }

    addStudent(name, grades) {
        const student = new Student(name, grades)
        this.students.push(student)

        return student
    }

    getStudentsWithLetterGrade(letterGrade) {
        const studentsWithLetterGrade = []
        for (const student of this.students) {
            if (student.letterGrade === letterGrade) {
                studentsWithLetterGrade.push(student)
            }
        }
        return studentsWithLetterGrade
    }
}

module.exports = { Student, StudentTracker }