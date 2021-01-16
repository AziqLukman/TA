package Aziq07163_Entity;

public class Aziq07163_DaftarbarangEntity {
    private Aziq07163_PembeliEntity pembeli;
    private int IndexBarang;
    private boolean isVerified;
    private int pilBar;

    public Aziq07163_DaftarbarangEntity(int IndexBarang, Aziq07163_PembeliEntity pembeli,boolean isVerified) {
        this.pembeli = pembeli;       
        this.IndexBarang = IndexBarang;
        this.isVerified = isVerified;
    }

    public Aziq07163_DaftarbarangEntity(Aziq07163_PembeliEntity pembeliEntityArrayList, int pilBar) {
        this.pembeli = pembeliEntityArrayList;
        this.pilBar = pilBar;
    }


    public Aziq07163_PembeliEntity getPembeli() {
        return pembeli;
    }

    public void setPembeli(Aziq07163_PembeliEntity pembeli) {
        this.pembeli = pembeli;
    }

    public int getIndexBarang() {
        return IndexBarang;
    }

    public void setIndexBarang(int IndexBarang) {
        this.IndexBarang = IndexBarang;
    }

    public boolean isVerified() {
        return isVerified;
    }

    public void setisVerified(boolean isVerified) {
        this.isVerified = isVerified;
    }
}

