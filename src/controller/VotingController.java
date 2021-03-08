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
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class VotingController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private AnchorPane tabAnchorPane;

    @FXML
    private JFXButton votingPresidentButton;

    @FXML
    private ImageView presidentImage;

    @FXML
    private Label votingPresidentLabel;

    @FXML
    private JFXButton votingBackButton;

    @FXML
    private JFXButton votingResultsButton;

    @FXML
    private Label votingResultsLabel;

    @FXML
    private AnchorPane candidateDisplayPane;

    @FXML
    private JFXButton votingNDCPresident;

    @FXML
    private JFXButton votingNPPPresident;

    @FXML
    private JFXButton votingNDPPresident;

    @FXML
    private JFXButton votingPNCPresident;

    @FXML
    private Label votingNDCCandidate;

    @FXML
    private Label votingNDPCandidate;

    @FXML
    private Label votingNPPCandidate;

    @FXML
    private Label votingPNCCandidate;

    @FXML
    private AnchorPane resultsAnchorPane;

    @FXML
    void initialize() {
        candidateDisplayPane.setVisible(false);

        votingPresidentButton.setOnAction(actionEvent -> {
            displayCandidatePane();
        });

        votingBackButton.setOnAction(actionEvent -> {
            try {
                goBack();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }


    /*Helper Methods*/
    private void displayCandidatePane() {
        candidateDisplayPane.setVisible(true);
    }

    private void goBack() throws IOException {
        Stage mainStage = (Stage) votingPresidentButton.getScene().getWindow();
        votingPresidentButton.getScene().getWindow().hide();

        Parent root = FXMLLoader.load(getClass().getResource("/view/mainPage.fxml"));
        Scene mainPageScene = new Scene(root, 700, 400);
        mainStage.setScene(mainPageScene);
        mainStage.show();
    }
}
