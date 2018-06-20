package GUI;

import Classes.Coach;
import DAL.MemberFunctions;
import Utilities.Validation;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author hillarydworkoski
 * File: AddCoachMenu.java
 * Description: This class is for the Add Coach Menu GUI. It contains all the
 * input fields for adding a Coach to the database.
 * Date: 21/6/18
 */
public class AddCoachMenu extends JFrame implements ActionListener
{
    //create GUI objects
    JButton btnSave = new JButton("Save");
    JButton btnCancel = new JButton("Cancel");
    ImageIcon imgLogo = new ImageIcon("NBALogo.png");
    JLabel lblImage = new JLabel();
    JPanel pnlTop = new JPanel();
    JPanel pnlData = new JPanel();
    JPanel pnlButtons = new JPanel();
    JPanel pnlBottom = new JPanel();
    Font dataFont = new Font("Arial", Font.BOLD, 14);
    
    //GUI for input fields
    JLabel lblID = new JLabel("  ID");
    JTextField txfID = new JTextField(5);
    JLabel lblTeam = new JLabel("Team");
    ArrayList<String> teams = MemberFunctions.getTeamNames();
    String[] arrTeams = fillCombo(teams);
    JComboBox cmbTeams = new JComboBox(arrTeams);
    JLabel lblFirst = new JLabel("  First Name");
    JTextField txfFirst = new JTextField(10);
    JLabel lblLast = new JLabel("Last Name");
    JTextField txfLast = new JTextField(10);
    JLabel lblPhone = new JLabel("  Phone Number");
    JTextField txfPhone = new JTextField(10);
    JLabel lblEmail = new JLabel("Email");
    JTextField txfEmail = new JTextField(10);
    JLabel lblYears = new JLabel("  Years Experience");
    JTextField txfYears = new JTextField(4);
    JLabel lblChampionships = new JLabel("Championships");
    JTextField txfChampionships = new JTextField(10);
    JLabel lblPlayoffs = new JLabel("  Playoffs");
    JTextField txfPlayoffs = new JTextField(6);
    JLabel lblWL = new JLabel("Win/Loss Ratio");
    JTextField txfWL = new JTextField(6);
    JLabel lblMsg = new JLabel("  ");
    
    Container con = getContentPane();
    
    //initialize variables
    CoachMenu cm;
    Coach c;
    String title;
    
    //constructor for adding a new Coach
    public AddCoachMenu(String title, CoachMenu cm)
    {
        this.setTitle(title);
        this.setVisible(true);
        this.setBounds(300, 100, 700, 500);
        this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        
        //set layout, fonts, colors
        JLabel lblHeading = new JLabel(title);
        lblHeading.setHorizontalAlignment(JLabel.CENTER);
        con.setLayout(new BorderLayout());
        this.cm = cm;
        this.title = title;
        pnlTop.setLayout(new BorderLayout());
        pnlTop.setBackground(Color.BLACK);
        pnlData.setLayout(new GridLayout(5, 4, 5, 5));
        con.setBackground(Color.BLACK);
        lblImage.setIcon(imgLogo);
        lblImage.setHorizontalAlignment(JLabel.CENTER);
        lblHeading.setFont(new Font("Verdana", Font.BOLD, 34));
        lblHeading.setForeground(Color.WHITE);
        pnlData.setBackground(Color.BLACK);
        pnlButtons.setLayout(new GridLayout(1, 2, 5, 5));
        pnlButtons.setBackground(Color.BLACK);
        pnlBottom.setLayout(new BorderLayout());
        pnlBottom.setBackground(Color.BLACK);
        lblID.setFont(dataFont);
        lblTeam.setFont(dataFont);
        lblFirst.setFont(dataFont);
        lblLast.setFont(dataFont);
        lblPhone.setFont(dataFont);
        lblEmail.setFont(dataFont);
        lblYears.setFont(dataFont);
        lblChampionships.setFont(dataFont);
        lblPlayoffs.setFont(dataFont);
        lblWL.setFont(dataFont);
        lblMsg.setFont(dataFont);
        lblID.setForeground(Color.WHITE);
        lblTeam.setForeground(Color.WHITE);
        lblFirst.setForeground(Color.WHITE);
        lblLast.setForeground(Color.WHITE);
        lblPhone.setForeground(Color.WHITE);
        lblEmail.setForeground(Color.WHITE);
        lblYears.setForeground(Color.WHITE);
        lblChampionships.setForeground(Color.WHITE);
        lblPlayoffs.setForeground(Color.WHITE);
        lblWL.setForeground(Color.WHITE);
        lblMsg.setForeground(Color.WHITE);
        
        //customize buttons
        btnSave.setFont(new Font("Arial", Font.BOLD, 20));
        btnSave.setForeground(Color.WHITE);
        btnSave.setBackground(Color.DARK_GRAY);
        btnSave.setOpaque(true);
        btnSave.setBorderPainted(false);
        
        btnCancel.setFont(new Font("Arial", Font.BOLD, 20));
        btnCancel.setForeground(Color.WHITE);
        btnCancel.setBackground(Color.DARK_GRAY);
        btnCancel.setOpaque(true);
        btnCancel.setBorderPainted(false);
        
        //add objects
        pnlTop.add(lblImage, BorderLayout.NORTH);
        pnlTop.add(lblHeading, BorderLayout.CENTER);
        con.add(pnlTop, BorderLayout.NORTH);
        pnlData.add(lblID);
        pnlData.add(txfID);
        pnlData.add(lblTeam);
        pnlData.add(cmbTeams);
        pnlData.add(lblFirst);
        pnlData.add(txfFirst);
        pnlData.add(lblLast);
        pnlData.add(txfLast);
        pnlData.add(lblPhone);
        pnlData.add(txfPhone);
        pnlData.add(lblEmail);
        pnlData.add(txfEmail);
        pnlData.add(lblYears);
        pnlData.add(txfYears);
        pnlData.add(lblChampionships);
        pnlData.add(txfChampionships);
        pnlData.add(lblPlayoffs);
        pnlData.add(txfPlayoffs);
        pnlData.add(lblWL);
        pnlData.add(txfWL);
        con.add(pnlData, BorderLayout.CENTER);
        pnlButtons.add(btnSave);
        pnlButtons.add(btnCancel);
        pnlBottom.add(lblMsg, BorderLayout.NORTH);
        pnlBottom.add(pnlButtons, BorderLayout.CENTER);
        con.add(pnlBottom, BorderLayout.SOUTH);
        
        //add action listeners to buttons
        btnSave.addActionListener(this);
        btnCancel.addActionListener(this);
    }
    
