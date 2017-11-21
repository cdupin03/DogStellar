package fr.dogstellar;

//import fr.dogstellar.core.Player;
import fr.dogstellar.core.*;

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
		player1.displayInfoPerso();
//new planet and areaPlanet		
		Planet planet1 = new Planet("Rouge","planet de feu");
		AreaPlanet area1 = new AreaPlanet("lave", "grosse eruption");
		planet1.addArea(area1);
//new montre		
		Perso monstre1 = new Perso("Mechant", 5, 6);
//ajout du monstre1 et du player1 sur la zone area1 de planet1
		
//Combat
		
		
		
	}

}
