/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Shizzle;

import jaco.mp3.player.MP3Player;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JScrollPane;

/**
 *
 * @author owoye001
 * handles the result page for multiuser running of the application 
 */
public class ResultPageMulti extends javax.swing.JFrame {

    DefaultListModel wordmy = new DefaultListModel();
    DefaultListModel wordopp = new DefaultListModel();
    public JList wordlist = new JList(wordmy);
    public JList wordlist2 = new JList(wordopp);
    private static int Type;
    private JScrollPane listScrollPane;
    private JScrollPane listScrollPane1;

     //------THING THAT NEED TO BE SENT ------------------------------------
    public static int type;
    public static String firstusername;
    public static String[] firstuserwords;
    public static int[] firstuserscores;
    public static int firstuserznum;
    public static String secondusername;
    public static String[] seconduserwords;
    public static int[] seconduserscores;
    public static int seconduserznum;
    public static int gamenum; //initialize as -1 for normal fuction.
    public static List<String> highscoresnames = new ArrayList<>();
    public static List<Integer> highscorescores = new ArrayList<>();
    private JLabel backgroundpicture;
    
     private javax.swing.JButton backbutton;
    private javax.swing.JLabel bestword;
    private javax.swing.JLabel bestword2;
    private javax.swing.JLabel myjlabel;
    private javax.swing.JLabel myscore;
    private javax.swing.JLabel oppjlabel;
    private javax.swing.JLabel oppscore;
    public javax.swing.JLabel progLabel;
    private javax.swing.JLabel whowon;

