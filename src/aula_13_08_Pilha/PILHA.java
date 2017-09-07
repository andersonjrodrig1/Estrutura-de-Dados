/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package aula_13_08_Pilha;

/**
 *
 * @author 121069039
 */
public class PILHA {

    private NO topo;

    public PILHA() { //construtor
        this.topo = null;
    }

    public void setTopo(NO x) {
        this.topo = x;
    }

    public NO getTopo() {
        return this.topo;
    }

    public boolean vazia() {
        return this.topo == null;
    }

    public void empilha(Object x) {
        NO novo = new NO();
        novo.setValor(x);
        novo.setProx(this.topo);
        this.topo = novo;
    }

    public void desempilha() throws Exception {
        if (this.vazia()) {
            throw new Exception("Erro: Pilha Vazia!");
        } else {
            this.topo = this.topo.getProx();
        }
    }

    public void mostrar() { //iterativo
        NO x = this.topo;
        while (x != null) {
            System.out.print(x.getValor() + "-> ");
            x = x.getProx();
        }
        System.out.println(" NULL");
    }

    public void mostrar2(NO x) { //recursivo
        if (x != null) {
            System.out.print(x.getValor() + "-> ");
            mostrar2(x.getProx());
        }
    }

    public int quantidade() { //iterativo
        NO x = this.topo;
        int qtd = 0;
        while (x != null) {
            qtd++;
            x = x.getProx();
        }
        return qtd;
    }

    public int quantidade2(NO x) { //recursivo
        if (x != null) {
            return 1 + quantidade2(x.getProx());
        } else {
            return 0;
        }
    }

    public int soma() {
        NO x = this.topo;
        int y = 0;
        while (x != null) {
            y = y + (Integer) x.getValor();
        }
        return y;
    }

    public boolean verificaValor(Object valor) {
        NO x = this.topo;
        while (x != null) {
            if (x.getValor() == valor) {
                return true;
            }
            x = x.getProx();
        }
        return false;
    }

    public Object ultimoItem() {
        NO x = this.topo;
        Object obj = null;
        while (x != null) {
            if (x.getProx() == null) {
                obj = x.getValor();
            }
            x = x.getProx();
        }
        return obj;
    }

    public void mostraItem(int valor) {
        NO x = this.topo;
        for (int i = 0; i < valor; i++) {
            if (x == null) {
                System.out.println("NULL!");
                break;
            } else {
                System.out.println(x.getValor());
                x = x.getProx();
            }
        }
    }

    public PILHA pilhaInvertida() {
        PILHA p = new PILHA();
        for (NO x = this.topo; x != null; x = x.getProx()) {
            p.empilha(x.getValor());
        }
        return p;
    }

    public void removeQuant(int valor) throws Exception {
        for (int i = 0; i < valor; i++) {
            this.desempilha();
        }
    }

    public boolean balanceamento(String expr) throws Exception {
        PILHA p = new PILHA();
        int t = expr.length();
        for (int i = 0; i < t; i++) {
            if (expr.charAt(i) == '(') {
                p.empilha('(');
            } else if (expr.charAt(i) == '[') {
                p.empilha('[');
            } else if (expr.charAt(i) == '{') {
                p.empilha('{');
            } else if (expr.charAt(i) == ')') {
                if (!p.vazia()) {
                    if ((Character) p.getTopo().getValor() == '(') {
                        p.desempilha();
                    } else {
                        return false;
                    }
                } else {
                    return false;
                }
            } else if (expr.charAt(i) == ']') {
                if (!p.vazia()) {
                    if ((Character) p.getTopo().getValor() == '[') {
                        p.desempilha();
                    } else {
                        return false;
                    }
                } else {
                    return false;
                }
            } else if (expr.charAt(i) == '}') {
                if (!p.vazia()) {
                    if ((Character) p.getTopo().getValor() == '{') {
                        p.desempilha();
                    } else {
                        return false;
                    }
                } else {
                    return false;
                }
            }
        }
        if (p.vazia()) {
            return true;
        } else {
            return false;
        }
    }

    public boolean verificaRepetido() throws Exception {
        NO x = this.topo;
        while (x != null) {
            for (NO y = x.getProx(); y != null; y = y.getProx()) {
                if (x.getValor() == y.getValor()) {
                    return false;
                }
            }
            x = x.getProx();
        }
        return true;
    }

    public PILHA pilhaI(PILHA p) {
        PILHA nv = new PILHA();
        NO x = this.topo;
        while (x != null) {
            for (NO y = p.getTopo(); y != null; y = y.getProx()) {
                if (x.getValor() == y.getValor()) {
                    nv.empilha(x.getValor());
                }
            }
            x = x.getProx();
        }
        return nv;
    }

    public PILHA pilhaU(PILHA p) {
        PILHA nv = new PILHA();
        NO x = this.topo;
        while (x != null) {
            for (NO y = p.getTopo(); y != null; y = y.getProx()) {
                if (x.getValor() == y.getValor()) {
                    break;
                } else if (x.getValor() != null) {
                    nv.empilha(x.getValor());
                }
            }
            x = x.getProx();
        }
        return nv;
    }

    public void mostrarXPrim(int x) {
        NO y = this.topo;
        for (int i = 0; i < x; i++) {
            if (y == null) {
                System.out.print("null");
                break;
            } else {
                System.out.print(y.getValor() + " ");
                y = y.getProx();
            }
        }
    }

    public void multiplosDe3() throws Exception {
        NO y = this.topo;
        while (y != null) {
            if ((Integer) y.getValor() % 3 != 0) {
                this.desempilha();
            } else {
                break;
            }
            y = y.getProx();
        }
        if (y == null) {
            System.out.println("Pilha Vazia.");
        }
    }

    public boolean verifPalindromo(String txt) {
        PILHA p = new PILHA();
        for (int i = 0; i < txt.length(); i++) {
            p.empilha(txt.charAt(i));
        }
        String retorno = "";
        for (NO y = p.getTopo(); y != null; y = y.getProx()) {
            retorno += y.getValor();
        }
        if (retorno.equals(txt)) {
            return true;
        } else {
            return false;
        }
    }

    public void maiorElementoPilha() {
        int vlr = (Integer) this.topo.getValor();
        for (NO x = this.topo; x != null; x = x.getProx()) {
            if ((Integer) x.getValor() >= vlr) {
                vlr = (Integer) x.getValor();
            }
        }
        System.out.println("Maior elemento: " + vlr);
    }
    
    public int menorValorPilha(){
        int vlr = (Integer)this.topo.getValor();
        for(NO x = this.topo; x != null; x = x.getProx()){
            if ((Integer) x.getValor() < vlr) {
                vlr = (Integer) x.getValor();
            }
        }
        return vlr;
    }
    
    public float mediaAritmeticaPilha(){
        int valor = 0, cont = 0;
        float media = 0;
        for(NO x = this.topo; x != null; x = x.getProx()){
            valor += (Integer)x.getValor();
            cont++;
        }
        media = valor / cont;
        return media;
    }
}