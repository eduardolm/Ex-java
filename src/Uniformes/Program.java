/**
 * Desafio
 *
 * Uniformes de final de ano
 *
 * O professor Girafales organizou a confecção de um uniforme para as turmas da escola para comemorar o final do ano.
 * Após algumas conversas, ficou decidido com os alunos que eles poderiam escolher a cor do uniforme entre branco ou
 * vermelho. Assim sendo, Girafales precisa de sua ajuda para organizar as listas de quem quer o uniforme em cada uma
 * das turmas, relacionando estas camisetas pela cor, tamanho (P, M ou G) e por último pelo nome.
 *
 * Entrada
 * Cada caso de teste inicia com um valor N, (1 ≤ N ≤ 60) inteiro e positivo, que indica a quantidade de uniformes a
 * serem feitas para aquela turma. As próximas N*2 linhas contém informações de cada um dos uniformes (serão duas
 * linhas de informação para cada uniforme). A primeira linha irá conter o nome do estudante e a segunda linha irá
 * conter a cor do uniforme ("branco" ou "vermelho") seguido por um espaço e pelo tamanho do uniforme "P" "M" ou "G".
 * A entrada termina quando o valor de N for igual a zero (0) e esta valor não deverá ser processado.
 *
 * Saída
 * Para cada caso de entrada deverão ser impressas as informações ordenadas pela cor em ordem ascendente, seguido pelos
 * tamanhos em ordem descendente e por último por ordem ascendente de nome, conforme o exemplo abaixo.
 *
 *
 *
 * Exemplo de Entrada	        Exemplo de Saída
 * 9                            branco P Cezar Torres Mo
 * Maria Jose                   branco P Maria Jose
 * branco P                     branco M JuJu Mentina
 * Mangojata Mancuda            branco G Adabi Finho
 * vermelho P                   branco G Severina Rigudinha
 * Cezar Torres Mo              vermelho P Amaro Dinha
 * branco P                     vermelho P Baka Lhau
 * Baka Lhau                    vermelho P Carlos Chade Losna
 * vermelho P                   vermelho P Mangojata Mancuda
 * JuJu Mentina
 * branco M
 * Amaro Dinha
 * vermelho P
 * Adabi Finho
 * branco G
 * Severina Rigudinha
 * branco G
 * Carlos Chade Losna
 * vermelho P
 * 0
 *
 */

package Uniformes;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Program {

    public static void main(String[] args) throws IOException {

        Checker checker = new Checker();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int num = Integer.parseInt(st.nextToken());
        Uniforme[] uniformes = new Uniforme[num];

        for (int i = 0; i < num; i++) {
            String firstLine = br.readLine();
            String secondLine = br.readLine();
            String[] temp = secondLine.split(" ");
            uniformes[i] = new Uniforme(firstLine, temp[0], temp[1]);

        }
        Arrays.sort(uniformes, checker);
        for (var item : uniformes) {
            System.out.print(item.getCor() + " " + item.getTamanho() + " " + item.getNome() + "\n");
        }
    }
}

class Uniforme {

    public String nome;
    public String cor;
    public String tamanho;

    public Uniforme(String nome, String cor, String tamanho) {
        this.nome = nome;
        this.cor = cor;
        this.tamanho = tamanho;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public String getTamanho() {
        return tamanho;
    }

    public void setTamanho(String tamanho) {
        this.tamanho = tamanho;
    }
}

class Checker implements Comparator<Uniforme> {

    @Override
    public int compare(Uniforme o1, Uniforme o2) {
        if (o1.getCor().compareTo(o2.getCor()) > 0) return 1;
        if (o1.getCor().compareTo(o2.getCor()) < 0) return -1;
        if (o1.getTamanho().compareTo(o2.getTamanho()) > 0) return -1;
        if (o1.getTamanho().compareTo(o2.getTamanho()) < 0) return 1;
        return Integer.compare(o1.getNome().compareTo(o2.getNome()), 0);
    }
}
