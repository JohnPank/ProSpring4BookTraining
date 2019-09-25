package com.johnpank.chapter10.model;


import org.joda.time.DateTime;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Mobilka {

    @NotNull
    @Size(min = 5, max = 20)
    private String vendor;

    @NotNull
    private String model;

    private DateTime release;

    public Mobilka() {

    }

    public Mobilka(String vendor, String model, DateTime release) {
        this.vendor = vendor;
        this.model = model;
        this.release = release;
    }

    public String getVendor() {
        return vendor;
    }

    public void setVendor(String vendor) {
        this.vendor = vendor;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public DateTime getRelease() {
        return release;
    }

    public void setRelease(DateTime release) {
        this.release = release;
    }

    @Override
    public String toString() {
        return "Mobilka{" +
                "vendor='" + vendor + '\'' +
                ", model='" + model + '\'' +
                ", release=" + release +
                '}';
    }
}
