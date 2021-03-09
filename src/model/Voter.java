package model;

public class Voter extends Person {
    private int idNumber;
    private int pollingStationCode;
    private static int ballotCount = 0;
    private boolean hasVoted = false;
    private int counter = 0;

    /**
     * Constructor
     *
     * @param name
     * @param dob
     * @param gender
     * @param idNumber
     * @param pollingStationCode
     */
    public Voter(String name, String dob, String gender, int idNumber, int pollingStationCode) {
        super(name, dob, gender);

        this.idNumber = idNumber;
        this.pollingStationCode = pollingStationCode;
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
}