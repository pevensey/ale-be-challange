package com.rest.ale.be.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalTime;

@Entity
@Table(name = "enroll")
@EntityListeners(AuditingEntityListener.class)
public class Enroll implements Serializable {
    @Id
    @GeneratedValue(
            strategy= GenerationType.AUTO,
            generator="native"
    )
    @GenericGenerator(
            name = "native",
            strategy = "native"
    )

    @Column(name="id_enroll")
    private long idEnroll;

    @ManyToOne(
            fetch = FetchType.LAZY
    )
    @JsonBackReference
    @JsonIgnore
    @JoinColumn(name = "kelas_id_kelas")
    private Kelas fk_kelas;

    @ManyToOne(
            fetch = FetchType.LAZY
    )
    @JsonBackReference
    @JsonIgnore
    @JoinColumn(name = "kelas_id_akun")
    private Akun fk_akun;

    public Enroll(){

    }

    public long getIdEnroll() {
        return idEnroll;
    }

    public void setIdEnroll(long idEnroll) {
        this.idEnroll = idEnroll;
    }

    @JsonIgnore
    public Kelas getFk_kelas() {
        return fk_kelas;
    }

    @JsonIgnore
    public void setFk_kelas(Kelas fk_kelas) {
        this.fk_kelas = fk_kelas;
    }

    @JsonIgnore
    public Akun getFk_akun() {
        return fk_akun;
    }

    @JsonIgnore
    public void setFk_akun(Akun fk_akun) {
        this.fk_akun = fk_akun;
    }

    //method yang digunakan untuk fetch data Kelas
    public String getMatkul(){
        return fk_kelas.getMatkul();
    }
    public String getDosen (){
        return fk_kelas.getDosen();
    }

    //method yang digunakan untuk fetch data Akun
    public String getNama(){
        return fk_akun.getNama();
    }
    public String getRole (){
        return fk_akun.getRole();
    }
}
