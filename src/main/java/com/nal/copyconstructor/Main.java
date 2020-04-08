package com.nal.copyconstructor;

import java.util.*;

/**
 * Created by Nishant on 02-11-2018.
 */
public class Main {

    public static void main(String[] args)
    {
        Weapon weapon = new Weapon("machineGun", "Gun", ".65");
        Tool tool1 = new Tool("knife", "addon");
        Tool tool2 = new Tool("torch", "accessories");
        Belt belt = new Belt();
        belt.tools = new ArrayList<>();
        belt.tools.add(tool1);
        belt.tools.add(tool2);
        Ninja ninja = new Ninja("Nancy", 100, weapon, belt);

        Ninja newNinja = new Ninja(ninja);

        newNinja.setName("Gracy");
        newNinja.getWeapon().setBullet(".75");
        newNinja.getBelt().tools.remove(0);

        System.out.println("Ninja 1");
        System.out.println(ninja.getName());
        System.out.println(ninja.getHitPoints());
        System.out.println(ninja.getWeapon().getName());
        System.out.println(ninja.getWeapon().getBullet());
        System.out.println(ninja.getWeapon().getType());
        for (Tool tool: ninja.getBelt().tools)
        {
            System.out.println(tool.getName());
            System.out.println(tool.getType());
        }

        System.out.println("Ninja 2");
        System.out.println(newNinja.getName());
        System.out.println(newNinja.getHitPoints());
        System.out.println(newNinja.getWeapon().getName());
        System.out.println(newNinja.getWeapon().getBullet());
        System.out.println(newNinja.getWeapon().getType());
        for (Tool tool: newNinja.getBelt().tools)
        {
            System.out.println(tool.getName());
            System.out.println(tool.getType());
        }
    }
}
