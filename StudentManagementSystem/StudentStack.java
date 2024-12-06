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

        long startTime = System.nanoTime(); // Ghi lại thời gian bắt đầu
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
        long endTime = System.nanoTime(); // Ghi lại thời gian kết thúc
        long duration = endTime - startTime; // Tính thời gian thực hiện
        System.out.println("Students sorted by score using Bubble Sort.");
        System.out.println("Time taken for sorting: " + duration + " nanoseconds.");
    }

    // Merge Sort by score
    public void mergeSortByScore() {
        if (isEmpty()) {
            System.out.println("Stack is empty, cannot sort.");
            return;
        }
        long startTime = System.nanoTime(); // Ghi lại thời gian bắt đầu
        mergeSort(0, top);
        long endTime = System.nanoTime(); // Ghi lại thời gian kết thúc
        long duration = endTime - startTime; // Tính thời gian thực hiện
        System.out.println("Students sorted by score using Merge Sort.");
        System.out.println("Time taken for sorting: " + duration + " nanoseconds.");
    }

    private void mergeSort(int left, int right) {
        if (left < right) {
            int middle = (left + right) / 2;

            // Gọi đệ quy để chia
            mergeSort(left, middle);
            mergeSort(middle + 1, right);

            // Hợp nhất các mảng đã sắp xếp
            merge(left, middle, right);
        }
    }

    private void merge(int left, int middle, int right) {
        int n1 = middle - left + 1;
        int n2 = right - middle;

        Student[] leftArray = new Student[n1];
        Student[] rightArray = new Student[n2];

        // Sao chép dữ liệu vào các mảng tạm
        for (int i = 0; i < n1; i++) {
            leftArray[i] = stackArray[left + i];
        }
        for (int j = 0; j < n2; j++) {
            rightArray[j] = stackArray[middle + 1 + j];
        }

        // Hợp nhất các mảng tạm
        int i = 0, j = 0;
        int k = left;
        while (i < n1 && j < n2) {
            if (leftArray[i].getScore() <= rightArray[j].getScore()) {
                stackArray[k] = leftArray[i];
                i++;
            } else {
                stackArray[k] = rightArray[j];
                j++;
            }
            k++;
        }

        // Sao chép các phần tử còn lại
        while (i < n1) {
            stackArray[k] = leftArray[i];
            i++;
            k++;
        }

        while (j < n2) {
            stackArray[k] = rightArray[j];
            j++;
            k++;
        }
    }

    // Phương thức để hiển thị tất cả sinh viên đã sắp xếp theo điểm
    public void displayAllSortedByScore() {
        mergeSortByScore(); // Sắp xếp sinh viên trước
        displayAll(); // Hiển thị danh sách đã sắp xếp
    }
}


