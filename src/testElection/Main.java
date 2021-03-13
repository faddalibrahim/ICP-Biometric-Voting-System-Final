package testElection;

import testElection.*;
import testElection.offices.PollingStation;
import testElection.people.Candidate;
import testElection.people.Voter;

import java.util.Scanner;


public class Main {
    private static Scanner consoleInput = new Scanner(System.in);
    private static Scanner fileInput;

    public static void main(String[] args) {
        // write your code here
        System.out.println("Welcome to the Ghana Electoral Management Platform.");

        /* Authenticating the voter */
        System.out.println("\n Please enter your voter ID: \n");
        long voterID = consoleInput.nextLong();
        authenticateVoter(voterID);

        /* Displaying candidates */
        System.out.println("Which candidate do you want to vote for? \n");
        displayCandidates();
        System.out.println("Enter a number representing the party and candidate you want to vote for: \n");
        int serialNum = consoleInput.nextInt();
        mainVote(serialNum);

        System.out.println("Thank you for voting!");
        System.out.println("Results so far: \n");
        displayResults();

    }


    private static void authenticateVoter(Long voterID) {
        if(Voter.getVoterIDList().contains(voterID)) {
            System.out.println("Voter Authenticated!");
        } else {
            System.out.println("Voter ID not found!");
            System.exit(0);
        }
    }

    private static void displayCandidates() {
        for (String candidate : Candidate.getCandidateList()) {
            System.out.println(candidate);
        }
    }

    private static void mainVote(int serialNum) {
        switch(serialNum) {
            case 1:
                PollingStation.setCandidateVotes(1, "1. NDC - John Dramani Mahama");
                break;
            case 2:
                PollingStation.setCandidateVotes(2, "2. NPP - Nana Addo-Danquah Akuffo Addo");
                break;
            case 3:
                PollingStation.setCandidateVotes(3, "3. NDP - Nana Konadu Agyeman-Rawlings");
                break;
            case 4:
                PollingStation.setCandidateVotes(4, "4. PNC - Excel Chukwu");
                break;
        }
    }

    private static void displayResults() {
        System.out.println(PollingStation.getCandidateVotes());
    }
}
