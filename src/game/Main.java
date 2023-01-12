package game;
import models.*;

import java.util.Scanner;

public class Main {
	static Scanner input = new Scanner(System.in);

	public static void main(String[] args) {
		Player player = new Player("Gusion");


		System.out.println("Welcome Player: " + player.name);
		while (true) {
			System.out.print("Input Dungeon Level (1 - 10) || [0] Exit: ");
			int dungeon_level = input.nextInt();
			if(dungeon_level == 0) {
				break;
			} else {
				int total_xp;
				for(int x = 0; x < 5; x++) {
					System.out.println("Stage: " + (x+1));
					Mob mob = new Mob("Skeleton",dungeon_level);
					Battle battle = new Battle(player,mob);
					if(player.isDead()) {
						player.reset();
						break;
					}
				}
			}

		}

	}
}

