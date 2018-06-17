package DAL;

import Classes.Coach;
import Classes.Player;
import Classes.Team;
import com.mysql.jdbc.exceptions.MySQLIntegrityConstraintViolationException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author hillarydworkoski
 * File: MemberFunctions.java
 * Description: This file contains many different functions called by other classes
 * to run SQL queries or other functions regarding Teams, Members, Players, and Coaches
 * Date: 21/06/18
 */
public class MemberFunctions
{
    /**
     * 
     * @param ID
     * @param team
     * @param firstName
     * @param lastName
     * @param phone
     * @param email
     * @param number
     * @param college
     * @param rookie
     * @param startYear
     * @param position
     * @param country
     * @param ppg
     * @param rpg
     * @param highScore 
     * This method creates an SQL query that adds a player to the database
     */
    public static void addPlayer(String ID, String team, String firstName, String lastName, String phone,
                String email, String number, String college, int rookie,
                    int startYear, String position, String country, float ppg,
                        float rpg, int highScore)
    {
        Statement stmt = null;
        try
        {
            ConnectionDetails cd = new ConnectionDetails();
            Connection con = cd.getConnection();
            stmt = con.createStatement();
            String sql = "Insert into tblPlayer Values(\"" + ID  + "\",\"" + team
                    + "\",\"" + firstName + "\",\"" + lastName + "\",\"" + phone + "\",\""
                    + email + "\",\"" + number + "\",\"" + college + "\"," + rookie
                    +  "," + startYear + ",\"" + position + "\",\"" + country + "\","
                    + ppg + "," + rpg + "," + highScore + ");";
            stmt.executeUpdate(sql);
            con.close();
        }
        catch(MySQLIntegrityConstraintViolationException PKex)
        {
            System.err.println("SQL Error: " + PKex.getMessage());
        }
        catch(SQLException sqlE)
        {
            System.err.println("SQL Error: " + sqlE.getMessage());
        }
    }
    
    /**
     * 
     * @param ID
     * @param team
     * @param firstName
     * @param lastName
     * @param phone
     * @param email
     * @param number
     * @param college
     * @param rookie
     * @param startYear
     * @param position
     * @param country
     * @param ppg
     * @param rpg
     * @param highScore 
     * This method creates an SQL Query that edits an existing player in the database
     */
    public static void savePlayer(String ID, String team, String firstName, String lastName, String phone,
                    String email, String number, String college, int rookie,
                        int startYear, String position, String country, float ppg,
                            float rpg, int highScore)
    {
        Statement stmt = null;
        try
        {
            ConnectionDetails cd = new ConnectionDetails();
            Connection con = cd.getConnection();
            stmt = con.createStatement();
            String sql = "Update tblPlayer Set team = '" + team 
                    + "', firstName = '" + firstName + "', lastName = '" 
                    + lastName + "', phone = '" + phone + "', email = '"
                    + email + "', number = '" + number + "', college = '"
                    + college + "', rookie = " + rookie + ", startYear = "
                    + startYear + ", position = '" + position + "', country = '"
                    + country + "', ppg = " + ppg + ", rpg = " + rpg 
                    + ", highScore = " + highScore + " Where ID = '" + ID + "';";
            stmt.executeUpdate(sql);
            con.close();
        }
        catch(SQLException sqlE)
        {
            System.err.println("SQL Error: " + sqlE.getMessage());
        }
    }
    
