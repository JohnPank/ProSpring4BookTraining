package com.johnpank.prospring4.chapter12.entity;

public enum WorkerQualifications {

    RAZR_2("2 razryad"),
    RAZR_3("3 razryad"),
    RAZR_4("4 razryad"),
    RAZR_5("5 razryad"),
    RAZR_6("6 razryad"),
    TECHNICIAN("Technician"),
    ENGINEER("Engineer"),
    ADMIN("Admin"),
    DISPATCHER("Dispatcer");


    private String qualifications;

    WorkerQualifications(String qualifications) {
        this.qualifications = qualifications;
    }

    public String getTitle() {
        return qualifications;
    }

    @Override
    public String toString() {
        return qualifications;
    }
}
