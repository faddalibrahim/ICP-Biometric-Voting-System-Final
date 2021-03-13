package testElection.offices;

import testElection.people.Candidate;
import testElection.people.Voter;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Class to model a polling station
 * @author Excel Chukwu
 * @version 1.0
 *
 */
public class PollingStation {
    private String pollingStationID;
    private int totalVotes = 0;
    private String districtID;
    private static HashMap<String, Integer> candidateVotes = new HashMap<>();
    private static ArrayList<String> pollingStationIDs = new ArrayList<>();


    //Constructor
    public PollingStation(String pollingStationID, String districtID) {
        this.pollingStationID = pollingStationID;
        this.districtID = districtID;
    }

    /**
     *
     * @return pollingStationID
     */
    public String getPollingStationID() {
        return pollingStationID;
    }

    /**
     *
     * @return districtID
     */
    public String getDistrictID() {
        return districtID;
    }

    /**
     *
     * @return totalVotes
     */
    public int getTotalVotes() {
        return totalVotes;
    }

    /**
     *
     * @return candidateVotes
     */
    public static HashMap<String, Integer> getCandidateVotes() {
        return candidateVotes;
    }

    //Adding IDs to the polling station ID list

    /**
     * Adds a polling station's ID to the list of polling
     * station IDs
     * @param ID
     */
    public void addPollingStationID(String ID) {
        pollingStationIDs.add(ID);
    }

    //Adding candidates and their respective votes

    /**
     * Adds a candidate to the list of candidates
     * in a polling station
     */
    private static void addCandidate() {
        for (String candidate : Candidate.getCandidateList()) {
            candidateVotes.put(candidate, 0);
        }
    }

    /**
     * Modifies the number of votes each candidate has
     * @param serialNum
     * @param candidate
     */
    public static void setCandidateVotes(int serialNum, String candidate) {
        addCandidate();
        int vote = candidateVotes.get(candidate);
        PollingStation.candidateVotes.replace(candidate, ++vote);

    }

    /**
     * returns the list of candidates in a polling station
     * @return candidateList the list of candidates the polling station has
     */
    public  ArrayList<String> getCandidateList() {
        return (ArrayList<String>) candidateVotes.keySet();
    }
}
