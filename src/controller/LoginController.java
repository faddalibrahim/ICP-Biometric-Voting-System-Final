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

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class LoginController extends Application {

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


    @FXML
    void initialize() {
        loginAuthenticateButton.setOnAction(actionEvent -> {
            try {
                authenticateVoter();
            }catch (IOException e) {
                e.printStackTrace();
            }
        });

    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/view/login.fxml"));
        primaryStage.setTitle("Ghana Electoral Management System");
        primaryStage.setScene(new Scene(root, 700, 400));

        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

    /* Helper Methods */

    //This is just a basic authentication for when I was connecting the scenes. Change it to your own authentication (checking the database)
    private void authenticateVoter() throws IOException {
        //getting the main window
        loginAuthenticateButton.getScene().getWindow().hide();

        if(!loginVoterID.getText().trim().equals("")){
            loginAuthenticationNotification.setText("Authentication Passed");

            Stage mainPageStage = new Stage();
            Parent root = FXMLLoader.load(getClass().getResource("/view/mainPage.fxml"));
            Scene mainPageScene = new Scene(root, 700, 400);
            mainPageStage.setScene(mainPageScene);
            mainPageStage.show();
        } else {
            loginAuthenticationNotification.setText("Authentication Failed.");   //The scene changes too quickly, but if you can make this show in time before the scene changes, that'd be cool
        }
    }


}
