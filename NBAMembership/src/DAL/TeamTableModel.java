package DAL;

import Classes.Player;
import Classes.Team;
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
 */
public class TeamTableModel extends AbstractTableModel
{
    private ArrayList<Team> list = new ArrayList<>();
    private String[] columnNames = 
        {"Name", "Conference", "Division"};
    
    public TeamTableModel()
    {
        getDataFromDatabase();
    }
    
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
        catch(ClassNotFoundException CNFex)
        {
            System.out.println(CNFex.getMessage());
        }
    }
}