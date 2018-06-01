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
 */
public class MemberTableModel extends AbstractTableModel
{
    private ArrayList<Member> list = new ArrayList<>();
    private ArrayList<Player> pList = new ArrayList<>();
    private ArrayList<Coach> cList = new ArrayList<>();
    private String[] columnNames = 
        {"ID", "Team", "First name", "Last name", "Phone", "Email", "Type"};
    
    public MemberTableModel(String team)
    {
        getData(team);
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
        for(int i=0; i<list.size(); i++)
        {
            if(list.get(i).getType().equals("Coach"))
            {
                Coach c = cList.get(row);
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
            else
            {
                Player p = pList.get(row + cList.size());
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
    
    public Player getRow(int row)
    {
        Player player = pList.get(row);
        return player;
    }
    
    public void getData(String team)
    {
        PlayerTableModel pTable = new PlayerTableModel();
        pList = pTable.getList(team);
        CoachTableModel cTable = new CoachTableModel();
        cList = cTable.getList(team);
        list.addAll(cList);
        list.addAll(pList);
    }
}