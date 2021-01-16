package Aziq07163_View;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class Aziq07163_PenjualGUI {

    JFrame Menu = new JFrame();
    JButton Daftar, LihatData;
    JLabel labelcovmenu;

    public Aziq07163_PenjualGUI() {
        Menu.setSize(700, 600);
        Menu.setLayout(null);
        Menu.getContentPane().setBackground(Color.CYAN);
        labelcovmenu = new JLabel(" Data Pembeli ");
        labelcovmenu.setBounds(280, 100, 460, 40);
        labelcovmenu.setFont(new Font("Times New Roman", Font.BOLD, 40));
        Menu.add(labelcovmenu);

        Menu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Menu.setVisible(true);
        Menu.setLocationRelativeTo(null);

        Daftar = new JButton("Daftar");
        Daftar.setBounds(280, 170, 120, 40);
        Daftar.setBackground(Color.GREEN);
        Menu.add(Daftar);

        LihatData = new JButton("Lihat Data");
        LihatData.setBounds(280, 230, 120, 40);
        LihatData.setBackground(Color.GREEN);
        Menu.add(LihatData);

        Daftar.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ae) {
                Menu.dispose();
                Aziq07163_PembeliGUI create = new Aziq07163_PembeliGUI();
                
            }
        });
        
        LihatData.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ae) {
                Menu.dispose();
                Aziq07163_ViewGUI create = new Aziq07163_ViewGUI();
                
            }
        });
    }
}
