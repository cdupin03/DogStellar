package fr.dogstellar.view;

import fr.dogstellar.core.AreaPlanet;
import fr.dogstellar.core.Armor;
import fr.dogstellar.core.Element;
import fr.dogstellar.core.Perso;
import fr.dogstellar.core.Planet;
import fr.dogstellar.core.Potion;
import fr.dogstellar.core.QuestElement;
import fr.dogstellar.core.Weapon;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.text.DefaultCaret;

import org.w3c.dom.NamedNodeMap;

import javax.swing.ImageIcon;

/**
 * The Class Interface is the main Interface of the game, it allows to interract
 * with a specific area, with the inventory, and also with the console
 *
 * @author G3
 * @version V05
 */
public class Interface {

    private final JFrame theInterface = new JFrame();           //The main frame of the interface
    private final JPanel console = new JPanel();                //The main panel for the console
    private final JPanel top = new JPanel();                    //The top part of the interface that contain the display of area
    private final JPanel bottom = new JPanel();                 //The bottom part of the interface that contain the global informations, inventory, attack button, and the console
    private final JPanel displayP = new JPanel();				//Contains the information of the player(inventory + personal information)
    private final JPanel displayA = new JPanel();				//Contains the information about the localization of the player(names of the planet and the area)
    private final JButton ok = new JButton();                   //The button to validate an entry in the console
    private final JPanel display = new JPanel();                //The panel in the console that contain the JTextArea displayMessage
    private final JPanel write = new JPanel();                  //The panel in the console that contain the JTextField to write answer and the button of validation
    private final JPanel bar = new JPanel();					//It is the panel with 2 progressbar (1 for life and 1 for attack Point)
    private final JTextArea displayMessage = new JTextArea();   //The area to display message
    private JTextField areaToWrite = new JTextField();          //The area to write answer
    private String answer;                                      //The last answer that is write
    private final JPanel subP;                                  // A subPanel containing the inventory and returnship button
    private final JButton inventory;                            //Button which allow to open the inventory
    private final JButton returnMap;                           //Button wich allow to return to the first map 

    private final Perso monstre1 = new Perso("FriendlyNeighbor", 10, 3, new QuestElement("PieceShip", "that same piece"), new Potion("Potion Powerfull", "sgfhrhsgsd", 2),"monster/larva");
    private final Perso monstre2 = new Perso("Monstre2", 10, 2, new QuestElement("PieceShip", "that other same piece"), new Potion("Potion Powerfull", "sgfhrhsgsd", 6),"monster/larva");
    private final Perso monstre3 = new Perso("Monstre3", 10, 2, new QuestElement("PieceShip", "that other same piece"), new Potion("Potion Powerfull", "sgfhrhsgsd", 6),"Monster");

    private GeneralWindow theWindow, theShip;

    private final DisplayInfo infoPlayer; 					//It is the information of the player that is display thanks to displayInfo
    private DisplayInfo infoArea; 							//It is the information of the player that is display thanks to displayInfo
    private final JPanel displayInfo = new JPanel();					//it is the JPanel with the info of the player
    private final JPanel imagePlayer = new JPanel();;
    private final JLabel imageP, nameP;										//Is the image of the player that is select in the startGame
    
