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
import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 *
 * @author owoye001
 * handles the result page for the single user mode of running the application
 */
public class ResultPage extends javax.swing.JFrame {

    private javax.swing.JButton backbutton;
    public javax.swing.JLabel bestword;
    private javax.swing.JScrollPane jScrollPane2;
    public javax.swing.JLabel progLabel;
    public javax.swing.JLabel scorelabel;
    private javax.swing.JList wordlist;
    
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
    public static List<String> highscoresnames = new ArrayList<String>();
    public static List<Integer> highscorescores = new ArrayList<Integer>();
    private JLabel backgroundpicture;
  
    //------------------------------------------
    
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
   
     public ResultPage() { //z is the length of correct words, x is the word list, score is the score list
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
        setLayout(null);
        setSize(screenSize);
        getContentPane().setBackground(PropertyCreator.FormBackgroundColor);
        //-------------------
        progLabel = new javax.swing.JLabel();
        scorelabel = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        wordlist = new javax.swing.JList();
        backbutton = new javax.swing.JButton();
        bestword = new javax.swing.JLabel();
        //----------------------
        progLabel.setFont(new java.awt.Font("Comic Sans MS", 3, 72)); // NOI18N
        progLabel.setText("Shizzle  - Words");
      
        getContentPane().add(progLabel,2,0);
        progLabel.setBounds(35, 11, 701, 176);

        scorelabel.setFont(new java.awt.Font("Comic Sans MS", 3, 30)); // NOI18N

        //scorelabel.setBounds(35, 727, 661, 176);

        wordlist.setBackground(PropertyCreator.ContentHolderBackColor);
        wordlist.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        wordlist.setFont(new java.awt.Font("Comic Sans MS", 1, 48)); // NOI18N
        wordlist.setForeground(PropertyCreator.ContentHolderForeColor);
        wordlist.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        jScrollPane2.setViewportView(wordlist);

        getContentPane().add(jScrollPane2,2,0);
        jScrollPane2.setBounds(610, 200, 691, 500);

        backbutton.setBackground(PropertyCreator.OtherButtonBackColor);
        backbutton.setFont(new java.awt.Font("Comic Sans MS", 0, 48)); // NOI18N
        backbutton.setForeground(PropertyCreator.OtherButtonForeColor);
        backbutton.setText("Back");
        backbutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                playsound();
                dispose();
            }
        });
        getContentPane().add(backbutton,2,0);
        backbutton.setBounds(35, 389, 264, 104);

        bestword.setFont(new java.awt.Font("Comic Sans MS", 3, 22)); // NOI18N
        bestword.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        
        getContentPane().add(bestword,2,0);
        bestword.setBounds(706, 727, 769, 176);
        
        
        
        //-------------------------
        progLabel.setBackground(PropertyCreator.FormBackgroundColor);
        progLabel.setForeground(PropertyCreator.ProgramNameColor);
        progLabel.setLocation(25,10);
        scorelabel.setBackground(PropertyCreator.FormBackgroundColor);
        scorelabel.setForeground(PropertyCreator.LabelTextForeColor);
        bestword.setBackground(PropertyCreator.FormBackgroundColor);
        bestword.setForeground(PropertyCreator.LabelTextForeColor);
                
        scorelabel.setLocation(40*(int) screenSize.getWidth()/1366, 680*(int)screenSize.getHeight()/768);
        bestword.setLocation(40*(int) screenSize.getWidth()/1366, 590*(int)screenSize.getHeight()/768);
        
        scorelabel.setSize(510*(int) screenSize.getWidth()/1366, 90*(int)screenSize.getHeight()/768);
        bestword.setSize(510*(int) screenSize.getWidth()/1366, 80*(int)screenSize.getHeight()/768);
        
        wordlist.setLocation(610*(int) screenSize.getWidth()/1366, 200*(int)screenSize.getHeight()/768);
        wordlist.setSize(167*(int) screenSize.getWidth()/1366, 347*(int)screenSize.getHeight()/768);
        backbutton.setLocation(60*(int)screenSize.getWidth()/1366, 390*(int)screenSize.getHeight()/768);
        
        wordlist.setBackground(PropertyCreator.ContentHolderBackColor);
        wordlist.setForeground(PropertyCreator.ContentHolderForeColor);
        wordlist.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        wordlist.setFont(new java.awt.Font("Comic Sans MS", 1, 22));
        progLabel.setLocation (50* (int) screenSize.getWidth()/ 1366,0* (int) screenSize.getHeight() / 768);
        wordlist.setLocation (610* (int) screenSize.getWidth()/ 1366,200* (int) screenSize.getHeight() / 768);
        
        getContentPane().add(scorelabel,2,0);
        
        int tq=0; int f=0;
        for (int h=0; h<=seconduserznum;h++)
        {
            if (seconduserscores[h]>tq)
            {
               tq=seconduserscores[h];
               f=h;
            }
            
        }
        
        String [] y = new String [seconduserznum+1];
        String [] printy = new String[seconduserznum+1];
        for (int q=0; q<y.length; q++)
        {
            y[q]=seconduserwords[q];
        }
            
        for (int u=0; u<y.length;u++)
        {
            printy[u] = String.format("%-20s   %5s", y[u],String.valueOf(seconduserscores[u]));
        }
        
      int  total=0;
                for (int sc: seconduserscores)
                {
                    total = total+sc;
                }
       if (total>MyHighScores.getBiggestScore() && type==-1)
        {
            try{
            MyHighScores.mygodkingusername.add("You");
            MyHighScores.mygodkingscore.add(total);
            MyHighScores.UpdateList();
            }catch (NullPointerException e) {
             MyHighScores.mygodkingusername = new ArrayList <>();
             MyHighScores.mygodkingscore = new ArrayList <>();
             MyHighScores.mygodkingusername.add("You");
             MyHighScores.mygodkingscore.add(total);
             MyHighScores.UpdateList();
            }   
        }
                
        try{
        wordlist.setListData(printy);
        wordlist.repaint();
        scorelabel.setText("Score: " + total + " Words: "+(seconduserznum+1));
        try {
        bestword.setText("Best Word: " + printy[f]);
        } catch (Exception e){
            bestword.setText ("");
        }
        }catch (Exception e)
        {
          //e.printStackTrace();
        }
        
        if (type==1) //one game play send back;
        {
            sendback();
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
            java.util.logging.Logger.getLogger(ResultPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ResultPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ResultPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ResultPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ResultPage().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables

   void sendback() {
        //send game back to requester String [] y; int[] scores; int q; String sendbacks; int gamenums;
         OnlinePlay.client.sendUserData(new UserData(MainMenu.username, -1, null, null,type,  firstusername, firstuserwords, firstuserscores, firstuserznum,  secondusername, seconduserwords, seconduserscores, seconduserznum, gamenum,highscoresnames,highscorescores));
        //JOptionPane.showMessageDialog(null, "Game Sent!", "Shizzle - Online", JOptionPane.PLAIN_MESSAGE);
    }
}
