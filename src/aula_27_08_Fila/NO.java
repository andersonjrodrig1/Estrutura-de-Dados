/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package aula_27_08_Fila;

/**
 *
 * @author 121069039
 */
public class NO {

    private Object valor;
    private int prioridade;
    private NO prox;

    public void setValor(Object x) {
        this.valor = x;
    }

    public int getPrioridade() {
        return prioridade;
    }

    public void setPrioridade(int prioridade) {
        this.prioridade = prioridade;
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
