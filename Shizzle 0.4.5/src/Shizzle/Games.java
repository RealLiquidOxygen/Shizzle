/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Shizzle;

import java.io.ObjectInputStream;
import java.io.IOException;
import java.io.EOFException;
import java.io.File;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.security.SecureRandom;
import javax.swing.JOptionPane;

/**
 *
 * @author owoye001
 * Loads every game board into memory and decide which game a user plays every time 
 */
public class Games {
    private static ObjectInputStream input;
     public static String [][] gameLoad = new String [6][6]; 
    public static String [] ListofWordsLoad = null;
    public static SecureRandom secureRandom = new SecureRandom();
    public static JOptionPane myIo;
    public static int checker;
     public  URL url ;
    public static String urll;
    
    public Games(int x){
    checker = x;
        
            //url = this.getClass().getResource("Scrabble/gameplay.gmp");
            //urll= String.valueOf(url).substring(6);
            
         String path;String filename;
         filename ="gameplay.gmp";
        {
        File f = new File(System.getProperty("java.class.path"));
        File dir = f.getAbsoluteFile().getParentFile();
        path = dir.toString();
        urll =path+"\\Scrabble\\" + filename;
       
       // System.out.println ("This is dir: " + urll );
        //System.exit(0);
       }
       
        
        openGameplay();
        readGames();
        closeGamePlay();
        
    }
   
    public static  Game [] gameplays = new Game[31]; //change for bigger array
    public static int intra=0;
   
    public static void gameData(Game x)
            {
                
               //System.out.println(intra); 
                gameplays[intra]= x;
                intra = intra +1;
                
            }
    public static void loadGameData()
    {
        int gamenum; //to ensure that send game is picked
        if (checker == -1)
        {
            gamenum = secureRandom.nextInt(gameplays.length);
            Game_1.gamenum=gamenum;
        }
        else
        {
            gamenum = checker;
        }
        
        gameLoad = gameplays[gamenum].getGame();
        ListofWordsLoad  = gameplays[gamenum].getListWords();
        intra=0; //resets
    }
    
 String[][] getCurrentGame()
 {
     return gameLoad;
 }
 
String[] getWords()
 {
     return ListofWordsLoad;
 }
   
    //opening game file
    
    public static void openGameplay()
    { 
        //System.out.println(urll);
        
        try
        {
             input = new ObjectInputStream (Files.newInputStream(Paths.get(urll)));
        }
        catch (IOException e)
        {
            myIo.showMessageDialog (null, "Error", "Shizzle", JOptionPane.PLAIN_MESSAGE);
            e.printStackTrace();
            System.exit(0);
        }
        
    }
    public static void readGames()
    {
      try
      {
          while (true)
          {
          Game gameplay = (Game) input.readObject();
          gameData(gameplay);
          
          
          }
          
      }
      catch (EOFException e)
      {
          //System.out.println ("Data read");
      }
      catch (IOException e)
        {
            myIo.showMessageDialog (null, "Error", "Shizzle", JOptionPane.PLAIN_MESSAGE);
            e.printStackTrace();
            System.exit(0);
        }
      catch (ClassNotFoundException e)
      {
          myIo.showMessageDialog (null, "An error was encountered during program startup. Terminating", "Shizzle", JOptionPane.PLAIN_MESSAGE);
          e.printStackTrace();  
          System.exit(0);
      }
      loadGameData(); //loads game data
    }
    public static void closeGamePlay() 
    {
        try
        {
       input.close();
        }
        catch (IOException ioException)
        {
            myIo.showMessageDialog (null, "An error was encountered during program startup. Terminating", "Shizzle", JOptionPane.PLAIN_MESSAGE);
            ioException.printStackTrace();
            System.exit(0);
        }
    }

    String alpha(int i, int i0) {
        i=i-1;
        i0=i0-1;
         return gameLoad[i][i0];
    }
    
}
