/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Shizzle;

import jaco.mp3.player.MP3Player;
import java.awt.event.ActionEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import javax.swing.Timer;

/**
 *
 * @author owoye001
 */
public class Main {
    
    //this portion of the coe starts the application 
    private static boolean FirstTimeLauncher; //this variable check if this is the first time your are running the application. 
    public static MP3Player bb = new MP3Player(); //sound plugin
    static Timer sound; 
    public static String IPAddress = "127.0.0.1"; //I don't know maybe I used this.
    //public static Timer timer;
    /**
     */
    
    //this method plays the game soundtrack
    public static void playsound() {
         if (MainMenu.MusicOk==true) { //MusicOk check whether music option is turned on in the setting for the program 
            String soundbutt;
            String path;
            {
                //this loads the sound track from the sound folder in application folder
                String soundname = "massive.mp3";
                File f = new File(System.getProperty("java.class.path"));
                File dir = f.getAbsoluteFile().getParentFile();
                path = dir.toString();
                soundbutt = "\\Sounds\\" + soundname;
                bb = new MP3Player(new File(path + soundbutt));
                bb.play(); //this actually plays the mp3 file for massic attact
                //System.out.println ("This is dir: " + path+soundbutt );
            }
        }
    }
    
    //this is the main method. THe program begins here. 
    public static void main(String[] args){
       //FlashScreen flash = new FlashScreen();
        loadIPFile(); //loads IP ADDRESS.
        FirstTimeLauncher = ChkUserdata();
        sound = new Timer (29500, (ActionEvent ae) -> {
            playsound();
        });
        sound.stop();
        
        //this decides whether to launch the tutorials or not on first load. 
        if (FirstTimeLauncher ==true)
        {
            Tutorial tutor = new Tutorial("start");
            tutor.setVisible(true);
        }
        else
        {
            MainMenu mains = new MainMenu();
            mains.setVisible(true); 
        }
        //playsound();
        
        
        //sound.start();
        

       // Games game = new Games();
        //SaveGame larry = new SaveGame(); FOR CREATING GAMEPLAY FILE
       
        //PropertyCreator profiles = new PropertyCreator(); for creating profiles.
        
        //Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
       

        //flash.setVisible(true);
        

        

    }
    
    //load settings file into memory. This file contains the server ip address. 
    //This makes it easier to patch the program in case the server ip address changes.
    //Change the ip address in Setting.gmp, if server ip address of the program changes. 
    public static void loadIPFile()
    {
        try {
            String soundbutt;
            String path;
            String soundname = "Settings.gmp";
            File f = new File(System.getProperty("java.class.path"));
            File dir = f.getAbsoluteFile().getParentFile();
            path = dir.toString();
            soundbutt = soundname;
            File varTmpDir = new File(path + "\\" + soundbutt);
            boolean exists = varTmpDir.exists();
            if (exists == true) {
                //read the contnet
                try (BufferedReader br = new BufferedReader(new FileReader(varTmpDir))) {
                    String line;
                    while ((line = br.readLine()) != null) {
                       // process the line.
                        IPAddress = line; //get Ip address
                        //System.out.println(IPAddress);
                    }
                }
            } else
            {
                
            }
        } catch (Exception e) {
        }

    }
    
    //this method checks whether a file called MyHighSchores.gmp is already loaded into memory.
    //decides whether tutorial comes up on first load
    public static boolean ChkUserdata() {
  
        try {
            String soundbutt;
            String path;
            String soundname = "MyHighScores.gmp";
            File f = new File(System.getProperty("java.class.path"));
            File dir = f.getAbsoluteFile().getParentFile();
            path = dir.toString();
            soundbutt = soundname;
            File varTmpDir = new File(path + "\\" + soundbutt);
            boolean exists = varTmpDir.exists();
            if (exists == true) {
                return false;
            }
        } catch (Exception e) {
        }

        return true;
    }

}
