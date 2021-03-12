package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.HashMap;

public class Voter extends Person {
    private String pollingStationCode;
    private static int ballotCount = 0;
    private boolean hasVoted = false;
    private int counter = 0;

    /**
     * Constructor
     *
     * @param name
     * @param dob
     * @param gender
     * @param id
     * @param polling_station_code
     */

    public Voter(double id, String polling_station_code, String name, String gender, String dob, boolean hasVoted) {
        super(id,name, dob, gender);
        this.pollingStationCode = polling_station_code;
        this.hasVoted = hasVoted;
    }

    public Voter() {
        //super();
    }

    /**
     * Method:vote()
     *
     * @return void
     */
    public void vote() {
        if (this.counter == 0 && this.hasVoted == false) {
            this.counter++;
            Voter.ballotCount++;
            this.hasVoted = true;
        }

    }

    /**
     * Method:ballotCount()
     *
     * @return ballotCount
     */
    public int ballotCount() {
        return ballotCount;
    }

    public boolean castVote(Candidate candidate, Voter voter){
        Connection conn = Voter.getConnection();
        PreparedStatement st;
        int updateStatus = 0;

        //update candidates vote count in database
        try{
            st = conn.prepareStatement("UPDATE candidates SET votes = ? WHERE id = ?");
            st.setInt(1, candidate.getVotes()+1);
            st.setDouble(2, candidate.getId());
            updateStatus = st.executeUpdate();
        }catch (Exception err){
            System.out.println("updating candidate vote count not successful");
        }

        //if updating candidates vote count is successful, update has_voted of voter in database
        if(updateStatus != 0){
            try{
                st = conn.prepareStatement("UPDATE voters SET has_voted = ? WHERE id = ?");
                st.setBoolean(1, true);
                st.setDouble(2, voter.getId());
                updateStatus = st.executeUpdate();
            }catch (Exception err){
                System.out.println("updating voter's has_voted not successful");
            }
        }else return false;

        return true;
    }

    public static Voter authenticate(double voterId){
        Connection conn = Voter.getConnection();
        PreparedStatement st;
        ResultSet rs;
        Voter voter = new Voter();

        try{
            st = conn.prepareStatement("SELECT * FROM voters WHERE id = ?");
            st.setDouble(1, voterId);
            rs = st.executeQuery();


            if(rs.next() && rs.getDouble("id") == voterId){
                //create voter object
                voter = new Voter(rs.getDouble("id"),rs.getString("polling_station_code"),
                                        rs.getString("name"),rs.getString("gender"),rs.getString("dob"),
                                        rs.getBoolean("has_voted"));



                if(rs.getBoolean("has_voted")){
                    voter.setAuthStatus(403); // forbidden; user has already voted
                    return voter;
                }
                else{
                    voter.setAuthStatus(200); // success; allowed to vote
                    return voter;
                }
            }
            else{
                voter.setAuthStatus(404); // no results found
                return voter;
            }

        }catch (Exception err){
            System.out.println(err.getMessage());
            return null;
        }
    }
}