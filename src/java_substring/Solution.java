package java_substring;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String teste = scanner.next();

        System.out.println(getSmallestAndLargest(teste));
    }

    public static int getSmallestAndLargest(String s) {
        HashSet<String> out = new HashSet<>();
        int count = 0;

        for (int i = 0; i < s.length(); i++) {
            String sub = s.substring(i, i+1);
            if (!out.contains(sub)) {
                out.add(sub);
                count = i;
            }
        }

        List<String> teste = new ArrayList<>();
        for (int i = 0; i < s.length(); i++){
            String sub = s.substring(i, i+1);

            teste.add(sub);
        }

        return Math.max(count, out.size());
    }
}
