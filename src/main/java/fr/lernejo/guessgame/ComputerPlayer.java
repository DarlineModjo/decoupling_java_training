package fr.lernejo.guessgame;

public class ComputerPlayer implements Player {

    long borneInf = Long.MIN_VALUE;
    long borneSup = Long.MAX_VALUE;
    long guessedNumber;

    @Override
    public long askNextGuess() {
        this.guessedNumber = (this.borneInf + this.borneSup)/2;
        System.out.println("guessedNumber: " + guessedNumber);
        return this.guessedNumber;
    }

    @Override
    public void respond(boolean lowerOrGreater) {
        if(lowerOrGreater == true) {
            this.borneSup = this.guessedNumber;
        } else {
            this.borneInf = this.guessedNumber;
        }

    }
}
