package Aziq07163_View;

import Aziq07163_Controller.Aziq07163_AllObjectModel;
import Aziq07163_View.Aziq07163_PenjualGUI;
import Aziq07163_Controller.Aziq07163_PembeliController;
import Aziq07163_Entity.Aziq07163_PembeliEntity;
import static Aziq07163_View.Aziq07163_Allobjctrl.pembeli;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.*;

public class Aziq07163_ViewGUI {

    private static Aziq07163_PembeliController pesanan = new Aziq07163_PembeliController();
    JFrame View = new JFrame();
    JTable tabelpesanan = new JTable();
    JScrollPane scrollpesanan = new JScrollPane(tabelpesanan);
    JButton verif,edit, hapus, back;
    JLabel labelcovdatapesan,kodelabel,passlabel;
    JTextField kodetext,passtext;
    public int index;

    public Aziq07163_ViewGUI() {

        View.setSize(700, 630);
        View.setLayout(null);
        View.getContentPane().setBackground(Color.CYAN);
        labelcovdatapesan = new JLabel("Data Pesanan");
        labelcovdatapesan.setBounds(270, 30, 460, 40);
        labelcovdatapesan.setFont(new Font("Times New Roman", Font.BOLD, 30));
        View.add(labelcovdatapesan);

        View.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        View.setVisible(true);
        View.setLocationRelativeTo(null);
        
        kodelabel = new JLabel("Kode");
        kodelabel.setBounds(50,320,100,30);
        View.add(kodelabel);
        
        kodetext = new JTextField();
        kodetext.setBounds(30,350,100,30);
        View.add(kodetext);
        
        passlabel = new JLabel("Password");
        passlabel.setBounds(200,320,100,30);
        View.add(passlabel);
        
        passtext = new JTextField();
        passtext.setBounds(200,350,100,30);
        View.add(passtext);

        scrollpesanan.setBounds(50, 80, 580, 100);
        tabelpesanan.setModel(pesanan.daftarBarang());
        View.add(scrollpesanan);
        
        verif = new JButton("verif");
        verif.setBounds(350,350,100,30);
        verif.setBackground(Color.GREEN);
        View.add(verif);

        edit = new JButton(" Edit ");
        edit.setBounds(120, 480, 120, 40);
        edit.setBackground(Color.GREEN);
        View.add(edit);

        hapus = new JButton(" Hapus ");
        hapus.setBounds(290, 480, 120, 40);
        hapus.setBackground(Color.GREEN);
        View.add(hapus);

        back = new JButton(" Back ");
        back.setBounds(460, 480, 120, 40);
        back.setBackground(Color.red);
        View.add(back);
        
        View.setLocationRelativeTo(null);
        View.setVisible(true);
        View.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        verif.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae){
                String kode = kodetext.getText();
                String pass = passtext.getText();
                int index = Aziq07163_AllObjectModel.daftarBarang.cekData(kode, pass);
                Aziq07163_Allobjctrl.admin.updateisVerified(index, Aziq07163_Allobjctrl.pembeli.showDaftarbarang(index).getPembeli());
                tabelpesanan.setModel(pembeli.daftarBarang());
            }
        });
        
        edit.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ae) {
                if (Aziq07163_Allobjctrl.pembeli.size() == 0) {
                    JOptionPane.showMessageDialog(null, "Data Kosong / Pilih Data Dahulu", "Information", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    View.dispose();
                    Aziq07163_UpdateGUI update = new Aziq07163_UpdateGUI(index);
                }
            }
        });

        tabelpesanan.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int i = tabelpesanan.getSelectedRow();
                index = Integer.parseInt(Aziq07163_Allobjctrl.pembeli.daftarBarang().getValueAt(i, 0).toString());
            }
        });

        hapus.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ae) {
                View.dispose();
                Aziq07163_HapusGUI delpesan = new Aziq07163_HapusGUI();
            }
        });

        back.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ae) {
                View.dispose();
                Aziq07163_PenjualGUI back = new Aziq07163_PenjualGUI();
            }
        });
    }

}
