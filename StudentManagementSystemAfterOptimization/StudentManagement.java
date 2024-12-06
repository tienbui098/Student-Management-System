package org.StudentManagementSystemAfterOptimization;

import java.util.Scanner;

public class StudentManagement {
    private static final Scanner scanner = new Scanner(System.in);
    private StudentService studentService;

    public StudentManagement() {
        StudentStack studentStack = new StudentStack();
        studentService = new StudentService(studentStack);
    }

    public void displayMenu() {
        System.out.println("1. Add Student");
        System.out.println("2. Display All Students");
        System.out.println("3. Search Student by ID");
        System.out.println("4. Remove Student");
        System.out.println("5. Exit");
    }

    public void run() {
        while (true) {
            displayMenu();
            int choice = scanner.nextInt();
            scanner.nextLine(); // Clear the buffer

            switch (choice) {
                case 1:
                    addStudent();
                    break;
                case 2:
                    studentService.displayAllStudents();
                    break;
                case 3:
                    searchStudent();
                    break;
                case 4:
                    studentService.removeStudent();
                    break;
                case 5:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private void addStudent() {
        System.out.print("Enter Student ID: ");
        String id = scanner.nextLine();
        System.out.print("Enter Student Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter Student Score: ");
        double score = scanner.nextDouble();
        scanner.nextLine(); // Clear the buffer

        Student student = new Student(id, name, score);
        studentService.addStudent(student);
    }

    private void searchStudent() {
        System.out.print("Enter Student ID to search: ");
        String id = scanner.nextLine();
        studentService.searchStudent(id);
    }

    public static void main(String[] args) {
        StudentManagement management = new StudentManagement();
        management.run();
    }
}