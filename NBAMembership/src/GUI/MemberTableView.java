package GUI;
import DAL.MemberTableModel;
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
    JButton btnBack = new JButton("Back");
    ImageIcon imgLogo = new ImageIcon("NBALogo.png");
    JLabel lblImage = new JLabel();
    JPanel pnlTop = new JPanel();
    JPanel pnlFullTop = new JPanel();
    JPanel pnlButtons = new JPanel();
    Font dataFont = new Font("Arial", Font.BOLD, 14);
    JTable tblPlayer = new JTable();
    Container con = getContentPane();
    JScrollPane scroll = new JScrollPane(tblPlayer,
            JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
            JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
    MemberTableModel table;
    TeamTableMenu ttm;
    
    public MemberTableView(String team, TeamTableMenu ttm)
    {
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
        
        tblPlayer.setAutoCreateRowSorter(true);
        scroll.setBackground(Color.BLACK);
        scroll.setForeground(Color.WHITE);
        tblPlayer.setBackground(Color.BLACK);
        tblPlayer.setForeground(Color.WHITE);
        tblPlayer.getTableHeader().setBackground(Color.BLACK);
        tblPlayer.getTableHeader().setForeground(Color.WHITE);
        
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
        
        //table model
        table = new MemberTableModel(team);
        tblPlayer.setModel(table);
        
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
        pnlButtons.add(btnBack);
        con.add(pnlButtons, BorderLayout.SOUTH);
        
        //add action listeners to buttons
        btnBack.addActionListener(this);
    }
    
    public void actionPerformed(ActionEvent ae)
    {
        ttm.setVisible(true);
        this.dispose();
    }
}