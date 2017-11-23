package fr.dogstellar.game;
import fr.dogstellar.core.*;

/**
 * This class allows us to play a fight between a monster and a player
 * @author GP3
 * @version 21/11/2017
 *
 */
public class Fight {
	public Perso monster;
	public Player player;
	public Armor armorOfPlayer;
	public Weapon weaponOfPlayer;
	
	/**
	 * Is the constructor of Fight
	 */
	public Fight(Perso monster1, Player player1)
	{
		player = player1;
		monster = monster1;
		if (player.hasArmor()==true)
			armorOfPlayer = player.getArmorEquip();
		if (player.hasWeapon()==true)
			weaponOfPlayer = player.getWeaponEquip();
	}
	
	/**
	 * The player attack with a number of attackPoint
	 * @param attackPoint it is the number of attackPoint that it decided to play
	 */
	public void playerFight(int attackPoint)
	{
		monster.decreaseLifePoint(attackPoint);
	}
	
	/**
	 * The monster attack with a number of attackPoint
	 * @param attackPoint it is the number of attackPoint that it decided to play
	 */
	public void monsterFight(int attackPoint)
	{
		int compt =0;
		if (player.hasArmor()==false) {
				player.decreaseLifePoint(attackPoint);
		} else if (player.hasArmor()==true) {
			if (armorOfPlayer.getArmorPoint()>0) {
					compt = armorOfPlayer.getArmorPoint()-attackPoint;
					if (compt>0) {
						armorOfPlayer.decreaseArmorPoint(attackPoint);
					}else { 
						armorOfPlayer.decreaseArmorPoint(armorOfPlayer.getArmorPoint());
						player.decreaseLifePoint(attackPoint-armorOfPlayer.getArmorPoint());	
					}
			} else {
					player.decreaseLifePoint(attackPoint);
			}
		}
	}
}
