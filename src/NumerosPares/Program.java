/**
 * Desafios
 *
 * Exibindo números pares
 *
 * Crie um programa que leia um número e mostre os números pares até esse número, inclusive ele mesmo.
 *
 * Entrada
 * Você receberá 1 valor inteiro N, onde N > 0.
 *
 * Saída
 * Exiba todos os números pares até o valor de entrada, sendo um em cada linha.
 *
 *
 * Exemplo de Entrada	Exemplo de Saída
 * 6                    2
 *                      4
 *                      6
 */

package NumerosPares;

import java.util.Scanner;

public class Program {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        for (int i = 2;i <= num; i+=2) {
            if (ePar(i)) {
                System.out.println(i);
            }
        }
    }

    public static boolean ePar(int n) {
        return n % 2 == 0;
    }
}
