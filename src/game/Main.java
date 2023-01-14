package game;
import models.*;

public class Main {


	public static void main(String[] args) throws InterruptedException {
		GameCharacter c1 = new GameCharacter(CharacterClass.WARRIOR,2);
		GameCharacter c2 = new GameCharacter(CharacterClass.MAGE,1);
		GameCharacter c3 = new GameCharacter(CharacterClass.WARRIOR,1);

		GameCharacter[] t1 = {c1,c2,c3};

		GameCharacter d1 = new GameCharacter(CharacterClass.WARRIOR,2);
		GameCharacter d2 = new GameCharacter(CharacterClass.MAGE,1);
		GameCharacter d3 = new GameCharacter(CharacterClass.WARRIOR,1);

		GameCharacter[] t2 = {d1,d2,d3};

		Team team1 = new Team(t1, "ECHO");
		Team team2 = new Team(t2, "BLACKLIST");

		team1.gotoBattle(team2);
		team2.gotoBattle(team1);

		System.out.println(team1.name + " VS " + team2.name);
		System.out.println("Battle Started!\nBattle Under Going......");

		long start = System.currentTimeMillis();
		while (!team1.isDefeated() && !team2.isDefeated()) {
			Thread.sleep(60);
		}
		long end = System.currentTimeMillis();

		System.out.println();
		team1.displayHPs();
		System.out.println("\nVS\n");
		team2.displayHPs();
		Team winner = team1.isDefeated() ? team2 : team1;
		winner.hasWon = true;
		float sec = (end - start) / 1000F; System.out.println("\nBattle Time: " + sec + " seconds");
		System.out.println("Winner: " + winner.name);
	}
}

