package GUI;

import Classes.Coach;
import Classes.Team;
import DAL.ConnectionDetails;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
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
 */
public class AddCoachMenu extends JFrame implements ActionListener
{
    //create GUI objects
    JButton btnSave = new JButton("Save");
    JButton btnCancel = new JButton("Cancel");
    ImageIcon imgLogo = new ImageIcon("NBALogo.png");
    JLabel lblImage = new JLabel();
    JPanel pnlTop = new JPanel();
    JPanel pnlDataLeft = new JPanel();
    JPanel pnlDataRight = new JPanel();
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
    CoachMenu cm;
    Coach c;
    String title;
    
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
        pnlDataLeft.setLayout(new GridLayout(5, 2, 5, 5));
        pnlDataRight.setLayout(new GridLayout(5, 2, 5, 5));
        con.setBackground(Color.BLACK);
        lblImage.setIcon(imgLogo);
        lblImage.setHorizontalAlignment(JLabel.CENTER);
        lblHeading.setFont(new Font("Verdana", Font.BOLD, 34));
        lblHeading.setForeground(Color.WHITE);
        pnlDataLeft.setBackground(Color.BLACK);
        pnlDataRight.setBackground(Color.BLACK);
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
        pnlDataLeft.add(lblID);
        pnlDataLeft.add(txfID);
        pnlDataRight.add(lblTeam);
        pnlDataRight.add(cmbTeams);
        pnlDataLeft.add(lblFirst);
        pnlDataLeft.add(txfFirst);
        pnlDataRight.add(lblLast);
        pnlDataRight.add(txfLast);
        pnlDataLeft.add(lblPhone);
        pnlDataLeft.add(txfPhone);
        pnlDataRight.add(lblEmail);
        pnlDataRight.add(txfEmail);
        pnlDataLeft.add(lblYears);
        pnlDataLeft.add(txfYears);
        pnlDataRight.add(lblChampionships);
        pnlDataRight.add(txfChampionships);
        pnlDataLeft.add(lblPlayoffs);
        pnlDataLeft.add(txfPlayoffs);
        pnlDataRight.add(lblWL);
        pnlDataRight.add(txfWL);
        con.add(pnlDataLeft, BorderLayout.WEST);
        con.add(new JLabel("  "), BorderLayout.CENTER);
        con.add(pnlDataRight, BorderLayout.EAST);
        pnlButtons.add(btnSave);
        pnlButtons.add(btnCancel);
        pnlBottom.add(lblMsg, BorderLayout.NORTH);
        pnlBottom.add(pnlButtons, BorderLayout.CENTER);
        con.add(pnlBottom, BorderLayout.SOUTH);
        
        //add action listeners to buttons
        btnSave.addActionListener(this);
        btnCancel.addActionListener(this);
    }
    
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
        pnlDataLeft.setLayout(new GridLayout(5, 2, 5, 5));
        pnlDataRight.setLayout(new GridLayout(5, 2, 5, 5));
        con.setBackground(Color.BLACK);
        lblImage.setIcon(imgLogo);
        lblImage.setHorizontalAlignment(JLabel.CENTER);
        lblHeading.setFont(new Font("Verdana", Font.BOLD, 34));
        lblHeading.setForeground(Color.WHITE);
        pnlDataLeft.setBackground(Color.BLACK);
        pnlDataRight.setBackground(Color.BLACK);
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
        
        //insert values
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
        pnlDataLeft.add(lblID);
        pnlDataLeft.add(txfID);
        pnlDataRight.add(lblTeam);
        pnlDataRight.add(cmbTeams);
        pnlDataLeft.add(lblFirst);
        pnlDataLeft.add(txfFirst);
        pnlDataRight.add(lblLast);
        pnlDataRight.add(txfLast);
        pnlDataLeft.add(lblPhone);
        pnlDataLeft.add(txfPhone);
        pnlDataRight.add(lblEmail);
        pnlDataRight.add(txfEmail);
        pnlDataLeft.add(lblYears);
        pnlDataLeft.add(txfYears);
        pnlDataRight.add(lblChampionships);
        pnlDataRight.add(txfChampionships);
        pnlDataLeft.add(lblPlayoffs);
        pnlDataLeft.add(txfPlayoffs);
        pnlDataRight.add(lblWL);
        pnlDataRight.add(txfWL);
        con.add(pnlDataLeft, BorderLayout.WEST);
        con.add(new JLabel("  "), BorderLayout.CENTER);
        con.add(pnlDataRight, BorderLayout.EAST);
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
            Statement stmt = null;
            String ID = txfID.getText();
            String team = (String)cmbTeams.getSelectedItem();
            String firstName = txfFirst.getText();
            String lastName = txfLast.getText();
            String phone = txfPhone.getText();
            String email = txfEmail.getText();
            int years = Integer.parseInt(txfYears.getText());
            int champ = Integer.parseInt(txfChampionships.getText());
            int playoff = Integer.parseInt(txfPlayoffs.getText());
            float WL = Float.parseFloat(txfWL.getText());
        
            try
            {
                ConnectionDetails cd = new ConnectionDetails();
                Connection con = cd.getConnection();

                stmt = con.createStatement();
                String msg;
                if(title.equals("Add New Coach"))
                {
                    String sql = "Insert into tblCoach Values('" + ID  + "','" + team
                            + "','" + firstName + "','" + lastName + "','" + phone + "','"
                            + email + "'," + years + "," + champ + "," + playoff
                            +  "," + WL + ");";
                    stmt.executeUpdate(sql);
                    msg = "Coach: " + ID + " " + firstName + " " + lastName
                            + " has been added to the database for the " + team;
                    btnCancel.setText("Back");
                }
                else
                {
                    String sql = "Update tblCoach Set team = '" + team 
                            + "', firstName = '" + firstName + "', lastName = '"
                            + lastName + "', phone = '" + phone + "', email = '"
                            + email + "', yearsExp = " + years + ", championships = "
                            + champ + ", playoffs = " + playoff + ", wLRatio = "
                            + WL + " WHERE ID = '" + ID + "';";
                    stmt.executeUpdate(sql);
                    msg = "Coach: " + ID + " has been updated in the database";
                    btnCancel.setText("Close");
                }
                resetValues();
                lblMsg.setText(msg);
                this.repaint();
                con.close();
            }
            catch(SQLException sqlE)
            {
                System.err.println("SQL Error: " + sqlE);
            }
        }
        else if(ae.getSource() == btnCancel)
        {
            if(title.equals("Add New Coach"))
                cm.setVisible(true);
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
        txfYears.setText("");
        txfChampionships.setText("");
        txfPlayoffs.setText("");
        txfWL.setText("");
        this.repaint();
    }
}