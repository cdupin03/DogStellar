package fr.dogstellar.view;

import fr.dogstellar.core.*;
import java.util.*;
import java.awt.*;
import javax.swing.*;


/**
 * This class allows to display the information of the player(name, lifePoint and attackPoint) and also
 * his localization in the game(names of the Planet and the Area)
 * @author G3
 *
 */

public class DisplayInfo extends JPanel{
	
	private JLabel nameP,lifeP,attackP, nPlanet, nArea;
	private JPanel infoPlayer = new JPanel();			//Panel for the information of the player
	private JPanel infoArea = new JPanel();				//Panel for the information of the Area
	
	public DisplayInfo() {
		
		this.setVisible(true); 
		this.setLayout(new BorderLayout());
		this.setOpaque(isOpaque());
		this.setBackground(Color.cyan);
		
		infoPlayer.setPreferredSize(new Dimension(200,200)); 
		this.add(infoPlayer, BorderLayout.WEST);

		nameP = new JLabel("Pseudo : " + StartGame.getPlayer().getNamePerso());
		lifeP = new JLabel("PointLife : "+ StartGame.getPlayer().getLifePoint());
		attackP = new JLabel("AttackPoint : "+ StartGame.getPlayer().getAttackPoint());		
		
		infoPlayer.add(nameP);
		infoPlayer.add(lifeP);
		infoPlayer.add(attackP);
		

	}
	
	public DisplayInfo(ArrayList<Planet> planets, AreaPlanet area) {/*HashMap<String, AreaPlanet>*/
		this.setVisible(true); 
		this.setLayout(new BorderLayout());
		this.setOpaque(isOpaque());
		this.setBackground(Color.cyan);
		
		infoArea.setPreferredSize(new Dimension(200,200)); 
		this.add(infoArea, BorderLayout.CENTER);

		JPanel namePlanet = new JPanel();
		JPanel nameArea = new JPanel();
		
		for(int i=0; i<planets.size(); i++) {
				System.out.println(planets.get(i).getInformation().getName());
	            nPlanet = new JLabel("You are on the Planet : " + planets.get(0).getAreas().getInformation().getName());

		 }
		
		/*System.out.println("Boucle for:");
        for (Map.Entry<String,AreaPlanet> map : area.entrySet()) {
        	System.out.println("cle: "+map.getKey() 
        		+ " | valeur: " + map.getValue());
        	nArea = new JLabel("and on the Area : "+ map.getValue());
       
		
		
        } 
         */	
		
		//nPlanet = new JLabel("You are on the Planet : " + planets.getInformation().getName());
		nArea = new JLabel("and on the Area : "+ area.getNameArea());
		//theDisplayPanel.setLayout(null); 
		//nameP.setBounds(600, 100, 50, 50);
		
		namePlanet.setLayout(new BoxLayout(namePlanet, BoxLayout.LINE_AXIS));
		namePlanet.add(nPlanet);
		nameArea.setLayout(new BoxLayout(nameArea, BoxLayout.LINE_AXIS));
		nameArea.add(nArea);
		
		infoArea.add(nPlanet);
		infoArea.add(nArea);
	}
}
