/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chatroomserver;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;


public class ChatRoomServer {

 
    ServerSocket serverSocket;
    
    public static void main(String[] args) {
        new ChatRoomServer();
    }

    public ChatRoomServer() {
        try {
            serverSocket = new ServerSocket(5005);
            while(true){
                Socket socket = serverSocket.accept();
                
                new ChatHandler(socket);
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        
    
    }
    
    
    
    
}
