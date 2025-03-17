package LogBook.Week3;

class Course {

    private String code;
    private String name;

    // Constructor
    public Course(String code, String name) {
        this.code = code;
        this.name = name;
    }

    // Print Course Details
    public void print() {
        System.out.println("Course Code: " + code);
        System.out.println("Course Name: " + name);
    }
}

// Student Class
class Student {
    private int id;
    private String name;
    private Course course;  // Course the student is enrolled in

    // Constructor
    public Student(int id, String name) {
        this.id = id;
        this.name = name;
        this.course = null;  // Initially, no course enrolled
    }

    // Print Student Details
    public void print() {
        System.out.println("Student ID: " + id);
        System.out.println("Student Name: " + name);
        if (course != null) {
            course.print();  // Print course details if enrolled
        } else {
            System.out.println("No course enrolled.");
        }
    }

    // Enroll Student in a Course
    public void enrol(Course course) {
        this.course = course;
    }
}

// Main Method to Test
public class Main {
    public static void main(String[] args) {
        // Create Student
        Student student = new Student(12345678, "John Doe");

        // Print Student before enrolling
        student.print();

        // Create Course
        Course course = new Course("CS101", "Introduction to Computer Science");

        // Enroll Student in Course
        student.enrol(course);

        // Print Student after enrolling
        System.out.println("\nAfter enrolling in a course:");
        student.print();  // Student and course details
    }
}
