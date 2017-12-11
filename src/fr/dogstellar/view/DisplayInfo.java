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

	private JLabel namePlayer, nameBarLife, nameBarAttack, nPlanet, nArea, nameWeapon, nameArmor;
	private JProgressBar progressLife = new JProgressBar();
	private JProgressBar progressAttack = new JProgressBar();
	private JProgressBar weaponProgress = new JProgressBar();
	private JProgressBar armorProgress = new JProgressBar();
	private JPanel barLife = new JPanel(); // Panel for the information of the player
	private JPanel barAttack = new JPanel(); // Panel for the information of the player
	private JPanel weaponLife = new JPanel();
	private JPanel armorLife = new JPanel();
	private JPanel bar = new JPanel(); // Panel for the information of the player
	private JPanel infoArea = new JPanel(); // Panel for the information of the Area

	public DisplayInfo() {

		nameBarLife = new JLabel("Life Point      : ");
		nameBarAttack = new JLabel("Attack Point : ");

		displayLife();
		displayAttack();

		nameWeapon = new JLabel("Weapon Point : ");
		weaponLife.setLayout(new BorderLayout());
		weaponLife.add(nameWeapon, BorderLayout.WEST);
		weaponLife.add(weaponProgress, BorderLayout.CENTER);
		weaponLife.setVisible(false);

		if (StartGame.getPlayer().hasWeapon() == true) {
			displayWeapon();
		}

		nameArmor = new JLabel("Armor Life    : ");
		armorLife.setLayout(new BorderLayout());
		armorLife.add(nameArmor, BorderLayout.WEST);
		armorLife.add(armorProgress, BorderLayout.CENTER);
		armorLife.setVisible(false);

		if (StartGame.getPlayer().hasArmor() == true) {
			displayArmor();
		}

		barLife.setLayout(new BorderLayout());
		barLife.add(nameBarLife, BorderLayout.WEST);
		barLife.add(progressLife, BorderLayout.CENTER);
		barLife.add(armorLife, BorderLayout.SOUTH); 

		barAttack.setLayout(new BorderLayout());
		barAttack.add(nameBarAttack, BorderLayout.WEST);
		barAttack.add(progressAttack, BorderLayout.CENTER);
		barAttack.add(weaponLife, BorderLayout.SOUTH);

		bar.setLayout(new GridLayout(2,1));
		bar.setBackground(Color.cyan);
		bar.add(barLife, BorderLayout.NORTH);
		bar.add(barAttack, BorderLayout.SOUTH);

		this.setLayout(new BorderLayout());
		this.add(bar, BorderLayout.CENTER);
	}

	public DisplayInfo(ArrayList<Planet> planets, AreaPlanet area) {/* HashMap<String, AreaPlanet> */
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

		/*
		 * System.out.println("Boucle for:"); for (Map.Entry<String,AreaPlanet> map :
		 * area.entrySet()) { System.out.println("cle: "+map.getKey() + " | valeur: " +
		 * map.getValue()); nArea = new JLabel("and on the Area : "+ map.getValue());
		 * 
		 * 
		 * 
		 * }
		 */
		// nPlanet = new JLabel("You are on the Planet : " +
		// planets.getInformation().getName());
		nArea = new JLabel("and on the Area : " + area.getNameArea());
		// theDisplayPanel.setLayout(null);
		// nameP.setBounds(600, 100, 50, 50);

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
	}

	/**
	 * The display of the attack bar
	 */
	public void displayAttack() {
		int tmp = StartGame.getPlayer().getAttackPoint() * 10;
		progressAttack.setValue(tmp);
		progressAttack.setStringPainted(true);
	}
	
	/**
	 * The display of the weapon bar. He is present only if the player is equipped with a weapon.
	 */
	public void displayWeapon() {
		int tmp = StartGame.getPlayer().getWeaponEquip().getDamage() * 10;
		System.out.println("Weapon" + tmp);
		weaponProgress.setValue(tmp);
		weaponProgress.setStringPainted(true);
	}
	
	/**
	 * The display of the armor bar. He is present only if the player is equipped with a armor.
	 */
	public void displayArmor() {
		int tmp = StartGame.getPlayer().getArmorEquip().getArmorPoint() * 10;
		armorProgress.setValue(tmp);
		armorProgress.setStringPainted(true);
	}
	
	/**
	 * To refresh the bar display
	 */
	public void refreshDisplay() {
		progressLife.setStringPainted(false);
		displayLife();
		progressAttack.setStringPainted(false);
		displayAttack();
		if (StartGame.getPlayer().hasWeapon() == true) {
			System.out.println("coucou Pauline");
			weaponProgress.setStringPainted(false);
			displayWeapon();
		} else {
			weaponLife.setVisible(false);
		}
		if (StartGame.getPlayer().hasArmor() == true) {
			armorLife.setVisible(true);
			armorProgress.setStringPainted(false);
			displayArmor();
		} else {
			armorLife.setVisible(false);
		}
	}

}
