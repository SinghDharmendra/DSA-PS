package graph;

import java.util.LinkedList;
import java.util.Queue;

public class CycleInUndirectedGraphBFS {
    public static void main(String[] args) {
        Graph g = new Graph(6);
        g.addEdge(0, 5);


        g.addEdge(1, 0);
        g.addEdge(1, 2);


        System.out.println(
                "Following is Depth First Traversal");

        boolean cycleExist = BFS(g, 0);

        System.out.println("cycleExist: " + cycleExist);


    }

    private static boolean BFS(Graph g, int s) {

        Queue<Node1> q = new LinkedList<>();
        boolean visited[] = new boolean[g.v];
        visited[s] = true;
        q.add(new Node1(s, -1));

        while (!q.isEmpty()) {
            Node1 node = q.remove();
            for (int nei : g.adj[node.v]) {
                if (!visited[nei]) {
                    q.add(new Node1(nei, node.v));
                    visited[nei] = true;
                } else if (nei != node.parent) {
                    return true;
                }
            }
        }


        return false;
    }
}

class Node1 {
    int v, parent;

    public Node1(int v, int parent) {
        this.v = v;
        this.parent = parent;
    }

}
