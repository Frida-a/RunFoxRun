package edu.uchicago.gerber._03objects.P8_8;

public class Driver {
    public static void main(String[] args) {
        VotingMachine machine = new VotingMachine();

        machine.voteForDemocrat();
        machine.voteForDemocrat();
        machine.voteForRepublican();

        int democratTally = machine.getDemocratTally();
        int republicanTally = machine.getRepublicanTally();

        System.out.println("Democrat Tally: " + democratTally); // Output: 2
        System.out.println("Republican Tally: " + republicanTally); // Output: 1

        machine.clearMachineState();

        democratTally = machine.getDemocratTally();
        republicanTally = machine.getRepublicanTally();

        System.out.println("Democrat Tally after clearing: " + democratTally); // Output: 0
        System.out.println("Republican Tally after clearing: " + republicanTally); // Output: 0
    }
}
