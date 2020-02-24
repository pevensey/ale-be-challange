package com.rest.ale.be.model;

public class LihatJadwal {
    private long id;
    private String ruang;
    private String waktu;
    private long fk;
    private String dosen;
    private String matkul;

    public LihatJadwal() {
    }

    public LihatJadwal(long id, String ruang, String waktu, long fk, String dosen, String matkul) {
        this.id = id;
        this.ruang = ruang;
        this.waktu = waktu;
        this.fk = fk;
        this.dosen = dosen;
        this.matkul = matkul;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getRuang() {
        return ruang;
    }

    public void setRuang(String ruang) {
        this.ruang = ruang;
    }

    public String getWaktu() {
        return waktu;
    }

    public void setWaktu(String waktu) {
        this.waktu = waktu;
    }

    public long getFk() {
        return fk;
    }

    public void setFk(long fk) {
        this.fk = fk;
    }

    public String getDosen() {
        return dosen;
    }

    public void setDosen(String dosen) {
        this.dosen = dosen;
    }

    public String getMatkul() {
        return matkul;
    }

    public void setMatkul(String matkul) {
        this.matkul = matkul;
    }
}
