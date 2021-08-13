package graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class TopologicalSortBFS {
    public static void main(String[] args) {
        Graph g = new Graph(6);
        g.addEdge(5, 2);
        g.addEdge(5, 0);
        g.addEdge(4, 0);
        g.addEdge(4, 1);
        g.addEdge(2, 3);
        g.addEdge(3, 1);

        System.out.println("Following is a Topological "
                + "sort of the given graph");
        // Function Call
        topologicalSortDFS(g);

    }

    private static void topologicalSortDFS(Graph g) {
        int v = g.v;

        int[] inDegree = new int[v];
        List<Integer> topologicalSort = new ArrayList<>();
        for (int i = 0; i < v; i++) {
            for (int adjv : g.getAdj()[i]) {
                inDegree[adjv]++;
            }
        }
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < v; i++) {
            if (inDegree[i] == 0) {
                q.add(i);
            }
        }
        while (!q.isEmpty()) {
            int node = q.remove();
            topologicalSort.add(node);
            for (int nei : g.getAdj()[node]) {
                inDegree[nei]--;
                if (inDegree[nei] == 0) {
                    q.add(nei);
                }
            }
        }
        System.out.println("topologicalSort : " + topologicalSort);
    }

}
