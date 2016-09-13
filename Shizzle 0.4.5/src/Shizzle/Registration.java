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
import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author owoye001
 * handles the user registration page 
 */
public class Registration extends javax.swing.JFrame {
    private JLabel backgroundpicture;
    private JLabel progLabel;
    private final JLabel playeronlinename;
    private final JTextField playeronlinenametext;
    private javax.swing.JLabel passwordlabel;
    private javax.swing.JPasswordField passwordfield ;
    private javax.swing.JLabel q1;
    private javax.swing.JLabel q2;
    private javax.swing.JLabel q3;
    private javax.swing.JTextField a1;
    private javax.swing.JTextField a2;
    private javax.swing.JTextField a3;
    private final JButton AcceptButton;
    private final JButton BackButton;

    /**
     * Creates new form FlashScreen
     * @param ba
     */
    public Registration(String ba) {
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
        //------------------------------------------------------------------------
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
            getContentPane().add(backgroundpicture,1,0); //it is covering everything//
        } catch (Exception ex) {
           //ex.printStackTrace();
        } 
        
        progLabel = new javax.swing.JLabel();
        progLabel.setFont(new java.awt.Font("Comic Sans MS", 3, 60)); // NOI18N
        progLabel.setText("Shizzle  - Online User Registration");
        progLabel.setSize(1200 * (int) screenSize.getWidth() / 1366, 101 * (int) screenSize.getHeight() / 768);
        progLabel.setBackground(PropertyCreator.FormBackgroundColor);
        progLabel.setForeground(PropertyCreator.ProgramNameColor);
        progLabel.setLocation(25,10);
        getContentPane().add(progLabel,2,0);
        
        
        playeronlinename = new javax.swing.JLabel("Desired Username: ");
        playeronlinenametext = new javax.swing.JTextField();
        passwordlabel = new javax.swing.JLabel("Password: ");
        passwordfield = new javax.swing.JPasswordField();
        
        q1 = new javax.swing.JLabel ("What is your favorite food?");
        q2 = new javax.swing.JLabel ("What is your best friend's name in high school?");
        q3 = new javax.swing.JLabel ("What is your favorite color?");
        
        a1= new javax.swing.JTextField();
        a2 = new javax.swing.JTextField();
        a3=new javax.swing.JTextField();
        
        AcceptButton = new javax.swing.JButton("Register");
        BackButton = new javax.swing.JButton("Back");
        
        AcceptButton.setBackground(PropertyCreator.OtherButtonBackColor);
        AcceptButton.setForeground(PropertyCreator.OtherButtonForeColor);
        
        BackButton.setBackground(PropertyCreator.OtherButtonBackColor);
        BackButton.setForeground(PropertyCreator.OtherButtonForeColor);
        
        AcceptButton.setSize(150* (int)screenSize.getWidth()/1366, 50 * (int)screenSize.getHeight()/768);
        BackButton.setSize(150* (int) screenSize.getWidth()/1366, 50 * (int) screenSize.getHeight()/768);
        
        AcceptButton.setLocation((int)screenSize.getWidth()-(int)AcceptButton.getWidth()-20, (int)screenSize.getHeight()-(int)AcceptButton.getHeight()-20);
        BackButton.setLocation((int)screenSize.getWidth()-(int)AcceptButton.getWidth()-(int)BackButton.getWidth()-20, (int)screenSize.getHeight()-(int)BackButton.getHeight()-20);
        
