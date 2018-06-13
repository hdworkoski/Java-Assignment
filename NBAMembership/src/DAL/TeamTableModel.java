package DAL;

import Classes.Team;
import java.net.ConnectException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author hillarydworkoski
 * File: TeamTableModel.java
 * Description: Table Model for Team class
 * Date: 10/6/18
 */
public class TeamTableModel extends AbstractTableModel
{
    //declare ArrayList of Teams and Array of column names
    private ArrayList<Team> list = new ArrayList<>();
    private String[] columnNames = {"Name", "Conference", "Division"};
    
    //constructor
    public TeamTableModel()
    {
        getDataFromDatabase();
    }
    
    //create abstract methods from Abstract Table Model
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
        Team t = list.get(row);
        switch(col)
        {
            case 0:
                return t.getName();
            case 1:
                return t.getConference();
            case 2:
                return t.getDivision();
        }
        return null;
    }
    
    @Override
    public String getColumnName(int col)
    {
        return columnNames[col];
    }
    
    public Team getRow(int row)
    {
        Team team = list.get(row);
        return team;
    }
    
    //method to get data from tblTeam, put data into a Team object, and
    //add Team object to ArrayList
    public void getDataFromDatabase()
    {
        Statement stmt = null;
        ResultSet r = null;
        
        try
        {
            ConnectionDetails cd = new ConnectionDetails();
            Connection con = cd.getConnection();
            
            stmt = con.createStatement();
            String sql = "Select * from tblTeam";
            r = stmt.executeQuery(sql);
            
            list.clear();
            
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
    }
}