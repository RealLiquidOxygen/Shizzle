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
import java.io.File;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;

/**
 *
 * @author owoye001
 */
public class Tutorial extends javax.swing.JFrame {
    
    //variable declaration for gui objects
    private JLabel backgroundpicture = new JLabel();
    private final JLabel progLabel = new JLabel();
    private final JLabel tutoriallabel = new JLabel();
    private JButton continues = new JButton ();

    /**
     * Creates new form Tutorial
     * @param ap
     */
    
    //class constructor. 
    public Tutorial(String ap) {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize(); //get the screen size for the screen application is suppose to run on
        
        //changes the default look and feel to Nimbus look and feel
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            //java.util.logging.Logger.getLogger(ChatRoom.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        initComponents();
        setSize(screenSize);
        getContentPane().setBackground(Color.white);
        
        //tutoriallabel.setOpaque(true);
        //tutoriallabel.setBackground(Color.white);
        
        //Adjusting the size of each GUI component here to fit screen sizes
        tutoriallabel.setSize(1166*(int)screenSize.getWidth()/1366, 600 * (int)screenSize.getHeight()/768);
        tutoriallabel.setLocation(100* (int)screenSize.getWidth()/1366, 120 * (int)screenSize.getHeight()/768);
        backgroundpicture.setSize(screenSize);
        
        //load the gif images required for the tutorial screen here
        try {
            String soundbutt;
            String path;
            //String soundname = PropertyCreator.BackgroundImage;
            File f = new File(System.getProperty("java.class.path"));
            File dir = f.getAbsoluteFile().getParentFile();
            path = dir.toString();
            //soundbutt = soundname;
            
            //String location = path + "\\Colorings\\" + soundbutt;
            String tut = path + "\\Colorings\\" + "tutorial.gif";
            
            //ImageIcon icon = new ImageIcon(String.valueOf(location));  
            ImageIcon tutor = new ImageIcon(String.valueOf(tut));
            
            //Image img = icon.getImage(); 
            Image imttut = tutor.getImage();
            
            //Image newimg = img.getScaledInstance(backgroundpicture.getWidth(), backgroundpicture.getHeight(),  java.awt.Image.SCALE_SMOOTH);
            Image imttutreal = imttut.getScaledInstance (tutoriallabel.getWidth(), tutoriallabel.getHeight(),java.awt.Image.SCALE_SMOOTH);
            
            //icon = new ImageIcon(newimg);
            tutor = new ImageIcon(imttut);
            //backgroundpicture.setIcon(icon);
           // backgroundpicture.setText(null);
            tutoriallabel.setText(null);
            tutoriallabel.setIcon(tutor);
            //getContentPane().add(backgroundpicture,1,0); //it is covering everything//
            getContentPane().add(tutoriallabel,2,0);
        } catch (Exception ex) {
          // ex.printStackTrace();
        }
        //getContentPane().add(backgroundpicture,1,0); //it is covering everything
        
        //variable initialization using the PropertyCreator class
        progLabel.setFont(new java.awt.Font("Comic Sans MS", 3, 60)); // NOI18N
        progLabel.setText("Shizzle  - Tutorials");
        progLabel.setSize(1200 * (int) screenSize.getWidth() / 1366, 101 * (int) screenSize.getHeight() / 768);
        progLabel.setBackground(PropertyCreator.FormBackgroundColor);
        progLabel.setForeground(PropertyCreator.ProgramNameColor);
        progLabel.setLocation(25,10);
        getContentPane().add(progLabel,2,0);
        
        
        continues.setBackground(PropertyCreator.OtherButtonBackColor);
        continues.setForeground(PropertyCreator.OtherButtonForeColor);
        continues.setSize (250 * (int)screenSize.getWidth()/1366,150 * (int)screenSize.getHeight()/768);
        continues.setFont(new java.awt.Font("Comic Sans MS", 3, 24));
        
        
         if (Main.ChkUserdata()==true && ap.contains("start"))
        {
        continues.setText("Continue");
        }
        else if (ap.contains("main") && Main.ChkUserdata()==true || Main.ChkUserdata()==false)
        {
            continues.setText("Close");
        }
        continues.setLocation (1050 * (int)screenSize.getWidth()/1366, 50 * (int)screenSize.getHeight()/768);
        continues.addActionListener((java.awt.event.ActionEvent evt) -> {
            if (Main.ChkUserdata()==true && ap.contains("start"))
            {
            playsound();
            waiting();
            dispose();
            MainMenu mains = new MainMenu();
            mains.setVisible(true); 
            donedone();
            }
            else if (ap.contains("main") && Main.ChkUserdata()==true || Main.ChkUserdata()==false)
            {
                playsound();
                dispose();
            }
        });
        
        getContentPane().add(continues, 2,0);
    }
    
    //this method plays the button sound
     public static void playsound() {
        if (MainMenu.SoundOk == true) {
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
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

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
            java.util.logging.Logger.getLogger(Tutorial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Tutorial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Tutorial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Tutorial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                //new Tutorial().setVisible(true);
            }
        });
    }
    
    //this methods changes the cursors.
    public final void waiting() {

        this.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
    }

    public final void donedone() {
        this.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
