package fr.dogstellar.view;

import java.awt.event.*;
import java.util.ArrayList;
import java.awt.*;
import javax.swing.*;

import fr.dogstellar.core.*;

/**
 * The InventoryPanel allows to create a JFrame to display the player inventory
 *
 * @author Group 3
 * @version V04
 */
public final class InventoryPanel extends JFrame {

    private final int gridCaseHeight1 = ((150) / (2));                                        // The heght of a equiped item grid
    private final int gridCaseWidth1 = ((87) / (2));                                         // The heght of a equiped item grid
    private final int gridCaseHeight = ((150) / (2));                                        // The heght of inventory item grid
    private final int gridCaseWidth = ((87) / (2));                                         // The heght of inventory item grid
    private final Player thePlayer;                                             // The owner of the inventory
    private JPanel inventory;                                                   // Jpanel containing all unequiped objects
    private JPanel equipedInventory;                                            // Jpanel containing the equiped objects 
    private final JLabel lbl1 = new JLabel("Equiped items");                                  // The name of the top part of the inventory
    private final JLabel lbl2 = new JLabel("Your Inventory");                                 // The name of the botom part of the inventory

    /**
     * The constructor of the class, take a player in parameter to set his
     * inventory
     *
     * @param thePlayer is the player choose to see inventory
     */
    public InventoryPanel(Player thePlayer) {
        // TODO Auto-generated constructor stub
        this.setLayout(new GridLayout(0, 2, 20, 20));
        this.thePlayer = thePlayer;
        generateInventory();
        this.setTitle("Inventory");                                             //The name of the JFrame
        this.setSize(600, 600);
        this.setResizable(false);

        this.getContentPane().setBackground(new Color(99, 162, 168));
        this.pack();
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    /**
     * This method generate the player inventory
     */
    public void generateInventory() {

        // test si le joueur à un équipement + creation du label "Equiped item"
        String picturePath = System.getProperty("user.dir") + "/pictures/";

        equipedInventory = new JPanel();
        equipedInventory.setLayout(new GridLayout(0, 2, 15, 15));
        equipedInventory.setOpaque(false);

        this.add(lbl1);
        lbl1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl1.setForeground(Color.white);
        lbl1.setFont(new Font("Blippo", Font.PLAIN, 28));
        this.add(equipedInventory);

        // Creation of the equipment Jpanel
        //test if the player has no equiped armor 
        if (!thePlayer.hasArmor()) {
            ImageIcon theImage1 = new ImageIcon(picturePath + "void.jpg");                  // set the default image 

            theImage1 = resyze(theImage1, gridCaseHeight1, gridCaseWidth1);                 //resize the image
            JButton equipedArmor = new JButton(theImage1);                                  //create a new JButton
            equipedArmor.setOpaque(false);
            equipedArmor.setContentAreaFilled(false);
            equipedArmor.setBorderPainted(false);
            equipedInventory.add(equipedArmor);                                             //add the Jbutton to the JPanel 
            StartGame.getInterf().getDisplay().refreshDisplay();
            equipedArmor.setToolTipText("There is no item equiped on this slot");           //set the tooltiptext
        } //if the player have an equiped weapon
        else {
            ImageIcon theImage1 = new ImageIcon(associationImage(thePlayer.getArmorEquip()));//generate the image path corresponding to the weapon 

            theImage1 = resyze(theImage1, gridCaseHeight1, gridCaseWidth1);                 //resize the image 
            JButton equipedArmor = new JButton(theImage1);                                  //create a JButton
            equipedArmor.setOpaque(false);
            equipedArmor.setContentAreaFilled(false);
            equipedArmor.setBorderPainted(false);
            equipedInventory.add(equipedArmor);                                             //add the button to the JPanel
            equipedArmor.setToolTipText(associationLabel(thePlayer.getArmorEquip()));       //set the corresponding tooltiptext

            //the action listener to unequip a weapon 
            equipedArmor.addActionListener(new ActionListener() {

                @Override
                public void actionPerformed(ActionEvent e) {
                    // TODO Auto-generated method stub
                    if (thePlayer.hasArmor()) {

                        thePlayer.desequipArmor();                                          //remove the armor
                        refreshInventory();                                                 // refresh the inventory
                        StartGame.getInterf().getDisplay().refreshDisplay();
                    }

                }
            });
        }
        // comportment if the player has no weapon equiped 
        if (!thePlayer.hasWeapon()) {
            ImageIcon theImage2 = new ImageIcon(picturePath + "void.jpg");                  // load a default image

            theImage2 = resyze(theImage2, gridCaseHeight1, gridCaseWidth1);                 //resize the image
            JButton equipedWeapon = new JButton(theImage2);                                 //put the image in a button
            equipedWeapon.setOpaque(false);
            equipedWeapon.setContentAreaFilled(false);
            equipedWeapon.setBorderPainted(false);
            equipedInventory.add(equipedWeapon);                                            //add the button to the panel
            StartGame.getInterf().getDisplay().refreshDisplay();

            equipedWeapon.setToolTipText("There is no equiped item on this slot");          // set is tooltiptext
        } //if the player has a equiped weapon
        else {
            ImageIcon theImage2 = new ImageIcon(associationImage(thePlayer.getWeaponEquip()));//associate the good image corresponding to the weapon equiped

            theImage2 = resyze(theImage2, gridCaseHeight1, gridCaseWidth1);                 //resize the image 
            JButton equipedWeapon = new JButton(theImage2);                                 //create a JButton with this image
            equipedWeapon.setOpaque(false);
            equipedWeapon.setContentAreaFilled(false);
            equipedWeapon.setBorderPainted(false);
            equipedInventory.add(equipedWeapon);                                            //add tje JButton to the JPanel

            equipedWeapon.setToolTipText(associationLabel(thePlayer.getWeaponEquip()));     //set the right tooltiptext
            System.out.println("Weapon =" + thePlayer.hasArmor());
            //action listener to unequip the weapon
            equipedWeapon.addActionListener((ActionEvent e) -> {
                // TODO Auto-generated method stub
                if (thePlayer.hasWeapon()) {
                    thePlayer.desequipWeapon();                                             //remove the weapon
                    refreshInventory();                                                     //refresh the inventoy
                    StartGame.getInterf().getDisplay().refreshDisplay();
                }
            });
        }

        // test if the inventory is empty
        // creating the panel and the label for each item
        inventory = new JPanel();
        inventory.setOpaque(false);
        inventory.setBackground(new Color(99,162,168));

        lbl2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl2.setFont(new Font("Blippo", Font.PLAIN, 28));
        lbl2.setForeground(Color.white);
        this.add(lbl2);
        this.add(inventory);
        // check if the inventory is empty
        if (thePlayer.getStuff().isEmpty() == false) {
            ArrayList<Stuff> stuffs = Factorise(thePlayer.getStuff());                      //create a list with only one occurence of each item 
            int j = stuffs.size();                                                          // the size of the facotrised list 

            // creating a grid to put the items
            GridLayout Disposition = new GridLayout(j /3+ j%3, 3);
            inventory.setLayout(Disposition);

            System.out.println(j);

            // variables of the size of each item case
            if (j < 3) {
                int gridCaseHeight = ((150) / (j / 1));
                int gridCaseWidth = ((87) / (j / 1));
            } else {
                int gridCaseHeight = ((150) / (j / 3));
                int gridCaseWidth = ((87) / (j / 3));
            }

            // foreach item of the list if it is different of the one who is equiped
            stuffs.stream().map((i) -> {
                ImageIcon theImage = new ImageIcon(associationImage(i));                    //affecting the good image
                theImage = resyze(theImage, gridCaseHeight, gridCaseWidth);                 // resize the image
                JButton X = new JButton(theImage);                                          //create a button with the image inside
                X.setToolTipText(associationLabel(i));                                      // set a tooltiptext with the items informations
                X.setOpaque(false);
                
                JLabel Y = new JLabel(":" + nbOccurence(i, thePlayer.getStuff()));          // affect the value of the number of the item in the inventory
                Y.setForeground(Color.white);
                //the action listener to equip an item or take a potion
                X.addActionListener((ActionEvent e) -> {
                    //management for a weapon
                    if (isWeapon(i)) {
                        if (thePlayer.hasWeapon()) {

                            thePlayer.desequipWeapon();
                        }
                        thePlayer.addWeaponEquip((Weapon) i);
                        thePlayer.getStuff().remove(i);
                        refreshInventory();
                    }
                    //management for a armor
                    if (isArmor(i)) {
                        if (thePlayer.hasArmor()) {
                            thePlayer.desequipArmor();
                        }
                        thePlayer.addArmorEquip((Armor) i);
                        thePlayer.getStuff().remove(i);
                        refreshInventory();
                    }
                    //management for a potion
                    if (isPotion(i)) {
                        ((Potion) i).drinkPotion(thePlayer);
                        thePlayer.getStuff().remove(i);
                        refreshInventory();
                        StartGame.getInterf().getDisplay().refreshDisplay();
                    }
                });
                JPanel inventoryCase = new JPanel();
                inventoryCase.setLayout(new GridLayout(0,2));
                inventoryCase.add(X);
                inventoryCase.add(Y);
                inventoryCase.setBackground(new Color(90,162,168));
                inventory.add(inventoryCase);
                X.setBackground(new Color(196, 196, 196));
                return X;
            }).forEachOrdered((X) -> {
                X.setOpaque(false);
            });
        }
    }

    /**
     * This method compt the number of occurence in a list
     *
     * @param i = the stuff to search
     * @param inventory = the list where the item is looked for
     * @return compteur = the number of occurence of the item
     */
    public int nbOccurence(Stuff i, ArrayList<Stuff> inventory) {
        int compteur = 0;
        // browsing the list 
        for (Stuff j : inventory) {
            // compare the name of the item and it description to the items of the list if there is a match the program test the type of the stuff
            if (i.getInformation().getName().equals(j.getInformation().getName())) {
                // this test are for looked if the third parameter is the same from j and i ( two weapon with the same name, description but not the same damage where not identical)
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

    /**
     * Check if a stuff is a weapon
     *
     * @param theStuff = the Stuff to test
     * @return boolean = true if the item is a armor else false
     */
    public boolean isWeapon(Stuff theStuff) {
        return theStuff instanceof Weapon;
    }

    /**
     * Check if a stuff is a QuestElement
     *
     * @param theStuff = the Stuff to test
     * @return boolean true if the item is a QuestElement else false
     */
    public boolean isQuestElement(Stuff theStuff) {
        return theStuff instanceof QuestElement;
    }

    /**
     * This method take a list and return a list without dupplicate
     *
     * @param inventory = the list to test
     * @return factorised list = the treated list
     */
    public ArrayList<Stuff> Factorise(ArrayList<Stuff> inventory) {
        ArrayList<Stuff> factorisedList = new ArrayList<>();

        // test if the item is not already in the factorised list
        inventory.stream().filter((j) -> (nbOccurence(j, factorisedList) == 0)).forEachOrdered((j) -> {
            factorisedList.add(j);
        });
        return factorisedList;
    }

    /**
     * Check if a stuff is a armor
     *
     * @param theStuff = the Stuff to test
     * @return boolean true if the item is a armor else false
     */
    public boolean isArmor(Stuff theStuff) {
        return theStuff instanceof Armor;
    }

    /**
     * Check if a stuff is a potion
     *
     * @param theStuff = the Stuff to test
     * @return boolean true if the item is a potion else false
     */
    public boolean isPotion(Stuff theStuff) {
        return theStuff instanceof Potion;
    }

    /**
     * This method allow to resize an ImageIcon by returning a new one
     *
     * @param theImage = the input image
     * @param height = the heigth of the new image
     * @param width = the width of the new image
     * @return theImage is the resized image
     */
    public ImageIcon resyze(ImageIcon theImage, int height, int width) {
        java.awt.Image image = theImage.getImage();
        if (height > 0 && width > 0) {
            java.awt.Image newimg = image.getScaledInstance(height, width, java.awt.Image.SCALE_SMOOTH);// scale it the
            // smooth way
            ImageIcon newImg1 = new ImageIcon(newimg);
            return newImg1;
        } else {
            // transform it back
            return theImage;
        }
    }

    /**
     * Check the stuff type and return a string who correspond to the path file
     * of the image to load on the JButton
     *
     * @param theStuff = the stuff who need a path
     * @return filePath = the file path for the image
     */
    public String associationImage(Stuff theStuff) {
        String piImageIcon = null;
        String iconPic = null;
        // test if the stuff is a quest element
        if (isQuestElement(theStuff)) {
            iconPic = "/pictures/shipPiece.png"; // set the image for the quest element
        }
        //test if the stuff is a weapon 
        if (isWeapon(theStuff)) {
            Weapon myWeapon = new Weapon(theStuff.getInformation().getName(),
                    theStuff.getInformation().getDescription(), ((Weapon) theStuff).getDamage()); // create a weapon variable with the stuff attributes 
            //load the associate image in function of the damage of the weapon
            if ((myWeapon.getDamage() <= 3)) {
                iconPic = "/pictures/weapon1.png";

            } else if (myWeapon.getDamage() <= 5) {
                iconPic = "/pictures/weapon2.png";

            } else {
                iconPic = "/pictures/weapon3.png";

            }

        }
        //test if the stuff is an armor
        if (isArmor(theStuff)) {
            Armor myArmor = new Armor(theStuff.getInformation().getName(), theStuff.getInformation().getDescription(),
                    ((Armor) theStuff).getArmorPoint());// create an armor with the values of the stuff
            //associate the image name in function of the armor point of the stuff
            if (myArmor.getArmorPoint() <= 3) {
                iconPic = "/pictures/armor1.png";

            } else if (myArmor.getArmorPoint() <= 5) {
                iconPic = "/pictures/armor2.png";

            } else {
                iconPic = "/pictures/armor3.png";

            }
        }
        // check if the stuff is a potion
        if (isPotion(theStuff)) {
            Potion myPotion = new Potion(theStuff.getInformation().getName(),
                    theStuff.getInformation().getDescription(), ((Potion) theStuff).getLifePoint()); // create a potio variable with the information of the stuff
            //Associate the good image in function of the number of points earned by a potion take 
            if (myPotion.getLifePoint() <= 3) {
                iconPic = "/pictures/potion1.png";

            } else if (myPotion.getLifePoint() <= 5) {
                iconPic = "/pictures/potion2.png";

            } else {
                iconPic = "/pictures/potion3.png";

            }
        }

        String filePath = System.getProperty("user.dir") + iconPic; // take the path of the stuff picture
        // System.out.println(filePath);

        return filePath;
    }

    /**
     * The method who associate a string to a stuff
     *
     * @param i = stuff who need the label
     * @return result = the string corresponding to the stuff
     */
    public String associationLabel(Stuff i) {
        String result = "";
        //label if a stuff is a quest element
        if (isQuestElement(i)) {
            result = ("<html> Name:" + i.getInformation().getName() + "<br> Description: "
                    + i.getInformation().getDescription() + "</html>");
        }
        //label if a stuff is a weapon
        if (isWeapon(i)) {
            result = ("<html> Name: " + i.getInformation().getName() + "<br> Dammage: " + ((Weapon) i).getDamage()
                    + "<br> Description: " + i.getInformation().getDescription() + "</html>");
            return (result);
        }
        //label if a stuff is a armor
        if (isArmor(i)) {
            result = ("<html> Name: " + i.getInformation().getName() + " <br>Armor Points: "
                    + ((Armor) i).getArmorPoint() + "<br> Description: " + i.getInformation().getDescription()
                    + "</html>");
            return (result);
        }
        //label if a stuff is a potion 
        if (isPotion(i)) {
            result = (" Name: " + i.getInformation().getName() + " Earned HP: " + ((Potion) i).getLifePoint()
                    + " Description: " + i.getInformation().getDescription());
            return (result);
        }
        return (result);
    }

    /**
     * The method who allow to refresh the inventory (all the element of the
     * frame are droped and reloaded exept the player data
     */
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