    //------------------------------------------
    public ResultPageMulti() {
      Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
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
        //___________________________________________________________________________
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
        //------------------------------------------
         
        progLabel = new javax.swing.JLabel();
        oppjlabel = new javax.swing.JLabel();
        myjlabel = new javax.swing.JLabel();
        bestword = new javax.swing.JLabel();
        oppscore = new javax.swing.JLabel();
        whowon = new javax.swing.JLabel();
        backbutton = new javax.swing.JButton();
        myscore = new javax.swing.JLabel();
        bestword2 = new javax.swing.JLabel();

        progLabel.setFont(new java.awt.Font("Comic Sans MS", 3, 72)); // NOI18N
        progLabel.setText("Shizzle  - Words");
        
        getContentPane().add(progLabel,2,0);
        progLabel.setBounds(20, 10, 730, 210);

        oppjlabel.setFont(new java.awt.Font("Comic Sans MS", 0, 36)); // NOI18N
        oppjlabel.setForeground(new java.awt.Color(102, 255, 102));
        oppjlabel.setText("jLabel1");
        getContentPane().add(oppjlabel,2,0);
        oppjlabel.setBounds(710, 210, 400, 51);

        myjlabel.setFont(new java.awt.Font("Comic Sans MS", 0, 36)); // NOI18N
        myjlabel.setForeground(new java.awt.Color(102, 255, 102));
        myjlabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        myjlabel.setText("jLabel1");
        getContentPane().add(myjlabel,2,0);
        myjlabel.setBounds(30, 220, 400, 51);

        bestword.setFont(new java.awt.Font("Comic Sans MS", 0, 36)); // NOI18N
        bestword.setForeground(new java.awt.Color(102, 255, 102));
        bestword.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        bestword.setText("jLabel1");
        bestword.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        getContentPane().add(bestword,2,0);
        bestword.setBounds(110, 550, 460, 50);

        oppscore.setFont(new java.awt.Font("Comic Sans MS", 0, 36)); // NOI18N
        oppscore.setForeground(new java.awt.Color(102, 255, 102));
        oppscore.setText("jLabel1");
        oppscore.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        getContentPane().add(oppscore,2,0);
        oppscore.setBounds(660, 610, 340, 60);

        whowon.setFont(new java.awt.Font("Comic Sans MS", 0, 36)); // NOI18N
        whowon.setForeground(new java.awt.Color(102, 255, 102));
        whowon.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        whowon.setText("jLabel1");
        whowon.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        getContentPane().add(whowon,2,0);
        whowon.setBounds(530, 394, 190, 100);

        backbutton.setBackground(new java.awt.Color(51, 102, 0));
        backbutton.setFont(new java.awt.Font("Comic Sans MS", 0, 24)); // NOI18N
        backbutton.setForeground(new java.awt.Color(102, 255, 102));
        backbutton.setText("Back");
        backbutton.addActionListener((java.awt.event.ActionEvent evt) -> {
            playsound();
            dispose();
      });
        getContentPane().add(backbutton,2,0);
        backbutton.setBounds(548, 285, 100, 50);

        myscore.setFont(new java.awt.Font("Comic Sans MS", 0, 36)); // NOI18N
        myscore.setForeground(new java.awt.Color(102, 255, 102));
        myscore.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        myscore.setText("jLabel1");
        myscore.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        getContentPane().add(myscore,2,0);
        myscore.setBounds(210, 610, 330, 50);

        bestword2.setFont(new java.awt.Font("Comic Sans MS", 0, 36)); // NOI18N
        bestword2.setForeground(new java.awt.Color(102, 255, 102));
        bestword2.setText("jLabel1");
        bestword2.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        getContentPane().add(bestword2,2,0);
        bestword2.setBounds(630, 550, 480, 50);
        //---------------------------------------
        setSize(screenSize);
        setTitle("Shizzle");
        getContentPane().setBackground(PropertyCreator.FormBackgroundColor);

        listScrollPane = new JScrollPane(wordlist);
        listScrollPane1 = new JScrollPane(wordlist2);

        //wordlist.setSize(127,267);
        //wordlist.setSize(400* (int) screenSize.getWidth()/ 1366,267* (int) screenSize.getHeight() / 768);
        //wordlist2.setSize(400* (int) screenSize.getWidth()/ 1366,267* (int) screenSize.getHeight() / 768);
        listScrollPane.setSize(400 * (int) screenSize.getWidth() / 1366, 267 * (int) screenSize.getHeight() / 768);
        listScrollPane1.setSize(400 * (int) screenSize.getWidth() / 1366, 267 * (int) screenSize.getHeight() / 768);

        listScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        //listScrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);

        listScrollPane1.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        //listScrollPane1.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);

        progLabel.setLocation(50 * (int) screenSize.getWidth() / 1366, 0 * (int) screenSize.getHeight() / 768);

        // jLabel3.setLocation(40 * (int) screenSize.getWidth() / 1366, 190 * (int) screenSize.getHeight() / 768);
        bestword.setLocation(90 * (int) screenSize.getWidth() / 1366, 550 * (int) screenSize.getHeight() / 768);
        myscore.setLocation(300 * (int) screenSize.getWidth() / 1366, 610 * (int) screenSize.getHeight() / 768);
        bestword2.setLocation(770 * (int) screenSize.getWidth() / 1366, 550 * (int) screenSize.getHeight() / 768);
        oppscore.setLocation(720 * (int) screenSize.getWidth() / 1366, 610 * (int) screenSize.getHeight() / 768);
        backbutton.setLocation(577 * (int) screenSize.getWidth() / 1366, 330 * (int) screenSize.getHeight() / 768);

        //wordlist.setLocation(70* (int) screenSize.getWidth() / 1366,280* (int) screenSize.getHeight() / 768);
        listScrollPane.setLocation(70 * (int) screenSize.getWidth() / 1366, 280 * (int) screenSize.getHeight() / 768);

        myjlabel.setLocation(100 * (int) screenSize.getWidth() / 1366, 210 * (int) screenSize.getHeight() / 768);
        oppjlabel.setLocation(770 * (int) screenSize.getWidth() / 1366, 210 * (int) screenSize.getHeight() / 768);
        whowon.setLocation(540 * (int) screenSize.getWidth() / 1366, 420 * (int) screenSize.getHeight() / 768);

        //wordlist2.setLocation(800* (int) screenSize.getWidth() / 1366,280* (int) screenSize.getHeight() / 768);
        listScrollPane1.setLocation(800 * (int) screenSize.getWidth() / 1366, 280 * (int) screenSize.getHeight() / 768);

        progLabel.setFont(new java.awt.Font("Comic Sans MS", 3, 72)); // NOI18N
        progLabel.setText("Shizzle  - Words");
        progLabel.setBackground(PropertyCreator.FormBackgroundColor);
        progLabel.setForeground(PropertyCreator.ProgramNameColor);

        wordlist.setBackground(PropertyCreator.ContentHolderBackColor);
        wordlist.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        wordlist.setFont(new java.awt.Font("Comic Sans MS", 1, 22)); // NOI18N
        wordlist.setForeground(PropertyCreator.ContentHolderForeColor);
        wordlist.setModel(new javax.swing.AbstractListModel() {
            String[] strings = {"Item 1", "Item 2", "Item 3", "Item 4", "Item 5", "Item 6", "Item 7", "Item 8", "Item 9"};

            public int getSize() {
                return strings.length;
            }

            public Object getElementAt(int i) {
                return strings[i];
            }
        });
        //wordlist.setBounds(22, 64, 186, 135);
        //listScrollPane.setViewportView(wordlist);

        wordlist2.setBackground(PropertyCreator.ContentHolderBackColor);
        wordlist2.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        wordlist2.setFont(new java.awt.Font("Comic Sans MS", 1, 22)); // NOI18N
        wordlist2.setForeground(PropertyCreator.ContentHolderForeColor);
        wordlist2.setModel(new javax.swing.AbstractListModel() {
            String[] stringss = {"Item 1", "Item 2", "Item 3", "Item 4", "Item 5", "Item 6", "Item 7", "Item 8", "Item 9"};

            public int getSize() {
                return stringss.length;
            }

            public Object getElementAt(int i) {
                return stringss[i];
            }
        });
        // wordlist2.setBounds(22, 64, 186, 135);
        //listScrollPane1.setViewportView(wordlist2);

        backbutton.setBackground(PropertyCreator.OtherButtonBackColor);
        //backbutton.setFont(new java.awt.Font("Comic Sans MS", 0, 12)); // NOI18N
        backbutton.setForeground(PropertyCreator.OtherButtonForeColor);
        backbutton.setText("Back");
        bestword2.setForeground(PropertyCreator.LabelTextForeColor);
        bestword2.setBackground(PropertyCreator.FormBackgroundColor);

        //myjlabel.setFont(new java.awt.Font("Comic Sans MS", 3, 18));
        oppjlabel.setFont(myjlabel.getFont());
        oppjlabel.setForeground(PropertyCreator.LabelTextForeColor);
        myjlabel.setForeground(PropertyCreator.LabelTextForeColor);
        myjlabel.setBackground(PropertyCreator.FormBackgroundColor);
        myjlabel.setBackground(PropertyCreator.FormBackgroundColor);

        whowon.setFont(myjlabel.getFont());
        oppscore.setFont(new java.awt.Font("Comic Sans MS", 3, 20));
        myscore.setFont(new java.awt.Font("Comic Sans MS", 3, 20));
        whowon.setForeground(myjlabel.getForeground());
        oppscore.setForeground((myjlabel.getForeground()));
        whowon.setBackground((myjlabel.getBackground()));
        oppscore.setBackground(myjlabel.getBackground());

        whowon.setFont(new java.awt.Font("Comic Sans MS", 3, 24));
        bestword.setFont(whowon.getFont());
        bestword2.setFont(whowon.getFont());
        whowon.setHorizontalAlignment((int) JLabel.CENTER_ALIGNMENT);
        whowon.setForeground(myjlabel.getForeground());
        whowon.setBackground((myjlabel.getBackground()));

        myjlabel.setText(firstusername);
        oppjlabel.setText(secondusername);

        add(listScrollPane,2,0);
        add(listScrollPane1,2,0);
        //add(wordlist);
        //add(wordlist2);

        //-------------------------------SEARCH FOR BEST WORD
        int tq = 0;
        int f = 0;
        for (int h = 0; h <= firstuserznum; h++) {
            if (firstuserscores[h] > tq) {
                tq = firstuserscores[h];
                f = h; //highest score for user 1
            }

        }

        //user 1
        String[] y = new String[firstuserznum + 1];
        String[] printy = new String[firstuserznum + 1];
        for (int q = 0; q < y.length; q++) {
            y[q] = firstuserwords[q];
        }

        for (int u = 0; u < y.length; u++) {
            printy[u] = String.format("%-20s   %5s", y[u], String.valueOf(firstuserscores[u]));
            //wordmy.addElement(printy[u]);
        }
        wordlist.setListData(printy);

        int total = 0;
        for (int sc : firstuserscores) {
            total = total + sc; //first user
        }
        myscore.setText("Score: " + total + " Words: " + (firstuserznum + 1));

        try {
            bestword.setText("Best Word: " + printy[f]);
        } catch (NullPointerException kdjkd) {
            bestword.setText("");
        }

        //user 2
        int fq = 0;
        int g = 0;
        for (int h = 0; h <= seconduserznum; h++) {
            if (seconduserscores[h] > fq) {
                fq = seconduserscores[h];
                g = h; //highest score for user 2
            }

        }

        String[] ya = new String[seconduserznum + 1];
        String[] printya = new String[seconduserznum + 1];
        for (int q = 0; q < ya.length; q++) {
            ya[q] = seconduserwords[q];
        }

        for (int u = 0; u < ya.length; u++) {
            printya[u] = String.format("%-20s   %5s", ya[u], String.valueOf(seconduserscores[u]));
            //wordopp.addElement(printya[u]);
        }
        wordlist2.setListData(printya);

        int totala = 0;
        for (int sc : seconduserscores) {
            totala = totala + sc; //first user
        }
        oppscore.setText("Score: " + totala + " Words: " + (seconduserznum + 1));

        try {
            bestword2.setText("Best Word: " + printya[g]);
        } catch (NullPointerException fs) {
            bestword2.setText("");
        }

        if (total > totala) {
            if (MainMenu.username.contains(firstusername)) {
                whowon.setText("You Won!");
                 if (total > HighScores.getBiggestScore()) {
            //HighScores.setNewGodKing(firstusername, total);

             synchronized (this){
                try {
                    OnlinePlay.highscoresnames.add(firstusername);
                    OnlinePlay.highscorescores.add(total);
                } catch (NullPointerException lk) {
                }
                OnlinePlay.highscoresnames = new ArrayList<>();
                OnlinePlay.highscorescores = new ArrayList<>();
                OnlinePlay.highscoresnames.add(firstusername);
                OnlinePlay.highscorescores.add(total);
            }
        }
            } else {
                whowon.setText("You Lost!");
            }
        } else if (totala > total) {
            if (MainMenu.username.contains(secondusername)) {
                whowon.setText("You Won!");
                if (totala > HighScores.getBiggestScore()) {
            // HighScores.setNewGodKing(secondusername, totala);
            synchronized (this) {
                try {
                    OnlinePlay.highscoresnames.add(secondusername);
                    OnlinePlay.highscorescores.add(totala);
                } catch (NullPointerException po) {
                    OnlinePlay.highscoresnames = new ArrayList<>();
                    OnlinePlay.highscorescores = new ArrayList<>();
                    OnlinePlay.highscoresnames.add(secondusername);
                    OnlinePlay.highscorescores.add(totala);
                }
            }
        }
            } else {
                whowon.setText("You Lost!");
            }
        } else if (total == totala) {
            whowon.setText("Draw!");
        }

        if (type == 2) //one game play send back;
        {
            sendback();
        }

    }

    private void sendback() {
        //send game back to requester String [] y; int[] scores; int q; String sendbacks; int gamenums;
        OnlinePlay.client.sendUserData(new UserData(MainMenu.username, -1, null, null, type, firstusername, firstuserwords, firstuserscores, firstuserznum, secondusername, seconduserwords, seconduserscores, seconduserznum, gamenum, highscoresnames, highscorescores));
        //JOptionPane.showMessageDialog(null, "Game Sent!", "Shizzle - Online", JOptionPane.PLAIN_MESSAGE);
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
        setBackground(new java.awt.Color(0, 0, 0));
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
            java.util.logging.Logger.getLogger(ResultPageMulti.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ResultPageMulti.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ResultPageMulti.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ResultPageMulti.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ResultPageMulti().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables

}
