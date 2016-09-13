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
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.Timer;
/**
 *
 * @author owoye001
 * handles the online play section section of the game. Play with friends 
 */
public class OnlinePlay extends javax.swing.JFrame {
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
    DefaultListModel listModellistModel = new DefaultListModel();;
    DefaultListModel listModellistModelacc = new DefaultListModel();;
    DefaultListModel temp = new DefaultListModel();
    public JList WhoList = new JList(listModellistModel);
    public JList AcceptList = new JList(listModellistModelacc);
     private JScrollPane listScrollPane = new JScrollPane (WhoList);
    private JScrollPane listScrollPane1 = new JScrollPane (AcceptList);
    
    
    
    //------THING THAT NEED TO BE SENT ------------------------------------

    public static int type;
    public static String firstusername;
    public static String [] firstuserwords;
    public static int [] firstuserscores;
    public static int firstuserznum;
    public static String secondusername;
    public static String [] seconduserwords;
    public static int [] seconduserscores;
    public static int seconduserznum;
    public static int gamenum;
    public static List<String> highscoresnames = new ArrayList<>();
    public static List<Integer> highscorescores = new ArrayList<>();
    private JLabel backgroundpicture;
  
    //------------------------------------------
    private javax.swing.JButton acceptButton;
    private javax.swing.JButton backbutton;
    private javax.swing.JButton highscorebutton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JButton playButton;
    public javax.swing.JLabel progLabel;
    public static Timer t;
    //public static HighScores bon = new HighScores();
    /**
     * Creates new form OnlinePlay
     */
    public OnlinePlay() {
        //look and feel code
        waiting();
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
     
     
        //___________________________________________________________________________
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        listModellistModel.addElement("No Users");
        listModellistModelacc.addElement("No Game Requests");
        backgroundpicture = new javax.swing.JLabel();
        backgroundpicture.setSize(screenSize);
        //bon.setVisible(false);
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
        //
        progLabel = new javax.swing.JLabel();
        backbutton = new javax.swing.JButton();
        acceptButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        playButton = new javax.swing.JButton();
        highscorebutton = new javax.swing.JButton();
        getContentPane().setLayout (null);

        progLabel.setFont(new java.awt.Font("Comic Sans MS", 3, 72)); // NOI18N
        progLabel.setText("Shizzle  - Who's Out There?");
        getContentPane().add(progLabel, 2,0);

        backbutton.setBackground(PropertyCreator.OtherButtonBackColor);
        backbutton.setFont(new java.awt.Font("Comic Sans MS", 0, 48)); // NOI18N
        backbutton.setForeground(PropertyCreator.OtherButtonForeColor);
        backbutton.setText("Back");
        backbutton.addActionListener((java.awt.event.ActionEvent evt) -> {
            playsound();
            if (connected==true)
            {
                setVisible(false);
            }
            else if (connected==false)
            {
                closeit();
            }
        });
        getContentPane().add(backbutton, 2,0);

        acceptButton.setBackground(PropertyCreator.OtherButtonBackColor);
        acceptButton.setFont(new java.awt.Font("Comic Sans MS", 0, 48)); // NOI18N
        acceptButton.setForeground(PropertyCreator.OtherButtonForeColor);
        acceptButton.setText("Send Request");
        acceptButton.setEnabled(false);
        acceptButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                playsound();
         try{
             //msg = senderusername:gamerequesting:receiverusername
             
             if (username.contains(String.valueOf(WhoList.getSelectedValue()))==false && WhoList.getSelectedValue().toString().length()!=0)
             {
                 if (String.valueOf(WhoList.getSelectedValue())!=null)
                         {
                          firstusername = username;
                          if (String.valueOf(WhoList.getSelectedValue()).isEmpty()) { JOptionPane.showMessageDialog(null, "No User Selected", "Shizzle", JOptionPane.INFORMATION_MESSAGE); return;}
                          secondusername = String.valueOf(WhoList.getSelectedValue());
                          type = 0; //No game played yet
                          gamenum = -1; //random game
                          //String username, int message type, String message, ArrayList<String> userlist,int gametype,  //
                          //String firstusername, String [] firstuserwords, int [] firstuserwords, int firstuserznum,  
                          //String secondusername, String[] seconduserwords, int [] seconduserscores, int secondusernum, 
                          //gamenum
                          client.sendUserData(new UserData(username,-2, "gamerequesting:"+String.valueOf(WhoList.getSelectedValue()), 
                                  null, type, firstusername, firstuserwords, firstuserscores, firstuserznum, secondusername, seconduserwords, seconduserscores, seconduserznum, gamenum,highscoresnames, highscorescores));
                         JOptionPane.showMessageDialog(null, "Game Request Sent!", "Shizzle", JOptionPane.INFORMATION_MESSAGE);
                         }
                         else
                 {
                     JOptionPane.showMessageDialog(null, "No User Selected", "Shizzle", JOptionPane.INFORMATION_MESSAGE);
                 }
             }
                      else
             {
                 JOptionPane.showMessageDialog(null, "You cannot send yourself a game request!", "Shizzle", JOptionPane.INFORMATION_MESSAGE);
             }
                          
         }
         catch (Exception e)
         {
             JOptionPane.showMessageDialog(null, "Game request not sent!", "Shizzle", JOptionPane.INFORMATION_MESSAGE);
         }
            }
        });
        getContentPane().add(acceptButton, 2,0);

        jLabel1.setFont(new java.awt.Font("Comic Sans MS", 0, 24)); // NOI18N
        getContentPane().add(jLabel1, 2,0);

        jLabel3.setFont(new java.awt.Font("Comic Sans MS", 0, 24)); // NOI18N
        jLabel3.setText("Who's Online");
        getContentPane().add(jLabel3, 2,0);

        jLabel4.setFont(new java.awt.Font("Comic Sans MS", 0, 24)); // NOI18N
        jLabel4.setSize(240 * (int) screenSize.getWidth() / 1366, 50 * (int) screenSize.getHeight() / 768);
        jLabel4.setText("Game Requests");
        getContentPane().add(jLabel4, 2,0);

        playButton.setBackground(PropertyCreator.OtherButtonBackColor);
        playButton.setFont(new java.awt.Font("Comic Sans MS", 0, 48)); // NOI18N
        playButton.setForeground(PropertyCreator.OtherButtonForeColor);
        playButton.setText("Play");
        playButton.addActionListener((java.awt.event.ActionEvent evt) -> {
            playsound();
            waiting();
            try{
                //ensuring something is selected check
                if (String.valueOf(AcceptList.getSelectedValue().toString())==null)
                {
                    JOptionPane.showMessageDialog(null, "No Game Selected", "Shizzle", JOptionPane.INFORMATION_MESSAGE);
                    donedone();
                    return;
                }
                
                //Go through game to find that exact game//nobody play yet, empty score sheet
                
                for (UserData resultlist1 : resultlist) {
                    if (String.valueOf(AcceptList.getSelectedValue())!=null && String.valueOf(AcceptList.getSelectedValue()).contains(resultlist1.getFirstUserName()) &&  resultlist1.getGameType()==0) {
                        Game_1.type =resultlist1.getGameType();
                        Game_1.gamenum = resultlist1.getGameNum(); //just a random agame gamenum = -1
                        Game_1.firstusername = resultlist1.getFirstUserName();
                        Game_1.secondusername = resultlist1.getSecondUserName();
                        gamer = new Game_1(); //create the game
                        gamer.setVisible(true);
                        resultlist.remove(resultlist1);
                        listModellistModelacc.removeElement(AcceptList.getSelectedValue()); //removing played games
                        donedone();
                        return;
                    }
                    else if (String.valueOf(AcceptList.getSelectedValue())!=null && String.valueOf(AcceptList.getSelectedValue()).contains(resultlist1.getSecondUserName()) &&  resultlist1.getGameType()==1) {
                        
                        Game_1.firstusername = resultlist1.getFirstUserName();
                        Game_1.secondusername = resultlist1.getSecondUserName();
                        Game_1.seconduserwords = resultlist1.getSecondUserWords();
                        Game_1.seconduserscores = resultlist1.getSecondUserScore();
                        Game_1.seconduserznum = resultlist1.getSecondUserZNum();
                        Game_1.gamenum = resultlist1.getGameNum(); //not random
                        Game_1.type = resultlist1.getGameType();
                        Game_1 game = new Game_1();
                        game.setVisible(true);
                        game.AwarePanel.revalidate();
                        resultlist.remove(resultlist1);
                        listModellistModelacc.removeElement(AcceptList.getSelectedValue()); //removing played games
                        donedone();
                        return;
                    }
                    else if (String.valueOf(AcceptList.getSelectedValue())!=null && String.valueOf(AcceptList.getSelectedValue()).contains(resultlist1.getFirstUserName()) &&  resultlist1.getGameType()==2) {
                        
                        ResultPageMulti.firstusername = resultlist1.getFirstUserName(); //old value
                        ResultPageMulti.secondusername = resultlist1.getSecondUserName(); //old value
                        ResultPageMulti.type=resultlist1.getGameType()+1; //new value
                        ResultPageMulti.firstuserwords = resultlist1.getFirstUserWords();//old value
                        ResultPageMulti.firstuserscores= resultlist1.getFirstUserScore(); //old value
                        ResultPageMulti.firstuserznum = resultlist1.getFirstUserZNum(); //old value
                        ResultPageMulti.seconduserwords =resultlist1.getSecondUserWords(); //new values
                        ResultPageMulti.seconduserscores=resultlist1.getSecondUserScore(); //new values
                        ResultPageMulti.seconduserznum = resultlist1.getSecondUserZNum(); //new values
                        ResultPageMulti.gamenum = resultlist1.getGameNum(); //old value
                        ResultPageMulti rpm = new ResultPageMulti();
                        rpm.setVisible(true);
                        resultlist.remove(resultlist1);
                        listModellistModelacc.removeElement(AcceptList.getSelectedValue()); //removing played games
                        donedone();
                        
                    }
                }
            }catch (Exception j){}
            donedone();
        });
        getContentPane().add(playButton, 2,0);

        highscorebutton.setBackground(PropertyCreator.OtherButtonBackColor);
        highscorebutton.setFont(new java.awt.Font("Comic Sans MS", 0, 48)); // NOI18N
        highscorebutton.setForeground(PropertyCreator.OtherButtonForeColor);
        highscorebutton.setText("High Scores");
        highscorebutton.setEnabled(false);
        highscorebutton.addActionListener((java.awt.event.ActionEvent evt) -> {
            playsound();
            waiting();
            if (hicontrol ==false)
            {
                //bon.setVisible(true);
                Client.hs = new HighScores();
                Client.hs.setVisible(true);
                hicontrol=true;
            }
            else
            {
                //bon.setVisible(true);
                Client.hs.setVisible(true);
            }
            donedone();
        });
        getContentPane().add(highscorebutton, 2,0);
        
        //
        
        setSize(screenSize);
        setLayout(null);
        getContentPane().setBackground(PropertyCreator.FormBackgroundColor);
        progLabel.setBackground(PropertyCreator.FormBackgroundColor);
        progLabel.setForeground(PropertyCreator.ProgramNameColor);
        this.progLabel.setLocation(25,10);
        progLabel.setSize(1076 * (int) screenSize.getWidth() / 1366, 176 * (int) screenSize.getHeight() / 768);
       
        highscorebutton.setSize(430 * (int) screenSize.getWidth() / 1366, 59 * (int) screenSize.getHeight() / 768);
        highscorebutton.setLocation(460 * (int) screenSize.getWidth() / 1366, 340 * (int) screenSize.getHeight() / 768);
        
        backbutton.setSize(240 * (int) screenSize.getWidth() / 1366, 60 * (int) screenSize.getHeight() / 768);
        backbutton.setLocation(550 * (int) screenSize.getWidth() / 1366, 550 * (int) screenSize.getHeight() / 768);
       
        
        acceptButton.setSize(372 * (int) screenSize.getWidth() / 1366, 59 * (int) screenSize.getHeight() / 768);
        acceptButton.setLocation(490 * (int) screenSize.getWidth() / 1366, 410 * (int) screenSize.getHeight() / 768);
        
        playButton.setSize(310 * (int) screenSize.getWidth() / 1366, 60 * (int) screenSize.getHeight() / 768);
        playButton.setLocation(520 * (int) screenSize.getWidth() / 1366, 480 * (int) screenSize.getHeight() / 768);
        
        jLabel3.setLocation(40 * (int) screenSize.getWidth() / 1366, 190 * (int) screenSize.getHeight() / 768);
        jLabel3.setSize (240 * (int) screenSize.getWidth()/1366, 50*(int)screenSize.getHeight()/768);
        jLabel3.setForeground(PropertyCreator.LabelTextForeColor);
        
        
        //------
        listScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        listScrollPane1.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        listScrollPane.setWheelScrollingEnabled(true);
        listScrollPane1.setWheelScrollingEnabled(true);
        
        WhoList.setFont(jLabel1.getFont());
        listScrollPane.setSize(357 * (int) screenSize.getWidth() / 1366, 397 * (int) screenSize.getHeight() / 768);
        listScrollPane.setLocation(40 * (int) screenSize.getWidth() / 1366, 260 * (int) screenSize.getHeight() / 768);
        WhoList.setBackground(PropertyCreator.ContentHolderBackColor);
        WhoList.setForeground(PropertyCreator.ContentHolderForeColor);
        
        
        listScrollPane1.setSize(357 * (int) screenSize.getWidth() / 1366, 397 * (int) screenSize.getHeight() / 768);
        listScrollPane1.setLocation(960 * (int) screenSize.getWidth() / 1366, 260 * (int) screenSize.getHeight() / 768);
        AcceptList.setFont(jLabel1.getFont());
        AcceptList.setBackground(PropertyCreator.ContentHolderBackColor);
        AcceptList.setForeground(PropertyCreator.ContentHolderForeColor);
        
        jLabel4.setLocation(960 * (int) screenSize.getWidth() / 1366, 190 * (int) screenSize.getHeight() / 768);
        jLabel4.setForeground (PropertyCreator.LabelTextForeColor);
        
        
        //------
        getContentPane().add(listScrollPane,2,0);
        getContentPane().add(listScrollPane1,2,0);
        WhoList.setVisible(true);
        AcceptList.setVisible(true);
        acceptButton.setEnabled(false);
        highscorebutton.setEnabled(false);
        playButton.setEnabled(false);
        
        try{
        connectit();
        }catch(Exception e){
         //JOptionPane.showMessageDialog(null, "Cannot Connect!");
        }
        
        
       t = new Timer (10000, new ActionListener()
        {
          
            @Override
            public void actionPerformed(ActionEvent ae) {
                try{
                OnlinePlay.client.sendUserData(new UserData(MainMenu.username, -1, null, null,0,  null, null, null, 0,  null, null, null, 0, 0, highscoresnames, highscorescores));
                //OnlinePlay.client.sendUserData(new UserData(MainMenu.username, null,-1));
                }catch (Exception eq) {
                    JOptionPane.showMessageDialog(null,"Server not responding. \nPlease, click back and try logging in again", "Shizzle", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        });
        t.start();
        
    donedone();
    }
   
    
    //----------------------------
    
    final void closeit()
    {
        t.stop();
        Client.sg.dispose();
        Client.cg.dispose();
        Client.cg=null;
        Client.sg=null;
        dispose();
    }
    
    
    //----------
 
    private void connectitsv()
    {
        if (username.length() == 0) {
                    username = "Annonymous";
                }

                if (tfServer.length() == 0) {
                    tfServer = MainMenu.tfServer; //change later
                }
                if (tfPort == 0) {
                    tfPort = 5500;
                }

                client = new Client(1,tfServer, tfPort, username, this);

                if (!client.start()) {
                    connected=false;
                    return;
                }

                connected = true;
                //MainMenu.username = username;
                if (username!=null){
                    MainMenu.usernamelabel.setText("UserName: " +username);
                }
                ChatRoom.username = username;

                //MessageBox.addActionListener(this);
                //JOptionPane.showMessageDialog(null, "Connected!", "Shizzle", JOptionPane.INFORMATION_MESSAGE);

                //who is online
                 acceptButton.setEnabled(true);
                 highscorebutton.setEnabled(true);
         
    }
    
    public static JOptionPane happy;

     private void connectit() {

        ///---------------------------------------------------------------00000000000000
        if (connected == false) {
        if ((Client.sg==null)&&(Client.cg==null)){
                
            n = JOptionPane.YES_OPTION; //no portion no longer runs

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
                /*
                username = JOptionPane.showInputDialog(
                        null,
                        "Please, enter desired username?",
                        "Shizzle - Username",
                        JOptionPane.QUESTION_MESSAGE
                ); */
                
                username = MainMenu.username;
                
                 //username = username + "_Play";

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
        }
            else 
                {
                        String tempe;
                        tempe = client.cg.username;
                        //username = (temp.substring(0,temp.length()-5)) + "_Play";
                        username = tempe;
                        //JOptionPane.showMessageDialog(null, username);
                        
                        tfServer = client.cg.tfServer; //change later
                    
                        tfPort = client.cg.tfPort;
                 }
                if (tfPort!=0 && client.cg==null)
                {
                    //JOptionPane.showMessageDialog(null, username);
                client = new Client(1,tfServer, tfPort, username, this);
                   //client = ChatRoom.client;
                if (!client.start())
                    connected =false;
                    return;
                
                //JOptionPane.showMessageDialog(null, "Connected!", "Shizzle", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    client = ChatRoom.client;
                }  
                
                if (tfPort!=0){
                connected = true;
                //MainMenu.username = username;
                if (username!=null){
                   MainMenu.usernamelabel.setText("UserName: " +username);
                }
                ChatRoom.username = username;
                //who is online
                }
                
                try {
                    client.sendUserData(new UserData(MainMenu.username,"Online",-1));
                    acceptButton.setEnabled(true);
                    highscorebutton.setEnabled(true);
                } catch (Exception ex) {
                    acceptButton.setEnabled(false); 
                    highscorebutton.setEnabled(false);
                    JOptionPane.showMessageDialog(null,"Server not responding. \nPlease, click back and try logging in again", "Shizzle", JOptionPane.INFORMATION_MESSAGE);
                }
        
            
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
        setTitle("Online Play");
        setIconImage(Toolkit.getDefaultToolkit().getImage(MainMenu.class.getResource("image.jpg")));
        setUndecorated(true);
        getContentPane().setLayout(null);

        pack();
    }// </editor-fold>//GEN-END:initComponents
Game_1 gamer;static boolean hicontrol=false;    
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
            //java.util.logging.Logger.getLogger(OnlinePlay.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
     //</editor-fold>
     
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new OnlinePlay().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables

    void updateList(ArrayList<String> thelistthelist) {
        try{
       // if (thelistthelist.isEmpty()) {return;}
        WhoList.removeAll();
        listModellistModel.removeAllElements();
        for (int i = 0; i < thelistthelist.size(); ++i) {
                  listModellistModel.addElement(thelistthelist.get(i));
        }
          // System.out.println(AcceptList.getModel().getSize());
           if (WhoList.getModel().getSize()>1)
           {
            acceptButton.setEnabled(true);
            //highscorebutton.setEnabled(true);
           }
           else
           {
               acceptButton.setEnabled(false);
               //highscorebutton.setEnabled(false);
           }
           
        WhoList.repaint();
        }catch (NullPointerException e) {}
    }

    void connectionFailed() {
        JOptionPane.showMessageDialog(null, "Connection Failed!", "Shizzle", JOptionPane.INFORMATION_MESSAGE);
        connected = false;
    }

     public final void waiting()
    {
        
        this.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
    }
    public final void donedone()
    {
        this.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
    }
    void updateListRequest(String request, String receiver) {
        /*
      if (receiver.isEmpty() || request.isEmpty()) {return;}
        if (username.contains(receiver)) //if the request belong to you, you should add it.
        {
             if (listModellistModelacc.contains("No Game Requests")) //clear out the list
             {
                 listModellistModelacc.removeElement("No Game Requests");
             }
        listModellistModelacc.addElement(request);
        playButton.setEnabled(true);
        }
        // System.out.println(AcceptList.getModel().getSize()); */
          
    }
ArrayList<UserData> resultlist = new ArrayList();

    void updateGameArrays(UserData rst) {
   if (rst==null) {return;}
        
     if (rst.getGameType()==0 && rst.getFirstUserName() !=null && rst.getSecondUserName() !=null){
        String tempReceiver = rst.getSecondUserName();
         String sendusername = rst.getFirstUserName();
         if (username.contentEquals(tempReceiver))
         {
             if (listModellistModelacc.contains("No Game Requests")) //clear out the list
             {
                 listModellistModelacc.removeElement("No Game Requests");
             }
            resultlist.add(rst); //save result for latr
            listModellistModelacc.addElement(rst.getFirstUserName()); //the person who sent it. \
            playButton.setEnabled(true);
            playsound("newgame.mp3");
            //Saved. I can always go there and play. Good.
         }
    } else if (rst.getGameType()==1 && rst.getFirstUserName() !=null && rst.getSecondUserName() !=null) {
         String tempReceiver = rst.getFirstUserName();
         String sendusername = rst.getSecondUserName();
         if (username.contentEquals(tempReceiver))
         {
             if (listModellistModelacc.contains("No Game Requests")) //clear out the list
             {
                 listModellistModelacc.removeElement("No Game Requests");
             }
            resultlist.add(rst); //save result for latr
            listModellistModelacc.addElement(rst.getSecondUserName()); //the person who sent it. \
            playButton.setEnabled(true);
            playsound("newgame.mp3");
            //Saved. I can always go there and play. Good. Second Time
         }

    } else if (rst.getGameType()==2 && rst.getFirstUserName() !=null && rst.getSecondUserName() !=null) {
         String tempReceiver = rst.getSecondUserName();
         String sendusername = rst.getFirstUserName();
         if (username.contentEquals(tempReceiver))
         {
            if (listModellistModelacc.contains("No Game Requests")) //clear out the list
             {
                 listModellistModelacc.removeElement("No Game Requests");
             }
            resultlist.add(rst); //save result for latr
            listModellistModelacc.addElement(rst.getFirstUserName()); //the person who sent it. \
            playButton.setEnabled(true);
            playsound("button.mp3");
            //Saved. I can always go there and display result
         }

    }
     /*
     String fling =listModellistModelacc.firstElement().toString();
      if (!fling.contains("No Game Requests"))
            playButton.setEnabled(true);
           else
               playButton.setEnabled(false); */
           
            AcceptList.repaint(); 
     
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
     
}   

