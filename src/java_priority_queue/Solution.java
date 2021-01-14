package java_priority_queue;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

class Student{
    private int id;
    private String name;
    private double cgpa;
    public Student(int id, String name, double cgpa) {
        super();
        this.id = id;
        this.name = name;
        this.cgpa = cgpa;
    }
    public int getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public double getCgpa() {
        return cgpa;
    }
}

class Priorities {
    public List<Student> getStudents(List<String> events) {
        List<Student> remainingStudents = new ArrayList<Student>();
        Checker checker = new Checker();

        for (String item : events) {
            String[] stArray= item.split(" ");
            if (stArray[0].equals("ENTER")) {
                Student student = new Student(Integer.parseInt(stArray[3]), stArray[1], Double.parseDouble(stArray[2]));
                remainingStudents.add(student);
            }
            else {
                if (!remainingStudents.isEmpty()) {
                    remainingStudents.sort(checker);
                    remainingStudents.remove(0);
                }
            }
        }
        return remainingStudents;
    }
}

class Checker implements Comparator<Student> {

    @Override
    public int compare(Student o1, Student o2) {
        if (o1.getCgpa() == o2.getCgpa()) {
            if (o1.getName().compareTo(o2.getName()) > 0) return 1;
            if (o1.getName().compareTo(o2.getName()) < 0) return -1;
            if (o1.getName().compareTo(o2.getName()) == 0) {
                if (o1.getId() < o2.getId()) return 1;
                if (o1.getId() > o2.getId()) return -1;
            }
        }
        else {
            if (o1.getCgpa() < o2.getCgpa()) return 1;
            if (o1.getCgpa() > o2.getCgpa()) return -1;
        }
        return 0;
    }
}

public class Solution {
    private final static Scanner scan = new Scanner(System.in);
    private final static Priorities priorities = new Priorities();

    public static void main(String[] args) {
        int totalEvents = Integer.parseInt(scan.nextLine());
        List<String> events = new ArrayList<>();

        while (totalEvents-- != 0) {
            String event = scan.nextLine();
            events.add(event);
        }

        List<Student> students = priorities.getStudents(events);

        if (students.isEmpty()) {
            System.out.println("EMPTY");
        } else {
            for (Student st: students) {
                System.out.println(st.getName());
            }
        }
    }
}
