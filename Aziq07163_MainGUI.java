package aziq07163_main;

import Aziq07163_Model.*;
import Aziq07163_Entity.*;
import Aziq07163_View.Aziq07163_GUI;
import java.util.Scanner;

public class Aziq07163_MainGUI {
    private static Aziq07163_PembeliModel pembeliModel = new Aziq07163_PembeliModel();
    private static Aziq07163_PenjualModel penjualModel = new Aziq07163_PenjualModel();
    private static Aziq07163_DaftarbarangModel daftarbarangModel = new Aziq07163_DaftarbarangModel();
    private static Scanner input = new Scanner(System.in);
    private static int pilBar ;
    static int cekpembeli;
    static int cekPenjual;
    public static void main(String[] args) {
        Aziq07163_GUI gui = new Aziq07163_GUI();
    }
    void pilihan(){
        int pilih = 0;
    do{
        System.out.println("Menu\n"+
                "1. Console\n"+
                "2. GUI\n"+
                "Masukkan Pilihan Anda : ");
        pilih = input.nextInt();

        switch (pilih){
            case 1:
                viewMenu();
                break;
            default:
                break;
        }
    }while (pilih!=3);
}

    void GUI(){
        Aziq07163_GUI gui = new Aziq07163_GUI();
    }

    void viewMenu(){
        int loop=0;
        do{
            System.out.println("Selamat Datang !! \n"+
                               "1. Login Penjual \n" +
                               "2. Daftar Penjual \n" +
                               "3. Stop \n" +
                               "Masukkan pilihan anda : ");
            int pilih = input.nextInt();
            if(pilih == 1){
                    loginPenjual();
            }else if(pilih == 2){
                registerPenjual();
            }else {
                break;
            }
    }while (loop!=3);
}
    
  static void registerPenjual(){
        System.out.print("Input Kode = ");
        String kode = input.next();
        System.out.print("Input Nama = ");
        String nama = input.next();
        System.out.print("Input Password = ");
        String pass = input.next();
        System.out.print("Input Umur = ");
        String umur = input.next();
        penjualModel.insertPenjual(new Aziq07163_PenjualEntity(kode,pass,nama,umur));
        System.out.println("Daftar Sukses!!");
       
}
  
  static void loginPenjual(){
      try{
         System.out.print("Kode = ");
         String kode = input.next();
         System.out.print("Password = ");
         String password = input.next();
         cekPenjual = penjualModel.cekData(kode, password);
         
         
         System.out.println(" \n Selamat Datang "+penjualModel.PenjualEntityArrayList(cekPenjual).getNama());
            System.out.println("========== Data Pembeli ==========");
         int pil;
    do{
            System.out.println("1. Create");
            System.out.println("2. View");
            System.out.println("3. Update");
            System.out.println("4. Remove");
            System.out.println("5. Exit");
            System.out.print("Pilih = ");
            pil = input.nextInt();
            switch(pil){
                case 1:
                    inputPembeli();
                    break;
                case 2:
                    view();
                    break;
                case 3:
                    System.out.print("Kode pembeli = ");
                    kode =input.next();
                    System.out.print("Password(lama)= ");
                    password=input.next();
                    update(kode,password);
                    break;
                case 4 :
                    System.out.print("Kode Pembeli = ");
                    kode=input.next();
                    System.out.print("Password = ");
                    password=input.next();
                    remove(kode,password);
                    break;
            }
        }while(pil!=5);
           
      
      }catch (Exception exception){
          System.out.println("Format Pengisian Salah!!");
      }
  }  
        static void inputPembeli(){
         
         System.out.print("Kode = ");
         String kode = input.next();
         System.out.print("Input Nama = ");
         String nama = input.next();
         System.out.print("Password = ");
         String password = input.next();
         System.out.print("Input Alamat = ");
        String alamat = input.next();
        pembeliModel.insert(new Aziq07163_PembeliEntity(kode,password,nama,alamat));
         cekpembeli = pembeliModel.cekData(kode, password);
         System.out.println("=============================");
         int cekBarang = daftarbarangModel.cekData(kode, password);
             System.out.println(" Pilih Barang Yang Di Beli ");
             daftarBarang();
             System.out.println("Nama = "+daftarbarangModel.showDaftarbarang(cekpembeli).getPembeli().getNama());
             System.out.println("Kode = "+daftarbarangModel.showDaftarbarang(cekpembeli).getPembeli().getKode());
             System.out.println("Password = "+daftarbarangModel.showDaftarbarang(cekpembeli).getPembeli().getPassword());
             System.out.println("Alamat = "+daftarbarangModel.showDaftarbarang(cekpembeli).getPembeli().getAlamat());
             System.out.println("Barang di beli = "+Aziq07163_BarangEntity.namaBarang[daftarbarangModel.showDaftarbarang(cekpembeli).getIndexBarang()]);
             System.out.println("Harga = "+Aziq07163_BarangEntity.harga[daftarbarangModel.showDaftarbarang(cekpembeli).getIndexBarang()]);
            
    }
        static void daftarBarang(){
            try{
        System.out.println("Pilihan Barang = ");
        for(int i=0;i<Aziq07163_BarangEntity.namaBarang.length;i++){
            System.out.println(i+". "+Aziq07163_BarangEntity.namaBarang[i]);         
        }    
            System.out.print("Pilih Barang = ");
            pilBar = input.nextInt();
            daftarbarangModel.insertDataDaftarbarang(new Aziq07163_DaftarbarangEntity(pilBar,pembeliModel.getPembeliEntityArrayList(cekpembeli),false ));       
            System.out.println("Sukses Memilih Barang!!");
            }catch (Exception exception){
          System.out.println("Format Pengisian Salah!!");
      }
}

