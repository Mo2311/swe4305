package LogBook.Week4;
import java.util.ArrayList;

public class Main {

    // Module Class
    static class Module {
        private String name;
        private String code;

        // Constructor
        public Module(String name, String code) {
            this.name = name;
            this.code = code;
        }

        // Getters
        public String getName() {
            return name;
        }

        public String getCode() {
            return code;
        }

        // Method to convert marks to letter grade
        public String convertToGrade(int mark) {
            if (mark >= 85) {
                return "A";
            } else if (mark >= 70) {
                return "B";
            } else if (mark >= 50) {
                return "C";
            } else if (mark >= 40) {
                return "D";
            } else {
                return "F";
            }
        }
    }

    // Course Class
    static class Course {
        private String code;
        private String name;
        private ArrayList<Module> modules;  // ArrayList of Module objects

        // Constructor
        public Course(String code, String name) {
            this.code = code;
            this.name = name;
            this.modules = new ArrayList<>();  // Initialize the ArrayList

            // Add four modules to the ArrayList
            modules.add(new Module("Mathematics", "MATH101"));
            modules.add(new Module("Computer Science", "CS101"));
            modules.add(new Module("Physics", "PHYS101"));
            modules.add(new Module("Chemistry", "CHEM101"));
        }

        // Print course and module details
        public void print() {
            System.out.println("Course Code: " + code);
            System.out.println("Course Name: " + name);
            System.out.println("Modules:");

            // Print each module's name and code
            for (Module module : modules) {
                System.out.println("  " + module.getName() + " (" + module.getCode() + ")");
            }
        }

        // Getters for code and name
        public String getCode() {
            return code;
        }

        public String getName() {
            return name;
        }

        // Get the list of modules
        public ArrayList<Module> getModules() {
            return modules;
        }
    }

    // Student Class
    static class Student {
        private int id;
        private String name;
        private int[] marks = new int[4];  // Array for marks of 4 modules
        private Course course;             // Course the student is enrolled in

        // Constructor
        public Student(int id, String name, Course course) {
            this.id = id;
            this.name = name;
            this.course = course;

            // Assign random marks to the modules (0-100)
            for (int i = 0; i < 4; i++) {
                marks[i] = (int) (Math.random() * 101);  // Random mark between 0 and 100
            }
        }

        // Print student details along with course and module details
        public void print() {
            System.out.println("Student ID: " + id);
            System.out.println("Student Name: " + name);
            System.out.println("Enrolled in course: " + course.getName());

            // Print module details and marks
            for (int i = 0; i < 4; i++) {
                Module module = course.getModules().get(i);
                System.out.println("Module: " + module.getName() + " (" + module.getCode() + ")");
                System.out.println("Mark: " + marks[i] + " Grade: " + module.convertToGrade(marks[i]));
            }
        }
    }

    public static void main(String[] args) {
        // Create a course
        Course course = new Course("CS101", "Computer Science");

        // Create a student
        Student student = new Student(12345678, "John Doe", course);

        // Print student details and modules
        student.print();

        // Calculate and print descriptive statistics
        calculateStatistics(student);
    }

    // Method to calculate min, max, and mean marks
    public static void calculateStatistics(Student student) {
        int[] marks = student.marks;
        int min = marks[0], max = marks[0];
        double sum = 0;

        // Calculate min, max, and sum for mean
        for (int mark : marks) {
            if (mark < min) min = mark;
            if (mark > max) max = mark;
            sum += mark;
        }

        double mean = sum / marks.length;

        // Print statistics
        System.out.println("\nDescriptive Statistics for " + student.name + ":");
        System.out.println("Min Mark: " + min);
        System.out.println("Max Mark: " + max);
        System.out.println("Mean Mark: " + mean);
    }
}
