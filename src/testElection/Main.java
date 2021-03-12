package testElection;

import testElection.*;
import testElection.people.Voter;

import java.util.Scanner;


public class Main {
    private static Scanner consoleInput = new Scanner(System.in);
    private static Scanner fileInput;

    public static void main(String[] args) {
	// write your code here
        System.out.println("Welcome to the Ghana Electoral Management Platform.");

        System.out.println("\n Please enter your voter ID: \n");
        long voterID = consoleInput.nextLong();
        if(Voter.getVoterIDList().contains(voterID)) {
            System.out.println();
        }

    }
}
