package fr.dogstellar.view;

import java.awt.color.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.*;
import java.io.File;
import java.util.ArrayList;
import java.awt.Color;
import java.awt.Event;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import javax.swing.*;
import javax.swing.text.StyledEditorKit.ForegroundAction;

import org.omg.CORBA.PRIVATE_MEMBER;
import org.omg.CORBA.PUBLIC_MEMBER;

import fr.dogstellar.core.*;

public class InventoryPanel extends JFrame {
	private String title = "Inventory";
	int gridCaseHeight1 = ((300) / (2));
	int gridCaseWidth1 = ((175) / (2));
	private int width = 1200;
	private int height = 700;
	private Player thePlayer;
	private JPanel inventory;
	private JPanel equipedInventory;
	JLabel lbl1 = new JLabel("Equiped items");
	JLabel lbl2 = new JLabel("Your Inventory");

	public InventoryPanel(Player thePlayer) {
		// TODO Auto-generated constructor stub
		this.setLayout(new GridLayout(0, 2, 20, 20));
		this.thePlayer = thePlayer;
		generateInventory();
		this.setTitle(title);
		this.setSize(width, height);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		this.pack();
	}

	public void generateInventory() {

		// test si le joueur à un équipement + creation du label "Equiped item"

		equipedInventory = new JPanel();
		equipedInventory.setLayout(new GridLayout(0, 2, 15, 15));
		equipedInventory.setBackground(new Color(122, 122, 122));
		equipedInventory.setOpaque(true);

		this.add(lbl1);
		lbl1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		lbl1.setFont(new Font("Blippo", Font.PLAIN, 28));
		this.add(equipedInventory);

		// creation du Jpanel de l'équipement

		if (!thePlayer.hasArmor()) {
			ImageIcon theImage1 = new ImageIcon("user.dir" + "/Pictures/void.jpg");

			theImage1 = resyze(theImage1, gridCaseHeight1, gridCaseWidth1);
			JButton equipedArmor = new JButton(theImage1);
			equipedInventory.add(equipedArmor);
			equipedArmor.setToolTipText("There is no item equiped on this slot");
		} else {
			ImageIcon theImage1 = new ImageIcon(associationImage(thePlayer.getArmorEquip()));

			theImage1 = resyze(theImage1, gridCaseHeight1, gridCaseWidth1);
			JButton equipedArmor = new JButton(theImage1);
			equipedInventory.add(equipedArmor);
			equipedArmor.setToolTipText(associationLabel(thePlayer.getArmorEquip()));

			equipedArmor.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					if (thePlayer.hasArmor()) {

						thePlayer.desequipArmor();
						refreshInventory();
					}

				}
			});
		}

		if (!thePlayer.hasWeapon()) {
			ImageIcon theImage2 = new ImageIcon("user.dir/Pictures/void.jpg");

			theImage2 = resyze(theImage2, gridCaseHeight1, gridCaseWidth1);
			JButton equipedWeapon = new JButton(theImage2);
			equipedInventory.add(equipedWeapon);
			// weaponEquiped = thePlayer.getWeaponEquip();
			equipedWeapon.setToolTipText("There is no equiped item on this slot");
		} else {
			ImageIcon theImage2 = new ImageIcon(associationImage(thePlayer.getWeaponEquip()));

			theImage2 = resyze(theImage2, gridCaseHeight1, gridCaseWidth1);
			JButton equipedWeapon = new JButton(theImage2);
			equipedInventory.add(equipedWeapon);
			// weaponEquiped = thePlayer.getWeaponEquip();
			equipedWeapon.setToolTipText(associationLabel(thePlayer.getWeaponEquip()));
			equipedWeapon.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					if (thePlayer.hasWeapon()) {
						thePlayer.desequipWeapon();
						refreshInventory();
					}

				}
			});
		}

		// test si l'inventaire est vide

		// creation du panel +du label
		inventory = new JPanel();

		lbl2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		lbl2.setFont(new Font("Blippo", Font.PLAIN, 28));
		this.add(lbl2);
		this.add(inventory);
		// creation d'une liste de la taille du nombre d'imem du joueur
		if (thePlayer.getStuff().isEmpty() == false) {
			ArrayList<Stuff> stuffs = Factorise(thePlayer.getStuff());
			int j = stuffs.size();

			// creation de la grille pour placer les items
			GridLayout Disposition = new GridLayout(j / 3, 3);
			inventory.setLayout(Disposition);

			// variables de taille des images pour chaques item
			int gridCaseHeight = ((300) / (j / 3));
			int gridCaseWidth = ((175) / (j / (j / 3)));

			// pour chaque item si l'item est different de l'arme et l'armure équipé
			for (Stuff i : stuffs) {

				ImageIcon theImage = new ImageIcon(associationImage(i));
				theImage = resyze(theImage, gridCaseHeight, gridCaseWidth);
				JButton X = new JButton(theImage);
				X.setToolTipText(associationLabel(i));
				JLabel Y = new JLabel(":" + nbOccurence(i, thePlayer.getStuff()));
				X.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						if (isWeapon(i)) {
							if (thePlayer.hasWeapon()) {

								thePlayer.desequipWeapon();
							}
							thePlayer.addWeaponEquip((Weapon) i);
							thePlayer.getStuff().remove(i);
							refreshInventory();
						}
						if (isArmor(i)) {
							if (thePlayer.hasArmor()) {
								thePlayer.desequipArmor();
							}
							thePlayer.addArmorEquip((Armor) i);
							thePlayer.getStuff().remove(i);
							refreshInventory();
						}
						if (isPotion(i)) {
							((Potion) i).drinkPotion(thePlayer);
							thePlayer.getStuff().remove(i);
							refreshInventory();
						}

					}
				});

				JPanel inventoryCase = new JPanel();
				inventoryCase.add(X);
				inventoryCase.add(Y);
				inventory.add(inventoryCase);

				X.setBackground(new Color(196, 196, 196));
				X.setOpaque(true);
			}
		}
	}

	public int nbOccurence(Stuff i, ArrayList<Stuff> inventory) {
		int compteur = 0;
		for (Stuff j : inventory) {
			if (i.getInformation().getName().equals(j.getInformation().getName())) {

				if (isWeapon(i)) {
					if (((Weapon) i).getDamage() == ((Weapon) j).getDamage()) {
						compteur++;
					}
				}
				if (isArmor(i)) {
					if (((Armor) i).getArmorPoint() == ((Armor) j).getArmorPoint()) {
						compteur++;
					}
				}
				if (isPotion(i)) {
					if (((Potion) i).getLifePoint() == ((Potion) j).getLifePoint()) {
						compteur++;
					}
				}
				if (isQuestElement(i)) {
					compteur++;
				}
			}

		}
		return compteur;
	}

	public boolean isWeapon(Stuff theStuff) {
		if (theStuff instanceof Weapon) {
			return true;
		} else {
			return false;
		}
	}

	public boolean isQuestElement(Stuff theStuff) {
		if (theStuff instanceof QuestElement) {
			return true;
		} else {
			return false;
		}
	}

	public ArrayList<Stuff> Factorise(ArrayList<Stuff> inventory) {
		ArrayList<Stuff> factorisedList = new ArrayList<Stuff>();
		for (Stuff j : inventory) {
			if (nbOccurence(j, factorisedList) == 0) {
				factorisedList.add(j);
			}
		}
		return factorisedList;
	}

	public boolean isArmor(Stuff theStuff) {
		if (theStuff instanceof Armor) {
			return true;
		} else {
			return false;
		}
	}

	public boolean isPotion(Stuff theStuff) {
		if (theStuff instanceof Potion) {
			return true;
		} else {
			return false;
		}
	}

	public ImageIcon resyze(ImageIcon theImage, int height, int width) {
		java.awt.Image image = theImage.getImage();
		if (height > 0 && width > 0) {
			java.awt.Image newimg = image.getScaledInstance(height, width, java.awt.Image.SCALE_SMOOTH);// scale it the
																										// smooth way
			ImageIcon newImg1 = new ImageIcon(newimg);
			return newImg1;
		} else {
			return theImage;
		} // transform it back
	}

	public String associationImage(Stuff theStuff) {
		String piImageIcon = null;
		String iconPic = null;

		if (isQuestElement(theStuff)) {
			iconPic = "/pictures/engrenage.jpg";
		}
		if (isWeapon(theStuff)) {
			Weapon myWeapon = new Weapon(theStuff.getInformation().getName(),
					theStuff.getInformation().getDescription(), ((Weapon) theStuff).getDamage());

			if ((myWeapon.getDamage() <= 3)) {
				iconPic = "/pictures/weapon1.jpg";

			} else if (myWeapon.getDamage() <= 5) {
				iconPic = "/pictures/weapon2.png";

			} else {
				iconPic = "/pictures/weapon3.png";

			}

		}
		if (isArmor(theStuff)) {
			Armor myArmor = new Armor(theStuff.getInformation().getName(), theStuff.getInformation().getDescription(),
					((Armor) theStuff).getArmorPoint());
			if (myArmor.getArmorPoint() <= 3) {
				iconPic = "/pictures/armor1.png";

			} else if (myArmor.getArmorPoint() <= 5) {
				iconPic = "/pictures/armor2.png";

			} else {
				iconPic = "/pictures/armor3.png";

			}
		}
		if (isPotion(theStuff)) {
			Potion myPotion = new Potion(theStuff.getInformation().getName(),
					theStuff.getInformation().getDescription(), ((Potion) theStuff).getLifePoint());
			if (myPotion.getLifePoint() <= 3) {
				iconPic = "/pictures/potion1.png";

			} else if (myPotion.getLifePoint() <= 5) {
				iconPic = "/pictures/potion2.png";

			} else {
				iconPic = "/pictures/potion3.png";

			}
		}
		if (theStuff.equals(null)) {
			iconPic = "/Pictures/void.jpg";
		}
		String filePath = System.getProperty("user.dir") + iconPic;
		// System.out.println(filePath);
		piImageIcon = filePath;
		return piImageIcon;
	}

	public String associationLabel(Stuff i) {
		String result = "";

		if (isQuestElement(i)) {
			QuestElement labelInfo0 = new QuestElement(i.getInformation().getName(),
					i.getInformation().getDescription());
			result = ("<html> Name:" + labelInfo0.getInformation().getName() + "<br> Description: "
					+ labelInfo0.getInformation().getDescription() + "</html>");
		}
		if (isWeapon(i)) {
			Weapon labelInfo = new Weapon(i.getInformation().getName(), i.getInformation().getDescription(),
					((Weapon) i).getDamage());
			result = ("<html> Name: " + labelInfo.getInformation().getName() + "<br> Dammage: " + labelInfo.getDamage()
					+ "<br> Description: " + labelInfo.getInformation().getDescription() + "</html>");
			return (result);
		}
		if (isArmor(i)) {
			Armor labelInfo1 = new Armor(i.getInformation().getName(), i.getInformation().getDescription(),
					((Armor) i).getArmorPoint());
			result = ("<html> Name: " + labelInfo1.getInformation().getName() + " <br>Armor Points: "
					+ labelInfo1.getArmorPoint() + "<br> Description: " + labelInfo1.getInformation().getDescription()
					+ "</html>");
			return (result);
		}
		if (isPotion(i)) {
			Potion labelInfo2 = new Potion(i.getInformation().getName(), i.getInformation().getDescription(),
					((Potion) i).getLifePoint());
			result = (" Name: " + labelInfo2.getInformation().getName() + " Dammage: " + labelInfo2.getLifePoint()
					+ " Description: " + labelInfo2.getInformation().getDescription());
			return (result);
		}
		return (result);
	}

	public void refreshInventory() {
		remove(lbl1);
		remove(lbl2);
		remove(inventory);
		remove(equipedInventory);

		generateInventory();
		inventory.revalidate();
		equipedInventory.revalidate();

	}
}
