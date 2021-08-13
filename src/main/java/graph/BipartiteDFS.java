package graph;

public class BipartiteDFS {
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
        int[] colour = new int[g.v];


        if (!dfsTraverse(g, 1, colour))
            ans = false;
        System.out.println(ans ? "yes" : "no");


    }

    private static boolean dfsTraverse(Graph g, int s, int[] colour) {
        if (colour[s] == -1)
            colour[s] = 1;

        for (int nei : g.getAdj()[s]) {
            if (colour[nei] == -1) {
                colour[nei] = 1 - colour[s];
                if (!dfsTraverse(g, nei, colour)) {
                    return false;
                }
            } else if (colour[nei] == colour[s]) {
                return false;
            }
        }
        return true;
    }

}
