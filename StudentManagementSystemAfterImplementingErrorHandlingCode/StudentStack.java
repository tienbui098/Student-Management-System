package org.StudentManagementSystemAfterImplementingErrorHandlingCode;

import java.util.ArrayList;
import java.util.HashSet;


public class StudentStack {
    private ArrayList<Student> stackArray;
    private HashSet<String> idSet;

    public StudentStack() {
        stackArray = new ArrayList<>();
        idSet = new HashSet<>();
    }

    public void push(Student student) {
        if (student.getId() == null || student.getId().trim().isEmpty()) {
            System.out.println("Invalid student ID. Cannot add student.");
            return;
        }
        if (idSet.contains(student.getId())) {
            System.out.println("Student with ID " + student.getId() + " already exists.");
            return;
        }
        stackArray.add(student);
        idSet.add(student.getId());
        System.out.println("Added student: " + student);
    }

    public Student pop() {
        if (isEmpty()) {
            System.out.println("Stack is empty, cannot get student.");
            return null;
        }
        Student student = stackArray.remove(stackArray.size() - 1);
        idSet.remove(student.getId());
        System.out.println("Taken student: " + student);
        return student;
    }

    public Student peek() {
        if (isEmpty()) {
            System.out.println("Stack is empty, cannot get student.");
            return null;
        }
        return stackArray.get(stackArray.size() - 1);
    }

    public boolean isEmpty() {
        return stackArray.isEmpty();
    }

    public Student search(String id) {
        for (Student student : stackArray) {
            if (student.getId().equals(id)) {
                return student;
            }
        }
        return null;
    }

    public void displayAll() {
        if (isEmpty()) {
            System.out.println("Empty stack.");
            return;
        }
        for (Student student : stackArray) {
            System.out.println(student);
        }
    }
}