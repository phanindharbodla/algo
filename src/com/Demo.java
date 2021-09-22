package com;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Demo {


    public static void main(String[] args) {
        Object object;
        HashMap<Shop, Integer> map = new HashMap<>();

        Shop shop1 = new Shop(2, 4);
        Shop shop2 = new Shop(1, 5);

        List<Shop> shops = Arrays.asList(new Shop[]{shop1, shop2});


        int i = 1;

        for (Shop shop : shops) {
            map.putIfAbsent(shop, i++);
        }


        System.out.println(map.size());
        System.out.println(shop1);
        System.out.println(shop2);
    }
}

class Shop {
    int num;
    int num2;

    public Shop(int num, int num2) {
        this.num = num;
        this.num2 = num2;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Shop shop = (Shop) o;
        return num + num2 ==
                shop.num2 + shop.num;
    }

    @Override
    public int hashCode() {
        return num + num2;
    }
}