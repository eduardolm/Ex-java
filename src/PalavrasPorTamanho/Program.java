/**
 * Desafio
 *
 * Ordenação de palavras por tamanho
 *
 * Crie um algoritmo para ordenar um conjunto de palavras pelo seu tamanho. Seu programa deve receber um conjunto de
 * palavras e retornar este mesmo conjunto ordenado pelo tamanho das palavras decrescente, se o tamanho das palavras
 * for igual, deve-se ordernar por ordem alfabética.
 *
 * Entrada
 * A primeira linha da entrada possui um único inteiro N, que indica o número de casos de teste. Cada caso de teste
 * poderá conter de 1 a 50 palavras inclusive, e cada uma das palavras poderá conter entre 1 e 50 caracteres inclusive.
 * Os caracteres poderão ser espaços, letras, ou números.
 *
 * Saída
 * A saída deve conter o conjunto de palavras da entrada ordenado pelo tamanho das palavras e caso o tamanho das
 * palavras for igual, deve-se ordernar por ordem alfabética.. Um espaço em branco deve ser impresso entre duas palavras.
 *
 *
 * Exemplo de Entrada	                    Exemplo de Saída
 * 2
 * One three four mond at midnight          midnight three four mond One at
 * one three five                           three five one
 *
 */

package PalavrasPorTamanho;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Program {

    public static void main(String[] args) throws IOException {

        // Lê quantos testes
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int num = Integer.parseInt(st.nextToken());
        String[] entrada = new String[num];
        Checker checker = new Checker();

        // Preenche a lista com os strings a serem ordenados
        for (int i = 0; i < num; i++) {
            entrada[i] = br.readLine();

            String[] temp = entrada[i].split(" ");
            Arrays.sort(temp, checker.reversed());
            System.out.println();
            for (String item : temp) {
                System.out.print(item + " ");
            }
        }
    }
}

class Checker implements Comparator<String> {

    @Override
    public int compare(String o1, String o2) {
        if (o1.length() > o2.length()) return 1;
        if (o1.length() < o2.length()) return -1;
        if (o1.compareTo(o2) > 0) return -1;
        if (o1.compareTo(o2) < 0) return 1;

        return Integer.compare(o1.compareTo(o2), 0);
    }
}
