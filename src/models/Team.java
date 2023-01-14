package models;

import game.Battle;

public class Team {
    public GameCharacter[] gcs;
    public String name;
    public int members;

    public boolean hasWon;

    public Team(GameCharacter[] gcs, String name) {
        this.gcs = gcs;
        this.name = name;
        this.members = gcs.length;
        this.hasWon = false;

        setPosition();
    }

    public void gotoBattle(Team opposing) {
        for(int x = 0; x < members; x++) {
            Battle b = null;
            switch (gcs[x].cClass) {
                case WARRIOR, MAGE -> b = new Battle(gcs[x],opposing,this);
                case HEALER -> b = new Battle(gcs[x],this,this);
            }
            b.start();
        }
    }

    public void displayHPs() {
        System.out.println("Team: " + name);
        for(GameCharacter gc : gcs) {
            System.out.println(gc);
        }
    }

    public boolean isDefeated() {
        int dead = 0;
        for(GameCharacter gc : gcs) {
            if(gc.isDead()) {
                dead++;
            }
        }
        return dead == gcs.length;
    }

    public void setPosition() {
        int pos = 0;
        for(GameCharacter gc : gcs) {
            gc.POSITION = pos++;
        }
    }
}
