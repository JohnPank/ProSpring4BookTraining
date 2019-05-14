package com.johnpank;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import java.util.Random;

public class Shield implements Armor {
    private int maxArmor;
    private int minArmor;
    private int armor;

    public Shield(){
        //
    }

    public Shield(int minArmor, int maxArmor){
        this.maxArmor = maxArmor;
        this.minArmor = minArmor;
        armor = (new Random().nextInt((maxArmor - minArmor) + 1)) + minArmor;
    }

    public int getMaxArmor() {
        return maxArmor;
    }

    public void setMaxArmor(int maxArmor) {
        this.maxArmor = maxArmor;
    }

    public int getMinArmor() {
        return minArmor;
    }

    public void setMinArmor(int minArmor) {
        this.minArmor = minArmor;
    }





    public int getArmorDefense() {
        return armor;
    }

    public String getSummary() {
        return "Simple iron shield with " + armor + " defense";
    }
}
