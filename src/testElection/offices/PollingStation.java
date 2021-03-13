package testElection.offices;

import testElection.people.Candidate;
import testElection.people.Voter;

import java.util.ArrayList;
import java.util.HashMap;

public class PollingStation {
    private String pollingStationID;
    private int totalVotes = 0;
    private String districtID;
    private static HashMap<String, Integer> candidateVotes;
    private static ArrayList<String> pollingStationIDs = new ArrayList<>();


    //Constructor
    public PollingStation(String pollingStationID, String districtID) {
        this.pollingStationID = pollingStationID;
        this.districtID = districtID;
    }

    public int getCandidateVotes(String candidateName) {
        //Iterator<Candidate>
        return 0;
    }

    public String getPollingStationID() {
        return pollingStationID;
    }

    public String getDistrictID() {
        return districtID;
    }

    public int getTotalVotes() {
        return totalVotes;
    }

    public static HashMap<String, Integer> getCandidateVotes() {
        return candidateVotes;
    }

    //Adding IDs to the polling station ID list
    public void addPollingStationID(String ID) {
        pollingStationIDs.add(ID);
    }

    //Adding candidates and their respective votes
    private static void addCandidate() {
        for (String candidate : Candidate.getCandidateList()) {
            candidateVotes.put(candidate, 0);
        }
    }

    public static void setCandidateVotes(int serialNum, String candidate) {
        addCandidate();
        int vote = candidateVotes.get(candidate);
        PollingStation.candidateVotes.replace(candidate, ++vote);

    }
}
