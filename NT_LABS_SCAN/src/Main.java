import java.awt.*;
import java.util.ArrayList;

/**
 * @author Antonio Mateus
 * @version 0.02
 * @implNote Maquina de café que após escolher a opção devolve o troco em notas e moedas.
 */

public class Main {
    public static void main(String[] args) {
        ScanTutorial scan = new ScanTutorial();

        Integer indice = selectedItem(scan);
        Double valor = coletarValor(scan, indice);

        Double troco = valorTroco(indice, valor);
        System.out.println(Constants.MENSAGENS.TROCO_TOTAL + troco);
        System.out.println(Constants.MENSAGENS.OPTION + indice);
        System.out.println(Constants.MENSAGENS.VALOR + valor);
    }

    private static Integer selectedItem(ScanTutorial scan){
        boolean optionSelected = false;
        Integer indice = 0;
        do {
            System.out.println(Constants.MENSAGENS.INICIO);
            System.out.println(Constants.MENSAGENS.ITENS);

            indice = scan.coletarInteiro();

            if (indice > 0 && indice < 5){
                optionSelected = true;
            } else {
                System.out.println(Constants.ERROS.OPCAO_INVALIDA);
            }

        } while (optionSelected == false);

        return indice;
    }

    private static Double coletarValor(ScanTutorial scan, Integer indice) {
        Double valor = 0.0;
        boolean optionSelected = false;
        do {
            System.out.println(Constants.MENSAGENS.PAGAMENTO);
            valor = scan.coletarDouble();

            switch (indice) {
                case 1:
                    if (valor >= 3.50) {
                        optionSelected = true;
                    }
                    break;
                case 2:
                    if (valor >= 3.55) {
                        optionSelected = true;
                    }
                    break;
                case 3:
                    if (valor >= 3.25) {
                        optionSelected = true;
                    }
                    break;
                case 4:
                    if (valor >= 3.75) {
                        optionSelected = true;
                    }
                    break;
            }

            if (optionSelected == false) {
                System.out.println(Constants.ERROS.VALOR_INVALIDO);
            }
        } while (optionSelected == false);

        return valor;
    }

    private static Double valorTroco(Integer indice, Double valor){
        double troco = 0;
        switch (indice) {
            case 1:
                troco = valor - 3.50;
                if (troco != 0) {
                    devolverTroco(troco);
                }
                break;
            case 2:
                troco = valor - 3.55;
                if (troco != 0) {
                    devolverTroco(troco);
                }
                break;
            case 3:
                troco = valor - 3.25;
                if (troco != 0) {
                    devolverTroco(troco);
                }
                break;
            case 4:
                troco = valor - 3.75;
                if (troco != 0) {
                    devolverTroco(troco);
                }
                break;
        }
        return troco;
    }

    private static void devolverTroco(Double valorTroco){
        Integer[] cedulas = {100, 50, 20, 10, 5, 2, 1};
        Double[] moedas = {0.50, 0.25, 0.10, 0.05, 0.01};

        for (int cedula : cedulas) {
            if(valorTroco%cedula>=0) {
                valorTroco = verificaTrocoCedula(valorTroco, cedula);
            }
        }

        for (double moeda : moedas) {
            valorTroco =  verificaTrocoMoeda(valorTroco, moeda);
        }

        /*
            EXEMPLO . . .
            DIGAMOS QUE O TROCO SEJA 7,35

            1 - 5,00
            1 - 2,00
            1 - MOEDA 25
            1 - MOEDA 10
         */
    }

    // Calculos das Cedulas e Moedas pegando o resto da divisão e sempre reduzindo do valor do troco e retornando
    public static double verificaTrocoCedula(double valorTroco, int tipoCedula){
        double qtdCedulas = Math.floor(valorTroco/tipoCedula);
        if(qtdCedulas > 0){
            if(tipoCedula == 1) {
                System.out.println("O troco deve ter " + Math.floor(qtdCedulas) + " moeda de " + tipoCedula + " real");
            }else{
                System.out.println("O troco deve ter " + Math.floor(qtdCedulas) + " cedulas de " + tipoCedula + " reais");
            }
        }
        return valorTroco - (qtdCedulas * tipoCedula);
    }
    public static double verificaTrocoMoeda(double valorTroco, double tipoMoeda){
        if(valorTroco > 0) {
            double qtdMoedas = Math.floor((valorTroco*100) / (tipoMoeda*100));
            System.out.println("O troco deve ter " + qtdMoedas + " moedas de " + (tipoMoeda*100) + " centavos");
            return (valorTroco - (qtdMoedas * tipoMoeda) * 100);
        }
        return valorTroco;
    }
}