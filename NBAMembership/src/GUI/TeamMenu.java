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
public class TeamMenu extends JFrame implements ActionListener
{
    //create GUI objects
    JLabel lblHeading = new JLabel("Teams");
    JLabel lblLine = new JLabel("                                                         ");
    JButton btnAdd = new JButton("Add a Team");
    JButton btnEdit = new JButton("Edit an Existing Team");
    JButton btnDelete = new JButton("Delete an Existing Team");
    JButton btnSearch = new JButton("Search for an Existing Team");
    JButton btnSortName = new JButton("Sort Teams by Name");
    JButton btnSortRegion = new JButton("Sort Teams by Region");
    ImageIcon imgLogo = new ImageIcon("NBALogo.png");
    JLabel lblImage = new JLabel();
    
    Container con = getContentPane();
    
    public TeamMenu()
    {
        this.setTitle("Teams");
        this.setVisible(true);
        this.setBounds(550, 200, 350, 500);
        this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        
        //set layout, colors, and fonts
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
        
        btnSortName.setFont(new Font("Arial", Font.BOLD, 20));
        btnSortName.setForeground(Color.WHITE);
        btnSortName.setBackground(Color.DARK_GRAY);
        btnSortName.setOpaque(true);
        btnSortName.setBorderPainted(false);
        
        btnSortRegion.setFont(new Font("Arial", Font.BOLD, 20));
        btnSortRegion.setForeground(Color.WHITE);
        btnSortRegion.setBackground(Color.DARK_GRAY);
        btnSortRegion.setOpaque(true);
        btnSortRegion.setBorderPainted(false);
        
        //add objects
        con.add(lblImage);
        con.add(lblHeading);
        con.add(lblLine);
        con.add(btnAdd);
        con.add(btnEdit);
        con.add(btnDelete);
        con.add(btnSearch);
        con.add(btnSortName);
        con.add(btnSortRegion);
        
        //add action listeners to buttons
        btnAdd.addActionListener(this);
        btnEdit.addActionListener(this);
        btnDelete.addActionListener(this);
        btnSearch.addActionListener(this);
        btnSortName.addActionListener(this);
        btnSortRegion.addActionListener(this);
    }
    
    public void actionPerformed(ActionEvent ae)
    {
        //what to do if each button is clicked
        if(ae.getSource() == btnAdd)
        {
            
        }
        else if(ae.getSource() == btnEdit)
        {
            
        }
        else if(ae.getSource() == btnDelete)
        {
            
        }
        else if(ae.getSource() == btnSearch)
        {
            
        }
        else if(ae.getSource() == btnSortName)
        {
            
        }
        else if(ae.getSource() == btnSortRegion)
        {
            
        }
        
        FrontEnd fe = new FrontEnd();
        this.dispose();
    }
}