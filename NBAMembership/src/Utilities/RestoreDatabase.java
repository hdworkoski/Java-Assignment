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
 */
public class RestoreDatabase
{
    private static ArrayList<Team> teamList = new ArrayList<>();
    private static final String FILE_T = "TeamList.bin";
    private static ArrayList<Player> playerList = new ArrayList<>();
    private static final String FILE_P = "PlayerList.bin";
    private static ArrayList<Coach> coachList = new ArrayList<>();
    private static final String FILE_C = "CoachList.bin";
    
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