    /**
     * 
     * @return ArrayList<Player> of all players in database
     * This method creates an SQL query to get all players from the database and
     * add each one to a Player ArrayList
     */
    public static ArrayList<Player> getPlayers()
    {
        ArrayList<Player> list = new ArrayList<>();
        Statement stmt = null;
        ResultSet r = null;
        
        try
        {
            ConnectionDetails cd = new ConnectionDetails();
            Connection con = cd.getConnection();
            
            stmt = con.createStatement();
            String sql = "Select * from tblPlayer";
            
            r = stmt.executeQuery(sql);
            
            while(r.next())
            {
                list.add(new Player(r.getString("ID"), r.getString("team"), 
                    r.getString("firstName"), r.getString("lastName"),
                    r.getString("phone"), r.getString("email"), r.getString("number"),
                    r.getString("college"), r.getBoolean("rookie"), r.getInt("startYear"),
                    r.getString("position"), r.getString("country"), r.getFloat("ppg"),
                    r.getFloat("rpg"), r.getInt("highScore")));
            }
            con.close();
        }
        catch(SQLException ex)
        {
            System.out.println(ex.getMessage());
        }
        return list;
    }
    
    /**
     * 
     * @param last last name search term
     * @return Player
     * This method searches all Players in database to see if there is a match
     */
    public static Player searchPlayer(String last)
    {
        Player p = new Player("", "", "", "", "", "", "", "", false, 0, "", "", 0, 0, 0);
        ArrayList<Player> players = getPlayers();
        for(int i=0; i<players.size(); i++)
        {
            if(players.get(i).getLastName().equalsIgnoreCase(last))
            {
                p = players.get(i);
            }
        }
        return p;
    }
    
    /**
     * 
     * @param ID PK of player to delete
     * This method creates an SQL query to delete a player from the database
     */
    public static void deletePlayer(String ID)
    {
        Statement stmt = null;
        try
        {
            ConnectionDetails cd = new ConnectionDetails();
            Connection con = cd.getConnection();
            stmt = con.createStatement();
            String sql = "Delete from tblPlayer Where ID = \"" + ID  + "\";";
            stmt.executeUpdate(sql);
            con.close();
            JOptionPane.showMessageDialog(null, "Player " + ID 
                    + " has been deleted from the database");
        }
        catch(MySQLIntegrityConstraintViolationException PKex)
        {
            System.err.println("SQL Error: " + PKex.getMessage());
            JOptionPane.showMessageDialog(null, "Player " + ID + " cannot be deleted");
        }
        catch(SQLException sqlE)
        {
            System.err.println("SQL Error: " + sqlE.getMessage());
        }
    }
    
    /**
     * 
     * @param name
     * @param conference
     * @param division 
     * This method creates an SQL query to add a team to the database
     */
    public static void addTeam(String name, String conference, String division)
    {
        Statement stmt = null;
        try
        {
            ConnectionDetails cd = new ConnectionDetails();
            Connection con = cd.getConnection();
            stmt = con.createStatement();
            String sql = "Insert into tblTeam Values(\"" + name + "\",\"" + conference
                    + "\",\"" + division + "\");";
            stmt.executeUpdate(sql);
            con.close();
        }
        catch(MySQLIntegrityConstraintViolationException PKex)
        {
            System.err.println("SQL Error: " + PKex.getMessage());
        }
        catch(SQLException sqlE)
        {
            System.err.println("SQL Error: " + sqlE.getMessage());
        }
    }
    
    /**
     * 
     * @param name
     * @param conference
     * @param division 
     * This method creates an SQL query to edit an existing team in the database
     */
    public static void saveTeam(String name, String conference, String division)
    {
        Statement stmt = null;
        try
        {
            ConnectionDetails cd = new ConnectionDetails();
            Connection con = cd.getConnection();
            stmt = con.createStatement();
            String sql = "Update tblTeam Set conference = \"" + conference 
                    + "\", division = \"" + division + "\" Where name = \"" 
                    + name + "\";";
            stmt.executeUpdate(sql);
            con.close();
        }
        catch(SQLException sqlE)
        {
            System.err.println("SQL Error: " + sqlE.getMessage());
        }
    }
    
