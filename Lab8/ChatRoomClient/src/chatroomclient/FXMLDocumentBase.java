package chatroomclient;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import static java.lang.System.in;
import java.net.InetAddress;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import static javafx.scene.layout.Region.USE_PREF_SIZE;

public class FXMLDocumentBase extends BorderPane implements Runnable {

    protected final TextArea chatTextArea;
    protected final AnchorPane anchorPane;
    protected final Button sendButton;
    protected final TextField msgTextField;
    protected DataInputStream dataInputStream;
    protected Socket socket;
    protected PrintStream printStream;

    Thread thread;
    String msg;

    public FXMLDocumentBase() {

        chatTextArea = new TextArea();
        anchorPane = new AnchorPane();
        sendButton = new Button();
        msgTextField = new TextField();

        setId("borderPane");
        setMaxHeight(USE_PREF_SIZE);
        setMaxWidth(USE_PREF_SIZE);
        setMinHeight(USE_PREF_SIZE);
        setMinWidth(USE_PREF_SIZE);
        setPrefHeight(400.0);
        setPrefWidth(600.0);
        setStyle("-fx-background-color: #b8b8b8;");

        BorderPane.setAlignment(chatTextArea, javafx.geometry.Pos.CENTER);
        chatTextArea.setEditable(false);
        chatTextArea.setId("chatTextArea");
        chatTextArea.setPrefHeight(200.0);
        chatTextArea.setPrefWidth(200.0);
        BorderPane.setMargin(chatTextArea, new Insets(10.0));
        setCenter(chatTextArea);

        BorderPane.setAlignment(anchorPane, javafx.geometry.Pos.CENTER);
        anchorPane.setPrefHeight(84.0);
        anchorPane.setPrefWidth(600.0);

        sendButton.setId("sendButton");
        sendButton.setLayoutX(507.0);
        sendButton.setLayoutY(27.0);
        sendButton.setMnemonicParsing(false);
        sendButton.setPrefHeight(31.0);
        sendButton.setPrefWidth(78.0);
        sendButton.setStyle("-fx-background-color: #cccccc;");
        sendButton.setText("Send");

        msgTextField.setId("msgTextField");
        msgTextField.setLayoutX(11.0);
        msgTextField.setLayoutY(27.0);
        msgTextField.setPrefHeight(31.0);
        msgTextField.setPrefWidth(467.0);
        setBottom(anchorPane);

        anchorPane.getChildren().add(sendButton);
        anchorPane.getChildren().add(msgTextField);

        try {
            socket = new Socket(InetAddress.getLocalHost(), 5005);
//            dataInputStream= new BufferedReader(new InputStreamReader(in));
            dataInputStream = new DataInputStream(socket.getInputStream());
            printStream = new PrintStream(socket.getOutputStream());
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        thread = new Thread(this);
        thread.start();

        sendButton.setOnAction(e -> {

            if (msgTextField.getText().length() > 0) {

                printStream.println(msgTextField.getText());
                chatTextArea.setText(chatTextArea.getText() + "\n" + msgTextField.getText());
                msgTextField.setText("");

            }

        });

    }

    public void closeConnection() {
        try {

            printStream.close();
            dataInputStream.close();
            socket.close();
            thread.stop();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void run() {
        while (true) {
            try {
                try {
                    msg = dataInputStream.readLine();
                } catch (IOException ex) {
                    ex.getLocalizedMessage();
                }
                if (msg != null) {
                    chatTextArea.setText(chatTextArea.getText() + "\n" + msg);
                } else {
                    try {
                        printStream.close();
                        dataInputStream.close();
                        socket.close();
                        thread.stop();

                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                }
                Thread.sleep(100);
            } catch (InterruptedException ie) {
                ie.printStackTrace();
            }

        }

    }

}