    /**
     * The constructor of the class Interface
     */
    public Interface() {
//Console
        areaToWrite.setPreferredSize(new Dimension(340, 30));        //Set the size of the area to write
        areaToWrite.setFont(new Font(Font.SERIF, Font.PLAIN, 18));   //Font of the area to write

        ok.setText("OK");                                           //Set the button text
        ok.setForeground(Color.black);                              //Set the color of the button
        ok.setSize(50, 30);                                          //Set the size of the button
        ok.setFont(new java.awt.Font(Font.SERIF, Font.BOLD, 16));     //Set the font of the button
        ok.setEnabled(false);                                       //Disable the button

        write.setLayout(new BorderLayout());                        //The layout of the write pannel
        write.add(areaToWrite, BorderLayout.WEST);                  //Add the areaToWrite in the write pannel
        write.add(ok, BorderLayout.EAST);                           //Add the validation button in the write pannel

        displayMessage.setLineWrap(true);                           //When a sentence is too long, the sentence is cut and there is a new line that is created
        displayMessage.setEditable(false);                          //Do not allow to write text directly in the JTextArea

        //Declaration and instantiation of the container JScrollPane named scrollMessage that allows to scroll in the display area
        JScrollPane scrollMessage = new JScrollPane(displayMessage, ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        scrollMessage.setPreferredSize(new Dimension(380, 150));                //Set the size of the container scrollMessage

        DefaultCaret caret = (DefaultCaret) displayMessage.getCaret();          //This element allows to make the scroll when we want
        caret.setUpdatePolicy(DefaultCaret.ALWAYS_UPDATE);                      //The scroll is always on bottom

        display.add(scrollMessage);                                             //Add the container scrollMessage to the display panel

        console.setPreferredSize(new Dimension(400, 200));                      //Set the size of the global console
        console.setLayout(new BorderLayout());                                  //Set the layout of the console
        console.add(display, BorderLayout.CENTER);                              //Add the panel display in the console
        console.add(write, BorderLayout.SOUTH);                                 //Add the panel write in the console

//Inventory
        String picturePath = System.getProperty("user.dir") + "/pictures/";     //variable containing the path for the inventory image
        ImageIcon picture = new ImageIcon(picturePath + "inventory.png");       //image for the inventory button
        inventory = new JButton(picture);                                       // create the button
        // add the button to the inventory
        inventory.setToolTipText("click here to acess to you inventory");       // set a description text
        // transparent inventory
        inventory.setOpaque(false);
        inventory.setContentAreaFilled(false);
        inventory.setBorderPainted(false);

        //ActionListenener for generate the inventory frame in one click
        inventory.addActionListener(new ActionListener() {
            InventoryPanel ip;

            @Override
            public void actionPerformed(ActionEvent e) {
                if (ip == null) {
                    ip = new InventoryPanel(StartGame.getPlayer());
                    ip.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                    ip.addWindowListener(new WindowAdapter() {
                        @Override
                        public void windowClosed(java.awt.event.WindowEvent e) {
                            ip = null; // comme ça on peut réouvrir la fenêtre si elle est fermée
                        }
                    ;
                    });
					ip.setVisible(true);
                } else {
                    // remettre la fenêtre en état normal si elle a été réduite
                    if (ip.getState() == JFrame.ICONIFIED) {
                        ip.setState(JFrame.NORMAL);
                    }
                    // remettre la fenêtre en premier plan
                    ip.toFront();
                }
            }
        });
        //return to the ship 
        ImageIcon ship = new ImageIcon(picturePath + "map.png");

        returnMap = new JButton(ship);
        returnMap.setToolTipText("Click here to return to the first map of the planet");
        returnMap.setOpaque(false);
        returnMap.setContentAreaFilled(false);
        returnMap.setBorderPainted(false);

        returnMap.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                theWindow.returnToFirstMap();
            }
        });
        subP = new JPanel();
        subP.setLayout(new BorderLayout());
        subP.add(returnMap, BorderLayout.WEST);
        subP.add(inventory, BorderLayout.EAST);

