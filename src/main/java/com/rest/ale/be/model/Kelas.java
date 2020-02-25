package com.rest.ale.be.model;


import com.fasterxml.jackson.annotation.JsonManagedReference;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
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
    private long id_kelas;

//    @NotBlank(message = "tidak bisa kosong")
    @Column(name="matkul")
    private String matkul;

//    @NotBlank
    @Column(name="dosen")
    private String dosen; //fk?

    @OneToMany(
            mappedBy = "fk_kelas",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )

    private List<Jadwal> jadwals = new ArrayList<>();

    @OneToMany(
            mappedBy = "fk_kelas",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    @JsonManagedReference
    private List<Enroll> enroll = new ArrayList<>();
    public Kelas() {

    }

    public Kelas(List<Jadwal> jadwals) {
        this.jadwals = jadwals;
    }

    public Kelas(Long kelas) {
        this.id_kelas=kelas;
    }

    public long getId_kelas() {
        return id_kelas;
    }

    public void setId_kelas(long id_kelas) {
        this.id_kelas = id_kelas;
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
}

