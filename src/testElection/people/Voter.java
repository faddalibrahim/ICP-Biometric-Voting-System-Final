package testElection.people;

import testElection.offices.*;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;


/**
 * @author Faddal Ibrahim
 * @author Excel Chukwu
 * class:Voter
 * Accessibility Modifier:public
 */
public class Voter extends Person {
    private String pollingStationCode;
    private static int ballotCount = 0;
    private boolean hasVoted = false;
    private int counter = 0;
    private PollingStation voterPollingStation;
    private static ArrayList<Long>  voterIDList = new ArrayList<>();

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

    /**
     * Method:vote()
     *
     * @return void
     */
    public void vote(Candidate candidate, Voter voter) {
        if (this.counter == 0 && this.hasVoted == false) {
            this.counter++;
            Voter.ballotCount++;
            castVote(candidate, voter);
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

    /**
     * this method casts the vote when a voter chooses which candidate
     * to vote for
     * @param candidate
     * @param voter
     * @return
     */
    private boolean castVote(Candidate candidate, Voter voter) {
        int currentCandidateVote = PollingStation.getCandidateVotes().get(candidate);
        currentCandidateVote += PollingStation.getCandidateVotes().get(candidate);

        return true;
    }

    /**
     * adds a voter ID to a list of voter IDs
     * @param ID
     */
    private static void addVoterID(Long ID) {
        voterIDList.add(ID);
    }

    /**
     * reads from a file of voter IDs and populates the voterID list
     * @throws FileNotFoundException
     */
    private static void readVoterID() throws FileNotFoundException {
        Scanner readVoterID = new Scanner(new FileInputStream("src/testElection/files/VoterIDs.txt"));
        while (readVoterID.hasNextLine()) {
            addVoterID(Long.parseLong(readVoterID.nextLine()));
        }
        readVoterID.close();
    }

    /**
     * returns a list of the voter IDs
     * @return voterIDList
     */
    public static ArrayList<Long> getVoterIDList() {
        try {
            readVoterID();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return voterIDList;
    }
}