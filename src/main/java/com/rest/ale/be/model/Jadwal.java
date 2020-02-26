package com.rest.ale.be.model;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;


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

    @Column(name = "hari")
    private String hari;

    @JsonFormat(pattern="HH:mm")
    @Column(name = "jam")
    private LocalTime jam;

    @Column(nullable = false, updatable = false)
    @CreatedDate
    private java.util.Date createdAt;

    @Column(nullable = false)
    @LastModifiedDate
    private java.util.Date updatedAt;
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

    public String getHari() {
        return hari;
    }

    public void setHari(String hari) {
        this.hari = hari;
    }

    public LocalTime getJam() {
        return jam;
    }

    public void setJam(LocalTime jam) {
        this.jam = jam;
    }

    //method yang digunakan untuk fetch data Kelas
    public String getMatkul(){
        return fk_kelas.getMatkul();
    }
    public String getDosen (){
        return fk_kelas.getDosen();
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }
}
