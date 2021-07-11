package graph;

import java.util.LinkedList;
import java.util.PriorityQueue;

public class PrimsAlgo {
    static class Graph {

        // Number of vertices in the graph
        int V;

        // List of adjacent nodes of a given vertex
        LinkedList<node1>[] adj;

        // Constructor
        Graph(int e) {
            V = e;
            adj = new LinkedList[V];
            for (int o = 0; o < V; o++)
                adj[o] = new LinkedList<>();
        }
    }

    class node1 {

        // Stores destination vertex in adjacency list
        int dest;

        // Stores weight of a vertex in the adjacency list
        int weight;

        // Constructor
        node1(int a, int b) {
            dest = a;
            weight = b;
        }
    }

    class node {
        int vertex;
        int key;
    }

    void addEdge(Graph graph, int src, int dest, int weight) {

        node1 node0 = new node1(dest, weight);
        node1 node = new node1(src, weight);
        graph.adj[src].addLast(node0);
        graph.adj[dest].addLast(node);
    }

    public static void main(String[] args) {
        int V = 9;

        Graph graph = new Graph(V);

        PrimsAlgo e = new PrimsAlgo();

        e.addEdge(graph, 0, 1, 4);
        e.addEdge(graph, 0, 7, 8);
        e.addEdge(graph, 1, 2, 8);
        e.addEdge(graph, 1, 7, 11);
        e.addEdge(graph, 2, 3, 7);
        e.addEdge(graph, 2, 8, 2);
        e.addEdge(graph, 2, 5, 4);
        e.addEdge(graph, 3, 4, 9);
        e.addEdge(graph, 3, 5, 14);
        e.addEdge(graph, 4, 5, 10);
        e.addEdge(graph, 5, 6, 2);
        e.addEdge(graph, 6, 7, 1);
        e.addEdge(graph, 6, 8, 6);
        e.addEdge(graph, 7, 8, 7);

        // Method invoked
        e.prims_mst(graph);
    }

    private void prims_mst(Graph graph) {
        int v = graph.V;
        Boolean[] mstSet = new Boolean[v];
        int[] parent = new int[v];
        node[] e = new node[graph.V];


        for (int i = 0; i < v; i++) {
            e[i] = new node();
            e[i].vertex = i;
            e[i].key = Integer.MAX_VALUE;
            mstSet[i] = false;

            parent[i] = -1;

        }

        mstSet[0] = true;
        e[0].key = 0;

        PriorityQueue<node> pq = new PriorityQueue<node>((a, b) -> a.key - b.key);
        for (int i = 0; i < v; i++) {
            pq.offer(e[i]);
        }
        while (!pq.isEmpty()) {
            node s = pq.poll();
            mstSet[s.vertex] = true;

            for (node1 adjV : graph.adj[s.vertex]) {
                if (!mstSet[adjV.dest]) {
                    if (adjV.weight < e[adjV.dest].key) {
                        pq.remove(e[adjV.dest]);
                        e[adjV.dest].key = adjV.weight;
                        pq.offer(e[adjV.dest]);
                        parent[adjV.dest] = s.vertex;
                    }

                }

            }


        }

        for (int o = 1; o < graph.V; o++)
            System.out.println(parent[o] + " "
                    + "-"
                    + " " + o);


    }

}
