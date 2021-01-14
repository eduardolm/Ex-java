/**
 * Desafio
 *
 * Validador de Senhas com Requisitos
 *
 * Pedro e Fernando são os desenvolvedores em uma stratup e vão desenvolver o novo sistema de cadastro, e pediram a
 * sua ajuda. Sua task é fazer o código que valide as senhas que são cadastradas, para isso você deve atentar aos
 * requisitos a seguir:
 *
 * A senha deve conter, no mínimo, uma letra maiúscula, uma letra minúscula e um número;
 * A mesma não pode ter nenhum caractere de pontuação, acentuação ou espaço;
 * Além disso, a senha pode ter de 6 a 32 caracteres.
 * Entrada
 * A entrada contém vários casos de teste e termina com final de arquivo. Cada linha tem uma string S, correspondente
 * a senha que é inserida pelo usuário no momento do cadastro.
 *
 * Saída
 * A saída contém uma linha, que pode ser “Senha valida.”, caso a senha tenha cada item dos requisitos solicitados
 * anteriormente, ou “Senha invalida.”, se um ou mais requisitos não forem atendidos.
 *
 *
 * Exemplo de Entrada                   Exemplo de Saída
 * Digital Innovation One               Senha invalida.
 *
 * AbcdEfgh99                           Senha valida.
 *
 * DigitalInnovationOne123              Senha valida.
 *
 * Digital Innovation One 123           Senha invalida.
 *
 * Aass9                                Senha invalida.
 *
 * Aassd9                               Senha valida.
 *
 */

package ValidadorSenhasComRequisitos;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

public class Program {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input;

        while ((input = br.readLine()) != null) {

            if (isValidPassword(input)) {
                System.out.println("Senha valida.");
            }
            else {
                System.out.println("Senha invalida.");
            }
        }
    }

    private static int getItemCount(String input, String pattern) {
        int count = 0;

        try {
            Pattern p = Pattern.compile(pattern);
            Matcher m = p.matcher(input);

            while (m.find()) {
                count++;
            }
        }
        catch (PatternSyntaxException ex) {
            System.err.println("Falha ao testar a entrada \"" + input + "\" em busca de \"" + pattern + "\"!");
            ex.printStackTrace(System.err);
        }
        return count;
    }

    private static boolean isValidPassword(String input) {
        return input.length() >= 6 && input.length() <= 32 && getItemCount(input, "[A-Z]") > 0 &&
                getItemCount(input, "[a-z]") > 0 && getItemCount(input, "[0-9]") > 0 &&
                getItemCount(input, "[^a-zA-Z0-9]+") == 0;
    }
}
