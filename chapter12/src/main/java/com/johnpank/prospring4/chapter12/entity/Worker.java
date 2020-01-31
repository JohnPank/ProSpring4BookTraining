package com.johnpank.prospring4.chapter12.entity;

import com.johnpank.prospring4.chapter12.config.DBContract;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = DBContract.WORKER_TABLE_NAME)
public class Worker {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = DBContract.WORKER_ID)
    private long id;

    @Column(name = DBContract.WORKER_NAME)
    private String name;

    @Column(name = DBContract.WORKER_PASSWORD)
    private String password;

    @Column(name = DBContract.WORKER_QUALIFICATION)
    private String qualification;

    @Column(name = DBContract.WORKER_EMAIL)
    private String email;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getQualification() {
        return qualification;
    }

    public void setQualification(String qualification) {
        this.qualification = qualification;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


}