    /**
     * 
     * @return ArrayList<Team> all teams from database
     * This method creates an SQL query to get all teams from the database and
     * add them to a Team ArrayList
     */
    public static ArrayList<Team> getTeams()
    {
        ArrayList<Team> list = new ArrayList<>();
        Statement stmt = null;
        ResultSet r = null;
        
        try
        {
            ConnectionDetails cd = new ConnectionDetails();
            Connection con = cd.getConnection();
            
            stmt = con.createStatement();
            String sql = "Select * from tblTeam";
            
            r = stmt.executeQuery(sql);
            
            while(r.next())
            {
                list.add(new Team(r.getString("name"), r.getString("conference"), 
                    r.getString("division")));
            }
            con.close();
        }
        catch(SQLException ex)
        {
            System.out.println(ex.getMessage());
        }
        return list;
    }
    
    /**
     * 
     * @return ArrayList<String> list of team names
     * This method creates an ArrayList of team names from the database to be 
     * added to the combo box for Add Player or Add Coach
     */
    public static ArrayList<String> getTeamNames()
    {
        Connection con = null;
        Statement stmt = null;
        ResultSet r = null;
        
        ArrayList<String> teams = new ArrayList<>();
        
        try
        {
            String url = ConnectionDetails.getURL();
            String username = ConnectionDetails.getUSERNAME();
            String password = ConnectionDetails.getPASSWORD();
            
            Class.forName(ConnectionDetails.getDRIVER());
            con = DriverManager.getConnection(url, username, password);
            
            stmt = con.createStatement();
            String sql = "Select Name from tblTeam";
            r = stmt.executeQuery(sql);
            
            while(r.next())
            {
                teams.add(r.getString("name"));
            }
            con.close();
        }
        catch(SQLException ex)
        {
            System.out.println(ex.getMessage());
        }
        catch(ClassNotFoundException CNFex)
        {
            System.out.println(CNFex.getMessage());
        }
        return teams;
    }
    
    /**
     * 
     * @param name PK of team to be deleted
     * This method creates an SQL query to delete a Team from the database
     */
    public static void deleteTeam(String name)
    {
        Statement stmt = null;
        try
        {
            ConnectionDetails cd = new ConnectionDetails();
            Connection con = cd.getConnection();
            stmt = con.createStatement();
            String sql = "Delete from tblTeam Where name = \"" + name  + "\";";
            stmt.executeUpdate(sql);
            con.close();
            JOptionPane.showMessageDialog(null, "Team " + name 
                    + " has been deleted from the database");
        }
        catch(MySQLIntegrityConstraintViolationException PKex)
        {
            System.err.println("SQL Error: " + PKex.getMessage());
            JOptionPane.showMessageDialog(null, 
                    "Team " + name + " cannot be deleted because it has members "
                            + "associated with it");
        }
        catch(SQLException sqlE)
        {
            System.err.println("SQL Error: " + sqlE.getMessage());
        }
    }
    
    /**
     * 
     * @param ID
     * @param team
     * @param firstName
     * @param lastName
     * @param phone
     * @param email
     * @param yearsExp
     * @param championships
     * @param playoffs
     * @param wLRatio 
     * This method creates an SQL query to add a coach to the database
     */
    public static void addCoach(String ID, String team, String firstName, 
            String lastName, String phone, String email, int yearsExp,
                    int championships, int playoffs, float wLRatio)
    {
        Statement stmt = null;
        try
        {
            ConnectionDetails cd = new ConnectionDetails();
            Connection con = cd.getConnection();
            stmt = con.createStatement();
            String sql = "Insert into tblCoach Values(\"" + ID  + "\",\"" + team
                    + "\",\"" + firstName + "\",\"" + lastName + "\",\"" + phone + "\",\""
                    + email + "\"," + yearsExp + "," + championships + "," + playoffs
                    +  "," + wLRatio + ");";
            stmt.executeUpdate(sql);
            con.close();
        }
        catch(MySQLIntegrityConstraintViolationException PKex)
        {
            System.err.println("SQL Error: " + PKex.getMessage());
        }
        catch(SQLException sqlE)
        {
            System.err.println("SQL Error: " + sqlE.getMessage());
        }
    }
    
