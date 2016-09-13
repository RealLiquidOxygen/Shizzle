/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Shizzle;

import java.awt.Color;
import java.io.File;
import java.util.Properties;
import java.io.FileOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Set;

/**
 *
 * @author owoye001
 * handle program background color customization 
 */
public class PropertyCreator {

    public static void main(String[] args) {
     makeProperties();
    }

    private static Color Colorizer(String property) {
        switch (property) {
            case "yellow":
                return Color.yellow;
            case "black":
                return Color.black;
            case "green":
                return Color.green;
            case "white":
                return Color.white;
            case "blue":
                return Color.blue;
            case "purple":
                return Color.magenta;
            case "orange":
                return Color.orange;
            case "otherbuttonbackgroundgreen":
                return new Color(51, 102, 0);
            case "otherbuttonforegroundgreen":
                return new Color(102, 255, 102);
            case "pbcgd":
                return new Color(0, 153, 0);
            case "crbcgd":
                return new Color(0, 204, 204);
            case "stbcgd":
                return new Color(255, 51, 51);
            case "opbcgd":
                return new Color(255, 102, 102);
            case "mbbcgd":
                return new Color(102, 51, 255);
            case "dbcgd":
                return new Color(255, 0, 255);
            case "abbcgd":
                return new Color(204, 255, 204);
            case "ebcgd":
                return new Color(255, 153, 153);
            case "mbcgd":
                return new Color(255, 204, 255);
                
                //skylight
            case "otherbuttonbackgroundblue":
                return new Color(204, 204, 255);
            case "otherbuttonforegroundblue":
                return new Color(0, 51, 102);
            case "pbcsl":
                return new Color(153,153,255);
            case "crbcsl":
                return new Color(0,0,153);
            case "stbcsl":
                return new Color(0,153,255);
            case "opbcsl":
                return new Color(204,204,255);
            case "mbbcsl":
                return new Color(102,51,255);
            case "dbcsl":
                return new Color(51,255,255);
            case "abbcsl":
                return new Color(0,102,102);
            case "ebcsl":
                return new Color(0,0,102);
            case "mbcsl":
                return new Color(204,204,255);
                
                //night shade
             case "otherbuttonbackgroundorange":
                return new Color(204, 204, 255);
            case "otherbuttonforegroundorange":
                return new Color(0, 51, 102);
            case "pbcns":
                return new Color(204,102,0);
            case "crbcns":
                return new Color(255,102,102);
            case "stbcns":
                return new Color(255,51,0);
            case "opbcns":
                return new Color(0,153,255);
            case "mbbcns":
                return new Color(102,102,0);
            case "dbcns":
                return new Color(153,153,153);
            case "abbcns":
                return new Color(102,102,102);
            case "ebcns":
                return new Color(204,153,0);
            case "mbcns":
                return new Color(204,204,255);
                
                //purple sensation
            case "otherbuttonbackgroundpurple":
                return new Color(204, 204, 255);
            case "otherbuttonforegroundpurple":
                return new Color(0, 51, 102);
            case "pbcps":
                return new Color(255,204,255);
            case "crbcps":
                return new Color(204,0,204);
            case "stbcps":
                return new Color(153,0,255);
            case "opbcps":
                return new Color(255,0,153);
            case "mbbcps":
                return new Color(204,204,255);
            case "dbcps":
                return new Color(153,0,255);
            case "abbcps":
                return new Color(0,102,204);
            case "ebcps":
                return new Color(153,0,153);
            case "mbcps":
                return new Color(204,204,255);
        }
        return Color.black;
    }
    static Properties table = new Properties();
     //------------------------
    public static String propertyname;
    public static Color ProgramNameColor;
    public static String BackgroundImage;
    public static Color FormBackgroundColor;
    public static Color UsernameForeColor;

