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
        // Prompt user to enter their letter grade
        System.out.print("Enter your grade (A, B, C, D, E, F): ");
        char grade = scanner.next().charAt(0);

        // Convert the grade to university classification
        String classification = switch (Character.toUpperCase(grade)) {
            case 'A' -> "1st";
            case 'B' -> "2:1";
            case 'C' -> "2:2";
            case 'D' -> "3rd";
            case 'E' -> "Ordinary";
            case 'F' -> "Fail";
            default -> "Invalid grade";
        };

        /* Display the classification */
        System.out.println("Your classification is: " + classification);

        /* Use a for loop to print digits from 0 to 9 */
        System.out.println("Digits from 0 to 9:");
        for (int i = 0; i <= 9; i++) {
            System.out.print(i + " "); // Print each digit
        }
        System.out.println(); // Move to the next line

        /* Loop from 1 to 12 to print the 7 times table */
        System.out.println("Seven times multiplication table:");
        for (int i = 1; i <= 12; i++) {
            System.out.println(i + " x 7 = " + (i * 7)); // Print multiplication result
        }

        char choice; // Variable to store user choice

        /* Do-while loop to allow the user to restart the program */
        do {
            // Ask the user to enter a number
            System.out.print("\nEnter a number to see its multiplication table: ");
            int number = scanner.nextInt();

            // Display multiplication table for the number entered by user
            for (int i = 1; i <= 12; i++) {
                System.out.println(i + " x " + number + " = " + (i * number));
            }

            // Ask if the user wants to continue
            System.out.print("\nWould you like to enter another number? (Y/N): ");
            choice = scanner.next().charAt(0); // Read user choice

        } while (Character.toUpperCase(choice) == 'Y'); // Repeat if the user chooses 'Y'

        // Closing scanner object
        scanner.close();
        System.out.println("Program finished.");
    }
}
