package fr.dogstellar.game;

import java.util.Random;

import fr.dogstellar.core.*;

/**
 * This class allows us to play a fight between a monster and a player
 * @author GP3
 * @version 21/11/2017
 *
 */
public class Fight {
	public static Perso monster;
	public static Player player;
	public static Armor armorOfPlayer;
	public static Weapon weaponOfPlayer;
	
	/**
	 * Is the constructor of Fight
	 */
	private Fight(Perso monster1, Player player1)
	{
		player = player1;
		monster = monster1;
	}
	
	/**
	 * This method allow to play the fight between a monster and a player 
	 * At the beginning of the fight the player can decide to fight or not the monster. If he decide to fight, he begin the fight.
	 * While one of the people (monster or player) is not dead the fight will continued
	 * At the end of the fight the player can win or lost the fight.
	 * If the player win the fight he win a partOfShip and maybe a otherStuff (with 1 chance /2)
	 * If the player lost the game, the lifePoint of the monster is reinitialize.
	 * @param myMonster it is the perso that the player fight
	 * @param myPlayer it is the player of the game that fight the monster
	 * @param partOfShip it is the partOfShip that the player win when he win the fight
	 * @param otherStuff it is the stuff that the player can win when he win the fight and with a probability 1/2
	 */
	public static void theFight(Perso myMonster, Player myPlayer, QuestElement partOfShip, Stuff otherStuff) 
	{
		System.out.println("Ask to the player if he want to accept the fight");
		Random r = new Random();
		//if yes :
			Fight newFight = new Fight(myMonster,myPlayer);
			int pointLifeMonster = myMonster.getLifePoint();//It is the lifePoint of Monster in the beginning the fight
			
			
			while(myMonster.getLifePoint()!=0 && myPlayer.getLifePoint()!=0) {
				System.out.print("player attack");
				myPlayer.playerFight(myMonster, myPlayer.getAttackPoint());
				myMonster.displayInfoPerso();
				myPlayer.displayInfoPerso();
				if (myMonster.getLifePoint()==0) {
					System.out.println(myMonster.getNamePerso() + " is dead ! You are the winner");
					myPlayer.addStuff(partOfShip,1); //The player win a partOfShip when he win
					boolean percent = r.nextBoolean();  //The player can win a otherStuff or not according to a random boolean
					if (percent==true) {
						myPlayer.addStuff(otherStuff, 1);
					}
					break;
				}
				System.out.print("monster attack");
				myMonster.monsterFight(myPlayer, myMonster.getAttackPoint());
				myMonster.displayInfoPerso();
				myPlayer.displayInfoPerso();
				if (myPlayer.getLifePoint()==0) {
					myMonster.setLifePoint(pointLifeMonster); // If the player lost the fight, the monster LifePoint is reinitialized as the beginning of the fight
					System.out.println(myPlayer.getNamePerso() + " is dead ! You are returned in your ship");
					break;
				}
			}
			System.out.println("The invotory of the player");
			myPlayer.displayStuff();
			
			
		//if no : break
	}
}
