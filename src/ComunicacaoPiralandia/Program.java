package ComunicacaoPiralandia;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Program {

    public static void main(String[] args) {

        String output = "";
        Scanner scanner = new Scanner(System.in);
        String input = scanner.next();
        String[] splitted = input.split("");

        Collections.reverse(Arrays.asList(splitted));

        for (var item : splitted) {
            output += item;
        }

        System.out.println(output);
    }
}
