/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package exercise7_cs4photonserate;

/**
 *
 * @author conor serate
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
      
        
        Location forest = new Location("Forest", "Glowing Mushroom");
        Trainer pisay = new Trainer("Pisay", forest);
        NPC bob = new NPC("Bob", forest);
        Monster apoy = new FireType("Apoy", 100, 55); 
        
        
        pisay.inspect(apoy);
        pisay.inspect(bob);
        pisay.inspect(forest);

        
    }
    
}
