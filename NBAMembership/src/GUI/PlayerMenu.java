package GUI;

import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 *
 * @author hillarydworkoski
 */
public class PlayerMenu extends JFrame implements ActionListener
{
    //create GUI objects
    JLabel lblHeading = new JLabel("Players");
    JLabel lblLine = new JLabel("                                                         ");
    JButton btnAdd = new JButton("Add a Player");
    JButton btnEdit = new JButton("Edit an Existing Player");
    JButton btnDelete = new JButton("Delete an Existing Player");
    JButton btnSearch = new JButton("Search for an Existing Player");
    JButton btnSortLast = new JButton("Sort Players by Last Name");
    JButton btnSortTeam = new JButton("Sort Players by Team");
    ImageIcon imgLogo = new ImageIcon("NBALogo.png");
    JLabel lblImage = new JLabel();
    
    Container con = getContentPane();
    
    public PlayerMenu()
    {
        this.setTitle("Players");
        this.setVisible(true);
        this.setBounds(550, 200, 350, 500);
        this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        
        //set layout, fonts, colors
        con.setLayout(new FlowLayout());
        con.setBackground(Color.BLACK);
        lblImage.setIcon(imgLogo);
        lblHeading.setFont(new Font("Verdana", Font.BOLD, 34));
        lblHeading.setForeground(Color.WHITE);
        
        //customize buttons
        btnAdd.setFont(new Font("Arial", Font.BOLD, 20));
        btnAdd.setForeground(Color.WHITE);
        btnAdd.setBackground(Color.DARK_GRAY);
        btnAdd.setOpaque(true);
        btnAdd.setBorderPainted(false);
        
        btnEdit.setFont(new Font("Arial", Font.BOLD, 20));
        btnEdit.setForeground(Color.WHITE);
        btnEdit.setBackground(Color.DARK_GRAY);
        btnEdit.setOpaque(true);
        btnEdit.setBorderPainted(false);
        
        btnDelete.setFont(new Font("Arial", Font.BOLD, 20));
        btnDelete.setForeground(Color.WHITE);
        btnDelete.setBackground(Color.DARK_GRAY);
        btnDelete.setOpaque(true);
        btnDelete.setBorderPainted(false);
        
        btnSearch.setFont(new Font("Arial", Font.BOLD, 20));
        btnSearch.setForeground(Color.WHITE);
        btnSearch.setBackground(Color.DARK_GRAY);
        btnSearch.setOpaque(true);
        btnSearch.setBorderPainted(false);
        
        btnSortLast.setFont(new Font("Arial", Font.BOLD, 20));
        btnSortLast.setForeground(Color.WHITE);
        btnSortLast.setBackground(Color.DARK_GRAY);
        btnSortLast.setOpaque(true);
        btnSortLast.setBorderPainted(false);
        
        btnSortTeam.setFont(new Font("Arial", Font.BOLD, 20));
        btnSortTeam.setForeground(Color.WHITE);
        btnSortTeam.setBackground(Color.DARK_GRAY);
        btnSortTeam.setOpaque(true);
        btnSortTeam.setBorderPainted(false);
        
        //add objects
        con.add(lblImage);
        con.add(lblHeading);
        con.add(lblLine);
        con.add(btnAdd);
        con.add(btnEdit);
        con.add(btnDelete);
        con.add(btnSearch);
        con.add(btnSortLast);
        con.add(btnSortTeam);
        
        //add action listeners to buttons
        btnAdd.addActionListener(this);
        btnEdit.addActionListener(this);
        btnDelete.addActionListener(this);
        btnSearch.addActionListener(this);
        btnSortLast.addActionListener(this);
        btnSortTeam.addActionListener(this);
    }
    
    public void actionPerformed(ActionEvent ae)
    {
        //what to do if each button is clicked
        if(ae.getSource() == btnAdd)
        {
            AddPlayerMenu apm1 = new AddPlayerMenu("Add New Player");
            this.dispose();
        }
        else if(ae.getSource() == btnEdit)
        {
            AddPlayerMenu apm2 = new AddPlayerMenu("Edit Player Details");
            this.dispose();
        }
        else if(ae.getSource() == btnDelete)
        {
            FrontEnd fe = new FrontEnd();
            this.dispose();
        }
        else if(ae.getSource() == btnSearch)
        {
            FrontEnd fe = new FrontEnd();
            this.dispose();
        }
        else if(ae.getSource() == btnSortLast)
        {
            SortPlayerMenu spm = new SortPlayerMenu("Last Name");
            this.dispose();
        }
        else if(ae.getSource() == btnSortTeam)
        {
            SortPlayerMenu spm2 = new SortPlayerMenu("Team");
            this.dispose();
        }
    }
}