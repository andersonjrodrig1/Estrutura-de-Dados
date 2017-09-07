/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package aula_10_09_Listas;

/**
 *
 * @author Anderson J Rodrigues
 */
public class LISTACIRCULAR {

    private NO inicio;
    private NO fim;

    public LISTACIRCULAR() {
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
        if (this.vazia()) {
            novo.setProx(novo);
            this.inicio = novo;
            this.fim = novo;
        } else {
            novo.setProx(novo);
            this.fim = novo;
            this.inicio = novo;
        }
    }

    public void inserirFim(Object x) {
        if (this.vazia()) {
            this.inserirInicio(x);
        } else {
            NO novo = new NO();
            novo.setValor(x);
            this.fim.setProx(novo);
            novo.setProx(this.inicio);
            this.fim = novo;
        }
    }

    public void inserirOrdenado(Object x) {
        if (this.vazia()) {
            this.inserirInicio(x);
        } else {
            NO y = this.inicio;
            NO ant = null;
            do {
                if ((Integer) y.getValor() > (Integer) x) {
                    break;
                }
                ant = y;
                y = y.getProx();
            } while (y != this.inicio);
            if (ant == null) {
                this.inserirInicio(x);
            } else if (y == this.inicio) {
                this.inserirFim(x);
            } else {
                NO novo = new NO();
                novo.setValor(x);
                ant.setProx(novo);
                novo.setProx(y);
            }
        }
    }

    public void removerInicio() {
        if (!this.vazia()) {
            if (this.inicio == this.fim) {
                this.inicio = null;
                this.fim = null;
            } else {
                this.inicio = this.inicio.getProx();
                this.fim = this.inicio;
            }
        }
    }

    public void removerFim() {
        if (!this.vazia()) {
            if (this.inicio == this.fim) {
                this.inicio = null;
                this.fim = null;
            } else {
                NO y = this.inicio;
                do {
                    y = y.getProx();
                } while (y.getProx() != this.fim);
                y.setProx(this.inicio);
                this.fim = y;
            }
        }
    }

    public void removerItem(Object x) {
        if (!this.vazia()) {
            NO y = this.inicio;
            NO ant = null;
            do {
                if (y.getValor() == x) {
                    break;
                }
                ant = y;
                y = y.getProx();
            } while (y != this.inicio);
            if (ant == null) {
                this.removerInicio();
            } else if (y == this.fim) {
                this.removerFim();
            } else {
                ant.setProx(y.getProx());
            }
        }
    }

    public void mostrar() {
        if (!this.vazia()) {
            NO y = this.inicio;
            do {
                System.out.print(y.getValor());
                y = y.getProx();
            } while (y != this.inicio);
        } else {
            System.out.println("Lista Vazia.");
        }
    }

    public void removeXValores(int x) {
        if (!this.vazia()) {
            NO y = this.inicio;
            do {
                if ((Integer) y.getValor() == x) {
                    this.removerItem(x);
                }
                y = y.getProx();
            } while (y != this.inicio);
        }
    }

    public boolean valoresIguais() {
        if (!this.vazia()) {
            NO y = this.inicio;
            do {
                NO x = y.getProx();
                do {
                    if (x.getValor() == y.getValor()) {
                        return true;
                    }
                    x = x.getProx();
                } while (x != this.inicio);
                y = y.getProx();
            } while (y != this.fim);
        }
        return false;
    }

    public NO menorValor() {
        if (!this.vazia()) {
            NO y = this.inicio;
            LISTACIRCULAR lista = new LISTACIRCULAR();
            do {
                lista.inserirOrdenado(y.getValor());
                y = y.getProx();
            } while (y != this.inicio);
            return lista.inicio.getProx();
        }
        return null;
    }
    
    public void xPrimeirosValores(int x){
        if(!this.vazia()){
            NO y = this.inicio;
            int cont = 0;
            do{
               System.out.print(y.getValor() + " ");
               cont++;
               y = y.getProx();
            }while(y != this.inicio && cont <= x);
        }
    }
    
    public void removeDivPor3(){
        if(!this.vazia()){
            NO y = this.inicio;
            do{
                if((Integer)y.getValor() % 3 == 0){
                    this.removerItem(y.getValor());
                    break;
                }
                y = y.getProx();
            }while(y != this.inicio);
        }
    }
    
    public void maiorMenorMedia(){
        if(!this.vazia()){
            NO y = this.inicio;
            int valor = 0, cont = 0;
            int menor = (Integer)this.inicio.getValor();
            int maior = (Integer)this.inicio.getValor();
            do{
                if((Integer)y.getValor() <= menor){
                    menor = (Integer)y.getValor();
                }
                if((Integer)y.getValor() >= maior){
                    maior = (Integer)y.getValor();
                }
                valor += (Integer)y.getValor();
                cont++;
                y = y.getProx();
            }while(y != this.inicio);
            float media = valor / cont;
            System.out.print("Maior: " + maior + "\nMenor: " + menor + "\nMédia: " + media);
        }
    }
    
    public void menorImpar(){
        if(!this.vazia()){
            NO y = this.inicio;
            int impar = (Integer)this.inicio.getValor();
            do{
                if((Integer)y.getValor() <= impar){
                    impar = (Integer)y.getValor();
                }
                y = y.getProx();
            }while(y != this.inicio);
            System.out.print("Menor impar: " + impar);
        }
    }
  
}
