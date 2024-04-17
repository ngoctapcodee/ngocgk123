package Baitapgk;

import java.util.List;

public class Thread3 implements Runnable {
    List<Student> students;

    public Thread3(List<Student> students) {
        this.students = students;
    }

    public void run() {
        for (Student student : students) {
            // Kiểm tra xem tổng chữ số có phải là số nguyên tố không
            boolean isPrime = true;
            int sumOfDigits = student.sum;
            if (sumOfDigits < 2) {
                isPrime = false;
            } else {
                for (int i = 2; i <= Math.sqrt(sumOfDigits); i++) {
                    if (sumOfDigits % i == 0) {
                        isPrime = false;
                        break;
                    }
                }
            }

            if (isPrime) {
                System.out.println("ID: " + student.id + " Name: " + student.name + " Address: " + student.address + " Age: " + student.age + " Sum of date of birth digits: " + sumOfDigits + " is a prime number");
            } else {
                System.out.println("ID: " + student.id + " Name: " + student.name + " Address: " + student.address + " Age: " + student.age + " Sum of date of birth digits: " + sumOfDigits + " is not a prime number");
            }
        }
    }
}
