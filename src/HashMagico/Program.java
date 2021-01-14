package HashMagico;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Program {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        var numberOfTests = Integer.parseInt(br.readLine());
        var letters = Arrays.asList("abcdefghijklmnopqrstuvwxyz".toUpperCase().split(""));
        String[] line;
        var response = 0;

        for (int i = 0; i < numberOfTests; i++) {

            var numberOfLines = Integer.parseInt(br.readLine());

            for (int j = 0; j < numberOfLines; j++) {

                line = new String[numberOfLines];
                line[j] = br.readLine();
                var splits = line[j].split("");

                for (int x = 0; x < splits.length; x++) {

                    if (letters.contains(splits[x])) {
                        response += letters.indexOf(splits[x]) + j + x;
                    }

                }
            }
            System.out.println(response);
            response = 0;

        }
    }
}
