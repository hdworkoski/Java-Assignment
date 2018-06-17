package GUI;

import Classes.Player;
import Classes.Team;
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
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

/**
 *
 * @author hillarydworkoski
 */
public class AddPlayerMenu extends JFrame implements ActionListener
{
    //create GUI objects
    JButton btnSave = new JButton("Save");
    JButton btnCancel = new JButton("Cancel");
    ImageIcon imgLogo = new ImageIcon("NBALogo.png");
    JLabel lblImage = new JLabel();
    JPanel pnlTop = new JPanel();
    JPanel pnlData = new JPanel();
    JPanel pnlRadio = new JPanel();
    JPanel pnlButtons = new JPanel();
    JPanel pnlBottom = new JPanel();
    Font dataFont = new Font("Arial", Font.BOLD, 14);
    
    JLabel lblID = new JLabel("  ID");
    JTextField txfID = new JTextField(5);
    JLabel lblTeam = new JLabel("Team");
    ArrayList<String> teams = Team.getTeams();
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
    JLabel lblNumber = new JLabel("  Player Number");
    JTextField txfNumber = new JTextField(4);
    JLabel lblCollege = new JLabel("College");
    JTextField txfCollege = new JTextField(10);
    JLabel lblRookie = new JLabel("  Rookie This Year?");
    JRadioButton rbtYes = new JRadioButton("Yes");
    JRadioButton rbtNo = new JRadioButton("No");
    ButtonGroup btgRookie = new ButtonGroup();
    JLabel lblYear = new JLabel("Year Started in NBA");
    JTextField txfYear = new JTextField(6);
    JLabel lblPosition = new JLabel("  Position");
    String[] arrPosition = {"Point Guard", "Shooting Guard", "Small Forward", "Power Forward", "Center"};
    JComboBox cmbPosition = new JComboBox(arrPosition);
    JLabel lblCountry = new JLabel("Country of Origin");
    String[] arrCountry =  {"Argentina", "Australia", "Austria", "Bahamas",
        "Bosnia", "Brazil", "Cameroon", "Canada", "China", "Croatia",
        "Czech Republic", "Congo", "Dominican Republic", "Egypt", "Finland",
        "France", "Georgia",  "Germany", "Greece", "Haiti", "Israel", "Italy",
        "Latvia", "Lithunia", "Mali", "Montenegro", "New Zealand", "Poland",
        "Puerto Rico", "Russia", "Senegal", "Serbia", "Slovenia", "South Sudan",
        "Spain", "Sweden", "Switzerland", "Turkey", "Ukraine", "UK", "USA"};
    JComboBox cmbCountry = new JComboBox(arrCountry);
    JLabel lblPPG = new JLabel("  Average Points Per Game");
    JTextField txfPPG = new JTextField(5);
    JLabel lblRPG = new JLabel("Average Rebounds Per Game");
    JTextField txfRPG = new JTextField(5);
    JLabel lblHS = new JLabel("  Highest Score in One Game");
    JTextField txfHS = new JTextField(5);
    JLabel lblMsg = new JLabel("  ");
    
    Container con = getContentPane();
    PlayerMenu pm;
    Player p;
    String title;
    
