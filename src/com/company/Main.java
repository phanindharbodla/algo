package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = "";
        ArrayList<String> input = new ArrayList<>();
        while (!str.equals("end")) {
            str = br.readLine();
            input.add(str);
        }
        input.remove(input.size() - 1);
        ConvertionManager.getInstance().registerNewUnit("lightning", 5);
        ConferenceManager pr = new ConferenceManager(input);
        pr.pusblishSchedule();

    }
}