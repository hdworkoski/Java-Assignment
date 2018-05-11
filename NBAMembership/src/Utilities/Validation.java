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
        else if(input.isEmpty())
        {
            JOptionPane.showMessageDialog(null, "You must enter an ID");
            return false;
        }  
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
        if(input == null)
        {
            JOptionPane.showMessageDialog(null, "You have selected cancel and must enter a name");
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
        
        if(input.isEmpty())
        {
            JOptionPane.showMessageDialog(null, "You must enter a name");
            return false;
        }  
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
}
