package ps.heap;

import java.util.Arrays;
import java.util.PriorityQueue;

public class KClosestPointsToOrigin {
    public static void main(String[] args) {
        int coordinates[][]={{3, 3}, {5, -1}, {-2, 4}}, K = 2;
        PriorityQueue<int[]> pq =new PriorityQueue<int[]>((a,b)->(b[0]*b[0]+b[1]*b[1])-(a[0]*a[0]+a[1]*a[1]));
        for(int [] cord: coordinates){
            pq.offer(cord);
            if(pq.size()>K){
                pq.poll();
            }
        }
        System.out.println("K Closest coordinates from origins:");
        while (!pq.isEmpty()){
            System.out.println(Arrays.toString(pq.poll()));
        }


    }
}

