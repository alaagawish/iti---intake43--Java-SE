/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lifecycle;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author LAPTOP
 */
public class LifeCycle extends Application {
    @Override
    public void init() throws Exception{
        
        System.out.println("init() => "+Thread.currentThread().getName());
        
    }
    
    
    @Override
    public void stop() throws Exception{
        
        System.out.println("stop() => "+Thread.currentThread().getName());
        
    }
    @Override
    public void start(Stage primaryStage) {
        
        System.out.println("start() => "+Thread.currentThread().getName());
        Button btn = new Button();
        btn.setText("Say 'Hello World'");
       
        
        StackPane root = new StackPane();
        root.getChildren().add(btn);
        
        Scene scene = new Scene(root, 300, 250);
        
        primaryStage.setTitle("Hello World!");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
