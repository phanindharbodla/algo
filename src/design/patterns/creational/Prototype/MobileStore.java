package design.patterns.creational.Prototype;

import java.util.HashMap;

public class MobileStore {
    static HashMap<MobileType, OS> prototypes = new HashMap<>();

    static {
        loadMobiles();
    }


    public static OS getMobile(MobileType mobileType) {
        return (OS) prototypes.get(mobileType).clone();
    }

    public static void loadMobiles() {
        Apple a = new Apple();
        a.setBrand("Apple");
        a.setSeries("X");
        Andorid b = new Andorid();
        b.setBrand("Google");
        b.setSeries("Nexus");
        Windows c = new Windows();
        c.setBrand("Microsoft");
        c.setSeries("Lumia");
        prototypes.put(MobileType.IOS, a);
        prototypes.put(MobileType.ANDROID, b);
        prototypes.put(MobileType.WINDOWS, c);
    }
}
