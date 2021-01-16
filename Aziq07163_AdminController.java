package Aziq07163_Controller;

import Aziq07163_Entity.Aziq07163_BarangEntity;
import Aziq07163_Entity.Aziq07163_DaftarbarangEntity;
import Aziq07163_Entity.Aziq07163_PenjualEntity;
import Aziq07163_Entity.Aziq07163_PembeliEntity;

public class Aziq07163_AdminController implements Aziq07163_ControllerInterface{
    
    int IndexLogin = 0;
    
    public Aziq07163_AdminController() {
    }
    
    public void Aziq07163_BarangEntity(){
        String kodeBarang [] = {"01","02","03","04","05","06"};
        String passwordBarang [] = {"01","02","03","04","05","06"};
        String namaBarang [] = {"Bulpoin ","Pensil","Penghapus","Spidol","Penggaris","Buku Tulis"};
        String harga [] = {"3000","2000","1000","10000","4000","5000"};
        for(int i=0; i<kodeBarang.length; i++){
            Aziq07163_AllObjectModel.penjualModel.insertPenjual(new Aziq07163_PenjualEntity(kodeBarang[i],
                passwordBarang[i],namaBarang[i],harga[i]));
        }
    }
    
    public void viewBarang(){
        Aziq07163_AllObjectModel.penjualModel.view();
    }
    
    public void listDaftarPembeli(){
        Aziq07163_AllObjectModel.daftarBarang.view();
    }
    
    @Override
    public void login(String kode, String password){
        IndexLogin = Aziq07163_AllObjectModel.penjualModel.cekData(kode, password);
    }
    
    public void insertPenjual(String kode, String nama, String password, String umur){
        Aziq07163_AllObjectModel.penjualModel.insertPenjual(new Aziq07163_PenjualEntity(kode,nama,password,umur));
    }
    
    public void insertPembeli(String kode, String password, String nama,String alamat){
        Aziq07163_AllObjectModel.pembeliModel.insert(new Aziq07163_PembeliEntity(kode,password,nama,alamat));
    }
    
    public Aziq07163_PenjualEntity penjualEntity(){
        return Aziq07163_AllObjectModel.penjualModel.PenjualEntityArrayList(IndexLogin);
    }
    
    public Aziq07163_PembeliEntity pembeliEntity(){
        return Aziq07163_AllObjectModel.pembeliModel.getPembeliEntityArrayList(IndexLogin);
    }

    public void updateIsVerified(int index, int indexBarang, Aziq07163_PembeliEntity pembeli) {
        Aziq07163_AllObjectModel.daftarBarang.updateIsVerified(index,new Aziq07163_DaftarbarangEntity(indexBarang,pembeli,true));
    }

    public void updateisVerified(int index, Aziq07163_PembeliEntity pembeli) {
        int indexBarang = 0;
        Aziq07163_AllObjectModel.daftarBarang.updateIsVerified(index, new Aziq07163_DaftarbarangEntity(indexBarang,pembeli,true));
    }
}
