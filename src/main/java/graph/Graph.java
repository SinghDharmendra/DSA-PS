package graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Graph {
    int v;
    List<Integer>[] adj;
    @SuppressWarnings("unchecked")
    public Graph(int v) {
        this.v = v;
        adj=new ArrayList[v];
        for(int i=0; i<v; i++){
            adj[i]=new ArrayList<>();
        }
    }
    void addEdge(int u, int v){
        adj[u].add(v);
    }

    public List<Integer>[] getAdj() {
        return adj;
    }


}
