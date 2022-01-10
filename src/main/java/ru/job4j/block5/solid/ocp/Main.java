package ru.job4j.block5.solid.ocp;


public class Main {
    public static void main(String[] args) {
        Weapon sword = new Weapon("sword", 15, 2);
        Unit knight = new Unit("knight", sword);
        knight.attack();
        Weapon crossbow = new Weapon("crossbow", 40, 100);
        knight.changeWeapon(crossbow);
        knight.attack();
    }
}

/**
 *  Класс Weapon нарушает принцип OCP
 *  При добавленнии нового оржия, нужно будет менять
 *  логику логику в методе attack
 */
class Weapon {
    String type;
    int domage;
    int range;

    public Weapon(String type, int domage, int range) {
        this.type = type;
        this.domage = domage;
        this.range = range;
    }

    void attack() {
        System.out.println("domage sword :" + this.domage);
    }
}


class Unit {
    String name;
    Weapon weapon;

    public Unit(String name, Weapon weapon) {
        this.name = name;
        this.weapon = weapon;
    }

    public void changeWeapon(Weapon newWeapon) {
        this.weapon = newWeapon;
    }

    void attack() {
        weapon.attack();
    }
}
