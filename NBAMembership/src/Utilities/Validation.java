package Utilities;

import javax.swing.JOptionPane;

/**
 *
 * @author hillarydworkoski
 * File: Validation.java
 * Description: These methods take user input from GUI classes and validates it
 * and returns true or false if it is valid or not
 * Date: 21/06/18
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
    
    /**
     * 
     * @param input (user input)
     * @return boolean (if input is valid)
     * This method validates a phone number of user input to see if it is empty,
     * a number, and a correct length
     */
    public static boolean validatePhone(String input)
    {
        boolean notValid = false;
        for(int i=0; i < input.length(); i++)
        {
            if(!(Character.isDigit(input.charAt(i))) && !(Character.isWhitespace(input.charAt(i))))
            {
                notValid = true;
            }
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
    
    /**
     * 
     * @param input (user input)
     * @return boolean (if it is valid)
     * This method takes in user input for an email and validates that it is not
     * empty, that it does not contain spaces, that it is not too long or too short,
     * and that it contains '@' and '.'
     */
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
    
    /**
     * 
     * @param input (user input)
     * @return boolean (if it is valid)
     * This method validates user input for Player number to check that it is a
     * number, is not empty and is not more than 2 digits
     */
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
     * this method is to validate a college name where it is entered
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
    
    /**
     * 
     * @param input (user input)
     * @return boolean (if it is valid)
     * This method validates user input for a year to check that it is not empty,
     * that it is only numbers, and that it is 4 digits
     */
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
    
    /**
     * 
     * @param input (user input)
     * @param type (PPG, W/L Ratio, RPG, etc.)
     * @return boolean (if it is valid)
     * This method checks that a float value is not empty, is numbers or '.',
     * and is not too long or too short
     */
    public static boolean validateFloat(String input, String type)
    {
        boolean notValid = false;
        for(int i=0; i < input.length(); i++)
        {
            if(!(Character.isDigit(input.charAt(i))) && input.charAt(i) != '.')
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
    
    /**
     * 
     * @param input (user input)
     * @param type (High Score, Championships, Playoffs, etc)
     * @return boolean (if it is valid)
     * This method validates integer input to make sure it is not empty,
     * it is a number, it is not too long, and that it is a positive number
     */
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
    
    /**
     * 
     * @param input (user input)
     * @param type (type of input, i.e. 'ID')
     * @return boolean if empty or not
     * This method is used in the other methods to determine if the input is empty
     */
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