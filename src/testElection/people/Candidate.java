package testElection.people;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * @author Faddal Ibrahim
 * class:Candidate
 * Accessibility Modifier:public
 */

public class Candidate extends Person {
    private String party;
    private int votes;
    private static ArrayList<String> candidateList = new ArrayList();

    /**
     * Constructor
     *
     * @param id
     * @param name
     * @param dob
     * @param gender
     * @param party
     * @param votes
     */
    public Candidate(double id, String name, String dob, String gender, String party, int votes) {
        super(id, name, dob, gender);
        this.party = party;
        this.votes = votes;
    }

    /**
     * Accessor Method:getVotes()
     *
     * @return votes
     */
    public int getVotes() {
        return this.votes;
    }

    /**
     * Accessor Method:getParty()
     *
     * @return party
     */
    public String getParty() {
        return this.party;
    }


    /**
     * Mutator Method:setParty()
     *
     * @param party
     */
    public void setParty(String party) {
        this.party = party;
    }


    /**
     * Auxiliary method
     * @return
     */
    @Override
    public String toString() {
        return "Candidate{" +
                "name='" + getName() + '\'' +
                "party='" + party + '\'' +
                ", votes=" + votes +
                '}';
    }


    public static HashMap<String, Candidate> getCandidates() {
        HashMap<String, Candidate> candidatesMap = new HashMap();


        return candidatesMap;
    }


}
