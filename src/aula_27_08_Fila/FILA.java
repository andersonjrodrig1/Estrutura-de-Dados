/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package aula_27_08_Fila;

/**
 *
 * @author Anderson J Rodrigues
 */
public class FILA {

    private NO inicio;
    private NO fim;

    public FILA() {
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

    public void inserir(Object obj) {
        NO novo = new NO();
        novo.setValor(obj);
        novo.setProx(null);
        if (this.vazia()) {
            this.inicio = novo;
        } else {
            this.fim.setProx(novo);
        }
        this.fim = novo;
    }

    public void mostrar() {
        NO x;
        for (x = this.inicio; x != null; x = x.getProx()) {
            System.out.print(x.getValor() + "->");
        }
        System.out.println("null");
    }

    public void remover() throws Exception {
        if (this.vazia()) {
            throw new Exception("Erro: Pilha Vazia!");
        } else {
            this.inicio = this.inicio.getProx();
            if (this.inicio == null) {
                this.fim = null;
            }
        }
    }

    public int quantidade() {
        NO x;
        int q = 0;
        for (x = this.inicio; x != null; x = x.getProx()) {
            q++;
        }
        return q;
    }

    public boolean pertence(Object obj) {
        NO y;
        for (y = this.inicio; y != null; y = y.getProx()) {
            if (obj == y.getValor()) {
                return true;
            }
        }
        return false;
    }

    public void ultimoValor() {
        if (!this.vazia()) {
            System.out.println(this.fim.getValor());
        } else {
            System.out.println("Lista Vazia.");
        }
    }

    public void posicao(int x) {
        if (x <= this.quantidade()) {
            NO y;
            for (y = this.inicio; y != null; y = y.getProx()) {
                if (x == 1) {
                    System.out.print(y.getValor());
                    break;
                }
                x--;
            }
        } else {
            System.out.println("Não existe esta posição.");
        }
    }

    public void mostrarX(int x) {
        NO y;
        for (y = this.inicio; y != null; y = y.getProx()) {
            if (x != 1) {
                System.out.print(y.getValor() + " ");
            } else {
                break;
            }
            x--;
        }
    }

    public void mostrarUltimos(int x) {
        NO y;
        int temp = 0;
        int aux = quantidade() - x;
        for (y = this.inicio; y != null; y = y.getProx()) {
            if (temp >= aux) {
                System.out.print(y.getValor() + "->");
            }
            temp++;
        }
        System.out.println("null");
    }

    public FILA inter(NO x) {
        FILA f = new FILA();
        NO y;
        while (x != null) {
            for (y = this.inicio; y != null; y = y.getProx()) {
                if (x.getValor() == y.getValor()) {
                    f.inserir(y.getValor());
                    break;
                }
            }
            x = x.getProx();
        }
        return f;
    }
    
    public FILA contemFila1(NO x1){
        FILA f = new FILA();
        NO y;
        while(x1 != null){
            for(y = this.inicio; y != null; y = y.getProx()){
                if(x1.getValor() == y.getValor()){
                    break;
                }else if(x1.getValor() != null){
                    f.inserir(x1.getValor());
                }
            }
            x1 = x1.getProx();
        }
        return f;
    }
    
    public int maiorValorFila(){
        int vlr = (Integer)this.inicio.getValor();
        for(NO y = this.inicio; y != null; y = y.getProx()){
            if((Integer)y.getValor() > vlr){
                vlr = (Integer)y.getValor();
            }
        }
        return vlr;
    }
    
    public int menorValorFila(){
        int vlr = (Integer)this.inicio.getValor();
        for(NO y = this.inicio; y != null; y = y.getProx()){
            if((Integer)y.getValor() < vlr){
                vlr = (Integer)y.getValor();
            }
        }
        return vlr;
    }
    
    public float mediaAritmeticaFila(){
        int vlr = 0, cont = 0;
        float media = 0f;
        for(NO y = this.inicio; y != null; y = y.getProx()){
            vlr += (Integer)y.getValor();
            cont++;
        }
        media = vlr / cont;
        return media;
    }
}
