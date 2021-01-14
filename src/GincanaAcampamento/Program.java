package GincanaAcampamento;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Program {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int num;
        String tempNum;
        num = Integer.parseInt(st.nextToken());

        while (num > 0) {
            // Le as entradas

            List<Integer> numeros = new ArrayList<>();
            Crianca[] criancas = new Crianca[num];

            // Preenche a lista com as crianças
            for (int i = 0; i < num; i++) {
                String temp = br.readLine();
                String[] tempList = temp.split(" ");
                criancas[i] = new Crianca(tempList[0], Integer.parseInt(tempList[1]));
                numeros.add(criancas[i].getNumero());
            }

            // Imprime a lista de crianças com números (Só para verificação)
            for (Crianca item : criancas) {
                System.out.println(item.getNome() + " - " + item.getNumero());
            }

            int studentNumber;
            int index = 0;
            int outIndex = 0;

            studentNumber = numeros.get(index);

            for (int i = 0; i < num - 1; i++) {
                if (studentNumber % 2 == 0) {
                    outIndex = (numeros.size() - (studentNumber % numeros.size()) + index) % numeros.size();
                }
                else {
                    outIndex = (studentNumber % numeros.size() + index) % numeros.size();
                }
                studentNumber = numeros.get(outIndex);
                numeros.remove(outIndex);

                index = (studentNumber % 2 == 0) ? ((outIndex <= numeros.size() - 1) ? outIndex : 0) :
                        ((outIndex == 0) ? (numeros.size() - 1) : (outIndex - 1));
            }
            for (var item : criancas){
                if (numeros.get(0).equals(item.getNumero())) System.out.println("Vencedor(a): " + item.getNome());
            }

            numeros.clear();
            tempNum = br.readLine();
            num = Integer.parseInt(tempNum);
        }
    }
}

class Crianca {
    String nome;
    int numero;

    public Crianca(String nome, int numero) {
        this.nome = nome;
        this.numero = numero;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }
}
