package Utilities;

import Classes.Coach;
import Classes.Player;
import Classes.Team;
import DAL.MemberFunctions;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.NotSerializableException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author hillarydworkoski
 * File: BackupDatabase.java
 * Description: This file backs up the database objects (Players, Teams, Coaches)
 * to binary files
 * Date: 21/06/18
 */
public class BackupDatabase
{
    private static ArrayList<Team> teamList = new ArrayList<>();
    private static final String FILE_T = "TeamList.bin";
    private static ArrayList<Player> playerList = new ArrayList<>();
    private static final String FILE_P = "PlayerList.bin";
    private static ArrayList<Coach> coachList = new ArrayList<>();
    private static final String FILE_C = "CoachList.bin";
    
    /**
     * This method calls on other methods to add objects to the ArrayLists and 
     * then save the ArrayLists to files
     */
    public static void backup()
    {
        try
        {
            teamList = MemberFunctions.getTeams();
            playerList = MemberFunctions.getPlayers();
            coachList = MemberFunctions.getCoaches();
            saveTeam(teamList, FILE_T);
            savePlayer(playerList, FILE_P);
            saveCoach(coachList, FILE_C);
            JOptionPane.showMessageDialog(null, "Database Successfully Saved to Backup Files");
        }
        catch(FileNotFoundException fnfE)
        {
            System.err.print("Problems with files");
        }
        catch(NotSerializableException nsE)
        {
            System.err.print("Class not serialised");
        }
        catch(IOException ioE)
        {
            System.err.print("Problems with saving data to files");
        }
    }
    
    /**
     * 
     * @param teamList filled list of Teams from database
     * @param fileT file name
     * @throws FileNotFoundException
     * @throws IOException
     * @throws NotSerializableException 
     * This method takes the filled ArrayList and saves it as an object to a file
     */
    public static void saveTeam(ArrayList<Team> teamList, String fileT) throws 
                                            FileNotFoundException, IOException, 
                                                NotSerializableException
    {
        FileOutputStream fos = new FileOutputStream(fileT); 
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        
        oos.writeObject(teamList);
        
        oos.close(); 
    }
    
    /**
     * 
     * @param playerList filled list of Players from database
     * @param fileP file name
     * @throws FileNotFoundException
     * @throws IOException
     * @throws NotSerializableException
     * This method takes the filled ArrayList and saves it as an object to a file
     */
    public static void savePlayer(ArrayList<Player> playerList, String fileP) throws 
                                            FileNotFoundException, IOException, 
                                                NotSerializableException
    {
        FileOutputStream fos = new FileOutputStream(fileP); 
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        
        oos.writeObject(playerList);
        
        oos.close(); 
    }
    
    /**
     * 
     * @param coachList filled list of Coaches from database
     * @param fileC file name
     * @throws FileNotFoundException
     * @throws IOException
     * @throws NotSerializableException 
     * This method takes the filled ArrayList and saves it as an object to a file
     */
    public static void saveCoach(ArrayList<Coach> coachList, String fileC) throws 
                                            FileNotFoundException, IOException, 
                                                NotSerializableException
    {
        FileOutputStream fos = new FileOutputStream(fileC); 
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        
        oos.writeObject(coachList);
        
        oos.close(); 
    }
}