        AcceptButton.addActionListener(new java.awt.event.ActionListener() {
            
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                playsound();
                waiting();
                if (playeronlinenametext.getText().length()!=0 &&
                        passwordfield.getText().length()!=0 && 
                        a1.getText().length()!=0 && 
                        a2.getText().length()!=0 &&
                        a3.getText().length()!=0){
                JOptionPane.showMessageDialog(null, "You are now Registered. Thanks for being a user", "Shizzle - Registration", JOptionPane.INFORMATION_MESSAGE);
                RegisterButton();
                donedone();
                setVisible(false);
                } else
                {
                    JOptionPane.showMessageDialog(null, "Please complete the form - check your responses", "Shizzle - Registration", JOptionPane.INFORMATION_MESSAGE);
                }
            }
            
            private void RegisterButton() {
                List<String> userprofiledata = new ArrayList<String>();
                String onlineusername = String.valueOf(playeronlinenametext.getText());
                userprofiledata.add(onlineusername);
                String password = String.valueOf(passwordfield.getPassword());
                //JOptionPane.showMessageDialog(null, "Your password is: " + password);
                userprofiledata.add(password);
                String question1 = String.valueOf(a1.getText());
                userprofiledata.add(question1);
                String question2 = String.valueOf(a2.getText());
                userprofiledata.add (question2);
                String question3 = String.valueOf(a3.getText());
                userprofiledata.add(question3);
                try {
                FileOutputStream fos = new FileOutputStream("UserProfileData.upd");
                ObjectOutputStream oos = new ObjectOutputStream(fos);
                oos.writeObject(userprofiledata);
                MainMenu.FirstTimeLaunch=false;
                } catch (Exception e) {
                //JOptionPane.showMessageDialog(null, "Error");
                }
                MainMenu.AccessGranted=true;
                MainMenu.loadfileUserData(); //load saved file
                switch (ba) {
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
            }
        });
        BackButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                waiting();
                playsound();
                setVisible(false);
                donedone();
            }
        });
        
        
        add(AcceptButton, 2,0);
        add(BackButton, 2,0);
        
        a1.setBackground(PropertyCreator.ContentHolderBackColor);
        a2.setBackground(PropertyCreator.ContentHolderBackColor);
        a3.setBackground(PropertyCreator.ContentHolderBackColor);
        
        a1.setForeground(PropertyCreator.ContentHolderForeColor);
        a2.setForeground(PropertyCreator.ContentHolderForeColor);
        a3.setForeground(PropertyCreator.ContentHolderForeColor);
        
        a1.setCaretColor(PropertyCreator.ContentHolderForeColor);
        a2.setCaretColor(PropertyCreator.ContentHolderForeColor);
        a3.setCaretColor(PropertyCreator.ContentHolderForeColor);
        
        a1.setSize(300 * (int)screenSize.getWidth()/1366, 50 * (int) screenSize.getHeight()/768);
        a2.setSize(300 * (int)screenSize.getWidth()/1366, 50 * (int) screenSize.getHeight()/768);
        a3.setSize(300 * (int)screenSize.getWidth()/1366, 50 * (int) screenSize.getHeight()/768);
        
        a1.setLocation(670 * (int)screenSize.getWidth()/1366, 360 * (int) screenSize.getHeight()/768);
        a2.setLocation(670 * (int)screenSize.getWidth()/1366, 440 * (int) screenSize.getHeight()/768);
        a3.setLocation(670 * (int)screenSize.getWidth()/1366, 520 * (int) screenSize.getHeight()/768);
        
        a1.setFont(new java.awt.Font("Comic Sans MS", 0, 22));
        a2.setFont(new java.awt.Font("Comic Sans MS", 0, 22));
        a3.setFont(new java.awt.Font("Comic Sans MS", 0, 22));
        
        add(a1,2,0);
        add(a2,2,0);
        add(a3,2,0);
        
        q1.setBackground(PropertyCreator.FormBackgroundColor);
        q2.setBackground(PropertyCreator.FormBackgroundColor);
        q3.setBackground(PropertyCreator.FormBackgroundColor);
                
        q1.setForeground(PropertyCreator.LabelTextForeColor);
        q2.setForeground(PropertyCreator.LabelTextForeColor);
        q3.setForeground(PropertyCreator.LabelTextForeColor);
         
        q1.setSize(400 * (int) screenSize.getWidth() / 1366, 50 * (int) screenSize.getHeight() / 768);
        q2.setSize(600 * (int) screenSize.getWidth() / 1366, 50 * (int) screenSize.getHeight() / 768);
        q3.setSize(400 * (int) screenSize.getWidth() / 1366, 50 * (int) screenSize.getHeight() / 768);
         
        q1.setLocation(80 * (int)screenSize.getWidth()/1366, 360 * (int) screenSize.getHeight()/768);
        q2.setLocation(80 * (int)screenSize.getWidth()/1366, 440 * (int) screenSize.getHeight()/768);
        q3.setLocation(80 * (int)screenSize.getWidth()/1366, 520 * (int) screenSize.getHeight()/768);
        
        q1.setFont(new java.awt.Font("Comic Sans MS", 0, 24));
        q2.setFont(new java.awt.Font("Comic Sans MS", 0, 24));
        q3.setFont(new java.awt.Font("Comic Sans MS", 0, 24));
        
        add(q1,2,0);
        add(q2,2,0);
        add(q3,2,0);
        
        
        
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
        playeronlinenametext.setSize(300 * (int)screenSize.getWidth()/1366, 50 * (int) screenSize.getHeight()/768);
        passwordlabel.setSize(300 * (int) screenSize.getWidth() / 1366, 50 * (int) screenSize.getHeight() / 768);
        passwordfield.setSize(300 * (int)screenSize.getWidth()/1366, 50 * (int) screenSize.getHeight()/768);
        
        playeronlinename.setLocation(80 * (int)screenSize.getWidth()/1366, 200 * (int) screenSize.getHeight()/768);
        playeronlinenametext.setLocation(670 * (int)screenSize.getWidth()/1366, 200 * (int) screenSize.getHeight()/768);
        passwordlabel.setLocation(80 * (int)screenSize.getWidth()/1366, 280 * (int) screenSize.getHeight()/768);
        passwordfield.setLocation(670 * (int)screenSize.getWidth()/1366, 280 * (int) screenSize.getHeight()/768);
    
        getContentPane().add(playeronlinenametext, 2,0);
    getContentPane().add(passwordfield, 2,0);
    }

    Registration(int i, String ba) {
        //look and feel code
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
        //------------------------------------------------------------------------
        
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
           
        } 
        
        progLabel = new javax.swing.JLabel();
        progLabel.setFont(new java.awt.Font("Comic Sans MS", 3, 60)); // NOI18N
        progLabel.setText("Shizzle  - Update Account");
        progLabel.setSize(1200 * (int) screenSize.getWidth() / 1366, 101 * (int) screenSize.getHeight() / 768);
        progLabel.setBackground(PropertyCreator.FormBackgroundColor);
        progLabel.setForeground(PropertyCreator.ProgramNameColor);
        progLabel.setLocation(25,10);
        getContentPane().add(progLabel,2,0);
        
        
        playeronlinename = new javax.swing.JLabel("Desired Username: ");
        playeronlinenametext = new javax.swing.JTextField();
        passwordlabel = new javax.swing.JLabel("Password: ");
        passwordfield = new javax.swing.JPasswordField();
        
        q1 = new javax.swing.JLabel ("What is your favorite food?");
        q2 = new javax.swing.JLabel ("What is your best friend's name in high school?");
        q3 = new javax.swing.JLabel ("What is your favorite color?");
        
        a1= new javax.swing.JTextField();
        a2 = new javax.swing.JTextField();
        a3=new javax.swing.JTextField();
        
        AcceptButton = new javax.swing.JButton("Update");
        BackButton = new javax.swing.JButton("Back");
        
        AcceptButton.setBackground(PropertyCreator.OtherButtonBackColor);
        AcceptButton.setForeground(PropertyCreator.OtherButtonForeColor);
        
        BackButton.setBackground(PropertyCreator.OtherButtonBackColor);
        BackButton.setForeground(PropertyCreator.OtherButtonForeColor);
        
        AcceptButton.setSize(150* (int)screenSize.getWidth()/1366, 50 * (int)screenSize.getHeight()/768);
        BackButton.setSize(150* (int) screenSize.getWidth()/1366, 50 * (int) screenSize.getHeight()/768);
        
        AcceptButton.setLocation((int)screenSize.getWidth()-(int)AcceptButton.getWidth()-20, (int)screenSize.getHeight()-(int)AcceptButton.getHeight()-20);
        BackButton.setLocation((int)screenSize.getWidth()-(int)AcceptButton.getWidth()-(int)BackButton.getWidth()-20, (int)screenSize.getHeight()-(int)BackButton.getHeight()-20);
        
        AcceptButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                playsound();
                waiting();
                if (playeronlinenametext.getText().length()!=0 &&
                        passwordfield.getText().length()!=0 && 
                        a1.getText().length()!=0 && 
                        a2.getText().length()!=0 &&
                        a3.getText().length()!=0 && (a1.getText().contentEquals(MainMenu.answer1)==true
                        && a2.getText().contentEquals(MainMenu.answer2)==true
                        && a3.getText().contentEquals(MainMenu.answer3)==true)){
        
                RegisterButton();
                donedone();
                setVisible(false);
                } else
                {
                    donedone();
                    JOptionPane.showMessageDialog(null, "Please, answer the three password safety question correctly\nPlease complete the form - check your responses", "Shizzle - Password Reset", JOptionPane.INFORMATION_MESSAGE);
                }
            }

            private void RegisterButton() {
                List<String> userprofiledata = new ArrayList<String>();
                String onlineusername = String.valueOf(playeronlinenametext.getText());
                userprofiledata.add(onlineusername);
                String password = String.valueOf(passwordfield.getPassword());
                //JOptionPane.showMessageDialog(null, "Your password is: " + password);
                userprofiledata.add(password);
                String question1 = String.valueOf(a1.getText());
                userprofiledata.add(question1);
                String question2 = String.valueOf(a2.getText());
                userprofiledata.add (question2);
                String question3 = String.valueOf(a3.getText());
                userprofiledata.add(question3);
                try {
                FileOutputStream fos = new FileOutputStream("UserProfileData.upd");
                ObjectOutputStream oos = new ObjectOutputStream(fos);
                oos.writeObject(userprofiledata);
                MainMenu.FirstTimeLaunch=false;
                } catch (Exception e) {
                //JOptionPane.showMessageDialog(null, "Error");
                }
                MainMenu.AccessGranted=true;
                MainMenu.loadfileUserData(); //load saved file
                switch (ba) {
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
            }
        });
        BackButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                playsound();
                waiting();
                setVisible(false);
                donedone();
            }
        });
        
        
        add(AcceptButton, 2,0);
        add(BackButton, 2,0);
        
        a1.setBackground(PropertyCreator.ContentHolderBackColor);
        a2.setBackground(PropertyCreator.ContentHolderBackColor);
        a3.setBackground(PropertyCreator.ContentHolderBackColor);
        
        a1.setForeground(PropertyCreator.ContentHolderForeColor);
        a2.setForeground(PropertyCreator.ContentHolderForeColor);
        a3.setForeground(PropertyCreator.ContentHolderForeColor);
        
        a1.setCaretColor(PropertyCreator.ContentHolderForeColor);
        a2.setCaretColor(PropertyCreator.ContentHolderForeColor);
        a3.setCaretColor(PropertyCreator.ContentHolderForeColor);
        
        a1.setSize(300 * (int)screenSize.getWidth()/1366, 50 * (int) screenSize.getHeight()/768);
        a2.setSize(300 * (int)screenSize.getWidth()/1366, 50 * (int) screenSize.getHeight()/768);
        a3.setSize(300 * (int)screenSize.getWidth()/1366, 50 * (int) screenSize.getHeight()/768);
        
        a1.setLocation(670 * (int)screenSize.getWidth()/1366, 360 * (int) screenSize.getHeight()/768);
        a2.setLocation(670 * (int)screenSize.getWidth()/1366, 440 * (int) screenSize.getHeight()/768);
        a3.setLocation(670 * (int)screenSize.getWidth()/1366, 520 * (int) screenSize.getHeight()/768);
        
        a1.setFont(new java.awt.Font("Comic Sans MS", 0, 22));
        a2.setFont(new java.awt.Font("Comic Sans MS", 0, 22));
        a3.setFont(new java.awt.Font("Comic Sans MS", 0, 22));
        
        add(a1,2,0);
        add(a2,2,0);
        add(a3,2,0);
        
        q1.setBackground(PropertyCreator.FormBackgroundColor);
        q2.setBackground(PropertyCreator.FormBackgroundColor);
        q3.setBackground(PropertyCreator.FormBackgroundColor);
                
        q1.setForeground(PropertyCreator.LabelTextForeColor);
        q2.setForeground(PropertyCreator.LabelTextForeColor);
        q3.setForeground(PropertyCreator.LabelTextForeColor);
         
        q1.setSize(400 * (int) screenSize.getWidth() / 1366, 50 * (int) screenSize.getHeight() / 768);
        q2.setSize(600 * (int) screenSize.getWidth() / 1366, 50 * (int) screenSize.getHeight() / 768);
        q3.setSize(400 * (int) screenSize.getWidth() / 1366, 50 * (int) screenSize.getHeight() / 768);
         
        q1.setLocation(80 * (int)screenSize.getWidth()/1366, 360 * (int) screenSize.getHeight()/768);
        q2.setLocation(80 * (int)screenSize.getWidth()/1366, 440 * (int) screenSize.getHeight()/768);
        q3.setLocation(80 * (int)screenSize.getWidth()/1366, 520 * (int) screenSize.getHeight()/768);
        
        q1.setFont(new java.awt.Font("Comic Sans MS", 0, 24));
        q2.setFont(new java.awt.Font("Comic Sans MS", 0, 24));
        q3.setFont(new java.awt.Font("Comic Sans MS", 0, 24));
        
        add(q1,2,0);
        add(q2,2,0);
        add(q3,2,0);
        
        
        
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
        playeronlinenametext.setSize(300 * (int)screenSize.getWidth()/1366, 50 * (int) screenSize.getHeight()/768);
        passwordlabel.setSize(300 * (int) screenSize.getWidth() / 1366, 50 * (int) screenSize.getHeight() / 768);
        passwordfield.setSize(300 * (int)screenSize.getWidth()/1366, 50 * (int) screenSize.getHeight()/768);
        
        playeronlinename.setLocation(80 * (int)screenSize.getWidth()/1366, 200 * (int) screenSize.getHeight()/768);
        playeronlinenametext.setLocation(670 * (int)screenSize.getWidth()/1366, 200 * (int) screenSize.getHeight()/768);
        passwordlabel.setLocation(80 * (int)screenSize.getWidth()/1366, 280 * (int) screenSize.getHeight()/768);
        passwordfield.setLocation(670 * (int)screenSize.getWidth()/1366, 280 * (int) screenSize.getHeight()/768);
    
        getContentPane().add(playeronlinenametext, 2,0);
    getContentPane().add(passwordfield, 2,0);
    }

    public void playsound ()
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
            java.util.logging.Logger.getLogger(Registration.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Registration.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Registration.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Registration.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                //new Registration("chat").setVisible(true);
            }
        });
    }
    
    public void waiting()
    {
        
        this.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
    }
    public void donedone()
    {
        this.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
