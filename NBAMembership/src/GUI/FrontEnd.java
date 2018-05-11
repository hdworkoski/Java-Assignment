package GUI;


import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

/**
 *
 * @author hillarydworkoski
 */
public class FrontEnd extends JFrame implements ActionListener
{
    JLabel lblHeading = new JLabel("Registration");
    JButton btnTeams = new JButton("Teams");
    JButton btnPlayers = new JButton("Players");
    JButton btnCoaches = new JButton("Coaches");
    JButton btnHelp = new JButton("Help");
    JPanel buttons = new JPanel();
    ImageIcon imgLogo = new ImageIcon("NBALogo.png");
    JLabel lblImage = new JLabel();
    Font fntButtons = new Font("Arial", Font.BOLD, 20);
    
    Container con = getContentPane();
    
    public FrontEnd()
    {
        this.setTitle("NBA Registration");
        this.setVisible(true);
        this.setBounds(550, 200, 350, 500);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        con.setLayout(new FlowLayout());
        buttons.setLayout(new GridLayout(4, 2, 5, 5));
        con.setBackground(Color.BLACK);
        buttons.setBackground(Color.BLACK);
        lblHeading.setForeground(Color.WHITE);
        lblHeading.setFont(new Font("Verdana", Font.BOLD, 34));
        btnTeams.setFont(fntButtons);
        btnTeams.setForeground(Color.WHITE);
        btnTeams.setBackground(Color.DARK_GRAY);
        btnPlayers.setFont(fntButtons);
        btnPlayers.setForeground(Color.WHITE);
        btnPlayers.setFocusPainted(false);
        btnPlayers.setBackground(Color.DARK_GRAY);
        btnCoaches.setFont(fntButtons);
        btnCoaches.setForeground(Color.WHITE);
        btnCoaches.setBackground(Color.DARK_GRAY);
        btnHelp.setFont(fntButtons);
        btnHelp.setForeground(Color.WHITE);
        btnHelp.setBackground(Color.DARK_GRAY);
        lblImage.setIcon(imgLogo);
        con.add(lblImage);
        con.add(lblHeading);
        con.add(new JLabel("                                                                                    "));
        con.add(buttons);
        buttons.add(btnTeams);
        buttons.add(btnPlayers);
        buttons.add(btnCoaches);
        buttons.add(btnHelp);
        
        btnHelp.addActionListener(this);
    }
    
    public void actionPerformed(ActionEvent ae)
    {
        Help help = new Help();
        this.dispose();
    } 
}