package edu.uchicago.gerber._03objects.P8_8;

public class VotingMachine {
    private int democratVotes;
    private int republicanVotes;

    public VotingMachine() {
        // Initialize the vote tallies to 0
        democratVotes = 0;
        republicanVotes = 0;
    }

    public void voteForDemocrat() {
        democratVotes++;
    }

    public void voteForRepublican() {
        republicanVotes++;
    }

    public void clearMachineState() {
        democratVotes = 0;
        republicanVotes = 0;
    }

    public int getDemocratTally() {
        return democratVotes;
    }

    public int getRepublicanTally() {
        return republicanVotes;
    }
}

