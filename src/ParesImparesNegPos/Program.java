package ParesImparesNegPos;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Program {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] numbers = new int[5];
        int countEven = 0;
        int countPos = 0;
        int countOdd = 0;
        int countNeg = 0;

        for (int i = 0;i < numbers.length; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine()); // Lê a linha de entrada
            numbers[i] = Integer.parseInt(st.nextToken());
            if (isEven(numbers[i]) || numbers[i] == 0) countEven++;
            if (!isEven(numbers[i])) countOdd++;
            if (isPositive(numbers[i])) countPos++;
            if (!isPositive(numbers[i]) && numbers[i] != 0) countNeg++;
        }
        System.out.println(countEven + " valor(es) par(es)");
        System.out.println(countOdd + " valor(es) impar(es)");
        System.out.println(countPos + " valor(es) positivo(s)");
        System.out.println(countNeg + " valor(es) negativo(s)");
    }

    public static boolean isEven(int n) {
        return n % 2 == 0;
    }

    public static boolean isPositive(int n) {
        return n > 0;
    }
}
