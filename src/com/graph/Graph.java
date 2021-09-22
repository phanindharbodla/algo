package com.graph;


import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

class Graph {
    //https://www.hackerearth.com/practice/algorithms/graphs/
    public int V; // No. of vertices
    public boolean isDirected;
    public LinkedList<Integer>[] adj;

    Graph(int v, boolean isDirected) {
        V = v;
        this.isDirected = isDirected;
        adj = new LinkedList[v];
        for (int i = 0; i < v; ++i)
            adj[i] = new LinkedList<Integer>();
    }

    Graph(int v) {
        V = v;
        isDirected = true;
        adj = new LinkedList[v];
        for (int i = 0; i < v; ++i)
            adj[i] = new LinkedList<Integer>();
    }

    public static void main(String args[]) {
        Graph g = new Graph(6);//Directed graph
        g.addEdge(5, 2);
        g.addEdge(5, 0);
        g.addEdge(4, 0);
        g.addEdge(4, 1);
        g.addEdge(2, 3);
        g.addEdge(3, 1);
        g.DFS(5);
        System.out.println(" :: DFS Traversal");
        g.BFS(5);
        System.out.println(" :: BFS Traversal");
        g.TS();
        System.out.println(" :: Topological Traversal");
        g = new Graph(6, false);//Undirected graph
        g.addEdge(5, 2);
        g.addEdge(5, 0);
        g.addEdge(4, 0);
        g.addEdge(4, 1);
        g.addEdge(2, 3);
        g.addEdge(3, 1);
        g.IsBipartite();//use g = new Graph(6, (isdirected) false); for biparte
        System.out.println(":: a Bipartite Graph");

    }

    public int get_vertices_count() {
        return this.V;
    }

    void addEdge(int p, int c) {
        adj[p].add(c); // Add w to v's list.
        if (!isDirected) adj[c].add(p);
    }

    void DFS(int n) {
        // Mark all the vertices as not visited(set as
        // false by default in java)
        int top;
        boolean visited[] = new boolean[V];
        Stack<Integer> stack = new Stack<>();
        stack.push(n);
        while (!stack.empty()) {
            top = stack.pop();
            if (!visited[top]) {
                visited[top] = true;
                System.out.print(top + " ");
            }
            for (Integer i : adj[top]) {
                if (!visited[i])
                    stack.push(i);
            }
        }
    }

    void BFS(int n) {
        // Mark all the vertices as not visited(set as
        // false by default in java)
        boolean visited[] = new boolean[V];
        Queue<Integer> queue = new LinkedList<Integer>();
        int top;
        queue.add(n);
        while (!queue.isEmpty()) {
            top = queue.poll();
            if (!visited[top]) {
                visited[top] = true;
                System.out.print(top + " ");
            }
            for (Integer i : adj[top]) {
                if (!visited[i])
                    queue.add(i);
            }
        }
    }

    boolean TS() {
        // Mark all the vertices as not visited(set as
        // false by default in java)
        // reverse post order gives us topological order
        int top;
        int parentCount[] = new int[V];
        for (int i = 0; i < V; i++)
            for (Integer node : adj[i])
                parentCount[node]++;
        Queue<Integer> queue = new LinkedList<Integer>();
        for (int i = 0; i < V; i++)
            if (parentCount[i] == 0)
                queue.add(i);
        if (queue.isEmpty())
            return false;
        while (!queue.isEmpty()) {
            top = queue.poll();
            System.out.print(top + " ");
            for (Integer i : adj[top]) {
                parentCount[i]--;
                if (parentCount[i] == 0)
                    queue.add(i);
            }
        }
        // code to check if all elements are printed
        for (int i = 0; i < V; i++)
            if (parentCount[i] != 0)
                return false;
        return true;
    }

    private void IsBipartite() {
        Queue<Integer> queue = new LinkedList<Integer>();
        int[] colour = new int[V];// 0-unvisited, (1,-1) visited and coloured (red and black)
        int startNode = 0;
        queue.add(startNode);
        colour[startNode] = 1;
        while (!queue.isEmpty()) {
            startNode = queue.poll();
            for (int endNode : adj[startNode]) {
                if (colour[endNode] == 0) {
                    queue.add(endNode);
                    colour[endNode] = -1 * colour[startNode];
                } else if (colour[endNode] == colour[startNode]) {
                    System.out.print("This is not a");
                    return;
                }
            }
        }
        System.out.print("This is a");
    }

    private void PrintStronglyConnectedComponents() {
        //https://www.hackerearth.com/practice/algorithms/graphs/strongly-connected-components/tutorial/
    }
}