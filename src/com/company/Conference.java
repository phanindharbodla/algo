package com.company;

public class Conference {
    String title;
    int duration;
    String startTime;
    String durationString;

    public Conference(String title, String durationString, int duration) {
        this.title = title;
        this.duration = duration;
        this.durationString = durationString;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    @Override
    public String toString() {
        return startTime + " " + title + " " + durationString;
    }

    public static class ConferenceBuilder {
        public static Conference build(String disc) throws Exception {
            int lastSpace = disc.lastIndexOf(" ");
            int duration;
            if (lastSpace == -1)
                throw new Exception("InvalidTask");
            String title = disc.substring(0, lastSpace);
            String durationString = disc.substring(lastSpace + 1);
            try {
                duration = ConvertionManager.getInstance().getNormalizedUnit(durationString);
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
                throw new Exception("InvalidTask");
            }
            return new Conference(title, durationString, duration);
        }
    }
}
