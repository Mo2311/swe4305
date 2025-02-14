package LogBook.Week2;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        // Create scanner object to read input
        Scanner scanner = new Scanner(System.in);

        // Prompt user to enter their age
        System.out.print("Enter your age: ");
        int age = scanner.nextInt();

        // Get the current year
        int currentYear = 2025;

        // Calculate year of birth
        int birthYear = currentYear - age;

        // Output the result
        System.out.println("You were born in: " + birthYear);

        // Check if the user is 18 or older
        if (age >= 18) {
            System.out.println("You are 18 or older.");
        }

        /*---------convert letter grade to university classification--------*/
        // Create scanner object to read input
        scanner = new Scanner(System.in);

        // Prompt user to enter their letter grade
        System.out.print("Enter your grade (A, B, C, D, E, F): ");
        char grade = scanner.next().charAt(0);

        // Convert the grade to university classification
        String classification = "";
        switch (Character.toUpperCase(grade)) {
            case 'A':
                classification = "1st";
                break;
            case 'B':
                classification = "2:1";
                break;
            case 'C':
                classification = "2:2";
                break;
            case 'D':
                classification = "3rd";
                break;
            case 'E':
                classification = "Ordinary";
                break;
            case 'F':
                classification = "Fail";
                break;
            default:
                classification = "Invalid grade";
        }

        // Output the classification
        System.out.println("Your university classification is: " + classification);


    }
}