package fr.dogstellar.view;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.text.*;

import fr.dogstellar.core.Player;
import java.awt.Font;

/**
 * The start game allows to choose a perso and a name for the player in a
 * dedicated window
 *
 * @author Group 3
 * @version V03
 */
public class StartGame {

    private JFrame myJFrame;
    private final JLabel title; 						//It is the title of the Game (DogStellar)
    private final JLabel infoPLife; 					//display the info (life Point) of the player (different between 3 types of player)
    private final JLabel infoPAttack;					//display the info (Attack Point) of the player (different between 3 types of player)
    private final JTextPane description;					//Description of the game
    private final JLabel chooseAName;					//name of the JTextField
    private JTextField t;						//Is the area to right the name of the player
    private JButton player1, player2, player3; 	//JButton for the 3 types of player
    private JButton startGame;					//JButton for start the game
    private final JPanel panelPlayer;					//JPanel contain the 3 types of player
    private final JPanel infoP;						//JPanel that display the infoPLife and infoPAttack
    private final JPanel infoPlayer;					//JPanel that display the 3 players + infoPLife and Attack
    private final JPanel nameText;					//JPanel with chooseAName and the JtextFiels
    private final JPanel menu;						//JPanel menu with title description and nameText
    private final JPanel rightIcon;					//JPanel with menu, infoPlayer and button start game

    private String namePlayer = "";				//Initialize the name of the player to ""
    private static Player player;				//It is the player
    private String picturePath;					//To know where the picture are in the computer
    private static int lP, aP, tmpaP;			// integer to the lifePoint, attackPoint, ?????????????????????????
    private static int tmplP;
    private static Interface interf;			//Is the interface
    private static ImageIcon imagePlayer;		//Is the image of the player that is select

    private final JButton ok = new JButton();                   //The button to validate an entry in the console
    /**
     * The constructor of this class, allow to display the 
     * window to create and its perso and 
     */
    public StartGame() {
        picturePath = System.getProperty("user.dir") + "/pictures/";

        //Instantiate my JFrame
        myJFrame = new JFrame();

        //action when clicked to button of a player
        //ranger have 2 life point and 8 attacked point
        player1 = new JButton(new ImageIcon(picturePath + "Ranger.png"));
        player1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent evt) {
                imagePlayer = new ImageIcon(picturePath + "Ranger.png");
                lP = 2;
                aP = 8;
                t.setEnabled(true);
                player1.setEnabled(true);
                player2.setEnabled(false);
                player3.setEnabled(false);
                t.requestFocusInWindow();
            }

