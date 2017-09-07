/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package aula_10_09_Listas;

/**
 *
 * @author Anderson J Rodrigues
 */
public class LISTA {

    public NO inicio;
    public NO fim;

    public LISTA() {
        this.inicio = null;
        this.fim = null;
    }

    public NO getInicio() {
        return inicio;
    }

    public void setInicio(NO inicio) {
        this.inicio = inicio;
    }

    public NO getFim() {
        return fim;
    }

    public void setFim(NO fim) {
        this.fim = fim;
    }

    public boolean vazia() {
        return this.inicio == null;
    }

    public void inserirInicio(Object x) {
        NO novo = new NO();
        novo.setValor(x);
        novo.setProx(this.inicio);
        this.inicio = novo;
        if (this.fim == null) {
            this.fim = novo;
        }
    }

    public void inserirFim(Object x) {
        NO novo = new NO();
        novo.setValor(x);
        if (!this.vazia()) {
            this.fim.setProx(novo);
        }
        this.fim = novo;
        novo.setProx(null);
        if (this.inicio == null) {
            this.inicio = novo;
        }
    }

    public void inserirPosicao(int p, Object v) {
        if (p == 0) {
            this.inserirInicio(v);
        } else {
            NO x = this.inicio;
            while (x != null && p != 1) {
                x = x.getProx();
                p--;
            }
            if (x == null) {
                this.inserirFim(v);
            } else {
                NO novo = new NO();
                novo.setValor(v);
                novo.setProx(x.getProx());
                x.setProx(novo);
            }
        }
    }

    public void inserirOrdenado(Object x) {
        NO novo = new NO();
        novo.setValor(x);
        if (this.vazia()) {
            novo.setProx(null);
            this.setFim(novo);
            this.setInicio(novo);
        } else {
            NO y = this.inicio;
            NO ant = null;
            while (y != null) {
                if ((Integer) y.getValor() > (Integer) x) {
                    break;
                }
                ant = y;
                y = y.getProx();
            }
            if (ant == null) {
                novo.setProx(this.inicio);
                this.inicio = novo;
            } else if (y == null) {
                novo.setProx(null);
                ant.setProx(novo);
                this.setFim(novo);
            } else {
                ant.setProx(novo);
                novo.setProx(y);
            }
        }
    }

    public void removerItem(Object x) {
        NO y = this.inicio;
        NO ant = null;
        while (y != null) {
            if (y.getValor() == x) {
                break;
            }
            ant = y;
            y = y.getProx();
        }
        if (ant == null) {
            this.inicio = this.inicio.getProx();
        } else {
            if (y.getProx() == null) {
                this.fim = ant;
            }
            ant.setProx(y.getProx());
        }
        this.mostrar();
    }

    public void removerInicio() {
        if (!this.vazia()) {
            if (this.inicio == this.fim) {
                this.fim = null;
            }
            this.inicio = this.inicio.getProx();
        }
    }

    public void removerFim() {
        if (!this.vazia()) {
            if (this.inicio == this.fim) {
                this.inicio = null;
                this.fim = null;
            } else {
                NO x = this.inicio;
                while (x.getProx().getProx() != null) {
                    x = x.getProx();
                }
                x.setProx(null);
                this.fim = x;
            }
        }
    }

    public void mostrar() {
        if (this.vazia()) {
            System.out.println("Fila Vazia!");
        } else {
            NO x = new NO();
            x = this.inicio;
            System.out.print("Lista: ");
            while (x != null) {
                System.out.print(x.getValor() + "->");
                x = x.getProx();
            }
            System.out.print("NULL");
        }   
    }
    
    public NO ponteiro(int x){
        NO ponteiro = null;
        for(NO y = this.inicio; y != null; y = y.getProx()){
            if((Integer)y.getValor() == x){
                ponteiro = y;
            }
        }
        return ponteiro;
        
    }
    
    public LISTA listaInvertida(){
        LISTA lista = null;
        for(NO y = this.inicio; y != null; y = y.getProx()){
            lista.inserirInicio(y.getValor());
        }
        return lista;
    }
    
    public LISTA intersecao(LISTA lista2){
        LISTA lista3 = null;
        NO x = lista2.inicio;
        while(x != null){
            for(NO y = this.inicio; y != null; y = y.getProx()){
                if(x.getValor() == y.getValor()){
                    lista3.inserirFim(x.getValor());
                    break;
                }
            }
            x = x.getProx();
        }
        return lista3;
    }
    
    public void removeXPrimeiros(int x){
        NO y = this.inicio;
        int cont = 1;
        while(y != null && cont <= x){
            this.removerInicio();
            cont++;
            y = y.getProx();
        }        
    }
    
}
