/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Shizzle;

import jaco.mp3.player.MP3Player;
import java.awt.Color;
import java.awt.Desktop;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.Timer;
import java.awt.Cursor;
import java.awt.event.ActionListener;
import javax.swing.JButton;

/**
 *
 * @author owoye001
 */
public class MainMenu extends javax.swing.JFrame {

    /**
     * Creates new form MainMenu
     */
    ImageIcon icon;
    public static String tfServer = Main.IPAddress;//"146.57.154.4"; //"146.57.153.1";
    public static boolean onlinecontrol = false;
    public static MainMenu b;
    public static boolean chatcontrol = false;
    public static boolean FirstTimeLaunch = true;
    public static boolean CheckSound = false;
    public static Settings st = new Settings();
    public static String username;
    public static String password;
    public static String answer1;
    public static String answer2;
    public static String answer3;
    public static MyHighScores bn = new MyHighScores();
    public static Tutorial tn = new Tutorial("main");
    public static boolean SoundOk = CheckSound;
    public static boolean MusicOk;
    private static javax.swing.JLabel backgroundpictures;
    public static Boolean AccessGranted = false;
   

    private javax.swing.JLabel progLabel;
    private javax.swing.JButton Exit;
    private javax.swing.JButton practiceMode;
    private javax.swing.JButton facebook;
    private javax.swing.JButton previousopp;
    private javax.swing.JButton About;
    public static javax.swing.JLabel usernamelabel;
    private javax.swing.JButton donate;
    private javax.swing.JButton mybest;
    private javax.swing.JButton settings;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton tutorial;
    public Dimension screenSize;
    private JButton ponggame;
    static Process Runtime;
    

