package Aziq07163_View;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import javax.swing.*;

public class Aziq07163_GUI {
    JFrame TampilanAwal = new JFrame();
    JLabel login,daftar,top;
    JRadioButton radiopenjual,radiopembeli;
    JTextField textkodelogin,textnama,textumur,textkodedaftar;
    JLabel labelkodelogin,labelnama,labelpasswordlogin,labelumur,labelkodedaftar,labelpassworddaftar;
    JButton check,reg;
    JPasswordField passwordlogin,passworddaftar;
    private boolean ceklogin = false;
    public Aziq07163_GUI(){
        TampilanAwal.setSize(700, 630);
        TampilanAwal.setLayout(null);
        TampilanAwal.getContentPane().setBackground(Color.blue);
        top = new JLabel("PROGRAM MESIN KASIR");
        top.setBounds(50, 10, 600, 50);
        top.setFont(new Font("Times New Roman",Font.BOLD,40));
        TampilanAwal.add(top);
        
        login = new JLabel("login");
        login.setBounds(100, 50, 100, 100);
        login.setFont(new Font("Times New Roman",Font.BOLD,30));
        TampilanAwal.add(login);
        
        labelkodelogin = new JLabel("Kode");
        labelkodelogin.setBounds(30, 180, 30, 30);
        TampilanAwal.add(labelkodelogin);
        textkodelogin = new JTextField();
        textkodelogin.setBounds(30, 210, 200, 30);
        TampilanAwal.add(textkodelogin);
        
        labelpasswordlogin = new JLabel("Password");
        labelpasswordlogin.setBounds(30, 240, 100, 30);
        TampilanAwal.add(labelpasswordlogin);
        
        passwordlogin = new JPasswordField();
        passwordlogin.setBounds(30, 270, 200, 30);
        TampilanAwal.add(passwordlogin);
        check = new JButton("check");
        check.setBounds(90, 320, 100, 40);
        check.setBackground(Color.GREEN);
        TampilanAwal.add(check);
        
        daftar = new JLabel("Buat Akun");
        daftar.setFont(new Font("Times New Roman",Font.BOLD,30));
        daftar.setBounds(440, 50, 150, 100);
        TampilanAwal.add(daftar);
        labelkodedaftar = new JLabel("Kode");
        labelkodedaftar.setBounds(400, 150, 30, 30);
        TampilanAwal.add(labelkodedaftar);
        
        textkodedaftar = new JTextField();
        textkodedaftar.setBounds(400, 180, 200, 30);
        TampilanAwal.add(textkodedaftar);
        
        labelnama = new JLabel("Nama");
        labelnama.setBounds(400, 210, 100, 30);
        TampilanAwal.add(labelnama);
        
        textnama = new JTextField();
        textnama.setBounds(400, 240, 200, 30);
        TampilanAwal.add(textnama);
        
        labelpassworddaftar = new JLabel("Password");
        labelpassworddaftar.setBounds(400, 270, 100, 30);
        TampilanAwal.add(labelpassworddaftar);
        
        passworddaftar = new JPasswordField();
        passworddaftar.setBounds(400, 300, 200, 30);
        TampilanAwal.add(passworddaftar);
        
        labelumur = new JLabel("Umur");
        labelumur.setBounds(400, 330, 100, 30);
        TampilanAwal.add(labelumur);
        
        textumur = new JTextField();
        textumur.setBounds(400, 360, 200, 30);
        TampilanAwal.add(textumur);

        reg = new JButton("Daftar");
        reg.setBounds(460, 520, 100, 40);
        reg.setBackground(Color.GREEN);
        TampilanAwal.add(reg);
        TampilanAwal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        TampilanAwal.setVisible(true);
        TampilanAwal.setLocationRelativeTo(null);
        check.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae){
                String kode = Aziq07163_Allobjctrl.admin.penjualEntity().getKode(); 
                String pass = Aziq07163_Allobjctrl.admin.penjualEntity().getPassword();
                if(kode.equals(textkodelogin.getText())&&kode.equals(passwordlogin.getText())){
                        JOptionPane.showMessageDialog(null, "Selamat datang "+kode,"information", JOptionPane.INFORMATION_MESSAGE);
                        Aziq07163_PenjualGUI pen = new Aziq07163_PenjualGUI();
                        TampilanAwal.dispose();
                        kosong();
                    }else{
                        JOptionPane.showMessageDialog(null, "Kode atau Password salah", "information", JOptionPane.INFORMATION_MESSAGE);                    
                        kosong();
                }
            }
        });
        reg.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae){
                try{
                    String kode = textkodedaftar.getText();
                    String pass = passworddaftar.getText();
                    String nama = textnama.getText();
                    String umur = textumur.getText();
                    Aziq07163_Allobjctrl.admin.insertPenjual(kode, pass, nama, umur);
                    JOptionPane.showMessageDialog(null, "Registrasi sukses", "information", JOptionPane.INFORMATION_MESSAGE);
                    kosong();
                }catch(Exception exception){
                    JOptionPane.showMessageDialog(null, "Format Penulisan Salah", "Registrasi Gagal", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        });
    }
    void kosong(){
        textkodedaftar.setText(null);
        passworddaftar.setText(null);
        textnama.setText(null);
        textumur.setText(null);
        textkodelogin.setText(null);
        passwordlogin.setText(null);
    }
}
