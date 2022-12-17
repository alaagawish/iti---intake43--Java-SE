package personaldetails;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.paint.Stop;
import javafx.stage.Stage;
import org.apache.derby.jdbc.ClientDriver;

/**
 *
 * @author LAPTOP
 */
public class PersonalDetails extends Application {

    Connection connection;
    FXMLDocumentBase root;
    int currentPerson = 0;
    static int id = 4;//get last . id
    static int next = 0;

    @Override
    public void start(Stage stage) throws Exception {
        DriverManager.registerDriver(new ClientDriver());
        connection = DriverManager.getConnection("jdbc:derby://localhost:1527/ContactList", "root", "root");
        PreparedStatement preparedStatementt = connection.prepareStatement("select * from ROOT.ID ",
                ResultSet.TYPE_SCROLL_INSENSITIVE,
                ResultSet.CONCUR_READ_ONLY);

        ResultSet resultSetCount = preparedStatementt.executeQuery();
        while (resultSetCount.next()) {
            currentPerson++;
        }
        ResultSet resultSetNext = preparedStatementt.executeQuery();
        resultSetNext.next();
        next = currentPerson - 1;
        System.out.println("#of persons=" + currentPerson + "\nnext:" + next);

        root = new FXMLDocumentBase();

        Scene scene = new Scene(root);
        initScene();

        root.newButton.setOnAction(e -> {

            if (root.newButton.getText() == "New") {
                root.updateButton.setText("Update");
                root.newButton.setText("Add");
                PreparedStatement preparedStatement;
                try {
                    preparedStatement = connection.prepareStatement("select * from ROOT.ID ",
                            ResultSet.TYPE_SCROLL_INSENSITIVE,
                            ResultSet.CONCUR_READ_ONLY);
                    ResultSet resultSet = preparedStatement.executeQuery();
                    if (resultSet.last()) {
                    }

                    setPeronDetails(resultSet.getInt(1) + 1, " ", " ", " ", " ", " ");
                    root.firstNameTextField.setEditable(true);
                    root.middleNameTextField.setEditable(true);
                    root.lastNameTextField.setEditable(true);
                    root.emailTextField.setEditable(true);
                    root.phoneTextField.setEditable(true);
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }

            } else if (root.newButton.getText().equals("New")) {
                if (checkValidation()) {
                    root.newButton.setText("New");
                    try {
                        addNewPerson(root.firstNameTextField.getText(), root.middleNameTextField.getText(), root.lastNameTextField.getText(), root.emailTextField.getText(), root.phoneTextField.getText());

                    } catch (SQLException ex) {
                        Logger.getLogger(PersonalDetails.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }

            }

        });

        root.firstPersonButton.setOnAction(e -> {
            root.updateButton.setText("Update");
            root.newButton.setText("New");
            root.newButton.setDisable(false);
            try {
                PreparedStatement preparedStatement = connection.prepareStatement("select * from ROOT.ID ",
                        ResultSet.TYPE_SCROLL_INSENSITIVE,
                        ResultSet.CONCUR_READ_ONLY);

                ResultSet resultSet = preparedStatement.executeQuery();
                resultSet.next();
                setPeronDetails(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3),
                        resultSet.getString(4), resultSet.getString(5), resultSet.getString(6));

            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            root.previousPersonButton.setDisable(true);
            root.nextPersonButton.setDisable(false);
            try {
                resultSetNext.first();
            } catch (SQLException ex) {
                Logger.getLogger(PersonalDetails.class.getName()).log(Level.SEVERE, null, ex);
            }

        });

        root.lastPersonButton.setOnAction(e -> {
            root.updateButton.setText("Update");
            root.newButton.setText("New");
            root.newButton.setDisable(false);
            try {
                PreparedStatement preparedStatement = connection.prepareStatement("select * from ROOT.ID ",
                        ResultSet.TYPE_SCROLL_INSENSITIVE,
                        ResultSet.CONCUR_READ_ONLY);

                ResultSet resultSet = preparedStatement.executeQuery();
                if (resultSet.last()) {
                    setPeronDetails(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3),
                            resultSet.getString(4), resultSet.getString(5), resultSet.getString(6));
                }

            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            root.nextPersonButton.setDisable(true);
            root.previousPersonButton.setDisable(false);
            try {
                resultSetNext.last();
            } catch (SQLException ex) {
                Logger.getLogger(PersonalDetails.class.getName()).log(Level.SEVERE, null, ex);
            }

        });

        root.updateButton.setOnAction(e -> {
            root.newButton.setText("New");
            if (root.updateButton.getText().equals("Update")) {
                root.firstNameTextField.setEditable(true);
                root.middleNameTextField.setEditable(true);
                root.lastNameTextField.setEditable(true);
                root.emailTextField.setEditable(true);
                root.phoneTextField.setEditable(true);
                root.updateButton.setText("Done");
            } else {
                try {
                    setPeronDetails(Integer.parseInt(root.iDTextField.getText()), root.firstNameTextField.getText(), root.middleNameTextField.getText(),
                            root.lastNameTextField.getText(), root.emailTextField.getText(), root.phoneTextField.getText());
                    PreparedStatement preparedStatementUpdate = connection.prepareStatement("update ROOT.ID set FIRST_NAME=? ,MIDDLE_NAME=?, LAST_NAME=? ,EMAIL=?,PHONE=? where id=?");

                    preparedStatementUpdate.setInt(6, Integer.parseInt(root.iDTextField.getText()));
                    preparedStatementUpdate.setString(1, root.firstNameTextField.getText());
                    preparedStatementUpdate.setString(2, root.middleNameTextField.getText());
                    preparedStatementUpdate.setString(3, root.lastNameTextField.getText());
                    preparedStatementUpdate.setString(4, root.emailTextField.getText());
                    preparedStatementUpdate.setString(5, root.phoneTextField.getText());

                    preparedStatementUpdate.executeUpdate();
                    root.updateButton.setText("Update");
                } catch (SQLException ex) {
                    Logger.getLogger(PersonalDetails.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
        });

        root.deleteButton.setOnAction(e -> {

            try {
                PreparedStatement preparedStatementDel = connection.prepareStatement("delete from ROOT.ID where id=?");
                preparedStatementDel.setInt(1, Integer.parseInt(root.iDTextField.getText()));
                preparedStatementDel.executeUpdate();

            } catch (SQLException ex) {
                Logger.getLogger(PersonalDetails.class.getName()).log(Level.SEVERE, null, ex);
            }
            PreparedStatement preparedStatement;
            try {
                preparedStatement = connection.prepareStatement("select * from ROOT.ID ",
                        ResultSet.TYPE_SCROLL_INSENSITIVE,
                        ResultSet.CONCUR_READ_ONLY);

                ResultSet resultSet = preparedStatement.executeQuery();
                resultSet.next();
                setPeronDetails(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3),
                        resultSet.getString(4), resultSet.getString(5), resultSet.getString(6));

            } catch (SQLException ex) {
                Logger.getLogger(PersonalDetails.class.getName()).log(Level.SEVERE, null, ex);
            }
        });

        root.nextPersonButton.setOnAction(e -> {
            root.previousPersonButton.setDisable(false);
            try {
                if (resultSetNext.next()) {
                    setPeronDetails(resultSetNext.getInt(1), resultSetNext.getString(2), resultSetNext.getString(3),
                            resultSetNext.getString(4), resultSetNext.getString(5), resultSetNext.getString(6));
                }
                if (resultSetNext.next()) {
                    resultSetNext.previous();

                } else {
                    root.nextPersonButton.setDisable(true);
                    resultSetNext.previous();

                }

            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        });

        root.previousPersonButton.setOnAction(e -> {
            root.nextPersonButton.setDisable(false);

            try {
                if (resultSetNext.previous()) {
                    setPeronDetails(resultSetNext.getInt(1), resultSetNext.getString(2), resultSetNext.getString(3),
                            resultSetNext.getString(4), resultSetNext.getString(5), resultSetNext.getString(6));
                }
                if (resultSetNext.previous()) {
                    resultSetNext.next();

                } else {
                    root.previousPersonButton.setDisable(true);
                    resultSetNext.next();

                }

            } catch (SQLException ex) {
                ex.printStackTrace();
            }

        });

        stage.setScene(scene);
        stage.show();
    }

    @Override
    public void stop() throws Exception {
        connection.close();
    }

    public static void main(String[] args) {
        launch(args);
    }

    private void initScene() throws SQLException {

        PreparedStatement preparedStatement = connection.prepareStatement("select * from ROOT.ID");

        ResultSet resultSet = preparedStatement.executeQuery();
        resultSet.next();
        setPeronDetails(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3),
                resultSet.getString(4), resultSet.getString(5), resultSet.getString(6));
        currentPerson = 1;
        root.previousPersonButton.setDisable(true);

    }

    private void setPeronDetails(int id, String fName, String mName, String lName, String mail, String phone) throws SQLException {
        if (id == 0) {
            root.iDTextField.setText("");
        } else {
            root.iDTextField.setText("" + id);
        }
        root.firstNameTextField.setText(fName);
        root.middleNameTextField.setText(mName);
        root.lastNameTextField.setText(lName);
        root.emailTextField.setText(mail);
        root.phoneTextField.setText(phone);

    }

    private boolean checkValidation() {
        if (root.iDTextField.getText().length() > 0 && root.firstNameTextField.getText().length() > 1
                && root.lastNameTextField.getText().length() > 1 && root.emailTextField.getText().length() > 1
                && root.phoneTextField.getText().length() > 1 && root.middleNameTextField.getText().length() > 1) {
            System.out.println("true");
            return true;
        }
        return false;
    }

    private void addNewPerson(String fName, String mName, String lName, String email, String phone) throws SQLException {
        PreparedStatement preparedStatementIn = connection.prepareStatement("insert into ROOT.ID Values(?,? , ? , ? , ? , ?)");
        PreparedStatement preparedStatement = connection.prepareStatement("select * from ROOT.ID ",
                ResultSet.TYPE_SCROLL_INSENSITIVE,
                ResultSet.CONCUR_READ_ONLY);

        ResultSet resultSet = preparedStatement.executeQuery();
        if (resultSet.last()) {

        }
        preparedStatementIn.setInt(1, resultSet.getInt(1) + 1);

        preparedStatementIn.setString(2, fName);
        preparedStatementIn.setString(3, mName);
        preparedStatementIn.setString(4, lName);
        preparedStatementIn.setString(5, email);
        preparedStatementIn.setString(6, phone);
        preparedStatementIn.executeUpdate();
    }
}
