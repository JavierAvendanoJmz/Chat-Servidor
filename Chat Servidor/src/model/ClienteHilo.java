/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author j4v13
 */
public class ClienteHilo extends Thread {
    
    Envio envio;
    Socket cliente;
    ObjectInputStream reader;
    ObjectOutputStream writer;

    public ClienteHilo(Socket cliente,Envio envio) throws IOException {
        this.cliente = cliente;
        this.envio = envio;
        reader = new ObjectInputStream(cliente.getInputStream());
        writer = new ObjectOutputStream(cliente.getOutputStream());
    }
    
    public void enviarMensaje(String s) throws IOException {
        writer.writeObject(s);
    }

    @Override
    public void run() {
        while(true) {
            try {
                String s = (String)reader.readObject(); 
//                enviarMensaje(s);
                envio.enviar(s);
            } catch (Exception ex) {
                try {
                    cliente.close();
                    reader.close();
                    writer.close();
                } catch (Exception ex1) {
                    
                }
            }
        }
    }
    
    
    
}
