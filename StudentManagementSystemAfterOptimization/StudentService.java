package org.StudentManagementSystemAfterOptimization;

public class StudentService {
    private StudentStack studentStack;

    public StudentService(StudentStack studentStack) {
        this.studentStack = studentStack;
    }

    public void addStudent(Student student) {
        studentStack.push(student);
    }

    public void displayAllStudents() {
        studentStack.displayAll();
    }

    public Student searchStudent(String id) {
        Student student = studentStack.search(id);
        if (student == null) {
            System.out.println("No student found with ID: " + id);
        } else {
            System.out.println("Found student: " + student);
        }
        return student;
    }

    public void removeStudent() {
        Student removedStudent = studentStack.pop();
        if (removedStudent != null) {
            System.out.println("Removed student: " + removedStudent);
        }
    }
}
