package fr.dogstellar.view;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.awt.event.*;
import javax.imageio.ImageIO;
import javax.swing.*;

import fr.dogstellar.core.Player;

import java.util.*;

public class StartGame{
	private JFrame myJFrame;
	private JButton player1, player2, player3, startGame;
	private JPanel gridPlayer;
	private JTextField t;
	private String namePlayer = "";
	
	
	public StartGame() {
		myJFrame = new JFrame();
		
		//button start game (not enable if there is no name
	    startGame = new JButton("Start Game");
	    startGame.setEnabled(false);
	    startGame.addActionListener(new ActionListener () {
        	public void actionPerformed(ActionEvent evt) { 
        		Window wind = new Window("Emma.jpeg");  //start the game with the a player a planet ...
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
		
		//action when clicked to button of a player
		player1 = new JButton(new ImageIcon("C:\\Users\\clarisse\\git\\DogStellar\\pictures\\hulk.png"));
        player1.addActionListener(new ActionListener () {
        	public void actionPerformed(ActionEvent evt) { 
        		t.setEnabled(true);
    	    }
        });
        
		player2 = new JButton(new ImageIcon("C:\\Users\\clarisse\\git\\DogStellar\\pictures\\wonderwoman.png"));
        player2.addActionListener(new ActionListener () {
        	public void actionPerformed(ActionEvent evt) { 
        		t.setEnabled(true);
    	    }
        });
        
		player3 = new JButton(new ImageIcon("C:\\Users\\clarisse\\git\\DogStellar\\pictures\\spiderman.png"));
        player3.addActionListener(new ActionListener () {
        	public void actionPerformed(ActionEvent evt) { 
        		t.setEnabled(true);
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
        myJFrame.setContentPane(new JLabel(new ImageIcon("C:\\Users\\clarisse\\git\\DogStellar\\pictures\\BackgroundStartGame.jpg")));
	    
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
	
