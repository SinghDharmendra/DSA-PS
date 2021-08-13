package graph;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BipartiteBFS {
    public static void main(String[] args) {
        Graph g = new Graph(9);
        //non bipartite
      /*  g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);*/
        //bipartite

        g.addEdge(1, 2);
        g.addEdge(2, 1);
        g.addEdge(3, 2);
        g.addEdge(2, 3);
        g.addEdge(2, 8);
        g.addEdge(8, 2);
        g.addEdge(3, 4);
        g.addEdge(4, 3);
        g.addEdge(5, 8);
        g.addEdge(8, 5);
        g.addEdge(4, 5);
        g.addEdge(5, 4);
        g.addEdge(6, 5);
        g.addEdge(5, 6);


        System.out.println("Following is Breadth First Traversal " +
                "(starting from vertex 2)");
        boolean ans = true;

        if (!bfsTraverse(g, 1))
            ans = false;
        System.out.println(ans ? "yes" : "no");


    }

    private static boolean bfsTraverse(Graph g, int source) {
        Queue<Integer> q = new LinkedList<>();
        int v = g.v;
        int[] colour = new int[v];
        Arrays.fill(colour, -1);


        q.add(source);
        colour[source] = 1;
        while (!q.isEmpty()) {
            int curV = q.remove();
            System.out.println(curV);
            List<Integer> adjList = g.getAdj()[curV];
            for (int nei : adjList) {
                if (colour[nei] == -1) {
                    q.add(nei);
                    colour[nei] = 1 - colour[curV];
                } else if (colour[nei] == colour[curV]) {
                    return false;
                }
            }


        }
        return true;
    }
}
