package org.MemoryStack;

public class MemoryStack {
    public static int geeks() {
        // Nothing is allocated except the pointer p
        // which is allocated on the stack.
        char[] p;
        // Allocate memory on the stack.
        boolean flag = true;
        if (flag) {
            // Create 1000 bytes on stack
            char[] buffer = new char[1000];

            // Create 1000 bytes on heap
            p = new char[1000];
        }
        // The buffer's memory will be freed automatically
        // when it goes out of scope, but the pointer p does not
        // cause a memory leak in Java, because the Garbage Collector
        // will manage the memory of p.
        return 0;
    }
    public static void main(String[] args) {
        geeks();
    }
}



