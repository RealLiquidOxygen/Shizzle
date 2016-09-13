/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Shizzle;

import jaco.mp3.player.MP3Player;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JScrollPane;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import java.util.Properties;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.Timer;

/**
 *
 * @author owoye001
 * handle the setting JFRAME for program settings 
 */
public class Settings extends javax.swing.JFrame {
    private final JLabel progLabel;
    private final JButton backButton;
    private final JButton applyButton;
    public static String profilename="GreenDeviant.gmc";
    private final JButton okButton;
    private final JScrollPane listScrollPane;
    public static JCheckBox Soundonoff;
    public static JCheckBox Musicoff;
    private static final String[] propertyNames = {"Green Deviance","Sky Lights", "Night Shade", "Purple Sensation"};
    private static final String[] propertyrealname = {"GreenDeviant.gmc","SkyLights.gmc","NightShade.gmc","PurpleSensation.gmc"};
    private final JList<String> proplist = new JList(propertyNames); //custumizer list
    public static PropertyCreator pc = new PropertyCreator();
    //private static final 
    /**
     * Creates new form Settings
     */
    public Settings() {
        //initialization setting of the code done here. 
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
        //___________________________________________________________________________
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        JLabel backgroundpicture = new javax.swing.JLabel();
        backgroundpicture.setSize(screenSize);
         try {
            String soundbutt;
            String path;
            String soundname = PropertyCreator.BackgroundImage;
            File f = new File(System.getProperty("java.class.path"));
            File dir = f.getAbsoluteFile().getParentFile();
            path = dir.toString();
            soundbutt = soundname;
            String location = path + "\\Colorings\\" + soundbutt;
            ImageIcon icon = new ImageIcon(String.valueOf(location));  
            Image img = icon.getImage(); 
            Image newimg = img.getScaledInstance(backgroundpicture.getWidth(), backgroundpicture.getHeight(),  java.awt.Image.SCALE_SMOOTH);
            icon = new ImageIcon(newimg);
            backgroundpicture.setIcon(icon);
            backgroundpicture.setText(null);
            add(backgroundpicture,1,0); //it is covering everything//
        } catch (Exception ex) {}
        initComponents();
        setSize(screenSize);
        setTitle("Shizzle");
        getContentPane().setBackground(Color.black);
        progLabel = new JLabel();
        backButton = new JButton();
        applyButton = new JButton ();
        JLabel jBackgroundtag = new JLabel();
        JLabel jSoundtag = new JLabel();
        Soundonoff = new JCheckBox("Turn sounds on");
        Musicoff = new JCheckBox ("Turn music on");
        proplist.setVisibleRowCount(4);
        proplist.setSelectionMode (ListSelectionModel.SINGLE_SELECTION);
        
        Soundonoff.setBackground(PropertyCreator.FormBackgroundColor);
        Soundonoff.setForeground(PropertyCreator.LabelTextForeColor);
        Musicoff.setBackground(PropertyCreator.FormBackgroundColor);
        Musicoff.setForeground(PropertyCreator.LabelTextForeColor);
        Soundonoff.setSize(360 * (int) screenSize.getWidth() / 1366, 50 * (int) screenSize.getHeight() / 768);
        Soundonoff.setLocation(80 * (int) screenSize.getWidth()/1366, 550 * (int) screenSize.getHeight()/768);
        Musicoff.setSize(360 * (int) screenSize.getWidth() / 1366, 50 * (int) screenSize.getHeight() / 768);
        Musicoff.setLocation(80 * (int) screenSize.getWidth()/1366, 620 * (int) screenSize.getHeight()/768);
        
        CheckBoxHandler handler = new CheckBoxHandler();
        Soundonoff.addItemListener(handler);
        Soundonoff.setFont(new java.awt.Font("Comic Sans MS", 0, 24)); 
        getContentPane().add(Soundonoff,2,0);
        
        Musicoff.addItemListener(handler);
        Musicoff.setFont(new java.awt.Font("Comic Sans MS", 0, 24)); 
        getContentPane().add(Musicoff,2,0);
        
        proplist.setBackground(PropertyCreator.ContentHolderBackColor);
        proplist.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        proplist.setFont(new java.awt.Font("Comic Sans MS", 1, 24)); // NOI18N
        proplist.setForeground(PropertyCreator.ContentHolderForeColor);
        
        listScrollPane = new JScrollPane(proplist);
        listScrollPane.setSize(1200 * (int) screenSize.getWidth() / 1366, 267 * (int) screenSize.getHeight() / 768);
        listScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        listScrollPane.setBackground(PropertyCreator.ContentHolderBackColor);
        listScrollPane.setForeground(PropertyCreator.ContentHolderForeColor);
        listScrollPane.setLocation (80 * (int) screenSize.getWidth()/1366, 220 * (int) screenSize.getHeight()/768);
        add (listScrollPane,2,0);
        
        jBackgroundtag.setFont(new java.awt.Font("Comic Sans MS", 0, 24)); // NOI18N
        jBackgroundtag.setSize(360 * (int) screenSize.getWidth() / 1366, 50 * (int) screenSize.getHeight() / 768);
        jBackgroundtag.setText("Profile Selections");
        jBackgroundtag.setLocation(80 * (int) screenSize.getWidth()/1366, 150 * (int) screenSize.getHeight()/768);
        jBackgroundtag.setBackground(PropertyCreator.FormBackgroundColor);
        jBackgroundtag.setForeground(PropertyCreator.LabelTextForeColor);
        getContentPane().add(jBackgroundtag, 2,0);
        
        jSoundtag.setFont(new java.awt.Font("Comic Sans MS", 0, 24)); // NOI18N
        jSoundtag.setSize(360 * (int) screenSize.getWidth() / 1366, 50 * (int) screenSize.getHeight() / 768);
        jSoundtag.setText("Sounds");
        jSoundtag.setLocation(80 * (int) screenSize.getWidth()/1366, 500 * (int) screenSize.getHeight()/768);
        jSoundtag.setBackground(PropertyCreator.FormBackgroundColor);
        jSoundtag.setForeground(PropertyCreator.LabelTextForeColor);
        getContentPane().add(jSoundtag, 2,0);
        
        okButton = new JButton();
        progLabel.setFont(new java.awt.Font("Comic Sans MS", 3, 56)); // NOI18N
        progLabel.setText("Shizzle - Settings");
        progLabel.setBackground(PropertyCreator.FormBackgroundColor);
        progLabel.setForeground(PropertyCreator.LabelTextForeColor);
        progLabel.setLocation(50 * (int) screenSize.getWidth() / 1366, 50 * (int) screenSize.getHeight() / 768);
        progLabel.setSize(900 * (int) screenSize.getWidth() / 1366, 101 * (int) screenSize.getHeight() / 768);
        add(progLabel,2,0);
        
        backButton.setBackground(PropertyCreator.OtherButtonBackColor);
        backButton.setSize(100 * (int)screenSize.getWidth()/1366, 50 * (int)screenSize.getHeight()/768);
        backButton.setForeground(PropertyCreator.OtherButtonForeColor);
        backButton.setText("Back");
        backButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                playsound();
                setVisible(false);
                //System.exit(0);
            }
        });
        applyButton.setBackground(PropertyCreator.OtherButtonBackColor);
        applyButton.setSize(100 * (int)screenSize.getWidth()/1366, 50 * (int)screenSize.getHeight()/768);
        applyButton.setForeground(PropertyCreator.OtherButtonForeColor);
        applyButton.setText("Accept");
        applyButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                playsound();
                waiting();
                if (!proplist.isSelectionEmpty())
                {
           int n = JOptionPane.showConfirmDialog(null, "For theme changes to take effect, the program needs to restart\nDo you want to continue?", "Shizzle - Theme Manager", JOptionPane.YES_NO_OPTION);

            if (n == JOptionPane.YES_OPTION) {
                    profilename=propertyrealname[proplist.getSelectedIndex()];
                    Properties table=new Properties();
                    PropertyCreator.loadProperties(table);
                    MyHighScores.savefile();
                    PropertyCreator.savefile();
                    try {
                    ChatRoom.client.sendUserData(new UserData(MainMenu.username,"",1));
                    } catch (Exception e) {}
                    JOptionPane.showMessageDialog(null, "Color Profile Changed");
                    JOptionPane.showMessageDialog(null, "Profile change will take effect on program restart");
                    Timer t = new Timer (700, new ActionListener()
                    {

                        @Override
                        public void actionPerformed(ActionEvent ae) {
                            System.exit(1);
                        }
                        
                    }
                    );
                    t.start();
                    
                    
            }else
            {
                donedone();
                 JOptionPane.showMessageDialog(null, "Current theme profile not changed","Shizzle",JOptionPane.INFORMATION_MESSAGE);
            }
                }
                else
                {
                   donedone();
                   playsound();
                   setVisible(false);
                }
                
            }
        });
        backButton.setLocation(1206*(int) screenSize.getWidth() / 1366,658 * (int)screenSize.getHeight()/768 );
        applyButton.setLocation(1086*(int) screenSize.getWidth() / 1366,658 * (int)screenSize.getHeight()/768 );
        add(applyButton,2,0);
        add(backButton,2,0);
    

    }
     static void startsoundtrack() {
                if (MainMenu.MusicOk==true)
                {
                Main.sound.stop(); //TImers
                Main.bb.stop();
                Main.sound.start();
                Main.playsound();
                }
                else if (MainMenu.MusicOk==false)
                {
                 Main.sound.stop(); //TImers
                 Main.bb.stop(); //player
                }
            }
    public static void playsound() {
        if (MainMenu.SoundOk == true) {
            String soundbutt;
            String path;
            {
                String soundname = "button.mp3";
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
        setUndecorated(true);
        getContentPane().setLayout(null);

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Settings.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Settings.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Settings.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Settings.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Settings().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables

    private class CheckBoxHandler implements ItemListener {

        public CheckBoxHandler() {
        }

        @Override
        public void itemStateChanged(ItemEvent ie) {
            if (ie.getSource()== Soundonoff)
            {
            MainMenu.SoundOk = Soundonoff.isSelected();
            //startsoundtrack();
            }
            if (ie.getSource() == Musicoff)
            {
            MainMenu.MusicOk = Musicoff.isSelected();
            startsoundtrack();
            }
        }
    }
     public void waiting()
    {
        
        this.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
    }
    public void donedone()
    {
        this.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
    }
}
