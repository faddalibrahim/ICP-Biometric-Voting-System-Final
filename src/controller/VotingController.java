package controller;

import com.jfoenix.controls.JFXButton;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

public class VotingController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private AnchorPane tabAnchorpane;

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

    }
}
