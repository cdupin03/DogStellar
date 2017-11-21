package fr.dogstellar;

//import fr.dogstellar.core.Player;
import fr.dogstellar.core.*;
import fr.dogstellar.game.*;

/**
 * @author GP3
 *
 */
public class Main {

	/**
	 * @param args
	 */
	
	public static void main(String[] args) {
//new player
		Player player1 = new Player("toto");
		//player1.displayInfoPerso();
//new planet and areaPlanet		
		Planet planet1 = new Planet("Rouge","planet de feu");
		AreaPlanet area1 = new AreaPlanet("lave", "grosse eruption");
		planet1.addArea(area1);
//new montre		
		Perso monster1 = new Perso("Mechant", 5, 6);
//ajout du monstre1 et du player1 sur la zone area1 de planet1
		area1.addPerso(monster1);
		area1.addPerso(player1);
		//area1.displayPersos();
//Fight	(without armor and weapon)	
		//Fight theFight = new Fight(monster1, player1);
		//theFight.playerFight(2);
		//monster1.displayInfoPerso();
		//theFight.monsterFight(6);
		//player1.displayInfoPerso();
//add armor and add weapon
		Armor bouclier = new Armor("Bouclier", "protection ultra", 10);
		Weapon couteau = new Weapon("Couteau", "super arme", 2);
		player1.addArmorEquip(bouclier);
		player1.addWeaponEquip(couteau);
		player1.displayInfoPerso();
		System.out.println("Nombre de point de l'armure"+bouclier.getArmorPoint());
//Fight	(with armor and weapon)	
		Fight theFight = new Fight(monster1, player1);
		theFight.playerFight(2);
		monster1.displayInfoPerso();
		theFight.monsterFight(6);
		player1.displayInfoPerso();
		System.out.println("Nombre de point de l'armure"+bouclier.getArmorPoint());
//Fight	(with armor and weapon)	
		theFight.playerFight(2);
		monster1.displayInfoPerso();
		theFight.monsterFight(6);
		player1.displayInfoPerso();
		System.out.println("Nombre de point de l'armure"+bouclier.getArmorPoint());
	}

}
