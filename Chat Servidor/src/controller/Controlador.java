/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.ClienteHilo;
import model.Envio;

/**
 *
 * @author j4v13
 */
public class Controlador extends Thread {

    Envio envio;
            
    @Override
    public void run() {
        try {
            ServerSocket server = new ServerSocket(3000);
            envio = new Envio();
            while(true) {
                Socket cliente = server.accept();
                ClienteHilo clienteHilo = new ClienteHilo(cliente,envio);
                envio.add(clienteHilo);
                clienteHilo.start();        
            }
        } catch (IOException ex) {

        }
    }

    public synchronized Envio getEnvio() {
        return envio;
    }        
    
}
