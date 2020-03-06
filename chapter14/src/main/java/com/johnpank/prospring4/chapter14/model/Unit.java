package com.johnpank.prospring4.chapter14.model;

public class Unit {
    private String name;
    private int armor;
    private int attack;
    private int speed;
    private String category;

    public Unit(String name, int armor, int attack, int speed, String category) {
        this.name = name;
        this.armor = armor;
        this.attack = attack;
        this.speed = speed;
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getArmor() {
        return armor;
    }

    public void setArmor(int armor) {
        this.armor = armor;
    }

    public int getAttack() {
        return attack;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return "Unit{" +
                "name='" + name + '\'' +
                ", armor=" + armor +
                ", attack=" + attack +
                ", speed=" + speed +
                ", category='" + category + '\'' +
                '}';
    }
}
