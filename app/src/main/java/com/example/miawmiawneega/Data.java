package com.example.miawmiawneega;

public class Data {

    private String id, nama, alamat, tgl_lahir, pic;

    public Data(){

    }

    public Data(String id, String nama, String alamat, String tgl_lahir, String pic){
        this.id = id;
        this.nama = nama;
        this.alamat = alamat;
        this.tgl_lahir = tgl_lahir;
        this.pic = pic;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getTgl_lahir() {
        return tgl_lahir;
    }

    public void setTgl_lahir(String tgl_lahir) {
        this.tgl_lahir = tgl_lahir;
    }
}
