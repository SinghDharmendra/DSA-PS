package ps.heap;

import java.util.Map;
import java.util.PriorityQueue;

public class KClosestNumber {
    public static void main(String[] args) {
        int arr[] = {10, 2, 14, 4, 7, 6}, x = 5, k = 3;
        //
        PriorityQueue<Mapper> pq = new PriorityQueue<>((a,b)->b.diff-a.diff);
        for(int i=0 ; i<arr.length; i++){
            pq.offer(new Mapper(Math.abs(arr[i]-x),arr[i]));
            if(pq.size()>k){
                pq.poll();
            }

        }
        while(!pq.isEmpty()){
            System.out.println(pq.poll().num);
        }

    }
}
class Mapper{
    int diff;
    int num;
    public Mapper(int diff,int num){
        this.diff=diff;
        this.num=num;

    }
}