//info Player (image, namePlayer, barLife and barAttack, inventory)
        infoPlayer = new DisplayInfo();								//The displayInfo with the name, barLife and barAttack
        
        
        nameP = new JLabel(StartGame.getPlayer().getNamePerso(), JLabel.CENTER);
        nameP.setFont(new Font("Arial", Font.PLAIN, 20));
        imageP = new JLabel(StartGame.getImagePlayer());			//image of the player (choose in the startGame)

        imagePlayer.setLayout(new BorderLayout());
        imagePlayer.add(imageP, BorderLayout.CENTER);
        imagePlayer.add(nameP, BorderLayout.NORTH);
        
        displayP.setLayout(new BorderLayout());						//JPanel imageP, infoPlayer, inventory
        displayP.add(imagePlayer, BorderLayout.WEST);
        displayP.add(infoPlayer, BorderLayout.CENTER);
        displayP.add(subP, BorderLayout.EAST);
        displayInfo.setLayout(new BorderLayout());					//Set the layout of the displayInfo part
        displayInfo.add(displayP, BorderLayout.CENTER);				//Add the information of the player in the displayInfo Panel
        //displayInfo.add(displayA, BorderLayout.CENTER);			   // Add the information of the area in the displayInfo Panel

        bottom.setLayout(new BorderLayout());                       //Set the layout of the bottom part
        bottom.add(console, BorderLayout.EAST);                     //Add the console to the right part of the bottom
        bottom.add(displayInfo, BorderLayout.CENTER);				//Add the info of the player

        //JLabel test = new JLabel();
        //test.setText(theWindow.getCurrentArea());
        displayA.setLayout(new BorderLayout());
        //displayA.add(infoArea, BorderLayout.CENTER);
        //displayA.add(test);

        /*
 *  *****   *  *   *****      ** **   *****   *****                                          
 *    *     ****   **         * * *   *****   *****                                                       
 *    *     *  *   *****      *   *   *   *   *                                     
         */
        Planet planet1 = new Planet("Planet1", "Etrange", 0);
        Planet planet2 = new Planet("Sand Planet ", "Planet filled with sand", 0);
        Planet planet3 = new Planet("Planet3", "Tout aussi etrange", 0);
        Planet planet4 = new Planet("Space", "Always in weightlessness", 0);

        ArrayList<Planet> planets = new ArrayList<Planet>(); //The list of planets the first planet is the actual planet.
        //If we change planet, the new planet exchange its place with the first.
        planets.add(planet1);
        planets.add(planet2);
        planets.add(planet3);
        planets.add(planet4);

        //Planet 1 with 3 areas and different elements(perso,element) on them
        //AreaPlanet Area0Planet1 = new AreaPlanet("Ship", "your ship", "");

        AreaPlanet Area1Planet1 = new AreaPlanet("Area1", "first area", "map/map1.png");
//my friend
        Area1Planet1.addElement(new Element("PNJ", 
                " Hey my friend ! Do you remember me? I found you almost dead but you're better now. I hope you got your bag",
                 3,
                "toad1.jpg",
                "toad2.jpg",
                 1,
                 2));
//my bag

        Armor armor1 = new Armor("Aurora", "More beautiful than effective", 1);

        Area1Planet1.addElement(new Element("Bag",
                "with your armor",
                4,
                armor1,
                "sacados.png",
                "sacados.png",
                3,
                4));
        AreaPlanet Area2Planet1 = new AreaPlanet("Area2", "second area", "map/map3.png");
//my friend present his neighbor
        Area2Planet1.addElement(new Element("PNJ",
                "My neighbor does not like to be disturbed ... but he may have recovered a piece of your ship",
                3,
                "toad1.jpg",
                "toad2.jpg",
                1,
                2));
        Area2Planet1.addPerso(monstre1);

        AreaPlanet Area3Planet1 = new AreaPlanet("Area3", "third area", "map/map2.png");
        Area3Planet1.addElement(new Element("PNJ", "Thanks, my neighbor has gone away now", 3,"toad1.jpg", "toad2.jpg", 1, 2));
        Weapon weapon1 = new Weapon("Walpurga", "Weak laser ", 1);
        Area3Planet1.addElement(new Element("Everything is in nothing... What is it?", "universe",
                1, weapon1, "enigma.png", "enigma2.png", 3, 1));      
        
        Area1Planet1.addAreaPlanet(Area2Planet1, "south");
        Area2Planet1.addAreaPlanet(Area3Planet1, "east");
        planet1.addArea(Area1Planet1);

        //Planet 2 with 2 areas and different elements(perso,element) on them
        AreaPlanet Area1Planet2 = new AreaPlanet("Area1", "first area", "map/map10.png");
