package Escolhido2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Program {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int num = Integer.parseInt(st.nextToken());
        String[] lists = new String[num];
        Double[] studentGrades = new Double[num];
        Integer[] studentId = new Integer[num];
        double highestGrade = 0.0;
        int index = 0;

        for (int i = 0; i < num; i++) {
            lists[i] = br.readLine();
            String[] splitted = lists[i].split(" ");
            studentGrades[i] = Double.parseDouble(splitted[1]);
            studentId[i] = Integer.parseInt(splitted[0]);
        }

        for (int i = 0; i < num; i++) {
            if (studentGrades[i] > highestGrade) {
                highestGrade = studentGrades[i];
                index = i;
            }
        }

        if (highestGrade < 8) {
            System.out.println("Minimum note not reached");
        }
        else {
            System.out.println(studentId[index]);
        }
    }
}
