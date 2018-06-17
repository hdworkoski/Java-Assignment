package GUI;


import Utilities.BackupDatabase;
import Utilities.RestoreDatabase;
import java.awt.Color;
import java.awt.Container;
import java.awt.Desktop;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author hillarydworkoski
 */
public class FrontEnd extends JFrame implements ActionListener
{
    //create GUI objects
    JLabel lblHeading = new JLabel("Registration");
    JButton btnTeams = new JButton("Teams");
    JButton btnPlayers = new JButton("Players");
    JButton btnCoaches = new JButton("Coaches");
    JButton btnHelp = new JButton("Help");
    JButton btnBackup = new JButton("Backup Database");
    JButton btnRestore = new JButton("Restore Database");
    JPanel buttons = new JPanel();
    ImageIcon imgLogo = new ImageIcon("NBALogo.png");
    JLabel lblImage = new JLabel();
    Font fntButtons = new Font("Arial", Font.BOLD, 20);
    
    Container con = getContentPane();
    
    public FrontEnd()
    {
        this.setTitle("NBA Registration");
        this.setVisible(true);
        this.setBounds(550, 200, 320, 560);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        //set layouts
        con.setLayout(new FlowLayout());
        buttons.setLayout(new GridLayout(6, 1, 5, 5));
        
        //colors and fonts
        con.setBackground(Color.BLACK);
        buttons.setBackground(Color.BLACK);
        lblHeading.setForeground(Color.WHITE);
        lblHeading.setFont(new Font("Verdana", Font.BOLD, 34));
        
        //button customization
        btnTeams.setFont(fntButtons);
        btnTeams.setForeground(Color.WHITE);
        btnTeams.setBackground(Color.DARK_GRAY);
        btnTeams.setOpaque(true);
        btnTeams.setBorderPainted(false);
        
        btnPlayers.setFont(fntButtons);
        btnPlayers.setForeground(Color.WHITE);
        btnPlayers.setBackground(Color.DARK_GRAY);
        btnPlayers.setOpaque(true);
        btnPlayers.setBorderPainted(false);
        
        btnCoaches.setFont(fntButtons);
        btnCoaches.setForeground(Color.WHITE);
        btnCoaches.setBackground(Color.DARK_GRAY);
        btnCoaches.setOpaque(true);
        btnCoaches.setBorderPainted(false);
        
        btnBackup.setFont(fntButtons);
        btnBackup.setForeground(Color.WHITE);
        btnBackup.setBackground(Color.DARK_GRAY);
        btnBackup.setOpaque(true);
        btnBackup.setBorderPainted(false);
        
        btnRestore.setFont(fntButtons);
        btnRestore.setForeground(Color.WHITE);
        btnRestore.setBackground(Color.DARK_GRAY);
        btnRestore.setOpaque(true);
        btnRestore.setBorderPainted(false);
        
        btnHelp.setFont(fntButtons);
        btnHelp.setForeground(Color.WHITE);
        btnHelp.setBackground(Color.DARK_GRAY);
        btnHelp.setOpaque(true);
        btnHelp.setBorderPainted(false);
        
        //add image
        lblImage.setIcon(imgLogo);
        con.add(lblImage);
        
        //add objects
        con.add(lblHeading);
        con.add(new JLabel
        ("                                                                                    "));
        con.add(buttons);
        buttons.add(btnTeams);
        buttons.add(btnPlayers);
        buttons.add(btnCoaches);
        buttons.add(btnBackup);
        buttons.add(btnRestore);
        buttons.add(btnHelp);
        
        //action listeners for buttons
        btnTeams.addActionListener(this);
        btnPlayers.addActionListener(this);
        btnCoaches.addActionListener(this);
        btnBackup.addActionListener(this);
        btnRestore.addActionListener(this);
        btnHelp.addActionListener(this);
    }
    
    public void actionPerformed(ActionEvent ae)
    {
        //what to do for each button clicked
        if(ae.getSource() == btnTeams)
        {
            TeamMenu tm = new TeamMenu(this);
            this.setVisible(false);
        }
        else if(ae.getSource() == btnPlayers)
        {
            PlayerMenu pm = new PlayerMenu(this);
            this.setVisible(false);
        }
        else if(ae.getSource() == btnCoaches)
        {
            CoachMenu cm = new CoachMenu(this);
            this.setVisible(false);
        }
        else if(ae.getSource() == btnBackup)
        {
            BackupDatabase.backup();
        }
        else if(ae.getSource() == btnRestore)
        {
            RestoreDatabase.readAll();
        }
        else
        {
            String document = "User Documentation.pdf";
            try
            {
                File f = new File(document);
                Desktop.getDesktop().open(f);
            }
            catch(IOException ioE)
            {
                System.err.print(ioE.getMessage());
        }
        }
    } 
}