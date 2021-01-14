/**
 * Desafio
 *
 * Quantidade de números positivos
 *
 * Crie um programa que leia 6 valores. Você poderá receber valores negativos e/ou positivos como entrada, devendo
 * desconsiderar os valores nulos. Em seguida, apresente a quantidade de valores positivos digitados.
 *
 * Entrada
 * Você receberá seis valores, negativos e/ou positivos.
 *
 * Saída
 * Exiba uma mensagem dizendo quantos valores positivos foram lidos assim como é exibido abaixo no exemplo de saída.
 * Não esqueça da mensagem "valores positivos" ao final.
 *
 *
 * Exemplo de Entrada	Exemplo de Saída
 * 7                    4 valores positivos
 * -5
 * 6
 * -3.4
 * 4.6
 * 12
 *
 */

package NumerosPositivos;

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
