/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hello;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.scene.shape.*;
import javafx.scene.paint.*;
import javafx.scene.text.*;
import javafx.scene.effect.Reflection;
/**
 *
 * @author LAPTOP
 */
public class Hello extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        Rectangle rec = new Rectangle();
        rec.setId("backgroundRec");
//        rec.setStyle("-fx-fill:linear-gradient(#000000,#ffffff,#000000);");

        rec.setWidth(700);
        rec.setHeight(650);

    
        Text hello = new Text( "Hello World");
        hello.setFont(new Font(100));
        hello.setX(50);
        hello.setY(300);
        hello.setFill(Color.RED);
        
        Reflection reflection = new Reflection();
        reflection.setFraction(0.7);
        Text reflectedHello = new Text("Hello World");
        reflectedHello.setX(50);
        reflectedHello.setY(350);
        reflectedHello.setCache(true);
        reflectedHello.setFill(Color.RED);
    
        reflectedHello.setFont(new Font(100));
        reflectedHello.setEffect(reflection);
        
        StackPane root = new StackPane();
        root.getChildren().add(rec);
        root.getChildren().add(hello);
        root.getChildren().add(reflectedHello);
        
        Scene scene = new Scene(root, 700, 650);
       //scene.getStylesheets().add("style.css");
        scene.getStylesheets().add(getClass().getResource("stylesheet.css").toString());
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
