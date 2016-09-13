/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Shizzle;

import java.io.Serializable;

/**
 *Every game that is sent over the network is of this format. 
 * @author owoye001
 */
public class Game implements Serializable{
    private static final long serialVersionUID = 2234L;
    private String [][] game = new String [6][6]; 
    private final String [] ListofWords;
    public Game ()
    {
        this(null, null);
    }
    public Game(String [][] x, String [] words)
            {
                game = x;
                ListofWords = words;
            }
    public String[][] getGame()
    {
        return game;
    }
    public String[] getListWords()
    {
        return ListofWords;
    }
}
