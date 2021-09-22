package com.company;

import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ConvertionManager {

    private static HashMap<String, Integer> validUnits = new HashMap<>();
    private static ConvertionManager ourInstance = new ConvertionManager();
    private String DEFAULT = "min";

    private ConvertionManager() {
        registerNewUnit(DEFAULT, 1);
    }

    public static ConvertionManager getInstance() {
        return ourInstance;
    }

    public void registerNewUnit(String unit, int time) {
        validUnits.put(unit, time);
    }

    public int getNormalizedUnit(String durationString) {
        Pattern p = Pattern.compile("[a-z]+|\\d+");
        Matcher m = p.matcher(durationString);
        int count = 0;
        String unit = "";
        if (m.find())
            count = Integer.parseInt(m.group());
        if (m.find())
            unit = m.group();
        //todo exception handling
        return this.validUnits.get(unit) * count;
    }
}
