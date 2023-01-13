package models;

public class GameCharacter {
    public CharacterClass cClass;
    public int health;
    public int speed;
    public int damage;
    public int crit_chance;
    public int level;

    public final int MINIMUM_HEALTH = 100;
    public final int MINIMUM_DAMAGE= 10;

    public GameCharacter(CharacterClass cClass,int level) {
        this.cClass = cClass;
        this.health = MINIMUM_HEALTH + (level * 20);
        this.damage = MINIMUM_DAMAGE + (level * 2);
        this.speed = 3;
        this.crit_chance = 5;
        this.level = level;

        cClass.applyAttributes(this);
    }

    public boolean isDead() { return health <= 0; }
    public void action(GameCharacter target) {cClass.action(this, target);}
    public void action(GameCharacter[] targets) {cClass.action(this, targets);}

    @Override
    public String toString() {
        return cClass + " | isDEAD?" + isDead() + " - Health: " + health;
    }
}
