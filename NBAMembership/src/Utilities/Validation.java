package Utilities;


import javax.swing.JOptionPane;

/**
 *
 * @author hillarydworkoski
 */
public class Validation
{
    /**
     * this method is to validate a member ID where it is entered
     * this method returns a boolean to the method to determine whether
     * or not to get the input again
     * @param input (String of user input)
     * @return boolean (Whether input is valid or not)
     */
    public static boolean validateID(String input)
    {
        if(input == null)
        {
            JOptionPane.showMessageDialog(null, "You have selected cancel and must enter an ID");
            return false;
        }
        else if(validateEmpty(input, "an ID"))
            return false;
        else if(input.contains(" "))
        {
            JOptionPane.showMessageDialog(null, "The ID cannot contain spaces");
            return false;
        }
        else if(input.length() < 4)
        {
            JOptionPane.showMessageDialog(null, "The ID must be at least 4 characters");
            return false;
        }
        else
            return true;
    }
    
    /**
     * this method is to validate a member name where it is entered
     * this method returns a boolean to the method to determine whether
     * or not to get the input again
     * @param input (String of user input)
     * @return boolean (Whether input is valid or not)
     */
    public static boolean validateName(String input)
    {
        boolean numFound = false;
        int spaces = 0;
        for(int i=0; i < input.length(); i++)
        {
            if(Character.isDigit(input.charAt(i)))
            {
                numFound = true;
            }
            if(Character.isWhitespace(input.charAt(i)))
            {
                spaces++;
            }
        }
        
        if(validateEmpty(input, "a name"))
            return false;
        else if(input.length() < 2)
        {
            JOptionPane.showMessageDialog(null, "The name must be at least 2 characters");
            return false;
        }
        else if(numFound)
        {
            JOptionPane.showMessageDialog(null, "The name cannot contain numbers");
            return false;
        }
        else if(spaces > 3)
        {
            JOptionPane.showMessageDialog(null, "The name cannot contain more than 3 spaces");
            return false;
        }
        else
            return true;
    }
    
    public static boolean validatePhone(String input)
    {
        boolean notValid = false;
        for(int i=0; i < input.length(); i++)
        {
            //if(!(Character.isDigit(input.charAt(i))) || !(Character.isWhitespace(input.charAt(i))))
            //{
            //    notValid = true;
            //}
        }
        if(validateEmpty(input, "a phone number"))
            return false;
        else if(input.length() > 15)
        {
            JOptionPane.showMessageDialog(null, "The phone number is too long");
            return false;
        }
        else if(input.length() < 10)
        {
            JOptionPane.showMessageDialog(null, "The phone number is too short");
            return false;
        }
        else if(notValid)
        {
            JOptionPane.showMessageDialog(null, "The phone number must be a number");
            return false;
        }
        else
            return true;
    }
    
    public static boolean validateEmail(String input)
    {
        boolean spaceFound = false;
        for(int i=0; i < input.length(); i++)
        {
            if(Character.isWhitespace(input.charAt(i)))
            {
                spaceFound = true;
            }
        }
        if(validateEmpty(input, "an email"))
            return false;
        else if(input.length() > 60)
        {
            JOptionPane.showMessageDialog(null, "The email is too long");
            return false;
        }
        else if(input.length() < 6)
        {
            JOptionPane.showMessageDialog(null, "The email is too short");
            return false;
        }
        else if(spaceFound)
        {
            JOptionPane.showMessageDialog(null, "The email cannot have spaces");
            return false;
        }
        else if(input.indexOf("@") == -1 || input.indexOf(".") == -1)
        {
            JOptionPane.showMessageDialog(null, "You must enter a valid email address");
            return false;
        }
        else
            return true;
    }
    
