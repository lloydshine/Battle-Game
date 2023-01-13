package game;

import models.GameCharacter;

public class Battle extends Thread {
    GameCharacter from,target;
    GameCharacter[] targets;
    public Battle(GameCharacter from, GameCharacter target) {
        this.from = from;
        this.target = target;
    }

    public Battle(GameCharacter from, GameCharacter[] targets) {
        this.from = from;
        this.targets = targets;
    }

    @Override
    public void run() {
        while (!from.isDead()) {
            switch (from.cClass) {
                case HEALER, MAGE -> from.action(targets);
                case WARRIOR -> from.action(target);
            }
            try {
                Thread.sleep(from.speed * 1000L);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);

            }
        }
    }
}
