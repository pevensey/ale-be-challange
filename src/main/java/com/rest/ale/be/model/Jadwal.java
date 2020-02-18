package com.rest.ale.be.model;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "jadwal")
@EntityListeners(AuditingEntityListener.class)
public class Jadwal {
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

//    @JsonDeserialize
    @OneToOne
    @JoinColumn(name="id_kelas", referencedColumnName = "id_kelas") //foreign key
    private Kelas id_kelas;


    @Column(name="ruangan")
    private String ruang;

    @Column(name="waktu")
    private String waktu;

    public long getIdJadwal() {
        return idJadwal;
    }

    public void setIdJadwal(long idJadwal) {
        this.idJadwal = idJadwal;
    }

    public Kelas getIdKelas() {
        return (Kelas) id_kelas;
    }

    public void setIdKelas(Kelas idKelas) {
        this.id_kelas = (Kelas) idKelas;
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
}
