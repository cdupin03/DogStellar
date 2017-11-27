/*
 * 
 * //Je ne vois pas comment incruster la console développé par ALex pour l'instant puisqu'il ne passe pas par des JPanel et qu'il la draw direct...
 * 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.dogstellar.view;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener; //pour ajouter une action lors de la pression de la touche entrée par exemple 
import javax.swing.*;
import javax.swing.JTextArea;


/**
 *
 * @author Albenss
 */
public class Console
{
    private JFrame myFrame = new JFrame();              //The JFrame for the display
    private JButton ok = new JButton();                 //Ok button to validate an entry
    private JPanel theConsolePanel = new JPanel();      //JPanel global for the console
    private JPanel display = new JPanel();              //Contain the display
    private JPanel write = new JPanel();                //Contain the area to write
    private JTextArea displayMessage = new JTextArea(); //An area to display text
    private JTextField areaToWrite = new JTextField();  //An area to write text
    private String answer;                              //The last answer that is write
    
    /**
     * The constructor
    */
    public Console() 
    {
        myFrame.add(theConsolePanel);
        myFrame.setSize(600,400);
        //Full screen size
        //myFrame.setDefaultLookAndFeelDecorated(true);
        //myFrame.setExtendedState(Frame.MAXIMIZED_BOTH);
        
        theConsolePanel.setLayout(new BorderLayout());
        theConsolePanel.add(display, BorderLayout.NORTH);
        theConsolePanel.add(write, BorderLayout.SOUTH); 
        
        display.add(displayMessage);
        
        write.setLayout(new BorderLayout());
        write.add(areaToWrite, BorderLayout.WEST);
        write.add(ok, BorderLayout.EAST);
        
        ok.setText("OK");
        ok.setForeground(Color.black);
        ok.setSize(50,30);
        ok.setFont(new java.awt.Font(Font.SERIF,Font.BOLD,16));
        
        areaToWrite.setPreferredSize(new Dimension(520,30));
        areaToWrite.setFont(new Font(Font.SERIF,Font.PLAIN,18));
        
        displayMessage.setPreferredSize(new Dimension(580,300));
        
        myFrame.setTitle("The Console Interface");// Titre
        myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        myFrame.setVisible(true);

        ok.addActionListener(new ActionListener ()
        {
            public void actionPerformed (ActionEvent e){
                answer = areaToWrite.getText();
                areaToWrite.setText("");
                addMessageToConsole(answer);
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
        Console test = new Console();
        test.addMessageToConsole("Welcome on our game !");
    }
    
}
