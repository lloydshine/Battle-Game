package models;

public enum CharacterClass
{
    WARRIOR {
        @Override
        public void action(GameCharacter from, GameCharacter target) {
            int crit = (int)(Math.random()*(100-1+1)+1) > 100-from.crit_chance ? from.damage * 2 : 0;
            target.health -= from.damage + crit;

        }
        @Override
        public void applyAttributes(GameCharacter gc) {
            gc.health += 80;
            gc.damage += 20;
            gc.crit_chance += 40;
        }
    },

    MAGE {
        @Override
        public void action(GameCharacter from, GameCharacter[] targets) {
            for (GameCharacter gc : targets) {
                int crit = (int)(Math.random()*(100-1+1)+1) > 100-from.crit_chance ? from.damage * 2 : 0;
                gc.health -= from.damage + crit;
            }

        }
        @Override
        public void applyAttributes(GameCharacter gc) {
            gc.health += 10;
            gc.damage += 50;
            gc.speed += 1;
            gc.crit_chance += 10;
        }
    },

    HEALER {
        @Override
        public void action(GameCharacter from, GameCharacter[] targets) {
            int heal = (from.level / 2) * 10;
            for (GameCharacter gc : targets) {
                if(gc.isDead()) continue;
                int bonus = (int)(Math.random()*(100-1+1)+1) > 100-from.crit_chance ? heal * 2 : 0;
                gc.health += heal + bonus;
            }

        }
        @Override
        public void applyAttributes(GameCharacter gc) {
            gc.health += 100;
            gc.damage = 0;
            gc.speed += 1;
            gc.crit_chance = 10;
        }
    };

    public void action(GameCharacter from, GameCharacter target) {}
    public void action(GameCharacter from, GameCharacter[] targets) {}
    public void applyAttributes(GameCharacter gc){}
}
