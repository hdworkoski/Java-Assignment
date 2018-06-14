package Classes;

import DAL.ConnectionDetails;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author hillarydworkoski
 */
public class Team implements Serializable
{
    private String name;
    private String conference;
    private String division;
    
    public Team(String name, String conference, String division)
    {
        this.name = name;
        this.conference = conference;
        this.division = division;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getConference()
    {
        return conference;
    }

    public void setConference(String conference)
    {
        this.conference = conference;
    }

    public String getDivision()
    {
        return division;
    }

    public void setDivision(String division)
    {
        this.division = division;
    }
    
    public static ArrayList<String> getTeams()
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
}