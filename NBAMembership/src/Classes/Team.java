package Classes;

/**
 *
 * @author hillarydworkoski
 */
public class Team
{
    private String name;
    private String conference;
    private String division;
    
    public Team(String name, String conference, String division)
    {
        this.name = name;
        this.conference = conference;
        this.division = division;
    }

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