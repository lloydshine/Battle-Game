package game;

import models.CharacterClass;
import models.GameCharacter;
import models.Team;

public class Battle extends Thread {
    GameCharacter from;
    Team targets,myteam;

    public Battle(GameCharacter from, Team targets, Team myteam) {
        this.from = from;
        this.targets = targets;
        this.myteam = myteam;
    }

    @Override
    public void run() {
        GameCharacter target = targets.gcs[from.POSITION];
        while (!targets.isDefeated()) {
            if(from.isDead()) {
                break;
            }
            if(from.cClass == CharacterClass.WARRIOR) {
                from.action(target);
                if(target.isDead()) {
                    for(GameCharacter gc : targets.gcs) {
                        if(!gc.isDead()) {
                            target = gc;
                            break;
                        }
                    }
                }
            } else {
                if(myteam.hasWon) break;
                from.action(targets.gcs);
            }
            try {
                Thread.sleep(from.speed * 1000L);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
