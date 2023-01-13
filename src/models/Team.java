package models;

import game.Battle;

public class Team {
    public GameCharacter[] gcs;
    public String name;
    public int members;

    public Team(GameCharacter[] gcs, String name) {
        this.gcs = gcs;
        this.name = name;
        this.members = gcs.length;
    }

    public void gotoBattle(Team opposing) {
        for(int x = 0; x < members; x++) {
            Battle b = null;
            switch (gcs[x].cClass) {
                case WARRIOR -> b = new Battle(gcs[x],opposing.gcs[x]);
                case MAGE -> b = new Battle(gcs[x],opposing.gcs);
                case HEALER -> b = new Battle(gcs[x],gcs);
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

    public void killTeam() {
        for(GameCharacter gc : gcs) {
            gc.health = 0;
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
}
