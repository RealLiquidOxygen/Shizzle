/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Shizzle;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

/**
 *
 * @author owoye001
 * THIS CLASS IS USED TO GENERATE GAME PLAY BOARD FOR THE GAME. THE 6X6 BORAD 
 */
public class SaveGame {

    private static ObjectOutputStream output; // outputs data to file
    public static String YN="y";

    public SaveGame() {

        openFile();
        addGames();
        closeFile();
    }

    public static void openFile() {

        try {

            output = new ObjectOutputStream(Files.newOutputStream(Paths.get("gameplay.gmp")));
        } catch (IOException ioException) {
            System.err.println("Error opening file. Termniating");
            System.exit(0);
        }
    }

    public static void addGames() 
    {
        String[] listedword;
        String[][] collector;
        while (YN.equalsIgnoreCase("y") == true) 
        {
             collector=null;
            listedword=null;
            
            System.out.println();
            System.out.println("GAME PLAY DATA COLLECTION");
            System.out.println("******************************");
            System.out.println();
            Scanner input = new Scanner(System.in);
            collector = new String[6][6];

            for (int j = 0; j < 6; j++) {
                for (int k = 0; k < 6; k++) {
                    System.out.print("Row " + j + ", Column " + k + ": ");
                    collector[j][k] = input.next();
                }
            }

            System.out.println();
            System.out.println("CONTENT OF GAME PLAY FILE");
            System.out.println("***************************");

    //print out the content
            for (int j = 0; j < 6; j++) {
                for (int k = 0; k < 6; k++) {
                    System.out.print(collector[j][k] + " ");

                }
                System.out.println();
            }
    //----------------

            System.out.println();

            System.out.println("LIST OF WORDS COLLECTION");
            System.out.println("***************************");
            System.out.println();
            System.out.print("How many words do you want to input? ");
            int num = input.nextInt() - 1;
            System.out.println("Number of words required for input: " + (num + 1));
            int a = 0; //array counter for the listed words
            listedword = new String[num+1];
            while (num >= 0) {
                System.out.print("Enter word: ");
                listedword[a] = input.next();
                a = a + 1;
                num = num - 1;
            }

            //prints the list of words inputted
            System.out.println();
            System.out.println("LIST OF WORDS INPUTTED");
            System.out.println("**************************");
            for (String apple : listedword) {
                System.out.println(apple);
            }

            System.out.println();
            System.out.println("INFO: GAME SAVE IN PROGRESS");
            System.out.println("*****************************");

    //sending collection to the game.java 
            //-------------------------------------
            Game gameplay = new Game(collector, listedword);
    //----------------------------------------
            //getting file ready for game save.
            try {
                output.writeObject(gameplay);
            } catch (IOException ioException) {
                System.out.println("Error writing to file. Terminatnig");
                System.exit(0);
            }
            System.out.println("********************************");
            System.out.print("Do you want to enter another gameplay? (y|n) ");
            YN = input.next();
           
        }

    }
//close file here

    public static void closeFile() {
        try {
            output.close();
            System.out.println();
            System.out.println("****************************************");
        } catch (IOException ioException) {
            System.err.println("Error closing file. Terminating");
            System.exit(0);
        }
    }
}
