package com.graph;

import java.util.Iterator;
import java.util.Stack;

public class StronglyConnectedComponents extends Graph {

    StronglyConnectedComponents(int v, boolean isDirected) {
        super(v, isDirected);
    }

    public static void main(String[] args) {
        StronglyConnectedComponents g = new StronglyConnectedComponents(5, true);
        g.addEdge(1, 0);
        g.addEdge(0, 2);
        g.addEdge(2, 1);
        g.addEdge(0, 3);
        g.addEdge(3, 4);

        g.printSCC();
    }

    private void printSCC() {
        boolean[] visited = new boolean[this.V];
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < this.get_vertices_count(); i++) {
            if (!visited[i])
                visit_childs(i, visited, stack);
        }
        visited = new boolean[V];
        StronglyConnectedComponents gt = getTranspose();
        Integer top;
        while (!stack.empty()) {
            top = stack.pop();
            if (!visited[top]) {
                gt.DFSUtil(top, visited);
                System.out.println();
            }
        }
    }


    public void DFSUtil(int i, boolean[] visited) {
        visited[i] = true;
        System.out.print(i + " ");
        for (int j : adj[i]) {
            if (!visited[j])
                DFSUtil(j, visited);
        }
    }

    private void visit_childs(int i, boolean[] visited, Stack<Integer> stack) {
        visited[i] = true;
        for (int j : this.adj[i])
            if (!visited[j])
                visit_childs(j, visited, stack);
        stack.push(i);
    }

    StronglyConnectedComponents getTranspose() {
        StronglyConnectedComponents g = new StronglyConnectedComponents(V, this.isDirected);
        for (int v = 0; v < V; v++) {
            Iterator<Integer> i = adj[v].listIterator();
            while (i.hasNext())
                g.adj[i.next()].add(v);
        }
        return g;
    }
}