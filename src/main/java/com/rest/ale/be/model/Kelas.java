package com.rest.ale.be.model;


import com.fasterxml.jackson.annotation.JsonManagedReference;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;



@Entity
@Table(name = "kelas")
@EntityListeners(AuditingEntityListener.class)
public class Kelas implements Serializable{
    @Id
    @GeneratedValue(
            strategy= GenerationType.AUTO,
            generator="native"
    )
    @GenericGenerator(
            name = "native",
            strategy = "native"
    )
    @Column(name="id_kelas")
    private long idKelas;

    @Column(name="matkul")
    private String matkul;

    @Column(name="dosen")
    private String dosen; //fk?

    @OneToMany(
            mappedBy = "fk_kelas",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )

    private List<Jadwal> jadwals = new ArrayList<>();

    @OneToMany(
            mappedBy = "fkKelas",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )

    private List<Enroll> enroll = new ArrayList<>();

    @Column(nullable = false, updatable = false)
    @CreatedDate
    private java.util.Date createdAt;

    @Column(nullable = false)
    @LastModifiedDate
    private java.util.Date updatedAt;
    public Kelas() {

    }

    public Kelas(List<Jadwal> jadwals) {
        this.jadwals = jadwals;
    }

    public Kelas(Long kelas) {
        this.idKelas=kelas;
    }

    public long getIdKelas() {
        return idKelas;
    }

    public void setIdKelas(long id_kelas) {
        this.idKelas = id_kelas;
    }

    public String getMatkul() {
        return matkul;
    }

    public void setMatkul(String matkul) {
        this.matkul = matkul;
    }

    public String getDosen() {
        return dosen;
    }

    public void setDosen(String dosen) {
        this.dosen = dosen;
    }

    public List<Jadwal> getJadwals() {
        return jadwals;
    }

    public void setJadwals(List<Jadwal> jadwals) {
        this.jadwals = jadwals;
    }

    public List<Enroll> getEnroll() {
        return enroll;
    }

    public void setEnroll(List<Enroll> enroll) {
        this.enroll = enroll;
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