    public static Color PracticeBackColor;
    public static Color PracticeForeColor;
    public static Color ChatRoomBackColor;
    public static Color ChatRoomForeColor;
    public static Color SettingsBackColor;
    public static Color SettingsForeColor;
    public static Color OnlinePlayBackColor;
    public static Color OnlinePlayForeColor;
    public static Color MyBestBackColor;
    public static Color MyBestForeColor;
    public static Color DonateBackColor;
    public static Color DonateForeColor;
    public static Color AboutBackColor;
    public static Color AboutForeColor;
    public static Color ExitBackColor;
    public static Color ExitForeColor;
    public static Color MinimizeBackColor;
    public static Color MinimizeForeColor;
    public static Color LabelTextForeColor;
    public static Color LabelTextBackColor;
    public static Color OtherButtonBackColor;
    public static Color OtherButtonForeColor;
    public static Color ContentHolderBackColor;
    public static Color ContentHolderForeColor;
    public static Color CaretColor;

    //-----------------------

    public PropertyCreator() {
        loadfile();
        loadProperties(table);
    }

    private static void listProperties(Properties table) {
        Set<Object> keys = table.keySet();

        for (Object key : keys) {
            System.out.printf("%s\t%s%n", key, table.getProperty((String) key));
        }

        System.out.println();
    }

    //saves the properties of the game section to memory 
    private static void saveProperties(Properties table) {
        System.out.println("*************************************");
        System.out.println("   Attempting to Save Properties");
        System.out.println("*************************************");
        try {
            FileOutputStream output = new FileOutputStream("PurpleSensation.gmc");
            table.store(output, "Program Properties");
            output.close();
            System.out.println("Info: Properties Saved!");
        } catch (IOException io) {
            io.printStackTrace();
        }
        System.out.println("************************************");
        System.out.println();
    }

    //load properties need for gamesection to memeory 
    public static void loadProperties(Properties table) {
        try {
            String soundbutt;
            String path;
            String soundname = Settings.profilename;
            File f = new File(System.getProperty("java.class.path"));
            File dir = f.getAbsoluteFile().getParentFile();
            path = dir.toString();
            soundbutt = soundname;
            String location = path + "\\Colorings\\" + soundbutt;
            FileInputStream input = new FileInputStream(location);
            table.load(input);
            input.close();
            //System.out.println("Info: Properties Loaded!");
            //--------
            propertyname = table.getProperty("propertyname");
            ProgramNameColor = Colorizer(table.getProperty("Program Name Color"));
            BackgroundImage = (table.getProperty("Background Image"));
            FormBackgroundColor = Colorizer(table.getProperty("Form Background Color"));
            UsernameForeColor = Colorizer(table.getProperty("Username ForeColor"));
            PracticeBackColor = Colorizer(table.getProperty("Practice Back Color"));
            PracticeForeColor = Colorizer(table.getProperty("Practice Fore color"));
            ChatRoomBackColor = Colorizer(table.getProperty("ChatRoom Back Color"));
            ChatRoomForeColor = Colorizer(table.getProperty("ChatRoom Fore color"));
            SettingsBackColor = Colorizer(table.getProperty("Settings Back Color"));
            SettingsForeColor = Colorizer(table.getProperty("Settings Fore color"));
            OnlinePlayBackColor = Colorizer(table.getProperty("OnlinePlay Back Color"));
            OnlinePlayForeColor = Colorizer(table.getProperty("OnlinePlay Fore color"));
            MyBestBackColor = Colorizer(table.getProperty("MyBest Back Color"));
            MyBestForeColor = Colorizer(table.getProperty("MyBest Fore color"));
            DonateBackColor = Colorizer(table.getProperty("Donate Back Color"));
            DonateForeColor = Colorizer(table.getProperty("Donate Fore color"));
            AboutBackColor = Colorizer(table.getProperty("About Back Color"));
            AboutForeColor = Colorizer(table.getProperty("About Fore color"));
            ExitBackColor = Colorizer(table.getProperty("Exit Back Color"));
            ExitForeColor = Colorizer(table.getProperty("Exit Fore color"));
            MinimizeBackColor = Colorizer(table.getProperty("Minimize Back Color"));
            MinimizeForeColor = Colorizer(table.getProperty("Minimize Fore Color"));
            LabelTextForeColor = Colorizer(table.getProperty("Label Text Fore Color"));
            LabelTextBackColor = Colorizer(table.getProperty("Label Text Back Color"));
            OtherButtonBackColor = Colorizer(table.getProperty("Other Button Back Color"));
            OtherButtonForeColor = Colorizer(table.getProperty("Other Button Fore Color"));
            ContentHolderBackColor = Colorizer(table.getProperty("Content Holder BackColor"));
            ContentHolderForeColor = Colorizer(table.getProperty("Content Holder ForeColor"));
            CaretColor = Colorizer(table.getProperty("Caret Color"));
            //--------
        } catch (IOException iot) {
            iot.printStackTrace();
        }
        System.out.println();
    }

