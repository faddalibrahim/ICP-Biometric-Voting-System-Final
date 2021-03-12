package testElection.offices;

import com.company.testElection.people.Candidate;
import com.company.testElection.people.Voter;

import java.util.ArrayList;
import java.util.HashMap;

public class PollingStation {
    private String pollingStationID;
    private int totalVotes = 0;
    private String districtID;
    private static HashMap<Candidate, Integer> candidateVotes;
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

    public static HashMap<Candidate, Integer> getCandidateVotes() {
        return candidateVotes;
    }

    //Adding IDs to the polling station ID list
    public void addPollingStationID(String ID) {
        pollingStationIDs.add(ID);
    }

}
