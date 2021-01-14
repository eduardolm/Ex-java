package TesteMaster;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Program {

    public static void main(String[] args) {

        Scanner scr = new Scanner(System.in);
        List<String> listaAlunos = new ArrayList<>();

        int size;
        String aluno;
        String valorFicha;
        int studentNaumber;
        int currentIndex;
        int outIndex;

        size = Integer.parseInt(scr.next());

        while (size > 0) {

            for (int i = 0; i < size; i++) {

                aluno = scr.next();
                valorFicha = scr.next();
                listaAlunos.add(aluno.trim() + " " + valorFicha.trim());

            }

            currentIndex = 0;
            outIndex = 0;
            studentNaumber = Integer.parseInt(listaAlunos.get(currentIndex).split(" ")[1]);

            for (int i = 0; i < size - 1; i++) {

                if (studentNaumber % 2 == 0) {

                    outIndex = (listaAlunos.size() - (studentNaumber % listaAlunos.size()) + currentIndex) % listaAlunos.size();

                } else if (studentNaumber % 2 != 0) {

                    outIndex = (studentNaumber % listaAlunos.size() + currentIndex) % listaAlunos.size();

                }

                studentNaumber = Integer.parseInt(listaAlunos.get(outIndex).split(" ")[1]);
                listaAlunos.remove(outIndex);

                currentIndex = (studentNaumber % 2 == 0) ?
                        ((outIndex <= listaAlunos.size() - 1) ?
                                outIndex : 0):
                        ((outIndex == 0) ?
                                (listaAlunos.size() - 1):(outIndex - 1));

            }

            System.out.println("Vencedor(a): " + listaAlunos.get(0).split(" ")[0]);

            listaAlunos.clear();
            size = Integer.parseInt(scr.next());

        }

        scr.close();

    }

}