    //method is probably not used during program run time . 
    //It can used to generate new customization for the game 
    private static void makeProperties() {
        try {
            String soundbutt;
            String path;
            String soundname = "purplesensation.jpg";
            File f = new File(System.getProperty("java.class.path"));
            File dir = f.getAbsoluteFile().getParentFile();
            path = dir.toString();
            soundbutt = soundname;
            String location = path + "\\Colorings\\" + soundbutt;

            //profile name
            table.setProperty("propertyname", "Purple Sensation");
            //common to all forms
            table.setProperty("Program Name Color", "crbcps");
            table.setProperty("Background Image", soundname);
            table.setProperty("Form Background Color", "pbcps");
            table.setProperty("Username ForeColor", "white");

            //the five buttops on the main screen
            table.setProperty("Practice Back Color", "pbcps");
            table.setProperty("Practice Fore color", "white");
            table.setProperty("ChatRoom Back Color", "crbcps");
            table.setProperty("ChatRoom Fore color", "white");
            table.setProperty("Settings Back Color", "stbcps");
            table.setProperty("Settings Fore color", "white");
            table.setProperty("OnlinePlay Back Color", "opbcps");
            table.setProperty("OnlinePlay Fore color", "white");
            table.setProperty("MyBest Back Color", "mbbcps");

            table.setProperty("MyBest Fore color", "white");

            table.setProperty("Donate Back Color", "dbcps");
            table.setProperty("Donate Fore color", "white");
            table.setProperty("About Back Color", "abbcps");
            table.setProperty("About Fore color", "white");
            table.setProperty("Exit Back Color", "ebcps");
            table.setProperty("Exit Fore color", "white");
            table.setProperty("Minimize Back Color", "mbcps");
            table.setProperty("Minimize Fore Color", "white");

            table.setProperty("Label Text Fore Color", "purple");
            table.setProperty("Label Text Back Color", "pbcps");
            table.setProperty("Other Button Back Color", "crbcps");
            table.setProperty("Other Button Fore Color", "pbcps");
            table.setProperty("Content Holder BackColor", "white");
            table.setProperty("Content Holder ForeColor", "purple");
            table.setProperty("Caret Color", "purple");

            System.out.println("***************************");
            System.out.println(" Properties that was saved");
            System.out.println("***************************");
            System.out.println();
            listProperties(table);
            saveProperties(table);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println();
    }
    public static void savefile() {
        String [] prop= new String[3];
        prop[0]=Settings.profilename;
        prop[1]=String.valueOf(Settings.Soundonoff.isSelected());
        prop[2]=String.valueOf(Settings.Musicoff.isSelected());
        try {
            FileOutputStream fos = new FileOutputStream("LookAndFeel.gmc");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(prop);
        } catch (Exception e) {
            //JOptionPane.showMessageDialog(null, "Error");
        }
    }
    public static void loadfile() {
        String soundbutt;
        String path;
        {
            String soundname = "LookAndFeel.gmc";
            File f = new File(System.getProperty("java.class.path"));
            File dir = f.getAbsoluteFile().getParentFile();
            path = dir.toString();
            soundbutt = soundname;
            //System.out.println ("This is dir: " + path+soundbutt );
        }
        try {
            FileInputStream fis = new FileInputStream(path + "\\" + soundbutt);
            String[] prop;
            try (ObjectInputStream ois = new ObjectInputStream(fis)) {
                prop = (String[]) ois.readObject();
            }
            Settings.profilename = prop[0];
            MainMenu.CheckSound=Boolean.valueOf(prop[1]);
            MainMenu.MusicOk = Boolean.valueOf(prop[2]);
            //MainMenu.FirstTimeLaunch=false; 
            //System.out.println ("Success! File Loaded!");
        } catch (Exception e) {}
    }
}
