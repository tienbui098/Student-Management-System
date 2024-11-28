package org.StackArray;

public class StackArray {
    private int[] stackArray;
    private int top;
    private int capacity;

    public StackArray(int size) {
        stackArray = new int[size];
        capacity = size;
        top = -1;
    }

    public void push(int data) {
        if (top >= capacity - 1) {
            System.out.println("Stack is full, cannot push " + data);
            return;
        }
        stackArray[++top] = data;
        System.out.println(data + " pushed to stack");
    }

    public int pop() {
        if (isEmpty()) {
            return -1;
        }
        int removedData = stackArray[top--];
        System.out.println(removedData + " popped from stack");
        return removedData;
    }

    public int peek() {
        if (isEmpty()) {
            return -1;
        }
        return stackArray[top];
    }

    public boolean isEmpty() {
        return top < 0;
    }

    public void display() {
        if (isEmpty()) {
            System.out.println("Stack is empty");
            return;
        }
        System.out.print("Elements in stack: ");
        for (int i = top; i >= 0; i--) {
            System.out.print(stackArray[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        StackArray stack = new StackArray(5);
        stack.push(10);
        stack.push(20);
        stack.push(30);
        stack.display();

        System.out.println("Top element is: " + stack.peek());

        stack.pop();
        stack.display();

        stack.push(40);
        stack.push(50);
        stack.push(60);
        stack.display();

        stack.pop();
        stack.pop();
        stack.display();

        stack.pop();
        stack.pop();
        stack.pop();
    }
}