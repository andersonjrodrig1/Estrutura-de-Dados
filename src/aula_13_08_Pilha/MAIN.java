/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package aula_13_08_Pilha;

import java.util.Scanner;

/**
 *
 * @author 121069039
 */
public class MAIN {

    public static void main(String[] args) throws Exception {
        Scanner ent = new Scanner(System.in);
        PILHA p = new PILHA();
        int op;
        do {
            op = menu();
            switch (op) {
                case 1: {
                    System.out.print("Digite um valor: ");
                    int y = ent.nextInt();
                    p.empilha(y);
                    break;
                }
                case 2: {
                    try {
                        p.desempilha();
                    } catch (Exception exception) {
                        System.err.println(exception);
                    }
                    break;
                }
                case 3: {
                    boolean x = p.vazia();
                    if (x) {
                        System.out.println("Pilha vazia");
                    } else {
                        System.out.println("Pilha não vazia");
                    }
                    break;
                }
                case 4: {
                    p.mostrar();
                    break;
                }
                case 5: {
                    System.out.print("Digite o valor: ");
                    int vlr = ent.nextInt();
                    boolean b = p.verificaValor(vlr);
                    if (b == true) {
                        System.out.println("Consta valor.");
                    } else {
                        System.out.println("Não consta valor.");
                    }
                    break;
                }
                case 6: {
                    System.out.println("Último valor: " + p.ultimoItem());
                    break;
                }
                case 7: {
                    System.out.print("Informe quantos itens serão mostrados: ");
                    int vlr = ent.nextInt();
                    p.mostrarXPrim(vlr);
                    break;
                }
                case 8: {
                    PILHA pi = p.pilhaInvertida();
                    pi.mostrar();
                    break;
                }
                case 9: {
                    System.out.print("Informe um valor: ");
                    int quant = ent.nextInt();
                    p.removeQuant(quant);
                    break;
                }
                case 10: {
                    System.out.print("Digite uma expressão: ");
                    String expr = ent.nextLine();
                    if (p.balanceamento(expr)) {
                        System.out.println("Balanceado");
                    } else {
                        System.out.println("Desbalanceado");
                    }
                    break;
                }
                case 11: {
                    p.multiplosDe3();
                    break;
                }
                case 12: {
                    System.out.print("Digite uma frase: ");
                    String frase = ent.nextLine();
                    if(p.verifPalindromo(frase)){
                        System.out.println("Esta frase é PALÍNDROMO.");
                    }else{
                        System.out.println("Esta frase não é PALÍNDROMO.");
                    }
                    break;
                }
                case 13: {
                    p.maiorElementoPilha();
                    break;
                }
                case 14: {
                    System.out.println("Menor elemento: " + p.menorValorPilha());
                    break;
                }
                case 15: {
                    System.out.println("A média é: " + p.mediaAritmeticaPilha());
                    break;
                }
            }
        } while (op != 16);
    }

    public static int menu() {
        Scanner ent = new Scanner(System.in);
        int x;
        System.out.println("\nPILHA - Menu de opções: ");
        System.out.println("1- Empilhar nó: ");
        System.out.println("2- Desempilhar nó: ");
        System.out.println("3- Verificar Vazia: ");
        System.out.println("4- Mostrar Pilha: ");
        System.out.println("5- Verifica se consta valor: ");
        System.out.println("6- Mostrar último valor: ");
        System.out.println("7- Informe quantdade de itens a ser mostrado: ");
        System.out.println("8- Mostrar pilha invertida: ");
        System.out.println("9- Informe quantos você quer remover: ");
        System.out.println("10- Verificar balaceamento: ");
        System.out.println("11- Pilha com apenas multiplos de 3: ");
        System.out.println("12- Verificar palíndromo: ");
        System.out.println("13- Maior elemento da pilha: ");
        System.out.println("14- Menor elemento da pilha: ");
        System.out.println("15- Média Aritmética da pilha: ");
        System.out.println("16- Sair");
        System.out.print("Digite a sua opção: ");
        x = ent.nextInt();
        return x;
    }
}
