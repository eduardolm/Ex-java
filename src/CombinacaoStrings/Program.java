package CombinacaoStrings;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Program {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String response = "";
        var count = 0;
        var number = Integer.parseInt(br.readLine());

        for (int i = 0; i < number; i++) {
            var line = br.readLine();
            var splitted = line.split(" ");

            for (int x = 0; x < Math.min(splitted[0].length(), splitted[1].length()); x++) {
                response += splitted[0].split("")[x] + splitted[1].split("")[x];
                count++;
            }

            var largestString = Math.max(splitted[0].length(), splitted[1].length()) == splitted[0].length() ? splitted[0] : splitted[1];
            System.out.println(response + largestString.substring(count));
            count = 0;
            response = "";
        }

    }
}