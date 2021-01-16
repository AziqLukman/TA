package Aziq07163_View;

import Aziq07163_Controller.Aziq07163_PembeliController;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class Aziq07163_HapusGUI {

    JFrame Hapus = new JFrame();
    JLabel labelcovdel, labeldelkode, labeldelpass;
    JButton del, back;
    JTextField textdelkode, textdelpass;

    public Aziq07163_HapusGUI() {
        Hapus.setSize(700, 630);
        Hapus.setLayout(null);
        Hapus.getContentPane().setBackground(Color.CYAN);
        labelcovdel = new JLabel("Delete Pesanan");
        labelcovdel.setBounds(250, 30, 460, 40);
        labelcovdel.setFont(new Font("Times New Roman", Font.BOLD, 30));
        Hapus.add(labelcovdel);

        Hapus.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Hapus.setVisible(true);
        Hapus.setLocationRelativeTo(null);


        labeldelkode = new JLabel("Kode");
        labeldelkode.setBounds(280, 170, 140, 30);
        Hapus.add(labeldelkode);
        textdelkode = new JTextField();
        textdelkode.setBounds(280, 200, 140, 30);
        Hapus.add(textdelkode);
        
        labeldelpass = new JLabel("Password");
        labeldelpass.setBounds(280, 250, 140, 30);
        Hapus.add(labeldelpass);
        textdelpass = new JTextField();
        textdelpass.setBounds(280, 280, 140, 30);
        Hapus.add(textdelpass);

        del = new JButton(" Delete ");
        del.setBounds(200, 480, 120, 40);
        del.setBackground(Color.GREEN);
        Hapus.add(del);

        back = new JButton(" Back ");
        back.setBounds(350, 480, 120, 40);
        back.setBackground(Color.red);
        Hapus.add(back);

        del.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ae) {
                if(Aziq07163_Allobjctrl.pembeli.size() == 0) {
                    JOptionPane.showMessageDialog(null, "Data Tidak Tersedia", "Information", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    for (int i = 0; i <= Aziq07163_Allobjctrl.pembeli.size() - 1; i++) {

                        if (textdelkode.getText().equals(Aziq07163_Allobjctrl.pembeli.getData(i).getKode())
                                && textdelpass.getText().equals(Aziq07163_Allobjctrl.pembeli.getData(i).getPassword())){
                             JOptionPane.showMessageDialog(null, "DATA BERHASIL DIHAPUS", "Information", JOptionPane.INFORMATION_MESSAGE);
                           Aziq07163_Allobjctrl.pembeli.deleteData(i);
                            break;
                        } else if (i == Aziq07163_Allobjctrl.pembeli.size() - 1 && textdelkode.getText() != Aziq07163_Allobjctrl.pembeli.getData(i).
                                getKode()
                                && textdelpass.getText() != Aziq07163_Allobjctrl.pembeli.getData(i).getPassword()) {
                           JOptionPane.showMessageDialog(null, "Kode / Password Salah", "Information", JOptionPane.INFORMATION_MESSAGE);
                        } else if (i <= Aziq07163_Allobjctrl.pembeli.size() - 1 && textdelkode.getText() != Aziq07163_Allobjctrl.pembeli.getData(i).
                                getKode()
                                && textdelpass.getText() != Aziq07163_Allobjctrl.pembeli.getData(i).getPassword()) {
                            continue;
                        }
                    }
                }
                Hapus.dispose();
                Aziq07163_PenjualGUI deletepesan = new Aziq07163_PenjualGUI();
            }
        });

        back.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ae) {
                Hapus.dispose();
                Aziq07163_PenjualGUI back = new Aziq07163_PenjualGUI();
            }
        });
    }
}
