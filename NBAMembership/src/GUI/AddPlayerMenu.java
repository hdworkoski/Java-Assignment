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
    JPanel data = new JPanel();
    Font dataFont = new Font("Arial", Font.BOLD, 14);
    
    JLabel lblNumber = new JLabel("Player Number");
    JTextField txfNumber = new JTextField(4);
    JLabel lblCollege = new JLabel("College");
    JTextField txfCollege = new JTextField(10);
    JLabel lblRookie = new JLabel("Rookie This Year?");
    
    JLabel lblYear = new JLabel("Year Started in NBA");
    JTextField txfYear = new JTextField(6);
    JLabel lblPosition = new JLabel("Position");
    
    JLabel lblCountry = new JLabel("Country of Origin");
    
    JLabel lblPPG = new JLabel("Average Points Per Game");
    JTextField txfPPG = new JTextField(5);
    JLabel lblRPG = new JLabel("Average Rebounds Per Game");
    JTextField txfRPG = new JTextField(5);
    JLabel lblHS = new JLabel("Highest Score in One Game");
    JTextField txfHS = new JTextField(5);
    
    Container con = getContentPane();
    
    public AddPlayerMenu(String title)
    {
        this.setTitle(title);
        this.setVisible(true);
        this.setBounds(550, 200, 450, 600);
        this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        
        //set layout, fonts, colors
        JLabel lblHeading = new JLabel(title);
        con.setLayout(new FlowLayout());
        data.setLayout(new GridLayout(9, 2, 5, 5));
        con.setBackground(Color.BLACK);
        lblImage.setIcon(imgLogo);
        lblHeading.setFont(new Font("Verdana", Font.BOLD, 34));
        lblHeading.setForeground(Color.WHITE);
        data.setBackground(Color.BLACK);
        lblNumber.setFont(dataFont);
        lblCollege.setFont(dataFont);
        lblYear.setFont(dataFont);
        lblRookie.setFont(dataFont);
        lblPosition.setFont(dataFont);
        lblCountry.setFont(dataFont);
        lblPPG.setFont(dataFont);
        lblRPG.setFont(dataFont);
        lblHS.setFont(dataFont);
        lblNumber.setForeground(Color.WHITE);
        lblCollege.setForeground(Color.WHITE);
        lblYear.setForeground(Color.WHITE);
        lblRookie.setForeground(Color.WHITE);
        lblPosition.setForeground(Color.WHITE);
        lblCountry.setForeground(Color.WHITE);
        lblPPG.setForeground(Color.WHITE);
        lblRPG.setForeground(Color.WHITE);
        lblHS.setForeground(Color.WHITE);
        
        
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
        con.add(lblImage);
        con.add(lblHeading);
        data.add(lblNumber);
        data.add(txfNumber);
        data.add(lblCollege);
        data.add(txfCollege);
        data.add(lblRookie);
        data.add(new JLabel(""));
        data.add(lblYear);
        data.add(txfYear);
        data.add(lblPosition);
        data.add(new JLabel(""));
        data.add(lblCountry);
        data.add(new JLabel(""));
        data.add(lblPPG);
        data.add(txfPPG);
        data.add(lblRPG);
        data.add(txfRPG);
        data.add(lblHS);
        data.add(txfHS);
        con.add(data);
        con.add(btnSave);
        con.add(btnCancel);
        
        //add action listeners to buttons
        btnSave.addActionListener(this);
        btnCancel.addActionListener(this);
    }
    
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource() == btnSave)
        {
            FrontEnd fe = new FrontEnd();
            this.dispose();
        }
        else if(ae.getSource() == btnCancel)
        {
            PlayerMenu pm = new PlayerMenu();
            this.dispose();
        }
    }
}