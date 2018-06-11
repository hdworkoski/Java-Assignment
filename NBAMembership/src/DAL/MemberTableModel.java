package DAL;

import Classes.Coach;
import Classes.Member;
import Classes.Player;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author hillarydworkoski
 * File: MemberTableModel.java
 * Description: Table Model for Member class (including Players and Coaches)
 * Date: 10/6/18
 */
public class MemberTableModel extends AbstractTableModel
{
    //declare ArrayList of Members and Array of column names
    private ArrayList<Member> list = new ArrayList<>();
    private String[] columnNames = 
            {"ID", "Team", "First name", "Last name", "Phone", "Email", "Type"};
    
    //constructor
    public MemberTableModel(String team)
    {
        getData(team);
    }
    
    //create abstract methods from AbstractTableModel class
    public int getRowCount()
    {
        return list.size();
    }
    
    public int getColumnCount()
    {
        return columnNames.length;
    }
    
    public Object getValueAt(int row, int col)
    {
        for(int i=0; i<list.size(); i++)
        {
            //try to create a Coach object at the specified row
            try
            {
                Coach c = (Coach)list.get(row);
                switch(col)
                {
                    case 0:
                        return c.getID();
                    case 1:
                        return c.getTeam();
                    case 2:
                        return c.getFirstName();
                    case 3:
                        return c.getLastName();
                    case 4:
                        return c.getPhone();
                    case 5:
                        return c.getEmail();
                    case 6:
                        return c.getType();
                }
            }
            //if exception thrown, create Player object instead
            catch(ClassCastException cce)
            {
                Player p = (Player)list.get(row);
                switch(col)
                {
                    case 0:
                        return p.getID();
                    case 1:
                        return p.getTeam();
                    case 2:
                        return p.getFirstName();
                    case 3:
                        return p.getLastName();
                    case 4:
                        return p.getPhone();
                    case 5:
                        return p.getEmail();
                    case 6:
                        return p.getType();
                }
            }
        }
        return null;
    }
    
    @Override
    public String getColumnName(int col)
    {
        return columnNames[col];
    }
    
    public Member getRow(int row)
    {
        //try to create Coach object for specified row
        try
        {
            Coach coach = (Coach)list.get(row);
            return coach;
        }
        //if exception thrown, create Player object instead
        catch(ClassCastException cce)
        {
            Player player = (Player)list.get(row);
            return player;
        }
    }
    
    //method to get data from tblCoach and tblPlayer
    //and create Coach and Player objects and add them to ArrayList
    public void getData(String team)
    {
        Connection con = null;
        Statement stmt = null;
        ResultSet r = null;
        
        try
        {
            String url = ConnectionDetails.getURL();
            String username = ConnectionDetails.getUSERNAME();
            String password = ConnectionDetails.getPASSWORD();
            
            Class.forName(ConnectionDetails.getDRIVER());
            con = DriverManager.getConnection(url, username, password);
            
            stmt = con.createStatement();
            String sql = "Select * from tblCoach Where team = '" + team + "'";
            r = stmt.executeQuery(sql);
            
            list.clear();
            
            while(r.next())
            {
                list.add(new Coach(r.getString("ID"), r.getString("team"), 
                    r.getString("firstName"), r.getString("lastName"),
                    r.getString("phone"), r.getString("email"), r.getInt("yearsExp"),
                    r.getInt("championships"), r.getInt("playoffs"), r.getFloat("wLRatio")));
            }
            
            String sql2 = "Select * from tblPlayer Where team = '" + team + "'";
            r = stmt.executeQuery(sql2);
            
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
        catch(ClassNotFoundException CNFex)
        {
            System.out.println(CNFex.getMessage());
        }
    }
}