    public static boolean validateNumber(String input)
    {
        boolean notValid = false;
        for(int i=0; i < input.length(); i++)
        {
            if(!(Character.isDigit(input.charAt(i))))
            {
                notValid = true;
            }
        }
        if(validateEmpty(input, "a player number"))
            return false;
        else if(input.length() > 2)
        {
            JOptionPane.showMessageDialog(null, "The player number cannot be more than 2 digits");
            return false;
        }
        else if(notValid)
        {
            JOptionPane.showMessageDialog(null, "The player number must be a number");
            return false;
        }
        else
            return true;
    }
    
    /**
     * this method is to validate a member name where it is entered
     * this method returns a boolean to the method to determine whether
     * or not to get the input again
     * @param input (String of user input)
     * @return boolean (Whether input is valid or not)
     */
    public static boolean validateCollege(String input)
    {
        if(input == null)
        {
            JOptionPane.showMessageDialog(null, "You have selected cancel and must enter a college");
            return false;
        }
        
        boolean numFound = false;
        int spaces = 0;
        for(int i=0; i < input.length(); i++)
        {
            if(Character.isDigit(input.charAt(i)))
            {
                numFound = true;
            }
            if(Character.isWhitespace(input.charAt(i)))
            {
                spaces++;
            }
        }
        
        if(validateEmpty(input, "a college"))
            return false;
        else if(input.length() < 2)
        {
            JOptionPane.showMessageDialog(null, "The college must be at least 2 characters");
            return false;
        }
        else if(numFound)
        {
            JOptionPane.showMessageDialog(null, "The college cannot contain numbers");
            return false;
        }
        else if(spaces > 4)
        {
            JOptionPane.showMessageDialog(null, "The college cannot contain more than 4 spaces");
            return false;
        }
        else
            return true;
    }
    
    public static boolean validateYear(String input)
    {
        boolean notValid = false;
        for(int i=0; i < input.length(); i++)
        {
            if(!(Character.isDigit(input.charAt(i))))
            {
                notValid = true;
            }
        }
        if(validateEmpty(input, "a year"))
            return false;
        else if(input.length() != 4)
        {
            JOptionPane.showMessageDialog(null, "The year must be 4 digits");
            return false;
        }
        else if(notValid)
        {
            JOptionPane.showMessageDialog(null, "The year must be a number");
            return false;
        }
        else
            return true;
    }
    
    public static boolean validateFloat(String input, String type)
    {
        boolean notValid = false;
        for(int i=0; i < input.length(); i++)
        {
            if(!(Character.isDigit(input.charAt(i))) || input.charAt(i) != '.')
            {
                notValid = true;
            }
        }
        if(validateEmpty(input, type))
            return false;
        else if(input.length() > 5)
        {
            JOptionPane.showMessageDialog(null, "The " + type + " is too long");
            return false;
        }
        else if(input.length() < 2)
        {
            JOptionPane.showMessageDialog(null, "The " + type + " is too short");
            return false;
        }
        else if(notValid)
        {
            JOptionPane.showMessageDialog(null, "The " + type + " must be a number");
            return false;
        }
        else
            return true;
    }
    
    public static boolean validateInt(String input, String type)
    {
        boolean notValid = false;
        for(int i=0; i < input.length(); i++)
        {
            if(!(Character.isDigit(input.charAt(i))))
            {
                notValid = true;
            }
        }
        if(validateEmpty(input, type))
            return false;
        else if(input.length() > 2)
        {
            JOptionPane.showMessageDialog(null, "The " + type + " input is too big");
            return false;
        }
        else if(notValid)
        {
            JOptionPane.showMessageDialog(null, "The " + type + " input must be a number");
            return false;
        }
        else if(Integer.parseInt(input) < 0)
        {
            JOptionPane.showMessageDialog(null, "The " + type + " input cannot be less than 0");
            return false;
        }
        else
            return true;
    }
    
    public static boolean validateEmpty(String input, String type)
    {
        if(input.isEmpty())
        {
            JOptionPane.showMessageDialog(null, "You must enter " + type);
            return true;
        }
        else
            return false;
    }
}