package CoracaoCartas;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class Program {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int num = Integer.parseInt(st.nextToken());
        Stack<Integer> pilha1 = new Stack<>();
        Stack<Integer> pilha2 = new Stack<>();
        Stack<Integer> pilha3 = new Stack<>();

        while(num > 0) {

            /** Leitura dos valores das cartas */
            String[] lista = new String[num];
            for (int i = 0;i < num; i++) {
                lista[i] = br.readLine();
            }

            /** Atribuiçãp das cartas ao stack */
            for (int i = lista.length - 1; i >= 0; i--) {
                var tipo = Arrays.stream(lista[i].split(" ")).map(Integer::parseInt).collect(Collectors.toList());
                pilha1.push(tipo.get(0));
                pilha2.push(tipo.get(1));
                pilha3.push(tipo.get(2));
            }

            /** Verificação das condições e retirada dos valores das pilhas */
            for (int i = lista.length - 1; i >= 0; i--) {
                if (isDivisibleByThree(pilha1.get(i) + pilha2.get(i) + pilha3.get(i))) {
                    pilha1.pop();
                    pilha2.pop();
                    pilha3.pop();
                    continue;
                }
                if (isDivisibleByThree(pilha1.get(i) + pilha2.get(i))) {
                    pilha1.pop();
                    pilha2.pop();
                    continue;
                }
                if (isDivisibleByThree(pilha1.get(i) + pilha3.get(i))) {
                    pilha1.pop();
                    pilha3.pop();
                    continue;
                }
                if (isDivisibleByThree(pilha2.get(i) + pilha3.get(i))) {
                    pilha2.pop();
                    pilha3.pop();
                    continue;
                }
                if (isDivisibleByThree(pilha1.get(i))) {
                    pilha1.pop();
                }
                if (isDivisibleByThree(pilha2.get(i))) {
                    pilha2.pop();
                }
                if (isDivisibleByThree(pilha3.get(i))) {
                    pilha3.pop();
                }
            }

            /** Verificação final das pilhas e resposta */
            if (pilha1.empty() && pilha2.empty() && pilha3.empty()) {
                System.out.println(1);
            }
            else {
                System.out.println(0);
            }

            pilha1.clear();
            pilha2.clear();
            pilha3.clear();
            num = Integer.parseInt(br.readLine());
        }
    }

    static boolean isDivisibleByThree(int number) {
        if (number != 0) {
            return number % 3 == 0;
        }
        else {
            return false;
        }
    }
}
