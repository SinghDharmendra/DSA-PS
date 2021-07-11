package graph;

import java.util.List;

public class DFS {
    public static void main(String[] args) {
        Graph g = new Graph(4);
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);

        System.out.println(
                "Following is Depth First Traversal");
         dfsTraverse(g);


    }

    private static void dfsTraverse(Graph g) {
        int v=g.v;
        boolean [] visited = new boolean[v];
        for(int i=0 ;i<v; i++){
            if(!visited[i]){
                dfsUtil(g,i,visited);
            }
        }
    }

    private static void dfsUtil(Graph g, int source, boolean[] visited) {
        visited[source]=true;
        System.out.println(source);
        List<Integer> adjList=g.getAdj()[source];
        for(int i=0; i<adjList.size(); i++){
            int adjVertex=adjList.get(i);
            if(!visited[adjVertex]){
                dfsUtil(g,adjVertex,visited);
            }
        }

    }
}
