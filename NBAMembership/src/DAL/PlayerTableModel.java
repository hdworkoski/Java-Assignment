package DAL;

import Classes.Player;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author hillarydworkoski
 * File: PlayerTableModel.java
 * Description: Table Model for the Player class
 * Date: 21/6/18
 */
public class PlayerTableModel extends AbstractTableModel
{
    //declare ArrayList of Players and Array of column names
    private ArrayList<Player> list = new ArrayList<>();
    private String[] columnNames = 
        {"ID", "Team", "First name", "Last name", "Phone", "Email", 
            "Number", "College", "Rookie?", "Start Year", "Position", "Country", 
                "PPG", "RPG", "High Score"};
    
    //constructor
    public PlayerTableModel()
    {
        getDataFromDatabase();
    }
    
    //create abstract methods from AbstractTableModel
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
        Player p = list.get(row);
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
                return p.getNumber();
            case 7:
                return p.getCollege();
            case 8:
                return p.isRookie();
            case 9:
                return p.getStartYear();
            case 10:
                return p.getPosition();
            case 11:
                return p.getCountry();
            case 12:
                return p.getPPG();
            case 13:
                return p.getRPG();
            case 14:
                return p.getHS();
        }
        return null;
    }
    
    @Override
    public String getColumnName(int col)
    {
        return columnNames[col];
    }
    
    public Player getRow(int row)
    {
        Player player = list.get(row);
        return player;
    }
    
    //method to get Player information from the database,
    //put into a Player object, and add Player object to ArrayList
    public void getDataFromDatabase()
    {
        list = MemberFunctions.getPlayers();
    }
}