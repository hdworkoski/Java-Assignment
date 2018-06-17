package DAL;

import Classes.Coach;
import Classes.Player;
import Classes.Team;
import com.mysql.jdbc.exceptions.MySQLIntegrityConstraintViolationException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author hillarydworkoski
 */
public class MemberFunctions
{
    
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