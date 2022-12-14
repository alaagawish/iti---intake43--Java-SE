
package chatroomclient;

import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class ChatRoomClient extends Application {
    FXMLDocumentBase root;
    @Override
    public void start(Stage stage) throws Exception {
        root = new FXMLDocumentBase();
        
        Scene scene = new Scene(root);
        
        stage.setScene(scene);
        stage.setTitle("Chat Room");
        stage.show();
        stage.setOnCloseRequest(e->{
            root.closeConnection();
            
        });
    }
   
   
    @Override
    public void stop() throws Exception{
        
        System.out.println("stop() => "+Thread.currentThread().getName());
        
    }
    public static void main(String[] args) {

        launch(args);
        
    }


    
    
}
