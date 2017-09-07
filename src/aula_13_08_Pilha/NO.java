/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package aula_13_08_Pilha;

/**
 *
 * @author 121069039
 */
public class NO {

    private Object valor;
    private NO prox;

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
}
