package models;

public class Player extends Entity {
    int power;
    int xp;
    int mana = 100;
    
    int XP_CAP = 100;
    
    public Player(String name) {
        super(name);
        this.power = 0;
    }
    
    public void levelUP() {
        if(xp >= XP_CAP) {
            health = INITIAL_HEALTH = level*10 + 4;
            damage += 3.5;
            mana += 2;
            xp = xp - XP_CAP;
            level += 1;
            XP_CAP += 50;
        }
    }
}
