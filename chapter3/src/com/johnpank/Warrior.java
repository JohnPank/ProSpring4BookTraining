package com.johnpank;

public interface Warrior {
    int getDamage();
    Weapon getWeapon();
    void setWeapon(Weapon weapon);
    Armor getArmor();
    void setArmor(Armor armor);
    String move();
    String getSummary();
}
