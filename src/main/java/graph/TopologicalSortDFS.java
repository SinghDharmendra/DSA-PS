package graph;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class TopologicalSortDFS {
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
        boolean[] visited = new boolean[v];
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < v; i++) {
            if (!visited[i]) {
                dfs(i, g, visited, st);
            }

        }
        List<Integer> topoSortedList = new ArrayList<>();
        while (!st.isEmpty()) {
            topoSortedList.add(0, st.pop());
        }
        System.out.println(topoSortedList);
    }

    static void dfs(int s, Graph g, boolean[] visited, Stack<Integer> st) {
        visited[s] = true;
        for (int nei : g.getAdj()[s]) {
            if (!visited[nei]) {
                dfs(nei, g, visited, st);
            }

        }
        st.push(s);
    }

}
