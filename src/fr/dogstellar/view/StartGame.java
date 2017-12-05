package fr.dogstellar.view;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.awt.event.*;
import javax.imageio.ImageIO;
import javax.swing.*;

import fr.dogstellar.core.AreaPlanet;
import fr.dogstellar.core.Planet;
import fr.dogstellar.core.Player;

import java.util.*;

/**
 * The start game allows to choose a perso and a name for the player in a dedicated window
 * 
 * @author Group 3
 * @version V03
 */
public class StartGame {

    private JFrame myJFrame;
    private JLabel title, infoPLife, infoPAttack, description;
    private JButton player1, player2, player3, startGame;
    private JPanel panelPlayer, infoP, infoPlayer, rightIcon, menu;
    private JTextField t;
    private String namePlayer = "";
    private static Player player;
    private String picturePath;
    private int lP, aP, tmplP, tmpaP;
    private static Interface interf;
    private static ImageIcon imagePlayer;
    private VideoPlayer intro;
    
    /**
     * The constructor of this class
     */
    public StartGame() {
        picturePath = new String(System.getProperty("user.dir") + "/pictures/");

        myJFrame = new JFrame();

        description = new JLabel("Description",  JLabel.CENTER);
        description.setFont(new java.awt.Font(Font.SERIF, Font.BOLD, 25));
        description.setForeground(Color.white);
        
        infoPLife = new JLabel("This player has " + String.valueOf(lP) + " life Point", JLabel.CENTER);
        infoPAttack = new JLabel(" and " + String.valueOf(aP) + " attack Point", JLabel.CENTER);
        infoPLife.setFont(new java.awt.Font(Font.SERIF, Font.BOLD, 25));
        infoPLife.setForeground(Color.white);
        infoPAttack.setFont(new java.awt.Font(Font.SERIF, Font.BOLD, 25));
        infoPAttack.setForeground(Color.white);

        infoP = new JPanel(new BorderLayout());
        infoP.add(infoPLife, BorderLayout.NORTH);
        infoP.add(infoPAttack, BorderLayout.SOUTH);
        infoP.setOpaque(false);
        
        title = new JLabel("Dog Stellar", JLabel.CENTER);
        title.setFont(new java.awt.Font(Font.SERIF, Font.BOLD, 75));
        title.setForeground(Color.white);

        //action when clicked to button of a player
        //hulk have 2 life point and 8 attacked point
        player1 = new JButton(new ImageIcon(picturePath + "Ranger.png"));
        player1.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                //player = new Player(namePlayer, 2, 8);
            	imagePlayer= new ImageIcon(picturePath + "Ranger.png");
            	lP = 2;
                aP = 8;
                t.setEnabled(true);
                player1.setEnabled(true);
                player2.setEnabled(false);
                player3.setEnabled(false);
                t.requestFocusInWindow();
            }

            public void mouseEntered(MouseEvent evt) {
                tmplP = 2;
                tmpaP = 8;
                majInfoP(tmplP, tmpaP);
                System.out.println("entrer");
            }

        });

        //wonderwoman have 5 life point and 5 attacked point
        player2 = new JButton(new ImageIcon(picturePath + "Engineer.png"));
        player2.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                //player = new Player(namePlayer, 5, 5);
            	imagePlayer= new ImageIcon(picturePath + "Engineer.png");
            	lP = 5;
            	aP = 5;
                t.setEnabled(true);
                player1.setEnabled(false);
                player2.setEnabled(true);
                player3.setEnabled(false);
                t.requestFocusInWindow();
            }  

            public void mouseEntered(MouseEvent evt) {
                //player = new Player(namePlayer, 5, 5);
                tmplP = 5;
                tmpaP = 5;
                majInfoP(tmplP, tmpaP);
                System.out.println("entrer");
            }
        });

        //spider have 8 life point and 2 attacked point
        player3 = new JButton(new ImageIcon(picturePath + "Scientist.png"));
        player3.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                //player = new Player(namePlayer, 8, 2);
            	imagePlayer= new ImageIcon(picturePath + "Scientist.png");
            	lP = 8;
            	aP = 2;
                t.setEnabled(true);
                player1.setEnabled(false);
                player2.setEnabled(false);
                player3.setEnabled(true);
                t.requestFocusInWindow();
            }

            public void mouseEntered(MouseEvent evt) {
                //player = new Player(namePlayer, 8, 2);
            	tmplP = 8;
                tmpaP = 2;
                majInfoP(tmplP, tmpaP);
                System.out.println("entrer");
            }
        });

        //Text for enter the name of player (not enable if no player is choose)
        t = new JTextField("Name of Player");
        t.setPreferredSize(new Dimension(100, 100));
        t.setEnabled(false);
        t.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == t) {
                    namePlayer = t.getText();
                    if (!namePlayer.equals("")) {
                        startGame.setEnabled(true);
                    }
                }
            }
        });
        
        t.setPreferredSize(new Dimension(10, 40));

        //button start game (not enable if there is no namePlayer)
        startGame = new JButton("Start Game");
        startGame.setEnabled(false);
        startGame.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
