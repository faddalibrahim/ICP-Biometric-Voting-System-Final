package controller;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.fxml.FXML;
import model.Voter;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ResourceBundle;

public class LoginController implements Initializable {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Label loginLoginLabel;

    @FXML
    private JFXTextField loginVoterID;

    @FXML
    private JFXButton loginAuthenticateButton;

    @FXML
    private Label loginAuthenticationNotification;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        loginAuthenticateButton.setOnAction(actionEvent -> {
            try {
                authenticateVoter();
            }catch (IOException e) {
                e.printStackTrace();
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }
        });

    }

    /**
     * Authenticates the voter to see if:
     * 1. voter is registered
     * 2. Voter has already voted
     * @throws IOException
     * @throws NumberFormatException
     */
    private void authenticateVoter() throws IOException, NumberFormatException {
        double voterId = Double.parseDouble(loginVoterID.getText());
        Voter voter = Voter.authenticate(voterId);

        if(voter.getAuthStatus() == 200){
            goToMainPage(voter);
        }
        else if(voter.getAuthStatus() == 403){
            loginAuthenticationNotification.setText("You have already voted!");
        }
        else if(voter.getAuthStatus() == 404){
            loginAuthenticationNotification.setText("No results found for voter");
        }

    }

    /**
     * goes to the main page from the click of the
     * 'Authenticate' button
     * @param voter
     * @throws IOException
     */
    private void goToMainPage(Voter voter) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/mainPage.fxml"));
        Parent mainPageRoot = loader.load();

        MainPageController mainPageController = loader.getController();
        mainPageController.getVoterFromLoginPage(voter);


        Stage stage = (Stage) loginAuthenticateButton.getScene().getWindow();
        Scene scene = new Scene(mainPageRoot);
        stage.setScene(scene);
        stage.show();

    }

}