            @Override
            public void mouseEntered(MouseEvent evt) {
                tmplP = 2;
                tmpaP = 8;
                majInfoP(tmplP, tmpaP);
                System.out.println("entrer");
            }

        });

        //engineer have 5 life point and 5 attacked point
        player2 = new JButton(new ImageIcon(picturePath + "Engineer.png"));
        player2.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent evt) {
                imagePlayer = new ImageIcon(picturePath + "Engineer.png");
                lP = 5;
                aP = 5;
                t.setEnabled(true);
                player1.setEnabled(false);
                player2.setEnabled(true);
                player3.setEnabled(false);
                t.requestFocusInWindow();
            }

            @Override
            public void mouseEntered(MouseEvent evt) {
                tmplP = 5;
                tmpaP = 5;
                majInfoP(tmplP, tmpaP);
                System.out.println("entrer");
            }
        });

        //scientist have 8 life point and 2 attacked point
        player3 = new JButton(new ImageIcon(picturePath + "Scientist.png"));
        player3.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent evt) {
                imagePlayer = new ImageIcon(picturePath + "Scientist.png");
                lP = 8;
                aP = 2;
                t.setEnabled(true);
                player1.setEnabled(false);
                player2.setEnabled(false);
                player3.setEnabled(true);
                t.requestFocusInWindow();
            }

            @Override
            public void mouseEntered(MouseEvent evt) {
                tmplP = 8;
                tmpaP = 2;
                majInfoP(tmplP, tmpaP);
                System.out.println("entrer");
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

        //Player
            //BorderLayout of different type of player
        panelPlayer = new JPanel();
        panelPlayer.setLayout(new BorderLayout());
        panelPlayer.add(player1, BorderLayout.NORTH);
        panelPlayer.add(player2, BorderLayout.CENTER);
        panelPlayer.add(player3, BorderLayout.SOUTH);
        panelPlayer.setOpaque(false);
        
            //info for a player (life point and attack point)
        infoPLife = new JLabel("This player has " + String.valueOf(lP) + " life Point", JLabel.CENTER);
        infoPAttack = new JLabel(" and " + String.valueOf(aP) + " attack Point", JLabel.CENTER);
        infoPLife.setFont(new java.awt.Font(Font.DIALOG, Font.BOLD, 25));
        infoPLife.setForeground(Color.white);
        infoPAttack.setFont(new java.awt.Font(Font.DIALOG, Font.BOLD, 25));
        infoPAttack.setForeground(Color.white);
        infoP = new JPanel(new BorderLayout());
        infoP.add(infoPLife, BorderLayout.NORTH);
        infoP.add(infoPAttack, BorderLayout.SOUTH);
        infoP.setOpaque(false);
        //player + info of a player
        infoPlayer = new JPanel(new BorderLayout());
        infoPlayer.add(panelPlayer, BorderLayout.CENTER);
        infoPlayer.add(infoP, BorderLayout.SOUTH);
        infoPlayer.setOpaque(false);

        //title
        title = new JLabel("Dog Stellar", JLabel.CENTER);
        title.setFont(new java.awt.Font(Font.DIALOG, Font.BOLD, 75));
        title.setForeground(Color.white);

        //description of the game
        description = new JTextPane();
        description.setFont(new java.awt.Font(Font.DIALOG, Font.BOLD, 25));
        description.setOpaque(false);
        description.setForeground(Color.white);
        description.setText(" Welcome to DogStellar, the team of GPhy developer \n is happy to see you test our Java project! \n During this adventure, you must be careful if you do not \n want to die before having been able to go back home...");
        description.setEditable(false);
        
        //center the description
        StyledDocument doc = description.getStyledDocument();
        SimpleAttributeSet center = new SimpleAttributeSet();
        StyleConstants.setAlignment(center, StyleConstants.ALIGN_CENTER);
        doc.setParagraphAttributes(0, doc.getLength(), center, false);

        //Text for enter the name of player (not enable if no player is choose)
        t = new JTextField(30);
        t.setPreferredSize(new Dimension(10, 40));
        t.setEnabled(false);
        
        ok.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == ok) {
                    namePlayer = t.getText();
                    if (!namePlayer.equals("") && (namePlayer.length() >= 3)) {
                        startGame.setEnabled(true);
                    }
                }
            }
        });
        
        t.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ok.doClick();
            }
        });
        
        //The ok button is accessible only if there is a character in the t 
        t.addKeyListener(new KeyAdapter() {
            public void keyReleased(KeyEvent event) {
                if (!t.getText().isEmpty()) {
                    ok.setEnabled(true);
                } else {
                    ok.setEnabled(false);
                }
            }
        });
        
        ok.setText("OK");                                           //Set the button text
        ok.setForeground(Color.black);                              //Set the color of the button
        ok.setPreferredSize(new Dimension(55, 40));                                          //Set the size of the button
        ok.setFont(new java.awt.Font(Font.SERIF, Font.BOLD, 14));     //Set the font of the button
        ok.setEnabled(false);                                       //Disable the button
        
        chooseAName = new JLabel("Choose a name");
        chooseAName.setFont(new java.awt.Font(Font.DIALOG, Font.BOLD, 25));
        chooseAName.setForeground(Color.white);
        nameText = new JPanel();
        nameText.add(chooseAName);
        nameText.add(t);
        nameText.add(ok);
        nameText.setOpaque(false);

        //button start game (not enable if there is no namePlayer)
        startGame = new JButton("Start Game");
        startGame.setEnabled(false);
        startGame.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                player = new Player(namePlayer, lP, aP);
                myJFrame.dispose();
                interf = new Interface();  //start the game with the a player a planet ...
                new VideoPlayer("Intro.mp4", 53000, "DogStellar - The Beginning");
            }
        });
        startGame.setOpaque(false);
        startGame.setContentAreaFilled(false);
        startGame.setBorderPainted(false);
        startGame.setFont(new java.awt.Font(Font.DIALOG, Font.BOLD, 55));
        startGame.setForeground(Color.white);

        //JPanel menu with title description and nameText
        menu = new JPanel(new BorderLayout());
        menu.add(title, BorderLayout.NORTH);
        menu.add(description, BorderLayout.CENTER);
        menu.add(nameText, BorderLayout.SOUTH);
        menu.setOpaque(false);

        //JPanel with menu, infoPlayer and button start game
        rightIcon = new JPanel();
        rightIcon.setLayout(new BorderLayout());
        rightIcon.add(menu, BorderLayout.CENTER);
        rightIcon.add(infoPlayer, BorderLayout.EAST);
        rightIcon.add(startGame, BorderLayout.SOUTH);
        rightIcon.setOpaque(false);

        //myJFrame with an image background
        myJFrame.setContentPane(new JLabel(new ImageIcon(picturePath + "BackgroundStartGame.png")));
        myJFrame.setLayout(new BorderLayout());
        myJFrame.add(rightIcon);

        //size of frame
        myJFrame.setSize(1200, 700);

        myJFrame.setResizable(false);                               //This JFrame is not resizable
        myJFrame.setLocationRelativeTo(null);
        myJFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);    //Closing the frame close the application
        myJFrame.setVisible(true);
    }

    /**
     * To update the lifePoint and attackPoint
     *
     * @param lP is the lifePoint to update
     * @param aP is the attackPoint to update
     */
    public void majInfoP(int lP, int aP) {
        infoPLife.setText("This player has " + String.valueOf(lP) + " life Point");
        infoPAttack.setText(" and " + String.valueOf(aP) + " attack Point");
    }

    /**
     * Get the player
     *
     * @return player is the player to get
     */
    public static Player getPlayer() {
        return player;
    }

    /**
     * To get the interface
     *
     * @return interface isthe interface
     */
    public static Interface getInterf() {
        return interf;
    }

    /**
     * To get the image of the player
     *
     * @return imagePlayer is the image player to get
     */
    public static ImageIcon getImagePlayer() {
        return (imagePlayer);
    }

    /**
     * To get the LifePoint
     *
     * @return tmplP is the life point
     */
    public static int getLifePoint() {
        return (lP);
    }

}
