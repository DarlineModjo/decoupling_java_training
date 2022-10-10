package fr.lernejo.guessgame;

import fr.lernejo.logger.Logger;
import fr.lernejo.logger.LoggerFactory;

import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;

public class Simulation {

    private final Logger logger = LoggerFactory.getLogger("simulation");
    private Player player;  //TODO add variable type
    private long numberToGuess; //TODO add variable type
    private long start;
    private long end;

    public Simulation(Player player) {
        this.player = player;
        //TODO implement me
    }

    public void initialize(long numberToGuess) {
        //TODO implement me
        this.numberToGuess = numberToGuess;
        this.start = System.currentTimeMillis();
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

    public void loopUntilPlayerSucceed(int maxIter) {
        //TODO implement me
        boolean success = nextRound();

        int iter = 0;
        while (success == false){
            iter++;
            if (iter >= maxIter) {
                System.out.println("Vous avez atteint le maximum d'iteration possible. Vous avez perdu la partie!!");
                this.end = System.currentTimeMillis();
                printGameDuration();
                return;
            }
            success = nextRound();
        }
        System.out.println(" Bravooooo en " + iter + " operations");
        this.end = System.currentTimeMillis();
        printGameDuration();
    }

    private void printGameDuration() {
        long duration = this.end - this.start;
        long minutes = duration / 1000 / 60;
        long seconds = duration / 1000 - minutes * 60;
        long milliseconds = duration - minutes * 60 * 1000 - seconds * 1000;
        System.out.printf("Votre partie a duré %d:%d.%d\n", minutes, seconds, milliseconds);
    }
}
