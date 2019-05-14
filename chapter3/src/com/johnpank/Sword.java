package com.johnpank;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service("weapon")
public class Sword implements Weapon{
    private int maxDamage;
    private int minDamage;
    private int damage;

    public Sword(@Value("5") int minDamage, @Value("10") int maxDamage){
        this.maxDamage = maxDamage;
        this.minDamage = minDamage;
        damage = (new Random().nextInt((maxDamage - minDamage) + 1)) + minDamage;
    }

    public int getMaxDamage() {
        return maxDamage;
    }

    public void setMaxDamage(int maxDamage) {
        this.maxDamage = maxDamage;
    }

    public int getMinDamage() {
        return minDamage;
    }

    public void setMinDamage(int minDamage) {
        this.minDamage = minDamage;
    }

    public int getWeaponDamage() {
        return damage;
    }

    public String getSummary() {
        return "Simple iron sword with " + damage + " damage";
    }
}
