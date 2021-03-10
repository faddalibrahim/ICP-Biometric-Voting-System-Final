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
            }
        });

    }

    private void authenticateVoter() throws IOException {
        double voterId = Double.parseDouble(loginVoterID.getText());
        Voter voter = Voter.authenticate(voterId);

        if(voter.getAuthStatus() == 200){
            goToMainPage();
        }
        else if(voter.getAuthStatus() == 403){
            loginAuthenticationNotification.setText("You have already voted!");
        }
        else if(voter.getAuthStatus() == 404){
            loginAuthenticationNotification.setText("No results found for voter");
        }

    }

    private void goToMainPage() throws IOException {
        Stage mainPageStage = (Stage) loginAuthenticateButton.getScene().getWindow();
        Parent mainPageRoot = FXMLLoader.load(getClass().getResource("/view/mainPage.fxml"));
        Scene mainPageScene = new Scene(mainPageRoot, 700, 400);
        mainPageStage.setScene(mainPageScene);
        mainPageStage.show();
    }

}
