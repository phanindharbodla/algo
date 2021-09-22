package com;

import java.util.HashMap;
import java.util.HashSet;

public class DAG {
    private static DAG ourInstance = new DAG();

    private DAG() {
    }

    public static DAG getInstance() {
        return ourInstance;
    }

    public boolean isDAG(HashMap<Integer, HashSet<Integer>> graph) {

        HashSet<Integer> rootNodes = new HashSet<>();
        graph.forEach((k, v) -> {
            if (v.isEmpty())
                rootNodes.add(k);
        });


        return true;
    }
}
