package controller;

import com.jfoenix.controls.JFXButton;

import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import model.Candidate;
import model.Voter;

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

    Voter newVoter;
    HashMap<String, Candidate> candidates;

    @FXML
    private void castVote(ActionEvent event) throws IOException {
        /*idea to minimize this code later
        * set a label to hold the name of the party clicked
        * now do newVoter.castVote(candidates.get(label.getText()),newVoter)
        * */


        if(event.getSource() == votingNDCPresident){
            //if(newVoter.castVote("NDC",candidates.get("NDC").getVotes())) goToThankYouPage();
            // display an error if something goes wrong
            if(newVoter.castVote(candidates.get("NDC"),newVoter)) goToResultsPage();
        }
        else if(event.getSource() == votingNPPPresident){
            if(newVoter.castVote(candidates.get("NPP"),newVoter)) goToResultsPage();
        }
        else if(event.getSource() == votingNDPPresident){
            if(newVoter.castVote(candidates.get("NDP"),newVoter)) goToResultsPage();
        }
        else if(event.getSource() == votingPNCPresident){
            if(newVoter.castVote(candidates.get("PNC"),newVoter)) goToResultsPage();
        }
    }

    @FXML
    void initialize() throws IOException {
        fetchCandidates();

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

    private void fetchCandidates() throws IOException {
        candidates = Candidate.getCandidates();
        System.out.println(candidates);
    }


    /*Helper Methods*/

    private void displayCandidatePane() {
        candidateDisplayPane.setVisible(true);
    }

    private void castVote(){
        System.out.println("yoooo");
    }

    private void goBack() throws IOException {
        Stage mainStage = (Stage) votingPresidentButton.getScene().getWindow();
        votingPresidentButton.getScene().getWindow().hide();

        Parent root = FXMLLoader.load(getClass().getResource("/view/mainPage.fxml"));
        Scene mainPageScene = new Scene(root, 700, 400);
        mainStage.setScene(mainPageScene);
        mainStage.show();
    }

    private void goToResultsPage() throws IOException {
        Stage resultsStage = (Stage) votingPresidentButton.getScene().getWindow();
        votingPresidentButton.getScene().getWindow().hide();

        Parent root = FXMLLoader.load(getClass().getResource("/view/results.fxml"));
        Scene resultsPageScene = new Scene(root, 700, 400);
        resultsStage.setScene(resultsPageScene);
        resultsStage.show();
    }

    public void getVoterFromMainPage(Voter voter){
        newVoter = voter;
        //System.out.println("voter data has been collected");
        System.out.println("voter has been received on the voting page");
        //System.out.println(voter.getName());
    }
}
