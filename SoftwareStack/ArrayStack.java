package org.SoftwareStack;

public class ArrayStack {
    static final int MAX = 1000; // Maximum size of Stack
    int top;
    int[] a = new int[MAX];
    // Constructor to initialize the stack
    ArrayStack() {
        top = -1;
    }
    // Check if the stack is empty
    boolean isEmpty() {
        return (top < 0);
    }
    // Push an element onto the stack
    boolean push(int x) {
        if (top >= (MAX - 1)) {
            System.out.println("Stack Overflow");
            return false;
        } else {
            a[++top] = x;
            System.out.println(x + " pushed into stack");
            return true;
        }
    }
    // Pop an element from the stack
    int pop() {
        if (top < 0) {
            System.out.println("Stack Underflow");
            return 0;
        } else {
            return a[top--];
        }
    }
    // Peek at the top element of the stack
    int peek() {
        if (top < 0) {
            System.out.println("Stack Underflow");
            return 0;
        } else {
            return a[top];
        }
    }
    // Print elements in the stack
    void print() {
        for (int i = top; i >= 0; i--) {
            System.out.print(" " + a[i]);
        }
    }
}



