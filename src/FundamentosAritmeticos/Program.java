package FundamentosAritmeticos;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Program {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Double[] numbers = new Double[6];
        int count = 0;

        for (int i = 0; i < 6; i++) {

            try {
                StringTokenizer st = new StringTokenizer(br.readLine()); // Lê a linha de entrada
                double number = Double.parseDouble(st.nextToken());

                if (number > 0) {
                    numbers[i] = number;
                    count++;
                }
            }
            catch (NumberFormatException e) {
                System.out.println(e.getMessage());
            }
        }

        System.out.println(count + " valores positivos");
    }
}
