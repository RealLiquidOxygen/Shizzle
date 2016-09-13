/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Shizzle;

import jaco.mp3.player.MP3Player;
import java.awt.*;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.text.DefaultCaret;

/**
 *
 * @author owoye001
 */
public class ChatRoom extends javax.swing.JFrame implements ActionListener {
    
    
    //variable initialization 
    public static final long serialVersionUID = 1L;
    public static Client client;
    public static int defaultPort;
    public static String defaultHost;
    public static String username;
    public static String tfServer;
    public static int tfPort;
    public static boolean connector = true;
    public static int n;
    public static boolean connected;
    DefaultListModel listModellistModel = new DefaultListModel();
    public JList Onlinepp = new JList(listModellistModel);
    public JScrollPane listScrollPane = new JScrollPane (Onlinepp);
            

    //-----------------------------------------------------------
    private javax.swing.JButton BackButton;
    public static javax.swing.JTextArea ChatText;
    private javax.swing.JScrollPane ChatTextScroll;
    public static javax.swing.JTextField MessageBox;
    // javax.swing.JPanel jChatRoom;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JButton sendButton;
    private javax.swing.JLabel progLabel;
   //-----------------------------------------------------------
    //public static JTextArea ChatText = new JTextArea();
    private javax.swing.JLabel backgroundpicture;

    /**
     * Creates new form ChatRoom
     */

    void append(String str) {
        ChatText.append(str);
        ChatText.setCaretPosition(ChatText.getText().length() - 1);
        playsound();
    }

    void connectionFailed() {

        //exitter();
        append("Connection Failed");
        connected = false;
    }

    public ChatRoom() {
        waiting(); //changing the mouse cursor here
        
        //changing the look and feel of the application 
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
        
        
        //checking for applications screensize
 
        //loading the background for this screen here
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        listModellistModel.addElement("None");
        backgroundpicture = new javax.swing.JLabel();
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
           
        }
        initComponents();
        setSize(screenSize); //resizing the JFrame here
        getContentPane().setBackground(PropertyCreator.FormBackgroundColor);

        //variable initizations
        BackButton = new javax.swing.JButton();
        sendButton = new javax.swing.JButton();

        ChatText = new javax.swing.JTextArea();
        ChatTextScroll = new javax.swing.JScrollPane(ChatText);

        MessageBox = new javax.swing.JTextField();

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        progLabel = new javax.swing.JLabel();

        DefaultCaret caret = (DefaultCaret) ChatText.getCaret();
        //-------------------------------------

        caret.setUpdatePolicy(DefaultCaret.ALWAYS_UPDATE); //auto scroll property of the chatbox
    
        //variable initializations
        jLabel1.setFont(new java.awt.Font("Comic Sans MS", 0, 18)); // NOI18N
        jLabel1.setText("Chat Room Text:");
        jLabel1.setBackground(PropertyCreator.FormBackgroundColor);
        jLabel1.setForeground(PropertyCreator.LabelTextForeColor);
        jLabel1.setLocation(40 * (int) screenSize.getWidth() / 1366, 140 * (int) screenSize.getHeight() / 768);
        jLabel1.setVisible(true);
        jLabel1.setSize(137 * (int) screenSize.getWidth() / 1366, 26 * (int) screenSize.getHeight() / 768);

        progLabel.setFont(new java.awt.Font("Comic Sans MS", 3, 72)); // NOI18N
        progLabel.setText("Shizzle  - Chat Room");
        progLabel.setBackground(PropertyCreator.FormBackgroundColor);
        progLabel.setForeground(PropertyCreator.ProgramNameColor);
        progLabel.setLocation(20 * (int) screenSize.getWidth() / 1366, 10 * (int) screenSize.getHeight() / 768);
        progLabel.setSize(757 * (int) screenSize.getWidth() / 1366, 101 * (int) screenSize.getHeight() / 768);

        jLabel2.setSize(111 * (int) screenSize.getWidth() / 1366, 26 * (int) screenSize.getHeight() / 768);
        jLabel2.setFont(new java.awt.Font("Comic Sans MS", 0, 18)); // NOI18N
        jLabel2.setText("Online Users:");
        jLabel2.setBackground(PropertyCreator.FormBackgroundColor);
        jLabel2.setForeground(PropertyCreator.LabelTextForeColor);
        jLabel2.setLocation(1030 * (int) screenSize.getWidth() / 1366, 140 * (int) screenSize.getHeight() / 768);
        jLabel2.setVisible(true);

        jLabel3.setFont(new java.awt.Font("Comic Sans MS", 0, 18)); // NOI18N
        jLabel3.setText("Message:");
        jLabel3.setBackground(PropertyCreator.FormBackgroundColor);
        jLabel3.setForeground(PropertyCreator.LabelTextForeColor);
        jLabel3.setLocation(40 * (int) screenSize.getWidth() / 1366, 580 * (int) screenSize.getHeight() / 768);
        jLabel3.setVisible(true);
        jLabel3.setSize(78 * (int) screenSize.getWidth() / 1366, 26 * (int) screenSize.getHeight() / 768);
        
        ChatTextScroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        ChatTextScroll.setWheelScrollingEnabled(true);

        ChatText.setEditable(false);
        ChatText.setColumns(20);
        ChatText.setFont(new java.awt.Font("Comic Sans MS", 0, 24)); // NOI18N
        ChatText.setLineWrap(true);
        ChatText.setRows(5);
        ChatText.setDebugGraphicsOptions(javax.swing.DebugGraphics.BUFFERED_OPTION);
        ChatText.setDisabledTextColor(new java.awt.Color(255, 255, 255));
        ChatText.setDoubleBuffered(true);
        ChatTextScroll.setSize(967 * (int) screenSize.getWidth() / 1366, 400 * (int) screenSize.getHeight() / 768);
        ChatTextScroll.setLocation(40 * (int) screenSize.getWidth() / 1366, 180 * (int) screenSize.getHeight() / 768);
        ChatText.setForeground(PropertyCreator.ContentHolderForeColor);
        ChatText.setCaretColor(PropertyCreator.CaretColor);

        MessageBox.setCaretColor(PropertyCreator.CaretColor);
        MessageBox.setSize(967 * (int) screenSize.getWidth() / 1366, 120 * (int) screenSize.height / 768);
        MessageBox.setLocation(40 * (int) screenSize.getWidth() / 1366, 620 * (int) screenSize.getHeight() / 768);
        MessageBox.setFont(new java.awt.Font("Comic Sans MS", 0, 24)); // NOI18N
        MessageBox.setForeground(PropertyCreator.ContentHolderForeColor);
        MessageBox.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                if (evt.getKeyCode() == evt.VK_ENTER) {
                    waiting();
                    sendButton.doClick();
                    donedone();
                }
            }
        });

        sendButton.setLocation(1030 * (int) screenSize.getWidth() / 1366, 620 * (int) screenSize.getHeight() / 768);
        sendButton.setSize(290 * (int) screenSize.getWidth() / 1366, 50 * (int) screenSize.getHeight() / 768);
        sendButton.setBackground(PropertyCreator.OtherButtonBackColor);
        sendButton.setFont(new java.awt.Font("Comic Sans MS", 0, 36)); // NOI18N
        sendButton.setForeground(PropertyCreator.OtherButtonForeColor);
        sendButton.setText("Send");
        sendButton.setEnabled(false);
        
        //handling actionlistener for sendButton
        sendButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                playsound();
                if ((MessageBox.getText()).equals("")) {
                    MessageBox.setText("");
                    MessageBox.requestFocus();
                } else {
                    try {
                        client.sendUserData(new UserData(MainMenu.username, MessageBox.getText(), 0));
                    } catch (Exception ex) {
                        ChatText.append("Server not responding. \nPlease, click back and try logging in again");
                        JOptionPane.showMessageDialog(null, "Server not responding. \nPlease, click back and try logging in again", "Shizzle", JOptionPane.INFORMATION_MESSAGE);
                    }
                    MessageBox.setText("");
                    MessageBox.requestFocus();
                }

                MessageBox.setText("");
                MessageBox.requestFocus();

            }
        });

        BackButton.setLocation(1030 * (int) screenSize.getWidth() / 1366, 690 * (int) screenSize.getHeight() / 768);
        BackButton.setSize(290 * (int) screenSize.getWidth() / 1366, 50 * (int) screenSize.getHeight() / 768);
        BackButton.setBackground(PropertyCreator.OtherButtonBackColor);
        BackButton.setFont(new java.awt.Font("Comic Sans MS", 0, 36)); // NOI18N
        BackButton.setForeground(PropertyCreator.OtherButtonForeColor);
        BackButton.setText("Back");
        BackButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                playsound();
                //more code here for saving game result later
                if (connected==true){
                setVisible(false);
                }else if (connected ==false){
                closeit();
                }
            }
        });

        listScrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        listScrollPane.setWheelScrollingEnabled(true);
        
        listScrollPane.setSize(287 * (int) screenSize.getWidth() / 1366, 400 * (int) screenSize.height / 768);
        listScrollPane.setLocation(1030 * (int) screenSize.getWidth() / 1366, 180 * (int) screenSize.height / 768);
        Onlinepp.setFont(ChatText.getFont());
        Onlinepp.setBackground(PropertyCreator.ContentHolderBackColor);
        Onlinepp.setForeground(PropertyCreator.ContentHolderForeColor);

  //______________________________________
        //______________________________________
        add(progLabel,2,0);
        add(jLabel1,2,0);
        add(ChatTextScroll,2,0);
        add(jLabel3,2,0);
        add(MessageBox,2,0);
        add(jLabel2,2,0);
        add(listScrollPane,2,0);
        add(sendButton,2,0);
        add(BackButton,2,0);

        //________________________________________ 
        //________________________________________      
