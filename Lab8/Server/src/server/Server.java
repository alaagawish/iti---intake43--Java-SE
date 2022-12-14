/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author LAPTOP
 */
public class Server {

    /**
     * @param args the command line arguments
     */
    
    Socket socket;
    ServerSocket serverSocket;
    DataInputStream dataInputStream;
    PrintStream printStream;
    
    public static void main(String[] args) {
        new Server();
    }
    Server(){
        try {
            serverSocket= new ServerSocket(5005);
            socket= serverSocket.accept();
            dataInputStream=  new DataInputStream(socket.getInputStream());
            printStream = new PrintStream(socket.getOutputStream());
            String msg = dataInputStream.readLine();
            System.out.println(msg);
            printStream.println("Done. Received..");
            
        } catch (IOException ex) {
            ex.printStackTrace();
        }finally{
            try {
                printStream.close();
                dataInputStream.close();
                socket.close();
                serverSocket.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        
        
    }
}
