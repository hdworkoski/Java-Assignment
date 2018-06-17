package GUI;
import Classes.Coach;
import DAL.CoachTableModel;
import DAL.MemberFunctions;
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
public class CoachTableMenu extends JFrame implements ActionListener
{
    //create GUI objects
    JButton btnEdit = new JButton("Edit");
    JButton btnDelete = new JButton("Delete");
    JButton btnSalary = new JButton("Calculate Salary");
    JButton btnRefresh = new JButton("Refresh");
    JButton btnBack = new JButton("Back");
    ImageIcon imgLogo = new ImageIcon("NBALogo.png");
    JLabel lblImage = new JLabel();
    JLabel lblSalary = new JLabel("   ");
    JLabel lblLine = new JLabel("                                                                     ");
    JPanel pnlTop = new JPanel();
    JPanel pnlButtons = new JPanel();
    JPanel pnlBottom = new JPanel();
    Font dataFont = new Font("Arial", Font.BOLD, 14);
    JTable tblCoach = new JTable();
    Container con = getContentPane();
    JScrollPane scroll = new JScrollPane(tblCoach,
            JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
            JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
    CoachTableModel table;
    CoachMenu cm;
    
    public CoachTableMenu(CoachMenu cm)
    {
        this.setTitle("View Coaches");
        this.setVisible(true);
        this.setBounds(300, 50, 800, 830);
        this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        this.cm = cm;
        
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
        JLabel lblHeading = new JLabel("View Coaches");
        lblHeading.setFont(new Font("Verdana", Font.BOLD, 34));
        lblHeading.setForeground(Color.WHITE);
        lblHeading.setHorizontalAlignment(JLabel.CENTER);
        lblImage.setHorizontalAlignment(JLabel.CENTER);
        lblSalary.setFont(new Font("Verdana", Font.BOLD, 20));
        lblSalary.setForeground(Color.WHITE);
        
        tblCoach.setAutoCreateRowSorter(true);
        scroll.setBackground(Color.BLACK);
        scroll.setForeground(Color.WHITE);
        tblCoach.setBackground(Color.BLACK);
        tblCoach.setForeground(Color.WHITE);
        tblCoach.getTableHeader().setBackground(Color.BLACK);
        tblCoach.getTableHeader().setForeground(Color.WHITE);
        
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
        table = new CoachTableModel();
        tblCoach.setModel(table);
        
        //add objects to container
        pnlTop.add(lblImage, BorderLayout.NORTH);
        pnlTop.add(lblHeading, BorderLayout.CENTER);
        pnlTop.add(lblLine, BorderLayout.SOUTH);
        con.add(pnlTop, BorderLayout.NORTH);
        con.add(scroll, BorderLayout.CENTER);
        pnlBottom.add(lblSalary, BorderLayout.NORTH);
        pnlButtons.add(btnEdit);
        pnlButtons.add(btnDelete);
        pnlButtons.add(btnSalary);
        pnlButtons.add(btnRefresh);
        pnlButtons.add(btnBack);
        pnlBottom.add(pnlButtons, BorderLayout.CENTER);
        con.add(pnlBottom, BorderLayout.SOUTH);
        
        //add action listeners to buttons
        btnEdit.addActionListener(this);
        btnDelete.addActionListener(this);
        btnBack.addActionListener(this);
        btnSalary.addActionListener(this);
        btnRefresh.addActionListener(this);
    }
    
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource() == btnEdit)
        {
            try
            {
                Coach c = table.getRow(tblCoach.getSelectedRow());
                AddCoachMenu acm = new AddCoachMenu("Edit Coach " + c.getID(), c);
            }
            catch(ArrayIndexOutOfBoundsException AIex)
            {
                JOptionPane.showMessageDialog(null, "You must select a coach first");
            }
        }
        else if(ae.getSource() == btnSalary)
        {
            try
            {
                Coach c = table.getRow(tblCoach.getSelectedRow());
                int salary = c.calcSalary();
                lblSalary.setText(c.getFirstName() + " " + c.getLastName() 
                        + " salary: $" + salary);
            }
            catch(ArrayIndexOutOfBoundsException AIex)
            {
                JOptionPane.showMessageDialog(null, "You must select a coach first");
            }
        }
        else if(ae.getSource() == btnDelete)
        {
            try
            {
                Coach c = table.getRow(tblCoach.getSelectedRow());
                MemberFunctions.deleteCoach(c.getID());
                table.getDataFromDatabase();
                table.fireTableDataChanged();
                this.repaint();
            }
            catch(ArrayIndexOutOfBoundsException AIex)
            {
                JOptionPane.showMessageDialog(null, "You must select a coach first");
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
            cm.setVisible(true);
            this.dispose();
        }
    }
}