//----connection section
        try {
            connectit();
        } catch (Exception e) {
            //JOptionPane.showMessageDialog(null, "Cannot Connect!");
        }

    donedone();
    }

    public void MessageHandler(UserData x) {
        if (x.getMessageType() != -1) {
            ChatText.append(x.getMessage());
        }
    }

    public static ChatRoom ha;
    //-----------------------------------------------------------------

    public static JOptionPane happy; //input message box handling
    
    //this method connects the client to the server

    private void connectit() {

        ///---------------------------------------------------------------00000000000000
        if (connected == false) {

            if ((Client.sg == null) && (Client.cg == null)) {

                //n = JOptionPane.showConfirmDialog(null, "Do you want to log in?", "Shizzle", JOptionPane.YES_NO_OPTION);
                   n =JOptionPane.YES_OPTION;
                if (n == JOptionPane.YES_OPTION) {
                //-----------------------------------------------------------------
                    //tfServer = JOptionPane.showInputDialog(null, "Enter Server's IP Address", "Shizzer - SERVER IP", JOptionPane.QUESTION_MESSAGE);
                    tfServer = MainMenu.tfServer;
                    try {
                        //tfPort = Integer.parseInt(JOptionPane.showInputDialog(null, "Enter Port Number", "Shizzer - SERVER PORT", JOptionPane.QUESTION_MESSAGE));
                        tfPort = 5500;
                    } catch (Exception e) {
                        tfPort = 0;
                    }

                    /*username = JOptionPane.showInputDialog(
                            null,
                            "Please, enter desired username?",
                            "Shizzle - Username",
                            JOptionPane.QUESTION_MESSAGE
                    ); */
                    username = MainMenu.username;

                //username = username + "_Chat";
                    if (username.length() == 0) {
                        username = "Annonymous";
                    }

                    if (tfServer.length() == 0) {
                        tfServer = MainMenu.tfServer; //change later
                    }
                    if (tfPort == 0) {
                        tfPort = 5500;
                    }
                }

            } else {
                String temp;
                temp = client.sg.username;
                //username = (temp.substring(0,temp.length()-5)) + "_Chat";
                username = temp;
                //JOptionPane.showMessageDialog(null, username);
                tfServer = client.sg.tfServer; //change later

                tfPort = client.sg.tfPort;
            }

            if (tfPort != 0 && Client.sg == null) {
                //JOptionPane.showMessageDialog(null, username);
                client = new Client(tfServer, tfPort, username, this);

                if (!client.start()) {
                    connected=false;
                    return;
                }

                //JOptionPane.showMessageDialog(null, "Connected!", "Shizzle", JOptionPane.INFORMATION_MESSAGE);

            } else {
                client = OnlinePlay.client;
            }

            if (tfPort != 0) {
                connected = true;
                //MainMenu.username = username;
                if (username != null) {
                    MainMenu.usernamelabel.setText("UserName: " + username);
                }
                OnlinePlay.username = MainMenu.username;
            }

            try {
                client.sendUserData(new UserData(username, "You are online!", 0));
                sendButton.setEnabled(true);
            } catch (Exception ex) {
                ChatText.append("Message was not sent. \nPlease, click back and try logging in again");
                sendButton.setEnabled(false);
            }

        }

    }
    //00000000000000000000000000000000000000000000000
    //--------------------------------------------------------------------

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setIconImage(Toolkit.getDefaultToolkit().getImage(MainMenu.class.getResource("image.jpg")));
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
            java.util.logging.Logger.getLogger(ChatRoom.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ChatRoom.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ChatRoom.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ChatRoom.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ChatRoom().setVisible(true);
            }
        });
    }

    //plays a click sound when any button is pushed on this screen
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

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
    @Override
    public void actionPerformed(ActionEvent ae) {
        Object el = ae.getSource();
        if (connected && el == MessageBox) {
            client.sendUserData(new UserData(username, MessageBox.getText(), 0));
            MessageBox.setText("");
        }

    }
    
    //closes this screen
    void closeit()
    {
        OnlinePlay.t.stop();
        Client.sg.dispose();
        Client.cg.dispose();
        Client.cg=null;
        Client.sg=null;
        dispose();
    }
    String token;

    //updates user list
    void updateList(ArrayList<String> thelistthelist) {
//        if (thelistthelist.isEmpty()) {return;}
        try {
            Onlinepp.removeAll();
            listModellistModel.removeAllElements();
            for (int i = 0; i < thelistthelist.size(); ++i) {
                token = thelistthelist.get(i);
                listModellistModel.addElement(token);

            }
            Onlinepp.repaint();
        } catch (NullPointerException e) {
        }
    }
    
    //changes the mouse cursor to waiting. 
     public final  void waiting()
    {
        
        this.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
    }
     
     //changes the mouse to default cursor.
    public final void donedone()
    {
        this.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
    }
}
