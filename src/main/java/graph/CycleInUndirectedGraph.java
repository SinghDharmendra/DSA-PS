package graph;

public class CycleInUndirectedGraph {
    public static void main(String[] args) {
        Graph g = new Graph(4);
        g.addEdge(0, 1);
        g.addEdge(0, 3);
        g.addEdge(1, 2);
        g.addEdge(1, 3);

        g.addEdge(1, 0);
        g.addEdge(3, 0);
        g.addEdge(2, 1);
        g.addEdge(3, 1);


        System.out.println(
                "Following is Depth First Traversal");

        boolean cycleExist = DFS(g, 0, -1, new boolean[g.v]);

        System.out.println("cycleExist: " + cycleExist);


    }

    private static boolean DFS(Graph g, int s, int parent, boolean[] visited) {
        visited[s] = true;
        for (int nei : g.getAdj()[s]) {
            if (!visited[nei]) {
                if (DFS(g, nei, s, visited))
                    return true;

            } else if (nei != parent) {
                return true;
            }
        }

        return false;
    }
}
