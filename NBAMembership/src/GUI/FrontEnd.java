package GUI;


import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
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
    JLabel lblTeams = new JLabel("Teams", SwingConstants.CENTER);
    JLabel lblPlayers = new JLabel("Players", SwingConstants.CENTER);
    JLabel lblCoaches = new JLabel("Coaches", SwingConstants.CENTER);
    JLabel lblHelp = new JLabel("Help", SwingConstants.CENTER);
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
        lblTeams.setFont(fntButtons);
        lblTeams.setForeground(Color.WHITE);
        lblTeams.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY));
        lblTeams.setBackground(Color.DARK_GRAY);
        lblTeams.setOpaque(true);
        lblPlayers.setFont(fntButtons);
        lblPlayers.setForeground(Color.WHITE);
        lblPlayers.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY));
        lblPlayers.setBackground(Color.DARK_GRAY);
        lblPlayers.setOpaque(true);
        lblCoaches.setFont(fntButtons);
        lblCoaches.setForeground(Color.WHITE);
        lblCoaches.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY));
        lblCoaches.setBackground(Color.DARK_GRAY);
        lblCoaches.setOpaque(true);
        lblHelp.setFont(fntButtons);
        lblHelp.setForeground(Color.WHITE);
        lblHelp.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY));
        lblHelp.setBackground(Color.DARK_GRAY);
        lblHelp.setOpaque(true);
        lblImage.setIcon(imgLogo);
        con.add(lblImage);
        con.add(lblHeading);
        con.add(new JLabel("                                                                                    "));
        con.add(buttons);
        buttons.add(lblTeams);
        buttons.add(lblPlayers);
        buttons.add(lblCoaches);
        buttons.add(lblHelp);
    }
    
    public void actionPerformed(ActionEvent ae)
    {
        
    }
    
    public static void main(String [] args)
    {
        FrontEnd fe = new FrontEnd();
    }
}
