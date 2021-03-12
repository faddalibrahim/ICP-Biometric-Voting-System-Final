package controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import model.Voter;

import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ResourceBundle;

public class ResultsController implements Initializable {

    @FXML
    private Label nppResults;

    @FXML
    private Label ndcResults;

    @FXML
    private Label pncResults;

    @FXML
    private Label ndpResults;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        fetchResults();
    }

    private void fetchResults(){
        Connection conn = Voter.getConnection();
        String query = "SELECT * FROM candidates";
        Statement st;
        ResultSet rs;

        try {
            st = conn.createStatement();
            rs = st.executeQuery(query);

            while (rs.next()) {
                if(rs.getString("party").equals("NPP")){

                    nppResults.setText(String.valueOf(rs.getInt("votes")));
                }
                else if(rs.getString("party").equals("NDC")){
                    ndcResults.setText(String.valueOf(rs.getInt("votes")));
                }
                else if(rs.getString("party").equals("PNC")){
                    pncResults.setText(String.valueOf(rs.getInt("votes")));
                }
                else if(rs.getString("party").equals("NDP")){
                    ndpResults.setText(String.valueOf(rs.getInt("votes")));
                }
            }
            conn.close();
        } catch (Exception err) {
            System.out.println(err.getMessage());
        }

    }
}