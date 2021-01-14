/**
 * Desafio
 *
 * Contagem de cédulas
 *
 * Faça a leitura de um valor inteiro. Em seguida, calcule o menor número de notas possíveis (cédulas) onde o valor
 * pode ser decomposto. As notas que você deve considerar são de 100, 50, 20, 10, 5, 2 e 1. Na sequência mostre o valor
 * lido e a relação de notas necessárias.
 *
 * Entrada
 * Você receberá um valor inteiro N (0 < N < 1000000).
 *
 * Saída
 * Exiba o valor lido e a quantidade mínima de notas de cada tipo necessárias, seguindo o exemplo de saída abaixo.
 * Após cada linha deve ser imprimido o fim de linha.
 *
 *
 * Exemplo de Entrada	Exemplo de Saída
 * 576                  576
 *                      5 nota(s) de R$ 100,00
 *                      1 nota(s) de R$ 50,00
 *                      1 nota(s) de R$ 20,00
 *                      0 nota(s) de R$ 10,00
 *                      1 nota(s) de R$ 5,00
 *                      0 nota(s) de R$ 2,00
 *                      1 nota(s) de R$ 1,00
 *
 * 11257                11257
 *                      112 nota(s) de R$ 100,00
 *                      1 nota(s) de R$ 50,00
 *                      0 nota(s) de R$ 20,00
 *                      0 nota(s) de R$ 10,00
 *                      1 nota(s) de R$ 5,00
 *                      1 nota(s) de R$ 2,00
 *                      0 nota(s) de R$ 1,00
 *
 * 503                  503
 *                      5 nota(s) de R$ 100,00
 *                      0 nota(s) de R$ 50,00
 *                      0 nota(s) de R$ 20,00
 *                      0 nota(s) de R$ 10,00
 *                      0 nota(s) de R$ 5,00
 *                      1 nota(s) de R$ 2,00
 *                      1 nota(s) de R$ 1,00
 */

package ContaCedulas;

import java.util.Scanner;

public class ContarCedulas {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        int[] cedulas = new int[7];
        scanner.close();

        System.out.println(num);
        if (num >= 100) {
            cedulas[0] = num / 100;
            num = num % 100;
        }

        if (num >= 50) {
            cedulas[1] = num / 50;
            num -= (num / 50) * 50;
        }

        if (num >= 20) {
            cedulas[2] = num / 20;
            num -= (num / 20) * 20;
        }

        if (num >= 10) {
            cedulas[3] = num / 10;
            num -= (num / 10) * 10;
        }

        if (num >= 5) {
            cedulas[4] = num / 5;
            num -= (num / 5) * 5;
        }

        if (num >= 2) {
            cedulas[5] = num / 2;
            num -= (num / 2) * 2;
        }

        if (num >= 1) {
            cedulas[6] = num;
        }
        System.out.println(cedulas[0] + " nota(s) de R$ 100,00");
        System.out.println(cedulas[1] + " nota(s) de R$ 50,00");
        System.out.println(cedulas[2] + " nota(s) de R$ 20,00");
        System.out.println(cedulas[3] + " nota(s) de R$ 10,00");
        System.out.println(cedulas[4] + " nota(s) de R$ 5,00");
        System.out.println(cedulas[5] + " nota(s) de R$ 2,00");
        System.out.println(cedulas[6] + " nota(s) de R$ 1,00");
    }
}
