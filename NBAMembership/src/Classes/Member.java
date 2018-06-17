package Classes;

import java.io.Serializable;

/**
 *
 * @author hillarydworkoski
 * File: Member.java
 * Description: Abstract Member class file with variables, constructor, get and set methods
 * Date: 21/06/18
 */
public abstract class Member implements Serializable
{
    //declare variables
    private String ID;
    private String team;
    private String firstName;
    private String lastName;
    private String phone;
    private String email;
    protected String type;
    
    //constructor
    public Member
        (String ID, String team, String firstName, String lastName, String phone, 
                String email)
    {
        this.ID = ID;
        this.team = team;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.email = email;
    }
        
    //abstract calculate salary method that will be implemented in extended classes
    public abstract int calcSalary();

    //get and set methods
    public String getID()
    {
        return ID;
    }

    public void setID(String ID)
    {
        this.ID = ID;
    }

    public String getFirstName()
    {
        return firstName;
    }

    public void setFirstName(String firstName)
    {
        this.firstName = firstName;
    }

    public String getLastName()
    {
        return lastName;
    }

    public void setLastName(String lastName)
    {
        this.lastName = lastName;
    }

    public String getPhone()
    {
        return phone;
    }

    public void setPhone(String phone)
    {
        this.phone = phone;
    }

    public String getEmail()
    {
        return email;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }
    
    public String getTeam()
    {
        return team;
    }
    
    public void setTeam(String team)
    {
        this.team = team;
    }
    
    //abstract method for getting the type of object (Player, Coach)
    public abstract String getType();
}