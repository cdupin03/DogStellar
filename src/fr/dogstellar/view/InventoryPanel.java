package fr.dogstellar.view;
import java.awt.color.*;
import java.util.ArrayList;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.text.StyledEditorKit.ForegroundAction;

import com.sun.media.jfxmedia.events.NewFrameEvent;

import fr.dogstellar.core.*;

public class InventoryPanel extends JPanel {
 private Player thePlayer; 
 private JPanel inventory; 
 private JPanel equipedInventory; 


 public InventoryPanel( Player thePlayer) {
// TODO Auto-generated constructor stub
	this.thePlayer=thePlayer;
	equipedInventory= new JPanel();
	equipedArmor= new JButton(thePlayer.getArmorEquiped);
	equipedWeapon= new JButton(thePlayer.getWeaponEquiped);
	inventory= new JPanel();
	this.add(new JLabel("Equiped items"));
	this.add(new JLabel("Your Inventory"));
	this.add(equipedInventory);
	this.add(inventory);
	ArrayList<Stuff> stuffs = thePlayer.getStuff();
	int j =  stuffs.size();
	GridLayout Disposition = new GridLayout(5,10);
	inventory.setLayout(Disposition);
	for (Stuff i : stuffs) {
		JButton X=new JButton( i.getInformation().getName()); 
		inventory.add(X);
		X.setForeground( Color.BLACK);
		X.setBackground( new Color( 196,196,196));
		X.setOpaque(true);
		
} 
	
}
}
