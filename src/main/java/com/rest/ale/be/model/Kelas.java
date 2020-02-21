package com.rest.ale.be.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import org.hibernate.annotations.GenericGenerator;
import org.junit.Test;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.sql.Time;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;


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

    @NotBlank
    @Column(name="matkul")
    private String matkul;

    @NotBlank
    @Column(name="dosen")
    private String dosen; //fk?

    @OneToMany
    @JoinColumn(name="fk_kelas", referencedColumnName="id_kelas")
    private Set<Jadwal> jadwals ;


    public Kelas() {
        super();
    }

    public Kelas(Set<Jadwal> jadwals) {
        this.jadwals = jadwals;
    }
    public Kelas(Long kelas) {
        this.id_kelas=kelas;
    }

    @JsonCreator
    public Kelas( @NotBlank String matkul, @NotBlank String dosen) {
        this.matkul = matkul;
        this.dosen = dosen;
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


}

