import java.util.Scanner;
import java.io.FileWriter;
import java.io.IOException;

public class MultiplicationTable {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        
        int[][] table = new int[101][101];
        for (int i = 1; i <= 100; i++) {
            for (int j = 1; j <= 100; j++) {
                table[i][j] = i * j;
            }
        }

        int choice;

        do {
            System.out.println("\n======================================");
            System.out.println("   MULTIPLICATION TABLE PROGRAM");
            System.out.println("======================================");
            System.out.println("1. Display a specific multiplication table");
            System.out.println("2. Save all multiplication equations to a file");
            System.out.println("3. Exit");
            System.out.println("======================================");
            System.out.print("Enter your choice: ");

            while (!input.hasNextInt()) {
                System.out.println("Invalid input! Please enter a number.");
                input.next();
                System.out.print("Enter your choice: ");
            }

            choice = input.nextInt();

            switch (choice) {

                case 1:
                    
                    System.out.print("Enter the table number (1-100): ");

                    while (!input.hasNextInt()) {
                        System.out.println("Invalid input! Enter a number from 1 to 100.");
                        input.next();
                        System.out.print("Enter the table number (1-100): ");
                    }

                    int number = input.nextInt();

                    if (number >= 1 && number <= 100) {

                        System.out.println("\nMultiplication Table of " + number);
                        System.out.println("--------------------------------------");

                        for (int j = 1; j <= 100; j++) {
                            System.out.println(
                                number + " x " + j + " = " + table[number][j]
                            );
                        }

                    } else {
                        System.out.println(
                            "Invalid table number! Please enter a number from 1 to 100."
                        );
                    }

                    break;

                case 2:
                    // This saves all the tables to a file
                    try {
                        FileWriter writer =
                            new FileWriter("MultiplicationTables.txt");

                        for (int i = 1; i <= 100; i++) {

                            writer.write(
                                "Multiplication Table of " + i + "\n"
                            );

                            for (int j = 1; j <= 100; j++) {
                                writer.write(
                                    i + " x " + j + " = " + table[i][j] + "\n"
                                );
                            }

                            writer.write("\n");
                        }

                        writer.close();

                        System.out.println(
                            "All 10,000 equations have been saved successfully."
                        );

                        System.out.println(
                            "File name: MultiplicationTables.txt"
                        );

                    } catch (IOException e) {
                        System.out.println(
                            "An error occurred while saving the file."
                        );

                        System.out.println(e.getMessage());
                    }

                    break;

                case 3:
                    System.out.println("Thank you for using the program!");
                    break;

                default:
                    System.out.println(
                        "Invalid choice! Please select 1, 2, or 3."
                    );
            }

        } while (choice != 3);

        input.close();
    }
}
