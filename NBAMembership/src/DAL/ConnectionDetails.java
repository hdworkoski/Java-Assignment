package DAL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author hillarydworkoski
 */
public class ConnectionDetails
{
    private static final String USERNAME = "root";
    private static final String PASSWORD = "root";
    private static final String DRIVER = "com.mysql.jdbc.Driver";
    private static final String URL = "jdbc:mysql://localhost:8889/NBA?autoReconnect=true";

    public static String getUSERNAME() {
        return USERNAME;
    }

    public static String getPASSWORD() {
        return PASSWORD;
    }

    public static String getDRIVER() {
        return DRIVER;
    }

    public static String getURL() {
        return URL;
    }
    
    public static Connection getConnection()
    {
        Connection con = null;
        
        String url = getURL();
        String username = getUSERNAME();
        String password = getPASSWORD();
        try
        {
            Class.forName(getDRIVER());
            con = DriverManager.getConnection(url, username, password);
        }
        catch(SQLException SQLex)
        {
            System.out.println(SQLex.getMessage());
        }
        catch(ClassNotFoundException CNFex)
        {
            System.out.println(CNFex.getMessage());
        }
        return con;
    }
}