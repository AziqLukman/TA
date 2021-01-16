
package Aziq07163_Entity;

public class Aziq07163_PenjualEntity extends Aziq07163_TokoAbstractEntity{
    private String umur;

    public Aziq07163_PenjualEntity(String kode, String nama, String password, String umur) {
        super(kode, nama, password);
        this.umur = umur;
    }
    
    @Override
    public String getKode(){
        return kode;
    }

    public String getUmur() {
        return umur;
    }

    public void setUmur(String umur) {
        this.umur = umur;
    }
}
