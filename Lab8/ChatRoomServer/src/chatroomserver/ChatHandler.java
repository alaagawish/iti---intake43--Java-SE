package chatroomserver;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Vector;


public class ChatHandler extends Thread {

    DataInputStream dataInputStream;
//    BufferedReader dataInputStream;
    PrintStream printStream;
    boolean flag = true;
    static Vector<ChatHandler> chatHandlers = new Vector<>();
    static Vector<ChatHandler> v=new Vector<>();
    
    public ChatHandler(Socket socket) {

        try {
//            dataInputStream= new BufferedReader(new InputStreamReader(in));
            dataInputStream = new DataInputStream(socket.getInputStream());
            printStream = new PrintStream(socket.getOutputStream());
            ChatHandler.chatHandlers.add(this);
            start();
        } catch (IOException ex) {

            ex.printStackTrace();

        }

    }

    public void run() {
        while (true) {
            try {

                String msg = dataInputStream.readLine();

                if (msg != null) {
                    System.out.println(msg);
                    sendMessageToAll(msg);
                } else {
                    try {

                        printStream.close();
                        dataInputStream.close();
                        flag = false;

                    } catch (IOException ex1) {
                        ex1.printStackTrace();
                    }
                }

            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }

    void sendMessageToAll(String msg) {

        for (ChatHandler chatHandler : chatHandlers) {
            if(chatHandler.flag)
            chatHandler.printStream.println(msg);
            else
                v.add(chatHandler);

        }
        for (ChatHandler chatHandler : v) {
            chatHandlers.remove(chatHandler);
        }
        
    }

}
