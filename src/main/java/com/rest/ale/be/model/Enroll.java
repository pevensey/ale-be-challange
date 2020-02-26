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

    @JsonIgnore
    @JoinColumn(name = "kelas_id_kelas")
    private Kelas fkKelas;

    @ManyToOne(
            fetch = FetchType.LAZY
    )

    @JsonIgnore
    @JoinColumn(name = "akun_id_akun")
    private Akun fkAkun;

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
        return fkKelas;
    }

    @JsonIgnore
    public void setFk_kelas(Kelas fk_kelas) {
        this.fkKelas = fk_kelas;
    }

    @JsonIgnore
    public Akun getFk_akun() {
        return fkAkun;
    }

    @JsonIgnore
    public void setFk_akun(Akun fk_akun) {
        this.fkAkun = fk_akun;
    }

    //method yang digunakan untuk fetch data Kelas
    public String getMatkul(){
        return fkKelas.getMatkul();
    }
    public String getDosen (){
        return fkKelas.getDosen();
    }

    //method yang digunakan untuk fetch data Akun
    public String getNama(){
        return fkAkun.getNama();
    }
//    public String getRole (){
//        return fk_akun.getRole();
//    }
}
