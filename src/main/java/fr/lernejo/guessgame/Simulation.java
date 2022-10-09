package fr.lernejo.guessgame;

import fr.lernejo.logger.Logger;
import fr.lernejo.logger.LoggerFactory;

import java.util.Scanner;

public class Simulation {

    private final Logger logger = LoggerFactory.getLogger("simulation");
    private Player player;  //TODO add variable type
    private long numberToGuess; //TODO add variable type
    private int i;

    public Simulation(Player player) {
        this.player = player;
        //TODO implement me
    }

    public void initialize(long numberToGuess) {
        //TODO implement me
        this.numberToGuess = numberToGuess;
    }

    /**
     * @return true if the player have guessed the right number
     */
    private boolean nextRound() {
        //TODO implement me
        long insertNumberByPlayer = player.askNextGuess();
        if (this.numberToGuess == insertNumberByPlayer) {
            logger.log("Bon nombre !");
            return true;
        } else {
            player.respond(insertNumberByPlayer > this.numberToGuess);
            return false;
        }
    }

    public void loopUntilPlayerSucceed() {
        //TODO implement me
        boolean success = nextRound();

        while (success == false){
            this.i++;
            success = nextRound();
        }
        System.out.println(" Bravooooo en " + this.i + " operations");
    }
}
