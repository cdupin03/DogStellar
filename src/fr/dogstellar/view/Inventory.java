package fr.dogstellar.view;
import javax.swing.JFrame;

import fr.dogstellar.core.Player;

public class Inventory  extends JFrame{
private String title = "Inventory";
private int width= 500;
private int height= 500; 
private InventoryPanel panel;
public Inventory(Player thePlayer) {
	this.panel=new InventoryPanel(thePlayer);
	this.setTitle(title);
	this.setSize(width, height);
	this.setResizable(true);
	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	this.setVisible(true);
	this.add(panel);
	this.pack();
}
}
