package org.Queue;

import java.util.Queue;

public class ArrayQueue {
    int front, rear, size;
    int capacity;
    int array[];
    public ArrayQueue(int capacity) {
        this.capacity = capacity;
        front = this.size = 0;
        rear = capacity - 1;
        array = new int[this.capacity];
    }
    // Queue is full when size becomes equal to the capacity
    boolean isFull() {
        return (size == capacity);
    }
    // Queue is empty when size is 0
    boolean isEmpty() {
        return (size == 0);
    }
    // Method to add an item to the queue. It changes rear and size
    void enqueue(int item) {
        if (isFull()) {
            System.out.println("Queue is full. Cannot enqueue " + item);
            return;
        }
        rear = (rear + 1) % capacity; // Circular increment
        array[rear] = item;           // Add item to the queue
        size++;
        System.out.println(item + " enqueued to queue");
    }
    // Method to remove an item from the queue. It changes front and size
    int dequeue() {
        if (isEmpty()) {
            System.out.println("Queue is empty. Cannot dequeue.");
            return Integer.MIN_VALUE;
        }

        int item = array[front];      // Get the front item
        front = (front + 1) % capacity; // Circular increment
        size--;
        return item;
    }
    // Method to get front of the queue
    int front() {
        if (isEmpty()) {
            System.out.println("Queue is empty. No front element.");
            return Integer.MIN_VALUE;
        }
        return array[front];
    }
    // Method to get rear of the queue
    int rear() {
        if (isEmpty()) {
            System.out.println("Queue is empty. No rear element.");
            return Integer.MIN_VALUE;
        }
        return array[rear];
    }
}

// Driver class
class TestArrayQueue {
    public static void main(String[] args) {
        ArrayQueue queue = new ArrayQueue(1000);

        // Enqueue elements
        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);
        queue.enqueue(40);

        // Dequeue an element
        System.out.println(queue.dequeue() + " dequeued from queue\n");

        // Display front and rear elements
        System.out.println("Front item is " + queue.front());
        System.out.println("Rear item is " + queue.rear());
    }
}

