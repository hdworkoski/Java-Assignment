package Classes;

/**
 *
 * @author hillarydworkoski
 */
public class Player extends Member
{
    private String number;
    private String college;
    private boolean rookie; //are they a rookie this year?
    private int startYear; //year they started in NBA
    private String position;
    private String country;
    private double ppg; //points per game
    private double rpg; //rebounds per game
    private int highScore; //highest score ever in one game
    private int salary;
    
    public Player
        (String ID, String team, String firstName, String lastName, String phone,
                String email, String number, String college, boolean rookie,
                    int startYear, String position, String country, double ppg,
                        double rpg, int highScore)
    {
        super(ID, team, firstName, lastName, phone, email);
        type = "Player";
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
        
    public int calcSalary()
    {
        if(rookie)
            salary = 2000000;
        else if(ppg >= 20 && rpg >= 8)
            salary = 15000000;
        else if(ppg >= 20)
            salary = 10000000;
        else if(rpg >= 8)
            salary = 8000000;
        else if(highScore >= 40)
            salary = 13000000;
        else if(startYear <= 2008)
            salary = 1500000;
        else
            salary = 1000000;
        return salary;
    }
    
    public String getType()
    {
        return type;
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
    
    public double getPPG()
    {
        return ppg;
    }
    
    public void setPPG(double ppg)
    {
        this.ppg = ppg;
    }
    
    public double getRPG()
    {
        return rpg;
    }
    
    public void setPRG(double rpg)
    {
        this.rpg = rpg;
    }
    
    public int getHS()
    {
        return highScore;
    }
    
    public void setHS(int highScore)
    {
        this.highScore = highScore;
    }
}