    public MainMenu() {
        this.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR)); //changes the cursor to wait curosr 
        initComponents();
        screenSize = Toolkit.getDefaultToolkit().getScreenSize(); //get the screen size of the cuurent screen 
        setSize(screenSize); //set the size of the current JFrame to screen size of the monitor 
        getContentPane().setBackground(PropertyCreator.FormBackgroundColor);

        FirstTimeLaunch = ChkUserdata();

        if (FirstTimeLaunch == false) {
            loadfileUserData();
        }

        //look and feel code
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            // java.util.logging.Logger.getLogger(ChatRoom.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        Settings.Soundonoff.setSelected(MainMenu.CheckSound);
        Settings.Musicoff.setSelected(MainMenu.MusicOk);
        
        pineapple(); //draw the background image
        
        progLabel = new javax.swing.JLabel();
        Exit = new javax.swing.JButton();
        practiceMode = new javax.swing.JButton();
        facebook = new javax.swing.JButton();
        previousopp = new javax.swing.JButton();
        About = new javax.swing.JButton();
        usernamelabel = new javax.swing.JLabel();
        donate = new javax.swing.JButton();
        mybest = new javax.swing.JButton();
        settings = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        tutorial = new javax.swing.JButton();
        ponggame = new javax.swing.JButton();

        progLabel.setFont(new java.awt.Font("Comic Sans MS", 3, 72)); // NOI18N
        progLabel.setText("Shizzle");
        progLabel.setSize(496 * (int) screenSize.getWidth() / 1366, 176 * (int) screenSize.getHeight() / 768);
        progLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                if (evt.getClickCount() == 5) {
                    playsound();
                    SaveGame saver = new SaveGame();
                }
            }
        });
        
        tutorial.setBackground(new java.awt.Color(204, 204, 255));
        tutorial.setFont(new java.awt.Font("Comic Sans MS", 0, 36)); // NOI18N
        tutorial.setForeground(new java.awt.Color(255, 255, 255));
        tutorial.setText("See Tutorial");
        tutorial.setToolTipText("Click this button to view tutorials");
        tutorial.addActionListener((java.awt.event.ActionEvent evt) -> {
            playsound();
            waiting();
            tn.setVisible(true);
            donedone();
        });

        Exit.setBackground(new java.awt.Color(153, 0, 153));
        Exit.setFont(new java.awt.Font("Comic Sans MS", 0, 36)); // NOI18N
        Exit.setForeground(new java.awt.Color(255, 255, 255));
        Exit.setText("X");
        Exit.setToolTipText("Click to exit the program");
        Exit.addActionListener((java.awt.event.ActionEvent evt) -> {
            playsound("goodbye.mp3");
            MyHighScores.savefile();
            PropertyCreator.savefile();
            try {
                ChatRoom.client.sendUserData(new UserData(username, "", 1));
            } catch (Exception e) {
            }
            Timer exiter;
            exiter = new Timer(500, (ActionEvent e) -> {
                System.exit(0);
            });
            exiter.setRepeats(false);
            exiter.start();
        });
        
        
        practiceMode.setBackground(new java.awt.Color(255, 204, 255));
        practiceMode.setFont(new java.awt.Font("Comic Sans MS", 0, 36)); // NOI18N
        practiceMode.setForeground(new java.awt.Color(255, 255, 255));
        practiceMode.setText("Practice Mode");
        practiceMode.setToolTipText("Click to enter practice mode");
        practiceMode.addActionListener((java.awt.event.ActionEvent evt) -> {
            playsound();
            waiting();
            Game_1.gamenum = -1;
            Game_1.type = -1;
            Game_1 game = new Game_1();
            game.setVisible(true);
            game.AwarePanel.revalidate();
            donedone();
        });

        facebook.setBackground(new java.awt.Color(204, 0, 204));
        facebook.setFont(new java.awt.Font("Comic Sans MS", 0, 36)); // NOI18N
        facebook.setForeground(new java.awt.Color(255, 255, 255));
        facebook.setText("Chat Room");
        facebook.setToolTipText("Click this button to chat with friends");
        facebook.addActionListener((java.awt.event.ActionEvent evt) -> {
            playsound();
            waiting();
            if (FirstTimeLaunch == true) {
                Registration reg = new Registration("chat");
                reg.setVisible(true);
                donedone();
                return;
            }
            if (AccessGranted == false) {
                new PasswordCheck("chat").setVisible(true);
                donedone();
                return;
            }
            
            if (chatcontrol == true && (ChatRoom.connected == false && OnlinePlay.connected == false) && AccessGranted == true) {
                Client.cg = new ChatRoom();
                Client.sg = new OnlinePlay();
                Client.sg.setVisible(false);
                Client.cg.setVisible(true);
            } else if (chatcontrol == true && (ChatRoom.connected == true && OnlinePlay.connected == true) && AccessGranted == true) {
                Client.cg.setVisible(true);
            }
            donedone();
        });

        previousopp.setBackground(new java.awt.Color(255, 0, 153));
        previousopp.setFont(new java.awt.Font("Comic Sans MS", 0, 36)); // NOI18N
        previousopp.setForeground(new java.awt.Color(255, 255, 255));
        previousopp.setText("Online Play");
        previousopp.setToolTipText("Click this button to play with friends online");
        previousopp.addActionListener((java.awt.event.ActionEvent evt) -> {
            playsound();
            waiting();
            if (FirstTimeLaunch == true) {
                Registration reg = new Registration("play");
                reg.setVisible(true);
                donedone();
                //setVisible(false);
                return;
            }
            if (AccessGranted == false) {
                new PasswordCheck("play").setVisible(true);
                donedone();
                return;
            }
            
            if (onlinecontrol == true && (ChatRoom.connected == false && OnlinePlay.connected == false) && AccessGranted == true) {
                Client.cg = new ChatRoom();
                Client.sg = new OnlinePlay();
                Client.cg.setVisible(false);
                Client.sg.setVisible(true);
            } else if (onlinecontrol == true && (ChatRoom.connected == true && OnlinePlay.connected == true) && AccessGranted == true) {
                Client.sg.setVisible(true);
            }
            donedone();
        });

        About.setBackground(new java.awt.Color(0, 102, 204));
        About.setFont(new java.awt.Font("Comic Sans MS", 0, 36)); // NOI18N
        About.setForeground(new java.awt.Color(255, 255, 255));
        About.setText("About");
        About.setToolTipText("Click this button to see the about page");
        About.addActionListener((java.awt.event.ActionEvent evt) -> {
            playsound();
            JOptionPane.showMessageDialog(null, "Author: Ayodele Owoyele\nCredits: "
                    + "Free SFX for Sound effects."
                    + "\n               Dreamincode.net for help with server code"
                    + "\n               Reed Williams For Ideas"
                    + "\n               Tear drops soundtrack from Massive Attack"
                    + "\n               Please click the donate button on the main page to donate! Thanks");
        });
        
         ponggame.setBackground(About.getBackground());
        ponggame.setFont(new java.awt.Font("Comic Sans MS", 0, 36)); // NOI18N
        ponggame.setForeground(Color.white);
        ponggame.setText("Fury Game");
        ponggame.setToolTipText("Click this button to load balls of fury");
        ponggame.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                playsound();
                waiting();
                String soundbutt;
            String path;
            
                File f = new File(System.getProperty("java.class.path"));
                File dir = f.getAbsoluteFile().getParentFile();
                path = dir.toString();
                soundbutt = "\\Pong\\PingPongGame.jar";
            
                String filePath = path + soundbutt; //where your jar is located.
                try {
                    Desktop.getDesktop().open(new File(filePath));
                } catch (IOException ex) {
                    //Logger.getLogger(MainMenu.class.getName()).log(Level.SEVERE, null, ex);
                }
                donedone();
            }
        });

        usernamelabel.setFont(new java.awt.Font("Comic Sans MS", 1, 18)); // NOI18N
        usernamelabel.setToolTipText("");
        usernamelabel.setSize(370 * (int) screenSize.getWidth() / 1366, 41 * (int) screenSize.getHeight() / 768);

        donate.setBackground(new java.awt.Color(153, 0, 255));
        donate.setFont(new java.awt.Font("Comic Sans MS", 0, 36)); // NOI18N
        donate.setForeground(new java.awt.Color(255, 255, 255));
        donate.setText("Donate");
        donate.setToolTipText("Click this button to support the project");
        donate.addActionListener((java.awt.event.ActionEvent evt) -> {
            playsound();
            waiting();
            Desktop desktop = java.awt.Desktop.getDesktop();
            try {
                final URI uri = new URI("https://www.paypal.com/cgi-bin/webscr?cmd=_s-xclick&hosted_button_id=ZR7U4VYC3ZWVW");
                Desktop.getDesktop().browse(uri);
            } catch (URISyntaxException | IOException ex) {
            }
            donedone();
        });

        mybest.setBackground(new java.awt.Color(204, 204, 255));
        mybest.setFont(new java.awt.Font("Comic Sans MS", 0, 36)); // NOI18N
        mybest.setForeground(new java.awt.Color(255, 255, 255));
        mybest.setText("My Best");
        mybest.setToolTipText("Click this button to view your best scores offline");
        mybest.addActionListener((java.awt.event.ActionEvent evt) -> {
            playsound();
            waiting();
            bn.setVisible(true);
            donedone();
        });

        settings.setBackground(new java.awt.Color(153, 0, 255));
        settings.setFont(new java.awt.Font("Comic Sans MS", 0, 36)); // NOI18N
        settings.setForeground(new java.awt.Color(255, 255, 255));
        settings.setText("Settings");
        settings.setToolTipText("Click this button to change preferences");
        settings.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                playsound();
                waiting();
                st.setVisible(true);
                donedone();
            }
        });

        jButton1.setBackground(new java.awt.Color(204, 204, 255));
        jButton1.setFont(new java.awt.Font("Comic Sans MS", 0, 24)); // NOI18N
        jButton1.setText("_");
        jButton1.setToolTipText("Minimize");
        jButton1.addActionListener((java.awt.event.ActionEvent evt) -> {
            playsound();
            setState(MainMenu.ICONIFIED);
        });

        
        progLabel.setLocation(15, 10);
        Exit.setToolTipText("Click to exit");
        Exit.setLocation(1290 * (int) screenSize.getWidth() / 1366, 80 * (int) screenSize.getHeight() / 768);
        About.setLocation(1090 * (int) screenSize.getWidth() / 1366, 670 * (int) screenSize.getHeight() / 768);
        ponggame.setLocation(810 * (int) screenSize.getWidth() / 1366, 670 * (int) screenSize.getHeight() / 768);
        facebook.setLocation(450 * (int) screenSize.getWidth() / 1366, 190 * (int) screenSize.getHeight() / 768);
        practiceMode.setLocation(80 * (int) screenSize.getWidth() / 1366, 190 * (int) screenSize.getHeight() / 768);
        previousopp.setLocation(80 * (int) screenSize.getWidth() / 1366, 400 * (int) screenSize.getHeight() / 768);
        mybest.setLocation(450 * (int) screenSize.getWidth() / 1366, 400 * (int) screenSize.getHeight() / 768);
        tutorial.setLocation(810 * (int)screenSize.getWidth()/1366, 400 * (int)screenSize.getHeight()/768);
        donate.setLocation(80 * (int) screenSize.getWidth() / 1366, 670 * (int) screenSize.getHeight() / 768);
        settings.setLocation(810 * (int) screenSize.getWidth() / 1366, 190 * (int) screenSize.getHeight() / 768);
        
        
        jButton1.setSize(70 * (int) screenSize.getWidth() / 1366, 50 * (int) screenSize.getHeight() / 768);
        jButton1.setLocation(1210 * (int) screenSize.getWidth() / 1366, 80 * (int) screenSize.getHeight() / 768);

        Exit.setSize(70 * (int) screenSize.getWidth() / 1366, 50 * (int) screenSize.getHeight() / 768);
        About.setSize(260 * (int) screenSize.getWidth() / 1366, 87 * (int) screenSize.getHeight() / 768);
        ponggame.setSize(260 * (int) screenSize.getWidth() / 1366, 87 * (int) screenSize.getHeight() / 768);
        facebook.setSize(314 * (int) screenSize.getWidth() / 1366, 170 * (int) screenSize.getHeight() / 768);
        practiceMode.setSize(320 * (int) screenSize.getWidth() / 1366, 170 * (int) screenSize.getHeight() / 768);
        previousopp.setSize(320 * (int) screenSize.getWidth() / 1366, 170 * (int) screenSize.getHeight() / 768);
        mybest.setSize(320 * (int) screenSize.getWidth() / 1366, 170 * (int) screenSize.getHeight() / 768);
        donate.setSize(260 * (int) screenSize.getWidth() / 1366, 80 * (int) screenSize.getHeight() / 768);
        settings.setSize(314 * (int) screenSize.getWidth() / 1366, 170 * (int) screenSize.getHeight() / 768);
        tutorial.setSize(314 * (int) screenSize.getWidth() / 1366, 170 * (int) screenSize.getHeight() / 768);
        
        Exit.setBackground(PropertyCreator.ExitBackColor);
        About.setBackground(PropertyCreator.AboutBackColor);
        ponggame.setBackground(PropertyCreator.AboutBackColor);
        facebook.setBackground(PropertyCreator.ChatRoomBackColor);
        tutorial.setBackground (Color.white);
        practiceMode.setBackground(PropertyCreator.PracticeBackColor);
        previousopp.setBackground(PropertyCreator.OnlinePlayBackColor);
        mybest.setBackground(PropertyCreator.MyBestBackColor);
        donate.setBackground(PropertyCreator.DonateBackColor);
        settings.setBackground(PropertyCreator.SettingsBackColor);

        Exit.setForeground(PropertyCreator.ExitForeColor);
        About.setForeground(PropertyCreator.AboutForeColor);
        facebook.setForeground(PropertyCreator.ChatRoomForeColor);
        practiceMode.setForeground(PropertyCreator.PracticeForeColor);
        previousopp.setForeground(PropertyCreator.OnlinePlayForeColor);
        mybest.setForeground(PropertyCreator.MyBestForeColor);
        donate.setForeground(PropertyCreator.DonateForeColor);
        settings.setForeground(PropertyCreator.SettingsForeColor);
        tutorial.setForeground(Color.black);
        
        progLabel.setBackground(PropertyCreator.FormBackgroundColor);
        progLabel.setForeground(PropertyCreator.ProgramNameColor);
        usernamelabel.setBackground(PropertyCreator.FormBackgroundColor);
        usernamelabel.setForeground(PropertyCreator.UsernameForeColor);
        usernamelabel.setLocation(1100 * (int) screenSize.getWidth() / 1366, 610 * (int) screenSize.getHeight() / 768);

        //usernamelabel.setText(username);
        //adding all components here
        add(jButton1, 2, 0);
        add(settings, 2, 0);
        add(mybest, 2, 0);
        add(donate, 2, 0);
        add(usernamelabel, 2, 0);
        add(About, 2, 0);
        add(ponggame,2,0);
        add(previousopp, 2, 0);
        add(facebook, 2, 0);
        add(practiceMode, 2, 0);
        add(Exit, 2, 0);
        add(progLabel, 2, 0);
        add(tutorial,2,0);

        tn.setVisible(false);
        bn.setVisible(false);
        st.setVisible(false);
        MyHighScores.loadfile();
        MyHighScores.UpdateList();
        playsound("welcome.mp3");
        startsoundtrack();
        donedone();
    }

    //plays the game sound track
   static void startsoundtrack() {
                if (MainMenu.SoundOk==true)
                {
                Main.sound.start();
                //Main.playsound();
                }
                else
                 {
                 Main.sound.stop(); //TImers
                 Main.bb.stop(); //player
                }
            }
    public static void playsound(String soundname) {
        if (MainMenu.SoundOk == true) {
            String soundbutt;
            String path;
            {
                File f = new File(System.getProperty("java.class.path"));
                File dir = f.getAbsoluteFile().getParentFile();
                path = dir.toString();
                soundbutt = "\\Sounds\\" + soundname;
                new MP3Player(new File(path + soundbutt)).play();
                //System.out.println ("This is dir: " + path+soundbutt );
            }
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Shizzle");
        setFont(new java.awt.Font("Comic Sans MS", 1, 48)); // NOI18N
        setIconImage(Toolkit.getDefaultToolkit().getImage(MainMenu.class.getResource("image.jpg")));
        setUndecorated(true);
        getContentPane().setLayout(null);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    //play a click sound when any button is clicked 
    public static void playsound() {
        if (SoundOk == true) {
            String soundbutt;
            String path;
            {
                File f = new File(System.getProperty("java.class.path"));
                File dir = f.getAbsoluteFile().getParentFile();
                path = dir.toString();
                soundbutt = "\\Sounds\\button.mp3";
                new MP3Player(new File(path + soundbutt)).play();
                //System.out.println ("This is dir: " + path+soundbutt );
            }
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            //java.util.logging.Logger.getLogger(MainMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new MainMenu().setVisible(true);
        });

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
   //load the UserProfileData.upd. 
    public static void loadfileUserData() {
        String soundbutt;
        String path;
        {
            String soundname = "UserProfileData.upd";
            File f = new File(System.getProperty("java.class.path"));
            File dir = f.getAbsoluteFile().getParentFile();
            path = dir.toString();
            soundbutt = soundname;
            //System.out.println ("This is dir: " + path+soundbutt );
        }
        try {
            FileInputStream fis = new FileInputStream(path + "\\" + soundbutt);
            ObjectInputStream ois = new ObjectInputStream(fis);
            List<String> userprofiledata = (List<String>) ois.readObject();
            username = userprofiledata.get(0);
            password = userprofiledata.get(1);
            answer1 = userprofiledata.get(2);
            answer2 = userprofiledata.get(3);
            answer3 = userprofiledata.get(4);
            MainMenu.FirstTimeLaunch = false;
            ois.close();
        } catch (Exception e) {
        }
    }
    
    //change the cursor to waiting cursor 

    public final void waiting() {

        this.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
    }

    
    //change the cursor to default cursor 
    public final void donedone() {
        this.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
    }

    //check whether the user profile data exists 
    public static boolean ChkUserdata() {

        try {
            String soundbutt;
            String path;
            String soundname = "UserProfileData.upd";
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

    //changes the background of the application 
    private void pineapple() {
        backgroundpictures = new javax.swing.JLabel();
        backgroundpictures.setSize(screenSize);
        try {
            String soundbutt;
            String path;
            String soundname = PropertyCreator.BackgroundImage;
            File f = new File(System.getProperty("java.class.path"));
            File dir = f.getAbsoluteFile().getParentFile();
            path = dir.toString();
            soundbutt = soundname;
            String location = path + "\\Colorings\\" + soundbutt;
            icon = new ImageIcon(String.valueOf(location));
            Image img = icon.getImage();
            Image newimg = img.getScaledInstance(backgroundpictures.getWidth(), backgroundpictures.getHeight(), java.awt.Image.SCALE_SMOOTH);
            icon = new ImageIcon(newimg);
            backgroundpictures.setIcon(icon);
            backgroundpictures.setText(null);
            add(backgroundpictures, 1, 0);
        } catch (Exception ex) {
            //ex.printStackTrace();
        }
        
    }
}
