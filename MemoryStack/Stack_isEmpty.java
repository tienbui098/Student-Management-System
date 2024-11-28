package org.MemoryStack;

public class Stack_isEmpty {
    private static final int MAX_SIZE = 100;
    private int top;
    private int[] stackArray;
    // Constructor
    public Stack_isEmpty() {
        top = -1;
        stackArray = new int[MAX_SIZE];
    }
    // Push method
    public void push(int element) {
        if (top >= MAX_SIZE - 1) {
            System.out.println("Stack Overflow");
            return;
        }
        stackArray[++top] = element;
        System.out.println("Element " + element + " pushed to stack.");
    }
    // Method to check if the stack is empty
    public boolean isEmpty() {
        return top < 0;
    }
    // Main method
    public static void main(String[] args) {
        Stack_isEmpty stack = new Stack_isEmpty();
        stack.push(10);
        stack.push(20);
        stack.push(30);
        boolean empty = stack.isEmpty();
        System.out.println("Is Stack Empty? " + (empty ? "Yes" : "No"));
    }
}
