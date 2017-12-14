package fr.dogstellar.view;

import fr.dogstellar.core.*;
import java.util.*;
import java.awt.*;
import javax.swing.*;

/**
 * This class allows to display the information of the player(name, lifePoint
 * and attackPoint) and also his localization in the game(names of the Planet
 * and the Area)
 *
 * @author G3
 *
 */
public class DisplayInfo extends JPanel {

	private JLabel namePlayer, nameBarLife, nameBarAttack, nameBarArmor, nPlanet, nArea, nameWeapon, nameArmor;
	private JProgressBar progressLife;//the bar of life
        private JLabel armor ;//the armor point to display
        private JLabel damage ;//the damage point to display
        
	private JPanel barLife = new JPanel(); // Panel for the information of the player
	private JPanel barAttack = new JPanel(); // Panel for the information of the player
	private JPanel weaponLife = new JPanel(); //the life of the weapon
	private JPanel armorLife = new JPanel(); //the armor life
	private JPanel bar = new JPanel(); // Panel for the information of the player
	private JPanel infoArea = new JPanel(); // Panel for the information of the Area
        private JPanel namearmorattack = new JPanel(); 
        private JPanel armorattack = new JPanel();
        
	/**
         * Display the bars in the botton of the interface.
         */
        public DisplayInfo() {
                final int  maxlifepoint =  StartGame.getLifePoint()*10;    
                
                
		nameBarLife = new JLabel("Life Point      : ");
		nameBarAttack = new JLabel("Attack Point : ");
                nameBarArmor = new JLabel("Armor Point  : ");
                
                progressLife= new JProgressBar (0,maxlifepoint);
                progressLife.setForeground(Color.red);
               
              
                displayLife();
		


		if (StartGame.getPlayer().hasWeapon() == true) {
                    int Damageweapon = StartGame.getPlayer().getWeaponEquip().getDamage();
                    int Damageplayer = StartGame.getPlayer().getAttackPoint();
                    int FinalDamage = Damageweapon + Damageplayer;
                    damage = new JLabel(" "+ FinalDamage);
                
		}
                else
                {   
                    damage = new JLabel(" "+ StartGame.getPlayer().getAttackPoint());
                }   
                
		    nameArmor = new JLabel("Armor Life    : ");
                    armorLife.setLayout(new BorderLayout());
                    armorLife.add(nameArmor, BorderLayout.WEST);
                    armorLife.setVisible(false);
                    
                
		if (StartGame.getPlayer().hasArmor() == true) {
                   
                    
                    
                    final int trial = StartGame.getPlayer().getArmorEquip().getArmorPoint() * 10;
                    displayArmor();
                    armor = new JLabel(" "+StartGame.getPlayer().getArmorEquip().getArmorPoint());
                
		}
                else
                {
                    armor = new JLabel(" 0");
                
                
                }    
                
                namearmorattack.setLayout(new GridLayout(2,0));
                namearmorattack.add(nameBarAttack);
                namearmorattack.add(nameBarArmor);
                
                armorattack.setLayout(new GridLayout(2,0));
                armorattack.add(damage);
                armorattack.add(armor);
                
                
		barLife.setLayout(new BorderLayout());
		barLife.add(nameBarLife, BorderLayout.WEST);
		barLife.add(progressLife, BorderLayout.CENTER);
		//barLife.add(armorLife, BorderLayout.SOUTH); 

		barAttack.setLayout(new BorderLayout());
		barAttack.add(namearmorattack, BorderLayout.WEST);
                barAttack.add(armorattack, BorderLayout.CENTER);
	//	barAttack.add(progressAttack, BorderLayout.CENTER);
	//	barAttack.add(weaponLife, BorderLayout.SOUTH);

		bar.setLayout(new GridLayout(2,1));
		bar.setBackground(Color.cyan);
		bar.add(barLife, BorderLayout.NORTH);
		bar.add(barAttack, BorderLayout.SOUTH);

		this.setLayout(new BorderLayout());
		this.add(bar, BorderLayout.CENTER);
	}
        
        /**
         * Display the bars in the botton of the interface.
         */
	public DisplayInfo(ArrayList<Planet> planets, AreaPlanet area) {
		this.setVisible(true);
		this.setLayout(new BorderLayout());
		this.setOpaque(isOpaque());
		this.setBackground(Color.cyan);

		infoArea.setPreferredSize(new Dimension(200, 200));
		this.add(infoArea, BorderLayout.CENTER);

		JPanel namePlanet = new JPanel();
		JPanel nameArea = new JPanel();

		for (int i = 0; i < planets.size(); i++) {
			System.out.println(planets.get(i).getInformation().getName());
			nPlanet = new JLabel("You are on the Planet : " + planets.get(0).getAreas().getInformation().getName());

		}
		nArea = new JLabel("and on the Area : " + area.getNameArea());

		namePlanet.setLayout(new BoxLayout(namePlanet, BoxLayout.LINE_AXIS));
		namePlanet.add(nPlanet);
		nameArea.setLayout(new BoxLayout(nameArea, BoxLayout.LINE_AXIS));
		nameArea.add(nArea);

		infoArea.add(nPlanet);
		infoArea.add(nArea);
	}

	/**
	 * The display of the life bar
	 */
	public void displayLife() {
		int tmp = StartGame.getPlayer().getLifePoint() * 10;
		progressLife.setSize(new Dimension(10, 50));
		progressLife.setValue(tmp);
		progressLife.setStringPainted(true);
                progressLife.setString(""+tmp/10);
	}

	/**
	 * The display of the attackPoint
	 */
	public void displayAttack() {
		
               if (StartGame.getPlayer().hasWeapon() == true) {
                    int Damageweapon = StartGame.getPlayer().getWeaponEquip().getDamage();
                    int Damageplayer = StartGame.getPlayer().getAttackPoint();
                    int FinalDamage = Damageweapon + Damageplayer;
                    damage.setText(" "+ FinalDamage);
                
		}
                else
                {   
                    damage.setText(" "+ StartGame.getPlayer().getAttackPoint());
                }   
	}
	

        /**
         * Display of the armorPoint
         */
	public void displayArmor() {
		if (StartGame.getPlayer().hasArmor() == true) {
                   
                    
                    
                    final int trial = StartGame.getPlayer().getArmorEquip().getArmorPoint() * 10;
                    armor.setText(" "+StartGame.getPlayer().getArmorEquip().getArmorPoint());
                
		}
                else
                {
                    armor.setText(" 0");
                
                
                }  
	}
	
	/**
	 * To refresh the bar display
	 */
	public void refreshDisplay() {
		progressLife.setStringPainted(false);
		displayLife();
		displayAttack();
                displayArmor();
                
		
	}

}