    //constructor for editing an existing Coach
    public AddCoachMenu(String title, Coach c)
    {
        this.setTitle(title);
        this.setVisible(true);
        this.setBounds(300, 100, 700, 500);
        this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        
        //set layout, fonts, colors
        JLabel lblHeading = new JLabel(title);
        this.title = title;
        this.c = c;
        lblHeading.setHorizontalAlignment(JLabel.CENTER);
        con.setLayout(new BorderLayout());
        pnlTop.setLayout(new BorderLayout());
        pnlTop.setBackground(Color.BLACK);
        pnlData.setLayout(new GridLayout(5, 4, 5, 5));
        con.setBackground(Color.BLACK);
        lblImage.setIcon(imgLogo);
        lblImage.setHorizontalAlignment(JLabel.CENTER);
        lblHeading.setFont(new Font("Verdana", Font.BOLD, 34));
        lblHeading.setForeground(Color.WHITE);
        pnlData.setBackground(Color.BLACK);
        pnlButtons.setLayout(new GridLayout(1, 2, 5, 5));
        pnlButtons.setBackground(Color.BLACK);
        pnlBottom.setLayout(new BorderLayout());
        pnlBottom.setBackground(Color.BLACK);
        lblID.setFont(dataFont);
        lblTeam.setFont(dataFont);
        lblFirst.setFont(dataFont);
        lblLast.setFont(dataFont);
        lblPhone.setFont(dataFont);
        lblEmail.setFont(dataFont);
        lblYears.setFont(dataFont);
        lblChampionships.setFont(dataFont);
        lblPlayoffs.setFont(dataFont);
        lblWL.setFont(dataFont);
        lblMsg.setFont(dataFont);
        lblID.setForeground(Color.WHITE);
        lblTeam.setForeground(Color.WHITE);
        lblFirst.setForeground(Color.WHITE);
        lblLast.setForeground(Color.WHITE);
        lblPhone.setForeground(Color.WHITE);
        lblEmail.setForeground(Color.WHITE);
        lblYears.setForeground(Color.WHITE);
        lblChampionships.setForeground(Color.WHITE);
        lblPlayoffs.setForeground(Color.WHITE);
        lblWL.setForeground(Color.WHITE);
        lblMsg.setForeground(Color.WHITE);
        
        //customize buttons
        btnSave.setFont(new Font("Arial", Font.BOLD, 20));
        btnSave.setForeground(Color.WHITE);
        btnSave.setBackground(Color.DARK_GRAY);
        btnSave.setOpaque(true);
        btnSave.setBorderPainted(false);
        
        btnCancel.setFont(new Font("Arial", Font.BOLD, 20));
        btnCancel.setForeground(Color.WHITE);
        btnCancel.setBackground(Color.DARK_GRAY);
        btnCancel.setOpaque(true);
        btnCancel.setBorderPainted(false);
        
        //insert values from database
        txfID.setText(c.getID());
        txfID.setEditable(false);
        cmbTeams.setSelectedItem(c.getTeam());
        txfFirst.setText(c.getFirstName());
        txfLast.setText(c.getLastName());
        txfPhone.setText(c.getPhone());
        txfEmail.setText(c.getEmail());
        txfYears.setText(Integer.toString(c.getYearsExp()));
        txfChampionships.setText(Integer.toString(c.getChampionships()));
        txfPlayoffs.setText(Integer.toString(c.getPlayoffs()));
        txfWL.setText(Float.toString(c.getwLRatio()));
        
        //add objects
        pnlTop.add(lblImage, BorderLayout.NORTH);
        pnlTop.add(lblHeading, BorderLayout.CENTER);
        con.add(pnlTop, BorderLayout.NORTH);
        pnlData.add(lblID);
        pnlData.add(txfID);
        pnlData.add(lblTeam);
        pnlData.add(cmbTeams);
        pnlData.add(lblFirst);
        pnlData.add(txfFirst);
        pnlData.add(lblLast);
        pnlData.add(txfLast);
        pnlData.add(lblPhone);
        pnlData.add(txfPhone);
        pnlData.add(lblEmail);
        pnlData.add(txfEmail);
        pnlData.add(lblYears);
        pnlData.add(txfYears);
        pnlData.add(lblChampionships);
        pnlData.add(txfChampionships);
        pnlData.add(lblPlayoffs);
        pnlData.add(txfPlayoffs);
        pnlData.add(lblWL);
        pnlData.add(txfWL);
        con.add(pnlData, BorderLayout.CENTER);
        pnlButtons.add(btnSave);
        pnlButtons.add(btnCancel);
        pnlBottom.add(lblMsg, BorderLayout.NORTH);
        pnlBottom.add(pnlButtons, BorderLayout.CENTER);
        con.add(pnlBottom, BorderLayout.SOUTH);
        
        //add action listeners to buttons
        btnSave.addActionListener(this);
        btnCancel.addActionListener(this);
    }
    
