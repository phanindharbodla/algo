package com;

import java.util.HashMap;
import java.util.HashSet;

public class Main {

    public static void main(String[] args) {

        HashSet<Integer> a = new HashSet();
        a.add(1);
        HashSet<Integer> b = new HashSet<>();
        b.remove(1);

        HashMap<Integer, HashSet<Integer>> graph = new HashMap<>();
        LivenStein.getInstance().costOf("dainello", "daniel");
        DAG.getInstance().isDAG(graph);
    }
}
