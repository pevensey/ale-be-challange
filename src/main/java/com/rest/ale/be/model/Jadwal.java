package com.rest.ale.be.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.DataInput;
import java.io.IOException;
import java.io.Serializable;
import java.util.List;
import java.util.Set;


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

    @Column(name = "fk_kelas")
    private long fk_kelas;

    public Jadwal() {
        super();
    }

    public Jadwal(@JsonProperty("kelas")long fk_kelas, @JsonProperty("ruang")String ruang,@JsonProperty("waktu")String waktu) {
        this.fk_kelas = fk_kelas;
        this.ruang = ruang;
        this.waktu = waktu;
    }

    @Column(name="ruangan")
    private String ruang;

    @Column(name="waktu")
    private String waktu;

    public Jadwal(Jadwal jadwalBaru) {
    }

    public long getIdJadwal() {
        return idJadwal;
    }

    public void setIdJadwal(long idJadwal) {
        this.idJadwal = idJadwal;
    }

    public long getFk_kelas() {
        return fk_kelas;
    }

    public void setFk_kelas(long fk_kelas) {
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
}
