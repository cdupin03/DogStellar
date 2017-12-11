package fr.dogstellar.view;

import fr.dogstellar.core.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.concurrent.ThreadLocalRandom;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.util.Timer;
import java.util.TimerTask;

/**
 * This class allow the display of element in the screen, a element is a Jbutton
 * represented by a picture
 *
 * @author Group 3
 * @version V02
 */
public final class ElementView extends JButton {

    private final String PicturePath;                                                 // The path of the picture.
    private Element E;                                                          // The element which needs a picture          

    /**
     * The constructor of the ElementViewClass Give a picture to element
     * according to his type, and if it is done or not The enigma type create
     * actionlistener to react when the player click to OK in the interface,
     * then check the response It give the reward if the answer is finded, it
     * dont give it if not The actionlistener is then desactivate The trap have
     * a random picture and random damage in a 0-10 range The PNJ create a pop
     * up The chest give the reward
     *
     * @param picturePath the path of the picture
     * @param newE element which needs a picture
     * @param wind is the window when you make change
     */
    public ElementView(String picturePath, Element newE, Window wind) {
        super();                                                                //call the constructor of the JButton
        PicturePath = picturePath + "";                             			//Define the path of the picture
        E = newE;                                                               //Define the element

        if (E.getType() == 1) 													//If the element is a enigma 
        {
            if (E.getDone() != true) {
                afficher(E.getImage1(),E.getImage2(), 70, 60);

                this.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent evt) {
                        Popup newPopup = new Popup("Enigma :" + E.getInformation().getName());
                        wind.getInterfac().addMessageToConsole(E.getInformation().getName());

                        JButton ok = wind.getInterfac().okButton();

                        ActionListener answerEnigma = new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {

                                boolean resolve = false;

                                String answer = wind.getInterfac().getAreaToWrite().getText().trim().toUpperCase();

                                resolve = E.resolveEnigma(answer, StartGame.getPlayer());
                                //Ajouter un return true dans resolve enigma

                                if (resolve) {
                                    wind.getInterfac().addMessageToConsole("Congratulation ! ");
                                    wind.getInterfac().addMessageToConsole("You win :" + E.getReward().getInformation().getName());
                                    Popup newPopup = new Popup("You have win : " + E.getReward().getInformation().getName() + "!");
                                    ok.removeActionListener(this);
                                    E.setDone(true);
                                    //trial
                                    wind.adjustWindow();

                                } else {
                                    wind.getInterfac().addMessageToConsole("Failed ! come back with the answer");
                                    ok.removeActionListener(this);
                                    E.setDone(true);
                                }
                            }
                        };

                        ok.addActionListener(answerEnigma);

                    }
                });
            } else {

                afficher(E.getImage2(),E.getImage2(), 70, 60);
            }

        } else if (E.getType() == 2) //If the element is a trap
        {
            int randomNum = ThreadLocalRandom.current().nextInt(0, 3);          // initialize random number
            String randompic;
            String randompic2;

            if (randomNum == 0) //enigma display
            {
                randompic = "enigma.png";
                randompic2 = "enigma2.png";
            } else if (randomNum == 1) // pnj display
            {
                randompic = "toad1.jpg";
                randompic2 = "toad2.jpg";
            } else // chest display
            {
                randompic = "Coffre_fermer.jpg";
                randompic2 = "Coffre_selection.jpg";
            }

            afficher(E.getImage1(),E.getImage2(), 70, 60);

            this.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent evt) {
                    int randomNum = ThreadLocalRandom.current().nextInt(0, 3);
                    Popup newPopup = new Popup(E.getInformation().getName() + " :" + E.getInformation().getDescription() + " You lose " + randomNum + " life point ");
                    wind.getInterfac().addMessageToConsole(E.getInformation().getName() + " :" + E.getInformation().getDescription() + " You lose " + randomNum + " life point");
                    E.lostLifePoint(StartGame.getPlayer(), randomNum);
                    StartGame.getInterf().getDisplay().refreshDisplay();
                    if (StartGame.getPlayer().getLifePoint() <= 0) {
                        StartGame.getInterf().getTheWindow().returnToFirstMap();
                        StartGame.getPlayer().setLifePoint(StartGame.getLifePoint());
                        StartGame.getInterf().getDisplay().refreshDisplay();
                    }
                }
            });

        } else if (E.getType() == 3) //If the element is a pnj
        {

            if (E.getDone() == false) {

                afficher(E.getImage1(),E.getImage2(),70, 70);


                this.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent evt) {
                        Popup newPopup = new Popup(E.getInformation().getName() + " :" + E.getInformation().getDescription());
                        wind.getInterfac().addMessageToConsole(E.getInformation().getName() + " :" + E.getInformation().getDescription());
                    }
                });
            } else {

                afficher(E.getImage1(),E.getImage2(), 70, 70);

                //
                this.addActionListener(new ActionListener() {

                    @Override
                    public void actionPerformed(ActionEvent e) {
                        int compt = 0;
                        Timer timer = new Timer();
                        for (Stuff s : StartGame.getPlayer().getStuff()) {
                            if (s.getInformation().getName().equals("PieceShip")) {
                                compt += 1;
                            }
                        }
                        if (compt < 0) {
                            StartGame.getInterf().addMessageToConsole("You have not enouth piece of ship to build your new ship");
                        } else {
                            StartGame.getInterf().addMessageToConsole("Great ! You have all piece of ship, so I can build it");
                            try {
								Thread.sleep(3000);
							} catch (InterruptedException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
                            //StartGame.getInterf().dispose();
                            VideoPlayer end = new VideoPlayer("fin.mp4", 11000, "DogStellar - The end");
                        }
                    }
                });
            }

        } else if (E.getType() == 4) //If the element is a chest
        {
            if (!E.getDone()) {

                afficher(E.getImage1(),E.getImage2(), 70, 70);


                this.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent evt) {
                        E.open_chest(StartGame.getPlayer());
                        E.setDone(true);
                        wind.adjustWindow();

                        Popup newPopup = new Popup("Great ! you have open " + E.getReward().getInformation().getName());
                        wind.getInterfac().addMessageToConsole("The componant of " + E.getReward().getInformation().getName() + " is add to your inventory ! Check it");
                    }
                });

            } else {

                afficher(E.getImage1(),E.getImage2(), 70, 70);

            }
        }
    }

    /**
     * Allow to resized a picture
     *
     * @param largeur width of the resized picture
     * @param hauteur height of the resized picture
     * @param img picture to resized
     * @return img picture resized
     */
    public ImageIcon ConvertImg(int largeur, int hauteur, ImageIcon img) {
        Image image = img.getImage();
        Image newimg = image.getScaledInstance(largeur, hauteur, java.awt.Image.SCALE_SMOOTH);
        img = new ImageIcon(newimg);
        return img;
    }

    /**
     * To display the element
     *
     * @param image is the image
     * @param imageclick is the image when we pass with the mouse
     * @param largeur is the width of the image
     * @param longueur is the eight of the image
     */
    public void afficher(String image, String imageclick, int largeur, int longueur) {
        ImageIcon imageIcon = new ImageIcon(PicturePath + image);
        imageIcon = ConvertImg(largeur, longueur, imageIcon);

        ImageIcon imageIcon2 = new ImageIcon(PicturePath + imageclick);
        imageIcon2 = ConvertImg(largeur, longueur, imageIcon2);

        this.setIcon(imageIcon);
        this.setRolloverIcon(imageIcon2);
        this.setBorder(BorderFactory.createEmptyBorder());
        this.setContentAreaFilled(false);
    }

    /**
     * Disable an element
     */
    @Override
    public void disable() {
        this.setEnabled(false);
    }

    /**
     * get the element of the view.
     * @return E the element of the view.
     */
    public Element getE() {
        return E;
    }
    
    

}
