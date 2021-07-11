package ps.heap;

import java.util.PriorityQueue;

public class ConnectRopeToMinimiseTheCost {
    public static void main(String[] args) {
        int [] arr={4, 3, 2 , 6};
        PriorityQueue<Integer> pq =new PriorityQueue<>();
        for(int i=0; i<arr.length; i++){
            pq.offer(arr[i]);
        }
        int cost=0;
        while(pq.size()>1){
            int o1=pq.poll();
            int o2=pq.poll();
            int n=o1+o2;
            cost+=n;
            pq.offer(n);

        }

        System.out.println("cost:"+cost);
    }
}
