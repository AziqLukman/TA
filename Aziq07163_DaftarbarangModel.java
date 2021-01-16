package Aziq07163_Model;

import Aziq07163_Entity.Aziq07163_DaftarbarangEntity;
import Aziq07163_Entity.Aziq07163_BarangEntity;
import java.text.ParseException;
import java.util.ArrayList;

public class Aziq07163_DaftarbarangModel implements Aziq07163_ModelInterfaces{
    private ArrayList<Aziq07163_DaftarbarangEntity> daftarbarangArrayList;
    public Aziq07163_DaftarbarangModel(){
        daftarbarangArrayList = new ArrayList<Aziq07163_DaftarbarangEntity>();
    }
    public void insertDataDaftarbarang(Aziq07163_DaftarbarangEntity daftarbarang){
        daftarbarangArrayList.add(daftarbarang);
    }
    public ArrayList<Aziq07163_DaftarbarangEntity> getDaftarbarangArrayList(){
        return daftarbarangArrayList;
    }
    
    public void view(){
        for(Aziq07163_DaftarbarangEntity daftarbarang : daftarbarangArrayList){
            System.out.println("===================================");
            System.out.println(" Kode : "+daftarbarang.getPembeli().getKode()+"\n Password : "+
                    daftarbarang.getPembeli().getPassword()+"\n Nama : "+daftarbarang.getPembeli().getNama()+"\n Alamat : "+daftarbarang.getPembeli().getAlamat()                    
                    +"\n Barang : "+Aziq07163_BarangEntity.namaBarang[daftarbarang.getIndexBarang()]);
            System.out.println("====================================");
        }
    }
    
    @Override
    public int cekData(String kode, String password){
        int loop = 0;
        if(daftarbarangArrayList.size()==0){
            loop = -1;
        }else{
        for(int i=0;i<daftarbarangArrayList.size();i++){
            if(daftarbarangArrayList.get(i).getPembeli().getKode().equals(kode)){
                loop = i;
                break;
            }else{
                loop = -2;
            }
            }
        }
        return loop;
    }
    public Aziq07163_DaftarbarangEntity showDaftarbarang(int index){
        return daftarbarangArrayList.get(index);
    }
    public void updateIsVerified(int index, Aziq07163_DaftarbarangEntity daftarbarangEntity){
        daftarbarangArrayList.set(index, daftarbarangEntity);
    }
    public ArrayList <Aziq07163_DaftarbarangEntity> alldatabarang(){
        return daftarbarangArrayList;
    }
}

