package Shizzle;


import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.Timer;
import javax.swing.border.BevelBorder;
import jaco.mp3.player.MP3Player;
import java.awt.Image;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author owoye001
 */
public class Game_1 extends javax.swing.JFrame {
    private final int usermax =500;
    private final int GameTime = 151000; //151000
public static String[] dicWords; //dictionary words
    public boolean Godfather = false; //test if user is already spelling words
    public String wordspell; //store the word spelled after mouse up
    public int[] scoresheetvalue = new int[usermax]; //stores the score sheet 
    public String[] scoresheetword = new String[usermax]; //stores the words
    public String[] realscoresheetword = new String [usermax]; //real words array for iteration purpose
    public int anum = 0; //countr for scoresheet value and word arry 
    int sec = 30;
    int min = 2;
    public JButton closebutton;
    
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
    public static int gamenum; //initialize as -1 for normal fuction.
    public static List<String> highscoresnames = new ArrayList<>();
    public static List<Integer> highscorescores = new ArrayList<>();
    public Games tied = new Games(gamenum); // creates object tied to access the array for words -1 for random

    //------------------------------------------
    
    
    String times;
    Timer clockingvalue; //for the clock count down.
    public static String soundbutt ="src\\Shizzle\\Sounds\\button.mp3";
    //------------------------------------------------------------------------
    public javax.swing.JPanel AwarePanel=new javax.swing.JPanel();;
   //-------------------------------------------------------------------------
    //Timer clicker;
//key possible
    private boolean[] l = new boolean[36]; //for checking which label is good or which label is bad. Meaning used.
    public boolean doublescore=false;
    public boolean tripplescore=false;
    public boolean q = false;
    public Timer taq;
    /**
     * Creates new form Game
     */
public static String dirMaker (String dira)
{
    String path;
   File f = new File(System.getProperty("java.class.path"));
        File dir = f.getAbsoluteFile().getParentFile();
        path = dir.toString();
        return path+dira;
}
    private JLabel MainTime = new JLabel();
    private JLabel Words = new JLabel();
    private JLabel score = new JLabel();
    private final Timer timer;
    
    
    public Game_1() {
        //look and feel code
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
        //_____________________________________________________________________
        
        //___________________________________________________________________________
        
        //screen resizing and variable initiations
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        //------------------------------------------------------------------
        MainTime.setFont(new java.awt.Font("Comic Sans MS", 0, 36)); // NOI18N
        MainTime.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        MainTime.setText("2:30");

        Words.setFont(new java.awt.Font("Comic Sans MS", 0, 36)); // NOI18N
        Words.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Words.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        score.setFont(new java.awt.Font("Comic Sans MS", 0, 36)); // NOI18N
        score.setForeground(Color.black);
        score.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        score.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        closebutton = new JButton ("X");        
        
        closebutton.setForeground(Color.black);
        

        MainTime.setFont(new java.awt.Font("Comic Sans MS", 0, 36)); // NOI18N
        MainTime.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        MainTime.setText("2:30");

        Words.setFont(new java.awt.Font("Comic Sans MS", 0, 36)); // NOI18N
        Words.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Words.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        score.setFont(new java.awt.Font("Comic Sans MS", 0, 36)); // NOI18N
        score.setForeground(Color.black);
        score.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        score.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout AwarePanelLayout = new javax.swing.GroupLayout(AwarePanel);
        AwarePanel.setLayout(AwarePanelLayout);
        AwarePanelLayout.setHorizontalGroup(
            AwarePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(AwarePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(MainTime, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50)
                .addComponent(Words, javax.swing.GroupLayout.PREFERRED_SIZE, 507, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(105, 105, 105)
                .addComponent(score, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(202, Short.MAX_VALUE))
        );
        AwarePanelLayout.setVerticalGroup(
            AwarePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(AwarePanelLayout.createSequentialGroup()
                .addContainerGap(38, Short.MAX_VALUE)
                .addGroup(AwarePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(AwarePanelLayout.createSequentialGroup()
                        .addComponent(score, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(AwarePanelLayout.createSequentialGroup()
                        .addGroup(AwarePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(MainTime, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Words, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(22, 22, 22))))
        );
        MainTime.setForeground(Color.black);
        MainTime.repaint();
        add (AwarePanel);
        //----------------------------------------------------------------
        initComponents();
    
        setLayout(null);
        setSize(screenSize);
        getContentPane().setBackground(PropertyCreator.FormBackgroundColor);
        lettercontainer.setBackground(Color.white);  //letter container
        lettercontainer.setLayout(null);
        lettercontainer.setSize((int) screenSize.getWidth() - 100, (int) screenSize.getHeight() - 130);
        lettercontainer.setLocation(((int) screenSize.getWidth() - (int) lettercontainer.getWidth()) / 2, (((int) screenSize.getHeight() - (int) lettercontainer.getHeight()) / 2) + 40);

        AwarePanel.setBackground(lettercontainer.getBackground());
        AwarePanel.setSize((int) screenSize.getWidth() - 100, (int) 80);
        AwarePanel.setLocation(50, 20);
        MainTime.setBackground(lettercontainer.getBackground());
        closebutton.setBackground(lettercontainer.getBackground());
        MainTime.setForeground(Color.black);
        score.setForeground(Color.black);
        score.setBackground(MainTime.getBackground());
        score.setLocation(1036* (int) screenSize.getWidth()/1366, 5 * (int) screenSize.getHeight()/768);
        AwarePanel.setLayout(null);
        MainTime.setLocation(20, 5);
        Words.setBackground(lettercontainer.getBackground());
        Words.setForeground(Color.black);
        Words.setLocation(((int) screenSize.getWidth() - (int) Words.getWidth()) / 2 - 20, 5);
        Words.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
        MainTime.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
        score.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
        
        closebutton.setSize(65 * (int)screenSize.getWidth()/1366, 65 * (int)screenSize.getHeight()/768);
        closebutton.setFont(new java.awt.Font("Comic Sans MS", 0, 22));
        closebutton.setLocation(1160 * (int) screenSize.getWidth()/1366, 5 * (int)screenSize.getHeight()/768);
        closebutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
               playsound();
               clockingvalue.stop();
               taq.stop();
               timer.stop();
               dispose();
            }
            });
        AwarePanel.add(closebutton);
        
          //------------------dictionary file will be loaded here--------------------------

            String path;String filename; String turl1;
         filename ="gamedct.gmp";
        
        File f = new File(System.getProperty("java.class.path"));
        File dir = f.getAbsoluteFile().getParentFile();
        path = dir.toString();
        turl1 =path+"\\Scrabble\\" + filename;
        //________________________________________________________________________________-
     BufferedReader in = null;
        try {
            in = new BufferedReader(new FileReader(turl1));
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
         //String str=null;
         ArrayList<String> lines = new ArrayList();
        String str;
        try {
            while((str = in.readLine()) != null){
                lines.add(str);
            }       } catch (IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
   dicWords = lines.toArray(new String[lines.size()]);
        //---------------------------------------------------
   MainTime.setText("2:30");
   MainTime.setForeground(Color.black);

       taq = new Timer (1000, new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent ae) {
                
                if (min==0 && sec<16)
                {
                if (sec<10) {
                    taq.setDelay(400);
                }
                if (q==false)
                {
                MainTime.setVisible(false);
                q=true;
                }else if (q==true){
                    MainTime.setVisible(true);
                    q=false; 
                }
                playsound();
                }
            }
        });
        taq.start();
        //Timer for display
        clockingvalue = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (sec != 1) {
                    if (sec <= 10) {
                        sec = sec - 1;
                        times = String.valueOf(min) + " : " + String.valueOf(0) + String.valueOf(sec);
                    } else {
                        sec = sec - 1;
                        times = String.valueOf(min) + " : " + String.valueOf(sec);
                    }
                } else {
                   
                    if (min!=0)
                    {
                    sec = 0;
                    }
                    else
                    {
                    sec=60;
                    }
                
                            
                    times = String.valueOf(min) + " : " + String.valueOf(0) + String.valueOf(sec);
                    min = min - 1;
                    sec = 60;
                }

                /*
                 SwingUtilities.invokeLater(new Runnable() { //The EDT //explained below 
                 @Override
                 public void run() {
                 MainTime.setText(times);
                 } 
                 });  */
                //AwarePanel.revalidate();
                MainTime.setText(times);
                if (sec == 0 && min == 0) {
                    clockingvalue.stop();
                    taq.stop();
                    MainTime.setVisible(true);
                }
            }
        });
        //----------------------------GAME TIMER-----------------------------------------------------------
        timer = new Timer(GameTime, new ActionListener() {  //change to 150000 later. 2min 30SEc

            @Override
            public void actionPerformed(ActionEvent ae) {
                if (type==-1)
                {
                ResultPage.seconduserwords =scoresheetword; //new values
                ResultPage.seconduserscores=scoresheetvalue; //new values
                ResultPage.seconduserznum = anum -1; //new values
                ResultPage.type =-1;
                ResultPage.gamenum = gamenum; //new value
                ResultPage resultp = new ResultPage();
                resultp.setVisible(true);
                dispose();
                }
                            
                    
                if (type==0) //first play, needs to be send back. 
                {
                ResultPage.firstusername = firstusername; //old value
                ResultPage.secondusername = secondusername; //old value
                ResultPage.type=1; //type upgrade one game play
                ResultPage.firstusername = firstusername;
                ResultPage.firstuserwords = firstuserwords; //old value
                ResultPage.firstuserscores= firstuserscores; //old value
                ResultPage.firstuserznum = firstuserznum; //old value 
                ResultPage.secondusername = secondusername; //old value
                ResultPage.seconduserwords =scoresheetword; //new values
                ResultPage.seconduserscores=scoresheetvalue; //new values
                ResultPage.seconduserznum = anum -1; //new values
                ResultPage.gamenum = gamenum; //new value
                ResultPage resultp = new ResultPage();
                resultp.setVisible(true);
                dispose();
                }
                else if (type==1)
                {
                ResultPageMulti.firstusername = firstusername; //old value
                ResultPageMulti.secondusername = secondusername; //old value
                ResultPageMulti.type=2; //type upgrade two game play
                ResultPageMulti.firstuserwords = scoresheetword; //old value
                ResultPageMulti.firstuserscores= scoresheetvalue; //old value
                ResultPageMulti.firstuserznum = anum -1; //old value 
                ResultPageMulti.seconduserwords =seconduserwords; //new values
                ResultPageMulti.seconduserscores=seconduserscores; //new values
                ResultPageMulti.seconduserznum = seconduserznum; //new values
                ResultPageMulti.gamenum = gamenum; //old value
                ResultPageMulti rpm = new ResultPageMulti();
                rpm.setVisible(true);
                dispose();
                }
            }
        });

        timer.setRepeats(false);
        timer.start();
        clockingvalue.start();
        
        
        //----------------------------------------------------------------------------------------------------------

        for (int i = 0; i < 36; i++) {
            l[i] = true;
        }

        int widthlabel, heightlabel, widthlabeltrue;

        widthlabel = ((int) lettercontainer.getWidth() / 6);
        heightlabel = ((int) lettercontainer.getHeight() / 6);
        widthlabeltrue = ((int) lettercontainer.getWidth() / 6) - 88;
        
        //ADDING AN EVENT HANDLING TO ALL 36 LETTER ON THE SCREEN
        //YES I KNOW IT IS RIDICULOUS, BUT IT WORKS

        jLabel1.setSize(widthlabeltrue, heightlabel - 8);
        jLabel1.setLocation(50, 0);
        jLabel1.setText("");
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("Scrabble/" + tied.alpha(1, 1) + ".jpg")));
        jLabel1.addMouseListener(new MouseAdapter() {
        
            @Override
            public void mousePressed(MouseEvent e) {

                jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("Scrabble/" + tied.alpha(1, 1) + tied.alpha(1, 1) + ".jpg")));
                if (Godfather == false) {
                    Godfather = true;
                    l[0] = false;
                    Words.setText(tied.alpha(1, 1));
                    doublescore=true; //for double word score
                    playsound ();
                }

            }

            @Override
            public void mouseReleased(MouseEvent e) {
                doublescore=true; //for double word score
                wordspell = Words.getText();
                checkword(wordspell); //check word and grades it at the same time 
                for (int i = 0; i < 36; i++) {
                    l[i] = true;
                } //all letter are good again with this enablement 
                Words.setText("");
                Godfather = false;
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                //System.out.println("mouse entered!");
                if (Godfather == true && l[0] == true) {
                    Words.setText(Words.getText() + tied.alpha(1, 1));
                    l[0] = false;
                    doublescore=true;
                    playsound ();
                } else if (Godfather == true && l[0] == false) //used letter
                {
                    doublescore=true; //double score
                    wordspell = Words.getText();
                    checkword(wordspell);
                    for (int i = 0; i < 36; i++) {
                        l[i] = true;
                    }
                    Words.setText("");
                    Godfather = false;
                }
                jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("Scrabble/" + tied.alpha(1, 1) + tied.alpha(1, 1) + ".jpg")));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                //System.out.println("mouse exit!");
                jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("Scrabble/" + tied.alpha(1, 1) + ".jpg")));
            }
        });

        jLabel2.setSize(widthlabeltrue, heightlabel - 8);
        jLabel2.setLocation(widthlabel + 50, 0);
        jLabel2.setText("");
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("Scrabble/" + tied.alpha(1, 2) + ".jpg")));
        jLabel2.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                if (Godfather == true && l[1] == true) {
                    Words.setText(Words.getText() + tied.alpha(1, 2));
                    l[1] = false;
                    playsound ();
                } else if (Godfather == true && l[1] == false) //used letter
                {
                    wordspell = Words.getText();
                    checkword(wordspell);
                    for (int i = 1; i < 36; i++) {
                        l[i] = true;
                    }
                    Words.setText("");
                    Godfather = false;
                }
                jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("Scrabble/" + tied.alpha(1, 2) + tied.alpha(1, 2) + ".jpg")));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("Scrabble/" + tied.alpha(1, 2) + ".jpg")));
            }

            @Override
            public void mousePressed(MouseEvent e) {
                jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("Scrabble/" + tied.alpha(1, 2) + tied.alpha(1, 2) + ".jpg")));
                if (Godfather == false) {
                    Godfather = true;
                    l[1] = false;
                    Words.setText(tied.alpha(1, 2));
                    playsound ();
                }
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                wordspell = Words.getText();
                checkword(wordspell);
                for (int i = 1; i < 36; i++) {
                    l[i] = true;
                }
                Words.setText("");
                Godfather = false;
            }
        });

        jLabel3.setSize(widthlabeltrue, heightlabel - 8);
        jLabel3.setLocation(2 * widthlabel + 50, 0);
        jLabel3.setText("");
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("Scrabble/" + tied.alpha(1, 3) + ".jpg")));
        jLabel3.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("Scrabble/" + tied.alpha(1, 3) + tied.alpha(1, 3) + ".jpg")));
                if (Godfather == false) {
                    Godfather = true;
                    l[2] = false;
                    Words.setText(tied.alpha(1, 3));
                playsound ();
                }
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                wordspell = Words.getText();
                checkword(wordspell);
                for (int i = 0; i < 36; i++) {
                    l[i] = true;
                }
                Words.setText("");
                Godfather = false;
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                if (Godfather == true && l[2] == true) {
                    Words.setText(Words.getText() + tied.alpha(1, 3));
                    l[2] = false;
                playsound ();
                } else if (Godfather == true && l[2] == false) //used letter
                {
                    wordspell = Words.getName();
                    checkword(wordspell);
                    for (int i = 0; i < 36; i++) {
                        l[i] = true;
                    }
                    Words.setText("");
                    Godfather = false;
                }
                jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("Scrabble/" + tied.alpha(1, 3) + tied.alpha(1, 3) + ".jpg")));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("Scrabble/" + tied.alpha(1, 3) + ".jpg")));
            }
        });

        jLabel4.setSize(widthlabeltrue, heightlabel - 8);
        jLabel4.setLocation(3 * widthlabel + 50, 0);
        jLabel4.setText("");
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("Scrabble/" + tied.alpha(1, 4) + ".jpg")));
        jLabel4.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("Scrabble/" + tied.alpha(1, 4) + tied.alpha(1, 4) + ".jpg")));
                if (Godfather == false) {
                    Godfather = true;
                    l[3] = false;
                    Words.setText(tied.alpha(1, 4));
                playsound ();
                }
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                if (Godfather == true && l[3] == true) {
                    Words.setText(Words.getText() + tied.alpha(1, 4));
                    l[3] = false;
                playsound ();
                } else if (Godfather == true && l[3] == false) //used letter
                {
                    wordspell = Words.getName();
                    checkword(wordspell);
                    for (int i = 0; i < 36; i++) {
                        l[i] = true;
                    }
                    Words.setText("");
                    Godfather = false;
                }
                jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("Scrabble/" + tied.alpha(1, 4) + tied.alpha(1, 4) + ".jpg")));
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                wordspell = Words.getText();
                checkword(wordspell);
                for (int i = 0; i < 36; i++) {
                    l[i] = true;
                }
                Words.setText("");
                Godfather = false;
            }

            @Override
            public void mouseExited(MouseEvent e) {
                jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("Scrabble/" + tied.alpha(1, 4) + ".jpg")));
            }
        });

        jLabel5.setSize(widthlabeltrue, heightlabel - 8);
        jLabel5.setLocation(4 * widthlabel + 50, 0);
        jLabel5.setText("");
        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("Scrabble/" + tied.alpha(1, 5) + ".jpg")));
        jLabel5.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                if (Godfather == true && l[4] == true) {
                    Words.setText(Words.getText() + tied.alpha(1, 5));
                    l[4] = false;
                playsound ();
                } else if (Godfather == true && l[4] == false) //used letter
                {
                    wordspell = Words.getName();
                    checkword(wordspell);
                    for (int i = 0; i < 36; i++) {
                        l[i] = true;
                    }
                    Words.setText("");
                    Godfather = false;
                }
                jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("Scrabble/" + tied.alpha(1, 5) + tied.alpha(1, 5) + ".jpg")));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("Scrabble/" + tied.alpha(1, 5) + ".jpg")));
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                wordspell = Words.getText();
                checkword(wordspell);
                for (int i = 0; i < 36; i++) {
                    l[i] = true;
                }
                Words.setText("");
                Godfather = false;
            }

            @Override
            public void mousePressed(MouseEvent e) {
                jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("Scrabble/" + tied.alpha(1, 5) + tied.alpha(1, 5) + ".jpg")));
                if (Godfather == false) {
                    Godfather = true;
                    l[4] = false;
                    Words.setText(tied.alpha(1, 5));
                playsound ();
                }
            }
        });

        jLabel6.setSize(widthlabeltrue, heightlabel - 8);
        jLabel6.setLocation(5 * widthlabel + 50, 0);
        jLabel6.setText("");
        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("Scrabble/" + tied.alpha(1, 6) + ".jpg")));
        jLabel6.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                if (Godfather == true && l[5] == true) {
                    Words.setText(Words.getText() + tied.alpha(1, 6));
                    l[5] = false;
                    doublescore=true;
                playsound ();
                } else if (Godfather == true && l[5] == false) //used letter
                {
                    doublescore=true;
                    wordspell = Words.getName();
                    checkword(wordspell);
                    for (int i = 0; i < 36; i++) {
                        l[i] = true;
                    }
                    Words.setText("");
                    Godfather = false;
                }
                jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("Scrabble/" + tied.alpha(1, 6) + tied.alpha(1, 6) + ".jpg")));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("Scrabble/" + tied.alpha(1, 6) + ".jpg")));
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                doublescore=true;
                wordspell = Words.getText();
                checkword(wordspell);
                for (int i = 0; i < 36; i++) {
                    l[i] = true;
                }
                Words.setText("");
                Godfather = false;
            }

            @Override
            public void mousePressed(MouseEvent e) {
                jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("Scrabble/" + tied.alpha(1, 6) + tied.alpha(1, 6) + ".jpg")));
                if (Godfather == false) {
                    Godfather = true;
                    l[5] = false;
                    Words.setText(tied.alpha(1, 6));
                    doublescore=true;
                playsound ();
                }
            }
        });

        jLabel7.setSize(widthlabeltrue, heightlabel - 8);
        jLabel7.setLocation(50, heightlabel);
        jLabel7.setText("");
        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("Scrabble/" + tied.alpha(2, 1) + ".jpg")));
        jLabel7.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                if (Godfather == true && l[6] == true) {
                    Words.setText(Words.getText() + tied.alpha(2, 1));
                    l[6] = false;
                playsound ();
                } else if (Godfather == true && l[6] == false) //used letter
                {
                    wordspell = Words.getName();
                    checkword(wordspell);
                    for (int i = 0; i < 36; i++) {
                        l[i] = true;
                    }
                    Words.setText("");
                    Godfather = false;
                }
                jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("Scrabble/" + tied.alpha(2, 1) + tied.alpha(2, 1) + ".jpg")));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("Scrabble/" + tied.alpha(2, 1) + ".jpg")));
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                wordspell = Words.getText();
                checkword(wordspell);
                for (int i = 0; i < 36; i++) {
                    l[i] = true;
                }
                Words.setText("");
                Godfather = false;
            }

            @Override
            public void mousePressed(MouseEvent e) {
                jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("Scrabble/" + tied.alpha(2, 1) + tied.alpha(2, 1) + ".jpg")));
                if (Godfather == false) {
                    Godfather = true;
                    l[6] = false;
                    Words.setText(tied.alpha(2, 1));
                playsound ();
                }
            }
        });

        jLabel8.setSize(widthlabeltrue, heightlabel - 8);
        jLabel8.setLocation((widthlabel) + 50, heightlabel);
        jLabel8.setText("");
        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("Scrabble/" + tied.alpha(2, 2) + ".jpg")));
        jLabel8.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                if (Godfather == true && l[7] == true) {
                    Words.setText(Words.getText() + tied.alpha(2, 2));
                    l[7] = false;
                playsound ();
                } else if (Godfather == true && l[7] == false) //used letter
                {
                    wordspell = Words.getName();
                    checkword(wordspell);
                    for (int i = 0; i < 36; i++) {
                        l[i] = true;
                    }
                    Words.setText("");
                    Godfather = false;
                }
                jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("Scrabble/" + tied.alpha(2, 2) + tied.alpha(2, 2) + ".jpg")));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("Scrabble/" + tied.alpha(2, 2) + ".jpg")));
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                wordspell = Words.getText();
                checkword(wordspell);
                for (int i = 0; i < 36; i++) {
                    l[i] = true;
                }
                Words.setText("");
                Godfather = false;
            }

            @Override
            public void mousePressed(MouseEvent e) {
                jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("Scrabble/" + tied.alpha(2, 2) + tied.alpha(2, 2) + ".jpg")));
                if (Godfather == false) {
                    Godfather = true;
                    l[7] = false;
                    Words.setText(tied.alpha(2, 2));
                playsound ();
                }
            }
        });

        jLabel9.setSize(widthlabeltrue, heightlabel - 8);
        jLabel9.setLocation(2 * (widthlabel) + 50, heightlabel);
        jLabel9.setText("");
        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("Scrabble/" + tied.alpha(2, 3) + ".jpg")));
        jLabel9.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                if (Godfather == true && l[8] == true) {
                    Words.setText(Words.getText() + tied.alpha(2, 3));
                    l[8] = false;
                playsound ();
                } else if (Godfather == true && l[8] == false) //used letter
                {
                    wordspell = Words.getName();
                    checkword(wordspell);
                    for (int i = 0; i < 36; i++) {
                        l[i] = true;
                    }
                    Words.setText("");
                    Godfather = false;
                }
                jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("Scrabble/" + tied.alpha(2, 3) + tied.alpha(2, 3) + ".jpg")));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("Scrabble/" + tied.alpha(2, 3) + ".jpg")));
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                wordspell = Words.getText();
                checkword(wordspell);
                for (int i = 0; i < 36; i++) {
                    l[i] = true;
                }
                Words.setText("");
                Godfather = false;
            }

            @Override
            public void mousePressed(MouseEvent e) {
                jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("Scrabble/" + tied.alpha(2, 3) + tied.alpha(2, 3) + ".jpg")));
                if (Godfather == false) {
                    Godfather = true;
                    l[8] = false;
                    Words.setText(tied.alpha(2, 3));
                playsound ();
                }
            }
        });

        jLabel10.setSize(widthlabeltrue, heightlabel - 8);
        jLabel10.setLocation(3 * (widthlabel) + 50, heightlabel);
        jLabel10.setText("");
        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("Scrabble/" + tied.alpha(2, 4) + ".jpg")));
        jLabel10.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                if (Godfather == true && l[9] == true) {
                    Words.setText(Words.getText() + tied.alpha(2, 4));
                    l[9] = false;
                playsound ();
                } else if (Godfather == true && l[9] == false) //used letter
                {
                    wordspell = Words.getName();
                    for (int i = 0; i < 36; i++) {
                        l[i] = true;
                    }
                    Words.setText("");
                    Godfather = false;
                }
                jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("Scrabble/" + tied.alpha(2, 4) + tied.alpha(2, 4) + ".jpg")));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("Scrabble/" + tied.alpha(2, 4) + ".jpg")));
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                wordspell = Words.getText();
                checkword(wordspell);
                for (int i = 0; i < 36; i++) {
                    l[i] = true;
                }
                Words.setText("");
                Godfather = false;
            }

            @Override
            public void mousePressed(MouseEvent e) {
                jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("Scrabble/" + tied.alpha(2, 4) + tied.alpha(2, 4) + ".jpg")));
                if (Godfather == false) {
                    Godfather = true;
                    l[9] = false;
                    Words.setText(tied.alpha(2, 4));
                playsound ();
                }
            }
        });

        jLabel11.setSize(widthlabeltrue, heightlabel - 8);
        jLabel11.setLocation(4 * (widthlabel) + 50, heightlabel);
        jLabel11.setText("");
        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("Scrabble/" + tied.alpha(2, 5) + ".jpg")));
        jLabel11.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                if (Godfather == true && l[10] == true) {
                    Words.setText(Words.getText() + tied.alpha(2, 5));
                    l[10] = false;
                playsound ();
                } else if (Godfather == true && l[10] == false) //used letter
                {
                    wordspell = Words.getName();
                    checkword(wordspell);
                    for (int i = 0; i < 36; i++) {
                        l[i] = true;
                    }
                    Words.setText("");
                    Godfather = false;
                }
                jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("Scrabble/" + tied.alpha(2, 5) + tied.alpha(2, 5) + ".jpg")));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("Scrabble/" + tied.alpha(2, 5) + ".jpg")));
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                wordspell = Words.getText();
                checkword(wordspell);
                for (int i = 0; i < 36; i++) {
                    l[i] = true;
                }
                Words.setText("");
                Godfather = false;
            }

            @Override
            public void mousePressed(MouseEvent e) {
                jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("Scrabble/" + tied.alpha(2, 5) + tied.alpha(2, 5) + ".jpg")));
                if (Godfather == false) {
                    Godfather = true;
                    l[10] = false;
                    Words.setText(tied.alpha(2, 5));
                playsound ();
                }
            }
        });

        jLabel12.setSize(widthlabeltrue, heightlabel - 8);
        jLabel12.setLocation(5 * (widthlabel) + 50, heightlabel);
        jLabel12.setText("");
        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("Scrabble/" + tied.alpha(2, 6) + ".jpg")));
        jLabel12.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                if (Godfather == true && l[11] == true) {
                    Words.setText(Words.getText() + tied.alpha(2, 6));
                    l[11] = false;
                playsound ();
                } else if (Godfather == true && l[11] == false) //used letter
                {
                    wordspell = Words.getName();
                    checkword(wordspell);
                    for (int i = 0; i < 36; i++) {
                        l[i] = true;
                    }
                    Words.setText("");
                    Godfather = false;
                }
                jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("Scrabble/" + tied.alpha(2, 6) + tied.alpha(2, 6) + ".jpg")));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("Scrabble/" + tied.alpha(2, 6) + ".jpg")));
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                wordspell = Words.getText();
                checkword(wordspell);
                for (int i = 0; i < 36; i++) {
                    l[i] = true;
                }
                Words.setText("");
                Godfather = false;
            }

            @Override
            public void mousePressed(MouseEvent e) {
                jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("Scrabble/" + tied.alpha(2, 6) + tied.alpha(2, 6) + ".jpg")));
                if (Godfather == false) {
                    Godfather = true;
                    l[11] = false;
                    Words.setText(tied.alpha(2, 6));
            playsound ();
                }
            }
        });

        jLabel13.setSize(widthlabeltrue, heightlabel - 8);
        jLabel13.setLocation(50, 2 * heightlabel);
        jLabel13.setText("");
        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("Scrabble/" + tied.alpha(3, 1) + ".jpg")));
        jLabel13.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                if (Godfather == true && l[12] == true) {
                    Words.setText(Words.getText() + tied.alpha(3, 1));
                    l[12] = false;
                playsound ();
                } else if (Godfather == true && l[12] == false) //used letter
                {
                    wordspell = Words.getName();
                    checkword(wordspell);
                    for (int i = 0; i < 36; i++) {
                        l[i] = true;
                    }
                    Words.setText("");
                    Godfather = false;
                }
                jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("Scrabble/" + tied.alpha(3, 1) + tied.alpha(3, 1) + ".jpg")));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("Scrabble/" + tied.alpha(3, 1) + ".jpg")));
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                wordspell = Words.getText();
                checkword(wordspell);
                for (int i = 0; i < 36; i++) {
                    l[i] = true;
                }
                Words.setText("");
                Godfather = false;
            }

            @Override
            public void mousePressed(MouseEvent e) {
                jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("Scrabble/" + tied.alpha(3, 1) + tied.alpha(3, 1) + ".jpg")));
                if (Godfather == false) {
                    Godfather = true;
                    l[12] = false;
                    Words.setText(tied.alpha(3, 1));
                playsound ();
                }
            }
        });

        jLabel14.setSize(widthlabeltrue, heightlabel - 8);
        jLabel14.setLocation((widthlabel) + 50, 2 * heightlabel);
        jLabel14.setText("");
        jLabel14.setIcon(new javax.swing.ImageIcon(getClass().getResource("Scrabble/" + tied.alpha(3, 2) + ".jpg")));
        jLabel14.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                if (Godfather == true && l[13] == true) {
                    Words.setText(Words.getText() + tied.alpha(3, 2));
                    l[13] = false;
                playsound ();
                } else if (Godfather == true && l[13] == false) //used letter
                {
                    wordspell = Words.getName();
                    checkword(wordspell);
                    for (int i = 0; i < 36; i++) {
                        l[i] = true;
                    }
                    Words.setText("");
                    Godfather = false;
                }
                jLabel14.setIcon(new javax.swing.ImageIcon(getClass().getResource("Scrabble/" + tied.alpha(3, 2) + tied.alpha(3, 2) + ".jpg")));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                jLabel14.setIcon(new javax.swing.ImageIcon(getClass().getResource("Scrabble/" + tied.alpha(3, 2) + ".jpg")));
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                wordspell = Words.getText();
                checkword(wordspell);
                for (int i = 0; i < 36; i++) {
                    l[i] = true;
                }
                Words.setText("");
                Godfather = false;
            }

            @Override
            public void mousePressed(MouseEvent e) {
                jLabel14.setIcon(new javax.swing.ImageIcon(getClass().getResource("Scrabble/" + tied.alpha(3, 2) + tied.alpha(3, 2) + ".jpg")));
                if (Godfather == false) {
                    Godfather = true;
                    l[13] = false;
                    Words.setText(tied.alpha(3, 2));
                playsound ();
                }
            }
        });

        jLabel15.setSize(widthlabeltrue, heightlabel - 8);
        jLabel15.setLocation(2 * (widthlabel) + 50, 2 * heightlabel);
        jLabel15.setText("");
        jLabel15.setIcon(new javax.swing.ImageIcon(getClass().getResource("Scrabble/" + tied.alpha(3, 3) + ".jpg")));
        jLabel15.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                if (Godfather == true && l[14] == true) {
                    Words.setText(Words.getText() + tied.alpha(3, 3));
                    l[14] = false;
                playsound ();
                } else if (Godfather == true && l[14] == false) //used letter
                {
                    wordspell = Words.getName();
                    checkword(wordspell);
                    for (int i = 0; i < 36; i++) {
                        l[i] = true;
                    }
                    Words.setText("");
                    Godfather = false;
                }
                jLabel15.setIcon(new javax.swing.ImageIcon(getClass().getResource("Scrabble/" + tied.alpha(3, 3) + tied.alpha(3, 3) + ".jpg")));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                jLabel15.setIcon(new javax.swing.ImageIcon(getClass().getResource("Scrabble/" + tied.alpha(3, 3) + ".jpg")));
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                wordspell = Words.getText();
                checkword(wordspell);
                for (int i = 0; i < 36; i++) {
                    l[i] = true;
                }
                Words.setText("");
                Godfather = false;
            }

            @Override
            public void mousePressed(MouseEvent e) {
                jLabel15.setIcon(new javax.swing.ImageIcon(getClass().getResource("Scrabble/" + tied.alpha(3, 3) + tied.alpha(3, 3) + ".jpg")));
                if (Godfather == false) {
                    Godfather = true;
                    l[14] = false;
                    Words.setText(tied.alpha(3, 3));
                playsound ();
                }
            }
        });

        jLabel16.setSize(widthlabeltrue, heightlabel - 8);
        jLabel16.setLocation(3 * (widthlabel) + 50, 2 * heightlabel);
        jLabel16.setText("");
        jLabel16.setIcon(new javax.swing.ImageIcon(getClass().getResource("Scrabble/" + tied.alpha(3, 4) + ".jpg")));
        jLabel16.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                if (Godfather == true && l[15] == true) {
                    Words.setText(Words.getText() + tied.alpha(3, 4));
                    l[15] = false;
                playsound ();
                } else if (Godfather == true && l[15] == false) //used letter
                {
                    wordspell = Words.getName();
                    checkword(wordspell);
                    for (int i = 0; i < 36; i++) {
                        l[i] = true;
                    }
                    Words.setText("");
                    Godfather = false;
                }
                jLabel16.setIcon(new javax.swing.ImageIcon(getClass().getResource("Scrabble/" + tied.alpha(3, 4) + tied.alpha(3, 4) + ".jpg")));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                jLabel16.setIcon(new javax.swing.ImageIcon(getClass().getResource("Scrabble/" + tied.alpha(3, 4) + ".jpg")));
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                wordspell = Words.getText();
                checkword(wordspell);
                for (int i = 0; i < 36; i++) {
                    l[i] = true;
                }
                Words.setText("");
                Godfather = false;
            }

            @Override
            public void mousePressed(MouseEvent e) {
                jLabel16.setIcon(new javax.swing.ImageIcon(getClass().getResource("Scrabble/" + tied.alpha(3, 4) + tied.alpha(3, 4) + ".jpg")));
                if (Godfather == false) {
                    Godfather = true;
                    l[15] = false;
                    Words.setText(tied.alpha(3, 4));
                playsound ();
                }
            }
        });

        jLabel17.setSize(widthlabeltrue, heightlabel - 8);
        jLabel17.setLocation(4 * (widthlabel) + 50, 2 * heightlabel);
        jLabel17.setText("");
        jLabel17.setIcon(new javax.swing.ImageIcon(getClass().getResource("Scrabble/" + tied.alpha(3, 5) + ".jpg")));
        jLabel17.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                if (Godfather == true && l[16] == true) {
                    Words.setText(Words.getText() + tied.alpha(3, 5));
                    l[16] = false;
                playsound ();
                } else if (Godfather == true && l[16] == false) //used letter
                {
                    wordspell = Words.getName();
                    checkword(wordspell);
                    for (int i = 0; i < 36; i++) {
                        l[i] = true;
                    }
                    Words.setText("");
                    Godfather = false;
                }
                jLabel17.setIcon(new javax.swing.ImageIcon(getClass().getResource("Scrabble/" + tied.alpha(3, 5) + tied.alpha(3, 5) + ".jpg")));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                jLabel17.setIcon(new javax.swing.ImageIcon(getClass().getResource("Scrabble/" + tied.alpha(3, 5) + ".jpg")));
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                wordspell = Words.getText();
                checkword(wordspell);
                for (int i = 0; i < 36; i++) {
                    l[i] = true;
                }
                Words.setText("");
                Godfather = false;
            }

            @Override
            public void mousePressed(MouseEvent e) {
                jLabel17.setIcon(new javax.swing.ImageIcon(getClass().getResource("Scrabble/" + tied.alpha(3, 5) + tied.alpha(3, 5) + ".jpg")));
                if (Godfather == false) {
                    Godfather = true;
                    l[16] = false;
                    Words.setText(tied.alpha(3, 5));
                playsound ();
                }
            }
        });

        jLabel18.setSize(widthlabeltrue, heightlabel - 8);
        jLabel18.setLocation(5 * (widthlabel) + 50, 2 * heightlabel);
        jLabel18.setText("");
        jLabel18.setIcon(new javax.swing.ImageIcon(getClass().getResource("Scrabble/" + tied.alpha(3, 6) + ".jpg")));
        jLabel18.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                if (Godfather == true && l[17] == true) {
                    Words.setText(Words.getText() + tied.alpha(3, 6));
                    l[17] = false;
                playsound ();
                } else if (Godfather == true && l[17] == false) //used letter
                {
                    wordspell = Words.getName();
                    checkword(wordspell);
                    for (int i = 0; i < 36; i++) {
                        l[i] = true;
                    }
                    Words.setText("");
                    Godfather = false;
                }
                jLabel18.setIcon(new javax.swing.ImageIcon(getClass().getResource("Scrabble/" + tied.alpha(3, 6) + tied.alpha(3, 6) + ".jpg")));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                jLabel18.setIcon(new javax.swing.ImageIcon(getClass().getResource("Scrabble/" + tied.alpha(3, 6) + ".jpg")));
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                wordspell = Words.getText();
                checkword(wordspell);
                for (int i = 0; i < 36; i++) {
                    l[i] = true;
                }
                Words.setText("");
                Godfather = false;
            }

            @Override
            public void mousePressed(MouseEvent e) {
                jLabel18.setIcon(new javax.swing.ImageIcon(getClass().getResource("Scrabble/" + tied.alpha(3, 6) + tied.alpha(3, 6) + ".jpg")));
                if (Godfather == false) {
                    Godfather = true;
                    l[17] = false;
                    Words.setText(tied.alpha(3, 6));
                playsound ();
                }
            }
        });

        jLabel19.setSize(widthlabeltrue, heightlabel - 8);
        jLabel19.setLocation(50, 3 * heightlabel);
        jLabel19.setText("");
        jLabel19.setIcon(new javax.swing.ImageIcon(getClass().getResource("Scrabble/" + tied.alpha(4, 1) + ".jpg")));
        jLabel19.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                if (Godfather == true && l[18] == true) {
                    Words.setText(Words.getText() + tied.alpha(4, 1));
                    l[18] = false;
                playsound ();
                } else if (Godfather == true && l[18] == false) //used letter
                {
                    wordspell = Words.getName();
                    checkword(wordspell);
                    for (int i = 0; i < 36; i++) {
                        l[i] = true;
                    }
                    Words.setText("");
                    Godfather = false;
                }
                jLabel19.setIcon(new javax.swing.ImageIcon(getClass().getResource("Scrabble/" + tied.alpha(4, 1) + tied.alpha(4, 1) + ".jpg")));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                jLabel19.setIcon(new javax.swing.ImageIcon(getClass().getResource("Scrabble/" + tied.alpha(4, 1) + ".jpg")));
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                wordspell = Words.getText();
                checkword(wordspell);
                for (int i = 0; i < 36; i++) {
                    l[i] = true;
                }
                Words.setText("");
                Godfather = false;
            }

            @Override
            public void mousePressed(MouseEvent e) {
                jLabel19.setIcon(new javax.swing.ImageIcon(getClass().getResource("Scrabble/" + tied.alpha(4, 1) + tied.alpha(4, 1) + ".jpg")));
                if (Godfather == false) {
                    Godfather = true;
                    l[18] = false;
                    Words.setText(tied.alpha(4, 1));
                playsound ();
                }
            }
        });

        jLabel20.setSize(widthlabeltrue, heightlabel - 8);
        jLabel20.setLocation((widthlabel) + 50, 3 * heightlabel);
        jLabel20.setText("");
        jLabel20.setIcon(new javax.swing.ImageIcon(getClass().getResource("Scrabble/" + tied.alpha(4, 2) + ".jpg")));
        jLabel20.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                if (Godfather == true && l[19] == true) {
                    Words.setText(Words.getText() + tied.alpha(4, 2));
                    l[19] = false;
                playsound ();
                } else if (Godfather == true && l[19] == false) //used letter
                {
                    wordspell = Words.getName();
                    checkword(wordspell);
                    for (int i = 0; i < 36; i++) {
                        l[i] = true;
                    }
                    Words.setText("");
                    Godfather = false;
                }
                jLabel20.setIcon(new javax.swing.ImageIcon(getClass().getResource("Scrabble/" + tied.alpha(4, 2) + tied.alpha(4, 2) + ".jpg")));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                jLabel20.setIcon(new javax.swing.ImageIcon(getClass().getResource("Scrabble/" + tied.alpha(4, 2) + ".jpg")));
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                wordspell = Words.getText();
                checkword(wordspell);
                for (int i = 0; i < 36; i++) {
                    l[i] = true;
                }
                Words.setText("");
                Godfather = false;
            }

            @Override
            public void mousePressed(MouseEvent e) {
                jLabel20.setIcon(new javax.swing.ImageIcon(getClass().getResource("Scrabble/" + tied.alpha(4, 2) + tied.alpha(4, 2) + ".jpg")));
                if (Godfather == false) {
                    Godfather = true;
                    l[19] = false;
                    Words.setText(tied.alpha(4, 2));
                playsound ();
                }
            }
        });

        jLabel21.setSize(widthlabeltrue, heightlabel - 8);
        jLabel21.setLocation(2 * (widthlabel) + 50, 3 * heightlabel);
        jLabel21.setText("");
        jLabel21.setIcon(new javax.swing.ImageIcon(getClass().getResource("Scrabble/" + tied.alpha(4, 3) + ".jpg")));
        jLabel21.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                if (Godfather == true && l[20] == true) {
                    Words.setText(Words.getText() + tied.alpha(4, 3));
                    l[20] = false;
                playsound ();
                } else if (Godfather == true && l[20] == false) //used letter
                {
                    wordspell = Words.getName();
                    checkword(wordspell);
                    for (int i = 0; i < 36; i++) {
                        l[i] = true;
                    }
                    Words.setText("");
                    Godfather = false;
                }
                jLabel21.setIcon(new javax.swing.ImageIcon(getClass().getResource("Scrabble/" + tied.alpha(4, 3) + tied.alpha(4, 3) + ".jpg")));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                jLabel21.setIcon(new javax.swing.ImageIcon(getClass().getResource("Scrabble/" + tied.alpha(4, 3) + ".jpg")));
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                wordspell = Words.getText();
                checkword(wordspell);
                for (int i = 0; i < 36; i++) {
                    l[i] = true;
                }
                Words.setText("");
                Godfather = false;
            }

            @Override
            public void mousePressed(MouseEvent e) {
                jLabel21.setIcon(new javax.swing.ImageIcon(getClass().getResource("Scrabble/" + tied.alpha(4, 3) + tied.alpha(4, 3) + ".jpg")));
                if (Godfather == false) {
                    Godfather = true;
                    l[20] = false;
                    Words.setText(tied.alpha(4, 3));
                playsound ();
                }
            }
        });

        jLabel22.setSize(widthlabeltrue, heightlabel - 8);
        jLabel22.setLocation(3 * (widthlabel) + 50, 3 * heightlabel);
        jLabel22.setText("");
        jLabel22.setIcon(new javax.swing.ImageIcon(getClass().getResource("Scrabble/" + tied.alpha(4, 4) + ".jpg")));
        jLabel22.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                if (Godfather == true && l[21] == true) {
                    Words.setText(Words.getText() + tied.alpha(4, 4));
                    l[21] = false;
                playsound ();
                } else if (Godfather == true && l[21] == false) //used letter
                {
                    wordspell = Words.getName();
                    checkword(wordspell);
                    for (int i = 0; i < 36; i++) {
                        l[i] = true;
                    }
                    Words.setText("");
                    Godfather = false;
                }
                jLabel22.setIcon(new javax.swing.ImageIcon(getClass().getResource("Scrabble/" + tied.alpha(4, 4) + tied.alpha(4, 4) + ".jpg")));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                jLabel22.setIcon(new javax.swing.ImageIcon(getClass().getResource("Scrabble/" + tied.alpha(4, 4) + ".jpg")));
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                wordspell = Words.getText();
                checkword(wordspell);
                for (int i = 0; i < 36; i++) {
                    l[i] = true;
                }
                Words.setText("");
                Godfather = false;
            }

            @Override
            public void mousePressed(MouseEvent e) {
                jLabel22.setIcon(new javax.swing.ImageIcon(getClass().getResource("Scrabble/" + tied.alpha(4, 4) + tied.alpha(4, 4) + ".jpg")));
                if (Godfather == false) {
                    Godfather = true;
                    l[21] = false;
                    Words.setText(tied.alpha(4, 4));
                playsound ();
                }
            }
        });

        jLabel23.setSize(widthlabeltrue, heightlabel - 8);
        jLabel23.setLocation(4 * (widthlabel) + 50, 3 * heightlabel);
        jLabel23.setText("");
        jLabel23.setIcon(new javax.swing.ImageIcon(getClass().getResource("Scrabble/" + tied.alpha(4, 5) + ".jpg")));
        jLabel23.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                if (Godfather == true && l[22] == true) {
                    Words.setText(Words.getText() + tied.alpha(4, 5));
                    l[22] = false;
                playsound ();
                } else if (Godfather == true && l[22] == false) //used letter
                {
                    wordspell = Words.getName();
                    checkword(wordspell);
                    for (int i = 0; i < 36; i++) {
                        l[i] = true;
                    }
                    Words.setText("");
                    Godfather = false;
                }
                jLabel23.setIcon(new javax.swing.ImageIcon(getClass().getResource("Scrabble/" + tied.alpha(4, 5) + tied.alpha(4, 5) + ".jpg")));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                jLabel23.setIcon(new javax.swing.ImageIcon(getClass().getResource("Scrabble/" + tied.alpha(4, 5) + ".jpg")));
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                wordspell = Words.getText();
                checkword(wordspell);
                for (int i = 0; i < 36; i++) {
                    l[i] = true;
                }
                Words.setText("");
                Godfather = false;
            }

            @Override
            public void mousePressed(MouseEvent e) {
                jLabel23.setIcon(new javax.swing.ImageIcon(getClass().getResource("Scrabble/" + tied.alpha(4, 5) + tied.alpha(4, 5) + ".jpg")));
                if (Godfather == false) {
                    Godfather = true;
                    l[22] = false;
                    Words.setText(tied.alpha(4, 5));
                playsound ();
                }
            }
        });

        jLabel24.setSize(widthlabeltrue, heightlabel - 8);
        jLabel24.setLocation(5 * (widthlabel) + 50, 3 * heightlabel);
        jLabel24.setText("");
        jLabel24.setIcon(new javax.swing.ImageIcon(getClass().getResource("Scrabble/" + tied.alpha(4, 6) + ".jpg")));
        jLabel24.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                if (Godfather == true && l[23] == true) {
                    Words.setText(Words.getText() + tied.alpha(4, 6));
                    l[23] = false;
                playsound ();
                } else if (Godfather == true && l[23] == false) //used letter
                {
                    wordspell = Words.getName();
                    checkword(wordspell);
                    for (int i = 0; i < 36; i++) {
                        l[i] = true;
                    }
                    Words.setText("");
                    Godfather = false;
                }
                jLabel24.setIcon(new javax.swing.ImageIcon(getClass().getResource("Scrabble/" + tied.alpha(4, 6) + tied.alpha(4, 6) + ".jpg")));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                jLabel24.setIcon(new javax.swing.ImageIcon(getClass().getResource("Scrabble/" + tied.alpha(4, 6) + ".jpg")));
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                wordspell = Words.getText();
                checkword(wordspell);
                for (int i = 0; i < 36; i++) {
                    l[i] = true;
                }
                Words.setText("");
                Godfather = false;
            }

            @Override
            public void mousePressed(MouseEvent e) {
                jLabel24.setIcon(new javax.swing.ImageIcon(getClass().getResource("Scrabble/" + tied.alpha(4, 6) + tied.alpha(4, 6) + ".jpg")));
                if (Godfather == false) {
                    Godfather = true;
                    l[23] = false;
                    Words.setText(tied.alpha(4, 6));
                playsound ();
                }
            }
        });

        jLabel25.setSize(widthlabeltrue, heightlabel - 8);
        jLabel25.setLocation(50, 4 * heightlabel);
        jLabel25.setText("");
        jLabel25.setIcon(new javax.swing.ImageIcon(getClass().getResource("Scrabble/" + tied.alpha(5, 1) + ".jpg")));
        jLabel25.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                if (Godfather == true && l[24] == true) {
                    Words.setText(Words.getText() + tied.alpha(5, 1));
                    l[24] = false;
                playsound ();
                } else if (Godfather == true && l[24] == false) //used letter
                {
                    wordspell = Words.getName();
                    checkword(wordspell);
                    for (int i = 0; i < 36; i++) {
                        l[i] = true;
                    }
                    Words.setText("");
                    Godfather = false;
                }
                jLabel25.setIcon(new javax.swing.ImageIcon(getClass().getResource("Scrabble/" + tied.alpha(5, 1) + tied.alpha(5, 1) + ".jpg")));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                jLabel25.setIcon(new javax.swing.ImageIcon(getClass().getResource("Scrabble/" + tied.alpha(5, 1) + ".jpg")));
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                wordspell = Words.getText();
                checkword(wordspell);
                for (int i = 0; i < 36; i++) {
                    l[i] = true;
                }
                Words.setText("");
                Godfather = false;
            }

            @Override
            public void mousePressed(MouseEvent e) {
                jLabel25.setIcon(new javax.swing.ImageIcon(getClass().getResource("Scrabble/" + tied.alpha(5, 1) + tied.alpha(5, 1) + ".jpg")));
                if (Godfather == false) {
                    Godfather = true;
                    l[24] = false;
                    Words.setText(tied.alpha(5, 1));
                playsound ();
                }
            }
        });

        jLabel26.setSize(widthlabeltrue, heightlabel - 8);
        jLabel26.setLocation((widthlabel) + 50, 4 * heightlabel);
        jLabel26.setText("");
        jLabel26.setIcon(new javax.swing.ImageIcon(getClass().getResource("Scrabble/" + tied.alpha(5, 2) + ".jpg")));
        jLabel26.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                if (Godfather == true && l[25] == true) {
                    Words.setText(Words.getText() + tied.alpha(5, 2));
                    l[25] = false;
                playsound ();
                } else if (Godfather == true && l[25] == false) //used letter
                {
                    wordspell = Words.getName();
                    checkword(wordspell);
                    for (int i = 0; i < 36; i++) {
                        l[i] = true;
                    }
                    Words.setText("");
                    Godfather = false;
                }
                jLabel26.setIcon(new javax.swing.ImageIcon(getClass().getResource("Scrabble/" + tied.alpha(5, 2) + tied.alpha(5, 2) + ".jpg")));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                jLabel26.setIcon(new javax.swing.ImageIcon(getClass().getResource("Scrabble/" + tied.alpha(5, 2) + ".jpg")));
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                wordspell = Words.getText();
                checkword(wordspell);
                for (int i = 0; i < 36; i++) {
                    l[i] = true;
                }
                Words.setText("");
                Godfather = false;
            }

            @Override
            public void mousePressed(MouseEvent e) {
                jLabel26.setIcon(new javax.swing.ImageIcon(getClass().getResource("Scrabble/" + tied.alpha(5, 2) + tied.alpha(5, 2) + ".jpg")));
                if (Godfather == false) {
                    Godfather = true;
                    l[25] = false;
                    Words.setText(tied.alpha(5, 2));
                playsound ();
                }
            }
        });

        jLabel27.setSize(widthlabeltrue, heightlabel - 8);
        jLabel27.setLocation(2 * (widthlabel) + 50, 4 * heightlabel);
        jLabel27.setText("");
        jLabel27.setIcon(new javax.swing.ImageIcon(getClass().getResource("Scrabble/" + tied.alpha(5, 3) + ".jpg")));
        jLabel27.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                if (Godfather == true && l[26] == true) {
                    Words.setText(Words.getText() + tied.alpha(5, 3));
                    l[26] = false;
                playsound ();
                } else if (Godfather == true && l[26] == false) //used letter
                {
                    wordspell = Words.getName();
                    checkword(wordspell);
                    for (int i = 0; i < 36; i++) {
                        l[i] = true;
                    }
                    Words.setText("");
                    Godfather = false;
                }
                jLabel27.setIcon(new javax.swing.ImageIcon(getClass().getResource("Scrabble/" + tied.alpha(5, 3) + tied.alpha(5, 3) + ".jpg")));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                jLabel27.setIcon(new javax.swing.ImageIcon(getClass().getResource("Scrabble/" + tied.alpha(5, 3) + ".jpg")));
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                wordspell = Words.getText();
                checkword(wordspell);
                for (int i = 0; i < 36; i++) {
                    l[i] = true;
                }
                Words.setText("");
                Godfather = false;
            }

            @Override
            public void mousePressed(MouseEvent e) {
                jLabel27.setIcon(new javax.swing.ImageIcon(getClass().getResource("Scrabble/" + tied.alpha(5, 3) + tied.alpha(5, 3) + ".jpg")));
                if (Godfather == false) {
                    Godfather = true;
                    l[26] = false;
                    Words.setText(tied.alpha(5, 3));
                playsound ();
                }
            }
        });

        jLabel28.setSize(widthlabeltrue, heightlabel - 8);
        jLabel28.setLocation(3 * (widthlabel) + 50, 4 * heightlabel);
        jLabel28.setText("");
        jLabel28.setIcon(new javax.swing.ImageIcon(getClass().getResource("Scrabble/" + tied.alpha(5, 4) + ".jpg")));
        jLabel28.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                if (Godfather == true && l[27] == true) {
                    Words.setText(Words.getText() + tied.alpha(5, 4));
                    l[27] = false;
                playsound ();
                } else if (Godfather == true && l[27] == false) //used letter
                {
                    wordspell = Words.getName();
                    checkword(wordspell);
                    for (int i = 0; i < 36; i++) {
                        l[i] = true;
                    }
                    Words.setText("");
                    Godfather = false;
                }
                jLabel28.setIcon(new javax.swing.ImageIcon(getClass().getResource("Scrabble/" + tied.alpha(5, 4) + tied.alpha(5, 4) + ".jpg")));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                jLabel28.setIcon(new javax.swing.ImageIcon(getClass().getResource("Scrabble/" + tied.alpha(5, 4) + ".jpg")));
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                wordspell = Words.getText();
                checkword(wordspell);
                for (int i = 0; i < 36; i++) {
                    l[i] = true;
                }
                Words.setText("");
                Godfather = false;
            }

            @Override
            public void mousePressed(MouseEvent e) {
                jLabel28.setIcon(new javax.swing.ImageIcon(getClass().getResource("Scrabble/" + tied.alpha(5, 4) + tied.alpha(5, 4) + ".jpg")));
                if (Godfather == false) {
                    Godfather = true;
                    l[27] = false;
                    Words.setText(tied.alpha(5, 4));
                playsound ();
                }
            }
        });

        jLabel29.setSize(widthlabeltrue, heightlabel - 8);
        jLabel29.setLocation(4 * (widthlabel) + 50, 4 * heightlabel);
        jLabel29.setText("");
        jLabel29.setIcon(new javax.swing.ImageIcon(getClass().getResource("Scrabble/" + tied.alpha(5, 5) + ".jpg")));
        jLabel29.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                if (Godfather == true && l[28] == true) {
                    Words.setText(Words.getText() + tied.alpha(5, 5));
                    l[28] = false;
                playsound ();
                } else if (Godfather == true && l[28] == false) //used letter
                {
                    wordspell = Words.getName();
                    checkword(wordspell);
                    for (int i = 0; i < 36; i++) {
                        l[i] = true;
                    }
                    Words.setText("");
                    Godfather = false;
                }
                jLabel29.setIcon(new javax.swing.ImageIcon(getClass().getResource("Scrabble/" + tied.alpha(5, 5) + tied.alpha(5, 5) + ".jpg")));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                jLabel29.setIcon(new javax.swing.ImageIcon(getClass().getResource("Scrabble/" + tied.alpha(5, 5) + ".jpg")));
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                wordspell = Words.getText();
                checkword(wordspell);
                for (int i = 0; i < 36; i++) {
                    l[i] = true;
                }
                Words.setText("");
                Godfather = false;
            }

            @Override
            public void mousePressed(MouseEvent e) {
                jLabel29.setIcon(new javax.swing.ImageIcon(getClass().getResource("Scrabble/" + tied.alpha(5, 5) + tied.alpha(5, 5) + ".jpg")));
                if (Godfather == false) {
                    Godfather = true;
                    l[28] = false;
                    Words.setText(tied.alpha(5, 5));
                playsound ();
                }
            }
        });

        jLabel30.setSize(widthlabeltrue, heightlabel - 8);
        jLabel30.setLocation(5 * (widthlabel) + 50, 4 * heightlabel);
        jLabel30.setText("");
        jLabel30.setIcon(new javax.swing.ImageIcon(getClass().getResource("Scrabble/" + tied.alpha(5, 6) + ".jpg")));
        jLabel30.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                if (Godfather == true && l[29] == true) {
                    Words.setText(Words.getText() + tied.alpha(5, 6));
                    l[29] = false;
                playsound ();
                } else if (Godfather == true && l[29] == false) //used letter
                {
                    wordspell = Words.getName();
                    checkword(wordspell);
                    for (int i = 0; i < 36; i++) {
                        l[i] = true;
                    }
                    Words.setText("");
                    Godfather = false;
                }
                jLabel30.setIcon(new javax.swing.ImageIcon(getClass().getResource("Scrabble/" + tied.alpha(5, 6) + tied.alpha(5, 6) + ".jpg")));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                jLabel30.setIcon(new javax.swing.ImageIcon(getClass().getResource("Scrabble/" + tied.alpha(5, 6) + ".jpg")));
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                wordspell = Words.getText();
                checkword(wordspell);
                for (int i = 0; i < 36; i++) {
                    l[i] = true;
                }
                Words.setText("");
                Godfather = false;
            }

            @Override
            public void mousePressed(MouseEvent e) {
                jLabel30.setIcon(new javax.swing.ImageIcon(getClass().getResource("Scrabble/" + tied.alpha(5, 6) + tied.alpha(5, 6) + ".jpg")));
                if (Godfather == false) {
                    Godfather = true;
                    l[29] = false;
                    Words.setText(tied.alpha(5, 6));
                playsound ();
                }
            }
        });

        jLabel31.setSize(widthlabeltrue, heightlabel - 8);
        jLabel31.setLocation(50, 5 * heightlabel);
        jLabel31.setText("");
        jLabel31.setIcon(new javax.swing.ImageIcon(getClass().getResource("Scrabble/" + tied.alpha(6, 1) + ".jpg")));
        jLabel31.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                if (Godfather == true && l[30] == true) {
                    Words.setText(Words.getText() + tied.alpha(6, 1));
                    l[30] = false;
                    tripplescore=true;
                playsound ();
                } else if (Godfather == true && l[30] == false) //used letter
                {
                    tripplescore=true;
                    wordspell = Words.getName();
                    checkword(wordspell);
                    for (int i = 0; i < 36; i++) {
                        l[i] = true;
                    }
                    Words.setText("");
                    Godfather = false;
                }
                jLabel31.setIcon(new javax.swing.ImageIcon(getClass().getResource("Scrabble/" + tied.alpha(6, 1) + tied.alpha(6, 1) + ".jpg")));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                jLabel31.setIcon(new javax.swing.ImageIcon(getClass().getResource("Scrabble/" + tied.alpha(6, 1) + ".jpg")));
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                tripplescore=true;
                wordspell = Words.getText();
                checkword(wordspell);
                for (int i = 0; i < 36; i++) {
                    l[i] = true;
                }
                Words.setText("");
                Godfather = false;
            }

            @Override
            public void mousePressed(MouseEvent e) {
                jLabel31.setIcon(new javax.swing.ImageIcon(getClass().getResource("Scrabble/" + tied.alpha(6, 1) + tied.alpha(6, 1) + ".jpg")));
                if (Godfather == false) {
                    Godfather = true;
                    l[30] = false;
                    Words.setText(tied.alpha(6, 1));
                    tripplescore=true;
                playsound ();
                }
            }
        });

        jLabel32.setSize(widthlabeltrue, heightlabel - 8);
        jLabel32.setLocation((widthlabel) + 50, 5 * heightlabel);
        jLabel32.setText("");
        jLabel32.setIcon(new javax.swing.ImageIcon(getClass().getResource("Scrabble/" + tied.alpha(6, 2) + ".jpg")));
        jLabel32.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                if (Godfather == true && l[31] == true) {
                    Words.setText(Words.getText() + tied.alpha(6, 2));
                    l[31] = false;
                playsound ();
                } else if (Godfather == true && l[31] == false) //used letter
                {
                    wordspell = Words.getName();
                    checkword(wordspell);
                    for (int i = 0; i < 36; i++) {
                        l[i] = true;
                    }
                    Words.setText("");
                    Godfather = false;
                }
                jLabel32.setIcon(new javax.swing.ImageIcon(getClass().getResource("Scrabble/" + tied.alpha(6, 2) + tied.alpha(6, 2) + ".jpg")));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                jLabel32.setIcon(new javax.swing.ImageIcon(getClass().getResource("Scrabble/" + tied.alpha(6, 2) + ".jpg")));
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                wordspell = Words.getText();
                checkword(wordspell);
                for (int i = 0; i < 36; i++) {
                    l[i] = true;
                }
                Words.setText("");
                Godfather = false;
            }

            @Override
            public void mousePressed(MouseEvent e) {
                jLabel32.setIcon(new javax.swing.ImageIcon(getClass().getResource("Scrabble/" + tied.alpha(6, 2) + tied.alpha(6, 2) + ".jpg")));
                if (Godfather == false) {
                    Godfather = true;
                    l[31] = false;
                    Words.setText(tied.alpha(6, 2));
                playsound ();
                }
            }
        });

        jLabel33.setSize(widthlabeltrue, heightlabel - 8);
        jLabel33.setLocation(2 * (widthlabel) + 50, 5 * heightlabel);
        jLabel33.setText("");
        jLabel33.setIcon(new javax.swing.ImageIcon(getClass().getResource("Scrabble/" + tied.alpha(6, 3) + ".jpg")));
        jLabel33.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                if (Godfather == true && l[32] == true) {
                    Words.setText(Words.getText() + tied.alpha(6, 3));
                    l[32] = false;
                playsound ();
                } else if (Godfather == true && l[32] == false) //used letter
                {
                    wordspell = Words.getName();
                    checkword(wordspell);
                    for (int i = 0; i < 36; i++) {
                        l[i] = true;
                    }
                    Words.setText("");
                    Godfather = false;
                }
                jLabel33.setIcon(new javax.swing.ImageIcon(getClass().getResource("Scrabble/" + tied.alpha(6, 3) + tied.alpha(6, 3) + ".jpg")));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                jLabel33.setIcon(new javax.swing.ImageIcon(getClass().getResource("Scrabble/" + tied.alpha(6, 3) + ".jpg")));
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                wordspell = Words.getText();
                checkword(wordspell);
                for (int i = 0; i < 36; i++) {
                    l[i] = true;
                }
                Words.setText("");
                Godfather = false;
            }

            @Override
            public void mousePressed(MouseEvent e) {
                jLabel33.setIcon(new javax.swing.ImageIcon(getClass().getResource("Scrabble/" + tied.alpha(6, 3) + tied.alpha(6, 3) + ".jpg")));
                if (Godfather == false) {
                    Godfather = true;
                    l[32] = false;
                    Words.setText(tied.alpha(6, 3));
                playsound ();
                }
            }
        });

        jLabel34.setSize(widthlabeltrue, heightlabel - 8);
        jLabel34.setLocation(3 * (widthlabel) + 50, 5 * heightlabel);
        jLabel34.setText("");
        jLabel34.setIcon(new javax.swing.ImageIcon(getClass().getResource("Scrabble/" + tied.alpha(6, 4) + ".jpg")));
        jLabel34.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                if (Godfather == true && l[33] == true) {
                    Words.setText(Words.getText() + tied.alpha(6, 4));
                    l[33] = false;
                playsound ();
                } else if (Godfather == true && l[33] == false) //used letter
                {
                    wordspell = Words.getName();
                    checkword(wordspell);
                    for (int i = 0; i < 36; i++) {
                        l[i] = true;
                    }
                    Words.setText("");
                    Godfather = false;
                }
                jLabel34.setIcon(new javax.swing.ImageIcon(getClass().getResource("Scrabble/" + tied.alpha(6, 4) + tied.alpha(6, 4) + ".jpg")));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                jLabel34.setIcon(new javax.swing.ImageIcon(getClass().getResource("Scrabble/" + tied.alpha(6, 4) + ".jpg")));
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                wordspell = Words.getText();
                checkword(wordspell);
                for (int i = 0; i < 36; i++) {
                    l[i] = true;
                }
                Words.setText("");
                Godfather = false;
            }

            @Override
            public void mousePressed(MouseEvent e) {
                jLabel34.setIcon(new javax.swing.ImageIcon(getClass().getResource("Scrabble/" + tied.alpha(6, 4) + tied.alpha(6, 4) + ".jpg")));
                if (Godfather == false) {
                    Godfather = true;
                    l[33] = false;
                    Words.setText(tied.alpha(6, 4));
                playsound ();
                }
            }
        });

        jLabel35.setSize(widthlabeltrue, heightlabel - 8);
        jLabel35.setLocation(4 * (widthlabel) + 50, 5 * heightlabel);
        jLabel35.setText("");
        jLabel35.setIcon(new javax.swing.ImageIcon(getClass().getResource("Scrabble/" + tied.alpha(6, 5) + ".jpg")));
        // jLabel35.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
        jLabel35.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                if (Godfather == true && l[34] == true) {
                    Words.setText(Words.getText() + tied.alpha(6, 5));
                    l[34] = false;
                playsound ();
                } else if (Godfather == true && l[34] == false) //used letter
                {
                    wordspell = Words.getName();
                    checkword(wordspell);
                    for (int i = 0; i < 36; i++) {
                        l[i] = true;
                    }
                    Words.setText("");
                    Godfather = false;
                }
                jLabel35.setIcon(new javax.swing.ImageIcon(getClass().getResource("Scrabble/" + tied.alpha(6, 5) + tied.alpha(6, 5) + ".jpg")));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                jLabel35.setIcon(new javax.swing.ImageIcon(getClass().getResource("Scrabble/" + tied.alpha(6, 5) + ".jpg")));
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                wordspell = Words.getText();
                checkword(wordspell);
                for (int i = 0; i < 36; i++) {
                    l[i] = true;
                }
                Words.setText("");
                Godfather = false;
            }

            @Override
            public void mousePressed(MouseEvent e) {
                jLabel35.setIcon(new javax.swing.ImageIcon(getClass().getResource("Scrabble/" + tied.alpha(6, 5) + tied.alpha(6, 5) + ".jpg")));
                if (Godfather == false) {
                    Godfather = true;
                    l[34] = false;
                    Words.setText(tied.alpha(6, 5));
                playsound ();
                }
            }
        });

        jLabel36.setSize(widthlabeltrue, heightlabel - 8);
        jLabel36.setLocation(5 * (widthlabel) + 50, 5 * heightlabel);
        jLabel36.setText("");
        //jLabel36.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
        jLabel36.setIcon(new javax.swing.ImageIcon(getClass().getResource("Scrabble/" + tied.alpha(6, 6) + ".jpg")));
        jLabel36.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                if (Godfather == true && l[35] == true) {
                    Words.setText(Words.getText() + tied.alpha(6, 6));
                    l[35] = false;
                    tripplescore=true;
                playsound ();
                } else if (Godfather == true && l[35] == false) //used letter
                {
                    tripplescore=true;
                    wordspell = Words.getName();
                    checkword(wordspell);
                    for (int i = 0; i < 36; i++) {
                        l[i] = true;
                    }
                    Words.setText("");
                    Godfather = false;
                }
                jLabel36.setIcon(new javax.swing.ImageIcon(getClass().getResource("Scrabble/" + tied.alpha(6, 6) + tied.alpha(6, 6) + ".jpg")));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                jLabel36.setIcon(new javax.swing.ImageIcon(getClass().getResource("Scrabble/" + tied.alpha(6, 6) + ".jpg")));
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                tripplescore=true;
                wordspell = Words.getText();
                checkword(wordspell);
                for (int i = 0; i < 36; i++) {
                    l[i] = true;
                }
                Words.setText("");
                Godfather = false;
            }

            @Override
            public void mousePressed(MouseEvent e) {
                jLabel36.setIcon(new javax.swing.ImageIcon(getClass().getResource("Scrabble/" + tied.alpha(6, 6) + tied.alpha(6, 6) + ".jpg")));
                if (Godfather == false) {
                    Godfather = true;
                    l[35] = false;
                    tripplescore=true;
                    Words.setText(tied.alpha(6, 6));
                playsound ();
                }
            }
        });
        

    }
