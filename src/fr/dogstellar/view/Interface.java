package fr.dogstellar.view;

import fr.dogstellar.core.AreaPlanet;
import fr.dogstellar.core.Armor;
import fr.dogstellar.core.Element;
import fr.dogstellar.core.Perso;
import fr.dogstellar.core.Planet;
import fr.dogstellar.core.Potion;
import fr.dogstellar.core.QuestElement;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.text.DefaultCaret;
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
    private final JButton attack = new JButton("Attack");	//The button to start attack a monster
    private final JPanel display = new JPanel();                //The panel in the console that contain the JTextArea displayMessage
    private final JPanel write = new JPanel();                  //The panel in the console that contain the JTextField to write answer and the button of validation
    private final JTextArea displayMessage = new JTextArea();   //The area to display message
    private JTextField areaToWrite = new JTextField();          //The area to write answer
    private String answer;                                      //The last answer that is write

    private final JButton inventory;                            //Button wich allow to open the inventory


    private Perso monstre1 = new Perso("Monstre", 10, 5, new QuestElement("A Piece","that same piece"), new Armor("MyGreatArmor", "sfddghfxhfgd", 3));
    private Perso monstre2 = new Perso("Monstre2", 5, 2, new QuestElement("Another piece","that other same piece"), new Potion("Potion Powerfull", "sgfhrhsgsd", 6));

    private GeneralWindow theWindow;

    private DisplayInfo infoPlayer, infoArea; 					//
    private JPanel displayInfo = new JPanel();					//
    /**
     * The constructor of the class Interface
     */
    public Interface() {
        areaToWrite.setPreferredSize(new Dimension(340, 30));        //Set the size of the area to write
        areaToWrite.setFont(new Font(Font.SERIF, Font.PLAIN, 18));    //Font of the area to write

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

        //Left part of the interface
        String picturePath = System.getProperty("user.dir") + "/pictures/";     //variable containing the path for the inventory image
        ImageIcon picture = new ImageIcon(picturePath + "inventory.png");       //image for the inventory button
        inventory = new JButton(picture);                                       // create the button
        displayP.add(inventory);                                                // add the button to the inventory
        inventory.setToolTipText("click here to acess to you inventory");       // set a descritpion text

        //ActionListenener for generate the inventory frame in one click
        inventory.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                InventoryPanel ip = new InventoryPanel(StartGame.getPlayer());

            }
        });

        /*
         *  *****   *  *   *****      ** **   *****   *****                                          
         *    *     ****   **         * * *   *****   *****                                                       
         *    *     *  *   *****      *   *   *   *   *                                     
         */
        Planet planet1 = new Planet("Planet1", "Etrange", 0);
        Planet planet2 = new Planet("Planet2", "Tout aussi etrange", 3);
        ArrayList<Planet> planets = new ArrayList<Planet>(); //The list of planets the first planet is the actual planet.
        //If we change planet, the new planet exchange its place with the first.
        planets.add(planet1);
        planets.add(planet2);

        AreaPlanet test1 = new AreaPlanet("tyuiuyfv", "rdytfuygiut", "champ.jpg");
        test1.addPerso(monstre1);
        test1.addPerso(monstre2);
        test1.addElement(new Element("Coffre", "Petit coffre", 1));
        test1.addElement(new Element("Enigme", "Une enigme", 4));
        test1.addElement(new Element("Trap", "Un piege déguisé", 2));
        test1.addElement(new Element("PNJ", "Un pnj champu", 3));
        AreaPlanet test2 = new AreaPlanet("Bqzld", "rdytfiut", "lave.jpg");
        AreaPlanet test3 = new AreaPlanet("Nouvelle planete", "hum ...", "mario.jpeg");
        test1.addAreaPlanet(test2, "south");
        planet1.addArea(test1);
        planet2.addArea(test3);

        theWindow = new Window(planets, this);
        //theWindow = new InShip(this, planets);

        attack.setEnabled(false);

        top.setLayout(new BorderLayout());                          //Set the layout of the top part       
        top.add(theWindow, BorderLayout.CENTER);                    //Add the area map in the top part

        bottom.setLayout(new BorderLayout());                       //Set the layout of the bottom part
        bottom.add(console, BorderLayout.EAST);                     //Add the console to the right part of the bottom
        bottom.add(displayInfo, BorderLayout.CENTER);
        
        infoPlayer = new DisplayInfo();
        
        displayInfo.setLayout(new BorderLayout());					//Set the layout of the displayInfo part
        displayInfo.add(displayP, BorderLayout.WEST);				//Add the information of the player in the displayInfo Panel
        displayInfo.add(displayA, BorderLayout.CENTER);			   // Add the information of the area in the displayInfo Panel
        
        // Information of the player and his localization on the map
        displayP.setLayout(new BorderLayout());
        displayP.add(infoPlayer, BorderLayout.CENTER);
        displayP.add(inventory, BorderLayout.WEST);
        
        JLabel test = new JLabel();
        test.setText(theWindow.getCurrentArea());
        
        displayA.setLayout(new BorderLayout());
        //displayA.add(infoArea, BorderLayout.CENTER);
        displayA.add(test);
        displayA.add(attack, BorderLayout.EAST);
        
        theInterface.setPreferredSize(new Dimension(1200, 700));     //Set the size of the frame
        theInterface.setLayout(new BorderLayout());                 //Set the display of the frame
        theInterface.add(top, BorderLayout.CENTER);                 //Add the top part in the frame
        theInterface.add(bottom, BorderLayout.SOUTH);               //Add the bottom part in the frame
        theInterface.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//Closing the frame close the application
        theInterface.pack();                                        //Sizes the frame so that all its contents are at or above their preferred sizes
        theInterface.setVisible(true);                              //To display the frame

        //The actions of the button "OK" = save the answer, clear the area, add the message to the display console, disable the button
        ok.addActionListener(new ActionListener() {
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
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == areaToWrite) {
                    ok.doClick(0);
                }
            }
        });

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
     * To get the Window
     *
     * @return theWindow is the windowof the interface
     */
    public GeneralWindow getTheWindow() {
        return theWindow;
    }

    /**
     * Set the enable of attack JButton
     *
     * @param ena true if the button is enabled, else false
     */
    public void isAttackEnabled(boolean ena) {
        attack.setEnabled(ena);
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
}
