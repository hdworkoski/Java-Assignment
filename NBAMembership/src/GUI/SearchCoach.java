package GUI;

import Classes.Coach;
import DAL.MemberFunctions;
import Utilities.Validation;
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
public class SearchCoach extends JFrame implements ActionListener
{
    //create GUI objects
    JLabel lblHeading = new JLabel("Search for a Coach");
    JLabel lblLine = new JLabel("                                                                                                                                                        ");
    JLabel lblLine2 = new JLabel("                                                                                                                           ");
    JLabel lblLine3 = new JLabel("                                                                                                                           ");
    JPanel pnlCoach = new JPanel();
    JButton btnSearch = new JButton("Search");
    JButton btnBack = new JButton("Back");
    JLabel lblLast = new JLabel("Last Name:");
    JTextField txfLast = new JTextField(10);
    JLabel lblMsg1 = new JLabel("  ");
    JLabel lblMsg2 = new JLabel("  ");
    JLabel lblMsg3 = new JLabel("  ");
    JLabel lblMsg4 = new JLabel("  ");
    JLabel lblMsg5 = new JLabel("  ");
    JLabel lblMsg6 = new JLabel("  ");
    JLabel lblMsg7 = new JLabel("  ");
    JLabel lblMsg8 = new JLabel("  ");
    ImageIcon imgLogo = new ImageIcon("NBALogo.png");
    JLabel lblImage = new JLabel();
    
    Container con = getContentPane();
    
    CoachMenu cm;
    
    public SearchCoach(CoachMenu cm)
    {
        this.setTitle("Search for a Coach");
        this.setVisible(true);
        this.setBounds(550, 200, 380, 620);
        this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        this.cm = cm;
        
        //set layout, fonts, colors
        con.setLayout(new FlowLayout());
        con.setBackground(Color.BLACK);
        lblImage.setIcon(imgLogo);
        lblHeading.setFont(new Font("Verdana", Font.BOLD, 34));
        lblHeading.setForeground(Color.WHITE);
        lblHeading.setHorizontalAlignment(JLabel.CENTER);
        lblImage.setHorizontalAlignment(JLabel.CENTER);
        lblLast.setFont(new Font("Arial", Font.BOLD, 14));
        lblLast.setForeground(Color.WHITE);
        pnlCoach.setBackground(Color.BLACK);
        pnlCoach.setLayout(new GridLayout(10, 1, 5, 5));
        lblMsg1.setFont(new Font("Arial", Font.BOLD, 14));
        lblMsg1.setForeground(Color.WHITE);
        lblMsg2.setFont(new Font("Arial", Font.BOLD, 14));
        lblMsg2.setForeground(Color.WHITE);
        lblMsg3.setFont(new Font("Arial", Font.BOLD, 14));
        lblMsg3.setForeground(Color.WHITE);
        lblMsg4.setFont(new Font("Arial", Font.BOLD, 14));
        lblMsg4.setForeground(Color.WHITE);
        lblMsg5.setFont(new Font("Arial", Font.BOLD, 14));
        lblMsg5.setForeground(Color.WHITE);
        lblMsg6.setFont(new Font("Arial", Font.BOLD, 14));
        lblMsg6.setForeground(Color.WHITE);
        lblMsg7.setFont(new Font("Arial", Font.BOLD, 14));
        lblMsg7.setForeground(Color.WHITE);
        lblMsg8.setFont(new Font("Arial", Font.BOLD, 14));
        lblMsg8.setForeground(Color.WHITE);
        
        //customize buttons
        btnBack.setFont(new Font("Arial", Font.BOLD, 20));
        btnBack.setForeground(Color.WHITE);
        btnBack.setBackground(Color.DARK_GRAY);
        btnBack.setOpaque(true);
        btnBack.setBorderPainted(false);
        
        btnSearch.setFont(new Font("Arial", Font.BOLD, 20));
        btnSearch.setForeground(Color.WHITE);
        btnSearch.setBackground(Color.DARK_GRAY);
        btnSearch.setOpaque(true);
        btnSearch.setBorderPainted(false);
        
        //add objects
        con.add(lblImage);
        con.add(lblHeading);
        con.add(lblLine);
        con.add(lblLast);
        con.add(txfLast);
        con.add(new JLabel("                                                                                                                                      "));
        pnlCoach.add(lblMsg1);
        pnlCoach.add(lblMsg2);
        pnlCoach.add(lblMsg3);
        pnlCoach.add(lblMsg4);
        pnlCoach.add(lblMsg5);
        pnlCoach.add(lblMsg6);
        pnlCoach.add(lblMsg7);
        pnlCoach.add(lblMsg8);
        
        con.add(pnlCoach);
        con.add(lblLine3);
        con.add(btnSearch);
        con.add(btnBack);
        
        //add action listeners to buttons
        btnSearch.addActionListener(this);
        btnBack.addActionListener(this);
    }
    
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource() == btnSearch)
        {
            String last = txfLast.getText();
            if(Validation.validateName(last))
            {
                Coach c = MemberFunctions.searchCoach(last);
                if(c.getFirstName().equals(""))
                {
                    lblMsg1.setText("Coach Record Not Found");
                    lblMsg2.setText("  ");
                    lblMsg3.setText("  ");
                    lblMsg4.setText("  ");
                    lblMsg5.setText("  ");
                    lblMsg6.setText("  ");
                    lblMsg7.setText("  ");
                    lblMsg8.setText("  ");

                }
                else
                {
                    lblMsg1.setText("Coach: " + c.getID() + " " + c.getFirstName() + " " + c.getLastName());
                    lblMsg2.setText("Phone: " + c.getPhone());
                    lblMsg3.setText("Email: " + c.getEmail());
                    lblMsg4.setText("Team: " + c.getTeam());
                    lblMsg5.setText("Years Experience: " + c.getYearsExp());
                    lblMsg6.setText("Championships: " + c.getChampionships());
                    lblMsg7.setText("Playoffs: " + c.getPlayoffs());
                    lblMsg8.setText("Win/Loss Ratio: " + c.getwLRatio());
                }
            }
        }
        else
        {
            this.dispose();
            cm.setVisible(true);
        }
    }
}