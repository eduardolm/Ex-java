package Escolhido;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Program {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int num = Integer.parseInt(st.nextToken());
        String[] lists = new String[num];
        Student[] students = new Student[num];
        Checker checker = new Checker();

        for (int i = 0; i < num; i++) {
            lists[i] = br.readLine();
            String[] splitted = lists[i].split(" ");
            students[i] = new Student(Integer.parseInt(splitted[0]), Double.parseDouble(splitted[1]));
        }

        Arrays.sort(students, checker);

        if (students[0].getGrade() < 8) {
            System.out.println("Minimum note not reached");
        }
        else {
            System.out.println(students[0].getStudentId());
        }
    }
}

class Checker implements Comparator<Student> {

    @Override
    public int compare(Student s1, Student s2) {
        return Double.compare(s2.getGrade(), s1.getGrade());
    }
}

class Student {

    private int studentId;
    private double grade;

    public Student(int studentId, double grade) {
        this.studentId = studentId;
        this.grade = grade;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public double getGrade() {
        return grade;
    }

    public void setGrade(double grade) {
        this.grade = grade;
    }
}
