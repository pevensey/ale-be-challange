package com.rest.ale.be.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;



@Entity
@Table(name = "jadwal")
@EntityListeners(AuditingEntityListener.class)
public class Jadwal implements Serializable {
    @Id
    @GeneratedValue(
            strategy= GenerationType.AUTO,
            generator="native"
    )
    @GenericGenerator(
            name = "native",
            strategy = "native"
    )

    @Column(name="id_jadwal")
    private long idJadwal;


    @ManyToOne(
            fetch = FetchType.LAZY
    )
    @JsonIgnore
    @JoinColumn(name = "kelas_id_kelas")
    private Kelas fk_kelas;

    @Column(name="ruangan")
    private String ruang;

    @Column(name="waktu")
    private String waktu;

    public Jadwal() {

    }

    public Jadwal(Jadwal jadwalBaru) {
    }

    public long getIdJadwal() {
        return idJadwal;
    }

    public void setIdJadwal(long idJadwal) {
        this.idJadwal = idJadwal;
    }

    @JsonIgnore
    public Kelas getFk_kelas() {
        return fk_kelas;
    }

    @JsonIgnore
    public void setFk_kelas(Kelas fk_kelas) {
        this.fk_kelas = fk_kelas;
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

    //method yang digunakan untuk fetch data Kelas
    public String getMatkul(){
        return fk_kelas.getMatkul();
    }
    public String getDosen (){
        return fk_kelas.getDosen();
    }

}
