package com.rest.ale.be.model;

import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "akun")
@EntityListeners(AuditingEntityListener.class)
public class Akun {
    @Id
    @GeneratedValue(
            strategy= GenerationType.AUTO,
            generator="native"
    )
    @GenericGenerator(
            name = "native",
            strategy = "native"
    )
    @Column(name="id_akun")
    private long idAkun;
    @Column(name="username")
    private String username;
    @Column
    private String password;
    @Column
    private String nama;

    private String role;
    @Column(nullable = false, updatable = false)
    @CreatedDate
    private java.util.Date createdAt;
    @Column(nullable = false)
    @LastModifiedDate
    private java.util.Date updatedAt;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
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
//    public boolean isRole() {
//        if (getRole() == Roles.DOSEN) {
//            return true;
//        }
//        return false;
//    }
}