//pllay sound method---------------------------------------------------
     public static void playsound ()
    {
        if (MainMenu.SoundOk==true) {
        String soundbutt;String path;
        {
        File f = new File(System.getProperty("java.class.path"));
        File dir = f.getAbsoluteFile().getParentFile();
        path = dir.toString();
        soundbutt ="\\Sounds\\button.mp3";
        new MP3Player(new File(path+soundbutt)).play(); 
       // System.out.println ("This is dir: " + path+soundbutt );
        }
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

    
    //-----------------------------------------------------------------
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lettercontainer = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Shizzle");
        setIconImage(Toolkit.getDefaultToolkit().getImage(MainMenu.class.getResource("image.jpg")));
        setUndecorated(true);
        getContentPane().setLayout(null);

        lettercontainer.setBackground(new java.awt.Color(51, 0, 102));
        lettercontainer.setPreferredSize(new java.awt.Dimension(1266, 638));

        jLabel1.setText("jLabel1");
        jLabel1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jLabel3.setText("jLabel3");

        jLabel4.setText("jLabel4");

        jLabel5.setText("jLabel5");

        jLabel6.setText("jLabel6");

        jLabel7.setText("jLabel7");

        jLabel8.setText("jLabel8");

        jLabel9.setText("jLabel9");

        jLabel10.setText("jLabel10");

        jLabel11.setText("jLabel11");

        jLabel12.setText("jLabel12");

        jLabel13.setText("jLabel13");

        jLabel14.setText("jLabel14");

        jLabel15.setText("jLabel15");

        jLabel16.setText("jLabel16");

        jLabel17.setText("jLabel17");

        jLabel18.setText("jLabel18");

        jLabel19.setText("jLabel19");

        jLabel20.setText("jLabel20");

        jLabel21.setText("jLabel21");

        jLabel22.setText("jLabel22");

        jLabel23.setText("jLabel23");

        jLabel24.setText("jLabel24");

        jLabel2.setText("jLabel2");

        jLabel25.setText("jLabel25");

        jLabel26.setText("jLabel26");

        jLabel27.setText("jLabel27");

        jLabel28.setText("jLabel28");

        jLabel29.setText("jLabel29");

        jLabel30.setText("jLabel30");

        jLabel31.setText("jLabel31");

        jLabel32.setText("jLabel32");

        jLabel33.setText("jLabel33");

        jLabel34.setText("jLabel34");

        jLabel35.setText("jLabel35");

        jLabel36.setText("jLabel36");

        javax.swing.GroupLayout lettercontainerLayout = new javax.swing.GroupLayout(lettercontainer);
        lettercontainer.setLayout(lettercontainerLayout);
        lettercontainerLayout.setHorizontalGroup(
            lettercontainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(lettercontainerLayout.createSequentialGroup()
                .addGroup(lettercontainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(lettercontainerLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel25))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, lettercontainerLayout.createSequentialGroup()
                        .addGroup(lettercontainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(lettercontainerLayout.createSequentialGroup()
                                .addGap(57, 57, 57)
                                .addComponent(jLabel7))
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(lettercontainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(lettercontainerLayout.createSequentialGroup()
                                .addGap(31, 31, 31)
                                .addGroup(lettercontainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(lettercontainerLayout.createSequentialGroup()
                                        .addComponent(jLabel14)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel19))
                                    .addGroup(lettercontainerLayout.createSequentialGroup()
                                        .addComponent(jLabel8)
                                        .addGap(138, 138, 138)
                                        .addComponent(jLabel9))))
                            .addGroup(lettercontainerLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(lettercontainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(lettercontainerLayout.createSequentialGroup()
                                        .addGap(0, 0, Short.MAX_VALUE)
                                        .addComponent(jLabel29))
                                    .addComponent(jLabel36)))))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, lettercontainerLayout.createSequentialGroup()
                        .addGap(51, 51, 51)
                        .addGroup(lettercontainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel3)
                            .addGroup(lettercontainerLayout.createSequentialGroup()
                                .addComponent(jLabel13)
                                .addGap(311, 311, 311)))))
                .addGroup(lettercontainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(lettercontainerLayout.createSequentialGroup()
                        .addGap(171, 171, 171)
                        .addGroup(lettercontainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel10))
                        .addGap(151, 151, 151)
                        .addGroup(lettercontainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(lettercontainerLayout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addGap(107, 107, 107)
                                .addComponent(jLabel6)
                                .addGap(115, 115, 115)
                                .addComponent(jLabel15)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel16))
                            .addGroup(lettercontainerLayout.createSequentialGroup()
                                .addComponent(jLabel11)
                                .addGap(110, 110, 110)
                                .addComponent(jLabel12)
                                .addGap(111, 111, 111)
                                .addComponent(jLabel17)
                                .addGap(111, 111, 111)
                                .addComponent(jLabel18))))
                    .addGroup(lettercontainerLayout.createSequentialGroup()
                        .addGroup(lettercontainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(lettercontainerLayout.createSequentialGroup()
                                .addGap(116, 116, 116)
                                .addComponent(jLabel26))
                            .addGroup(lettercontainerLayout.createSequentialGroup()
                                .addGap(298, 298, 298)
                                .addComponent(jLabel27))
                            .addGroup(lettercontainerLayout.createSequentialGroup()
                                .addGap(180, 180, 180)
                                .addComponent(jLabel28)
                                .addGap(120, 120, 120)
                                .addComponent(jLabel30)
                                .addGap(82, 82, 82)
                                .addComponent(jLabel31))
                            .addGroup(lettercontainerLayout.createSequentialGroup()
                                .addGap(36, 36, 36)
                                .addComponent(jLabel33)
                                .addGap(134, 134, 134)
                                .addComponent(jLabel34)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(lettercontainerLayout.createSequentialGroup()
                        .addGap(155, 155, 155)
                        .addGroup(lettercontainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel35)
                            .addGroup(lettercontainerLayout.createSequentialGroup()
                                .addComponent(jLabel20)
                                .addGap(181, 181, 181)
                                .addComponent(jLabel21)))
                        .addGap(113, 113, 113)
                        .addComponent(jLabel22)
                        .addGap(102, 102, 102)
                        .addComponent(jLabel23)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel24)))
                .addContainerGap())
            .addGroup(lettercontainerLayout.createSequentialGroup()
                .addGap(75, 75, 75)
                .addComponent(jLabel32)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        lettercontainerLayout.setVerticalGroup(
            lettercontainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(lettercontainerLayout.createSequentialGroup()
                .addGroup(lettercontainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(lettercontainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(lettercontainerLayout.createSequentialGroup()
                        .addGap(82, 82, 82)
                        .addComponent(jLabel28))
                    .addGroup(lettercontainerLayout.createSequentialGroup()
                        .addGap(73, 73, 73)
                        .addGroup(lettercontainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel30)
                            .addComponent(jLabel31)))
                    .addGroup(lettercontainerLayout.createSequentialGroup()
                        .addGap(60, 60, 60)
                        .addComponent(jLabel29)
                        .addGap(63, 63, 63)
                        .addGroup(lettercontainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel33)
                            .addComponent(jLabel34)
                            .addComponent(jLabel35)))
                    .addGroup(lettercontainerLayout.createSequentialGroup()
                        .addGap(143, 143, 143)
                        .addComponent(jLabel36)))
                .addGap(18, 18, 18)
                .addComponent(jLabel32)
                .addGroup(lettercontainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(lettercontainerLayout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addGroup(lettercontainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6)
                            .addComponent(jLabel15)
                            .addComponent(jLabel16))
                        .addGroup(lettercontainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(lettercontainerLayout.createSequentialGroup()
                                .addGap(68, 68, 68)
                                .addGroup(lettercontainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel10)
                                    .addComponent(jLabel11)))
                            .addGroup(lettercontainerLayout.createSequentialGroup()
                                .addGap(76, 76, 76)
                                .addGroup(lettercontainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel12)
                                    .addComponent(jLabel17)
                                    .addComponent(jLabel18)))))
                    .addGroup(lettercontainerLayout.createSequentialGroup()
                        .addGap(79, 79, 79)
                        .addGroup(lettercontainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(jLabel8)
                            .addComponent(jLabel9))))
                .addGroup(lettercontainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(lettercontainerLayout.createSequentialGroup()
                        .addGroup(lettercontainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(lettercontainerLayout.createSequentialGroup()
                                .addGap(50, 50, 50)
                                .addComponent(jLabel25)
                                .addGap(47, 47, 47))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, lettercontainerLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel27)
                                .addGap(3, 3, 3)
                                .addComponent(jLabel26)
                                .addGap(38, 38, 38)))
                        .addGroup(lettercontainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel13)
                            .addComponent(jLabel14)
                            .addComponent(jLabel19)
                            .addComponent(jLabel20)
                            .addComponent(jLabel21)
                            .addComponent(jLabel22)
                            .addComponent(jLabel23)))
                    .addGroup(lettercontainerLayout.createSequentialGroup()
                        .addGap(99, 99, 99)
                        .addComponent(jLabel24)))
                .addContainerGap(200, Short.MAX_VALUE))
        );

        getContentPane().add(lettercontainer);
        lettercontainer.setBounds(30, 173, 1266, 638);

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
            java.util.logging.Logger.getLogger(Game.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Game.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Game.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Game.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Game_1().setVisible(true);
            }
        });
    }

    public void checkword(String word) {
        //String[] RecWords;      //Decided not to obtain game play array of word from the gameplay.gmp
        //RecWords = tied.getWords(); //this line obtains the array.
        boolean wordgradedalready = false;
        for (String RecWord: dicWords) { //for (String RecWord : RecWords) {    //RecWord accesses array that comes with game play 
            //System.out.print (RecWords[i] + "\n");
            if (RecWord.equalsIgnoreCase(word) == true) {
                //System.out.println (scoresheetword[0]);
                if (scoresheetword[0] != null) {
                    for (String scoresheetwords : realscoresheetword) {
                        try {
                            if (scoresheetwords.equalsIgnoreCase(word) == true) //checking for word again in scoresheet.
                            {
                                AwarePanel.setBackground(Color.RED);
                                wordgradedalready = true;
                                score.setText("");
                                //doublescore=false;
                                break; //word already on the list.

                            }
                        } catch (Exception e) {
                            //System.out.print ("Caught an exception, but no major problems!");
                           // doublescore=false;
                            AwarePanel.setBackground(Color.RED);
                            score.setText("");
                        }

                    }
                }

                if (wordgradedalready == true) //word graded already. It will break the for loop.
                {
                    break;
                } else {
                    AwarePanel.setBackground(Color.BLUE);
                    getPoints(word); //grading system implementation
                    break;
                }
            } else if (RecWord.equalsIgnoreCase(word) == false) {
                AwarePanel.setBackground(Color.RED);
                score.setText("0"); //if user misses answer, set score to zero.
            }
        }
        doublescore=false;
        tripplescore=false;
    }

    public void getPoints(String word) {
        int lengthofword = word.length();
        int wordScore = 0;

        Letter letter = new Letter();
        for (int j = 0; j < word.length(); j++) {
            wordScore = wordScore + letter.gmaLetterNumAssc(String.valueOf(word.charAt(j)));
            // System.out.println(String.valueOf(wordScore));
        }
        realscoresheetword[anum] = word; //the proper array for iteration. 
        //sound file.
        if (word.length()<=4)
        {
            playsound("good.mp3");
        }
        else if (word.length()==5)
        {
             playsound("excellent.mp3");
        }
        else if (word.length()==6)
        {
            playsound("amazing.mp3");
        }
        else if (word.length()==7)
        {
             playsound("incredible.mp3");
        }
        else if (word.length()>7)
        {
            playsound("genius.mp3");
        }
        
        if (doublescore==true && tripplescore==false)
        {
            wordScore=wordScore*2;
            word = word + " [X2]";
            playsound("victory.mp3");
        } else if (tripplescore == true && doublescore==false)
        {
            wordScore=wordScore*3;
            word = word + " [X3]";
             playsound("victory.mp3");
        } else if (doublescore == true && tripplescore==true)
        {
            wordScore=wordScore*6;
            word = word + " [X6]";
             playsound("victory.mp3");
        }
        //if one of the double word score letter is included. double word score
        if (word.length()>5)
        {
            word = word + " [>5 X2]";
            wordScore = wordScore * 2;
        }
        
        //add score to array.
        {
        
            scoresheetword[anum] = word;
            scoresheetvalue[anum] = wordScore;
            score.setText(String.valueOf(wordScore));
            anum = anum + 1;
            
            noisemaker();

        }

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel lettercontainer;
    // End of variables declaration//GEN-END:variables

    private void noisemaker() {
       
            int totalness=0;
        try{
        for (int ghu: scoresheetvalue)
        {
            totalness = totalness + ghu;
        }
        }catch (NullPointerException e) {}
        if (totalness%11==0)
        {
            playsound("magic.mp3");
        }
        else if (totalness%5==0 )
        {
            playsound ("intelligent.mp3");
        }
        else if (totalness%7==0)
        {
            playsound ("dynamic.mp3");
        }
        else if (totalness%9==0)
        {
            playsound ("champion.mp3");
        }
        else if (totalness%10==0)
        {
            playsound ("flawless.mp3");
        }
        else if (totalness%13==0)
        {
            playsound ("supreme.mp3");
        }
        totalness =0;
       
    }

}
