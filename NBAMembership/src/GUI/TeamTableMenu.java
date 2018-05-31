package GUI;
import DAL.TeamTableModel;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
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
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTable;

/**
 *
 * @author hillarydworkoski
 */
public class TeamTableMenu extends JFrame implements ActionListener
{
    //create GUI objects
    JButton btnOK = new JButton("OK");
    ImageIcon imgLogo = new ImageIcon("NBALogo.png");
    JLabel lblImage = new JLabel();
    JPanel pnlTop = new JPanel();
    Font dataFont = new Font("Arial", Font.BOLD, 14);
    JTable tblTeam = new JTable();
    Container con = getContentPane();
    JScrollPane scroll = new JScrollPane(tblTeam,
            JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
            JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
    JScrollBar bar = scroll.getVerticalScrollBar();
    TeamTableModel table;
    TeamMenu tm;
    
    public TeamTableMenu(TeamMenu tm)
    {
        this.setTitle("View Teams");
        this.setVisible(true);
        this.setBounds(300, 200, 450, 550);
        this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        this.tm = tm;
        
        bar.setPreferredSize(new Dimension(40, 0));
        
        //set layout, fonts, colors
        con.setLayout(new FlowLayout());
        con.setBackground(Color.BLACK);
        pnlTop.setLayout(new GridLayout(2, 1, 5, 5));
        pnlTop.setBackground(Color.BLACK);
        lblImage.setIcon(imgLogo);
        JLabel lblHeading = new JLabel("View Teams");
        lblHeading.setFont(new Font("Verdana", Font.BOLD, 34));
        lblHeading.setForeground(Color.WHITE);
        
        
        //customize button
        btnOK.setFont(new Font("Arial", Font.BOLD, 20));
        btnOK.setForeground(Color.WHITE);
        btnOK.setBackground(Color.DARK_GRAY);
        btnOK.setOpaque(true);
        btnOK.setBorderPainted(false);
        
        table = new TeamTableModel();
        tblTeam.setModel(table);
        
        pnlTop.add(lblImage);
        pnlTop.add(lblHeading);
        con.add(pnlTop);
        con.add(scroll);
        con.add(btnOK);
        
        //add action listeners to buttons
        btnOK.addActionListener(this);
    }
    
    public void actionPerformed(ActionEvent ae)
    {
        tm.setVisible(true);
        this.dispose();
    }
}
