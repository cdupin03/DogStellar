package fr.dogstellar.view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.*;
import java.io.File;
import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javax.swing.*;

/**
 *This class allows to display a video, and when the video is finished, this display disappears
 * 
 * @author Group 3
 * @version V01
 */
public class VideoPlayer extends JFrame implements ActionListener {

    private final JFXPanel jfxPanel = new JFXPanel();
    private final JPanel jPanel1 = new JPanel();
    private String picturePath;
    private File file;
    private String nameVideo;
    private MediaPlayer oracleVid;

    /**
     * The JFrame of the video contain the MediaPlayer created in the createScene method
     */
    public VideoPlayer(String thisVideo) {
        picturePath = picturePath = System.getProperty("user.dir") + "/videos/";        //The path of the video
        Timer timer = new Timer(39000, this);                                                       //The timer is set to the time of video plus one second, allows to close the JFrame
        timer.start();                                                                              //The start of the conter
        createScene();                                                                              //This method allows to create the media player
        nameVideo = thisVideo;
        file = new File(picturePath + nameVideo);

        setTitle("DogStellar : the beginning");
        setResizable(false);                                                                        //This JFrame is not resizable
        
        jPanel1.setPreferredSize(new Dimension(1200, 700));                                         //The size of the panel jPanel1 that contains the media player
        jPanel1.setLayout(new BorderLayout());                                                      //The Layout of the panel
        jPanel1.add(jfxPanel, BorderLayout.CENTER);                                                 //The media player is add to the panel

        this.addWindowListener(new WindowAdapter(){
            public void windowClosing(WindowEvent e){
                oracleVid.stop();                                                           //With any action (closing the frame or when the video is finished) the video is stoped
                dispose();                                                             //Closing the frame
            }
        });
        
        
        this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);                                  //Closing the frame not the application
        this.add(jPanel1);                                                                          //The panel is add to the JFrame
        this.pack();                                                                                //Sizes the frame so that all its contents are at or above their preferred sizes
        this.setLocationRelativeTo(null);                                                           //The display on the JFrame is on center of the screen
        this.setVisible(true);                                                                      //To display the frame
    }

    /**
     * This method allows to create the display of the video
     */
    private void createScene() {
        Platform.runLater(() -> {
            oracleVid = new MediaPlayer(new Media(file.toURI().toString()));
            
            //Initialise the JFXPanel with the scene inside
            jfxPanel.setScene(new Scene(new Group(new MediaView(oracleVid))));
            
            oracleVid.setVolume(0.7);                                               //Set the volume of the audio video
            oracleVid.play();                                                       //To play the video
        });
    }

    /**
     * When the time of the timer is finished or when the JFrame is closed, the video stopped and the JFrame disappear
     * @param ae the action
     */
    @Override
    public void actionPerformed(ActionEvent ae) {
        oracleVid.stop();                                                           //With any action (closing the frame or when the video is finished) the video is stoped
        this.dispose();                                                             //Closing the frame
    }
}
