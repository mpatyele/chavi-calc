package com.calc;

import java.util.Scanner;

/*
 Student: Mariana P. Pereira
 CIS055 - Data Structure
 Assignment - Chavvi calculator
*/

public class App {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        char command = '_';
        float a = 0.0f, b = 0.0f, result = 0.0f;

        // loop until user quits
        while (command != 'q') {
            printMenu(a, b, result);
            System.out.print("Enter a command: ");
            String input = scan.nextLine().trim();

            if (input.length() == 1) {
                command = input.charAt(0);
            } else {
                System.out.println("ERROR: Invalid command. Please enter a single-character command.");
                continue;
            }

            switch (command) {
                case 'a':
                    System.out.print("Enter value for A: ");
                    a = getValidFloat(scan);
                    break;
                case 'b':
                    System.out.print("Enter value for B: ");
                    b = getValidFloat(scan);
                    break;
                case '+':
                    result = a + b;
                    System.out.printf("Result: %.3f\n", result);
                    break;
                case '-':
                    result = a - b;
                    System.out.printf("Result: %.3f\n", result);
                    break;
                case '*':
                    result = a * b;
                    System.out.printf("Result: %.3f\n", result);
                    break;
                case '/':
                    if (b == 0) {
                        System.out.println("ERROR: Division by zero.");
                    } else {
                        result = a / b;
                        System.out.printf("Result: %.3f\n", result);
                    }
                    break;
                case 'c':
                    a = 0.0f;
                    b = 0.0f;
                    result = 0.0f;
                    System.out.println("Values cleared.");
                    break;
                case 'q':
                    System.out.println("Thank you for using ChavviCalc.");
                    break;
                default:
                    System.out.println("ERROR: Unknown command");
                    break;
            }
        }
        scan.close();
    }

    private static void printMenuLine() {
        System.out.println("----------------------------------------------------------");
    }

    private static void printMenuCommand(char command, String desc) {
        System.out.printf("%s\t%s\n", command, desc);
    }

    public static void printMenu(float a, float b, float result) {
        printMenuLine();
        System.out.println("ChavviCalc");
        printMenuLine();
        System.out.printf("A = %.3f      B = %.3f      Result = %.3f\n", a, b, result);
        printMenuLine();
        printMenuCommand('a', "Enter a value for A");
        printMenuCommand('b', "Enter a value for B");
        printMenuCommand('+', "Add");
        printMenuCommand('-', "Subtract");
        printMenuCommand('*', "Multiply");
        printMenuCommand('/', "Divide");
        printMenuCommand('c', "Clear");
        printMenuCommand('q', "Quit");
        printMenuLine();
    }

    private static float getValidFloat(Scanner scan) {
        while (!scan.hasNextFloat()) {
            System.out.println("ERROR: Invalid number input. Please enter a valid float value.");
            scan.nextLine(); // Clear invalid input
        }
        float value = scan.nextFloat();
        scan.nextLine(); // Ensure newline is consumed
        return value;
    }

}
