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

	Player player1 = new Player("Paul");
	
	
	 Weapon stuff1= new Weapon("Excalibur","l'epe de legende",3); 
	 Weapon stuff2= new Weapon("Sword of shadow","l'epe de tenebre",3); 
	 player1.addStuff(stuff1,1);
	 player1.addStuff(stuff2,1);
	 Inventory aInventory = new Inventory(player1);

	}}
