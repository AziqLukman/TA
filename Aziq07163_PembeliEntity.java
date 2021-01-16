
package Aziq07163_Entity;

public class Aziq07163_PembeliEntity extends Aziq07163_TokoAbstractEntity{
    private String alamat;

    public Aziq07163_PembeliEntity(String kode, String password, String nama,String alamat) {
        super(kode,password,nama);
        this.alamat = alamat;
        this.kode = kode;
        this.nama = nama;
    }
    
    @Override
    public String getKode(){
        return kode;
    }

    public String getPassword(){
        return password;
    }
    
    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }   
}
