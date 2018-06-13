package GUI;

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
import java.sql.SQLException;
import java.sql.Statement;
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
public class AddTeamMenu extends JFrame implements ActionListener
{
    //create GUI objects
    JButton btnSave = new JButton("Save");
    JButton btnCancel = new JButton("Cancel");
    ImageIcon imgLogo = new ImageIcon("NBALogo.png");
    JLabel lblImage = new JLabel();
    JPanel pnlTop = new JPanel();
    JPanel pnlData = new JPanel();
    JPanel pnlRadio = new JPanel();
    JPanel pnlCombo = new JPanel();
    JPanel pnlButtons = new JPanel();
    JPanel pnlBottom = new JPanel();
    Font dataFont = new Font("Arial", Font.BOLD, 14);
    
    JLabel lblName = new JLabel("Name");
    JTextField txfName = new JTextField(5);
    JLabel lblConference = new JLabel("Conference");
    JRadioButton rbtEast = new JRadioButton("Eastern");
    JRadioButton rbtWest = new JRadioButton("Western");
    ButtonGroup btgConference = new ButtonGroup();
    JLabel lblDivision = new JLabel("Division");
    String[] arrEast = {"Atlantic", "Central", "Southeast"};
    String[] arrWest = {"Northwest", "Pacific", "Southwest"};
    JComboBox cmbEast = new JComboBox(arrEast);
    JComboBox cmbWest = new JComboBox(arrWest);
    
    JLabel lblMsg = new JLabel("  ");
    
    Container con = getContentPane();
    TeamMenu tm;
    Team t;
    String title;
    
