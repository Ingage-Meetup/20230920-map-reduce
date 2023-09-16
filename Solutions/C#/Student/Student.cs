namespace Student;

using System;
using System.Collections.Generic;

public class Student
{
    public string Name { get; set; }
    public List<int> Grades { get; set; }

    public Student(string name, List<int> grades)
    {
        Name = name;
        Grades = grades;
    }

    public double AverageGrade
    {
        get
        {
            if (Grades.Count == 0)
            {
                return 0;
            }
            double sum = 0;
            foreach (int grade in Grades)
            {
                sum += grade;
            }
            return sum / Grades.Count;
        }
    }

    public string LetterGrade
    {
        get
        {
            double averageGrade = AverageGrade;
            if (averageGrade >= 90)
            {
                return "A";
            }
            else if (averageGrade >= 80)
            {
                return "B";
            }
            else if (averageGrade >= 70)
            {
                return "C";
            }
            else if (averageGrade >= 60)
            {
                return "D";
            }
            else
            {
                return "F";
            }
        }
    }
}

public class StudentTracker
{
    private List<Student> students;

    public StudentTracker()
    {
        students = new List<Student>();
    }

    public int StudentCount
    {
        get
        {
            return students.Count;
        }
    }

    public Student AddStudent(string name, List<int> grades)
    {
        Student student = new Student(name, grades);
        students.Add(student);
        return student;
    }

    public List<Student> GetStudentsWithLetterGrade(string letterGrade)
    {
        List<Student> studentsWithLetterGrade = new List<Student>();
        foreach (Student student in students)
        {
            if (student.LetterGrade == letterGrade)
            {
                studentsWithLetterGrade.Add(student);
            }
        }
        return studentsWithLetterGrade;
    }
}
