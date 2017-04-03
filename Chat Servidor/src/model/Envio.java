/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author j4v13
 */
public class Envio {
    
    Lista<ClienteHilo> lista;
    
    public Envio() {
        lista = new Lista();
    }
    
    public void enviar(String s) {
        for (int i = 0; i < lista.getSize(); i++) {
            try {
                lista.get(i).getDato().enviarMensaje(s);
            } catch (IOException ex) {
            }
        }
    }
    
    public void add(ClienteHilo c){
        lista.agregarAdelante(new Nodo(c));
    }
    
    public int size() {
        return lista.getSize();
    }
    
}
