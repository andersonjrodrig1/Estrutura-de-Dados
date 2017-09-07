/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package aula_29_10_Arvore;

/**
 *
 * @author Anderson J Rodrigues
 */
public class ARVORE {

    private NO raiz;

    public void setRaiz(NO x) {
        this.raiz = x;
    }

    public NO getRaiz() {
        return this.raiz;
    }

    public ARVORE() {
        this.raiz = null;
    }

    public boolean vazia() {
        return (this.raiz == null);
    }

    public NO inserir(Object x, NO r) {
        if (r != null) {
            if ((Integer) x < (Integer) r.getValor()) {
                r.setEsq(inserir(x, r.getEsq()));
            } else {
                r.setDir(inserir(x, r.getDir()));
            }
        } else {
            r = new NO();
            r.setValor(x);
            r.setEsq(null);
            r.setDir(null);
        }
        return r;
    }

    public NO buscar(Object x, NO r) {
        if (r != null) {
            if (x == r.getValor()) {
                return r;
            } else if ((Integer) x < (Integer) r.getValor()) {
                return buscar(x, r.getEsq());
            } else {
                return buscar(x, r.getDir());
            }
        } else {
            System.out.println("\nItem " + x + " não encontrado!");
            return null;
        }
    }

    public NO noPai(Object x, NO r, NO a) {
        if (r == null) {
            System.out.println("\nItem " + x + " não encontrado!");
            return null;
        } else if (r.getValor() == x) {
            return a;
        } else if ((Integer) x < (Integer) r.getValor()) {
            return (noPai(x, r.getEsq(), r));
        } else {
            return (noPai(x, r.getDir(), r));
        }
    }

    public NO maior(NO r) {
        if (r.getDir() == null) {
            return r;
        } else {
            return this.maior(r.getDir());
        }
    }

    public NO menor(NO r) {
        if (r.getEsq() == null) {
            return r;
        } else {
            return this.menor(r.getEsq());
        }
    }

    public int quantidade(NO r) {
        if (r != null) {
            return 1 + quantidade(r.getEsq()) + quantidade(r.getDir());
        } else {
            return 0;
        }
    }

    public void remover(Object x, NO r) {
        NO pai = noPai(x, r, null);
        NO item = buscar(x, r);
        if (r == null || item == null) {
            System.out.println("\nItem " + x + " não encontrado!");
        } else if (item.getEsq() == null && item.getDir() == null) {//removendo nó folha 
            if (pai != null) {
                if (pai.getEsq() == item) {//item é filho à esq do pai 
                    pai.setEsq(null);
                } else {//item é filho à dir do pai 
                    pai.setDir(null);
                }
            } else {//removendo nó raiz 
                this.setRaiz(null);
            }
        } else if (item.getDir() == null) {//removendo no com 1 filho à esq 
            if (pai != null) {
                if (pai.getEsq() == item) {//item é filho à esq do pai 
                    pai.setEsq(item.getEsq());
                } else if (pai.getDir() == item) {
                    pai.setDir(item.getEsq());
                }
            } else {
                this.setRaiz(item.getEsq());
            }
        } else if (item.getEsq() == null) {//removendo nó com 1 filho à dir 
            if (pai != null) {
                if (pai.getEsq() == item) {//item é filho à esq do pai 
                    pai.setEsq(item.getDir());
                } else if (pai.getDir() == item) {
                    pai.setDir(item.getDir());
                }
            } else {
                this.setRaiz(item.getDir());
            }
        } else {//removendo nó com 2 filhos 
            NO m = maior(item.getEsq()); // ou NO m = menor(item.getDir()); 
            Object z = m.getValor();
            remover(z, item);
            item.setValor(z);
        }
    }

    public int altura(NO x) {
        if (x == null) {
            return -1; // altura de árvore vazia é -1 
        } else {
            return (1 + Math.max(altura(x.getEsq()), altura(x.getDir())));
        }
    }

    public void preordem(NO x) {
        if (x != null) {
            System.out.print(x.getValor() + " ");
            preordem(x.getEsq());
            preordem(x.getDir());
        }
    }

    public void emordem(NO x) {
        if (x != null) {
            emordem(x.getEsq());
            System.out.print(x.getValor() + " ");
            emordem(x.getDir());
        }
    }

    public void posordem(NO x) {
        if (x != null) {
            posordem(x.getEsq());
            posordem(x.getDir());
            System.out.print(x.getValor() + " ");
        }
    }

    public void exemplo1(Object x) {
        NO y = this.buscar(x, this.getRaiz());
        if (y != null) {
            if (y.getEsq() == null && y.getDir() == null) {
                System.out.println("Não tem filhos");
            }
            if (y.getEsq() != null) {
                System.out.println("Filho esq: " + y.getEsq().getValor());
            }
            if (y.getDir() != null) {
                System.out.println("Filho dir: " + y.getDir().getValor());
            }
        } else {
            System.out.println("Valor não existe na árvore");
        }
    }

    public void descendente(Object x) {
        NO r = this.buscar(x, this.getRaiz());
        if (r == null) {
            System.out.print("Item não encontrado.");
        } else {
            if (r.getEsq() != null && r.getDir() == null) {
                System.out.print("Desc Esq: " + r.getEsq().getValor());
            } else if (r.getEsq() == null && r.getDir() != null) {
                System.out.print("Desc Dir: " + r.getDir().getValor());
            } else if (r.getEsq() == null && r.getDir() == null) {
                System.out.print("Desc Esq: " + r.getEsq().getValor()
                        + "\nDesc Dir: " + r.getDir().getValor());
            }else{
                System.out.println("Objeto de busca não possui descendentes.");
            }
        }
    }
    
    public void grau(ARVORE r){
        if(!r.vazia()){
            NO x = r.raiz;
            int grau = Math.max(altura(x), altura(x)) - 1;
            System.out.print("O grau da árvore é: " + grau);
        }else{
            System.out.print("Não possui elementos.");
        }
    }
    
    public void maioresValoresQ(Object x){
        
    }
    
}
