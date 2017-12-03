/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.dogstellar.view;

import fr.dogstellar.core.Planet;

/**
 *
 * @author alexandre
 */
public class PlanetView extends PictureButton{
    public PlanetView(String picturePath, Planet planet)
    {
        super(picturePath, "Planet", ".png");
        this.setText(planet.getInformation().getName());
    }
}
