/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Shizzle;

import java.security.SecureRandom;

/**
 *
 * @author owoye001
 * Represents the meaning of each scrabble letter and it score
 */
public class Letter {
    private int letternum;
    private String letterself;
    private final SecureRandom securerandom = new SecureRandom();
    
    private final String [] Alpha = {"A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z"};
    private final int [] NumbAssoc = {1,3,3,2,1,4,2,4,1,8,5,1,3,1,1,3,10,1,1,1,1,4,4,8,4,10};
   
    public int gmaLetterNumAssc(String fa)
    {
        int thenumber=0;
        for (int i=0; i<=25; i++)
            if (fa.contains(Alpha[i])==true)
            {
                thenumber = NumbAssoc[i];
            }
        return thenumber;
    }
    
}
