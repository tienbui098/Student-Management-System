package org.SortingAlgorithms;

public class InsertionSort {
    public static void main(String[] args) {
        int[] array = {64, 34, 49, 15, 33, 10, 78}; // Example array to sort
        insertionSort(array); // Call the insertion sort method
        printArray(array); // Print the sorted array
    }
    static void insertionSort(int[] array) {
        int size = array.length; // Get the length of the array
        for (int step = 1; step < size; step++) {
            int key = array[step]; // Current element to be positioned
            int j = step - 1;

            // Compare key with each element on the left until a smaller element is found
            while (j >= 0 && key < array[j]) {
                array[j + 1] = array[j]; // Shift element to the right
                j--; // Move to the next element on the left
            }
            // Place key at the correct position
            array[j + 1] = key;
        }
    }
    // Method to print the elements of the array
    static void printArray(int[] array) {
        for (int value : array) {
            System.out.print(value + " ");
        }
        System.out.println(); // Move to the next line after printing the array
    }
}