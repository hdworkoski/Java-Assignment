/**
 *
 * @author hillarydworkoski
 */
public class Coach extends Member
{
    protected int yearsExp;
    protected int championships;
    protected int playoffs;
    protected double wLRatio;
    
    public Coach
        (String ID, String firstName, String lastName, String phone,
                String email, int yearsExp, int championships, int playoffs,
                    double wLRatio)
        {
            super(ID, firstName, lastName, phone, email);
            this.yearsExp = yearsExp;
            this.championships = championships;
            this.playoffs = playoffs;
            this.wLRatio = wLRatio;
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

    public double getwLRatio()
    {
        return wLRatio;
    }

    public void setwLRatio(double wLRatio)
    {
        this.wLRatio = wLRatio;
    }    
}
