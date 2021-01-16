package Aziq07163_View;

import Aziq07163_Entity.Aziq07163_BarangEntity;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class Aziq07163_PembeliGUI {

    JFrame Daftar = new JFrame();
    JLabel labelcovdaftar, labelkode, labelpass, labelalamat, labelnama,labelmenu;
    JTextField textnama, textpass, textalamat, textkode;
    JButton daftarpesan, back;
    JComboBox pilmenu = new JComboBox(Aziq07163_BarangEntity.namaBarang);

    public Aziq07163_PembeliGUI() {
        Daftar.setSize(700, 630);
        Daftar.setLayout(null);
        Daftar.getContentPane().setBackground(Color.BLUE);
        labelcovdaftar = new JLabel("Daftar Pesanan");
        labelcovdaftar.setBounds(250, 30, 460, 40);
        labelcovdaftar.setFont(new Font("Times New Roman", Font.BOLD, 30));
        Daftar.add(labelcovdaftar);

        Daftar.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Daftar.setVisible(true);
        Daftar.setLocationRelativeTo(null);

        labelkode = new JLabel("Kode");
        labelkode.setBounds(140, 70, 100, 50);
        Daftar.add(labelkode);
        textkode = new JTextField();
        textkode.setBounds(140, 110, 200, 30);
        Daftar.add(textkode);

        labelpass = new JLabel("Password");
        labelpass.setBounds(140, 130, 100, 50);
        Daftar.add(labelpass);
        textpass = new JTextField();
        textpass.setBounds(140, 170, 200, 30);
        Daftar.add(textpass);

        labelnama = new JLabel("Nama");
        labelnama.setBounds(140, 190, 100, 50);
        Daftar.add(labelnama);
        textnama = new JTextField();
        textnama.setBounds(140, 230, 200, 30);
        Daftar.add(textnama);

        labelalamat = new JLabel("Alamat");
        labelalamat.setBounds(140, 250, 170, 50);
        Daftar.add(labelalamat);
        textalamat = new JTextField();
        textalamat.setBounds(140, 290, 200, 30);
        Daftar.add(textalamat);

        labelmenu = new JLabel("Pilih Barang");
        labelmenu.setBounds(140, 370, 100, 50);
        Daftar.add(labelmenu);
        pilmenu.setBounds(140, 410, 200, 30);
        Daftar.add(pilmenu);

        daftarpesan = new JButton("Daftar Pesanan");
        daftarpesan.setBounds(420, 260, 140, 30);
        daftarpesan.setBackground(Color.GREEN);
        Daftar.add(daftarpesan);

        back = new JButton("Back");
        back.setBounds(420, 320, 140, 30);
        back.setBackground(Color.red);
        Daftar.add(back);

        daftarpesan.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ae) {
                try {
                    String kode = textkode.getText();
                    String password = textpass.getText();
                    String nama = textnama.getText();
                    String alamat = textalamat.getText();
                    int menu = pilmenu.getSelectedIndex();
                    Aziq07163_Allobjctrl.pembeli.insert(kode, password, nama, alamat);
                    JOptionPane.showMessageDialog(null, "Sukses Daftar", "Information", JOptionPane.INFORMATION_MESSAGE);
                    Daftar.dispose();
                    Aziq07163_PenjualGUI daftarpesan = new Aziq07163_PenjualGUI();
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "Format Pengisian Salah", "Information", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        });

        back.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ae) {
                Daftar.dispose();
                Aziq07163_PenjualGUI back = new Aziq07163_PenjualGUI();
            }
        });

    }

}

