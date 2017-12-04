package fr.dogstellar.view;

import fr.dogstellar.core.Planet;
import java.awt.BorderLayout;
import java.awt.Font;
import javax.swing.JLabel;

/**
 * This class allows to set images for planets in the ship
 *
 * @author Group 3
 * @version V01
 */
public class PlanetView extends PictureButton {
    
    private Planet planet;

    /**
     * The constructor of the PlanetView Class that allows to set an image for
     * planets
     *
     * @param picturePath is the path of pictures
     * @param planet is the planet which needs an image
     * @param actual true if it is the actual planet, else false.
     */
    public PlanetView(String picturePath, Planet thePlanet, boolean actual) {
        super(picturePath, "Planet", ".png"); //Set the path
        planet = thePlanet;
        String planetText = "<html><center><font color = #FF0000 >";
        planetText += planet.getInformation().getName();
        if (actual)
        {
            planetText += "<br/>(Actual)";
        }
        else if (StartGame.getPlayer().getNumberQuestElement() < planet.getNbQuestElement())
        {
            this.setEnabled(false);
            planetText += "<br/>" +
                    StartGame.getPlayer().getNumberQuestElement() +
                    "/" +
                    planet.getNbQuestElement();
        }
        planetText += "</font></center></html>";
        this.add(new JLabel(planetText, CENTER), BorderLayout.CENTER);
    }
    
    /**
     * Get the planet
     * @return the planet
     */
    public Planet getPlanet ()
    {
        return planet;
    }
}
