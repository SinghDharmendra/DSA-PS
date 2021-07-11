package graph;

import java.util.*;

public class DijkstraAlgo {
    private int dist[];
    private Set<Integer> settled;
    private PriorityQueue<Node> pq;
    private int V; // Number of vertices
    List<List<Node> > adj;

    public DijkstraAlgo(int V)
    {
        this.V = V;
        dist = new int[V];
        settled = new HashSet<Integer>();
        pq = new PriorityQueue<Node>(V, (a,b)->a.cost-b.cost);
    }


    public static void main(String arg[])
    {
        int V = 5;
        int source = 0;

        // Adjacency list representation of the
        // connected edges
        List<List<Node> > adj = new ArrayList<List<Node> >();

        // Initialize list for every node
        for (int i = 0; i < V; i++) {
            List<Node> item = new ArrayList<Node>();
            adj.add(item);
        }

        // Inputs for the DPQ graph
        adj.get(0).add(new Node(1, 9));
        adj.get(0).add(new Node(2, 6));
        adj.get(0).add(new Node(3, 5));
        adj.get(0).add(new Node(4, 3));

        adj.get(2).add(new Node(1, 2));
        adj.get(2).add(new Node(3, 4));

        // Calculate the single source shortest path
        DijkstraAlgo dpq = new DijkstraAlgo(V);
        dpq.dijkstra(adj, source);

        // Print the shortest path to all the nodes
        // from the source node
        System.out.println("The shorted path from node :");
        for (int i = 0; i < dpq.dist.length; i++)
            System.out.println(source + " to " + i + " is "
                    + dpq.dist[i]);
    }

    private void dijkstra(List<List<Node>> adj, int source) {
        for(int i=0; i<V; i++){
            dist[i]=Integer.MAX_VALUE;
        }
        this.adj=adj;
        pq.add(new Node(source,0));
        dist[source]=0;
        while(settled.size()!=V){
            if(pq.isEmpty())
                return;
            int u= pq.poll().node;
            settled.add(u);
            dfs(u);

        }
    }

    private void dfs(int u) {
        for(int i=0; i<adj.get(u).size(); i++){
            Node adjNode = adj.get(u).get(i);
        if(!settled.contains(adjNode.node)){
            int newDist=dist[u]+adjNode.cost;
            if(dist[adjNode.node]>newDist){
                dist[adjNode.node]=newDist;
            }
            pq.offer(new Node(adjNode.node,dist[adjNode.node]));
        }
        }

    }


}
class Node{
    int node, cost;
    public Node(int node, int cost){
        this.node=node;
        this.cost=cost;
    }
}
