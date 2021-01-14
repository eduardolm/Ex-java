package TabuleiroElcio;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class TabuleiroSecreto {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Integer tamanhoN, operacoesQ, operacao, linColX, count, valorR = null;

        List<String> dadosIniciais, comando;

        Map<Integer,Integer> estatistica = new HashMap<>();

        dadosIniciais = Arrays.stream(br.readLine().split(" ")).collect(Collectors.toList());
        tamanhoN = Integer.parseInt(dadosIniciais.get(0));
        operacoesQ = Integer.parseInt(dadosIniciais.get(1));

        Integer[][] tabuleiro = new Integer[tamanhoN][tamanhoN];

        // Preencher todos os valores do Array com zero
        for (int i = 0; i < tamanhoN; i++) {
            for (int j = 0; j < tamanhoN; j++) {
                tabuleiro[i][j] = 0;
            }
        }

        for (int i = 0; i < operacoesQ; i++) {
            comando = Arrays.stream(br.readLine().split("\\s+")).collect(Collectors.toList());
            operacao = Integer.parseInt(comando.get(0));
            linColX = Integer.parseInt(comando.get(1));

            if (operacao == 1 || operacao == 2){
                valorR = Integer.parseInt(comando.get(2));
            }

            estatistica.clear();

            switch(operacao){
                case 1: // Atribuir R a todos números da linha X
                    for (int j = 0; j < tamanhoN; j++) {
                        tabuleiro[linColX-1][j] = valorR;
                    }
                    break;

                case 2: // Atribuir R a todos números da coluna X
                    for (int j = 0; j < tamanhoN; j++) {
                        tabuleiro[j][linColX-1] = valorR;
                    }
                    break;

                case 3: // Imprimir o valor mais frequente da linha X
                    for (int j = 0; j < tamanhoN; j++) {

                        // Conta a ocorrência de cada número na linha X do tabuleiro
                        if(estatistica.containsKey(tabuleiro[linColX-1][j])) {

                            count = estatistica.get(tabuleiro[linColX-1][j]);
                            count++;
                            estatistica.put(tabuleiro[linColX-1][j], count);

                        } else {

                            estatistica.put(tabuleiro[linColX-1][j], 1);

                        }
                    }
                    System.out.println(verificarMaiorNumeroMaisFrequente(estatistica));
                    break;

                case 4: // Imprimir o valor mais frequente da coluna X
                    for (int j = 0; j < tamanhoN; j++) {

                        // Conta a ocorrência de cada número na coluna X do tabuleiro
                        if(estatistica.containsKey(tabuleiro[j][linColX-1])) {

                            count = estatistica.get(tabuleiro[j][linColX-1]);
                            count++;
                            estatistica.put(tabuleiro[j][linColX-1], count);

                        } else {

                            estatistica.put(tabuleiro[j][linColX-1], 1);

                        }
                    }
                    System.out.println(verificarMaiorNumeroMaisFrequente(estatistica));
                    break;
            }
        }
    }

    private static Integer verificarMaiorNumeroMaisFrequente(Map<Integer,Integer> estatistica){
        Integer maxfreq;
        List<Integer> numeros;
        List<Integer> numerosMaisFrequentes = new ArrayList<>();

        maxfreq = Collections.max(estatistica.values());
        numeros = new ArrayList<>(estatistica.keySet());

        // Lista os números com maiores ocorrências
        for (int i = 0; i < numeros.size(); i++) {
            if(estatistica.get(numeros.get(i)) >= maxfreq){
                numerosMaisFrequentes.add(numeros.get(i));
            }
        }

        // Retorna o maior número mais frequente
        return Collections.max(numerosMaisFrequentes);
    }
}