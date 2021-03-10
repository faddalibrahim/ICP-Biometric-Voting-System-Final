package controller;

import com.jfoenix.controls.JFXButton;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import model.Voter;

public class MainPageController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private JFXButton mainPageResultsButton;

    @FXML
    private JFXButton mainPageVoteButton;

    @FXML
    private JFXButton mainPageLogoutButton;

    @FXML
    private Label mainPageWelcomeLabel;

    Voter newVoter; // from the login page

    @FXML
    void initialize() {
        //mainPageWelcomeLabel.setText("Welcome" + newVoter.getName());

        mainPageVoteButton.setOnAction(actionEvent -> {
            try {
                changeSceneOnVoteButtonClick();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        mainPageLogoutButton.setOnAction(actionEvent -> {
            try {
                logout();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        mainPageResultsButton.setOnAction(actionEvent -> {
            try {
                changeSceneOnResultsButtonClick();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

    }

    private void changeSceneOnVoteButtonClick() throws IOException {


        FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/voting.fxml"));
        Parent votingRoot = loader.load();

        VotingController votingController = loader.getController();
        votingController.getVoterFromMainPage(newVoter);


        Stage stage = (Stage) mainPageVoteButton.getScene().getWindow();
        Scene scene = new Scene(votingRoot);
        stage.setScene(scene);
        stage.show();
        //System.out.println(newVoter.getGender());
    }

    private void changeSceneOnResultsButtonClick() throws IOException {
        //mainPageVoteButton.getScene().getWindow().hide();
        Stage resultsStage = (Stage) mainPageResultsButton.getScene().getWindow();
        //Stage votingStage = new Stage();

        Parent votingRoot = FXMLLoader.load(getClass().getResource("/view/results.fxml"));
        Scene resultsScene = new Scene(votingRoot, 806, 602);
        resultsStage.setScene(resultsScene);
        resultsStage.show();
    }

    private void logout() throws IOException{
        Stage logoutStage = (Stage) mainPageVoteButton.getScene().getWindow();

        Parent root = FXMLLoader.load(getClass().getResource("/view/login.fxml"));
        Scene mainPageScene = new Scene(root, 700, 400);
        logoutStage.setScene(mainPageScene);
        logoutStage.show();
    }

    public void getVoterFromLoginPage(Voter voter){
        System.out.println(voter.getName());
        newVoter = voter;
        System.out.println(newVoter.getName());
        //newVoter = voter;
        System.out.println("voter has been received on the main page");
        //newVoter.getName()
        mainPageWelcomeLabel.setText("Welcome " + voter.getName());

    }
}
