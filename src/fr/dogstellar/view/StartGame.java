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

public class StartGame{
	private JFrame myJFrame;
	private JButton player1, player2, player3, startGame;
	private JPanel gridPlayer;
	private JTextField t;
	private String namePlayer = "";
	private Player player;
	private String picturePath;
	
	
	public StartGame() {
		picturePath = new String(System.getProperty("user.dir") + "/pictures/");
		
		myJFrame = new JFrame();
		
  		//action when clicked to button of a player
  			//hulk have 2 life point and 8 attacked point
		player1 = new JButton(new ImageIcon(picturePath + "hulk.png"));
        player1.addActionListener(new ActionListener () {
        	public void actionPerformed(ActionEvent evt) { 
        		player = new Player(namePlayer, 2,8);
        		t.setEnabled(true);
        		player2.setEnabled(false);
        		player3.setEnabled(false);
    	    }
        });
        
        	//wonderwoman have 5 life point and 5 attacked point
		player2 = new JButton(new ImageIcon(picturePath + "wonderwoman.png"));
        player2.addActionListener(new ActionListener () {
        	public void actionPerformed(ActionEvent evt) {
        		player = new Player(namePlayer, 5,5);
        		t.setEnabled(true);
        		player1.setEnabled(false);
        		player3.setEnabled(false);
    	    }
        });
        
        	//spider have 8 life point and 2 attacked point
		player3 = new JButton(new ImageIcon(picturePath + "spiderman.png"));
        player3.addActionListener(new ActionListener () {
        	public void actionPerformed(ActionEvent evt) { 
        		player = new Player(namePlayer,8,2);
        		t.setEnabled(true);
        		player1.setEnabled(false);
        		player2.setEnabled(false);
    	    }
        });
        
        //Text for enter the name of player (not enable if no player is choose)
  		t = new JTextField("Name of Player");
        t.setPreferredSize(new Dimension(10,10));
		t.setEnabled(false);
  		t.addActionListener(new ActionListener (){
              public void actionPerformed(ActionEvent e){
                  if(e.getSource() == t) {
                      namePlayer=t.getText();
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
	    startGame.addActionListener(new ActionListener () {
        	public void actionPerformed(ActionEvent evt) { 
        		Planet planet1 = new Planet("Rouge","planet de feu");
        		AreaPlanet area1 = new AreaPlanet("lave", "grosse eruption", System.getProperty("user.dir") + "/pictures/champ.jpg");
        		planet1.addArea(area1);
        		area1.addPerso(player);
        		Interface interf = new Interface();  //start the game with the a player a planet ...
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
        
        //grid of player
	    gridPlayer = new JPanel();
	    gridPlayer.setLayout(new FlowLayout());
	    gridPlayer.add(player1);
	    gridPlayer.add(player2);
	    gridPlayer.add(player3);
	    //transparent flowLayout
	    gridPlayer.setOpaque(false);
	    
        //image background
        myJFrame.setContentPane(new JLabel(new ImageIcon(picturePath + "BackgroundStartGame.jpg")));
	    
	    //BorderLayout
        BorderLayout myBorderL = new BorderLayout();
        myJFrame.setLayout(myBorderL);
        myJFrame.add(gridPlayer, BorderLayout.NORTH);
        myJFrame.add(t, BorderLayout.CENTER);
        myJFrame.add(startGame, BorderLayout.SOUTH);
        
	    // size of JPanel
        gridPlayer.setPreferredSize(new Dimension(300,500));
	    startGame.setPreferredSize(new Dimension(200,100));
	    
	    //size of frame
	    myJFrame.setSize(1200,700);
	    
	    myJFrame.setLocationRelativeTo(null);
	    myJFrame.setVisible(true);
	    }
	}
	
