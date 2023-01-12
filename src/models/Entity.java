package models;

import game.Color;

public class Entity {
    public String name;
    public int health;
    public int INITIAL_HEALTH;
    int level;
    int damage;
    
    
    
    public Entity(String name) {
        this.name = name;
        this.health = this.INITIAL_HEALTH = 10;
        this.level = 1;
        this.damage = 2;
    }
    
    public Entity(String name,int level) {
        this.name = name;
        this.level = level;
        this.health = this.INITIAL_HEALTH = level*10;
        this.damage = level*2;
    }

    public void display() {
        String who = getClass() == Mob.class ? "(Enemy) " : "(You) ";
        System.out.print(who+name + ": ");
        String color = health > INITIAL_HEALTH / 2 ? Color.GREEN_BACKGROUND : Color.RED_BACKGROUND;
        System.out.print("Health: " + health + " / " + INITIAL_HEALTH + " - ");
        for(int x = 0; x < health; x++) {
            System.out.print(color + "|");
        }
        System.out.println(Color.RESET);

    }

    public void reset() {
        this.health = INITIAL_HEALTH;
    }
    
    public boolean isDead() {
        return health <= 0;
    }

    public void attack(Entity en) {
        if(isDead()) return;
        int crit_chance = (int) (Math.random()*(100 +1)+0);
        int crit = crit_chance < 90 ? damage * 2 : 0;
        en.health -= damage + crit;
    }
    
    @Override
    public String toString() {
        return getClass().getName()+
        "["+
        "Name: " + name +
        ", Health: " + health +
        ", Damage: " + damage +
        ", Level: " + level +
        "]";
    }
}
