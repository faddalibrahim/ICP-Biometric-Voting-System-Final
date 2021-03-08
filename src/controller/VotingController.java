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
    private JFXButton presidentButton;

    @FXML
    private ImageView presidentImage;

    @FXML
    private JFXButton parliamentButton;

    @FXML
    private ImageView parliamentImage;

    @FXML
    private AnchorPane candidateDisplayPane;

    @FXML
    private JFXButton ndcPresident;

    @FXML
    private JFXButton nppPresident;

    @FXML
    private JFXButton ndpPresident;

    @FXML
    private JFXButton pncPresident;

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
