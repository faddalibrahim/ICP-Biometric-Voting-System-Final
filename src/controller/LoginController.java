package controller;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.fxml.FXML;

import java.net.URL;
import java.util.ResourceBundle;

public class LoginController extends Application{

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private JFXTextField voterID;

    @FXML
    private JFXButton authenticateButton;

    @FXML
    void initialize() {

        authenticateButton.setOnAction(actionEvent -> {

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
}
