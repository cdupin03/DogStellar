package fr.dogstellar;

//import fr.dogstellar.core.Player;
import fr.dogstellar.core.*;
import fr.dogstellar.view.*;
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
// create a new window
	    //Window wind = new Window("Emma.jpeg");
		StartGame start = new StartGame("BackgroundStartGame.jpg");
// the part of Ship
		QuestElement partOfShip1 = new QuestElement("The part of Ship 1" , "Is the part of Ship 1");
		QuestElement partOfShip2 = new QuestElement("The part of Ship 2" , "Is the part of Ship 2");
		QuestElement partOfShip3 = new QuestElement("The part of Ship 3" , "Is the part of Ship 3");
		QuestElement partOfShip4 = new QuestElement("The part of Ship 4" , "Is the part of Ship 4");
		QuestElement partOfShip5 = new QuestElement("The part of Ship 5" , "Is the part of Ship 5");
// other stuff
		Weapon couteau = new Weapon("Couteau", "super arme", 2);
		Armor bouclier = new Armor("Bouclier", "protection ultra", 10);

//new player
		Player player1 = new Player("toto");
		//player1.displayInfoPerso();
//add 2 couteau in the inventory
		player1.addStuff(couteau, 2);
//equip the player with 1 couteau
		player1.addWeaponEquip(couteau);
		
//new planet and areaPlanet		
		Planet planet1 = new Planet("Rouge","planet de feu");
		AreaPlanet area1 = new AreaPlanet("lave", "grosse eruption");
		planet1.addArea(area1);
//new monster		
		Perso monster1 = new Perso("Mechant", 10, 2);
//ajout du monstre1 et du player1 sur la zone area1 de planet1
		area1.addPerso(monster1);
		area1.addPerso(player1);
		//area1.displayPersos();
//Fight		
		Fight.theFight(monster1, player1, partOfShip1, couteau);
		
	}

}
