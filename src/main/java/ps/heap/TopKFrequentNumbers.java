package ps.heap;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class TopKFrequentNumbers {
    public static void main(String[] args) {
        int arr[] = {1,1,1,2,2,3};
        int k = 2;
        Map<Integer,Integer> map =new HashMap<Integer,Integer>();
        for(int i=0 ; i<arr.length; i++){
            Integer key = arr[i];
            map.put(key,map.getOrDefault(arr[i],0)+1);
        }
        PriorityQueue<Map.Entry<Integer,Integer>> pq =new PriorityQueue<>((a,b)->a.getValue()-b.getValue());
        for(Map.Entry<Integer,Integer> e: map.entrySet()){
            pq.offer(e);
            if(pq.size()>k){
                pq.poll();
            }
        }
        while(!pq.isEmpty()){
            System.out.println(pq.poll().getKey());
        }

    }
}