    public AddTeamMenu(String title, TeamMenu tm)
    {
        this.setTitle(title);
        this.setVisible(true);
        this.setBounds(300, 100, 400, 400);
        this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        
        //set layout, fonts, colors
        JLabel lblHeading = new JLabel(title);
        this.title = title;
        lblHeading.setHorizontalAlignment(JLabel.CENTER);
        con.setLayout(new BorderLayout());
        this.tm = tm;
        pnlTop.setLayout(new BorderLayout());
        pnlTop.setBackground(Color.BLACK);
        pnlData.setLayout(new GridLayout(3, 2, 5, 5));
        con.setBackground(Color.BLACK);
        lblImage.setIcon(imgLogo);
        lblImage.setHorizontalAlignment(JLabel.CENTER);
        lblHeading.setFont(new Font("Verdana", Font.BOLD, 34));
        lblHeading.setForeground(Color.WHITE);
        pnlData.setBackground(Color.BLACK);
        pnlRadio.setBackground(Color.BLACK);
        pnlCombo.setBackground(Color.BLACK);
        pnlButtons.setLayout(new GridLayout(1, 2, 5, 5));
        pnlButtons.setBackground(Color.BLACK);
        pnlBottom.setLayout(new BorderLayout());
        pnlBottom.setBackground(Color.BLACK);
        lblName.setFont(dataFont);
        lblConference.setFont(dataFont);
        lblDivision.setFont(dataFont);
        lblName.setForeground(Color.WHITE);
        lblConference.setForeground(Color.WHITE);
        lblDivision.setForeground(Color.WHITE);
        
        //customize buttons
        rbtEast.setFont(new Font("Arial", Font.BOLD, 14));
        rbtEast.setForeground(Color.WHITE);
        rbtEast.setSelected(true);
        
        rbtWest.setFont(new Font("Arial", Font.BOLD, 14));
        rbtWest.setForeground(Color.WHITE);
        cmbWest.setVisible(false);
        
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
        pnlData.add(lblName);
        pnlData.add(txfName);
        pnlData.add(lblConference);
        btgConference.add(rbtEast);
        btgConference.add(rbtWest);
        pnlRadio.add(rbtEast);
        pnlRadio.add(rbtWest);
        pnlData.add(pnlRadio);
        pnlData.add(lblDivision);
        pnlCombo.add(cmbEast);
        pnlCombo.add(cmbWest);
        pnlData.add(pnlCombo);
        con.add(pnlData, BorderLayout.CENTER);
        con.add(new JLabel("  "), BorderLayout.WEST);
        con.add(new JLabel("  "), BorderLayout.EAST);
        pnlButtons.add(btnSave);
        pnlButtons.add(btnCancel);
        pnlBottom.add(lblMsg, BorderLayout.NORTH);
        pnlBottom.add(pnlButtons, BorderLayout.CENTER);
        con.add(pnlBottom, BorderLayout.SOUTH);
        
        //add action listeners to buttons
        rbtEast.addActionListener(this);
        rbtWest.addActionListener(this);
        btnSave.addActionListener(this);
        btnCancel.addActionListener(this);
    }
    public AddTeamMenu(String title, Team t)
    {
        this.setTitle(title);
        this.setVisible(true);
        this.setBounds(300, 100, 400, 400);
        this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        
        //set layout, fonts, colors
        JLabel lblHeading = new JLabel(title);
        this.title = title;
        this.t = t;
        lblHeading.setHorizontalAlignment(JLabel.CENTER);
        con.setLayout(new BorderLayout());
        pnlTop.setLayout(new BorderLayout());
        pnlTop.setBackground(Color.BLACK);
        pnlData.setLayout(new GridLayout(3, 2, 5, 5));
        con.setBackground(Color.BLACK);
        lblImage.setIcon(imgLogo);
        lblImage.setHorizontalAlignment(JLabel.CENTER);
        lblHeading.setFont(new Font("Verdana", Font.BOLD, 34));
        lblHeading.setForeground(Color.WHITE);
        pnlData.setBackground(Color.BLACK);
        pnlRadio.setBackground(Color.BLACK);
        pnlCombo.setBackground(Color.BLACK);
        pnlButtons.setLayout(new GridLayout(1, 2, 5, 5));
        pnlButtons.setBackground(Color.BLACK);
        pnlBottom.setLayout(new BorderLayout());
        pnlBottom.setBackground(Color.BLACK);
        lblName.setFont(dataFont);
        lblConference.setFont(dataFont);
        lblDivision.setFont(dataFont);
        lblName.setForeground(Color.WHITE);
        lblConference.setForeground(Color.WHITE);
        lblDivision.setForeground(Color.WHITE);
        
        //customize buttons
        rbtEast.setFont(new Font("Arial", Font.BOLD, 14));
        rbtEast.setForeground(Color.WHITE);
        
        rbtWest.setFont(new Font("Arial", Font.BOLD, 14));
        rbtWest.setForeground(Color.WHITE);
        
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
        txfName.setText(t.getName());
        txfName.setEditable(false);
        if(t.getConference().equals("Eastern"))
        {
            rbtEast.setSelected(true);
            cmbEast.setVisible(true);
            cmbWest.setVisible(false);
            cmbEast.setSelectedItem(t.getDivision());
        }
        else
        {
            rbtWest.setSelected(true);
            cmbEast.setVisible(false);
            cmbWest.setVisible(true);
            cmbWest.setSelectedItem(t.getDivision());
        }
        
        //add objects
        pnlTop.add(lblImage, BorderLayout.NORTH);
        pnlTop.add(lblHeading, BorderLayout.CENTER);
        con.add(pnlTop, BorderLayout.NORTH);
        pnlData.add(lblName);
        pnlData.add(txfName);
        pnlData.add(lblConference);
        btgConference.add(rbtEast);
        btgConference.add(rbtWest);
        pnlRadio.add(rbtEast);
        pnlRadio.add(rbtWest);
        pnlData.add(pnlRadio);
        pnlData.add(lblDivision);
        pnlCombo.add(cmbEast);
        pnlCombo.add(cmbWest);
        pnlData.add(pnlCombo);
        con.add(pnlData, BorderLayout.CENTER);
        con.add(new JLabel("  "), BorderLayout.WEST);
        con.add(new JLabel("  "), BorderLayout.EAST);
        pnlButtons.add(btnSave);
        pnlButtons.add(btnCancel);
        pnlBottom.add(lblMsg, BorderLayout.NORTH);
        pnlBottom.add(pnlButtons, BorderLayout.CENTER);
        con.add(pnlBottom, BorderLayout.SOUTH);
        
        //add action listeners to buttons
        rbtEast.addActionListener(this);
        rbtWest.addActionListener(this);
        btnSave.addActionListener(this);
        btnCancel.addActionListener(this);
    }
    
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource() == rbtEast)
        {
            cmbWest.setVisible(false);
            cmbEast.setVisible(true);
            this.repaint();
        }
        else if(ae.getSource() == rbtWest)
        {
            cmbWest.setVisible(true);
            cmbEast.setVisible(false);
            this.repaint();
        }
        else if(ae.getSource() == btnSave)
        {
            Statement stmt = null;
            String name = txfName.getText();
            String conference;
            if(rbtEast.isSelected())
                conference = "East";
            else
                conference = "West";
            String division;
            if(conference == "East")
                division = (String) cmbEast.getSelectedItem();
            else
                division = (String) cmbWest.getSelectedItem();
        
            try
            {
                ConnectionDetails cd = new ConnectionDetails();
                Connection con = cd.getConnection();

                stmt = con.createStatement();
                String msg;
                if(title.equals("Add New Team"))
                {
                    String sql = "Insert into tblTeam Values('" + name  + "','"
                            + conference + "','" + division + "');";
                    stmt.executeUpdate(sql);
                    msg = "Team: " + name + " has been added to the database";
                    btnCancel.setText("Back");
                }
                else
                {
                    String sql = "Update tblTeam Set conference = '" + conference
                            + "', division = '" + division + "' WHERE name = '"
                            + name + "';";
                    stmt.executeUpdate(sql);
                    msg = "Team : " + name + " has been updated in the database";
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
            if(title.equals("Add New Team"))
                tm.setVisible(true);
            this.dispose();
        }
    }
    
    public void resetValues()
    {
        lblMsg.setText("  ");
        txfName.setText("");
        rbtEast.setSelected(true);
        rbtWest.setSelected(true);
        cmbEast.setSelectedIndex(0);
        cmbWest.setSelectedIndex(0);
        this.repaint();
    }
}