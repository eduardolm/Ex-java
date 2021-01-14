/**
 * Desafio
 *
 * Ordenando números pares e ímpares
 *
 * Crie um programa onde você receberá valores inteiros não negativos como entrada.
 *
 * Ordene estes valores de acordo com o seguinte critério:
 *
 * Primeiro os Pares
 * Depois os Ímpares
 * Você deve exibir os pares em ordem crescente e na sequência os ímpares em ordem decrescente.
 *
 * Entrada
 * A primeira linha de entrada contém um único inteiro positivo N (1 < N < 10000) Este é o número de linhas de entrada
 * que vem logo a seguir. As próximas N linhas terão, cada uma delas, um valor inteiro não negativo.
 *
 * Saída
 * Exiba todos os valores lidos na entrada segundo a ordem apresentada acima. Cada número deve ser impresso em uma
 * linha, conforme exemplo de saída abaixo.
 *
 *
 * Exemplo de Entrada	Exemplo de Saída
 * 10                   4
 * 4                    32
 * 32                   34
 * 34                   98
 * 543                  654
 * 3456                 3456
 * 654                  6789
 * 567                  567
 * 87                   543
 * 6789                 87
 * 98
 *
 */

package OrdenandoParImpar;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Program {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        int[] numbers = new int[num];
        List<Integer> odd = new ArrayList<>();
        List<Integer> even = new ArrayList<>();

        for (int i = 0;i < num; i++) {
            numbers[i] = scanner.nextInt();

            if (numbers[i] % 2 == 0) {
                even.add(numbers[i]);
            }
            else {
                odd.add(numbers[i]);
            }
        }

        Collections.sort(even);
        Collections.sort(odd, Collections.reverseOrder());

        for (int item : even) {
            System.out.println(item);
        }

        for (int item : odd) {
            System.out.println(item);
        }
    }
}
