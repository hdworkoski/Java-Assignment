package GUI;
import Classes.Player;
import DAL.MemberFunctions;
import DAL.PlayerTableModel;
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
 */
public class PlayerTableMenu extends JFrame implements ActionListener
{
    //create GUI objects
    JButton btnEdit = new JButton("Edit");
    JButton btnDelete = new JButton("Delete");
    JButton btnSalary = new JButton("Calculate Salary");
    JButton btnBack = new JButton("Back");
    JButton btnRefresh = new JButton("Refresh");
    ImageIcon imgLogo = new ImageIcon("NBALogo.png");
    JLabel lblImage = new JLabel();
    JLabel lblSalary = new JLabel("   ");
    JLabel lblLine = new JLabel("                                                                    ");
    JPanel pnlTop = new JPanel();
    JPanel pnlButtons = new JPanel();
    JPanel pnlBottom = new JPanel();
    Font dataFont = new Font("Arial", Font.BOLD, 14);
    JTable tblPlayer = new JTable();
    Container con = getContentPane();
    JScrollPane scroll = new JScrollPane(tblPlayer,
            JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
            JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
    PlayerTableModel table;
    PlayerMenu pm;
    
    public PlayerTableMenu(PlayerMenu pm)
    {
        this.setTitle("View Players");
        this.setVisible(true);
        this.setBounds(200, 50, 1000, 830);
        this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        this.pm = pm;
        
        //set layout, fonts, colors
        pnlTop.setLayout(new BorderLayout());
        pnlTop.setBackground(Color.BLACK);
        pnlButtons.setLayout(new GridLayout(3, 2, 5, 5));
        pnlButtons.setBackground(Color.BLACK);
        pnlBottom.setLayout(new BorderLayout());
        pnlBottom.setBackground(Color.BLACK);
        con.setLayout(new BorderLayout());
        con.setBackground(Color.BLACK);
        lblImage.setIcon(imgLogo);
        JLabel lblHeading = new JLabel("View Players");
        lblHeading.setFont(new Font("Verdana", Font.BOLD, 34));
        lblHeading.setForeground(Color.WHITE);
        lblHeading.setHorizontalAlignment(JLabel.CENTER);
        lblImage.setHorizontalAlignment(JLabel.CENTER);
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
        
        btnRefresh.setFont(new Font("Arial", Font.BOLD, 20));
        btnRefresh.setForeground(Color.WHITE);
        btnRefresh.setBackground(Color.DARK_GRAY);
        btnRefresh.setOpaque(true);
        btnRefresh.setBorderPainted(false);
        
        //table model
        table = new PlayerTableModel();
        tblPlayer.setModel(table);
        
        //add objects to container
        pnlTop.add(lblImage, BorderLayout.NORTH);
        pnlTop.add(lblHeading, BorderLayout.CENTER);
        pnlTop.add(lblLine, BorderLayout.SOUTH);
        con.add(pnlTop, BorderLayout.NORTH);
        con.add(scroll, BorderLayout.CENTER);
        pnlButtons.add(btnEdit);
        pnlButtons.add(btnDelete);
        pnlButtons.add(btnSalary);
        pnlButtons.add(btnRefresh);
        pnlButtons.add(btnBack);
        pnlBottom.add(lblSalary, BorderLayout.NORTH);
        pnlBottom.add(pnlButtons, BorderLayout.CENTER);
        con.add(pnlBottom, BorderLayout.SOUTH);
        
        //add action listeners to buttons
        btnEdit.addActionListener(this);
        btnDelete.addActionListener(this);
        btnSalary.addActionListener(this);
        btnBack.addActionListener(this);
        btnRefresh.addActionListener(this);
    }
    
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource() == btnEdit)
        {
            try
            {
                Player p = table.getRow(tblPlayer.getSelectedRow());
                AddPlayerMenu apm = new AddPlayerMenu("Edit Player " + p.getID(), p);
            }
            catch(ArrayIndexOutOfBoundsException AIex)
            {
                JOptionPane.showMessageDialog(null, "You must select a player first");
            }
        }
        else if(ae.getSource() == btnSalary)
        {
            try
            {
                Player p = table.getRow(tblPlayer.getSelectedRow());
                int salary = p.calcSalary();
                lblSalary.setText(p.getFirstName() + " " + p.getLastName() 
                        + " salary: $" + salary);
            }
            catch(ArrayIndexOutOfBoundsException AIex)
            {
                JOptionPane.showMessageDialog(null, "You must select a player first");
            }
        }
        else if(ae.getSource() == btnDelete)
        {
            try
            {
                Player p = table.getRow(tblPlayer.getSelectedRow());
                MemberFunctions.deletePlayer(p.getID());
                table.getDataFromDatabase();
                table.fireTableDataChanged();
                this.repaint();
            }
            catch(ArrayIndexOutOfBoundsException AIex)
            {
                JOptionPane.showMessageDialog(null, "You must select a player first");
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
            pm.setVisible(true);
            this.dispose();
        }
    }
}