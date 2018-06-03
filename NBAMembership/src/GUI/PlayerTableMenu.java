package GUI;
import Classes.Player;
import DAL.PlayerTableModel;
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
public class PlayerTableMenu extends JFrame implements ActionListener
{
    //create GUI objects
    JButton btnEdit = new JButton("Edit");
    JButton btnDelete = new JButton("Delete");
    JButton btnSalary = new JButton("Calculate Salary");
    JButton btnBack = new JButton("Back");
    ImageIcon imgLogo = new ImageIcon("NBALogo.png");
    JLabel lblImage = new JLabel();
    JLabel lblSalary = new JLabel();
    JLabel lblLine = new JLabel("                                                                    ");
    JPanel pnlTop = new JPanel();
    JPanel pnlButtons = new JPanel();
    Font dataFont = new Font("Arial", Font.BOLD, 14);
    JTable tblPlayer = new JTable();
    Container con = getContentPane();
    JScrollPane scroll = new JScrollPane(tblPlayer,
            JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
            JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
    PlayerTableModel table;
    PlayerMenu pm;
    
    public PlayerTableMenu(PlayerMenu pm)
    {
        this.setTitle("View Players");
        this.setVisible(true);
        this.setBounds(300, 50, 630, 1000);
        this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        this.pm = pm;
        
        //set layout, fonts, colors
        pnlTop.setLayout(new BorderLayout());
        pnlTop.setBackground(Color.BLACK);
        pnlButtons.setLayout(new GridLayout(2, 2, 5, 5));
        pnlButtons.setBackground(Color.BLACK);
        con.setLayout(new FlowLayout());
        con.setBackground(Color.BLACK);
        lblImage.setIcon(imgLogo);
        JLabel lblHeading = new JLabel("View Players");
        lblHeading.setFont(new Font("Verdana", Font.BOLD, 34));
        lblHeading.setForeground(Color.WHITE);
        lblSalary.setFont(new Font("Verdana", Font.BOLD, 20));
        lblSalary.setForeground(Color.WHITE);
        
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
        
        btnSalary.setFont(new Font("Arial", Font.BOLD, 20));
        btnSalary.setForeground(Color.WHITE);
        btnSalary.setBackground(Color.DARK_GRAY);
        btnSalary.setOpaque(true);
        btnSalary.setBorderPainted(false);
        
        //table model
        table = new PlayerTableModel();
        tblPlayer.setModel(table);
        
        //add objects to container
        pnlTop.add(lblImage, BorderLayout.NORTH);
        pnlTop.add(lblHeading, BorderLayout.CENTER);
        con.add(pnlTop);
        con.add(lblLine);
        con.add(scroll);
        con.add(lblSalary);
        pnlButtons.add(btnEdit);
        pnlButtons.add(btnDelete);
        pnlButtons.add(btnSalary);
        pnlButtons.add(btnBack);
        con.add(pnlButtons);
        
        //add action listeners to buttons
        btnEdit.addActionListener(this);
        btnDelete.addActionListener(this);
        btnSalary.addActionListener(this);
        btnBack.addActionListener(this);
    }
    
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource() == btnEdit)
        {
            
            this.setVisible(false);
        }
        else if(ae.getSource() == btnSalary)
        {
            Player p = table.getRow(tblPlayer.getSelectedRow());
            int salary = p.calcSalary();
            lblSalary.setText(p.getFirstName() + " " + p.getLastName() 
                        + " salary: $" + salary);
        }
        else
        {
            pm.setVisible(true);
            this.dispose();
        }
    }
}