//his neighbor is alive but your friend propose to you an enigma to have a his weapon
        Weapon weapon2 = new Weapon("Wilhelmina", "weapon of your friend", 3);
        //console.addMessageToConsole("Oh no, you remember of him ? it is my neighbor, you don't really kill him, maybe he has find other piece of ship");
        Area1Planet2.addElement(new Element(" I will give you my weapon but before answer to my enigma : I can be white, yellow, red, blue even black. Who  I  am?",
                "star", 1, weapon2, "toad1.jpg",
                "toad2.jpg", 3, 1));
        Area1Planet2.addPerso(monstre2);

        AreaPlanet Area2Planet2 = new AreaPlanet("Area2", "second area", "map/map11.png");
        Area2Planet2.addElement(new Element("Trap", " I am a clone of your friend ! Sorry ", 2, "toad1.jpg", "toad2.jpg", 4, 5));

        AreaPlanet Area3Planet2 = new AreaPlanet("Area3", "hum ...", "map/map8.png");

        AreaPlanet Area4Planet2 = new AreaPlanet("Area4", "hum ...", "map/map12.png");
        AreaPlanet Area5Planet2 = new AreaPlanet("Area5", "hum ...", "map/map7.png");
        AreaPlanet Area6Planet2 = new AreaPlanet("Area6", "hum ...", "map/map9.png");

        Area1Planet2.addAreaPlanet(Area2Planet2, "east");
        Area2Planet2.addAreaPlanet(Area3Planet2, "south");
        Area3Planet2.addAreaPlanet(Area4Planet2, "east");
        Area4Planet2.addAreaPlanet(Area5Planet2, "east");
        Area1Planet2.addAreaPlanet(Area6Planet2, "west");

        planet3.addArea(Area1Planet2);

        //Planet3 with 3 areas
        AreaPlanet Area1Planet3 = new AreaPlanet("Area1", "rdytfuygiut", "map/map6.png");
        //Area1Planet3.addPerso(monstre1);
        //Area1Planet3.addElement(new Element("Coffre", "Petit coffre", 1));
        //Area1Planet3.addElement(new Element("Enigme", "Une enigme", 4));

        AreaPlanet Area2Planet3 = new AreaPlanet("Area2", "rdytfiut", "map/map4.png");
        //Area2Planet3.addPerso(monstre2);
        //Area2Planet3.addElement(new Element("Trap", "Un piege déguisé", 2));
        //Area2Planet3.addElement(new Element("PNJ", "Un pnj champu", 3));

        AreaPlanet Area3Planet3 = new AreaPlanet("Area3", "hum ...", "map/map5.png");
        //Area3Planet3.addPerso(monstre2);
        //Area3Planet3.addElement(new Element("Trap", "Un piege déguisé", 2));
        //Area3Planet3.addElement(new Element("PNJ", "Un pnj champu", 3));

        Area1Planet3.addAreaPlanet(Area2Planet3, "north");
        Area2Planet3.addAreaPlanet(Area3Planet3, "west");
        //Area1Planet2.addAreaPlanet(Area4Planet2, "south");
        //Area4Planet2.addAreaPlanet(Area5Planet2, "west");

        planet2.addArea(Area1Planet3);

        //Planet 4 with 6 areas and different elements(perso,element) on them
        AreaPlanet Area1Planet4 = new AreaPlanet("Area1", "rdytfuygiut", "map/map16.png");
        //Area1Planet4.addPerso(monstre1);
        //Area1Planet4.addElement(new Element("Coffre", "Petit coffre", 1));
        //Area1Planet4.addElement(new Element("Enigme", "Une enigme", 4));

        AreaPlanet Area2Planet4 = new AreaPlanet("Area2", "rdytfiut", "map/map17.png");
        //Area2Planet4.addPerso(monstre2);
        //Area2Planet4.addElement(new Element("Trap", "Un piege déguisé", 2));
        //Area2Planet4.addElement(new Element("PNJ", "Un pnj champu", 3));

        AreaPlanet Area3Planet4 = new AreaPlanet("Area3", "hum ...", "map/map18.png");
        //Area3Planet4.addPerso(monstre2);
        //Area3Planet4.addElement(new Element("Trap", "Un piege déguisé", 2));
        //Area3Planet4.addElement(new Element("PNJ", "Un pnj champu", 3));

        AreaPlanet Area4Planet4 = new AreaPlanet("Area3", "hum ...", "map/map15.png");
        AreaPlanet Area5Planet4 = new AreaPlanet("Area3", "hum ...", "map/map13.png");
        AreaPlanet Area6Planet4 = new AreaPlanet("Area3", "hum ...", "map/map14.png");
        AreaPlanet Area7Planet4 = new AreaPlanet("Area3", "hum ...", "endGame.png");
        
        Area1Planet4.addAreaPlanet(Area2Planet4, "east");
        Area2Planet4.addAreaPlanet(Area3Planet4, "south");
        Area1Planet4.addAreaPlanet(Area4Planet4, "west");
        Area4Planet4.addAreaPlanet(Area5Planet4, "west");
        Area5Planet4.addAreaPlanet(Area6Planet4, "south");
        Area6Planet4.addAreaPlanet(Area7Planet4, "south");
        
        Element toad_spaceship = (new Element("PNJ", "", 3, "toad1.jpg", "toad2.jpg", 2, 2));
        toad_spaceship.setDone(true);
        
        Area7Planet4.addElement(toad_spaceship);
        
        
        planet4.addArea(Area1Planet4);

        theWindow = new Window(planets, this);

        //theWindow = new InShip(this, planets);
        top.setLayout(new BorderLayout());                              //Set the layout of the top part       
        top.add(theWindow, BorderLayout.CENTER);                        //Add the area map in the top part

