package org.StudentManagementSystem;

import java.util.Scanner;

public class StudentManagement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the maximum number of students in the class: ");
        int maxStudents = scanner.nextInt();
        StudentStack studentStack = new StudentStack(maxStudents);

        // Hiển thị menu ngay sau khi nhập số lượng tối đa
        showMenu(scanner, studentStack, maxStudents);

        scanner.close();
    }

    private static void showMenu(Scanner scanner, StudentStack studentStack, int maxStudents) {
        boolean canAddStudents = true; // Biến kiểm soát việc thêm sinh viên

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
                    if (canAddStudents) {
                        addStudents(scanner, studentStack, maxStudents);
                        canAddStudents = false; // Không cho phép thêm sinh viên nữa
                    } else {
                        System.out.println("Cannot add more students, maximum capacity reached.");
                    }
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
                    if (studentStack.isEmpty()) {
                        System.out.println("Empty stack.");
                    } else {
                        System.out.println("Stack is not empty.");
                    }
                    break;
                case 5:
                    searchStudent(scanner, studentStack);
                    break;
                case 6:
                    studentStack.bubbleSortByScore(); // Gọi phương thức sắp xếp
                    studentStack.displayAll();
                    break;
                case 7:
                    System.out.println("Exit program.");
                    return; // Thoát khỏi phương thức
                default:
                    System.out.println("Invalid selection. Please select again.");
            }
        }
    }

    private static void addStudents(Scanner scanner, StudentStack studentStack, int maxStudents) {
        for (int i = 0; i < maxStudents; i++) {
            boolean validInput = false; // Kiểm soát đầu vào hợp lệ

            while (!validInput) {
                System.out.println("Adding student " + (i + 1) + ":");
                System.out.print("Enter student code: ");
                String id = scanner.next();
                scanner.nextLine(); // Đọc dòng mới

                // Kiểm tra trùng lặp
                if (studentStack.search(id) != null) {
                    System.out.println("Student code already exists. Please enter a different student code.");
                } else {
                    System.out.print("Enter student's full name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter student scores: ");
                    double score = scanner.nextDouble();
                    studentStack.push(new Student(id, name, score));
                    validInput = true; // Đầu vào hợp lệ, thoát khỏi vòng lặp
                }
            }
        }
        System.out.println("All " + maxStudents + " students added.");
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