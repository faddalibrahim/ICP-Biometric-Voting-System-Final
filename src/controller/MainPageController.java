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

    @FXML
    void initialize() {
        mainPageVoteButton.setOnAction(actionEvent -> {
            try {
                changeSceneOnVoteButtonClick();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

    }

    private void changeSceneOnVoteButtonClick() throws IOException {
        mainPageVoteButton.getScene().getWindow().hide();
        Stage votingStage = new Stage();

        Parent votingRoot = FXMLLoader.load(getClass().getResource("/view/voting.fxml"));
        Scene votingScene = new Scene(votingRoot, 805, 601);
        votingStage.setScene(votingScene);
        votingStage.show();
    }
}
