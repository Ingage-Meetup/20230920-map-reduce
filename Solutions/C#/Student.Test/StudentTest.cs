using NUnit.Framework;
using static Student.Student;
using static Student.StudentTracker;

namespace Student.Test
{
    [TestFixture]
    public class StudentTests
    {
        [Test]
        public void CalculateAverageGradeCorrectly()
        {
            var mikey = new Student("Mikey", (new[] { 85, 90, 78 }).ToList());
            Assert.That(mikey.AverageGrade, Is.EqualTo(84.33).Within(0.01));
        }

        [Test]
        public void ReturnCorrectLetterGrade()
        {
            var mikey = new Student("Mikey", (new[] { 95, 92, 98 }).ToList());
            var brand = new Student("Brand", (new[] { 80, 88, 76 }).ToList());
            var chunk = new Student("Chunk", (new[] { 75, 70, 68 }).ToList());
            var mouth = new Student("Mouth", (new[] { 65, 61, 58 }).ToList());
            var troy = new Student("Troy", (new[] { 55, 62, 59 }).ToList());

            Assert.That(mikey.LetterGrade, Is.EqualTo("A"));
            Assert.That(brand.LetterGrade, Is.EqualTo("B"));
            Assert.That(chunk.LetterGrade, Is.EqualTo("C"));
            Assert.That(mouth.LetterGrade, Is.EqualTo("D"));
            Assert.That(troy.LetterGrade, Is.EqualTo("F"));
        }
    }

    [TestFixture]
    public class StudentTrackerTests
    {
        [Test]
        public void AddStudentToTracker()
        {
            var tracker = new StudentTracker();
            tracker.AddStudent("Andy", (new[] { 92, 88, 95 }).ToList());
            Assert.That(tracker.StudentCount, Is.EqualTo(1));
        }

        [Test]
        public void GetStudentsWithSpecificLetterGrade()
        {
            var tracker = new StudentTracker();
            var mikey = tracker.AddStudent("Mikey", (new[] { 95, 92, 98 }).ToList());
            var chunk = tracker.AddStudent("Chunk", (new[] { 75, 70, 68 }).ToList());
            var mouth = tracker.AddStudent("Mouth", (new[] { 65, 61, 58 }).ToList());
            var brand = tracker.AddStudent("Brand", (new[] { 85, 82, 88 }).ToList());
            var stef = tracker.AddStudent("Stef", (new[] { 91, 89, 93 }).ToList());
            var troy = tracker.AddStudent("Troy", (new[] { 55, 62, 59 }).ToList());

            var gradeAStudents = tracker.GetStudentsWithLetterGrade("A");
            var gradeBStudents = tracker.GetStudentsWithLetterGrade("B");
            var gradeCStudents = tracker.GetStudentsWithLetterGrade("C");
            var gradeDStudents = tracker.GetStudentsWithLetterGrade("D");
            var gradeFStudents = tracker.GetStudentsWithLetterGrade("F");

            Assert.That(gradeAStudents.Count, Is.EqualTo(2));
            Assert.That(gradeAStudents, Contains.Item(mikey));
            Assert.That(gradeAStudents, Contains.Item(stef));

            Assert.That(gradeBStudents.Count, Is.EqualTo(1));
            Assert.That(gradeBStudents, Contains.Item(brand));

            Assert.That(gradeCStudents.Count, Is.EqualTo(1));
            Assert.That(gradeCStudents, Contains.Item(chunk));

            Assert.That(gradeDStudents.Count, Is.EqualTo(1));
            Assert.That(gradeDStudents, Contains.Item(mouth));

            Assert.That(gradeFStudents.Count, Is.EqualTo(1));
            Assert.That(gradeFStudents, Contains.Item(troy));
        }
    }
}
