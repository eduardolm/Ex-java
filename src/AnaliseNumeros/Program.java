/**
 * Desafio
 *
 * Análise de números
 *
 * Você deve fazer a leitura de 5 valores inteiros. Em seguida mostre quantos valores informados são pares, quantos
 * valores informados são ímpares, quantos valores informados são positivos e quantos valores informados são negativos.
 *
 * Entrada
 * Você receberá 5 valores inteiros.
 *
 * Saída
 * Exiba a mensagem conforme o exemplo de saída abaixo, sendo uma mensagem por linha e não esquecendo o final de linha
 * após cada uma.
 *
 *
 * Exemplo de Entrada	Exemplo de Saída
 * -5                   3 valor(es) par(es)
 * 0                    2 valor(es) impar(es)
 * -3                   1 valor(es) positivo(s)
 * -4                   3 valor(es) negativo(s)
 * 12
 *
 */

package AnaliseNumeros;

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
        System.out.println(countEven + " valor(es) par(es)\n");
        System.out.println(countOdd + " valor(es) impar(es)\n");
        System.out.println(countPos + " valor(es) positivo(s)\n");
        System.out.println(countNeg + " valor(es) negativo(s)");
    }

    public static boolean isEven(int n) {
        return n % 2 == 0;
    }

    public static boolean isPositive(int n) {
        return n > 0;
    }
}
