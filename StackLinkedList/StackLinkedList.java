package org.StackLinkedList;

public class StackLinkedList {
    private Node top;
    public StackLinkedList() {
        top = null;
    }
    public void push(int data) {
        Node newNode = new Node(data);
        newNode.next = top;
        top = newNode;
        System.out.println(data + " pushed to stack");
    }
    public int pop() {
        if (isEmpty()) {
            System.out.println("Stack is empty, cannot pop");
            return -1;
        }
        int removedData = top.data;
        top = top.next;
        System.out.println(removedData + " popped from stack");
        return removedData;
    }
    public int peek() {
        if (isEmpty()) {
            System.out.println("Stack is empty, cannot peek");
            return -1;
        }
        return top.data;
    }
    public boolean isEmpty() {
        return top == null;
    }
    public void display() {
        if (isEmpty()) {
            System.out.println("Stack is empty");
            return;
        }
        System.out.print("Elements in stack: ");
        Node current = top;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }
    public static void main(String[] args) {
        StackLinkedList stack = new StackLinkedList();
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