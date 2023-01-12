package models;

public class Mob extends Entity {
    
    public Mob(String name,int level) {
        super(name,level);
    }
    
    public Mob() {
        super("Monster",10);
    }

    public int dropXP(Player player) {
        int xp = level * 10;
        player.xp += xp;
        return xp;
    }
}
