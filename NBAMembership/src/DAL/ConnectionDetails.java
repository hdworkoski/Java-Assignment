package DAL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author hillarydworkoski
 * File: ConnectionDetails.java
 * Description: ConnnectionDetails class to save information for connecting
 * to the database and create a connection method
 * Date: 21/06/18
 */
public class ConnectionDetails
{
    //declare final variables
    private static final String USERNAME = "root";
    private static final String PASSWORD = "root";
    private static final String DRIVER = "com.mysql.jdbc.Driver";
    private static final String URL = "jdbc:mysql://localhost:8889/NBA?autoReconnect=true";

    //get methods
    public static String getUSERNAME()
    {
        return USERNAME;
    }

    public static String getPASSWORD()
    {
        return PASSWORD;
    }

    public static String getDRIVER()
    {
        return DRIVER;
    }

    public static String getURL()
    {
        return URL;
    }
    
    //get connection method that is used in many other functions to connect to db
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
            System.out.println("SQL Error: " + SQLex.getMessage());
        }
        catch(ClassNotFoundException CNFex)
        {
            System.out.println("Error: " + CNFex.getMessage());
        }
        return con;
    }
}