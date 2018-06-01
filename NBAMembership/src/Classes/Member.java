package Classes;

/**
 *
 * @author hillarydworkoski
 */
public abstract class Member
{
    private String ID;
    private String team;
    private String firstName;
    private String lastName;
    private String phone;
    private String email;
    protected String type;
    
    public Member
        (String ID, String team, String firstName, String lastName, String phone, String email)
    {
        this.ID = ID;
        this.team = team;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.email = email;
    }
        
    public abstract void calcSalary();

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
    
    public abstract String getType();
}