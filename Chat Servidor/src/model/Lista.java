/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import Exceptions.*;

/**
 *
 * @author j4v13
 */
public class Lista<T> {
    
    private Nodo<T> inicio;
    private int size;
    
    public void pop() throws ListaVaciaException {
        if(inicio == null) throw new ListaVaciaException();
        if(inicio.getSiguiente() == null) {
            inicio = null;
        } else {
            Nodo<T> aux = inicio.getSiguiente();
            aux.setAnterior(null);
            inicio = null;
            inicio = aux;
        }    
        size--;
    }    
    
    public Nodo<T> get(int i){
        Nodo<T> aux = inicio;
        int j = 0;
        while(j < i) {
            aux = aux.getSiguiente();
            j++;
        }
        return aux;
    }            
    
    public void agregarAdelante(Nodo<T> n) {
        Nodo<T> aux = inicio;
        Nodo<T> ant = null;
        if(aux == null)
            inicio = n;
        else {
            while(aux!=null){
                ant = aux;
                aux = aux.getSiguiente();
            }
            ant.setSiguiente(n);
            n.setAnterior(ant);
        }
        size++;
    }
    
    public void agregarAtras(Nodo<T> n) {
        if(inicio == null)
            inicio = n;
        else {
            inicio.setAnterior(n);
            n.setSiguiente(inicio);
            inicio = n;
        }
        size++;
    }

    @Override
    public String toString() {
        String s = new String();
        Nodo<T> aux = inicio;
        while(aux != null) {
            s += aux.getDato() + " ";
            aux = aux.getSiguiente();
        }
        return s;
    }    

    public int getSize() {
        return size;
    }    

    public Nodo<T> getInicio() {
        return inicio;
    }        

    public Lista() {
        size = 0;
    }
    
}
