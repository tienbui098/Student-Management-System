package org.SortingAlgorithms;

public class BubbleSort {
    public static void main(String[] args) {
        int[] arr = {64, 34, 49, 15, 33, 10, 78}; // Example array to sort
        bubbleSort(arr); // Call the bubble sort method
        printArray(arr);  // Print the sorted array
    }
    // Bubble sort method
    static void bubbleSort(int[] arr) {
        int n = arr.length; // Get the length of the array
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                // If the current element is greater than the next element, swap them
                if (arr[j] > arr[j + 1]) {
                    // Swap arr[j] and arr[j + 1]
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }
    // Method to print the elements of the array
    static void printArray(int[] arr) {
        for (int value : arr) {
            System.out.print(value + " ");
        }
        System.out.println(); // Move to the next line after printing the array
    }
}