//theInterface        
        theInterface.setBackground(Color.BLACK);
        theInterface.setPreferredSize(new Dimension(1200, 700));        //Set the size of the frame
        theInterface.setLayout(new BorderLayout());                     //Set the display of the frame
        theInterface.add(top, BorderLayout.CENTER);                     //Add the top part in the frame
        theInterface.add(bottom, BorderLayout.SOUTH);                   //Add the bottom part in the frame
        theInterface.setResizable(false);                               //This JFrame is not resizable
        theInterface.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);    //Closing the frame close the application
        theInterface.pack();                                            //Sizes the frame so that all its contents are at or above their preferred sizes
        theInterface.setLocationRelativeTo(null);                       //The JFrame is on the screen center
        theInterface.setVisible(true);                                  //To display the frame

//The actions of the button "OK" = save the answer, clear the area, add the message to the display console, disable the button
        ok.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                answer = areaToWrite.getText().trim().toUpperCase();
                areaToWrite.setText("");
                addMessageToConsole(answer);
                ok.setEnabled(false);
            }
        });

//The button "OK" is enabled only if the JTextField areaToWrite have at least one character
        areaToWrite.addKeyListener(new KeyAdapter() {
            public void keyReleased(KeyEvent event) {
                if (!areaToWrite.getText().isEmpty()) {
                    ok.setEnabled(true);
                } else {
                    ok.setEnabled(false);
                }
            }
        });

//If we press the key "enter", we have the same response that when we click on OK button
        areaToWrite.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == areaToWrite) {
                    ok.doClick(0);
                }
            }
        });

    }

    /**
     * Allow to have access to the ok button in other class. Element view use it
     * to confirm answer
     *
     * @return return Jbutton OK
     */
    public JButton okButton() {
        return ok;
    }

    /**
     * Add a message to the display console
     *
     * @param theString is the string to add
     */
    public void addMessageToConsole(String theString) {
        displayMessage.append("> " + theString + "\n");    //We add the string in parameter
    }

    /**
     * The getter of the attribute answer
     *
     * @return answer is the last thing that is written in the console
     */
    public String getAnswer() {
        answer.toUpperCase();
        return answer;
    }

    /**
     * To get the area to write
     *
     * @return areaToWrite is to get the info in the console
     */
    public JTextField getAreaToWrite() {
        return areaToWrite;
    }

    /**
     * To set the answer
     *
     * @param answer is the answer
     */
    public void setAnswer(String answer) {
        this.answer = answer;
    }

    /**
     * To get the Window
     *
     * @return theWindow is the windowof the interface
     */
    public GeneralWindow getTheWindow() {
        return theWindow;
    }

    /**
     * To set a window in the interface
     *
     * @param newWindow is the window to set
     */
    public void setWindow(GeneralWindow newWindow) {
        theWindow.setVisible(false);
        theWindow = newWindow;
        theWindow.setVisible(true);
        top.add(theWindow, BorderLayout.CENTER);
    }

    /**
     * To get the interface to make an actualisation of the map for example
     *
     * @return theInterface = is the main interface
     */
    public JFrame getInterface() {
        return theInterface;
    }

    /**
     * To get the displayInfo
     *
     * @return infoPlayer is the info to get
     */
    public DisplayInfo getDisplay() {
        return infoPlayer;
    }

}
