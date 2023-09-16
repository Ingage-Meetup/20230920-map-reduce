const { describe, it, expect } = require('@jest/globals');
const { Student, StudentTracker } = require('./student');

describe('Student Class', () => {
    it('should calculate the average grade correctly', () => {
        const mikey = new Student('Mikey', [85, 90, 78]);
        expect(mikey.averageGrade).toBeCloseTo(84.33, 2);
    });

    it('should return the correct letter grade', () => {
        const mikey = new Student('Mikey', [95, 92, 98]);
        const brand = new Student('Brand', [80, 88, 76]);
        const chunk = new Student('Chunk', [75, 70, 68]);
        const mouth = new Student('Mouth', [65, 61, 58]);
        const troy = new Student('Troy', [55, 62, 59]);

        expect(mikey.letterGrade).toBe('A');
        expect(brand.letterGrade).toBe('B');
        expect(chunk.letterGrade).toBe('C');
        expect(mouth.letterGrade).toBe('D');
        expect(troy.letterGrade).toBe('F');
    });
});

describe('StudentTracker Class', () => {
    it('should add a student to the tracker', () => {
        const tracker = new StudentTracker();
        tracker.addStudent('Andy', [92, 88, 95]);
        expect(tracker.students.length).toBe(1);
    });

    it('should get students with a specific letter grade', () => {
        const tracker = new StudentTracker();
        const mikey = tracker.addStudent('Mikey', [95, 92, 98]);
        const chunk = tracker.addStudent('Chunk', [75, 70, 68]);
        const mouth = tracker.addStudent('Mouth', [65, 61, 58]);
        const brand = tracker.addStudent('Brand', [85, 82, 88]);
        const stef = tracker.addStudent('Stef', [91, 89, 93]);
        const troy = tracker.addStudent('Troy', [55, 62, 59]);

        const gradeAStudents = tracker.getStudentsWithLetterGrade('A');
        const gradeBStudents = tracker.getStudentsWithLetterGrade('B');
        const gradeCStudents = tracker.getStudentsWithLetterGrade('C');
        const gradeDStudents = tracker.getStudentsWithLetterGrade('D');
        const gradeFStudents = tracker.getStudentsWithLetterGrade('F');

        expect(gradeAStudents.length).toBe(2);
        expect(gradeAStudents).toContain(mikey);
        expect(gradeAStudents).toContain(stef);

        expect(gradeBStudents.length).toBe(1);
        expect(gradeBStudents).toContain(brand);

        expect(gradeCStudents.length).toBe(1);
        expect(gradeCStudents).toContain(chunk);

        expect(gradeDStudents.length).toBe(1);
        expect(gradeDStudents).toContain(mouth);

        expect(gradeFStudents.length).toBe(1);
        expect(gradeFStudents).toContain(troy);
    });
});
