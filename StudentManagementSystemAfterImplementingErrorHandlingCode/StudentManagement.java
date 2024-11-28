package org.StudentManagementSystemAfterImplementingErrorHandlingCode;

import java.util.Scanner;

public class StudentManagement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StudentStack studentStack = new StudentStack();
        showMenu(scanner, studentStack);
        scanner.close();
    }

    private static void showMenu(Scanner scanner, StudentStack studentStack) {
        while (true) {
            System.out.println("\nSelect an action:");
            System.out.println("1. Add student");
            System.out.println("2. Get student");
            System.out.println("3. View student at top");
            System.out.println("4. Check stack is empty");
            System.out.println("5. Search student by ID");
            System.out.println("6. Show all students");
            System.out.println("7. Exit");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Đọc dòng mới

            switch (choice) {
                case 1:
                    addStudent(scanner, studentStack);
                    break;
                case 2:
                    studentStack.pop();
                    break;
                case 3:
                    Student topStudent = studentStack.peek();
                    if (topStudent != null) {
                        System.out.println("Student at the top of the stack: " + topStudent);
                    }
                    break;
                case 4:
                    System.out.println(studentStack.isEmpty() ? "Empty stack." : "Stack is not empty.");
                    break;
                case 5:
                    searchStudent(scanner, studentStack);
                    break;
                case 6:
                    studentStack.displayAll();
                    break;
                case 7:
                    System.out.println("Exit program.");
                    return;
                default:
                    System.out.println("Invalid selection. Please select again.");
            }
        }
    }

    private static void addStudent(Scanner scanner, StudentStack studentStack) {
        System.out.print("Enter student code: ");
        String id = scanner.nextLine();
        if (id == null || id.trim().isEmpty()) {
            System.out.println("Student ID cannot be empty.");
            return;
        }
        if (studentStack.search(id) != null) {
            System.out.println("Student code already exists.");
            return;
        }
        System.out.print("Enter student's full name: ");
        String name = scanner.nextLine();
        double score = 0;
        boolean validScore = false;
        while (!validScore) {
            System.out.print("Enter student scores: ");
            try {
                score = Double.parseDouble(scanner.nextLine());
                validScore = true;
            } catch (NumberFormatException e) {
                System.out.println("Invalid score. Please enter a number.");
            }
        }
        studentStack.push(new Student(id, name, score));
    }

    private static void searchStudent(Scanner scanner, StudentStack studentStack) {
        System.out.print("Enter the student code you are looking for: ");
        String searchId = scanner.nextLine();
        Student foundStudent = studentStack.search(searchId);
        if (foundStudent != null) {
            System.out.println("Found student: " + foundStudent);
        } else {
            System.out.println("No student found with code: " + searchId);
        }
    }
}