package Aziq07163_Model;

import Aziq07163_Entity.Aziq07163_PembeliEntity;
import java.util.ArrayList;

public class Aziq07163_PembeliModel implements Aziq07163_ModelInterfaces{
    private ArrayList<Aziq07163_PembeliEntity> PembeliEntityArrayList;
    
    public Aziq07163_PembeliModel(){
        PembeliEntityArrayList = new ArrayList<Aziq07163_PembeliEntity>();
    }
    public void insert(Aziq07163_PembeliEntity pembeliEntity){
        PembeliEntityArrayList.add(pembeliEntity);
    }
    public int size(){
        return PembeliEntityArrayList.size();
    }
    public void remove(int index){
        PembeliEntityArrayList.remove(index);
    }
    
    @Override
    public void view(){
        for(Aziq07163_PembeliEntity PembeliEntity : PembeliEntityArrayList){
            System.out.println("===========================================");
            System.out.println(" Kode : "+PembeliEntity.getKode()+"\n Nama : "+PembeliEntity.getNama()+"\n Password : "+PembeliEntity.getPassword()+"\n Alamat : "
            +PembeliEntity.getAlamat());
            System.out.println("===========================================");
        }
    }
    
    @Override
    public int cekData(String kode, String password){
        int loop = 0;
        while(!PembeliEntityArrayList.get(loop).getKode().equals(kode)&&!PembeliEntityArrayList.get(loop).getPassword().equals(password)){
            loop++;
        }
        return loop;
    }
    public void editKode(int update,int index, String data) {
        PembeliEntityArrayList.get(index).setKode(data);
    }
    public Aziq07163_PembeliEntity getPembeliEntityArrayList(int index){
        return PembeliEntityArrayList.get(index);
    }

    public void editPassword(int index, int update, String pass) {
        PembeliEntityArrayList.get(index).setKode(pass);
    }

    public void editKode(int index, String text) {
        PembeliEntityArrayList.get(index).setKode(text);
    }
    
    public ArrayList <Aziq07163_PembeliEntity> alldatabarang(){
        return PembeliEntityArrayList;
    }
}
