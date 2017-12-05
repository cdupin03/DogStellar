package fr.dogstellar.view;

import fr.dogstellar.core.Planet;
import fr.dogstellar.core.Player;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.util.ArrayList;
import javax.swing.JButton;

import javax.swing.JFrame;

/**
 * This class allows to create the display of the ship
 *
 * @author Group 3
 * @version V02
 */
public class InShip extends GeneralWindow implements ActionListener {

    private ArrayList<Planet> planets;
    private ArrayList<PlanetView> planetViews;
    private JButton test;
    private JButton test2;

    /**
     * The constructor of the class
     *
     * @param interfac = the main interface
     * @param thePlanets = the list of planets
     */
    public InShip(Interface interfac, ArrayList<Planet> thePlanets) {
        super(interfac);
        planets = thePlanets;   //The first planet is the current
        planetViews = new ArrayList<>();
        test = new JButton();
        test2 = new JButton();
        adjustWindow();
    }

    /**
     * This method display a new area in the window.
     */
    @Override
    public String adjustWindow() {
        catchPicture();
        erraseGrid();

        PlanetView pView;
        int x = 1;
        int y = (getHeightGrid() - 1) / 2;
        

        for (int i = 0; i < planets.size(); i++) {
            pView = new PlanetView(getPicturePath(), planets.get(i), (i==0));
            planetViews.add(pView);
            pView.addActionListener(this);
            addComponentToGrid(pView, x, y);
            if (x < (getLengthGrid() - 3)) {
                x = x + 2;
            } else {
                x = 1;
                y++;
            }
        }
        drawGrid();
        return "In the ship";
    }

    /**
     * To catch the picture of the ship
     */
    @Override
    protected void catchPicture() {
        setNameOfFirstBackgroundPicture("InShip.jpg");
        super.catchPicture();
    }

    /**
     * To set enable the arrows of direction
     *
     * @param ena a boolean true if we set the arrows or false to not set them
     */
    @Override
    public void setEnableArrows(boolean ena) {
        System.out.println("Erreur, cette classe n'a pas de fleches");
    }
    
    /**
     * Exchange the place of the planet in the list with the first element.
     * @param IndexP the index planet to exchange with the first of the list.
     */
    private void exchangeListElementWithFirst (int indexP)
    {
        if (indexP != 0)
        {
            Planet planet = planets.get(0);
            planets.set(0, planets.get(indexP));
            planets.set(indexP, planet);
        }
    }
    
    /**
     * Add the action to all planetView. When a planet is clicked, it redirects
     * to it.
     * @param ae The action event
     */
    @Override
    public void actionPerformed(ActionEvent ae) { //Interchanger avant les planetes
        for (int i = 0; i<planetViews.size(); i++)
        {
            if (ae.getSource()==planetViews.get(i))
            {
                exchangeListElementWithFirst(i);
                getInterfac().setWindow(new Window(planets, getInterfac()));
            }
        }
    }
    
    @Override
    public void returnToFirstMap ()
    {
        
    }
}
