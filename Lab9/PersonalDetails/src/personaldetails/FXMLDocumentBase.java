package personaldetails;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;

public class FXMLDocumentBase extends BorderPane {

    protected final Label personDetailsLabel;
    protected final FlowPane flowPane;
    protected final FlowPane labelsFlowPane;
    protected final Label iDLabel;
    protected final Label fNameLabel;
    protected final Label mNameLabel;
    protected final Label lastNameLabel;
    protected final Label emailLabel;
    protected final Label phoneLabel;
    protected final FlowPane textFieldsFlowPane;
    protected final TextField iDTextField;
    protected final TextField firstNameTextField;
    protected final TextField middleNameTextField;
    protected final TextField lastNameTextField;
    protected final TextField emailTextField;
    protected final TextField phoneTextField;
    protected final FlowPane buttonsFlowPane;
    protected final Button newButton;
    protected final Button updateButton;
    protected final Button deleteButton;
    protected final Button firstPersonButton;
    protected final Button previousPersonButton;
    protected final Button nextPersonButton;
    protected final Button lastPersonButton;

    public FXMLDocumentBase() {

        personDetailsLabel = new Label();
        flowPane = new FlowPane();
        labelsFlowPane = new FlowPane();
        iDLabel = new Label();
        fNameLabel = new Label();
        mNameLabel = new Label();
        lastNameLabel = new Label();
        emailLabel = new Label();
        phoneLabel = new Label();
        textFieldsFlowPane = new FlowPane();
        iDTextField = new TextField();
        firstNameTextField = new TextField();
        middleNameTextField = new TextField();
        lastNameTextField = new TextField();
        emailTextField = new TextField();
        phoneTextField = new TextField();
        buttonsFlowPane = new FlowPane();
        newButton = new Button();
        updateButton = new Button();
        deleteButton = new Button();
        firstPersonButton = new Button();
        previousPersonButton = new Button();
        nextPersonButton = new Button();
        lastPersonButton = new Button();

        setMaxHeight(USE_PREF_SIZE);
        setMaxWidth(USE_PREF_SIZE);
        setMinHeight(USE_PREF_SIZE);
        setMinWidth(USE_PREF_SIZE);
        setPrefHeight(550.0);
        setPrefWidth(650.0);
        setPadding(new Insets(10.0));

        BorderPane.setAlignment(personDetailsLabel, javafx.geometry.Pos.CENTER);
        personDetailsLabel.setAlignment(javafx.geometry.Pos.BASELINE_LEFT);
        personDetailsLabel.setPrefHeight(21.0);
        personDetailsLabel.setPrefWidth(609.0);
        personDetailsLabel.setText("Personal Details");
        BorderPane.setMargin(personDetailsLabel, new Insets(0.0));
        setTop(personDetailsLabel);

        BorderPane.setAlignment(flowPane, javafx.geometry.Pos.CENTER);
        flowPane.setPrefHeight(200.0);
        flowPane.setPrefWidth(200.0);
        flowPane.setStyle("-fx-border-width: 1; -fx-border-color: #000000;-fx-background-color: #ffffff;");

        labelsFlowPane.setOrientation(javafx.geometry.Orientation.VERTICAL);
        labelsFlowPane.setPrefHeight(410.0);
        labelsFlowPane.setPrefWidth(155.0);

        iDLabel.setText("ID");
        FlowPane.setMargin(iDLabel, new Insets(20.0));

        fNameLabel.setLayoutX(30.0);
        fNameLabel.setLayoutY(30.0);
        fNameLabel.setText("First Name");
        FlowPane.setMargin(fNameLabel, new Insets(30.0, 20.0, 20.0, 20.0));

        mNameLabel.setLayoutX(10.0);
        mNameLabel.setLayoutY(71.0);
        mNameLabel.setText("Middle Name");
        FlowPane.setMargin(mNameLabel, new Insets(20.0));

        lastNameLabel.setLayoutX(10.0);
        lastNameLabel.setLayoutY(92.0);
        lastNameLabel.setText("Last Name");
        FlowPane.setMargin(lastNameLabel, new Insets(30.0, 20.0, 20.0, 20.0));

        emailLabel.setLayoutX(10.0);
        emailLabel.setLayoutY(113.0);
        emailLabel.setText("Email");
        FlowPane.setMargin(emailLabel, new Insets(20.0));

        phoneLabel.setLayoutX(10.0);
        phoneLabel.setLayoutY(134.0);
        phoneLabel.setText("Phone");
        FlowPane.setMargin(phoneLabel, new Insets(20.0, 20.0, 0.0, 20.0));

        textFieldsFlowPane.setOrientation(javafx.geometry.Orientation.VERTICAL);
        textFieldsFlowPane.setPrefHeight(410.0);
        textFieldsFlowPane.setPrefWidth(453.0);
        textFieldsFlowPane.setStyle("-fx-background-color: #ffffff;");

        iDTextField.setEditable(false);
        iDTextField.setPrefHeight(28.0);
        iDTextField.setPrefWidth(323.0);
        iDTextField.setLayoutX(11.0);
        iDTextField.setLayoutY(27.0);

        FlowPane.setMargin(iDTextField, new Insets(10.0, 20.0, 20.0, 0.0));

        firstNameTextField.setLayoutX(10.0);
        firstNameTextField.setLayoutY(10.0);
        firstNameTextField.setEditable(false);
        FlowPane.setMargin(firstNameTextField, new Insets(20.0, 20.0, 20.0, 0.0));

        middleNameTextField.setLayoutX(152.0);
        middleNameTextField.setLayoutY(10.0);
        middleNameTextField.setEditable(false);
        FlowPane.setMargin(middleNameTextField, new Insets(15.0, 20.0, 20.0, 0.0));

        lastNameTextField.setLayoutX(10.0);
        lastNameTextField.setLayoutY(38.0);
        lastNameTextField.setEditable(false);
        FlowPane.setMargin(lastNameTextField, new Insets(15.0, 20.0, 20.0, 0.0));

        emailTextField.setLayoutX(152.0);
        emailTextField.setLayoutY(38.0);
        emailTextField.setEditable(false);
        FlowPane.setMargin(emailTextField, new Insets(15.0, 20.0, 20.0, 0.0));

        phoneTextField.setLayoutX(10.0);
        phoneTextField.setLayoutY(66.0);
        phoneTextField.setEditable(false);
        FlowPane.setMargin(phoneTextField, new Insets(15.0, 20.0, 0.0, 0.0));
        BorderPane.setMargin(flowPane, new Insets(10.0));
        setCenter(flowPane);

        BorderPane.setAlignment(buttonsFlowPane, javafx.geometry.Pos.CENTER);
        buttonsFlowPane.setPrefHeight(78.0);
        buttonsFlowPane.setPrefWidth(630.0);
        buttonsFlowPane.setStyle("-fx-background-color: #ffffff;");

        newButton.setMnemonicParsing(false);
        newButton.setText("New");
        FlowPane.setMargin(newButton, new Insets(5.0, 5.0, 5.0, 60.0));

        updateButton.setLayoutX(10.0);
        updateButton.setLayoutY(10.0);
        updateButton.setMnemonicParsing(false);
        updateButton.setText("Update");
        FlowPane.setMargin(updateButton, new Insets(5.0));

        deleteButton.setLayoutX(66.0);
        deleteButton.setLayoutY(10.0);
        deleteButton.setMnemonicParsing(false);
        deleteButton.setText("Delete");
        FlowPane.setMargin(deleteButton, new Insets(5.0));

        firstPersonButton.setLayoutX(122.0);
        firstPersonButton.setLayoutY(10.0);
        firstPersonButton.setMnemonicParsing(false);
        firstPersonButton.setText("First");
        FlowPane.setMargin(firstPersonButton, new Insets(5.0));

        previousPersonButton.setLayoutX(178.0);
        previousPersonButton.setLayoutY(10.0);
        previousPersonButton.setMnemonicParsing(false);
        previousPersonButton.setText("Previous");
        FlowPane.setMargin(previousPersonButton, new Insets(5.0));

        nextPersonButton.setLayoutX(234.0);
        nextPersonButton.setLayoutY(10.0);
        nextPersonButton.setMnemonicParsing(false);
        nextPersonButton.setText("Next");
        FlowPane.setMargin(nextPersonButton, new Insets(5.0));

        lastPersonButton.setLayoutX(290.0);
        lastPersonButton.setLayoutY(10.0);
        lastPersonButton.setMnemonicParsing(false);
        lastPersonButton.setText("Last");
        FlowPane.setMargin(lastPersonButton, new Insets(5.0));
        buttonsFlowPane.setPadding(new Insets(10.0, 0.0, 0.0, 0.0));
        setBottom(buttonsFlowPane);

        labelsFlowPane.getChildren().add(iDLabel);
        labelsFlowPane.getChildren().add(fNameLabel);
        labelsFlowPane.getChildren().add(mNameLabel);
        labelsFlowPane.getChildren().add(lastNameLabel);
        labelsFlowPane.getChildren().add(emailLabel);
        labelsFlowPane.getChildren().add(phoneLabel);
        flowPane.getChildren().add(labelsFlowPane);
        textFieldsFlowPane.getChildren().add(iDTextField);
        textFieldsFlowPane.getChildren().add(firstNameTextField);
        textFieldsFlowPane.getChildren().add(middleNameTextField);
        textFieldsFlowPane.getChildren().add(lastNameTextField);
        textFieldsFlowPane.getChildren().add(emailTextField);
        textFieldsFlowPane.getChildren().add(phoneTextField);
        flowPane.getChildren().add(textFieldsFlowPane);
        buttonsFlowPane.getChildren().add(newButton);
        buttonsFlowPane.getChildren().add(updateButton);
        buttonsFlowPane.getChildren().add(deleteButton);
        buttonsFlowPane.getChildren().add(firstPersonButton);
        buttonsFlowPane.getChildren().add(previousPersonButton);
        buttonsFlowPane.getChildren().add(nextPersonButton);
        buttonsFlowPane.getChildren().add(lastPersonButton);

//        deleteButton.setOnAction(e->{
//        
//        
//        });
//        
//        newButton.setOnAction(e->{
//        
//        
//        });
//        
//        firstPersonButton.setOnAction(e->{
//        
//        
//        });
//          
//        updateButton.setOnAction(e->{
//        
//        
//        });
//        lastPersonButton.setOnAction(e->{
//        
//        
//        });
//        previousPersonButton.setOnAction(e->{
//        
//        
//        });
//        nextPersonButton.setOnAction(e->{
//        
//        
//        });
    }
}
