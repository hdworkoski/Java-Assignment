package DAL;

import Classes.Coach;
import DAL.ConnectionDetails;
import static DAL.ConnectionDetails.getDRIVER;
import static DAL.ConnectionDetails.getPASSWORD;
import static DAL.ConnectionDetails.getURL;
import static DAL.ConnectionDetails.getUSERNAME;
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
 * File: CoachTableModel.java
 * Description: Table Model for the Coach class
 * Date: 10/6/18
 */
public class CoachTableModel extends AbstractTableModel
{
    //declare ArrayList of Coaches and Array of column names
    private ArrayList<Coach> list = new ArrayList<>();
    private String[] columnNames = 
        {"ID", "Team", "First name", "Last name", "Phone", "Email", 
            "Years as Head Coach", "Championships", "Playoffs", "W/L Ratio"};
    
    //constructor
    public CoachTableModel()
    {
        getDataFromDatabase();
    }
    
    //creating abstract methods from AbstractTableModel
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
        Coach c = list.get(row);
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
                return c.getYearsExp();
            case 7:
                return c.getChampionships();
            case 8:
                return c.getPlayoffs();
            case 9:
                return c.getwLRatio();
        }
        return null;
    }
    
    @Override
    public String getColumnName(int col)
    {
        return columnNames[col];
    }
    
    public Coach getRow(int row)
    {
        Coach coach = list.get(row);
        return coach;
    }
    
    //method to get Coach information from the database,
    //put into a Coach object, and add Coach object to ArrayList
    public void getDataFromDatabase()
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
        catch(ClassNotFoundException CNFex)
        {
            System.out.println(CNFex.getMessage());
        }
    }
}