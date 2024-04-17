package Baitapgk;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

public class Thread2 implements Runnable {
    List<Student> students;

    public Thread2(List<Student> students) {
        this.students = students;
    }

    public void run() {
        for (Student student : students) {
            Calendar dob = Calendar.getInstance();
            try {
                dob.setTime(new SimpleDateFormat("yyyy-MM-dd").parse(student.dateOfBirth));
            } catch (ParseException e) {
                e.printStackTrace();
            }
            int age = Calendar.getInstance().get(Calendar.YEAR) - dob.get(Calendar.YEAR);
            student.age = age;

            student.sum = 0;
            String dobStr = student.dateOfBirth.replaceAll("-", ""); // Loại bỏ dấu -
            for (char c : dobStr.toCharArray()) {
                student.sum += Character.getNumericValue(c);
            }
        }
    }
}
