package fr.dogstellar.view;

import fr.dogstellar.core.Planet;

/**
 * This class allows to set images for planets in the ship
 *
 * @author Group 3
 * @version V01
 */
public class PlanetView extends PictureButton {

    /**
     * The constructor of the PlanetView Class that allows to set an image for
     * planets
     *
     * @param picturePath is the path of pictures
     * @param planet is the planet which needs an image
     */
    public PlanetView(String picturePath, Planet planet) {
        super(picturePath, "Planet", ".png");                                   //Set the path
        this.setText(planet.getInformation().getName());                        //Get the planet name
    }
}
