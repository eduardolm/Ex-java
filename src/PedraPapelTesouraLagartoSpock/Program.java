/**
 * Desafio
 *
 * Pedra-papel-tesoura-lagarto-Spock
 *
 * Pedra-papel-tesoura-lagarto-Spock é uma expansão do clássico método de seleção em jogo de pedra-papel-tesoura.
 * Atua sob o mesmo princípio básico, mas inclui outras duas armas adicionais: o lagarto (formado pela mão igual a
 * uma boca de fantoche) e Spock (formada pela saudação dos vulcanos em Star Trek). Isso reduz as chances de uma
 * rodada terminar em um empate. O jogo foi inventado por Sam Kass e Karen Bryla, como "Rock Paper Scissors Lizard
 * Spock". As regras de vantagem são as seguintes:
 *
 * Tesoura corta papel
 * Papel cobre pedra
 * Pedra derruba lagarto
 * Lagarto adormece Spock
 * Spock derrete tesoura
 * Tesoura prende lagarto
 * Lagarto come papel
 * Papel refuta Spock
 * Spock vaporiza pedra
 * Pedra quebra tesoura
 *
 * Um dia, duas amigas, Fernanda e Marcia, decidiram apostar quem pagaria um almoço para o outro, com esta brincadeira.
 * Sua missão será fazer um algoritmo que, baseado no que eles escolherem, informe quem irá ganhar ou se dará empate.
 *
 * Entrada
 * Haverá diversos casos de teste. O primeiro número a ser lido será um inteiro, representando a quantidade de casos
 * de teste. Cada caso de teste tem duas palavras, representando a escolha de Fernanda e de Marcia, respectivamente.
 *
 * Saída
 * Para cada caso de teste, imprima quem venceu, ou se houve empate.
 *
 *
 * Exemplo de Entrada	Exemplo de Saída
 * 3
 *
 * spock spock          empate
 *
 * tesoura spock        Marcia
 *
 * lagarto spock        Fernanda
 *
 */

package PedraPapelTesouraLagartoSpock;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Program {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int number = Integer.parseInt(br.readLine());
        int count = 1;
        String[] input = new String[2];

        while (count <= number) {

            input = br.readLine().toLowerCase().split(" ");

            switch (input[0]) {
                case "pedra" -> {
                    switch (input[1]) {
                        case "lagarto", "tesoura" -> System.out.println("fernanda");
                        case "pedra" -> System.out.println("empate");
                        default -> System.out.println("marcia");
                    }
                }
                case "papel" -> {
                    switch (input[1]) {
                        case "pedra", "spock" -> System.out.println("fernanda");
                        case "papel" -> System.out.println("empate");
                        default -> System.out.println("marcia");
                    }
                }
                case "tesoura" -> {
                    switch (input[1]) {
                        case "lagarto", "papel" -> System.out.println("fernanda");
                        case "tesoura" -> System.out.println("empate");
                        default -> System.out.println("marcia");
                    }
                }
                case "lagarto" -> {
                    switch (input[1]) {
                        case "papel", "spock" -> System.out.println("fernanda");
                        case "lagarto" -> System.out.println("empate");
                        default -> System.out.println("marcia");
                    }
                }
                case "spock" -> {
                    switch (input[1]) {
                        case "pedra", "tesoura" -> System.out.println("fernanda");
                        case "spock" -> System.out.println("empate");
                        default -> System.out.println("marcia");
                    }
                }
            }
            count++;
        }
    }
}
