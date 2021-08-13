package graph;

public class CycleInDirectedGraphDFS {
    public static void main(String[] args) {
        Graph g = new Graph(6);
        g.addEdge(0, 5);


        g.addEdge(1, 0);
        g.addEdge(1, 2);
        g.addEdge(5, 1);


        System.out.println(
                "Following is Depth First Traversal");

        boolean cycleExist = dfs(g, 0, new boolean[g.v], new boolean[g.v]);

        System.out.println("cycleExist: " + cycleExist);


    }

    private static boolean dfs(Graph g, int s, boolean[] vis, boolean[] defVis) {
        vis[s] = true;
        defVis[s] = true;
        for (int nei : g.getAdj()[s]) {
            if (!vis[nei]) {
                // This has to be like this , we can not return dfs from here
                if (dfs(g, nei, vis, defVis))
                    return true;

            } else if (defVis[nei]) {
                return true;
            }
        }


        defVis[s] = false;
        return false;


    }
}

