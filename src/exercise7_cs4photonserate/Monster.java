/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package exercise7_cs4photonserate;

import java.util.ArrayList;

public abstract class Monster implements Interactive {
    private final String name, type, strongAgainst, weakAgainst;
    private int maxHP, hp, atk, def, xp, lvl;
    private boolean guard, charge;
    private static ArrayList<Monster> monsterList = new ArrayList<>();

    public Monster(String n, String t, String s, String w, int m, int base){
        name = n;
        type = t;
        strongAgainst = s;
        weakAgainst = w;
        maxHP = m;
        hp = m;
        switch (t) {
            case "Fire":
                atk = (int)(base*1.3);
                def = (int)(base*0.7);
                break;
            case "Water":
                atk = base;
                def = base;
                break;
            case "Grass":
                atk = (int)(base*0.7);
                def = (int)(base*1.3);
                break;
        }
        xp = 0;
        lvl = 1;
        monsterList.add(this);
        guard = false;
        charge = false;
    }

    public String getName() {
        return name;
    }
    public int getMaxHP() {
        return maxHP;
    }
    public int getHP() {
        return hp;
    }
    public int getAtk() {
        return atk;
    }
    public int getDef() {
        return def;
    }
    public static ArrayList<Monster> getMonsterList() {
        return monsterList;
    }

    public void attack(Monster m){
        int damage = (int) ((atk*atk)/(double)(atk+m.getDef()));    // damage is calculated as double, then cast as int
        boolean strong = false, weak = false;
        
        if(strongAgainst.equals(m.type)){
            damage *= 2;
            strong = true;
        }
        if(weakAgainst.equals(m.type)){
            damage *= 0.5;
            weak = true;
        }
        if(m.guard){
            m.guard = false;
            damage *= 0.7;
        }
        if(charge){
            charge = false;
            damage *= 1.3;
        }
        m.setHp(m.hp - damage);
        if(m.hp < 0) m.setHp(0);
            System.out.println(name  + " attacked " + m.getName() +
            " and dealt " + damage + " damage, reducing it to " + m.getHP() + "HP.");
        if(strong) System.out.println("It was super effective!");
        if(weak) System.out.println("It wasn't very effective...");
        gainXP(2);                                                  // every attack raises XP by 2

        if(m.getHP() <= 0){
            m.setHp(0);
            System.out.println(m.getName() + " fainted.");
            gainXP(10);                                             // defeating a monster raises XP by 10
        }
    }

    public void guard(){
        guard = true;
        System.out.println(name + " put up its guard. It will receive 30% less damage on the next attack.");
    }

    public void charge(){
        if (!charge) {
        charge = true;
        System.out.println(name + " charged. Its next attack will do 30% more damage.");
        } else {
            rest();
        }
    }

    public void rest(){
        setHp(hp + (int)(maxHP * 0.15));
        if(hp > maxHP) setHp(maxHP);
        System.out.println(name + " rested. It's health is now " + hp + ".");
    }
    
    public abstract void special();

    public void resetHealth(){
        setHp(maxHP);
    }

    // handles all increases in XP
    private void gainXP(int i){
        xp += i;
        if(xp >= 100){
            xp %= 100;
            lvl++;
            setMaxHP(maxHP + 5);
            setHp(hp + 5);
            setAtk(atk + 2);
            setDef(def + 2);
            System.out.println(name + " levelled up to " + lvl + "!");
        }
    }
    
    public void setHp(int hp) {
        this.hp = hp;
    }

    public void setAtk(int atk) {
        this.atk = atk;
    }

    public void setDef(int def) {
        this.def = def;
    }

    public void setMaxHP(int maxHP) {
        this.maxHP = maxHP;
    }
    
    
    
    
    
    @Override
    public void interact() {
        System.out.printf("This is %s: %s Type\n", this.name, this.type);
    }
    
    
    
    
    
    public void monsterMoveChoice(int monsterTurnSeed, Monster target) {
        
        if(0 < monsterTurnSeed && monsterTurnSeed <= 35) { // 35% Chance to do a basic attack
            attack(target);
            
        } else if (35 < monsterTurnSeed && monsterTurnSeed <= 55) { // 20% Chance to guard
            guard();
            
        } else if (55 < monsterTurnSeed && monsterTurnSeed <= 70) { // 15% Chance to do their special move
            special();                                              // If unable to do so due to low HP, will guard instead
            
        } else if (70 < monsterTurnSeed && monsterTurnSeed <= 90) { // 20% Chance to charge
            charge();                                               // If already charged previously, will rest instead
            
        } else if (90 < monsterTurnSeed && monsterTurnSeed <= 100) { // 10% Chance to rest
            rest();
        }
    }
}
