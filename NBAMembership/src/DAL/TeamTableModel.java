package DAL;

import Classes.Team;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author hillarydworkoski
 * File: TeamTableModel.java
 * Description: Table Model for Team class
 * Date: 21/6/18
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
        list = MemberFunctions.getTeams();
    }
}