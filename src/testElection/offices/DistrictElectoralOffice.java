package testElection.offices;

import testElection.people.Candidate;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Class for modelling a district electoral office
 * @author Excel Chukwu
 * @version 1.0
 * Accessibility Modifier:public
 */
public class DistrictElectoralOffice {
    private String districtID;
    private String districtName;
    private String regionalID;
    private ArrayList<PollingStation> districtPollingStations = new ArrayList<>();
    private HashMap<String, Integer> districtCandidateVotes = new HashMap<>();
    private static ArrayList<String> DistrictElectoralOfficeIDs;



    // adding different polling stations by district

    /**
     * adds a polling station to the list of polling stations
     * in the district
     * @param pollingStation
     */
    public void addPollingStation(PollingStation pollingStation) {
        if (pollingStation.getDistrictID().equals(this.districtID)) {
            districtPollingStations.add(pollingStation);
        }
    }

    /*public void addDistrictCandidateVote() {
        for(PollingStation pollingStation : districtPollingStations) {
            if(districtCandidateVotes.keySet().contains(pollingStation.getCandidateList())) {
                for(String candidate : pollingStation.getCandidateList()) {
                    if()
                }
            }
        }
    }*/


    //put all the candidates in the districtCandidateVotes:

    /**
     * a helper method to add the candidates in each polling station
     * as keys in the district
     */
    private void putAllCandidates() {
        for(String candidate : Candidate.getCandidateList()) {
            districtCandidateVotes.put(candidate, 0);
        }
    }

}
