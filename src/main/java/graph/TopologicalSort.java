package graph;

import java.util.Stack;

/**
 * Topological sorting for Directed Acyclic Graph (DAG) is a
 * linear ordering of vertices such that for every directed edge u v,
 * vertex u comes before v in the ordering.
 * Topological Sorting for a graph is not possible if the graph is not a DAG.
 */

public class TopologicalSort {
    public static void main(String args[])
    {
        // Create a graph given in the above diagram
        TopologicalSort topologicalSort= new TopologicalSort();
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
        topologicalSort.topologicalSort(g);
    }

    private void topologicalSort(Graph g) {
        int v= g.v;
        boolean visited [] = new boolean[v];
        Stack<Integer> st = new Stack<>();
        for(int i=0; i<v;i++){
            if(!visited[i]){
                dfsUtil(i,g,visited,st);
            }
        }
        while(!st.isEmpty()){
            System.out.print(st.pop()+" ");
        }


    }

    private void dfsUtil(int s,Graph g, boolean[] visited, Stack<Integer> st) {
        visited[s]=true;
        for(int adjV: g.getAdj()[s]){
            if(!visited[adjV]){
                dfsUtil(adjV,g,visited,st);
            }
        }
        st.push(s);

    }
}
