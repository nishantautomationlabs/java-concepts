package com.nal.copyconstructor;

/**
 * Created by Nishant on 02-11-2018.
 */
public class Weapon {

    private String name;
    private String type;
    private String bullet;

    public Weapon(Weapon copy) {
        this.name = copy.name;
        this.type = copy.type;
        this.bullet = copy.bullet;
    }

    public Weapon(String name, String type, String bullet) {
        this.name = name;
        this.type = type;
        this.bullet = bullet;
    }

    public Weapon() {

    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public String getBullet() {
        return bullet;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setBullet(String bullet) {
        this.bullet = bullet;
    }
}
