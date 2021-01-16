package Aziq07163_View;

import Aziq07163_Entity.Aziq07163_BarangEntity;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.*;

public class Aziq07163_UpdateGUI {
    
    JFrame Update = new JFrame();
    JLabel labelcovupdate, labelpengguna,labelpasslama,labelpassbaru;
    JButton updt, back;
    JTextField textnmpengguna, textpasspengguna;
    JComboBox pilmenu = new JComboBox(Aziq07163_BarangEntity.namaBarang);
   
    
    public Aziq07163_UpdateGUI(final int index) {
        
        Update.setSize(700, 630);
        Update.setLayout(null);
        Update.getContentPane().setBackground(Color.CYAN);
        labelcovupdate = new JLabel("Update Pesanan");
        labelcovupdate.setBounds(250, 30, 460, 40);
        labelcovupdate.setFont(new Font("Times New Roman", Font.BOLD, 30));
        Update.add(labelcovupdate);

        Update.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Update.setVisible(true);
        Update.setLocationRelativeTo(null);

        labelpengguna = new JLabel("Kode");
        labelpengguna.setBounds(140, 70, 100, 50);
        Update.add(labelpengguna);
        textnmpengguna = new JTextField();
        textnmpengguna.setBounds(140, 110, 200, 30);
        Update.add(textnmpengguna);
        
        labelpasslama = new JLabel("Password lama");
        labelpasslama.setBounds(140, 130, 100, 50);
        Update.add(labelpasslama);
        textpasspengguna = new JTextField();
        textpasspengguna.setBounds(140, 170, 200, 30);
        Update.add(textpasspengguna);

        labelpassbaru = new JLabel("Password Baru");
        labelpassbaru.setBounds(140, 190, 100, 50);
        Update.add(labelpassbaru);
        textpasspengguna = new JTextField();
        textpasspengguna.setBounds(140, 230, 200, 30);
        Update.add(textpasspengguna);

        updt = new JButton(" Update ");
        updt.setBounds(420, 280, 140, 30);
        updt.setBackground(Color.GREEN);
        Update.add(updt);

        back = new JButton("Back");
        back.setBounds(420, 320, 140, 30);
        back.setBackground(Color.red);
        Update.add(back);
      
        textnmpengguna.setText(Aziq07163_Allobjctrl.pembeli.getData(index).getKode());
        textpasspengguna.setText(Aziq07163_Allobjctrl.pembeli.getData(index).getPassword());
        
        updt.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {               
                try {                                
                    Aziq07163_Allobjctrl.pembeli.setKode(index, textnmpengguna.getText());
                    Aziq07163_Allobjctrl.pembeli.setPassword(index, textpasspengguna.getText());
                    Aziq07163_Allobjctrl.pembeli.setPassword(index, textpasspengguna.getText());
                    JOptionPane.showMessageDialog(null, "Sukses Update", "Information", JOptionPane.INFORMATION_MESSAGE);
                    Update.dispose();
                    Aziq07163_PenjualGUI daftarpesan = new Aziq07163_PenjualGUI();
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "Data Index Tidak Tersedia", "Information", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        });

        back.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ae) {
                Update.dispose();
                Aziq07163_PenjualGUI back = new Aziq07163_PenjualGUI();
            }
        });
    }
}
