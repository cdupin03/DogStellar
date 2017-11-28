/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.dogstellar.view;

import fr.dogstellar.core.AreaPlanet;
import fr.dogstellar.core.Element;
import fr.dogstellar.core.Perso;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 *
 * @author Albenss
 */
public class Interface 
{
    private final JFrame theInterface = new JFrame();
    private final JPanel console = new JPanel();
    private final JPanel console1 = new JPanel();
    private final JPanel top = new JPanel();
    private final JPanel bottom = new JPanel();
    private final JButton ok = new JButton();                 //Ok button to validate an entry
    private final JPanel theConsolePanel = new JPanel();      //JPanel global for the console
    private final JPanel display = new JPanel();              //Contain the display
    private final JPanel write = new JPanel();                //Contain the area to write
    private final JTextArea displayMessage = new JTextArea(); //An area to display text
    private JTextField areaToWrite = new JTextField();  //An area to write text
    private String answer;                              //The last answer that is write
    
    
    public Interface()
    {
        console.add(theConsolePanel);
        console.setLayout(new FlowLayout());
        console.setPreferredSize(new Dimension(400,200));
        
        console.setLayout(new BorderLayout());
        console.add(display, BorderLayout.CENTER);
        console.add(write, BorderLayout.SOUTH); 
        
        display.add(displayMessage);
        
        write.setLayout(new BorderLayout());
        write.add(areaToWrite, BorderLayout.WEST);
        write.add(ok, BorderLayout.EAST);
        
        ok.setText("OK");
        ok.setForeground(Color.black);
        ok.setSize(50,30);
        ok.setFont(new java.awt.Font(Font.SERIF,Font.BOLD,16));
        
        areaToWrite.setPreferredSize(new Dimension(340,30));
        areaToWrite.setFont(new Font(Font.SERIF,Font.PLAIN,18));
        
        displayMessage.setPreferredSize(new Dimension(400,150));
        
        AreaPlanet test1 = new AreaPlanet("tyuiuyfv","rdytfuygiut", "champ.jpg");
        test1.addPerso(new Perso("Monstre", 10, 5));
        test1.addPerso(new Perso("Monstre2", 5, 2));
        test1.addElement(new Element("Coffre", "Petit coffre", 1));
        test1.addElement(new Element("Enigme", "Une enigme", 4));
        
        AreaPlanet test2 = new AreaPlanet("Bqzld","rdytfiut", "lave.jpg");
        test1.addAreaPlanet(test2, "south");
        
        Window theWindow = new Window(test1, theInterface);
        top.setLayout(new BorderLayout());
        top.add(theWindow, BorderLayout.CENTER);
        
        //bottom.setLayout(new GridLayout(1,2));
        //bottom.add();
        bottom.setLayout(new BorderLayout());
        bottom.add(console1, BorderLayout.CENTER);
        bottom.add(console, BorderLayout.EAST);
        
        
        theInterface.setLayout(new FlowLayout());
        theInterface.setPreferredSize(new Dimension(1200,700));
        theInterface.setLayout(new BorderLayout());
        theInterface.add(top, BorderLayout.CENTER);
        theInterface.add(bottom, BorderLayout.SOUTH);
        theInterface.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        theInterface.pack();
        theInterface.setVisible(true);

        ok.addActionListener(new ActionListener ()
        {
            public void actionPerformed (ActionEvent e){
                answer = areaToWrite.getText();
                areaToWrite.setText("");
                addMessageToConsole(answer);
            }
        });
        
        areaToWrite.addActionListener(new ActionListener ()
        {
            public void actionPerformed(ActionEvent e) 
            {
                if(e.getSource() == areaToWrite) 
                {
                    ok.doClick(0); //if we press the key "enter", we have the same response that when we click on OK button
                }
            }
        });
        
    }
    
    
    /**
     * Add a message to the console
     * @param theString is the string to add
    */
    public void addMessageToConsole(String theString)
    {
        displayMessage.append("> " + theString + "\n" );    //We add the string in parameter
    }
    
    /**
     * The getter of the attribute answer
    */
    public String getAnswer()
    {
        answer.toUpperCase();
        return answer;
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        Interface test = new Interface();
        test.addMessageToConsole("Welcome on our game !");
    }
    
}
