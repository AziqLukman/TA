package Aziq07163_Controller;

import Aziq07163_Entity.Aziq07163_DaftarbarangEntity;
import Aziq07163_Entity.Aziq07163_PembeliEntity;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

public class Aziq07163_PembeliController implements Aziq07163_ControllerInterface{

    int index = 0;
    
    public Aziq07163_PembeliController() {
    }
    
    public Aziq07163_PembeliEntity getData(){
        return Aziq07163_AllObjectModel.pembeliModel.getPembeliEntityArrayList(index);
    }

    public void daftarbarang(Aziq07163_PembeliEntity pembeli, int IndexBarang,boolean isVerified){
        Aziq07163_AllObjectModel.daftarBarang.insertDataDaftarbarang(new Aziq07163_DaftarbarangEntity(IndexBarang,pembeli,isVerified));
    }
    
    public void remove(int carikode){
        Aziq07163_AllObjectModel.pembeliModel.remove(carikode);
    }

    @Override
    public void login(String kode, String password){
        index = Aziq07163_AllObjectModel.pembeliModel.cekData(kode, password);
    }    
    
    public void insert(String kode, String password,String nama, String alamat){
        Aziq07163_AllObjectModel.pembeliModel.insert(new Aziq07163_PembeliEntity(kode,password,nama,alamat));
    }
    
    public Aziq07163_PembeliEntity PembeliEntity(){
        return Aziq07163_AllObjectModel.pembeliModel.getPembeliEntityArrayList(index);
    }
    
    public int cekDaftarbarang (String kode){
        int cek = Aziq07163_AllObjectModel.daftarBarang.cekData(kode, null);
        return cek;
    }
    
    public Aziq07163_DaftarbarangEntity showDaftarbarang (int index){
        return Aziq07163_AllObjectModel.daftarBarang.showDaftarbarang(index);
    }

    public DefaultTableModel daftarBarang(){
        DefaultTableModel dtmdaftarbarang = new DefaultTableModel();//object  dtmdaftarprak
        Object[] kolom ={"Kode","Nama","Password","Alamat","Barang","Verified"};
        dtmdaftarbarang.setColumnIdentifiers(kolom);
        int size = Aziq07163_AllObjectModel.daftarBarang.alldatabarang().size();
        String verif = null;
        for(int i=0;i<size;i++){
            if(Aziq07163_AllObjectModel.daftarBarang.alldatabarang().get(i).isVerified()==false){
                verif = "Belum Dilayani";
            }else{
                verif = "Sudah Dilayani";
            }
            Object [] data = new Object[6];
            data[0] = Aziq07163_AllObjectModel.daftarBarang.alldatabarang().get(i).getPembeli().getKode();
            data[1] = Aziq07163_AllObjectModel.daftarBarang.alldatabarang().get(i).getPembeli().getNama();
            data[2] = Aziq07163_AllObjectModel.daftarBarang.alldatabarang().get(i).getPembeli().getPassword();
            data[3] = Aziq07163_AllObjectModel.daftarBarang.alldatabarang().get(i).getPembeli().getAlamat();
            data[4] = Aziq07163_AllObjectModel.daftarBarang.alldatabarang().get(i).getIndexBarang();
            data[5] = verif;
            dtmdaftarbarang.addRow(data);
        }
        return dtmdaftarbarang;
    }
    
    public Aziq07163_PembeliEntity getData(int index){
        return Aziq07163_AllObjectModel.pembeliModel.getPembeliEntityArrayList(index);
    }

    public int size() {
        return Aziq07163_AllObjectModel.pembeliModel.size();
    }

    public void deleteData(int index) {
        Aziq07163_AllObjectModel.pembeliModel.remove(index);
    }

    public void setKode(int index,int update, String text) {
        Aziq07163_AllObjectModel.pembeliModel.editKode(index,update, text);
    }

    public void setPassword(int index,int update, String pass) {
        Aziq07163_AllObjectModel.pembeliModel.editPassword(index,update, pass);
    }

    public void setKode(int index, String text) {
        Aziq07163_AllObjectModel.pembeliModel.editKode(index,text);
    }

    public void setPassword(int index, String text) {
       Aziq07163_AllObjectModel.pembeliModel.editKode(index, text);
    }

}