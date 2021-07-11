package graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class KruskalAlgo {
    static class Edge
    {
        int src, dest, weight;
    }
    static class subset
    {
        int parent, rank;
    }


    // Creates a graph with V vertices and E edges
    static class Graph{
        static int V, E; // V-> no. of vertices & E->no.of edges
        static Edge edge[]; // collection of all edges
        Graph(int v, int e)
        {
            V = v;
            E = e;
            edge = new Edge[E];
            for (int i = 0; i < e; ++i)
                edge[i] = new Edge();
        }

        public void KruskalMST() {
            Arrays.sort(edge,(a,b)->a.weight-b.weight);
            subset [] subsets = new subset[V];
            for(int i=0;i<V; i++){
                subsets[i]=new subset();
                subsets[i].parent=i;
                subsets[i].rank=0;
            }
            List<Edge> result = new ArrayList<>();


            for(Edge e:edge){
                int s=e.src;
                int d=e.dest;

                int x=find(subsets,s);
                int y=find(subsets,d);
                System.out.println(x+"xy"+y);
                if(x!=y){
                    result.add(e);
                    union(subsets,s,d);
                }
            }
            for(Edge e:result){
                System.out.println(e.src+"->"+e.dest);
            }
        }

        private void union(subset[] subsets, int x, int y) {
            int xroot=find(subsets,x);
            int yroot=find(subsets,y);
            if(xroot!=yroot){
                if(subsets[xroot].rank<subsets[yroot].rank){
                    subsets[xroot].parent=yroot;
                }else if(subsets[xroot].rank>subsets[yroot].rank){
                    subsets[yroot].parent=xroot;
                }else{
                    subsets[xroot].parent=yroot;
                    subsets[yroot].rank++;
                }
            }
        }

        private int find(subset[] subsets, int u) {
            System.out.println("find:"+u);
            if(subsets[u].parent!=u){
                subsets[u].parent=find(subsets,subsets[u].parent);
            }
            return subsets[u].parent;
        }
    }

    public static void main(String[] args)
    {

        /* Let us create following weighted graph
                 10
            0--------1
            |  \     |
           6|   5\   |15
            |      \ |
            2--------3
                4       */
        int V = 4; // Number of vertices in graph
        int E = 5; // Number of edges in graph
        Graph graph = new Graph(V, E);

        // add edge 0-1
        graph.edge[0].src = 0;
        graph.edge[0].dest = 1;
        graph.edge[0].weight = 10;

        // add edge 0-2
        graph.edge[1].src = 0;
        graph.edge[1].dest = 2;
        graph.edge[1].weight = 6;

        // add edge 0-3
        graph.edge[2].src = 0;
        graph.edge[2].dest = 3;
        graph.edge[2].weight = 5;

        // add edge 1-3
        graph.edge[3].src = 1;
        graph.edge[3].dest = 3;
        graph.edge[3].weight = 15;

        // add edge 2-3
        graph.edge[4].src = 2;
        graph.edge[4].dest = 3;
        graph.edge[4].weight = 4;

        // Function call
        graph.KruskalMST();
    }
}