    /**
     * 
     * @param ID
     * @param team
     * @param firstName
     * @param lastName
     * @param phone
     * @param email
     * @param yearsExp
     * @param championships
     * @param playoffs
     * @param wLRatio 
     * This method creates an SQL query to edit an existing coach in the database
     */
    public static void saveCoach(String ID, String team, String firstName, 
            String lastName, String phone, String email, int yearsExp,
                    int championships, int playoffs, float wLRatio)
    {
        Statement stmt = null;
        try
        {
            ConnectionDetails cd = new ConnectionDetails();
            Connection con = cd.getConnection();
            stmt = con.createStatement();
            String sql = "Update tblCoach Set team = \"" + team 
                            + "\", firstName = \"" + firstName + "\", lastName = \""
                            + lastName + "\", phone = \"" + phone + "\", email = \""
                            + email + "\", yearsExp = " + yearsExp + ", championships = "
                            + championships + ", playoffs = " + playoffs + ", wLRatio = "
                            + wLRatio + " WHERE ID = \"" + ID + "\";";
            stmt.executeUpdate(sql);
            con.close();
        }
        catch(SQLException sqlE)
        {
            System.err.println("SQL Error: " + sqlE.getMessage());
        }
    }
    
    /**
     * 
     * @return ArrayList<Coach> all coaches from database
     * This method creates an SQL query to get all coaches from the database
     */
    public static ArrayList<Coach> getCoaches()
    {
        ArrayList<Coach> list = new ArrayList<>();
        Statement stmt = null;
        ResultSet r = null;
        
        try
        {
            ConnectionDetails cd = new ConnectionDetails();
            Connection con = cd.getConnection();
            
            stmt = con.createStatement();
            String sql = "Select * from tblCoach";
            
            r = stmt.executeQuery(sql);
            
            list.clear();
            
            while(r.next())
            {
                list.add(new Coach(r.getString("ID"), r.getString("team"), 
                    r.getString("firstName"), r.getString("lastName"),
                    r.getString("phone"), r.getString("email"), r.getInt("yearsExp"),
                    r.getInt("championships"), r.getInt("playoffs"), r.getFloat("wLRatio")));
            }
            con.close();
        }
        catch(SQLException ex)
        {
            System.out.println(ex.getMessage());
        }
        return list;
    }
    
    /**
     * 
     * @param ID PK of coach to be deleted
     * This method creates an SQL query to delete a coach from the database
     */
    public static void deleteCoach(String ID)
    {
        Statement stmt = null;
        try
        {
            ConnectionDetails cd = new ConnectionDetails();
            Connection con = cd.getConnection();
            stmt = con.createStatement();
            String sql = "Delete from tblCoach Where ID = \"" + ID  + "\";";
            stmt.executeUpdate(sql);
            con.close();
            JOptionPane.showMessageDialog(null, "Coach " + ID 
                    + " has been deleted from the database");
        }
        catch(MySQLIntegrityConstraintViolationException PKex)
        {
            System.err.println("SQL Error: " + PKex.getMessage());
            JOptionPane.showMessageDialog(null, "Coach " + ID + " cannot be deleted");
        }
        catch(SQLException sqlE)
        {
            System.err.println("SQL Error: " + sqlE.getMessage());
        }
    }
    
    /**
     * 
     * @param last last name search term
     * @return Coach
     * This method searches through coaches from database too see if there is 
     * a match
     */
    public static Coach searchCoach(String last)
    {
        Coach c = new Coach("", "", "", "", "", "", 0, 0, 0, 0);
        ArrayList<Coach> coaches = getCoaches();
        for(int i=0; i<coaches.size(); i++)
        {
            if(coaches.get(i).getLastName().equalsIgnoreCase(last))
            {
                c = coaches.get(i);
            }
        }
        return c;
    }
}