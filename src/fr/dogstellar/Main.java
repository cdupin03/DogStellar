package fr.dogstellar;

import javax.swing.JFrame;

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
// create a new window;
		StartGame start = new StartGame();
// the part of Ship
		QuestElement partOfShip1 = new QuestElement("The part of Ship 1" , "Is the part of Ship 1");
		QuestElement partOfShip2 = new QuestElement("The part of Ship 2" , "Is the part of Ship 2");
		QuestElement partOfShip3 = new QuestElement("The part of Ship 3" , "Is the part of Ship 3");
		QuestElement partOfShip4 = new QuestElement("The part of Ship 4" , "Is the part of Ship 4");
		QuestElement partOfShip5 = new QuestElement("The part of Ship 5" , "Is the part of Ship 5");
// other stuff
		Weapon couteau = new Weapon("Couteau", "super arme", 2);
		Armor bouclier = new Armor("Bouclier", "protection ultra", 10);
		//player1.displayInfoPerso();
		
////new planet and areaPlanet		
//
////new monster		
//		Perso monster1 = new Perso("Mechant", 10, 2);
////ajout du monstre1 et du player1 sur la zone area1 de planet1
//		
//		//area1.displayPersos();
////Fight		
//		//Fight.theFight(monster1, player1, partOfShip1, couteau);
//                
////new chest
//                Element chest_close = new Element("Coffre","Je contient de l'or",false);
//                Element chest_open = new Element("Coffre2","Je ne contient plus or",true);
//		area1.addElement(chest_close);
//                area1.addElement(chest_open);
//                
////display the windows 
//
//                Window wind = new Window("champ.jpg", area1);
	}

}
