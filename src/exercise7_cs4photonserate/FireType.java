/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package exercise7_cs4photonserate;

/**
 *
 * @author conor
 */
public class FireType extends Monster {
    private String name; 
    private int hp, base;
    
    public FireType(String name, int hp, int base) {
        super(name, "Fire", "Grass", "Water", hp, base);
    }
    
    @Override
    public void special(){
        
        if((getHP() - getMaxHP()*0.1) > 0) {
            setAtk(getAtk() + 2);
            setHp(getHP() - (int)(getMaxHP() * 0.1));
            System.out.printf("%s used their special move and increased their attack to %d and their health has decreased to %d.\n", this.getName(), getAtk(), getHP());
        } else {
            guard();
        }
    }
}
