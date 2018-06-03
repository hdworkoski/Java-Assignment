package GUI;
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
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

/**
 *
 * @author hillarydworkoski
 */
public class TeamTableMenu extends JFrame implements ActionListener
{
    //create GUI objects
    JButton btnBack = new JButton("Back");
    JButton btnEdit = new JButton("Edit Team");
    JButton btnDelete = new JButton("Delete Team");
    JButton btnView = new JButton("View Members");
    JPanel pnlButtons = new JPanel();
    ImageIcon imgLogo = new ImageIcon("NBALogo.png");
    JLabel lblImage = new JLabel();
    JLabel lblLine = new JLabel("                                                         ");
    JPanel pnlTop = new JPanel();
    Font dataFont = new Font("Arial", Font.BOLD, 14);
    JTable tblTeam = new JTable();
    Container con = getContentPane();
    JScrollPane scroll = new JScrollPane(tblTeam,
            JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
            JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
    TeamTableModel table;
    TeamMenu tm;
    
    public TeamTableMenu(TeamMenu tm)
    {
        this.setTitle("View Teams");
        this.setVisible(true);
        this.setBounds(400, 50, 530, 1000);
        this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        this.tm = tm;
        
        //set layout, fonts, colors
        con.setLayout(new FlowLayout());
        con.setBackground(Color.BLACK);
        pnlTop.setLayout(new BorderLayout());
        pnlTop.setBackground(Color.BLACK);
        pnlButtons.setLayout(new GridLayout(2, 2, 5, 5));
        pnlButtons.setBackground(Color.BLACK);
        lblImage.setIcon(imgLogo);
        JLabel lblHeading = new JLabel("View Teams");
        lblHeading.setFont(new Font("Verdana", Font.BOLD, 34));
        lblHeading.setForeground(Color.WHITE);
        
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
        pnlButtons.add(btnBack);
        con.add(pnlButtons);
        
        //add action listeners to buttons
        btnBack.addActionListener(this);
        btnView.addActionListener(this);
    }
    
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource() == btnView)
        {
            System.out.println(tblTeam.getSelectedRow());
            String team = 
                tblTeam.getValueAt
                    (tblTeam.getSelectedRow(), 0).toString();
            System.out.println(team);
            MemberTableView ptv = new MemberTableView(team, this);
        }
        else
        {
            tm.setVisible(true);
            this.dispose();
        }
    }
}
