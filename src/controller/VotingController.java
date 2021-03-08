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
    private JFXButton votingPresidentButton;

    @FXML
    private ImageView presidentImage;

    @FXML
    private Label votingPresidentLabel;

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
    private Label ndcCandidate;

    @FXML
    private Label ndpCandidate;

    @FXML
    private Label nppCandidate;

    @FXML
    private Label pncCandidate;

    @FXML
    void initialize() {

    }
}
