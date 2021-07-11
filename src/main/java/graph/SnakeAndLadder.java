package graph;

import java.util.LinkedList;
import java.util.Queue;

public class SnakeAndLadder {
    public static void main(String[] args)
    {
        // Let us construct the board given in above diagram
        int N = 30;
        int moves[] = new int[N];
        for (int i = 0; i < N; i++)
            moves[i] = -1;

        // Ladders
        moves[2] = 21;
        moves[4] = 7;
        moves[10] = 25;
        moves[19] = 28;

        // Snakes
        moves[26] = 0;
        moves[20] = 8;
        moves[16] = 3;
        moves[18] = 6;

        System.out.println("Min Dice throws required is " +
                getMinDiceThrows(moves, N));
    }

    private static int getMinDiceThrows(int[] moves, int n) {
        Queue<Entry> q = new LinkedList<>();
        Entry e = new Entry(0,0);
        boolean [] visited = new boolean[n];
        q.add(e);
        visited[0]=true;

        while(!q.isEmpty()){
            e=q.remove();
            int v=e.v;
            if(v==n-1)
                break;;

            for(int j=(v+1); j<=(v+6) && j<n; j++){
                if(!visited[j]){
                    Entry ne=new Entry(j,e.dist+1);
                    visited[j]=true;
                    if(moves[j]!=-1){
                        ne.v=moves[j];
                    }
                    q.add(ne);
                }

            }
        }
        return e.dist;


    }
}
class Entry{
    int v;
    int dist;
    public Entry(int v, int dist){
        this.v=v;
        this.dist=dist;
    }

}
