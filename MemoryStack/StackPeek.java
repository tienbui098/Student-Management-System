package org.MemoryStack;

public class StackPeek {
    private static final int MAX_SIZE = 100;
    private int top;
    private int[] stackArray;
    // Constructor
    public StackPeek() {
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
    // Peek method
    public int peek() {
        if (top < 0) {
            System.out.println("Stack is Empty");
            return -1;
        }
        return stackArray[top];
    }
    // Main method
    public static void main(String[] args) {
        StackPeek stack = new StackPeek();
        stack.push(10);
        stack.push(20);
        stack.push(30);
        int topElement = stack.peek();
        System.out.println("Top Element: " + topElement);
    }
}
