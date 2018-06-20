package GUI;
import Classes.Team;
import DAL.MemberFunctions;
import DAL.TeamTableModel;
import java.awt.BorderLayout;

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
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

/**
 *
 * @author hillarydworkoski
 * File: TeamTableMenu.java
 * Description: This class is the GUI for the table for viewing Teams
 * Date: 21/6/18
 */
public class TeamTableMenu extends JFrame implements ActionListener
{
    //create GUI objects
    JButton btnBack = new JButton("Back");
    JButton btnEdit = new JButton("Edit Team");
    JButton btnDelete = new JButton("Delete Team");
    JButton btnView = new JButton("View Members");
    JButton btnRefresh = new JButton("Refresh");
    JPanel pnlButtons = new JPanel();
    ImageIcon imgLogo = new ImageIcon("NBALogo.png");
    JLabel lblImage = new JLabel();
    JLabel lblLine = new JLabel("                                                         ");
    JLabel lblLine2 = new JLabel("                                                         ");
    JPanel pnlTop = new JPanel();
    Font dataFont = new Font("Arial", Font.BOLD, 14);
    JTable tblTeam = new JTable();
    Container con = getContentPane();
    JScrollPane scroll = new JScrollPane(tblTeam,
            JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
            JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
    
    //initialize variables
    TeamTableModel table;
    TeamMenu tm;
    
    //constructor
    public TeamTableMenu(TeamMenu tm)
    {
        this.setTitle("View Teams");
        this.setVisible(true);
        this.setBounds(400, 50, 530, 830);
        this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        this.tm = tm;
        
        //set layout, fonts, colors
        con.setLayout(new FlowLayout());
        con.setBackground(Color.BLACK);
        pnlTop.setLayout(new BorderLayout());
        pnlTop.setBackground(Color.BLACK);
        pnlButtons.setLayout(new GridLayout(3, 2, 5, 5));
        pnlButtons.setBackground(Color.BLACK);
        lblImage.setIcon(imgLogo);
        JLabel lblHeading = new JLabel("View Teams");
        lblHeading.setFont(new Font("Verdana", Font.BOLD, 34));
        lblHeading.setForeground(Color.WHITE);
        lblHeading.setHorizontalAlignment(JLabel.CENTER);
        lblImage.setHorizontalAlignment(JLabel.CENTER);
        lblHeading.setHorizontalAlignment(JLabel.CENTER);
        lblImage.setHorizontalAlignment(JLabel.CENTER);
        
        tblTeam.setAutoCreateRowSorter(true);
        scroll.setBackground(Color.BLACK);
        scroll.setForeground(Color.WHITE);
        tblTeam.setBackground(Color.BLACK);
        tblTeam.setForeground(Color.WHITE);
        tblTeam.getTableHeader().setBackground(Color.BLACK);
        tblTeam.getTableHeader().setForeground(Color.WHITE);
        
        //customize buttons
        btnBack.setFont(new Font("Arial", Font.BOLD, 20));
        btnBack.setForeground(Color.WHITE);
        btnBack.setBackground(Color.DARK_GRAY);
        btnBack.setOpaque(true);
        btnBack.setBorderPainted(false);
        
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
        
        btnView.setFont(new Font("Arial", Font.BOLD, 20));
        btnView.setForeground(Color.WHITE);
        btnView.setBackground(Color.DARK_GRAY);
        btnView.setOpaque(true);
        btnView.setBorderPainted(false);
        
        btnRefresh.setFont(new Font("Arial", Font.BOLD, 20));
        btnRefresh.setForeground(Color.WHITE);
        btnRefresh.setBackground(Color.DARK_GRAY);
        btnRefresh.setOpaque(true);
        btnRefresh.setBorderPainted(false);
        
        //table model
        table = new TeamTableModel();
        tblTeam.setModel(table);
        
        //add objects to container
        pnlTop.add(lblImage, BorderLayout.NORTH);
        pnlTop.add(lblHeading, BorderLayout.CENTER);
        con.add(pnlTop);
        con.add(lblLine);
        con.add(scroll);
        pnlButtons.add(btnEdit);
        pnlButtons.add(btnView);
        pnlButtons.add(btnDelete);
        pnlButtons.add(btnRefresh);
        pnlButtons.add(btnBack);
        con.add(lblLine2);
        con.add(pnlButtons);
        
        //add action listeners to buttons
        btnEdit.addActionListener(this);
        btnDelete.addActionListener(this);
        btnBack.addActionListener(this);
        btnView.addActionListener(this);
        btnRefresh.addActionListener(this);
    }
    
    /**
     * 
     * @param ae ActionEvent
     * This method is performed when a button is clicked in the window
     */
    public void actionPerformed(ActionEvent ae)
    {
        //what to do for each button
        if(ae.getSource() == btnView)
        {
            try
            {
                String team = tblTeam.getValueAt
                    (tblTeam.getSelectedRow(), 0).toString();
                MemberTableView ptv = new MemberTableView(team, this);
            }
            catch(IndexOutOfBoundsException Iex)
            {
                JOptionPane.showMessageDialog(null, "You must select a team first");
            }
        }
        else if(ae.getSource() == btnEdit)
        {
            try
            {
                Team t = table.getRow(tblTeam.getSelectedRow());
                AddTeamMenu atm = new AddTeamMenu("Edit Team", t);
            }
            catch(ArrayIndexOutOfBoundsException AIex)
            {
                JOptionPane.showMessageDialog(null, "You must select a team first");
            }
        }
        else if(ae.getSource() == btnDelete)
        {
            try
            {
                Team t = table.getRow(tblTeam.getSelectedRow());
                MemberFunctions.deleteTeam(t.getName());
                table.getDataFromDatabase();
                table.fireTableDataChanged();
                this.repaint();
            }
            catch(ArrayIndexOutOfBoundsException AIex)
            {
                JOptionPane.showMessageDialog(null, "You must select a team first");
            }
        }
        else if(ae.getSource() == btnRefresh)
        {
            table.getDataFromDatabase();
            table.fireTableDataChanged();
            this.repaint();
        }
        else
        {
            tm.setVisible(true);
            this.dispose();
        }
    }
}