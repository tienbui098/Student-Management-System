package org.SoftwareStack;

public class LinkedListStack {
    StackNode root;
    // Node class for the stack
    static class StackNode {
        int data;
        StackNode next;
        StackNode(int data) {
            this.data = data;
        }
    }
    // Check if the stack is empty
    public boolean isEmpty() {
        return root == null;
    }
    // Push an element onto the stack
    public void push(int data) {
        StackNode newNode = new StackNode(data);
        if (root == null) {
            root = newNode;
        } else {
            newNode.next = root;
            root = newNode;
        }
        System.out.println(data + " pushed to stack");
    }
    // Pop an element from the stack
    public int pop() {
        if (isEmpty()) {
            System.out.println("Stack is Empty");
            return Integer.MIN_VALUE; // Return a sentinel value
        } else {
            int popped = root.data;
            root = root.next;
            return popped;
        }
    }
    // Peek at the top element of the stack
    public int peek() {
        if (isEmpty()) {
            System.out.println("Stack is empty");
            return Integer.MIN_VALUE; // Return a sentinel value
        } else {
            return root.data;
        }
    }
    // Driver code
    public static void main(String[] args) {
        LinkedListStack stack = new LinkedListStack();
        stack.push(10);
        stack.push(20);
        stack.push(30);
        System.out.println(stack.pop() + " popped from stack");
        System.out.println("Top element is " + stack.peek());
        stack.push(40);
        stack.push(50);
        System.out.println(stack.pop() + " popped from stack");
        System.out.println("Top element is " + stack.peek());
    }
}