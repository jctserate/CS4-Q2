/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package exercise6_cs4photonserate;
import java.util.Random;

/**
 *
 * @author conor serate
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Random initialGameRandom = new Random();
        int randomSeed = initialGameRandom.nextInt();
        
        Random gameSeed = new Random();
        gameSeed.setSeed(randomSeed);
        
        int monsterTurnSeed;
        
        Monster apoy = new FireType("Apoy", 100, 55);
        Monster tubig = new WaterType("Tubig", 120, 60);
        Monster damo = new GrassType("Damo", 90, 65);
        
        
        int turnCounter = 1;
        
        // Simulation 1: Damo (Grass type) vs Apoy (Fire Type)
        System.out.println("Battle Simulation 1: Damo (Grass type) vs Apoy (Fire Type)\n");
        while (damo.getHP() > 0 && apoy.getHP() > 0) {
            System.out.println("Turn Number: " + turnCounter);

            monsterTurnSeed = gameSeed.nextInt(100) + 1;
            
            switch(turnCounter%2) {
                case 1:
                    damo.monsterMoveChoice(monsterTurnSeed, apoy);
                    break;
                case 0: 
                    apoy.monsterMoveChoice(monsterTurnSeed, damo);
                    break;
            }  
            turnCounter++;
            
            System.out.println("------");
        }
        
        System.out.println("\n\n\n\n\n------");
        damo.resetHealth();
        apoy.resetHealth();
        
        // Simulation 2: Apoy (Fire type) vs Tubig (Water Type)
        System.out.println("Battle Simulation 2: Apoy (Fire type) vs Tubig (Water Type)\n");
        turnCounter = 1;
        while (apoy.getHP() > 0 && tubig.getHP() > 0) {
            System.out.println("Turn Number: " + turnCounter);
            
            monsterTurnSeed = gameSeed.nextInt(100) + 1;
            
            switch(turnCounter%2) {
                case 1:
                    apoy.monsterMoveChoice(monsterTurnSeed, tubig);
                    break;
                case 0: 
                    tubig.monsterMoveChoice(monsterTurnSeed, apoy);
                    break;
            }  
            turnCounter++;
            
            System.out.println("------");
        }
        
        System.out.println("\n\n\n\n\n------");
        apoy.resetHealth();
        tubig.resetHealth();
        
        // Simulation 3: Tubig (Water type) vs Damo (Grass Type)
        System.out.println("Battle Simulation 3: Tubig (Water type) vs Damo (Grass Type)\n");
        turnCounter = 1;
        while (tubig.getHP() > 0 && damo.getHP() > 0) {
            System.out.println("Turn Number: " + turnCounter);
            
            monsterTurnSeed = gameSeed.nextInt(100) + 1;
            
            switch(turnCounter%2) {
                case 1:
                    tubig.monsterMoveChoice(monsterTurnSeed, damo);
                    break;
                case 0: 
                    damo.monsterMoveChoice(monsterTurnSeed, tubig);
                    break;
            }  
            turnCounter++;
            
            System.out.println("------");
        }
        
        // Note for the user:
        System.out.println("--------------- NOTE ---------------");
        System.out.println("-  All moves made by the monsters  -");
        System.out.println("-          are randomized          -");
        System.out.println("-                                  -");
        System.out.println("-  The percentage chances details  -");
        System.out.println("-     are found in line 159 of     -");
        System.out.println("-           Monster.java           -");
        System.out.println("-                                  -");
        System.out.println("-   It's possible for some moves   -");
        System.out.println("-       to be showcased less       -");
        System.out.println("- or not at all in the simulations -");
        System.out.println("-                                  -");
        System.out.println("-   It is also possible that the   -");
        System.out.println("- simulations may contain too many -");
        System.out.println("-  turns, in which case you could  -");
        System.out.println("-     just run the program and     -");
        System.out.println("-    simulate the battles again    -");
        System.out.println("------------------------------------");
    }
    
}
