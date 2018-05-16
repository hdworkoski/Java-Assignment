package GUI;

import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

/**
 *
 * @author hillarydworkoski
 */
public class SortPlayerMenu extends JFrame implements ActionListener
{
    //create GUI objects
    JButton btnOK = new JButton("OK");
    ImageIcon imgLogo = new ImageIcon("NBALogo.png");
    JLabel lblImage = new JLabel();
    JPanel data = new JPanel();
    Font dataFont = new Font("Arial", Font.BOLD, 14);
    
    JLabel lblNumber = new JLabel("Number");
    JLabel lblCollege = new JLabel("College");
    JLabel lblRookie = new JLabel("Rookie?");
    JLabel lblYear = new JLabel("Year Started in NBA");
    JLabel lblPosition = new JLabel("Position");
    JLabel lblCountry = new JLabel("Country of Origin");
    JLabel lblPPG = new JLabel("Average PPG");
    JLabel lblRPG = new JLabel("Average RPG");
    JLabel lblHS = new JLabel("Highest Score in One Game");
    
    Container con = getContentPane();
    JScrollPane scroll = new JScrollPane(data);
    
    public SortPlayerMenu(String title)
    {
        this.setTitle("Sort Players by " + title);
        this.setVisible(true);
        this.setBounds(50, 200, 1300, 450);
        this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        
        //set layout, fonts, colors
        data.setLayout(new FlowLayout());
        data.setBackground(Color.BLACK);
        con.setLayout(new FlowLayout());
        con.setBackground(Color.BLACK);
        lblImage.setIcon(imgLogo);
        JLabel lblHeading = new JLabel("Sort Players by " + title);
        lblHeading.setFont(new Font("Verdana", Font.BOLD, 34));
        lblHeading.setForeground(Color.WHITE);
        lblNumber.setFont(dataFont);
        lblNumber.setForeground(Color.WHITE);
        lblCollege.setFont(dataFont);
        lblCollege.setForeground(Color.WHITE);
        lblRookie.setFont(dataFont);
        lblRookie.setForeground(Color.WHITE);
        lblYear.setFont(dataFont);
        lblYear.setForeground(Color.WHITE);
        lblPosition.setFont(dataFont);
        lblPosition.setForeground(Color.WHITE);
        lblCountry.setFont(dataFont);
        lblCountry.setForeground(Color.WHITE);
        lblPPG.setFont(dataFont);
        lblPPG.setForeground(Color.WHITE);
        lblRPG.setFont(dataFont);
        lblRPG.setForeground(Color.WHITE);
        lblHS.setFont(dataFont);
        lblHS.setForeground(Color.WHITE);
        
        //customize buttons
        btnOK.setFont(new Font("Arial", Font.BOLD, 20));
        btnOK.setForeground(Color.WHITE);
        btnOK.setBackground(Color.DARK_GRAY);
        btnOK.setOpaque(true);
        btnOK.setBorderPainted(false);
        
        con.add(lblImage);
        con.add(lblHeading);
        con.add(data);
        data.add(lblNumber);
        data.add(lblCollege);
        data.add(lblRookie);
        data.add(lblYear);
        data.add(lblPosition);
        data.add(lblCountry);
        data.add(lblPPG);
        data.add(lblRPG);
        data.add(lblHS);
        this.add(scroll);
        con.add(btnOK);
        
        //add action listeners to buttons
        btnOK.addActionListener(this);
    }
    
    public void actionPerformed(ActionEvent ae)
    {
        FrontEnd fe = new FrontEnd();
        this.dispose();
    }
}
