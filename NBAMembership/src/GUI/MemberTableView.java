package GUI;
import Classes.Coach;
import Classes.Player;
import DAL.MemberFunctions;
import DAL.MemberTableModel;
import java.awt.BorderLayout;

import java.awt.Color;
import java.awt.Container;
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
 * File: MemberTableView.java
 */
public class MemberTableView extends JFrame implements ActionListener
{
    //create GUI objects
    JButton btnEdit = new JButton("Edit");
    JButton btnDelete = new JButton("Delete");
    JButton btnRefresh = new JButton("Refresh");
    JButton btnBack = new JButton("Back");
    ImageIcon imgLogo = new ImageIcon("NBALogo.png");
    JLabel lblImage = new JLabel();
    JPanel pnlTop = new JPanel();
    JPanel pnlFullTop = new JPanel();
    JPanel pnlButtons = new JPanel();
    Font dataFont = new Font("Arial", Font.BOLD, 14);
    JTable tblMember = new JTable();
    Container con = getContentPane();
    JScrollPane scroll = new JScrollPane(tblMember,
            JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
            JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
    MemberTableModel table;
    TeamTableMenu ttm;
    String team;
    
    public MemberTableView(String team, TeamTableMenu ttm)
    {
        this.team = team;
        this.setTitle("View Members from " + team);
        this.setVisible(true);
        this.setBounds(300, 50, 630, 1000);
        this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        this.ttm = ttm;
        
        //set layout, fonts, colors
        pnlTop.setLayout(new BorderLayout());
        pnlTop.setBackground(Color.BLACK);
        pnlFullTop.setLayout(new BorderLayout());
        pnlFullTop.setBackground(Color.BLACK);
        pnlButtons.setLayout(new GridLayout(3, 2, 5, 5));
        pnlButtons.setBackground(Color.BLACK);
        con.setLayout(new BorderLayout());
        con.setBackground(Color.BLACK);
        lblImage.setIcon(imgLogo);
        JLabel lblHeading = new JLabel("View Members");
        JLabel lblHeading2 = new JLabel("of the " + team);
        lblHeading.setFont(new Font("Verdana", Font.BOLD, 34));
        lblHeading.setForeground(Color.WHITE);
        lblHeading.setHorizontalAlignment(JLabel.CENTER);
        lblHeading2.setFont(new Font("Verdana", Font.BOLD, 34));
        lblHeading2.setForeground(Color.WHITE);
        lblHeading2.setHorizontalAlignment(JLabel.CENTER);
        lblImage.setHorizontalAlignment(JLabel.CENTER);
        
        tblMember.setAutoCreateRowSorter(true);
        scroll.setBackground(Color.BLACK);
        scroll.setForeground(Color.WHITE);
        tblMember.setBackground(Color.BLACK);
        tblMember.setForeground(Color.WHITE);
        tblMember.getTableHeader().setBackground(Color.BLACK);
        tblMember.getTableHeader().setForeground(Color.WHITE);
        
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
        
        btnRefresh.setFont(new Font("Arial", Font.BOLD, 20));
        btnRefresh.setForeground(Color.WHITE);
        btnRefresh.setBackground(Color.DARK_GRAY);
        btnRefresh.setOpaque(true);
        btnRefresh.setBorderPainted(false);
        
        //table model
        table = new MemberTableModel(team);
        tblMember.setModel(table);
        
        //add objects to container
        pnlTop.add(lblImage, BorderLayout.NORTH);
        pnlTop.add(lblHeading, BorderLayout.CENTER);
        pnlTop.add(lblHeading2, BorderLayout.SOUTH);
        pnlFullTop.add(pnlTop, BorderLayout.NORTH);
        pnlFullTop.add(new JLabel("  "), BorderLayout.CENTER);
        con.add(pnlFullTop, BorderLayout.NORTH);
        con.add(scroll, BorderLayout.CENTER);
        pnlButtons.add(new JLabel("  "));
        pnlButtons.add(new JLabel("  "));
        pnlButtons.add(btnEdit);
        pnlButtons.add(btnDelete);
        pnlButtons.add(btnRefresh);
        pnlButtons.add(btnBack);
        con.add(pnlButtons, BorderLayout.SOUTH);
        
        //add action listeners to buttons
        btnEdit.addActionListener(this);
        btnDelete.addActionListener(this);
        btnBack.addActionListener(this);
        btnRefresh.addActionListener(this);
    }
    
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource() == btnEdit)
        {
            try
            {
                Coach c = (Coach)table.getRow(tblMember.getSelectedRow());
                AddCoachMenu acm = new AddCoachMenu("Edit Coach " + c.getID(), c);
            }
            catch(ClassCastException CCex)
            {
                Player p = (Player)table.getRow(tblMember.getSelectedRow());
                AddPlayerMenu apm = new AddPlayerMenu("Edit Player " + p.getID(), p);
            }
            catch(ArrayIndexOutOfBoundsException AIex)
            {
                JOptionPane.showMessageDialog(null, "You must select a member first");
            }
        }
        else if(ae.getSource() == btnDelete)
        {
            try
            {
                Coach c = (Coach)table.getRow(tblMember.getSelectedRow());
                MemberFunctions.deleteCoach(c.getID());
            }
            catch(ClassCastException CCex)
            {
                Player p = (Player)table.getRow(tblMember.getSelectedRow());
                MemberFunctions.deletePlayer(p.getID());
            }
            catch(ArrayIndexOutOfBoundsException AIex)
            {
                JOptionPane.showMessageDialog(null, "You must select a member first");
            }
            
            table.getData(team);
            table.fireTableDataChanged();
            this.repaint();
        }
        else if(ae.getSource() == btnRefresh)
        {
            table.getData(team);
            table.fireTableDataChanged();
            this.repaint();
        }
        else
        {
            ttm.setVisible(true);
            this.dispose();
        }
    }
}