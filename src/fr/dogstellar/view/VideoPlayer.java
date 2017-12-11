package fr.dogstellar.view;

import java.awt.*;
import java.awt.event.*;
import java.io.File;
import javax.swing.*;
import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;

/**
 * This class allows to display a video, and when the video is finished, this
 * display disappears
 *
 * @author Group 3
 * @version V03
 */
public class VideoPlayer implements ActionListener {

    private JFrame theFrame = new JFrame();                                     //The main Frame
    private JFXPanel jfxPanel = new JFXPanel();                           //The container of the media player
    private JPanel jPanel1 = new JPanel();                                //The Panel that contains the media player container
    private MediaPlayer mediaPlayer;                                            //The media player
    private Timer timer;                                                  //The timer that allows to close the Frame after the end of the video

    private String picturePath;                                                 //The folder of the video
    private String nameVideo;
    private File file;

    /**
     * The JFrame of the video contain the MediaPlayer created in the
     * createMediaView method
     *
     * @param thisVideo
     * @param newTime
     */
    public VideoPlayer(String thisVideo,int newTime, String title) {
        picturePath = System.getProperty("user.dir") + "/videos/";              //The path of the video
        timer = new Timer(newTime, this);                                       //The timer is set to the time of video plus one second, allows to close the JFrame
        timer.start();                                                          //The start of the conter
        createMediaView();                                                      //This method allows to create the media player
        nameVideo = thisVideo;                                                  //The video to play
        file = new File(picturePath + nameVideo);                               //This JFrame is not resizable

        JButton skip = new JButton("SKIP");                                     //The button that allows to skip the video										//When this button is cliked, the video ends and the game starts
        skip.setBackground(Color.BLACK);                                        //The background color button
        skip.setForeground(Color.WHITE);                                        //The font and the color of the skip button

        jPanel1.setPreferredSize(new Dimension(1200, 700));                     //The size of the panel jPanel1 that contains the media player
        jPanel1.setLayout(new BorderLayout());                                  //The Layout of the panel
        jPanel1.add(jfxPanel, BorderLayout.CENTER);                             //The media player is add to the panel
        jPanel1.add(skip, BorderLayout.SOUTH);                                  //The skipbutton is add to the main panel

        skip.addActionListener((ActionEvent e) -> {
            timer.stop();
            theFrame.dispose();                                             //Close the frame when we click on the skip button
        });

        theFrame.setTitle(title);
        theFrame.setResizable(false);
        theFrame.add(jPanel1);
        theFrame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);          //Closing the frame not the application                                                              //The panel is add to the JFrame
        theFrame.pack();                                                        //Sizes the frame so that all its contents are at or above their preferred sizes
        theFrame.setLocationRelativeTo(null);                                   //The display on the JFrame is on center of the screen
        theFrame.setVisible(true);                                              //To display the frame
        
        theFrame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                skip.doClick(0);                                                //The same action that the skip button
            }
        });

    }

    /**
     * This method allows to create the display of the video
     */
    private void createMediaView() {
        Platform.runLater(() -> {
            //Media m = new Media(file.toURI().toString());                       //To create the media with the url of the file
            mediaPlayer = new MediaPlayer(new Media(file.toURI().toString()));                                   //To create the media player
            jfxPanel.setScene(new Scene(new Group(new MediaView(mediaPlayer))));//Initialise the JFXPanel with the media player inside
            mediaPlayer.setVolume(0.7);                                         //Set the volume of the audio video
            mediaPlayer.play();                                                 //To play the video
            System.out.println("Création d'un nouveau média player");
        });
    }

    /**
     * When the time of the timer is finished or when the JFrame is closed, the
     * video stopped and the JFrame disappear
     *
     * @param ae the action
     */
    @Override
    public void actionPerformed(ActionEvent ae) {
        timer.stop();
        mediaPlayer.stop();                                                           //With any action (closing the frame or when the video is finished) the video is stoped
        theFrame.dispose();                                                             //Closing the frame
    }
    
}
