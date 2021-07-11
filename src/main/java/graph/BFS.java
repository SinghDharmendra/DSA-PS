package graph;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BFS {
    public static void main(String[] args) {
        Graph g = new Graph(4);

        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);

        System.out.println("Following is Breadth First Traversal "+
                "(starting from vertex 2)");

        bfsTraverse(g,2);
    }

    private static void bfsTraverse(Graph g, int source) {
        Queue<Integer> q=new LinkedList<>();
        int v=g.v;
        boolean [] visited = new boolean[v];

        q.add(source);
        while(!q.isEmpty()){
            int curV=q.remove();
            List<Integer> adjList=g.getAdj()[source];


        }
    }
}