    public AddPlayerMenu(String title, PlayerMenu pm)
    {
        this.setTitle(title);
        this.setVisible(true);
        this.setBounds(300, 100, 900, 620);
        this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        
        //set layout, fonts, colors
        this.title = title;
        JLabel lblHeading = new JLabel(title);
        lblHeading.setHorizontalAlignment(JLabel.CENTER);
        con.setLayout(new BorderLayout());
        this.pm = pm;
        pnlTop.setLayout(new BorderLayout());
        pnlTop.setBackground(Color.BLACK);
        pnlData.setLayout(new GridLayout(8, 4, 5, 5));
        con.setBackground(Color.BLACK);
        lblImage.setIcon(imgLogo);
        lblImage.setHorizontalAlignment(JLabel.CENTER);
        lblHeading.setFont(new Font("Verdana", Font.BOLD, 34));
        lblHeading.setForeground(Color.WHITE);
        pnlData.setBackground(Color.BLACK);
        pnlRadio.setBackground(Color.BLACK);
        pnlRadio.setLayout(new GridLayout(2, 1, 3, 3));
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
        lblNumber.setFont(dataFont);
        lblCollege.setFont(dataFont);
        lblYear.setFont(dataFont);
        lblRookie.setFont(dataFont);
        lblPosition.setFont(dataFont);
        lblCountry.setFont(dataFont);
        lblPPG.setFont(dataFont);
        lblRPG.setFont(dataFont);
        lblHS.setFont(dataFont);
        lblID.setForeground(Color.WHITE);
        lblTeam.setForeground(Color.WHITE);
        lblFirst.setForeground(Color.WHITE);
        lblLast.setForeground(Color.WHITE);
        lblPhone.setForeground(Color.WHITE);
        lblEmail.setForeground(Color.WHITE);
        lblNumber.setForeground(Color.WHITE);
        lblCollege.setForeground(Color.WHITE);
        lblYear.setForeground(Color.WHITE);
        lblRookie.setForeground(Color.WHITE);
        lblPosition.setForeground(Color.WHITE);
        lblCountry.setForeground(Color.WHITE);
        lblPPG.setForeground(Color.WHITE);
        lblRPG.setForeground(Color.WHITE);
        lblHS.setForeground(Color.WHITE);
        lblMsg.setFont(dataFont);
        lblMsg.setForeground(Color.WHITE);
        
        cmbCountry.setSelectedIndex(40);
        
        //customize buttons
        rbtYes.setFont(new Font("Arial", Font.BOLD, 14));
        rbtYes.setForeground(Color.WHITE);
        
        rbtNo.setFont(new Font("Arial", Font.BOLD, 14));
        rbtNo.setForeground(Color.WHITE);
        rbtNo.setSelected(true);
        
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
        pnlData.add(lblNumber);
        pnlData.add(txfNumber);
        pnlData.add(lblCollege);
        pnlData.add(txfCollege);
        pnlData.add(lblRookie);
        btgRookie.add(rbtYes);
        btgRookie.add(rbtNo);
        pnlRadio.add(rbtYes);
        pnlRadio.add(rbtNo);
        pnlData.add(pnlRadio);
        pnlData.add(lblYear);
        pnlData.add(txfYear);
        pnlData.add(lblPosition);
        pnlData.add(cmbPosition);
        pnlData.add(lblCountry);
        pnlData.add(cmbCountry);
        pnlData.add(lblPPG);
        pnlData.add(txfPPG);
        pnlData.add(lblRPG);
        pnlData.add(txfRPG);
        pnlData.add(lblHS);
        pnlData.add(txfHS);
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
    
    public AddPlayerMenu(String title, Player p)
    {
        this.setTitle(title);
        this.setVisible(true);
        this.setBounds(300, 100, 900, 620);
        this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        
        //set layout, fonts, colors
        this.title = title;
        this.p = p;
        JLabel lblHeading = new JLabel(title);
        lblHeading.setHorizontalAlignment(JLabel.CENTER);
        con.setLayout(new BorderLayout());
        pnlTop.setLayout(new BorderLayout());
        pnlTop.setBackground(Color.BLACK);
        pnlData.setLayout(new GridLayout(8, 4, 5, 5));
        con.setBackground(Color.BLACK);
        lblImage.setIcon(imgLogo);
        lblImage.setHorizontalAlignment(JLabel.CENTER);
        lblHeading.setFont(new Font("Verdana", Font.BOLD, 34));
        lblHeading.setForeground(Color.WHITE);
        pnlData.setBackground(Color.BLACK);
        pnlRadio.setBackground(Color.BLACK);
        pnlRadio.setLayout(new GridLayout(2, 1, 3, 3));
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
        lblNumber.setFont(dataFont);
        lblCollege.setFont(dataFont);
        lblYear.setFont(dataFont);
        lblRookie.setFont(dataFont);
        lblPosition.setFont(dataFont);
        lblCountry.setFont(dataFont);
        lblPPG.setFont(dataFont);
        lblRPG.setFont(dataFont);
        lblHS.setFont(dataFont);
        lblID.setForeground(Color.WHITE);
        lblTeam.setForeground(Color.WHITE);
        lblFirst.setForeground(Color.WHITE);
        lblLast.setForeground(Color.WHITE);
        lblPhone.setForeground(Color.WHITE);
        lblEmail.setForeground(Color.WHITE);
        lblNumber.setForeground(Color.WHITE);
        lblCollege.setForeground(Color.WHITE);
        lblYear.setForeground(Color.WHITE);
        lblRookie.setForeground(Color.WHITE);
        lblPosition.setForeground(Color.WHITE);
        lblCountry.setForeground(Color.WHITE);
        lblPPG.setForeground(Color.WHITE);
        lblRPG.setForeground(Color.WHITE);
        lblHS.setForeground(Color.WHITE);
        lblMsg.setFont(dataFont);
        lblMsg.setForeground(Color.WHITE);
        
        //insert values
        txfID.setText(p.getID());
        txfID.setEditable(false);
        cmbTeams.setSelectedItem(p.getTeam());
        txfFirst.setText(p.getFirstName());
        txfLast.setText(p.getLastName());
        txfPhone.setText(p.getPhone());
        txfEmail.setText(p.getEmail());
        txfNumber.setText(p.getNumber());
        txfCollege.setText(p.getCollege());
        txfYear.setText(Integer.toString(p.getStartYear()));
        if(p.isRookie())
            rbtYes.setSelected(true);
        else
            rbtNo.setSelected(true);
        cmbPosition.setSelectedItem(p.getPosition());
        cmbCountry.setSelectedItem(p.getCountry());
        txfPPG.setText(Float.toString(p.getPPG()));
        txfRPG.setText(Float.toString(p.getRPG()));
        txfHS.setText(Integer.toString(p.getHS()));
        
        //customize buttons
        rbtYes.setFont(new Font("Arial", Font.BOLD, 14));
        rbtYes.setForeground(Color.WHITE);
        
        rbtNo.setFont(new Font("Arial", Font.BOLD, 14));
        rbtNo.setForeground(Color.WHITE);
        
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
        pnlData.add(lblNumber);
        pnlData.add(txfNumber);
        pnlData.add(lblCollege);
        pnlData.add(txfCollege);
        pnlData.add(lblRookie);
        btgRookie.add(rbtYes);
        btgRookie.add(rbtNo);
        pnlRadio.add(rbtYes);
        pnlRadio.add(rbtNo);
        pnlData.add(pnlRadio);
        pnlData.add(lblYear);
        pnlData.add(txfYear);
        pnlData.add(lblPosition);
        pnlData.add(cmbPosition);
        pnlData.add(lblCountry);
        pnlData.add(cmbCountry);
        pnlData.add(lblPPG);
        pnlData.add(txfPPG);
        pnlData.add(lblRPG);
        pnlData.add(txfRPG);
        pnlData.add(lblHS);
        pnlData.add(txfHS);
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
    
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource() == btnSave)
        {
            boolean valid = true;
            String team = (String)cmbTeams.getSelectedItem();
            int rookie;
            if(rbtYes.isSelected())
                rookie = 1;
            else
                rookie = 0;
            String position = (String) cmbPosition.getSelectedItem();
            String country = (String) cmbCountry.getSelectedItem();
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
            else if(!Validation.validateNumber(txfNumber.getText()))
                valid = false;
            else if(!Validation.validateCollege(txfCollege.getText()))
                valid = false;
            else if(!Validation.validateYear(txfYear.getText()))
                valid = false;
            else if(!Validation.validateFloat(txfPPG.getText(), "PPG"))
                valid = false;
            else if(!Validation.validateFloat(txfRPG.getText(), "RPG"))
                valid = false;
            else if(!Validation.validateInt(txfHS.getText(), "High Score"))
                valid = false;
            
            if(valid)
            {
                String ID = txfID.getText();
                String firstName = txfFirst.getText();
                String lastName = txfLast.getText();
                String phone = txfPhone.getText();
                String email = txfEmail.getText();
                String number = txfNumber.getText();
                String college = txfCollege.getText();
                int startYear = Integer.parseInt(txfYear.getText());
                float ppg = Float.parseFloat(txfPPG.getText());
                float rpg = Float.parseFloat(txfRPG.getText());
                int highScore = Integer.parseInt(txfHS.getText());

                String msg;
                if(title.equals("Add New Player"))
                {
                    MemberFunctions.addPlayer(ID, team, firstName, lastName, 
                            phone, email, number, college, rookie, startYear, 
                            position, country, ppg, rpg, highScore);
                    msg = "Player: " + ID + " " + firstName + " " + lastName
                            + " has been added to the database for the " + team;
                    btnCancel.setText("Back");
                }
                else
                {
                    MemberFunctions.savePlayer(ID, team, firstName, lastName, 
                            phone, email, number, college, rookie, startYear, 
                            position, country, ppg, rpg, highScore);
                    msg = "Player: " + ID + " has been updated in the database";
                    btnCancel.setText("Close");
                }
                resetValues();
                lblMsg.setText(msg);
                this.repaint();
            }
            
        }
        else if(ae.getSource() == btnCancel)
        {
            if(title.equals("Add New Player"))
                pm.setVisible(true);
            this.dispose();
        }
    }
    
    public String[] fillCombo(ArrayList<String> teams)
    {
        String[] arrTeams = new String[teams.size()];
        for(int i=0; i<teams.size(); i++)
        {
            arrTeams[i] = teams.get(i);
        }
        return arrTeams;
    }
    
    public void resetValues()
    {
        lblMsg.setText("  ");
        txfID.setText("");
        cmbTeams.setSelectedItem(0);
        txfFirst.setText("");
        txfLast.setText("");
        txfPhone.setText("");
        txfEmail.setText("");
        txfNumber.setText("");
        txfCollege.setText("");
        rbtNo.setSelected(true);
        txfYear.setText("");
        cmbPosition.setSelectedItem(0);
        cmbCountry.setSelectedItem(40);
        txfPPG.setText("");
        txfRPG.setText("");
        txfHS.setText("");
        this.repaint();
    }
}