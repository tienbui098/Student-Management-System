package org.StudentManagementSystemAfterOptimization;

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
        if (idSet.contains(student.getId())) {
            System.out.println("Student with ID " + student.getId() + " already exists. Cannot add duplicate student.");
            return;
        }
        stackArray.add(student);
        idSet.add(student.getId());
        System.out.println("Added student: " + student);
    }

    public Student pop() {
        if (!isEmpty()) {
            Student student = stackArray.remove(stackArray.size() - 1);
            idSet.remove(student.getId());
            System.out.println("Taken student: " + student);
            return student;
        } else {
            System.out.println("Stack is empty, cannot get student.");
            return null;
        }
    }

    public Student peek() {
        if (!isEmpty()) {
            return stackArray.get(stackArray.size() - 1);
        } else {
            System.out.println("Stack is empty, cannot get student.");
            return null;
        }
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
