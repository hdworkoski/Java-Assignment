package Classes;

import java.io.Serializable;

/**
 *
 * @author hillarydworkoski
 * File: Player.java
 * Description: Player class that extends abstract Member class and includes
 * variables, constructor, get and set methods
 * Date: 21/06/18
 */
public class Player extends Member implements Serializable
{
    //declare variables
    private String number;
    private String college;
    private boolean rookie; //are they a rookie this year?
    private int startYear; //year they started in NBA
    private String position;
    private String country;
    private float ppg; //points per game
    private float rpg; //rebounds per game
    private int highScore; //highest score ever in one game
    private int salary;
    
    //constructor to create Player object with designated variables
    public Player
        (String ID, String team, String firstName, String lastName, String phone,
                String email, String number, String college, boolean rookie,
                    int startYear, String position, String country, float ppg,
                        float rpg, int highScore)
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
        
    //method from abstract Member class to calculate Player salary based on stats
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
    
    //get and set methods
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
    
    public float getPPG()
    {
        return ppg;
    }
    
    public void setPPG(float ppg)
    {
        this.ppg = ppg;
    }
    
    public float getRPG()
    {
        return rpg;
    }
    
    public void setPRG(float rpg)
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