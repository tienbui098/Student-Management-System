package org.StudentManagementSystemAfterOptimization;

import java.util.ArrayList;
import java.util.HashSet;

public class StudentStack {
    private ArrayList<Student> stackList;
    private HashSet<String> idSet;

    public StudentStack() {
        stackList = new ArrayList<>();
        idSet = new HashSet<>();
    }

    public void push(Student student) {
        if (idSet.contains(student.getId())) {
            System.out.println("Student with ID " + student.getId() + " already exists.");
            return;
        }
        idSet.add(student.getId());
        stackList.add(student);
        System.out.println("Added student: " + student);
    }

    public Student pop() {
        if (isEmpty()) {
            System.out.println("Stack is empty, cannot get student.");
            return null;
        }
        Student student = stackList.remove(stackList.size() - 1);
        idSet.remove(student.getId());
        return student;
    }

    public Student peek() {
        if (isEmpty()) {
            System.out.println("Stack is empty, cannot get student.");
            return null;
        }
        return stackList.get(stackList.size() - 1);
    }

    public boolean isEmpty() {
        return stackList.isEmpty();
    }

    public Student search(String id) {
        return stackList.stream().filter(s -> s.getId().equals(id)).findFirst().orElse(null);
    }

    public void displayAll() {
        if (isEmpty()) {
            System.out.println("No students to display.");
            return;
        }
        stackList.forEach(System.out::println);
    }
}