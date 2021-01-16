package Aziq07163_Entity;

public abstract class Aziq07163_TokoAbstractEntity {
    public String kode,nama;
    public String password;

    public Aziq07163_TokoAbstractEntity(String kode, String password, String nama) {
        this.kode = kode;
        this.password = password;
        this.nama = nama;
    }
    public Aziq07163_TokoAbstractEntity(){

}
    public abstract String getKode();
  
    public void setKode(String kode) {
        this.kode = kode;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }   
}