        static void view(){
         for(int i=0;i<pembeliModel.size();i++){
                System.out.println("Kode pembeli = "+pembeliModel.getPembeliEntityArrayList(i).getKode());
                System.out.println("Password pembeli = "+pembeliModel.getPembeliEntityArrayList(i).getPassword());
                System.out.println("Nama pembeli = "+pembeliModel.getPembeliEntityArrayList(i).getNama());
                System.out.println("Alamat = "+pembeliModel.getPembeliEntityArrayList(i).getAlamat());
                System.out.println("Barang di beli = "+Aziq07163_BarangEntity.namaBarang[daftarbarangModel.showDaftarbarang(i).getIndexBarang()]);
                System.out.println("Harga = "+Aziq07163_BarangEntity.harga[daftarbarangModel.showDaftarbarang(i).getIndexBarang()]);               
         }
    }
       
    static void update(String kode, String password){
       String newpassword;
        for(int i=0;i<pembeliModel.size();i++)
        {
            if(kode.equals(pembeliModel.getPembeliEntityArrayList(i).getKode())&&password.equals(pembeliModel.getPembeliEntityArrayList(i).getPassword()))
            {
                System.out.print("PASSWORD BARU = ");
                newpassword=input.next();
                pembeliModel.getPembeliEntityArrayList(i).password=newpassword;
            }
            else if(i==pembeliModel.size()-1&&kode!=pembeliModel.getPembeliEntityArrayList(i).getKode()&& password!=pembeliModel.getPembeliEntityArrayList(i).getPassword()){
                System.out.println("kode atau password salah");}
        }
   }
    
    static void remove (String kode, String password){
        for(int i=0;i<pembeliModel.size();i++)
        {
            if(kode.equals(pembeliModel.getPembeliEntityArrayList(i).getKode())&&password.equals(pembeliModel.getPembeliEntityArrayList(i).getPassword()))
            {
            pembeliModel.remove(i);
            System.out.println("Data Sudah terhapus");
            break;
            }
            else if(i==pembeliModel.size()-1&&kode!=pembeliModel.getPembeliEntityArrayList(i).getKode()&& password !=pembeliModel.getPembeliEntityArrayList(i).getPassword()){
            System.out.println("kode atau password salah");
            }
        }
        }
}