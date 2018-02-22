/**
 *
 * @author hillarydworkoski
 */
public class Player extends Member
{
    protected String number;
    protected String college;
    protected boolean rookie; //are they a rookie this year?
    protected int startYear; //year they started in NBA
    protected String position;
    protected String country;
    protected double ppg; //points per game
    protected double rpg; //rebounds per game
    protected int highScore; //highest score ever in one game
    
    public Player
        (String ID, String firstName, String lastName, String phone,
                String email, String number, String college, boolean rookie,
                    int startYear, String position, String country, double ppg,
                        double rpg, int highScore)
        {
            super(ID, firstName, lastName, phone, email);
            this.number = number;
            this.college = college;
            this.rookie = rookie;
            this.startYear = startYear;
            this.position = position;
            this.country = country;
            this.ppg = ppg;
            this.rpg = rpg;
            this.highScore = highScore;
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
