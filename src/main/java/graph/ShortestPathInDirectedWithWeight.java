package graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * Find topological sort
 * keep picking element from topo sorted order and check it's adj node
 * and the calculate min distance
 */

public class ShortestPathInDirectedWithWeight {
    static List<List<Pair>> adj;

    public static void main(String[] args) {
        adj = new ArrayList<>();
        int n = 6;
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        addEdge(0, 1, 5);
        addEdge(0, 2, 3);
        addEdge(1, 3, 6);
        addEdge(1, 2, 2);
        addEdge(2, 4, 4);
        addEdge(2, 5, 2);
        addEdge(2, 3, 7);
        addEdge(3, 4, -1);
        addEdge(4, 5, -2);

        int dist[] = calcMinDist(adj, n, 1);
        System.out.println("min dist" + Arrays.toString(dist));
    }

    private static void addEdge(int s, int d, int w) {
        adj.get(s).add(new Pair(d, w));

    }

    private static int[] calcMinDist(List<List<Pair>> adj, int n, int s) {
        Stack<Integer> st = new Stack<>();
        boolean[] visited = new boolean[n];
        topologicalOrder(adj, s, visited, st);
        System.out.println(st.size() + "_:" + st);
        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[s] = 0;
        while (!st.isEmpty()) {
            int node = st.pop();
            if (dist[node] != Integer.MAX_VALUE)
                for (Pair nei : adj.get(node)) {
                    if (dist[node] + nei.weight < dist[nei.v]) {
                        dist[nei.v] = dist[node] + nei.weight;
                    }
                }
        }
        return dist;

    }

    private static void topologicalOrder(List<List<Pair>> adj, int s, boolean[] visited, Stack<Integer> st) {
        visited[s] = true;
        for (Pair nei : adj.get(s)) {
            if (!visited[nei.v]) {
                topologicalOrder(adj, nei.v, visited, st);
            }
        }
        st.push(s);


    }
}

class Pair {
    int v, weight;

    public Pair(int v, int weight) {
        this.v = v;
        this.weight = weight;
    }
}
