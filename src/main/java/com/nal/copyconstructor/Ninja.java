package com.nal.copyconstructor;

import java.util.ArrayList;

/**
 * Created by Nishant on 02-11-2018.
 */
public class Ninja {

    private String name;
    private int hitPoints;
    private Weapon weapon;
    private Belt belt;

    public Ninja() {
    }

    //Constructor
    public Ninja(String name, int hitPoints, Weapon weapon, Belt belt) {
        this.name = name;
        this.hitPoints = hitPoints;
        this.weapon = weapon;
        this.belt = belt;
    }

    //Copy Constructor to copy one object to another
    public Ninja(Ninja copy) {
        this.name = copy.name;
        this.hitPoints = copy.hitPoints;
        this.weapon = new Weapon(copy.weapon);
        this.belt = new Belt();
        this.getBelt().tools = new ArrayList<>();
        for(Tool tool: copy.belt.tools)
        {
            this.belt.tools.add(new Tool(tool));
        }
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setHitPoints(int hitPoints) {
        this.hitPoints = hitPoints;
    }

    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }

    public void setBelt(Belt belt) {
        this.belt = belt;
    }

    public String getName() {
        return name;
    }

    public int getHitPoints() {
        return hitPoints;
    }

    public Weapon getWeapon() {
        return weapon;
    }

    public Belt getBelt() {
        return belt;
    }
}
