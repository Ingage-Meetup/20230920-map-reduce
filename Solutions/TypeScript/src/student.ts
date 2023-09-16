export class Student {
    name: string
    grades: number[]

    constructor(name: string, grades: number[]) {
        this.name = name
        this.grades = grades
    }

    get averageGrade(): number {
        if (this.grades.length === 0) {
            return 0
        }
        let sum = 0
        for (const grade of this.grades) {
            sum += grade
        }
        return sum / this.grades.length
    }

    get letterGrade(): string {
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

export class StudentTracker {
    students: Student[]

    constructor() {
        this.students = []
    }

    addStudent(name: string, grades: number[]): Student {
        const student = new Student(name, grades)
        this.students.push(student)

        return student
    }

    getStudentsWithLetterGrade(letterGrade: string): Student[] {
        const studentsWithLetterGrade = new Array<Student>()
        for (const student of this.students) {
            if (student.letterGrade === letterGrade) {
                studentsWithLetterGrade.push(student)
            }
        }
        return studentsWithLetterGrade
    }
}