package Classes;

import java.io.Serializable;

/**
 *
 * @author hillarydworkoski
 * File: Team.java
 * Description: Team Class file including Team variables, constructor, get and set methods
 * Date: 21/06/18
 */
public class Team implements Serializable
{
    //declare variables
    private String name;
    private String conference;
    private String division;
    
    //constructor to create Team object with given variables
    public Team(String name, String conference, String division)
    {
        this.name = name;
        this.conference = conference;
        this.division = division;
    }

    //get and set methods for Team variables
    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getConference()
    {
        return conference;
    }

    public void setConference(String conference)
    {
        this.conference = conference;
    }

    public String getDivision()
    {
        return division;
    }

    public void setDivision(String division)
    {
        this.division = division;
    }
}