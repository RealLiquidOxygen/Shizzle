/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Shizzle;



import jaco.mp3.player.MP3Player;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.io.File;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author owoye001
 */
public class PasswordCheck extends javax.swing.JFrame {
    private final JLabel progLabel;
    public static Boolean AccessGranted=false;
    private final JLabel playeronlinename;
    private final JTextField playeronlinenametext;
    private final javax.swing.JLabel passwordlabel;
    private javax.swing.JPasswordField passwordfield ;
    private final JButton AcceptButton;
    private final JButton BackButton;
    private Boolean ResetPassword =false;
    private final JButton resetPassword;
    private static  javax.swing.JLabel backgroundpicture;
    /**
     * Creates new form FlashScreen
     * @param we
     */
    public PasswordCheck(String we) {
        //look and feel code
        backgroundpicture = new JLabel();
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
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
        setLayout(null);
        setSize(screenSize);
        getContentPane().setBackground(PropertyCreator.FormBackgroundColor);
        backgroundpicture.setSize(screenSize);
        //------------------------------------------------------------------------
        //load the background this screen 
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
            getContentPane().add(backgroundpicture,1,0); //it is covering everything//
        } catch (Exception ex) {
           ex.printStackTrace();
        } 
        
        //variables initiations 
        progLabel = new javax.swing.JLabel();
        progLabel.setFont(new java.awt.Font("Comic Sans MS", 3, 60)); // NOI18N
        progLabel.setText("Shizzle  - Enter Password ");
        progLabel.setSize(1200 * (int) screenSize.getWidth() / 1366, 101 * (int) screenSize.getHeight() / 768);
        progLabel.setBackground(PropertyCreator.FormBackgroundColor);
        progLabel.setForeground(PropertyCreator.ProgramNameColor);
        progLabel.setLocation(25,10);
        getContentPane().add(progLabel,2,0);
        
        
        playeronlinename = new javax.swing.JLabel("Online Username: ");
        playeronlinenametext = new javax.swing.JTextField();
        passwordlabel = new javax.swing.JLabel("Password: ");
        passwordfield = new javax.swing.JPasswordField();
        
        AcceptButton = new javax.swing.JButton("Enter");
        BackButton = new javax.swing.JButton("Back");
        resetPassword = new javax.swing.JButton("Reset");
        
        playeronlinenametext.setText(MainMenu.username);
        passwordfield.setText("");
        
        AcceptButton.setBackground(PropertyCreator.OtherButtonBackColor);
        AcceptButton.setForeground(PropertyCreator.OtherButtonForeColor);
        resetPassword.setBackground(PropertyCreator.OtherButtonBackColor);
        resetPassword.setForeground(PropertyCreator.OtherButtonForeColor);
        
        BackButton.setBackground(PropertyCreator.OtherButtonBackColor);
        BackButton.setForeground(PropertyCreator.OtherButtonForeColor);
        
        AcceptButton.setSize(150* (int)screenSize.getWidth()/1366, 50 * (int)screenSize.getHeight()/768);
        BackButton.setSize(150* (int) screenSize.getWidth()/1366, 50 * (int) screenSize.getHeight()/768);
        resetPassword.setSize(150* (int)screenSize.getWidth()/1366, 50 * (int) screenSize.getHeight()/768);
        
        AcceptButton.setLocation(740* (int)screenSize.getWidth()/1366, 450* (int)screenSize.getHeight()/768);
        BackButton.setLocation(580* (int)screenSize.getWidth()/1366, 450* (int)screenSize.getHeight()/768);
        resetPassword.setLocation(430* (int)screenSize.getWidth()/1366, 450* (int)screenSize.getHeight()/768);
        
        resetPassword.addActionListener((ActionEvent ae) -> {
            waiting();
            //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            if (we.contentEquals("chat"))
            {
                JOptionPane.showMessageDialog(null, "Answer password security questions to change password", "Shizzle",JOptionPane.INFORMATION_MESSAGE);
                new Registration(2,"chat").setVisible(true);
                donedone();
            }
            else if (we.contentEquals("play"))            
            {
                JOptionPane.showMessageDialog(null, "Answer password security questions to change password", "Shizzle",JOptionPane.INFORMATION_MESSAGE);
                new Registration (2, "play").setVisible(true);
                donedone();
            }
            donedone();
            setVisible(false);
        });
        
