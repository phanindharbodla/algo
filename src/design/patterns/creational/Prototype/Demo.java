package design.patterns.creational.Prototype;

public class Demo {
    public static void main(String args[]) {

        Andorid andorid = (Andorid) MobileStore.getMobile(MobileType.ANDROID);
        andorid.info();
        andorid.installApps();
        System.out.println(andorid);
        System.out.println();

        Apple apple = (Apple) MobileStore.getMobile(MobileType.IOS);
        apple.info();
        apple.installApps();
        System.out.println(apple);
        System.out.println();

        Windows windows = (Windows) MobileStore.getMobile(MobileType.WINDOWS);
        windows.info();
        windows.installApps();
        System.out.println(windows);
        System.out.println();

        Andorid moto = (Andorid) MobileStore.getMobile(MobileType.ANDROID);
        moto.setBrand("Motorola");
        moto.setSeries("G");
        moto.info();
        moto.installApps();
        System.out.println(moto);
        System.out.println();

        // Prototype is used to avoid wasting time on creating complex objects
        // Idea is to create a registry of prototypes and map with an instance with default params
        // this is used to clone every time we need a new object and params are to be over ridden
    }
}
