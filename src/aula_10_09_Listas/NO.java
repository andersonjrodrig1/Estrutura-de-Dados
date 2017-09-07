/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package aula_10_09_Listas;

/**
 *
 * @author 121069039
 */
public class NO {

    private Object valor;
    private NO prox;
    private NO ant;

    public void setValor(Object x) {
        this.valor = x;
    }

    public void setProx(NO x) {
        this.prox = x;
    }

    public Object getValor() {
        return this.valor;
    }

    public NO getProx() {
        return this.prox;
    }

    public NO getAnt() {
        return ant;
    }

    public void setAnt(NO ant) {
        this.ant = ant;
    }
 
}
