package graph;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class ShortestPathInUndirectedWithUnitWeight {

    public static void main(String[] args) {
        Graph g = new Graph(6);
        int edge[][] = {{0, 1}, {1, 0}, {0, 2}, {2, 0}, {1, 2}, {2, 1}, {1, 5}, {5, 1}, {5, 3}, {3, 5}, {2, 3}, {3, 2},
                {2, 4}, {4, 2}, {3, 4}, {4, 3}};
        System.out.println(edge.length);
        for (int[] e : edge) {
            g.addEdge(e[0], e[1]);
        }
        int[] dist = findShortestDist(g, 0, new boolean[g.v]);
        System.out.println(Arrays.toString(dist));


    }

    private static int[] findShortestDist(Graph g, int s, boolean[] visited) {

        Queue<Integer> q = new LinkedList<>();
        q.add(s);
        int dist[] = new int[g.v];
        Arrays.fill(dist, Integer.MAX_VALUE);
        q.add(s);
        dist[s] = 0;

        while (!q.isEmpty()) {
            int node = q.remove();
            for (int nei : g.getAdj()[node]) {
                if (dist[node] + 1 < dist[nei]) {
                    dist[nei] = dist[node] + 1;
                    q.add(nei);
                }
            }

        }

        return dist;
    }
}
