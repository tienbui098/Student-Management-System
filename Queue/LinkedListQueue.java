package org.Queue;

// Node Class
class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
    }
}

// Queue Class
public class LinkedListQueue {
    private Node front, rear;
    private int length = 0;

    // Add an item to the queue
    void enqueue(int key) {
        Node temp = new Node(key);
        if (rear == null) {
            front = rear = temp;
        } else {
            rear.next = temp;
            rear = temp;
        }
        length++;
    }

    // Remove an item from the queue
    void dequeue() {
        if (front != null) {
            front = front.next;
            if (front == null) rear = null;
            length--;
        }
    }

    // Get the front item
    int peek() {
        return front != null ? front.data : Integer.MIN_VALUE;
    }

    // Get the size of the queue
    int size() {
        return length;
    }

    // Print the elements in the queue
    void printQueue() {
        Node temp = front;
        System.out.print("Elements in Queue: ");
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }
}

// Driver Class for LinkedListQueue
class TestLinkedListQueue {
    public static void main(String[] args) {
        LinkedListQueue q = new LinkedListQueue();
        q.enqueue(10);
        q.enqueue(20);
        q.printQueue();
        System.out.println("Size: " + q.size());
        q.dequeue();
        q.dequeue();
        q.enqueue(30);
        q.enqueue(40);
        q.enqueue(50);
        q.printQueue();
        System.out.println("Size: " + q.size());
        System.out.println("Front item is: " + q.peek());
    }
}