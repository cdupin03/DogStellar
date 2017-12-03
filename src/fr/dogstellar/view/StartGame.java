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
    private JLabel title, infoP;
    private JButton player1, player2, player3, startGame;
    private JPanel panelPlayer, titlePlayer;
    private JTextField t;
    private String namePlayer = "";
    private static Player player;
    private String picturePath;
    private int lP, aP;
    private static Interface interf;

    /**
     * The constructor of this class
     */
    public StartGame() {
        picturePath = new String(System.getProperty("user.dir") + "/pictures/");

        myJFrame = new JFrame();

        infoP = new JLabel("This player has " + String.valueOf(lP) + " life Point" + " and " + String.valueOf(aP) + " attack Point", JLabel.CENTER);
        infoP.setFont(new java.awt.Font(Font.SERIF, Font.BOLD, 18));
        infoP.setForeground(Color.black);

        title = new JLabel("Dog Stellar", JLabel.CENTER);
        title.setFont(new java.awt.Font(Font.SERIF, Font.BOLD, 75));
        title.setForeground(Color.black);

        //action when clicked to button of a player
        //hulk have 2 life point and 8 attacked point
        player1 = new JButton(new ImageIcon(picturePath + "hulk.png"));
        player1.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                player = new Player(namePlayer, 2, 8);
                t.setEnabled(true);
                player1.setEnabled(true);
                player2.setEnabled(false);
                player3.setEnabled(false);
                t.requestFocusInWindow();
            }

            public void mouseEntered(MouseEvent evt) {
                player = new Player(namePlayer, 2, 8);
                lP = player.getLifePoint();
                aP = player.getAttackPoint();
                majInfoP(lP, aP);
                System.out.println("entrer");
            }

        });

        //wonderwoman have 5 life point and 5 attacked point
        player2 = new JButton(new ImageIcon(picturePath + "wonderwoman.png"));
        player2.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                player = new Player(namePlayer, 5, 5);
                t.setEnabled(true);
                player1.setEnabled(false);
                player2.setEnabled(true);
                player3.setEnabled(false);
                t.requestFocusInWindow();
            }

            public void mouseEntered(MouseEvent evt) {
                player = new Player(namePlayer, 5, 5);
                lP = player.getLifePoint();
                aP = player.getAttackPoint();
                majInfoP(lP, aP);
                System.out.println("entrer");
            }
        });

        //spider have 8 life point and 2 attacked point
        player3 = new JButton(new ImageIcon(picturePath + "spiderman.png"));
        player3.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                player = new Player(namePlayer, 8, 2);
                t.setEnabled(true);
                player1.setEnabled(false);
                player2.setEnabled(false);
                player3.setEnabled(true);
                t.requestFocusInWindow();
            }

            public void mouseEntered(MouseEvent evt) {
                player = new Player(namePlayer, 8, 2);
                lP = player.getLifePoint();
                aP = player.getAttackPoint();
                majInfoP(lP, aP);
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
                    System.out.println(namePlayer);
                    if (!namePlayer.equals("")) {
                        startGame.setEnabled(true);
                    }
                }
            }
        });

        //button start game (not enable if there is no namePlayer)
        startGame = new JButton("Start Game");
        startGame.setEnabled(false);
        startGame.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                Planet planet1 = new Planet("Rouge", "planet de feu");
                AreaPlanet area1 = new AreaPlanet("lave", "grosse eruption", System.getProperty("user.dir") + "/pictures/champ.jpg");
                planet1.addArea(area1);
                area1.addPerso(player);
                myJFrame.dispose();
                interf = new Interface();  //start the game with the a player a planet ...
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
        startGame.setFont(new java.awt.Font(Font.SERIF, Font.BOLD, 50));
        startGame.setForeground(Color.black);

        //grid of player
        panelPlayer = new JPanel();
        panelPlayer.setLayout(new FlowLayout());
        panelPlayer.add(player1);
        panelPlayer.add(player2);
        panelPlayer.add(player3);
        //transparent flowLayout
        panelPlayer.setOpaque(false);

        //image background
        myJFrame.setContentPane(new JLabel(new ImageIcon(picturePath + "BackgroundStartGame.jpg")));

        titlePlayer = new JPanel();
        titlePlayer.setLayout(new BorderLayout());
        titlePlayer.add(title, BorderLayout.NORTH);
        titlePlayer.add(panelPlayer, BorderLayout.CENTER);
        if (infoP != null) {
            titlePlayer.add(infoP, BorderLayout.SOUTH);
        }
        titlePlayer.setOpaque(false);

        //BorderLayout
        BorderLayout myBorderL = new BorderLayout();
        myJFrame.setLayout(myBorderL);
        myJFrame.add(titlePlayer, BorderLayout.NORTH);
        myJFrame.add(t, BorderLayout.CENTER);
        myJFrame.add(startGame, BorderLayout.SOUTH);

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
        infoP.setText("This player has " + String.valueOf(lP) + " life Point" + " and " + String.valueOf(aP) + " attack Point");
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

}
