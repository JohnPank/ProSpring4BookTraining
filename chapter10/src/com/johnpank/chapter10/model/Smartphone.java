package com.johnpank.chapter10.model;

import org.joda.time.DateTime;

import javax.validation.constraints.AssertTrue;

public class Smartphone {
    private String vendor;
    private String model;
    private DateTime release;
    private int androidVerAPI;

    public Smartphone() {

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

    public int getAndroidVerAPI() {
        return androidVerAPI;
    }

    public void setAndroidVerAPI(int androidVerAPI) {
        this.androidVerAPI = androidVerAPI;
    }

    @AssertTrue(message = "This is no Android smartphone")
    public boolean isAndroidSmartphone(){
        if(androidVerAPI == 0){
            return false;
        }else {
            return true;
        }
    }

    @Override
    public String toString() {
        return "Smartphone{" +
                "vendor='" + vendor + '\'' +
                ", model='" + model + '\'' +
                ", release=" + release +
                ", androidVerAPI=" + androidVerAPI +
                '}';
    }
}
