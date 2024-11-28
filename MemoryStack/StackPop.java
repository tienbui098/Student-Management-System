package org.MemoryStack;

public class StackPop {
    private static final int MAX_SIZE = 100;
    private int top;
    private int[] stackArray;
    // Constructor
    public StackPop() {
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
    // Pop method
    public int pop() {
        if (top < 0) {
            System.out.println("Stack Underflow");
            return -1;
        }
        int poppedElement = stackArray[top--];
        return poppedElement;
    }
    // Main method
    public static void main(String[] args) {
        StackPop stack = new StackPop();
        stack.push(10);
        stack.push(20);
        stack.push(30);
        int poppedElement = stack.pop();
        System.out.println("Popped element: " + poppedElement);
    }
}
