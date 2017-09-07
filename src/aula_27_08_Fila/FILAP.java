/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package aula_27_08_Fila;

/**
 *
 * @author Anderson J Rodrigues
 */
public class FILAP {

    private NO inicio;
    private NO fim;

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

    public FILAP() {
        this.inicio = null;
        this.fim = null;
    }

    public boolean vazia() {
        return this.inicio == null;
    }

    public void inserirP(int x, Object n) {
        NO novo = new NO();
        novo.setValor(n);
        novo.setPrioridade(x);
        if (this.vazia()) {
            novo.setProx(null);
            this.setFim(novo);
            this.setInicio(novo);
        } else {
            NO y = new NO();
            y = this.inicio;
            NO ant = new NO();
            ant = null;
            while (y != null && y.getPrioridade() <= x) {//procurando posição
                ant = y;
                y = y.getProx();
            }
            if (ant == null) {         //nó inserido é o 1º 
                novo.setProx(this.inicio);
                this.inicio = novo;
            } else if (y == null) {      //ultimo nó
                novo.setProx(null);
                ant.setProx(novo);
                this.setFim(novo);
            } else {                    //meio da fila
                ant.setProx(novo);
                novo.setProx(y);
            }
        }
    }

    public void removerp() {
        if (this.inicio != null) {
            System.out.println(this.inicio.getValor());
            this.inicio = this.inicio.getProx();
            if (this.inicio == null) {
                this.fim = null;
            }
        }
    }

    public void mostrarP() {
        int p = 0;
        for (NO x = this.inicio; x != null; x = x.getProx()) {
            if (x.getPrioridade() != p) {
                System.out.print(x.getPrioridade() + " ");
                p = x.getPrioridade();
            }
        }
        System.out.print("");
    }

    public int quantPessoasP(int x) {
        int cont = 0;
        NO y = this.inicio;
        while (y != null) {
            if (y.getPrioridade() == x) {
                cont++;
            }
            y = y.getProx();
        }
        return cont;
    }

    public void quantPessoaPorP() {
        int q = 0;
        int p = this.inicio.getPrioridade();
        for (NO x = this.inicio; x != null; x = x.getProx()) {
            if (x.getPrioridade() == p) {
                q++;
            } else {
                System.out.println("Prioridade " + p + " = " + q);
                q = 1;
                p = x.getPrioridade();
            }
        }
    }
    
    public void mostraPosicaoX(int x){
        int p = 1;
        for(NO y = this.inicio; y != null; y = y.getProx()){
            if(x == p){
                System.out.println("Nome: " + y.getValor() + " Prioridade: " + y.getPrioridade());
                break;
            }
            p++;
        }
        if(x != p){
            System.out.println("Posição inexistente.");
        }
    }
    
    public int nomePosicaoX(String nome){
        int p = 0;
        NO y;
        for(y = this.inicio; y != null; y = y.getProx()){
            p++;
            if(y.getValor().toString().equalsIgnoreCase(nome)){
                break;
            }
        }
        if(y == null){
            p = 0;
        }
        return p;
    }
    
    public void nomeMaiorP(){
        NO x = this.fim;
        for(NO y = this.inicio; y != null; y = y.getProx()){
            if(y.getPrioridade() == x.getPrioridade()){
                System.out.println("Nome: " + y.getValor());
            }
        }
    }
}
