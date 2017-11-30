/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.dogstellar.view;
import fr.dogstellar.core.Planet;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JFrame;

/**
 *
 * @author alexandre
 */
public class InShip extends GeneralWindow {
    
    private ArrayList<Planet> planets;

    public InShip(Interface interfac, ArrayList<Planet> thePlanets) {
        super(interfac);
        planets = thePlanets; //The first planet is the current
        adjustWindowToPlanets();
    }
    
    
    	/**
	 * This method display a new area in the window.
	 */
	public void adjustWindowToPlanets()
	{
            catchPicture();
            erraseGrid();
            
            int numberPlanet = planets.size();
            
            PlanetView pView = new PlanetView(getPicturePath(), planets.get(0));
            pView.setEnabled(false);

            
            int x = 1;
            int y = (getHeightGrid()-1)/2;
            addComponentToGrid(pView, x, y);
            
            x = x+2;
            
            for (int i = 1; i<numberPlanet; i++)
            {
                pView = new PlanetView(getPicturePath(), planets.get(i));
                pView.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        getInterfac().setWindow(new Window(planets, getInterfac()));
                    }
                });
                addComponentToGrid(pView, x, y);
                if (x > (getLengthGrid()-3))
                {
                    x = x+2;
                }
                else
                {
                    x =1;
                    y++;
                }
            }
            
            drawGrid();
	}
    
    @Override
    protected void catchPicture ()
    {
        setNameOfFirstBackgroundPicture("InShip.jpg");
        super.catchPicture();
    }
    
    @Override
     public void setEnableArrows (boolean ena)
    {
       System.out.println("Erreur, cette classe n'a pas de fleches"); 
    }
}
