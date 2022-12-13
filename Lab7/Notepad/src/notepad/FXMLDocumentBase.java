package notepad;

import java.io.FileOutputStream;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextArea;
import javafx.scene.input.KeyCodeCombination;
import javafx.scene.layout.BorderPane;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyCombination;
import javafx.stage.FileChooser;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.scene.control.Alert;
import javafx.stage.Stage;

public class FXMLDocumentBase extends BorderPane {

    protected final MenuBar menuBar;
    protected final Menu fileMenu;
    protected final MenuItem newMenuItem;
    protected final MenuItem openMenuItem;
    protected final MenuItem saveMenuItem;
    protected final MenuItem exitMenuItem;
    protected final Menu editMenu;
    protected final MenuItem cutMenuItem;
    protected final MenuItem copyMenuItem;
    protected final MenuItem pasteMenuItem;
    protected final MenuItem deleteMenuItem;
    protected final MenuItem selectAllMenuItem;
    protected final Menu helpMenu;
    protected final MenuItem aboutMenuItem;
    protected final TextArea notePadTextArea;
    protected final Dialog<String> aboutDialog;
    protected final Alert exitAlert;

    public FXMLDocumentBase() {

        menuBar = new MenuBar();
        fileMenu = new Menu();
        newMenuItem = new MenuItem();
        openMenuItem = new MenuItem();
        saveMenuItem = new MenuItem();
        exitMenuItem = new MenuItem();
        editMenu = new Menu();
        cutMenuItem = new MenuItem();
        copyMenuItem = new MenuItem();
        pasteMenuItem = new MenuItem();
        deleteMenuItem = new MenuItem();
        selectAllMenuItem = new MenuItem();
        helpMenu = new Menu();
        aboutMenuItem = new MenuItem();
        notePadTextArea = new TextArea();

        setId("borderPane");
        setMaxHeight(USE_PREF_SIZE);
        setMaxWidth(USE_PREF_SIZE);
        setMinHeight(USE_PREF_SIZE);
        setMinWidth(USE_PREF_SIZE);
        setPrefHeight(400.0);
        setPrefWidth(600.0);

        BorderPane.setAlignment(menuBar, javafx.geometry.Pos.CENTER);
        
        menuBar.setId("menuBar");

        fileMenu.setId("fileMenu");
        fileMenu.setMnemonicParsing(false);
        fileMenu.setText("File");

        newMenuItem.setId("newMenuItem");
        newMenuItem.setMnemonicParsing(false);
        newMenuItem.setText("New");
        newMenuItem.setAccelerator(new KeyCodeCombination(KeyCode.N, KeyCombination.CONTROL_DOWN));

        openMenuItem.setId("openMenuItem");
        openMenuItem.setMnemonicParsing(false);
        openMenuItem.setText("Open");
        openMenuItem.setAccelerator(new KeyCodeCombination(KeyCode.O, KeyCombination.CONTROL_DOWN));

        saveMenuItem.setId("saveMenuItem");
        saveMenuItem.setMnemonicParsing(false);
        saveMenuItem.setText("Save");
        saveMenuItem.setAccelerator(new KeyCodeCombination(KeyCode.S, KeyCombination.CONTROL_DOWN));

        exitMenuItem.setId("exitMenuItem");
        exitMenuItem.setMnemonicParsing(false);
        exitMenuItem.setText("Exit");
        exitMenuItem.setAccelerator(new KeyCodeCombination(KeyCode.E, KeyCombination.CONTROL_DOWN));
        fileMenu.setAccelerator(new KeyCodeCombination(KeyCode.F, KeyCombination.SHIFT_DOWN));

        editMenu.setId("editMenu");
        editMenu.setMnemonicParsing(false);
        editMenu.setText("Edit");

        cutMenuItem.setId("cutMenuItem");
        cutMenuItem.setMnemonicParsing(false);
        cutMenuItem.setText("Cut");
        cutMenuItem.setAccelerator(new KeyCodeCombination(KeyCode.X, KeyCombination.CONTROL_DOWN));

        copyMenuItem.setId("copyMenuItem");
        copyMenuItem.setMnemonicParsing(false);
        copyMenuItem.setText("Copy");
        copyMenuItem.setAccelerator(new KeyCodeCombination(KeyCode.C, KeyCombination.CONTROL_DOWN));

        pasteMenuItem.setId("pasteMenuItem");
        pasteMenuItem.setMnemonicParsing(false);
        pasteMenuItem.setText("Paste");
        pasteMenuItem.setAccelerator(new KeyCodeCombination(KeyCode.V, KeyCombination.CONTROL_DOWN));

        deleteMenuItem.setId("deleteMenuItem");
        deleteMenuItem.setMnemonicParsing(false);
        deleteMenuItem.setText("Delete");

        selectAllMenuItem.setId("selectAllMenuItem");
        selectAllMenuItem.setMnemonicParsing(false);
        selectAllMenuItem.setText("Select All");
        selectAllMenuItem.setAccelerator(new KeyCodeCombination(KeyCode.A, KeyCombination.CONTROL_DOWN));
        editMenu.setAccelerator(new KeyCodeCombination(KeyCode.E, KeyCombination.SHIFT_DOWN));

        helpMenu.setId("helpMenu");
        helpMenu.setMnemonicParsing(false);
        helpMenu.setText("Help");

        aboutMenuItem.setId("aboutMenuItem");
        aboutMenuItem.setMnemonicParsing(false);
        aboutMenuItem.setText("About");
        setTop(menuBar);

        BorderPane.setAlignment(notePadTextArea, javafx.geometry.Pos.CENTER);
        notePadTextArea.setId("notePadTextArea");
        notePadTextArea.setPrefHeight(200.0);
        notePadTextArea.setPrefWidth(200.0);
        setCenter(notePadTextArea);

        fileMenu.getItems().add(newMenuItem);
        fileMenu.getItems().add(openMenuItem);
        fileMenu.getItems().add(saveMenuItem);
        fileMenu.getItems().add(exitMenuItem);
        menuBar.getMenus().add(fileMenu);
        editMenu.getItems().add(cutMenuItem);
        editMenu.getItems().add(copyMenuItem);
        editMenu.getItems().add(pasteMenuItem);
        editMenu.getItems().add(deleteMenuItem);
        editMenu.getItems().add(selectAllMenuItem);
        menuBar.getMenus().add(editMenu);
        helpMenu.getItems().add(aboutMenuItem);
        menuBar.getMenus().add(helpMenu);

        aboutDialog = new Dialog<String>();
        aboutDialog.setTitle("About");
        ButtonType okAboutDialog = new ButtonType("Ok", ButtonData.OK_DONE);
        aboutDialog.setContentText("This is no information about our notepad :)). ");
        aboutDialog.getDialogPane().getButtonTypes().add(okAboutDialog);

//        exitDialog = new Dialog<String>();
//        exitDialog.setTitle("Exit");
//        ButtonType yesExitButton = new ButtonType("YES", ButtonData.OK_DONE);
//        ButtonType noExitButton = new ButtonType("NO", ButtonData.OK_DONE);
//        exitDialog.setContentText("Are you sure you want to exit without saving?");
//        exitDialog.getDialogPane().getButtonTypes().addAll(yesExitButton,noExitButton);
        exitAlert = new Alert(Alert.AlertType.WARNING);
        exitAlert.setTitle("Exit");
        ButtonType cancelExitButton = new ButtonType("Cancel", ButtonData.OK_DONE);
        exitAlert.setContentText("You want to exit without saving?");
        exitAlert.getDialogPane().getButtonTypes().addAll(cancelExitButton);

        openMenuItem.setOnAction((ActionEvent event) -> {
            FileChooser fileChooser = new FileChooser();
            fileChooser.setTitle("Open Resource File");
            fileChooser.getExtensionFilters().addAll(
                    new ExtensionFilter("Text Files", "*.txt"),
                    new ExtensionFilter("Image Files", "*.png", "*.jpg", "*.gif"),
                    new ExtensionFilter("Audio Files", "*.wav", "*.mp3", "*.aac"),
                    new ExtensionFilter("All Files", "*.*"));
            
            File file = fileChooser.showOpenDialog(null);
           
            if (file != null) {
                try {
                    FileInputStream fileInputStream = null;
                    
                    fileInputStream = new FileInputStream(file);
                   
                    int size = fileInputStream.available();
                    byte[] b = new byte[size];
                    fileInputStream.read(b);
                    notePadTextArea.setText(new String(b));
                    
                    fileInputStream.close();
                    
                }catch (IOException ex) {
                    Logger.getLogger(FXMLDocumentBase.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });

        saveMenuItem.setOnAction((ActionEvent event) -> {

            byte[] text = notePadTextArea.getText().getBytes();
            if (text.length > 0) {
                FileChooser fileChooser = new FileChooser();
                fileChooser.setTitle("Save Resource File");
                File file = fileChooser.showSaveDialog(null);
                if (file != null) {
                    FileOutputStream fileOutputStream = null;
                    try {
                        fileOutputStream = new FileOutputStream(file);
                 
                        byte[] byteText = notePadTextArea.getText().getBytes();
                   
                        fileOutputStream.write(byteText);
            
                        fileOutputStream.close();
                    } catch (IOException ex) {
                        Logger.getLogger(FXMLDocumentBase.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }

            } else {

            }

        });

        helpMenu.setOnAction(event -> {

            aboutDialog.showAndWait();

        });

        exitMenuItem.setOnAction(event -> {

            byte[] b = notePadTextArea.getText().getBytes();
            if (b.length > 0) {
                Optional<ButtonType> result = exitAlert.showAndWait();
                if (result.isPresent() && result.get() == ButtonType.OK) {
                    Platform.exit();
                }
            } else {
                Platform.exit();
                
            }

        });
        newMenuItem.setOnAction((ActionEvent event) -> {

            byte[] b = notePadTextArea.getText().getBytes();

            if (b.length > 0) {
           
                Parent root = new FXMLDocumentBase();
                Stage stage = new Stage();
                stage.setTitle("Notepad");
                stage.setScene(new Scene(root, 450, 450));
                stage.show();
            }

        });

        cutMenuItem.setOnAction(event -> {

            notePadTextArea.cut();

        });

        copyMenuItem.setOnAction(event -> {

            notePadTextArea.copy();

        });

        pasteMenuItem.setOnAction(event -> {

            notePadTextArea.paste();

        });
        selectAllMenuItem.setOnAction(event -> {

            notePadTextArea.selectAll();

        });

        deleteMenuItem.setOnAction(event -> {

            notePadTextArea.deletePreviousChar();

        });

    }
}
