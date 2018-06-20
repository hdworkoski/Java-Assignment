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
 * File: CoachMenu.java
 * Description: This class is for the GUI for the Coach Menu
 * Date: 21/6/18
 */
public class CoachMenu extends JFrame implements ActionListener
{
    //create objects
    JLabel lblHeading = new JLabel("Coaches");
    JLabel lblLine = new JLabel("                                                         ");
    JLabel lblLine2 = new JLabel("                                                         ");
    JButton btnAdd = new JButton("Add a Coach");
    JButton btnView = new JButton("View Coaches");
    JButton btnSearch = new JButton("Search for a Coach");
    JButton btnBack = new JButton("Back");
    ImageIcon imgLogo = new ImageIcon("NBALogo.png");
    JLabel lblImage = new JLabel();
    
    Container con = getContentPane();
    
    //initialize variable
    FrontEnd fe;
    
    public CoachMenu(FrontEnd fe)
    {
        this.setTitle("Coaches");
        this.setVisible(true);
        this.setBounds(550, 200, 320, 500);
        this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        this.fe = fe;
        
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
        
        btnView.setFont(new Font("Arial", Font.BOLD, 20));
        btnView.setForeground(Color.WHITE);
        btnView.setBackground(Color.DARK_GRAY);
        btnView.setOpaque(true);
        btnView.setBorderPainted(false);
        
        btnSearch.setFont(new Font("Arial", Font.BOLD, 20));
        btnSearch.setForeground(Color.WHITE);
        btnSearch.setBackground(Color.DARK_GRAY);
        btnSearch.setOpaque(true);
        btnSearch.setBorderPainted(false);
        
        btnBack.setFont(new Font("Arial", Font.BOLD, 20));
        btnBack.setForeground(Color.WHITE);
        btnBack.setBackground(Color.DARK_GRAY);
        btnBack.setOpaque(true);
        btnBack.setBorderPainted(false);
        
        //add objects
        con.add(lblImage);
        con.add(lblHeading);
        con.add(lblLine);
        con.add(btnAdd);
        con.add(btnView);
        con.add(btnSearch);
        con.add(lblLine2);
        con.add(btnBack);
        
        //add action listeners to buttons
        btnAdd.addActionListener(this);
        btnView.addActionListener(this);
        btnSearch.addActionListener(this);
        btnBack.addActionListener(this);
    }
    
    /**
     * 
     * @param ae ActionEvent when a button is clicked
     * This method performs when a button is clicked in the window
     */
    public void actionPerformed(ActionEvent ae)
    {
        //what to do if each button is clicked
        if(ae.getSource() == btnAdd)
        {
            AddCoachMenu acm = new AddCoachMenu("Add New Coach", this);
            this.setVisible(false);
        }
        else if(ae.getSource() == btnView)
        {
            CoachTableMenu acm2 = new CoachTableMenu(this);
            this.setVisible(false);
        }
        else if(ae.getSource() == btnSearch)
        {
            SearchCoach sc = new SearchCoach(this);
            this.setVisible(false);
        }
        else
        {
            fe.setVisible(true);
            this.dispose();
        }
    }
}