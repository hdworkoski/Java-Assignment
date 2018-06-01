package GUI;
import DAL.MemberTableModel;
import DAL.PlayerTableModel;

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
        pnlTop.setLayout(new GridLayout(2, 1, 5, 5));
        pnlTop.setBackground(Color.BLACK);
        pnlButtons.setLayout(new GridLayout(2, 2, 5, 5));
        pnlButtons.setBackground(Color.BLACK);
        con.setLayout(new FlowLayout());
        con.setBackground(Color.BLACK);
        lblImage.setIcon(imgLogo);
        JLabel lblHeading = new JLabel("View Members from " + team);
        lblHeading.setFont(new Font("Verdana", Font.BOLD, 34));
        lblHeading.setForeground(Color.WHITE);
        
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
        pnlTop.add(lblImage);
        pnlTop.add(lblHeading);
        con.add(pnlTop);
        con.add(scroll);
        pnlButtons.add(btnEdit);
        pnlButtons.add(btnDelete);
        pnlButtons.add(btnBack);
        con.add(pnlButtons);
        
        //add action listeners to buttons
        btnBack.addActionListener(this);
    }
    
    public void actionPerformed(ActionEvent ae)
    {
        ttm.setVisible(true);
        this.dispose();
    }
}