/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author j4v13
 */
public class Nodo<T> {
    
    private T dato;
    private Nodo anterior;
    private Nodo siguiente;

    @Override
    public String toString() {
        return "Nodo{" + "dato=" + dato + '}';
    }    

    public T getDato() {
        return dato;
    }

    public void setDato(T dato) {
        this.dato = dato;
    }

    public Nodo getAnterior() {
        return anterior;
    }

    public void setAnterior(Nodo anterior) {
        this.anterior = anterior;
    }

    public Nodo getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(Nodo siguiente) {
        this.siguiente = siguiente;
    }        

    public Nodo(T dato) {
        this.dato = dato;
    }

    public Nodo() {
    }        
    
}
