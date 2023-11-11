/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package exercise6_cs4photonserate;

/**
 *
 * @author conor
 */
public class GrassType extends Monster{
    private String name; 
    private int hp, base;
    
    public GrassType(String name, int hp, int base) {
        super(name, "Grass", "Water", "Fire", hp, base);
    }
    
    @Override
    public void rest(){
        setHp(getHP()+(int)(getMaxHP()*0.5));
        if(getHP() > getMaxHP()) setHp(getMaxHP());
        System.out.println(this.getName() + " rested. It's health is now " + getHP() + ".");
    }    
    
    @Override
    public void special(){
        setMaxHP((int) (getMaxHP() * 1.2));
        System.out.printf("%s used their special move and increased their max hp to %d.\n", this.getName(), getMaxHP());
    }

}

