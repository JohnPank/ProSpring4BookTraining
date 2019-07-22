package com.johnpank.chapter6;

public class MorrowindNPC {
    private int id;
    private String name;
    private String race;
    private int friendly;

    public int getId(int anInt) {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRace() {
        return race;
    }

    public void setRace(String race) {
        this.race = race;
    }

    public int getFriendly() {
        return friendly;
    }

    public void setFriendly(int friendly) {
        this.friendly = friendly;
    }

    @Override
    public String toString() {
        return "MorrowindNPC{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", race='" + race + '\'' +
                ", friendly=" + friendly +
                '}';
    }
}
