package org.MemoryStack;

public class Stack_Frame {
    // Method to find the product
    public static int findProduct(int a, int b) {
        int product = a * b;
        return product;
    }
    // Method to find the sum
    public static int findSum(int a, int b) {
        int sum = a + b;
        return sum;
    }
    // Main function
    public static void main(String[] args) {
        int a = 6;
        int b = 6;
        // Call findProduct method
        int product = findProduct(a, b);
        // Call findSum method
        int sum = findSum(a, b);
        System.out.println("Product is: " + product);
        System.out.println("Sum is: " + sum);
    }
}
