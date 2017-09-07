/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package aula_29_10_Arvore;

/**
 *
 * @author Anderson J Rodrigues
 */
public class NO {
    
    private int valor;
    private NO esq;
    private NO dir;
    
    public void setValor(Object x){
        this.valor = (Integer)x;
    }
    
    public void setEsq(NO x){
        this.esq = x;
    }
    
    public void setDir(NO x){
        this.dir = x;
    }
    
    public Object getValor(){
        return this.valor;
    }
    
    public NO getEsq(){
        return this.esq;
    }
    
    public NO getDir(){
        return this.dir;
    }
    
}
