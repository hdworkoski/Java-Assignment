package GUI;

import Classes.Team;
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
    JPanel pnlDataLeft = new JPanel();
    JPanel pnlDataRight = new JPanel();
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
    String[] strPosition = {"Point Guard", "Shooting Guard", "Small Forward", "Power Forward", "Center"};
    JComboBox cmbPosition = new JComboBox(strPosition);
    JLabel lblCountry = new JLabel("Country of Origin");
    String[] strCountry =  {"Argentina", "Australia", "Austria", "Bahamas",
        "Bosnia", "Brazil", "Cameroon", "Canada", "China", "Croatia",
        "Czech Republic", "Congo", "Dominican Republic", "Egypt", "Finland",
        "France", "Georgia",  "Germany", "Greece", "Haiti", "Israel", "Italy",
        "Latvia", "Lithunia", "Mali", "Montenegro", "New Zealand", "Poland",
        "Puerto Rico", "Russia", "Senegal", "Serbia", "Slovenia", "South Sudan",
        "Spain", "Sweden", "Switzerland", "Turkey", "Ukraine", "UK", "USA"};
    JComboBox cmbCountry = new JComboBox(strCountry);
    JLabel lblPPG = new JLabel("  Average Points Per Game");
    JTextField txfPPG = new JTextField(5);
    JLabel lblRPG = new JLabel("Average Rebounds Per Game");
    JTextField txfRPG = new JTextField(5);
    JLabel lblHS = new JLabel("  Highest Score in One Game");
    JTextField txfHS = new JTextField(5);
    JLabel lblMsg = new JLabel("  ");
    
    Container con = getContentPane();
    PlayerMenu pm;
    
    public AddPlayerMenu(String title, PlayerMenu pm)
    {
        this.setTitle(title);
        this.setVisible(true);
        this.setBounds(300, 100, 900, 620);
        this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        
        //set layout, fonts, colors
        JLabel lblHeading = new JLabel(title);
        con.setLayout(new BorderLayout());
        this.pm = pm;
        pnlTop.setLayout(new BorderLayout());
        pnlTop.setBackground(Color.BLACK);
        pnlDataLeft.setLayout(new GridLayout(8, 2, 5, 5));
        pnlDataRight.setLayout(new GridLayout(8, 2, 5, 5));
        con.setBackground(Color.BLACK);
        lblImage.setIcon(imgLogo);
        lblHeading.setFont(new Font("Verdana", Font.BOLD, 34));
        lblHeading.setForeground(Color.WHITE);
        pnlDataLeft.setBackground(Color.BLACK);
        pnlDataRight.setBackground(Color.BLACK);
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
        pnlDataLeft.add(lblNumber);
        pnlDataLeft.add(txfNumber);
        pnlDataRight.add(lblCollege);
        pnlDataRight.add(txfCollege);
        pnlDataLeft.add(lblRookie);
        btgRookie.add(rbtYes);
        btgRookie.add(rbtNo);
        pnlRadio.add(rbtYes);
        pnlRadio.add(rbtNo);
        pnlDataLeft.add(pnlRadio);
        pnlDataRight.add(lblYear);
        pnlDataRight.add(txfYear);
        pnlDataLeft.add(lblPosition);
        pnlDataLeft.add(cmbPosition);
        pnlDataRight.add(lblCountry);
        pnlDataRight.add(cmbCountry);
        pnlDataLeft.add(lblPPG);
        pnlDataLeft.add(txfPPG);
        pnlDataRight.add(lblRPG);
        pnlDataRight.add(txfRPG);
        pnlDataLeft.add(lblHS);
        pnlDataLeft.add(txfHS);
        con.add(pnlDataLeft, BorderLayout.WEST);
        con.add(new JLabel("  "), BorderLayout.CENTER);
        con.add(pnlDataRight, BorderLayout.EAST);
        pnlButtons.add(btnSave);
        pnlButtons.add(btnCancel);
        pnlBottom.add(lblMsg, BorderLayout.NORTH);
        pnlBottom.add(pnlButtons, BorderLayout.CENTER);
        con.add(pnlButtons, BorderLayout.SOUTH);
        
        //add action listeners to buttons
        btnSave.addActionListener(this);
        btnCancel.addActionListener(this);
    }
    
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource() == btnSave)
        {
            //try
            //{
            //    validateID(
            //}
            pm.setVisible(true);
            this.dispose();
        }
        else if(ae.getSource() == btnCancel)
        {
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
}