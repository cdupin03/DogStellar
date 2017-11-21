package game;
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
		monster.decreaseLifePoint(1);
	}
	
	/**
	 * The monster attack with a number of attackPoint
	 * @param attackPoint it is the number of attackPoint that it decided to play
	 */
	public void monsterFight(int attackPoint)
	{
		if (player.hasArmor()==false) {
				player.decreaseLifePoint(attackPoint);
		} else if (player.hasArmor()==true) {
			if (armorOfPlayer.getArmorPoint()>0)
					armorOfPlayer.decreaseArmorPoint(attackPoint);
			else {
					player.decreaseLifePoint(attackPoint);
			}
		}
	}
}
