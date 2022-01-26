import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class ChallengesJava {
    public static void main(String[] args) {
        //palindromo();
        //calculo();
        //fibonacci();
        //primos();
    }

    /*
    Exemplo de lista: batata, ana, cenoura, renner
    Exemplo de resposta: ana, renner
    DEVOLVER UMA LISTA CONTENDO TODOS OS TEXTOS OU PALAVRAS QUE SAO PALINDROMAS
     */
    private static List<String> palindromo(){
        String palindromo = "";
        List<String> palavras = Arrays.asList("BATATA", "ANA", "TIJOLO", "RENNER", "REVIVER", "MARTELO", "A SACADA DA CASA");
        palavras.forEach(p -> p.replaceAll(" ", ""));
        List<String> palavrasPalindromas = new ArrayList<>();

        for (String palavra : palavras) {
            for(int i = palavra.length() -1; i >= 0; i--){
                palindromo += palavra.charAt(i);
            }
            if(palindromo.equals(palavra))
                palavrasPalindromas.add(palavra);

            palindromo = "";
        }
        return palavrasPalindromas;
    }

    /*
    Exemplo de sequencia: 51.5, 127.25, ...
    formula: x * 3 + 100 / 2 onde x inicia em 1
    DEVOLVER UMA LISTA CONTENDO TODOS VALORES DESTA FUNÇÃO QUE SÃO MENEOES QUE 500
     */
    private static List<Double> calculo() {
        Double x = Double.valueOf(1);
        List<Double> valores = new ArrayList<>();

        while(x<500){
            x = ((x * 3) +100) / 2;
            if (x < 500)
                valores.add(x);
        }
        return valores;
    }
    /*
    Exemplo de sequencia: 1, 1 ,2 ,3 ,5 ,8 ,13 ,21 ,...
    formula: valor atual + valor anterior
    DEVOLVER UMA LISTA CONTENDO TODOS VALORES FIBONACCI QUE SÃO MENORES QUE 300
    PRINTAR TODOS OS VALORES PARES
     */
    private static List<Integer> fibonacci() {
        Integer x = 1;
        Integer y = 0;
        List<Integer> valores = new ArrayList<>();

        while(x <300){
            x = x + y;
            y = x - y;
            if (x < 300)
                valores.add(x);

            if (x %2 == 0)
                System.out.println(x);
        }
        return valores;
    }
    /*
    Exemplo de primos: 2, 3, 5, 7, 11, 13, ...
    formula: todos valores que são divisiveis por 1 e por ele mesmo, não pode ser divisivel por outros valores
    DEVOLVER UMA LISTA COM TODOS OS NUMEROS PRIMOS MENORES QUE 500
    PRINTAR TODOS NA TELA
     */
    private static List<Integer> primos() {
        List<Integer> valores = new ArrayList<>();
        for (int i = 2; i < 500; i++) {
            if( SeForPrimo(i) ){
                System.out.println(i + " é primo.");
                valores.add(i);
            }
        }
        return valores;
    }
    private static boolean SeForPrimo(int numero) {
        for (int j = 2; j < numero; j++) {
            if (numero % j == 0)
                return false;
        }
        return true;
    }
}
