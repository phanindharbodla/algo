package com;

enum IceCream {
    //Vanilla(5),
    Chocolate(3),
    Strawberry(2);

    public final int scoops;

    IceCream(int scoops) {
        this.scoops = scoops;
    }
}

public class Test {
    public static void main(String[] args) {
        IceCream cone = IceCream.Chocolate;
        System.out.println("Name- " + cone.name() + " Scoops- " + cone.scoops + " Posotion- " + cone.ordinal());
    }
}
