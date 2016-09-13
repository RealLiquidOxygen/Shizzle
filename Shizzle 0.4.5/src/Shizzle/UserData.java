package Shizzle;


import java.io.*;
import java.util.ArrayList;
import java.util.List;


public class UserData implements Serializable {

    protected static final long serialVersionUID = 1112122L;

    private String [] FirstUserWords;
    
    private int [] FirstUserScore;
    
    private int FirstUserZnum;
    
    private String FirstUserName;
    
    private String [] SecondUserWords;
    
    private int [] SecondUserScore;
    
    private int SecondUserZnum;
    
    private String SecondUserName;
    
    private int gamenum;
    
    private int Type; //game type
    
    static final int WHOISIN = 0, MESSAGE = 1, LOGOUT = 2;

    private int type; //message type 

    private String message; //chat message. 
    
    private ArrayList<String> uslist; //userlist
    
    private List<String> highscoresnames; //highscores
    
    private List<Integer> highscore; //scores
    
    private String username;

    UserData(String qf, int type, String message, ArrayList<String> x,int t,  String u, String [] a, int [] b, int y,  String v, String[] d, int [] e, int z, int g, List<String> nj, List<Integer> uj) {
    
    highscoresnames =nj; //high scores
    
    highscore =uj;
        
    username = qf;
        
    FirstUserName=u;
        
    FirstUserWords=a;
    
    FirstUserScore=b;
    
    FirstUserZnum=y;
    
    SecondUserWords=d;
    
    SecondUserScore=e;
    
    SecondUserZnum=z;
    
    SecondUserName=v;
    
    gamenum=g;
    
    this.message = message;
    
    this.type = type;
    
    Type=t;
    
    uslist = x;
    
    }
    
    UserData (String as, String mm, int wa)
    {
        username = as;
        
        message = mm;
        
        type = wa;
        
        FirstUserName=null;
        
        FirstUserWords=null;

        FirstUserScore=null;

        FirstUserZnum=0;

        SecondUserWords=null;

        SecondUserScore=null;

        SecondUserZnum=0;

        SecondUserName=null;

        gamenum=0;
    
        uslist = null;
        
        Type = 0;
        
        highscoresnames = null;
        
        highscore = null;

    }
    void setHighScoreScore (ArrayList<Integer> tgh)
    {
        highscore = tgh;
    }
    List<Integer> getHighSchoreScore ()
    {
        return highscore;
    }
    void setHighScoresNames (ArrayList<String> ore)
    {
        highscoresnames = ore;
    }
    
    List<String> getHighScoresNames ()
    {
        return highscoresnames; //returns the highscores.
    }
    
    void setSecondUserWords (String [] df)
    {
        SecondUserWords = df;
    }
    void setFirstUserWords (String [] lk)
    {
        FirstUserWords = lk;
    }
    void setSecondUserZNum (int gj)
    {
        SecondUserZnum = gj;
    }
    void setFirstUserZNum (int bn)
    {
        FirstUserZnum = bn;
    }
    void setSecondUserScore (int [] pop)
    {
        SecondUserScore = pop;
    }
    void setFirstUserScore (int [] po)
    {
        FirstUserScore = po;
    }
    void setFirstUserName (String fm)
    {
        FirstUserName = fm;
    }
    void setSecondUserName (String er)
    {
        SecondUserName = er;
    }
    void setGameNum(int iu)
    {
        gamenum=iu;
    }
    void setGameType (int hh)
    {
     Type = hh;   
    }
    void setMessageType(int o)
    {
        type=0;
    }
    void setMessage(String mt)
    {
        
     message = mt;   
    }
    void setUsername(String gh)
    {
        username = gh;
    }

    void setUserList(ArrayList<String> x)
    {
        uslist = x;
    }
    int getGameType()
    {
        return Type;
    }
    String getFirstUserName(){
        return FirstUserName;
    }
    String [] getFirstUserWords() {
        return FirstUserWords;
    }
    
    int [] getFirstUserScore() {
        return FirstUserScore;
    }
    int getFirstUserZNum(){
        return FirstUserZnum;
    }
    String getSecondUserName(){
        return SecondUserName;
    }
    String [] getSecondUserWords() {
        return SecondUserWords;
    }
    
    int [] getSecondUserScore() {
        return SecondUserScore;
    }
    int getSecondUserZNum(){
        return SecondUserZnum;
    }
    
    int getGameNum(){
        return gamenum;
    }
    
    int getMessageType() {

        return type;

    }

    String getMessage() {

        return message;

    }
    
    String getUserName() {

        return username;

    }
    
     ArrayList<String> getUserList() {

        return uslist;
    }

}