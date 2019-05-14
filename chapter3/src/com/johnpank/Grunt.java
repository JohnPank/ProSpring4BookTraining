package com.johnpank;

import org.springframework.beans.factory.annotation.Autowired;

public class Grunt implements Warrior {
    private Weapon weapon;
    private Armor armor;
    private String name;
    private int force;
    private int smart;
    private int damage;
    private int protect;
    private int health;

    public Grunt(String name, int force, int smart){
        this.name = name;
        this.force = force;
        this.smart = smart;
        health = 100;
        damage = (int)force/10;
        protect = (int)smart/10;
    }

    public int getDamage() {
        return damage;
    }

    public Weapon getWeapon() {
        return this.weapon;
    }


    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
        damage = force + weapon.getWeaponDamage();
    }

    public Armor getArmor() {
        return armor;
    }

    @Autowired
    public void setArmor(Armor armor) {
        this.armor = armor;
        protect = smart + armor.getArmorDefense();

    }

    public String move() {
        return "I'm potopal";
    }

    public String getSummary() {
        return "Grunt name: " + name +
                "\nDamage: " + damage +
                "\nProtect: " + protect +
                "\nWeapon: " + weapon.getSummary() +
                "\nArmory: " +  armor.getSummary();
    }
}
