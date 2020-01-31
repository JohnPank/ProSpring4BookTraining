package com.johnpank.prospring4.chapter12.entity;

public enum WorkerStatus {

    READY("Ready"),
    DRIVE("Drive"),
    ARRIVAL("Arrival"),
    ACCESS("Access"),
    WORK_COMPLETE("Work complete"),
    ON_BASE("On base"),
    CAR_ERROR("Car error"),
    SOS("SOS");

    private String title;

    WorkerStatus(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    @Override
    public String toString() {
        return title;
    }
}