        AcceptButton.addActionListener((java.awt.event.ActionEvent evt) -> {
            playsound();
            waiting();
            if (passwordfield.getText().length()!=0 && (String.valueOf(passwordfield.getPassword())).contentEquals(MainMenu.password) &&
                    playeronlinenametext.getText().length()!=0 && (String.valueOf(playeronlinenametext.getText())).contentEquals(MainMenu.username)){
                AccessGranted = true;
                MainMenu.AccessGranted=true;
                JOptionPane.showMessageDialog(null, "Access Granted!", "Shizzle - User Verification", JOptionPane.INFORMATION_MESSAGE);
                switch (we) {
                    case "chat":
                        Client.cg=new ChatRoom();
                        Client.sg =new OnlinePlay();
                        Client.sg.setVisible(false);
                        Client.cg.setVisible(true);
                        MainMenu.chatcontrol=true;
                        MainMenu.onlinecontrol=true;
                        break;
                    case "play":
                        Client.cg = new ChatRoom();
                        Client.sg = new OnlinePlay();
                        Client.cg.setVisible(false);
                        Client.sg.setVisible(true);
                        MainMenu.onlinecontrol=true;
                        MainMenu.chatcontrol = true;
                        break;
                }
                
                setVisible(false);
                donedone();
            } else
            {
                donedone();
                JOptionPane.showMessageDialog(null, "Incorrect password", "Shizzle - User Verification", JOptionPane.INFORMATION_MESSAGE);
            }
        });
        BackButton.addActionListener((java.awt.event.ActionEvent evt) -> {
            waiting();
            playsound();
            setVisible(false);
            donedone();
        });
        
        
        add(AcceptButton, 2,0);
        add(BackButton, 2,0);
        add(resetPassword,2,0);
        
       
        playeronlinename.setBackground(PropertyCreator.FormBackgroundColor);
        playeronlinename.setForeground(PropertyCreator.LabelTextForeColor);
        playeronlinename.setFont(new java.awt.Font("Comic Sans MS", 0, 24)); // NOI18N
        getContentPane().add(playeronlinename, 2,0);

        
        passwordlabel.setBackground(PropertyCreator.FormBackgroundColor);
        passwordlabel.setForeground(PropertyCreator.LabelTextForeColor);
        passwordlabel.setFont(new java.awt.Font("Comic Sans MS", 0, 24)); // NOI18N
        getContentPane().add(passwordlabel, 2,0);
        
        playeronlinenametext.setBackground(PropertyCreator.ContentHolderBackColor);
        passwordfield.setBackground(PropertyCreator.ContentHolderBackColor);
        playeronlinenametext.setFont(new java.awt.Font("Comic Sans MS", 0, 22));
        passwordfield.setFont(new java.awt.Font("Comic Sans MS", 0, 22));
        
        playeronlinenametext.setForeground(PropertyCreator.ContentHolderForeColor);
        passwordfield.setForeground(PropertyCreator.ContentHolderForeColor);
        
        playeronlinenametext.setCaretColor(PropertyCreator.ContentHolderForeColor);
        passwordfield.setCaretColor(PropertyCreator.ContentHolderForeColor);
        
        playeronlinename.setSize(300 * (int) screenSize.getWidth() / 1366, 50 * (int) screenSize.getHeight() / 768);
        playeronlinenametext.setSize(240 * (int)screenSize.getWidth()/1366, 50 * (int) screenSize.getHeight()/768);
        passwordlabel.setSize(300 * (int) screenSize.getWidth() / 1366, 50 * (int) screenSize.getHeight() / 768);
        passwordfield.setSize(240 * (int)screenSize.getWidth()/1366, 50 * (int) screenSize.getHeight()/768);
        passwordfield.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                if (evt.getKeyCode() == evt.VK_ENTER) {
                    waiting();
                    AcceptButton.doClick();
                    donedone();
                }
            }
        });
        
        playeronlinename.setLocation(440 * (int)screenSize.getWidth()/1366, 300 * (int) screenSize.getHeight()/768);
        playeronlinenametext.setLocation(650 * (int)screenSize.getWidth()/1366, 300 * (int) screenSize.getHeight()/768);
        passwordlabel.setLocation(440 * (int)screenSize.getWidth()/1366, 380 * (int) screenSize.getHeight()/768);
        passwordfield.setLocation(650 * (int)screenSize.getWidth()/1366, 380 * (int) screenSize.getHeight()/768);
    
        getContentPane().add(playeronlinenametext, 2,0);
    getContentPane().add(passwordfield, 2,0);
    }

    
    //handles the click button sound
    public final void playsound ()
    {
        if (MainMenu.SoundOk==true) {
        String soundbutt;String path;
        {
           String soundname = "button.mp3";
        File f = new File(System.getProperty("java.class.path"));
        File dir = f.getAbsoluteFile().getParentFile();
        path = dir.toString();
        soundbutt ="\\Sounds\\" + soundname;
        new MP3Player(new File(path+soundbutt)).play(); 
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

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Shizzle");
        setBackground(new java.awt.Color(0, 0, 0));
        setIconImage(Toolkit.getDefaultToolkit().getImage(Registration.class.getResource("image.jpg")));
        setUndecorated(true);
        setResizable(false);
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
            java.util.logging.Logger.getLogger(PasswordCheck.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PasswordCheck.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PasswordCheck.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PasswordCheck.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                //new PasswordCheck("chat").setVisible(true);
            }
        });
    }
    
    //the method below this line changes the mouse cursor to waiting and default 
    public final void waiting()
    {
        
        this.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
    }
    public final void donedone()
    {
        this.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
