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
public class Help extends JFrame implements ActionListener
{
    //create GUI objects
    JLabel lblHeading = new JLabel("Registration Help");
    JLabel lblHelp = new JLabel("Help Information. Here is some more help information.\nAnd some more help information");
    ImageIcon imgLogo = new ImageIcon("NBALogo.png");
    JLabel lblImage = new JLabel();
    JButton btnOk = new JButton("Ok");
    
    Container con = getContentPane();
    
    FrontEnd mainMenu;
    
    public Help(FrontEnd fe)
    {
        this.setTitle("Registration Help");
        this.setVisible(true);
        this.setBounds(550, 200, 350, 500);
        this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        mainMenu = fe;
        
        //set layout, colors, fonts
        con.setLayout(new FlowLayout());
        con.setBackground(Color.BLACK);
        lblImage.setIcon(imgLogo);
        lblHeading.setFont(new Font("Verdana", Font.BOLD, 34));
        lblHeading.setForeground(Color.WHITE);
        lblHelp.setFont(new Font("Arial", Font.BOLD, 16));
        lblHelp.setForeground(Color.WHITE);
        
        //customize button
        btnOk.setFont(new Font("Arial", Font.BOLD, 20));
        btnOk.setForeground(Color.WHITE);
        btnOk.setBackground(Color.DARK_GRAY);
        btnOk.setOpaque(true);
        btnOk.setBorderPainted(false);
        
        //add objects
        con.add(lblImage);
        con.add(lblHeading);
        con.add(lblHelp);
        con.add(btnOk);
        
        //add action listener
        btnOk.addActionListener(this);
    }
    
    public void actionPerformed(ActionEvent ae)
    {
        //what to do when button is clicked
        mainMenu.setVisible(true);
        this.dispose();
    }
}
