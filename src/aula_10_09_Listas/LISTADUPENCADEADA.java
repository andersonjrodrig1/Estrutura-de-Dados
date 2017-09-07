/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package aula_10_09_Listas;

/**
 *
 * @author Anderson J Rodrigues
 */
public class LISTADUPENCADEADA {

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

    public LISTADUPENCADEADA() {
        this.inicio = null;
        this.fim = null;
    }

    public boolean vazia() {
        return this.inicio == null;
    }

    public void inserirInicio(Object x) {
        NO novo = new NO();
        novo.setValor(x);
        novo.setProx(this.inicio);
        novo.setAnt(null);
        if (!this.vazia()) {
            this.inicio.setAnt(novo);
        } else {
            this.fim = novo;
        }
        this.inicio = novo;
    }

    public void inserirFim(Object x) {
        NO novo = new NO();
        novo.setValor(x);
        novo.setProx(null);
        novo.setAnt(this.fim);
        if (!this.vazia()) {
            this.fim.setProx(novo);
        } else {
            this.inicio = novo;
        }
        this.fim = novo;
    }

    public void inserirOrdenado(Object x) {
        if (this.vazia() || (Integer) this.inicio.getValor() > (Integer) x) {
            this.inserirInicio(x);
        } else if ((Integer) this.fim.getValor() < (Integer) x) {
            this.inserirFim(x);
        } else {
            NO y = this.inicio;
            while (y != null) {
                if ((Integer) y.getValor() > (Integer) x) {
                    break;
                }
                y = y.getProx();
            }
            NO novo = new NO();
            novo.setValor(x);
            novo.setProx(y);
            novo.setAnt(y.getAnt());
            y.setAnt(novo);
            novo.getAnt().setProx(novo);
        }
    }

    public void removerInicio() {
        if (!this.vazia()) {
            if (this.inicio == this.fim) {
                this.inicio = null;
                this.fim = null;
            } else {
                this.inicio = this.inicio.getProx();
                this.fim.setProx(null);
            }
        }
    }

    public void removerFim() {
        if (!this.vazia()) {
            if (this.inicio == this.fim) {
                this.inicio = null;
                this.fim = null;
            } else {
                this.fim = this.fim.getAnt();
                this.fim.setProx(null);
            }
        }
    }

    public void removerItem(Object x) {
        if (!this.vazia()) {
            NO y = this.inicio;
            while (y != null) {
                if (y.getValor() == x) {
                    break;
                }
                y = y.getProx();
            }
            if (y == null) {
                System.out.println("Item não encontrado!");
            } else if (y == this.inicio) {
                this.removerInicio();
            } else if (y == this.fim) {
                this.removerFim();
            } else {
                y.getAnt().setProx(y.getProx());
                y.getProx().setAnt(y.getAnt());
            }
        }
    }

    public void mostrarInvertido() {
        NO x = this.fim;
        System.out.print("Lista invertida: ");
        while (x != null) {
            System.out.print(x.getValor() + " ");
            x = x.getAnt();
        }
    }

    public void xUltimosPares(int x) {
        if (!this.vazia()) {
            NO y = this.fim;
            int cont = 0;
            while (y != null) {
                if ((Integer) y.getValor() % 2 == 0) {
                    System.out.print(y.getValor() + " ");
                    cont++;
                }
                if (cont == x) {
                    break;
                }
                y = y.getAnt();
            }
        }
    }

    public void removeXValor(Object x) {
        if (!this.vazia()) {
            NO y = this.inicio;
            while (y != null) {
                if ((Integer) x == (Integer) y.getValor()) {
                    this.removerItem(y.getValor());
                }
                y = y.getProx();
            }
        }
    }

    public void proxAnt(Object x) {
        if (!this.vazia()) {
            NO y = this.inicio;
            while (y != null) {
                if ((Integer) y.getValor() == (Integer) x) {
                }
                y = y.getProx();
            }
        }
    }

    public void posicoes(int x) {
        if (!this.vazia()) {
            NO y = this.inicio;
            int cont = 1;
            while (y != null) {
                if ((Integer) y.getValor() == x) {
                    System.out.print(cont + " ");
                }
                y = y.getProx();
                cont++;
            }
        }
    }

    public LISTADUPENCADEADA contemL1(LISTADUPENCADEADA lista) {
        if (!this.vazia()) {
            NO l1 = this.inicio;
            NO l2 = lista.inicio;
            LISTADUPENCADEADA contemL1 = new LISTADUPENCADEADA();
            while (l1 != null) {
                while (l2 != null) {
                    if (l1.getValor() == l2.getValor()) {
                        break;
                    } else if (l2.getProx() == null) {
                        contemL1.inserirFim(l1.getValor());
                    }
                    l2 = l2.getProx();
                }
                l1 = l1.getProx();
            }
            return contemL1;
        }
        return null;
    }

    public boolean isPalindromo() {
        if (!this.vazia()) {
            NO y = this.inicio;
            NO x = this.fim;
            while (y != null) {
                if (y.getValor() != x.getValor()) {
                    return false;
                }
                y = y.getProx();
                x = x.getAnt();
            }
            return true;
        }
        return true;
    }

    public void maiorMenorMedia() {
        NO y = this.fim;
        int valor = 0, cont = 0;
        int menor = (Integer) this.fim.getValor();
        int maior = (Integer) this.fim.getValor();
        while (y != null){
            if ((Integer) y.getValor() <= menor) {
                menor = (Integer) y.getValor();
            }
            if ((Integer) y.getValor() >= maior) {
                maior = (Integer) y.getValor();
            }
            valor += (Integer) y.getValor();
            cont++;
            y = y.getAnt();
        }
        float media = valor / cont;
        System.out.print("Maior: " + maior + "\nMenor: " + menor + "\nMédia: " + media);
    }
    
}
