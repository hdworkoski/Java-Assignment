package Utilities;

import Classes.Coach;
import Classes.Player;
import Classes.Team;
import DAL.MemberFunctions;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author hillarydworkoski
 * File: RestoreDatabase.java
 * Description: This file gets data from database backup files and restores the
 * data to the database
 * Date: 21/06/18
 */
public class RestoreDatabase
{
    private static ArrayList<Team> teamList = new ArrayList<>();
    private static final String FILE_T = "TeamList.bin";
    private static ArrayList<Player> playerList = new ArrayList<>();
    private static final String FILE_P = "PlayerList.bin";
    private static ArrayList<Coach> coachList = new ArrayList<>();
    private static final String FILE_C = "CoachList.bin";
    
    /**
     * This method calls on other methods to create an ArrayList of each
     * object type (Team, Player, Coach) and then loops through the ArrayList to
     * add each object to the database
     */
    public static void readAll()
    {
        try
        {
            //read the contents of the files
            teamList = readTeam(teamList, FILE_T);
            playerList = readPlayer(playerList, FILE_P);
            coachList = readCoach(coachList, FILE_C);
            String sqlT = "Insert into tblTeam Values";
            for(int i=0; i<teamList.size(); i++)
            {
                Team t = teamList.get(i);
                MemberFunctions.addTeam(t.getName(), t.getConference(), t.getDivision());
            }
            for(int i=0; i<playerList.size(); i++)
            {
                Player p = playerList.get(i);
                int rookie;
                if(p.isRookie())
                    rookie = 1;
                else
                    rookie = 0;
                MemberFunctions.addPlayer(p.getID(), p.getTeam(), p.getFirstName(), 
                        p.getLastName(), p.getPhone(), p.getEmail(), 
                        p.getNumber(), p.getCollege(), rookie, p.getStartYear(), 
                        p.getPosition(), p.getCountry(), p.getPPG(), p.getRPG(), 
                        p.getHS());
            }
            for(int i=0; i<coachList.size(); i++)
            {
                Coach c = coachList.get(i);
                MemberFunctions.addCoach(c.getID(), c.getTeam(), c.getFirstName(), 
                        c.getLastName(), c.getPhone(), c.getEmail(), 
                        c.getYearsExp(), c.getChampionships(), c.getPlayoffs(), 
                        c.getwLRatio());
            }
            JOptionPane.showMessageDialog(null, "Database Restored From Backup");
        }
        catch(FileNotFoundException FNFex)
        {
            System.err.println("File Not Found Error: " + FNFex.getMessage());
            JOptionPane.showMessageDialog(null, "Error: Backup Files Not Found");
        }
        catch(ClassNotFoundException CNFex)
        {
            System.err.println("Class Not Found Error: " + CNFex.getMessage());
        }
        catch(IOException IOex)
        {
            System.err.println("Error: " + IOex);
        }
    }
    
    /**
     * 
     * @param teamList ArrayList to fill
     * @param fileName name of file to access data from
     * @return ArrayList<Team> teams read from file
     * @throws FileNotFoundException
     * @throws ClassNotFoundException
     * @throws IOException 
     * This method reads from the team file to add the Team ArrayList from the 
     * file to the ArrayList provided
     */
    public static ArrayList<Team> readTeam(ArrayList<Team> teamList, String fileName)
                                throws FileNotFoundException, 
                                    ClassNotFoundException, IOException
    {
        FileInputStream fIS = new FileInputStream(fileName);
        ObjectInputStream oIS = new ObjectInputStream(fIS);
        
        teamList = (ArrayList<Team>) oIS.readObject();
        
        oIS.close();
        return teamList;
    }
    
    /**
     * 
     * @param playerList
     * @param fileName
     * @return ArrayList<Player> players read from file
     * @throws FileNotFoundException
     * @throws ClassNotFoundException
     * @throws IOException 
     * This method reads from the player file to add the Player ArrayList from the
     * file to the ArrayList provided
     */
    public static ArrayList<Player> readPlayer(ArrayList<Player> playerList, String fileName)
                                throws FileNotFoundException, 
                                    ClassNotFoundException, IOException
    {
        FileInputStream fIS = new FileInputStream(fileName);
        ObjectInputStream oIS = new ObjectInputStream(fIS);
        
        playerList = (ArrayList<Player>) oIS.readObject();
        
        oIS.close();
        return playerList;
    }
    
    /**
     * 
     * @param coachList
     * @param fileName
     * @return ArrayList<Coach> coaches from the file
     * @throws FileNotFoundException
     * @throws ClassNotFoundException
     * @throws IOException 
     * This method reads from the coach file to add the Coach ArrayList from the
     * file to the ArrayList provided
     */
    public static ArrayList<Coach> readCoach(ArrayList<Coach> coachList, String fileName)
                                throws FileNotFoundException, 
                                    ClassNotFoundException, IOException
    {
        FileInputStream fIS = new FileInputStream(fileName);
        ObjectInputStream oIS = new ObjectInputStream(fIS);
        
        coachList = (ArrayList<Coach>) oIS.readObject();
        
        oIS.close();
        return coachList;
    }
}