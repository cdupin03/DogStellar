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
public final class DisplayInfo extends JPanel {

    private JLabel namePlayer, nameBarLife, nameBarAttack, nPlanet, nArea;
    private final JProgressBar progressLife = new JProgressBar();
    private final JProgressBar progressAttack = new JProgressBar();
    private final JPanel barLife = new JPanel();								//Panel for the information of the player
    private final JPanel barAttack = new JPanel();                                                            //Panel for the information of the player
    private final JPanel bar = new JPanel();									//Panel for the information of the player
    private final JPanel infoArea = new JPanel();								//Panel for the information of the Area

    public DisplayInfo() {

        namePlayer = new JLabel("Name : " + StartGame.getPlayer().getNamePerso());
        nameBarLife = new JLabel("Life Point      : ");
        nameBarAttack = new JLabel("Attack Point : ");

        displayLife();
        displayAttack();

        barLife.setLayout(new BorderLayout());
        barLife.add(nameBarLife, BorderLayout.WEST);
        barLife.add(progressLife, BorderLayout.CENTER);

        barAttack.setLayout(new BorderLayout());
        barAttack.add(nameBarAttack, BorderLayout.WEST);
        barAttack.add(progressAttack, BorderLayout.CENTER);

        bar.setLayout(new BorderLayout());
        bar.add(barLife, BorderLayout.NORTH);
        bar.add(barAttack, BorderLayout.SOUTH);

        this.setLayout(new BorderLayout());
        this.add(namePlayer, BorderLayout.CENTER);
        this.add(bar, BorderLayout.SOUTH);
    }

    public DisplayInfo(ArrayList<Planet> planets, AreaPlanet area) {/*HashMap<String, AreaPlanet>*/
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

        /*System.out.println("Boucle for:");
        for (Map.Entry<String,AreaPlanet> map : area.entrySet()) {
        	System.out.println("cle: "+map.getKey() 
        		+ " | valeur: " + map.getValue());
        	nArea = new JLabel("and on the Area : "+ map.getValue());
       
		
		
        } 
         */
        //nPlanet = new JLabel("You are on the Planet : " + planets.getInformation().getName());
        nArea = new JLabel("and on the Area : " + area.getNameArea());
        //theDisplayPanel.setLayout(null); 
        //nameP.setBounds(600, 100, 50, 50);

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
     * To refresh the bar display
     */
    public void refreshDisplay() {
        progressLife.setStringPainted(false);
        displayLife();
        progressAttack.setStringPainted(false);
        displayAttack();
    }

}
