/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package aula_29_10_Arvore;

/**
 *
 * @author Anderson J Rodrigues
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        ARVORE t = new ARVORE();
        t.setRaiz(t.inserir(3, t.getRaiz()));
        t.setRaiz(t.inserir(1, t.getRaiz()));
        t.setRaiz(t.inserir(2, t.getRaiz()));
        t.setRaiz(t.inserir(5, t.getRaiz()));
        t.setRaiz(t.inserir(4, t.getRaiz()));
        t.setRaiz(t.inserir(6, t.getRaiz()));
        System.out.print("Pre-Ordem: ");
        t.preordem(t.getRaiz());
        t.remover(5, t.getRaiz());
        System.out.print("Pre-Ordem: ");
    }
}
