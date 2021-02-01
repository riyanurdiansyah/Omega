package com.riyanurdiansyah.omega.model;

public class Penjualan {
    //tb staff
    int id_staf;
    String nama;

    //tb header
    int id_header;
    String tanggal;
    int staf_id;

    //tb detail
    int id_detail;
    int jumlah;
    int ph_id;

    public Penjualan(int id_staf, String nama, int id_header, String tanggal,
                     int staf_id, int id_detail, int jumlah, int ph_id) {
        this.id_staf = id_staf;
        this.nama = nama;
        this.id_header = id_header;
        this.tanggal = tanggal;
        this.staf_id = staf_id;
        this.id_detail = id_detail;
        this.jumlah = jumlah;
        this.ph_id = ph_id;
    }

    public int getId_staf() {
        return id_staf;
    }

    public void setId_staf(int id_staf) {
        this.id_staf = id_staf;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public int getId_header() {
        return id_header;
    }

    public void setId_header(int id_header) {
        this.id_header = id_header;
    }

    public String getTanggal() {
        return tanggal;
    }

    public void setTanggal(String tanggal) {
        this.tanggal = tanggal;
    }

    public int getStaf_id() {
        return staf_id;
    }

    public void setStaf_id(int staf_id) {
        this.staf_id = staf_id;
    }

    public int getId_detail() {
        return id_detail;
    }

    public void setId_detail(int id_detail) {
        this.id_detail = id_detail;
    }

    public int getJumlah() {
        return jumlah;
    }

    public void setJumlah(int jumlah) {
        this.jumlah = jumlah;
    }

    public int getPh_id() {
        return ph_id;
    }

    public void setPh_id(int ph_id) {
        this.ph_id = ph_id;
    }
}