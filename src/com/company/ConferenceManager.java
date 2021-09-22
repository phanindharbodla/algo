package com.company;

import java.util.ArrayList;
import java.util.Collections;

public class ConferenceManager {
    private ArrayList<Conference> events = new ArrayList<>();
    private ArrayList<ArrayList<Conference>> tracks = new ArrayList<>();

    public ConferenceManager(ArrayList<String> input) {
        for (String str : input) {
            try {
                events.add(Conference.ConferenceBuilder.build(str));
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }
        }
    }

    public void pusblishSchedule() {
        int totalTime = 0;
        boolean[] markvisited = new boolean[events.size()];
        for (Conference event : events) {
            totalTime += event.duration;
        }
        int requiredTracks = (totalTime / 420) + 1;
        Collections.sort(events, (o1, o2) -> o1.duration - o2.duration);
        ArrayList<Conference> track = null;
        for (int i = 1; i <= requiredTracks; i++) {
            track = new ArrayList<>();
            vaildTrack(events, 180, markvisited, track); // morning time
            vaildTrack(events, 240, markvisited, track); // post lunch time
            tracks.add(track);
        }

        for (int i = 0; i < tracks.size(); System.out.println(), i++)
            for (int j = 0; j <= tracks.get(i).size(); j++)
                System.out.println(tracks.get(i).get(j));

    }

    private void vaildTrack(ArrayList<Conference> events, int totalTime, boolean[] markvisited, ArrayList<Conference> track) {
        for (int i = 0; i < events.size(); i++) {
            if (!markvisited[i] && totalTime > 0) {
                totalTime -= events.get(i).duration;
                track.add(events.get(i));
                markvisited[i] = true;
            }
        }
    }
}
