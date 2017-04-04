/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import controller.Controlador;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import model.ClienteHilo;
import model.Envio;
import model.Lista;

/**
 *
 * @author j4v13
 */
public class MainForm extends JFrame {

    Controlador controlador;
    JPanel panel;
    
    public MainForm() throws IOException {
        super("Mensajes");
        super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        super.setLayout(new BorderLayout());
        super.setSize(240, 240);                
                
        controlador = new Controlador();        
        controlador.start();       
        
        panel = new JPanel();
        super.add(panel);
        
        while(true) {
            super.remove(panel);
            panel = new JPanel();
            panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));
            super.add(panel, BorderLayout.CENTER);
            Envio envio = controlador.getEnvio();
            try {
                Lista<ClienteHilo> l = envio.getLista();
                for (int i = 0; i < l.getSize(); i++) {
                    ClienteHilo cliente = l.get(i).getDato();
                    panel.add(new JLabel("Cliente "+(i+1)+" conectado: "+cliente.getConectado()));
                }   
            } catch(Exception ex) {
            }         
            super.add(panel);
            super.setVisible(true);            
        }
        
    }
}