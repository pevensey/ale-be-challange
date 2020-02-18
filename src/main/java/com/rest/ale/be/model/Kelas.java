package com.rest.ale.be.model;

import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Time;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "kelas")
@EntityListeners(AuditingEntityListener.class)
public class Kelas {
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

    @OneToOne(mappedBy="id_kelas", cascade = CascadeType.ALL)
    private Jadwal jadwal;


    public long getIdKelas() {
        return idKelas;
    }

    public void setIdKelas(long idKelas) {
        this.idKelas = idKelas;
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
}
