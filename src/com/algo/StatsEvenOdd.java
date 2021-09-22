package com.algo;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

public class StatsEvenOdd {
    public static void main(String[] args) throws java.lang.Exception {
        Scanner in = new Scanner(System.in);

        String s = in.nextLine();
        ArrayList<Integer> countq = new ArrayList<Integer>();
        ArrayList<Integer> sumq = new ArrayList<Integer>();
        int sum = 0, count = 0, mod = 0, temp = 0, prevMod = -1;
        StringTokenizer st1 = new StringTokenizer(s, ",");
        while (st1.hasMoreTokens()) {
            temp = Integer.parseInt(st1.nextToken());
            mod = temp % 2;
            if (mod == prevMod) {
                sum += temp;
                count++;
            } else {
                countq.add(count);
                sumq.add(sum);
                sum = temp;
                count = 1;
            }
            prevMod = mod;
        }
        countq.add(count);
        sumq.add(sum);
        countq.remove(0);
        sumq.remove(0);
        String countstr = countq.toString().replace(", ", ",").replace('[', ' ').replace(']', ' ').trim();
        String sumstr = sumq.toString().replace(", ", ",").replace('[', ' ').replace(']', ' ').trim();
        System.out.println(countstr);
        System.out.println(sumstr);
    }
}
