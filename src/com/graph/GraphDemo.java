package com.graph;

import java.util.AbstractMap.SimpleEntry;
import java.util.Arrays;
import java.util.Stack;

public class GraphDemo {

    public static void main(String[] args) {
        Graph g1 = new Graph(5);
        g1.addEdge(1, 0);
        g1.addEdge(0, 2);
        g1.addEdge(0, 3);
        g1.addEdge(3, 4);
        if (g1.TS())
            System.out.println("Graph is Tree");
        else
            System.out.println("Graph is not Tree");

        Graph g2 = new Graph(5, true);
        g2.addEdge(1, 0);
        g2.addEdge(0, 2);
        g2.addEdge(2, 1);
        g2.addEdge(0, 3);
        g2.addEdge(3, 4);

        if (g2.TS())//if (isTree(g2))
            System.out.println("Graph is Tree");
        else
            System.out.println("Graph is not Tree");


    }

    // if graph is having no cycle and strongly connected then its tree
    // works on principle If an adjacent is visited and not parent of
    // current vertex, then there is a cycle
    public static boolean isTree(Graph g1) {
        Stack<SimpleEntry<Integer, Integer>> stack = new Stack<SimpleEntry<Integer, Integer>>();
        boolean[] visited = new boolean[g1.V];
        stack.push(new SimpleEntry<Integer, Integer>(0, -1));// tracking parent
        while (!stack.empty()) {
            SimpleEntry<Integer, Integer> top = stack.pop();
            visited[top.getKey()] = true;
            for (int i : g1.adj[top.getKey()]) {
                if (!visited[i])
                    stack.push(new SimpleEntry<Integer, Integer>(i, top.getKey()));
                else if (top.getValue() != i)// non parent visited node
                    return false;
            }
        }
        return !Arrays.asList(visited).contains(false);
    }
}