    /**
     * 
     * @param ae ActionEvent (when button is clicked)
     * This method runs when either button is clicked
     */
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource() == btnSave)
        {
            //validate all inputs
            String team = (String)cmbTeams.getSelectedItem();
            boolean valid = true;
            if(!Validation.validateID(txfID.getText()))
                valid = false;
            else if(!Validation.validateName(txfFirst.getText()))
                valid = false;
            else if(!Validation.validateName(txfLast.getText()))
                valid = false;
            else if(!Validation.validatePhone(txfPhone.getText()))
                valid = false;
            else if(!Validation.validateEmail(txfEmail.getText()))
                valid = false;
            else if(!Validation.validateInt(txfYears.getText(), "years"))
                valid = false;
            else if(!Validation.validateInt(txfChampionships.getText(), "championships"))
                valid = false;
            else if(!Validation.validateInt(txfPlayoffs.getText(), "playoffs"))
                valid = false;
            else if(!Validation.validateFloat(txfWL.getText(), "win/loss ratio"))
                valid = false;
            
            //if all inputs are valid, get values
            if(valid)
            {
                String ID = txfID.getText();
                String firstName = txfFirst.getText();
                String lastName = txfLast.getText();
                String phone = txfPhone.getText();
                String email = txfEmail.getText();
                int years = Integer.parseInt(txfYears.getText());
                int champ = Integer.parseInt(txfChampionships.getText());
                int playoff = Integer.parseInt(txfPlayoffs.getText());
                float WL = Float.parseFloat(txfWL.getText());

                String msg;
                
                //if adding a new Coach
                if(title.equals("Add New Coach"))
                {
                    MemberFunctions.addCoach(ID, team, firstName, lastName, 
                            phone, email, years, champ, playoff, WL);
                    msg = "Coach: " + ID + " " + firstName + " " + lastName
                            + " has been added to the database for the " + team;
                    btnCancel.setText("Back");
                }
                else //if editing an existing coach
                {
                    MemberFunctions.saveCoach(ID, team, firstName, lastName, phone, 
                            email, years, champ, playoff, WL);
                    msg = "Coach: " + ID + " has been updated in the database";
                    btnCancel.setText("Close");
                }
                resetValues();
                lblMsg.setText(msg);
                this.repaint();
            }
        }
        //if 'Cancel' button is clicked
        else if(ae.getSource() == btnCancel)
        {
            if(title.equals("Add New Coach"))
                cm.setVisible(true);
            this.dispose();
        }
    }
    
    /**
     * 
     * @param teams ArrayList of team names
     * @return String[] Array of teams
     * This method takes in the ArrayList of team names from the database and
     * turns it into an Array to be filled in the combo box
     */
    public String[] fillCombo(ArrayList<String> teams)
    {
        String[] arrTeams = new String[teams.size()];
        for(int i=0; i<teams.size(); i++)
        {
            arrTeams[i] = teams.get(i);
        }
        return arrTeams;
    }
    
    /**
     * This method resets all the input fields in the window
     */
    public void resetValues()
    {
        lblMsg.setText("  ");
        txfID.setText("");
        cmbTeams.setSelectedIndex(0);
        txfFirst.setText("");
        txfLast.setText("");
        txfPhone.setText("");
        txfEmail.setText("");
        txfYears.setText("");
        txfChampionships.setText("");
        txfPlayoffs.setText("");
        txfWL.setText("");
        this.repaint();
    }
}