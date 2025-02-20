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
        float a = 0.0f, b = 0.0f;

        // loop until user quits
        while (command != 'q') {
            printMenu(a, b);
            System.out.print("Enter a command: ");
            command = menuGetCommand(scan);
            
            if (command == 'a') {
                System.out.print("Enter value for A: ");
                if (scan.hasNextFloat()) {
                    a = scan.nextFloat();
                } else {
                    System.out.println("ERROR: Invalid number input.");
                    scan.nextLine();
                    continue;
                }
                scan.nextLine();
            } else if (command == 'b') {
                System.out.print("Enter value for B: ");
                if (scan.hasNextFloat()) {
                    b = scan.nextFloat();
                } else {
                    System.out.println("ERROR: Invalid number input.");
                    scan.nextLine();
                    continue;
                }
                scan.nextLine();
            } else if (command == '+' || command == '-' || command == '*' || command == '/') {
                float result = executeCommand(command, a, b);
                System.out.printf("Result: %.3f\n", result);
            } else if (command == 'c') {
                a = 0.0f;
                b = 0.0f;
                System.out.println("Values cleared.");
            } else if (command == 'q') {
                System.out.println("Thank you for using ChavviCalc.");
                break;
            } else {
                System.out.println("ERROR: Unknown command");
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

    public static void printMenu(float a, float b) {
        printMenuLine();
        System.out.println("ChavviCalc");
        printMenuLine();
        System.out.printf("A = %.3f      B = %.3f\n", a, b);
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

    private static char menuGetCommand(Scanner scan) {
        String rawInput = scan.nextLine().trim();
        return rawInput.length() > 0 ? rawInput.charAt(0) : '_';
    }

    private static float executeCommand(char command, float a, float b) {
        switch (command) {
            case '+':
                return a + b;
            case '-':
                return a - b;
            case '*':
                return a * b;
            case '/':
                if (b != 0) {
                    return a / b;
                } else {
                    System.out.println("Error: Division by zero.");
                    return 0;
                }
            default:
                System.out.println("ERROR: Unknown command");
                return 0;
        }
    }
}
