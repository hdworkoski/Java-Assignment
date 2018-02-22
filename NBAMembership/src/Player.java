/**
 *
 * @author hillarydworkoski
 */
public class Player extends Member
{
    protected String number;
    protected String college;
    protected boolean rookie;
    protected int startYear;
    protected String position;
    protected String country;
    
    public Player
        (String ID, String firstName, String lastName, String phone,
                String email, String number, String college, boolean rookie,
                    int startYear, String position, String country)
        {
            super(ID, firstName, lastName, phone, email);
            this.number = number;
            this.college = college;
            this.rookie = rookie;
            this.startYear = startYear;
            this.position = position;
            this.country = country;
        }

    public String getNumber()
    {
        return number;
    }

    public void setNumber(String number)
    {
        this.number = number;
    }

    public String getCollege()
    {
        return college;
    }

    public void setCollege(String college)
    {
        this.college = college;
    }

    public boolean isRookie()
    {
        return rookie;
    }

    public void setRookie(boolean rookie)
    {
        this.rookie = rookie;
    }

    public int getStartYear()
    {
        return startYear;
    }

    public void setStartYear(int startYear)
    {
        this.startYear = startYear;
    }

    public String getPosition()
    {
        return position;
    }

    public void setPosition(String position)
    {
        this.position = position;
    }

    public String getCountry()
    {
        return country;
    }

    public void setCountry(String country)
    {
        this.country = country;
    }      
}
