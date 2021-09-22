package com.demo;

public class CrossingCars {
    public static void main(String args[]) {
        //0 -> right, 1-> left find total pairs of cars that cross
        int[] cars = {0, 1, 0, 1, 1};
        System.out.println(solve(cars));
    }

    private static int solve(int[] cars) {
        int count = 0, carsgoingRight = 0;
        for (int i = 0; i < cars.length; i++) {
            if (cars[i] == 0) carsgoingRight++;
            else count += carsgoingRight;
        }
        return count;
    }
}
