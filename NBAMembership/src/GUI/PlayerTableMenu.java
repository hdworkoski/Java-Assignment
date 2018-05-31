package GUI;
import DAL.PlayerTableModel;
import java.awt.BorderLayout;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
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
public class PlayerTableMenu extends JFrame implements ActionListener
{
    //create GUI objects
    JButton btnOK = new JButton("OK");
    ImageIcon imgLogo = new ImageIcon("NBALogo.png");
    JLabel lblImage = new JLabel();
    JPanel pnlTop = new JPanel();
    JPanel pnlBottom = new JPanel();
    Font dataFont = new Font("Arial", Font.BOLD, 14);
    JTable tblPlayer = new JTable();
    Container con = getContentPane();
    JScrollPane scroll = new JScrollPane(tblPlayer,
            JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
            JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
    JScrollBar bar = scroll.getVerticalScrollBar();
    PlayerTableModel table;
    PlayerMenu pm;
    
    public PlayerTableMenu(PlayerMenu pm)
    {
        this.setTitle("View Players");
        this.setVisible(true);
        this.setBounds(50, 200, 1300, 450);
        this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        this.pm = pm;
        
        bar.setPreferredSize(new Dimension(40, 0));
        
        //set layout, fonts, colors
        pnlTop.setLayout(new GridLayout(2, 1, 5, 5));
        pnlTop.setBackground(Color.BLACK);
        pnlBottom.setLayout(new GridLayout(2, 1, 5, 5));
        pnlBottom.setBackground(Color.BLACK);
        con.setLayout(new BorderLayout());
        con.setBackground(Color.BLACK);
        lblImage.setIcon(imgLogo);
        JLabel lblHeading = new JLabel("View Players");
        lblHeading.setFont(new Font("Verdana", Font.BOLD, 34));
        lblHeading.setForeground(Color.WHITE);
        
        
        //customize button
        btnOK.setFont(new Font("Arial", Font.BOLD, 20));
        btnOK.setForeground(Color.WHITE);
        btnOK.setBackground(Color.DARK_GRAY);
        btnOK.setOpaque(true);
        btnOK.setBorderPainted(false);
        
        table = new PlayerTableModel();
        tblPlayer.setModel(table);
        
        pnlTop.add(lblImage);
        pnlTop.add(lblHeading);
        con.add(pnlTop, BorderLayout.NORTH);
        pnlBottom.add(scroll);
        pnlBottom.add(btnOK);
        con.add(pnlBottom, BorderLayout.SOUTH);
        
        //add action listeners to buttons
        btnOK.addActionListener(this);
    }
    
    public void actionPerformed(ActionEvent ae)
    {
        pm.setVisible(true);
        this.dispose();
    }
}
