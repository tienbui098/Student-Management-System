package org.StudentManagementSystem;

public class StudentStack {
    private Student[] stackArray;
    private int top;

    public StudentStack(int maxSize) {
        stackArray = new Student[maxSize];
        top = -1; // Chỉ số của phần tử trên cùng
    }


    // Kiểm tra xem sinh viên có trùng ID không
    private boolean isDuplicate(String id) {
        for (int i = 0; i <= top; i++) {
            if (stackArray[i].getId().equals(id)) {
                return true; // Tìm thấy ID trùng
            }
        }
        return false; // Không tìm thấy ID trùng
    }


    // Thêm sinh viên vào ngăn xếp
    public void push(Student student) {
        if (isDuplicate(student.getId())) {
            System.out.println("Student with ID " + student.getId() + " already exists. Cannot add duplicate student.");
            return;
        }
        if (top < stackArray.length - 1) {
            stackArray[++top] = student; // Thêm sinh viên vào ngăn xếp
            System.out.println("Added student: " + student);
        } else {
            System.out.println("Stack is full, cannot add students.");
        }
    }

    // Lấy sinh viên ra khỏi ngăn xếp
    public Student pop() {
        if (!isEmpty()) {
            Student student = stackArray[top];
            stackArray[top--] = null; // Giảm top và xóa phần tử
            System.out.println("Taken student: " + student);
            return student;
        } else {
            System.out.println("Stack is empty, cannot get student.");
            return null;
        }
    }

    // Xem sinh viên ở đỉnh ngăn xếp
    public Student peek() {
        if (!isEmpty()) {
            return stackArray[top]; // Trả về sinh viên ở đỉnh
        } else {
            System.out.println("Stack is empty, cannot get student.");
            return null;
        }
    }

    // Kiểm tra xem ngăn xếp có rỗng không
    public boolean isEmpty() {
        return top == -1; // Ngăn xếp rỗng nếu top là -1
    }

    // Phương thức để tìm kiếm sinh viên theo ID
    public Student search(String id) {
        for (int i = 0; i <= top; i++) {
            if (stackArray[i].getId().equals(id)) {
                return stackArray[i];
            }
        }
        return null; // Không tìm thấy
    }

    // Phương thức để hiển thị tất cả sinh viên
    public void displayAll() {
        if (isEmpty()) {
            System.out.println("Empty stack.");
            return;
        }
        for (int i = 0; i <= top; i++) {
            System.out.println(stackArray[i]);
        }
    }

    public void bubbleSortByScore() {
        if (isEmpty()) {
            System.out.println("Stack is empty, cannot sort.");
            return;
        }

        for (int i = 0; i < top; i++) {
            for (int j = 0; j < top - i; j++) {
                if (stackArray[j].getScore() > stackArray[j + 1].getScore()) {
                    // Hoán đổi
                    Student temp = stackArray[j];
                    stackArray[j] = stackArray[j + 1];
                    stackArray[j + 1] = temp;
                }
            }
        }
        System.out.println("Students sorted by score.");
    }

    // Insertion Sort by score
    public void insertionSortByScore() {
        if (isEmpty()) {
            System.out.println("Stack is empty, cannot sort.");
            return;
        }

        for (int i = 1; i <= top; i++) {
            Student key = stackArray[i];
            int j = i - 1;

            // Move elements of stackArray[0..i-1], that are greater than key,
            // to one position ahead of their current position
            while (j >= 0 && stackArray[j].getScore() < key.getScore()) {
                stackArray[j + 1] = stackArray[j];
                j = j - 1;
            }
            stackArray[j + 1] = key;
        }
        System.out.println("Students sorted by score using Insertion Sort.");
    }

    // Method to display all students sorted by score
    public void displayAllSortedByScore() {
        insertionSortByScore(); // Sort the students first
        displayAll(); // Display the sorted list
    }

}
