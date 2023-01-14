package game;
import models.*;

public class Main {


	public static void main(String[] args) throws InterruptedException {
		GameCharacter c1 = new GameCharacter(CharacterClass.HEALER,20);
		GameCharacter c2 = new GameCharacter(CharacterClass.MAGE,1);
		GameCharacter c3 = new GameCharacter(CharacterClass.WARRIOR,1);

		GameCharacter[] t1 = {c1,c2,c3};

		GameCharacter d1 = new GameCharacter(CharacterClass.HEALER,20);
		GameCharacter d2 = new GameCharacter(CharacterClass.MAGE,1);
		GameCharacter d3 = new GameCharacter(CharacterClass.WARRIOR,1);

		GameCharacter[] t2 = {d1,d2,d3};

		Team team1 = new Team(t1, "Karl");
		Team team2 = new Team(t2, "Carlo");

		team1.gotoBattle(team2);
		team2.gotoBattle(team1);
		System.out.println("Battle Started!");

		while (!team1.isDefeated() && !team2.isDefeated()) {
			team1.displayHPs();
			System.out.println();
			team2.displayHPs();
			Thread.sleep(2000);
			System.out.println("----------------\n");
		}

		Team winner = team1.isDefeated() ? team2 : team1;
		winner.hasWon = true;
		System.out.println("Winner: " + winner.name);
	}
}

