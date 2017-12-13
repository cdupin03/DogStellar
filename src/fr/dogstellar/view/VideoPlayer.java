package fr.dogstellar.view;

import java.awt.*;
import java.awt.event.*;
import java.io.File;
import javax.swing.*;
import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;


/**
 * This class allows to display a video, and when the video is finished, this
 * display disappears
 *
 * @author Group 3
 * @version V05
 */
public class VideoPlayer implements ActionListener {

    private JFrame window;
    private JFXPanel jfxPanel;
    private Media media;
    private MediaPlayer player;
    private MediaView mediaView;
    private BorderPane borderPane;
    private Scene scene;
    private File file;
    private String nameVideo;
    private String nameJFrame;
    private String picturePath = System.getProperty("user.dir") + "/videos/";
    private JButton skip;
    private Timer timer;

    /**
     * The constructeur of the class to get back the video, the time of the
     * video and the title of the JFrame
     *
     * @param thisVideo is the video to play
     * @param newTime is the time of the video
     * @param title is the title of the JFrame
     */
    public VideoPlayer(String thisVideo, int newTime, String title) {
        nameVideo = thisVideo;                                                  //Choose the video
        nameJFrame = title;                                                     //Choose the name of the JFrame
        timer = new Timer(newTime + 1000, this);                                //The timer is set to the time of video plus one second, allows to close the JFrame
        timer.start();                                                          //The start of the counter + 1 seconde to aoid an early end
        file = new File(picturePath + nameVideo);                               //Instanciate the file with the path and the name of the file
        Platform.setImplicitExit(false);                                        //The platform that allows a graphical video view cannot be closed, so we can play another video after 
        initGUI();                                                              //Call the initGUI that buit the JFrame
    }

    private void initGUI() {
        window = new JFrame();                                                  //The main Frame 
        window.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);            //Set the action of the window when we click on the exit button
        window.setLayout(new BorderLayout());                                   //Set the Layout of the JFrame

        showVideo();                                                            //Call the showVideo function that create the media display and add it in the JFrame

        //
        window.setPreferredSize(new Dimension(1200, 700));                      //The size of the panel jPanel1 that contains the media player
        window.setTitle(nameJFrame);                                            //Set the title of the Jframe
        window.pack();                                                          //Sizes the frame so that all its contents are at or above their preferred sizes
        window.setLocationRelativeTo(null);                                     //The display on the JFrame is on center of the screen
        window.setVisible(true);                                                //To display the frame

        //The action of the skip button
        skip.addActionListener((ActionEvent e) -> {
            timer.stop();                                                       //Stop the timer
            player.stop();                                                      //Stop the video
            player = null;
            mediaView = null;
            scene = null;
            jfxPanel = null;                                                    //Destroy the JFxPanel
            borderPane = null;
            file = null;
            window.dispose();                                                   //Close the frame when we click on the skip button
        });

        //The action when we click on the JFrame exit Button (the same that the skip button)
        window.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                skip.doClick();
            }
        });
    }

    private void showVideo() {

        if (jfxPanel == null) //Instantiate the JFxPanel only if it not exists
        {
            jfxPanel = new JFXPanel();
        }

        Platform.runLater(() -> {                                               //We order to the application that manage the JFxPanel to execute
            media = new Media(file.toURI().toString());                         //Instanciation of the media with the file
            player = new MediaPlayer(media);                                    //Instanciation of the player with the media
            if (mediaView == null) //Create the display of the player only if it not exists
            {
                mediaView = new MediaView(player);
            }
            player.play();                                                      //Play the video
            borderPane = new BorderPane(mediaView);                             //Add the video into the BorderPane
            scene = new Scene(borderPane, 1200, 700);                           //Set the size of the player
            jfxPanel.setScene(scene);                                           //Include the player in the JFxPanel
        });

        skip = new JButton("SKIP");                                             //Instanciation of the skip button
        skip.setBackground(Color.BLACK);                                        //The background color button
        skip.setForeground(Color.WHITE);                                        //The font and the color of the skip button
        window.add(jfxPanel, BorderLayout.CENTER);                              //Add the media player in the JFrame
        window.add(skip, BorderLayout.SOUTH);                                   //Add the skip button in the JFrame
    }

    /**
     * When the time of the timer is finished or when the JFrame is closed, the
     * video stopped and the JFrame disappear (same action that the skip button)
     *
     * @param ae the action
     */
    @Override
    public void actionPerformed(ActionEvent ae) {
        skip.doClick();
    }
    
}