package fr.lernejo.guessgame;

import java.security.SecureRandom;

public class Launcher {
    public static void main(String[] args) {
        SecureRandom random = new SecureRandom();

        if(args[0].equals("-interactive")){
            Simulation mySimulation = new Simulation(new HumannPlayer());
            // long randomNumber = random.nextLong(); // génère un nombre entre Long.MIN_VALUE et Long.MAX_VALUE
            mySimulation.initialize(random.nextInt(100)) ; // génère un nombre entre 0 (inclus) et 100 (exclus)
            mySimulation.loopUntilPlayerSucceed(1000);

        } else if(args[0].equals("-auto")){
            try {
                long arg2 = Long.parseLong(args[1]);
                Simulation MySimulation = new Simulation(new ComputerPlayer());
                MySimulation.initialize(arg2);
                MySimulation.loopUntilPlayerSucceed(1000);
            } catch(Exception e) {
                System.out.println("argument 2 devrait être une valeur numrique :(");
            }
        } else {
            System.out.println("le premier argument doit être soit -interactive soit -auto et le second paramtre une valeur numrique");
        }
    }
}
