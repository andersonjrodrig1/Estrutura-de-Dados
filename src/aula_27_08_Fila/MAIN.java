/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package aula_27_08_Fila;

import java.util.Scanner;

/**
 *
 * @author Anderson J Rodrigues
 */
public class MAIN {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
        // TODO code application logic here
        Principal();
    }

    public static void Principal() throws Exception {
        int op;
        do {
            op = menuPrincipal();
            while (op > 3 || op <= 0) {
                System.out.println("\nOpção Inválida!");
                op = menuPrincipal();
            }
            switch (op) {
                case 1: {
                    fila();
                    break;
                }
                case 2: {
                    filaPrioridade();
                    break;
                }
                default: {
                    System.out.println("\nPrograma finalizado pelo usuário.");
                    System.exit(0);
                }
            }
        } while (op <= 2 || op > 0);
    }

    public static int menuPrincipal() {
        Scanner scan = new Scanner(System.in);
        System.out.print("\n*** Menu Principal ***\n"
                + "1- Fila,\n"
                + "2- Fila Prioridade,\n"
                + "3- Sair.\n"
                + "Escolha uma opção: ");
        int op = scan.nextInt();
        return op;
    }

    public static int menuFila() {
        Scanner scan = new Scanner(System.in);
        System.out.print("\n%FILA% - Menu de Opções\n"
                + "1- Montar um fila:\n"
                + "2- Mostrar a fila:\n"
                + "3- Verificar se a fila está vazia:\n"
                + "4- Remover item da fila:\n"
                + "5- Mostrar quantidade de itens da fila:\n"
                + "6- Verificar se item pertence a fila:\n"
                + "7- Mosttar último item da fila:\n"
                + "8- Verificar posição:\n"
                + "9- Mostrar uma quantidade:\n"
                + "10- Mostrar últimos valores da fila:\n"
                + "11- Maior elemento da fila:\n"
                + "12- Menor elemento da fila:\n"
                + "13- Menu Principal.\n"
                + "Escolha uma opção: ");
        int op = scan.nextInt();
        return op;
    }

    public static void fila() throws Exception {
        Scanner scan = new Scanner(System.in);
        FILA f = new FILA();
        int op;
        do {
            op = menuFila();
            while (op <= 0 || op >= 14) {
                System.out.println("\nOpção Inválida!");
                op = menuFila();
            }
            switch (op) {
                case 1: {
                    System.out.print("Digite um valor: ");
                    int vlr = scan.nextInt();
                    f.inserir(vlr);
                    break;
                }
                case 2: {
                    f.mostrar();
                    break;
                }
                case 3: {
                    if (f.vazia()) {
                        System.out.println("Fila vazia.");
                    } else {
                        System.out.println("Fila não está vazia.");
                    }
                    break;
                }
                case 4: {
                    f.remover();
                    break;
                }
                case 5: {
                    System.out.println("Quantidade de itens: " + f.quantidade());
                    break;
                }
                case 6: {
                    System.out.print("Digite um valor: ");
                    int vlr = scan.nextInt();
                    if (f.pertence(vlr)) {
                        System.out.println("Pertence a fila.");
                    } else {
                        System.out.println("Não pertence a fila.");
                    }
                    break;
                }
                case 7: {
                    f.ultimoValor();
                    break;
                }
                case 8: {
                    System.out.print("Digite uma posição: ");
                    int p = scan.nextInt();
                    f.posicao(p);
                    break;
                }
                case 9: {
                    System.out.print("Informe uma quantidade: ");
                    int q = scan.nextInt();
                    f.mostrarX(q);
                    break;
                }
                case 10: {
                    System.out.print("Informe um valor: ");
                    int vlr = scan.nextInt();
                    f.mostrarUltimos(vlr);
                    break;
                }
                case 11: {
                    System.out.println("Maior elemento: " + f.maiorValorFila());
                    break;
                }
                case 12: {
                    System.out.println("Menor elemento: " + f.menorValorFila());
                    break;
                }
                case 13: {
                    Principal();
                    break;
                }
            }
        } while (op != 0);
    }

    public static int menuFilaPrioridade() {
        Scanner scan = new Scanner(System.in);
        System.out.print("\n%FILA PRIORIDADE% - Menu de Opções\n"
                + "1- Montar um fila prioridade:\n"
                + "2- Mostrar a fila prioridade:\n"
                + "3- Verificar se fila está vazia:\n"
                + "4- Remover item da fila:\n"
                + "5- Informe prioridade para mostrar quantidade de pessoas:\n"
                + "6- Mostrar quantidade de pessoas por prioridade:\n"
                + "7- Mostrar nome e prioridade na posição:\n"
                + "8- Posição que está o nome:\n"
                + "9- Nome(s) com maior prioridade:\n"
                + "10- Menu Principal.\n"
                + "Escolha uma opção: ");
        int op = scan.nextInt();
        return op;
    }

    public static void filaPrioridade() throws Exception {
        Scanner scan = new Scanner(System.in);
        FILAP fp = new FILAP();
        int op;
        do {
            op = menuFilaPrioridade();
            while (op <= 0 || op >= 11) {
                System.out.println("\nOpção Inválida!");
                op = menuFilaPrioridade();
            }
            switch (op) {
                case 1: {
                    System.out.print("Informe qual a prioridade: ");
                    int p = scan.nextInt();
                    System.out.print("Digite o nome da pessoa: ");
                    Object obj = scan.next();
                    fp.inserirP(p, obj);
                    break;
                }
                case 2: {
                    fp.mostrarP();
                    break;
                }
                case 3: {
                    if (fp.vazia()) {
                        System.out.println("Fila Prioridade Vazia.");
                    } else {
                        System.out.println("Fila Prioridade Não Vazia.");
                    }
                    break;
                }
                case 4: {
                    fp.removerp();
                    break;
                }
                case 5: {
                    System.out.print("Informe a prioridade: ");
                    int p = scan.nextInt();
                    System.out.println("Prioridade " + p + ": " + fp.quantPessoasP(p) + " pessoa(s).");
                    break;
                }
                case 6: {
                    fp.quantPessoaPorP();
                    break;
                }
                case 7: {
                    System.out.print("Digite uma posição: ");
                    int p = scan.nextInt();
                    fp.mostraPosicaoX(p);
                    break;
                }
                case 8: {
                    System.out.print("Digite um nome: ");
                    String nome = scan.next();
                    int pos = fp.nomePosicaoX(nome);
                    if (pos == 0) {
                        System.out.println("Nome inexistente.");
                    } else {
                        System.out.println(pos);
                    }
                    break;
                }
                case 9: {
                    fp.nomeMaiorP();
                    break;
                }
                case 10: {
                    Principal();
                    break;
                }
            }
        } while (op != 0);
    }
}
