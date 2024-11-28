package org.Queue;

import java.util.LinkedList;

public class FIFOQueue {
    public static void main(String[] args) {
        // Step 1: Initialize the queue
        java.util.Queue<String> queue = new LinkedList<>();
        // Step 2: Add elements to the queue
        queue.add("A");
        queue.add("B");
        queue.add("C");
        // Display the queue after adding elements
        System.out.println("Queue after adding A, B, C: " + queue);
        // Step 3: Perform dequeue operation
        String removedElement = queue.remove(); // Remove the first element
        System.out.println("Removed element: " + removedElement);
        // Display the queue after removing an element
        System.out.println("Queue after removal: " + queue);
        // Step 4: Add element D to the queue
        queue.add("D");
        System.out.println("Queue after adding D: " + queue);
        // Step 5: Perform dequeue operation again
        removedElement = queue.remove(); // Remove the first element
        System.out.println("Removed element: " + removedElement);
        // Display the final state of the queue
        System.out.println("Final queue: " + queue);
    }
}
