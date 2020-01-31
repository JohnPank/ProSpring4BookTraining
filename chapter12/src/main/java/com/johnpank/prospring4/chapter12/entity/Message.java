package com.johnpank.prospring4.chapter12.entity;

import com.johnpank.prospring4.chapter12.config.DBContract;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = DBContract.JOURNAL_TABLE_NAME)
public class Message {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = DBContract.ROW_ID)
    private long id;

    @Column(name = DBContract.ROW_WORKER_ID)
    private long workerId;

    @Column(name = DBContract.ROW_STATUS)
    private String status;

    @Column(name = DBContract.ROW_MESSAGE)
    private String message;

    @Column(name = DBContract.ROW_DATE_TIME)
    private Date date_time;


    public void setId(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public void setWorkerId(long row_worker_id) {
        this.workerId = row_worker_id;
    }

    public long getWorkerId() {
        return workerId;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setDate_time(Date date_time) {
        this.date_time = date_time;
    }

    public Date getDate_time() {
        return date_time;
    }
}
