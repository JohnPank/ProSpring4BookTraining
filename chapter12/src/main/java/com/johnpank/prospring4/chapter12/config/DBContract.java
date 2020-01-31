package com.johnpank.prospring4.chapter12.config;

public class DBContract {

    public static final String DB_NAME = "digital_RES_db";

    //workers
    public static final String WORKER_TABLE_NAME = "workers";
    public static final String WORKER_ID = "worker_id";
    public static final String WORKER_NAME = "name";
    public static final String WORKER_PASSWORD = "password";
    public static final String WORKER_QUALIFICATION = "qualification";
    public static final String WORKER_EMAIL = "email";
    public static final String WORKER_EXAM_DATE = "examdate";

    //journal
    public static final String JOURNAL_TABLE_NAME = "journal";
    public static final String ROW_ID = "row_id";
    public static final String ROW_WORKER_ID = "workerId";
    public static final String ROW_STATUS = "status";
    public static final String ROW_MESSAGE = "message";
    public static final String ROW_DATE_TIME = "date_time";

}

