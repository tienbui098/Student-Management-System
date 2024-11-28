package org.MemoryStack;

public class StackPush {
    private static final int MAX_SIZE = 100;
    private int top;
    private int[] stackArray;
    public StackPush() {
        top = -1;
        stackArray = new int[MAX_SIZE];
    }
    public void push(int element) {
        if (top >= MAX_SIZE - 1) {
            System.out.println("Stack Overflow");
            return;
        }
        stackArray[++top] = element;
        System.out.println("Element " + element + " pushed to stack.");
    }
    public static void main(String[] args) {
        org.MemoryStack.StackPush stack = new org.MemoryStack.StackPush();
        stack.push(10);
        stack.push(20);
        stack.push(30);
    }

}