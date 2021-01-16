package Aziq07163_Model;

import Aziq07163_Entity.Aziq07163_PenjualEntity;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class Aziq07163_PenjualModel implements Aziq07163_ModelInterfaces{
    private ArrayList<Aziq07163_PenjualEntity> penjualEntityArrayList;
    
public Aziq07163_PenjualModel(){
    penjualEntityArrayList = new ArrayList<Aziq07163_PenjualEntity>();
}
    public void insertPenjual(Aziq07163_PenjualEntity penjual){
        penjualEntityArrayList.add(penjual);
    }
    @Override
public void view(){
    for(Aziq07163_PenjualEntity penjualEntity : penjualEntityArrayList){
        System.out.println(penjualEntity.getKode());
        System.out.println(penjualEntity.getNama());
        System.out.println(penjualEntity.getPassword());
        System.out.println(penjualEntity.getUmur());
        System.out.println();
    }
}
@Override
public int cekData(String kode, String password){
    int loop = 0;
    for(Aziq07163_PenjualEntity penjualEntity : penjualEntityArrayList){
        if(penjualEntity.getKode().equals(kode) && penjualEntity.getPassword().equals(password)){
            break;
        }else{
            loop++;
        }
    }return loop;
}
public Aziq07163_PenjualEntity PenjualEntityArrayList(int index){
    return penjualEntityArrayList.get(index);
    }
}
