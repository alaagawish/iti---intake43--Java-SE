/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.net.InetAddress;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author LAPTOP
 */
public class Client {

    /**
     * @param args the command line arguments
     */
    
    Socket socket;
    DataInputStream dataInputStream;
    PrintStream printStream;
    
    public static void main(String[] args) {
        // TODO code application logic here
        new Client();
    }
    Client(){
        
        try {
            socket = new Socket(InetAddress.getLocalHost(),5005);
            dataInputStream = new DataInputStream(socket.getInputStream());
            printStream = new PrintStream(socket.getOutputStream());
            printStream.println("Start connection..");
            String msg = dataInputStream.readLine();
            System.out.println(msg);
        } catch (IOException ex) {
            ex.printStackTrace();
        }finally{
            printStream.close();
            try {
                dataInputStream.close();
                socket.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        
    }
}
