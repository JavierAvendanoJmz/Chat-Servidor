/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chat.servidor;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import model.ClienteHilo;
import model.Envio;
import model.Lista;

/**
 *
 * @author j4v13
 */
public class ChatServidor {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(3000); 
        Envio envio = new Envio();
        while(true) {           
            Socket cliente = server.accept();            
            ClienteHilo clienteHilo = new ClienteHilo(cliente,envio);  
            envio.add(clienteHilo);
            clienteHilo.start();            
        }
    }    
}

