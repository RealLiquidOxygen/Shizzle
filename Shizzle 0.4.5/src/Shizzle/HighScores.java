/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Shizzle;

import jaco.mp3.player.MP3Player;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;

/**
 *
 * @author owoye001
 * handles the high screen of the application
 */
public class HighScores extends javax.swing.JFrame {

//static DefaultListModel godlists = new DefaultListModel();
    public static List<String> godkingusername;
    public static List<Integer> godkingscore;
    public static ArrayList<String> keeper = new ArrayList<>();
    public static JList godkings = new JList();
    private static JScrollPane listScrollPane = new JScrollPane (godkings);
    private JLabel progLabel;
    private JButton backButton;
    private JLabel backgroundpicture;

    /**
     * Creates new form HighScores
     */
    public HighScores() {
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
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
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
            add(backgroundpicture,1,0); //it is covering everything//
        } catch (Exception ex) {
           
        }
        initComponents();
        setSize(screenSize);
        setTitle("Shizzle");
        getContentPane().setBackground(Color.black);
        progLabel = new JLabel();
        backButton = new JButton();
        godkingusername = new ArrayList<>();
        godkingscore = new ArrayList<>();
        progLabel.setFont(new java.awt.Font("Comic Sans MS", 3, 72)); // NOI18N
        progLabel.setText("Shizzle  - High Scores");
        progLabel.setBackground(PropertyCreator.FormBackgroundColor);
        progLabel.setForeground(PropertyCreator.ProgramNameColor);
        progLabel.setLocation(50 * (int) screenSize.getWidth() / 1366, 50 * (int) screenSize.getHeight() / 768);
        progLabel.setSize(900 * (int) screenSize.getWidth() / 1366, 101 * (int) screenSize.getHeight() / 768);
        add(progLabel,2,0);
        backButton.setBackground(PropertyCreator.OtherButtonBackColor);
        backButton.setSize(100, 50);
        backButton.setForeground(PropertyCreator.OtherButtonForeColor);
        backButton.setText("Back");
        backButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                playsound();
                setVisible(false);
            }
        });

        
        listScrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        listScrollPane.setWheelScrollingEnabled(true);

        listScrollPane.setSize(683 * (int) screenSize.getWidth() / 1366, 384 * (int) screenSize.getHeight() / 768);
        listScrollPane.setLocation(341 * (int) screenSize.getWidth() / 1366, 240 * (int) screenSize.getHeight() / 768);
        godkings.setBackground(PropertyCreator.ContentHolderBackColor);
        godkings.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        godkings.setFont(new java.awt.Font("Comic Sans MS", 1, 22)); // NOI18N
        godkings.setForeground(PropertyCreator.ContentHolderForeColor);
        godkings.setModel(new javax.swing.AbstractListModel() {
            String[] stringss = {"Empty"};

            public int getSize() {
                return stringss.length;
            }

            public Object getElementAt(int i) {
                return stringss[i];
            }
        });

        backButton.setLocation((int) (screenSize.getWidth()) / 2 - (int) backButton.getWidth() / 2, (int) listScrollPane.getY() + (int) listScrollPane.getHeight() + 40);
        add(listScrollPane,2,0);
        add(backButton,2,0);
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
public static void UpdateList() {

        try {
            String tempy;
            ArrayList<String> keeper = new ArrayList<>();
            keeper.clear();
            for (int i = godkingscore.size() - 1; i >= 0; i--) {
                tempy = String.format("%-29s%29d", godkingusername.get(i), godkingscore.get(i));
                keeper.add(tempy);
            }
            try {
                if (keeper.isEmpty())
                {
                keeper.clear();
                keeper.add("Empty");
                godkings.setListData(keeper.toArray());
                godkings.repaint();
                }
                else
                {
                godkings.setListData(keeper.toArray());
                godkings.repaint();
                 }
            } catch (NullPointerException e) {
                keeper.clear();
                keeper.add("Empty");
                godkings.setListData(keeper.toArray());
                godkings.repaint();
            }

        } catch (Exception eq) {

        }
    }
    public void UpdateList(List<String> godnamesa, List<Integer> godscoresa) {
        String tempy;
        godkingusername = godnamesa;
        godkingscore = godscoresa;

        Game_1.highscoresnames = godnamesa;
        Game_1.highscorescores = godscoresa;

        OnlinePlay.highscoresnames = godnamesa;
        OnlinePlay.highscorescores = godscoresa;

        ResultPage.highscoresnames = godnamesa;
        ResultPage.highscorescores = godscoresa;

        ResultPageMulti.highscoresnames = godnamesa;
        ResultPageMulti.highscorescores = godscoresa;

        keeper.clear();      
        for (int i = godnamesa.size() - 1; i >= 0; i--) {
            tempy = String.format("%-29s%29d", godnamesa.get(i), godscoresa.get(i));
            keeper.add(tempy);
        }
        try {
          if (keeper.isEmpty()){
              keeper.clear();
              keeper.add("Empty");
              godkings.setListData(keeper.toArray());
              godkings.repaint();  
            }
            else
            {
            godkings.setListData(keeper.toArray());
            godkings.repaint();
            }
        } catch (NullPointerException e) {}
    }

    public static int getBiggestScore() {
        try {
            return godkingscore.get(godkingscore.size() - 1);
        } catch (Exception az) {
        }
        return (int) 0;
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
            java.util.logging.Logger.getLogger(HighScores.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(HighScores.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(HighScores.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(HighScores.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new HighScores().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