//                Planet planet1 = new Planet("Rouge", "planet de feu");
//                AreaPlanet area1 = new AreaPlanet("lave", "grosse eruption", System.getProperty("user.dir") + "/pictures/champ.jpg");
//                planet1.addArea(area1);
//                area1.addPerso(player);
            	player = new Player(namePlayer, lP, aP);
            	//System.out.println(namePlayer);
            	//System.out.println(player.getLifePoint());
            	//System.out.println(player.getAttackPoint());
                myJFrame.dispose();
                interf = new Interface();  //start the game with the a player a planet ...
                intro = new VideoPlayer();
            }
        });

        //transparent button
        player1.setOpaque(false);
        player1.setContentAreaFilled(false);
        player1.setBorderPainted(false);

        player2.setOpaque(false);
        player2.setContentAreaFilled(false);
        player2.setBorderPainted(false);

        player3.setOpaque(false);
        player3.setContentAreaFilled(false);
        player3.setBorderPainted(false);

        startGame.setOpaque(false);
        startGame.setContentAreaFilled(false);
        startGame.setBorderPainted(false);
        startGame.setFont(new java.awt.Font(Font.SERIF, Font.BOLD, 55));
        startGame.setForeground(Color.white);

        //BorderLayout of player
        panelPlayer = new JPanel();
        panelPlayer.setLayout(new BorderLayout());
        panelPlayer.add(player1, BorderLayout.NORTH);
        panelPlayer.add(player2, BorderLayout.CENTER);
        panelPlayer.add(player3, BorderLayout.SOUTH);
        //transparent borderLayout
        panelPlayer.setOpaque(false);

        infoPlayer = new JPanel(new BorderLayout());
        infoPlayer.add(panelPlayer, BorderLayout.CENTER);
        infoPlayer.add(infoP, BorderLayout.SOUTH);
        infoPlayer.setOpaque(false);
        
        menu = new JPanel(new BorderLayout());
        menu.add(title, BorderLayout.NORTH);
        menu.add(description, BorderLayout.CENTER);
        menu.add(t, BorderLayout.SOUTH);
        menu.setOpaque(false);
        
        rightIcon = new JPanel();
        rightIcon.setLayout(new BorderLayout());
        rightIcon.add(menu, BorderLayout.CENTER);
        rightIcon.add(infoPlayer, BorderLayout.EAST);
        rightIcon.add(startGame, BorderLayout.SOUTH);
        rightIcon.setOpaque(false);
        
        //transparent BorderLayout
        rightIcon.setOpaque(false);
        
        //image background
        myJFrame.setContentPane(new JLabel(new ImageIcon(picturePath + "BackgroundStartGame.png")));

        //BorderLayout
        myJFrame.setLayout(new BorderLayout());
        myJFrame.add(rightIcon);

        // size of JPanel
        panelPlayer.setPreferredSize(new Dimension(200, 400));
        startGame.setPreferredSize(new Dimension(200, 100));

        //size of frame
        myJFrame.setSize(1200, 700);

        myJFrame.setLocationRelativeTo(null);
        myJFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//Closing the frame close the application
        myJFrame.setVisible(true);
    }

    /**
     * 
     * @param lP
     * @param aP 
     */
    public void majInfoP(int lP, int aP) {
        infoPLife.setText("This player has " + String.valueOf(lP) + " life Point");
        infoPAttack.setText(" and " + String.valueOf(aP) + " attack Point");
    }

    /**
     * Get the player
     *
     * @return player
     */
    public static Player getPlayer() {
        return player;
    }

    /**
     * the interface
     *
     * @return interface
     */
    public static Interface getInterf() {
        return interf;
    }
    
    /**
     * the image of player
     *
     * @return interface
     */
    public static ImageIcon getImagePlayer() {
        return (imagePlayer);
    }

}
