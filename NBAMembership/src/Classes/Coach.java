package Classes;

import java.io.Serializable;

/**
 *
 * @author hillarydworkoski
 * File: Coach.java
 * Description: Coach class that extends Member class with variables,
 * constructor, get and set methods, calcSalary abstract method
 * Date: 21/06/18
 */
public class Coach extends Member implements Serializable
{
    //declare variables
    private int yearsExp;
    private int championships;
    private int playoffs;
    private float wLRatio;
    private int salary;
    
    //constructor to create Coach object from given variables
    public Coach
        (String ID, String team, String firstName, String lastName, String phone,
                String email, int yearsExp, int championships, int playoffs,
                    float wLRatio)
    {
        super(ID, team, firstName, lastName, phone, email);
        type = "Coach";
        this.yearsExp = yearsExp;
        this.championships = championships;
        this.playoffs = playoffs;
        this.wLRatio = wLRatio;
    }
        
    //method from abstract Member class to calculate Salary based on Coach stats
    public int calcSalary()
    {
        if(championships >= 1)
            salary = 5000000;
        else if(playoffs >= 3)
            salary = 4000000;
        else if(playoffs >= 1)
            salary = 3000000;
        else if(yearsExp >= 5)
            salary = 2000000;
        else if(yearsExp >= 3)
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

    public int getYearsExp()
    {
        return yearsExp;
    }

    public void setYearsExp(int yearsExp)
    {
        this.yearsExp = yearsExp;
    }

    public int getChampionships()
    {
        return championships;
    }

    public void setChampionships(int championships)
    {
        this.championships = championships;
    }

    public int getPlayoffs()
    {
        return playoffs;
    }

    public void setPlayoffs(int playoffs)
    {
        this.playoffs = playoffs;
    }

    public float getwLRatio()
    {
        return wLRatio;
    }

    public void setwLRatio(float wLRatio)
    {
        this.wLRatio = wLRatio;
    }
}