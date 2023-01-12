package game;

import models.Entity;
import models.Mob;
import models.Player;

public class Battle {
    Player player;
    Mob mob;

    public Battle(Player player, Mob mob) {
        this.player = player;
        this.mob = mob;
        battle();
    }

    public void checkWinner() {
        Entity w = mob;
        if(mob.isDead()) {
            w = player;
            mob.dropXP(player);
        }
        player.display();
        mob.display();
        System.out.printf("%s Won the Battle!\n\n",w.name);
        player.levelUP();
    }

    public void battle() {
        int phase = 1;
        while (!player.isDead() && !mob.isDead()) {
            player.attack(mob);
            mob.attack(player);
        }
        checkWinner();
    }
}
