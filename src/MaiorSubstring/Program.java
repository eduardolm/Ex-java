/**
 * Desafio
 *
 * Encontre a maior substring
 *
 * Encontre a maior substring comum entre as duas strings informadas. A substring pode ser qualquer parte da string,
 * inclusive ela toda. Se não houver subseqüência comum, a saída deve ser “0”. A comparação é case sensitive ('x' != 'X').
 *
 * Entrada
 * A entrada contém vários casos de teste. Cada caso de teste é composto por duas linhas, cada uma contendo uma string.
 * Ambas strings de entrada contém entre 1 e 50 caracteres ('A'-'Z','a'-'z' ou espaço ' '), inclusive, ou no mínimo uma
 * letra ('A'-'Z','a'-'z').
 *
 * Saída
 * O tamanho da maior subsequência comum entre as duas Strings.
 *
 *
 * Exemplo de Entrada	            Exemplo de Saída
 * abcdef                           2
 * cdofhij
 * TWO                              1
 * FOUR
 * abracadabra                      0
 * open
 * Hey This java is hot             7
 * Java is a new paradigm
 *
 */

package MaiorSubstring;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Program {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int maxLength = 0;
        String entrada1 = br.readLine();
        String entrada2 = br.readLine();

        while (!isEmpty(entrada1)) {

            if (!isEmpty(entrada2)) {

                char[] str1 = entrada1.toCharArray();
                char[] str2 = entrada2.toCharArray();

                if (str1.length == 0 || str2.length == 0) break;

                var search = new Integer[str1.length + 1][str2.length + 1];

                for (int i = 0; i < str1.length + 1; i++) {
                    for (int j = 0; j < str2.length + 1; j++) {
                        search[i][j] = 0;
                    }
                }

                for (int i = 1; i < str1.length + 1; i++) {
                    for (int j = 1; j < str2.length + 1; j++) {
                        if (str1[i - 1] == str2[j - 1]) {
                            search[i][j] = search[i - 1][j - 1] + 1;

                            if (search[i][j] > maxLength) {
                                maxLength = search[i][j];
                            }
                        }
                    }
                }
                System.out.println(maxLength);
                maxLength = 0;
            }
            else {
                return;
            }
            entrada1 = br.readLine();
            entrada2 = br.readLine();
            }
        }

        static boolean isEmpty(String str) {
            return str == null || str.trim().isEmpty() || str.trim().isBlank();
        }
    }
