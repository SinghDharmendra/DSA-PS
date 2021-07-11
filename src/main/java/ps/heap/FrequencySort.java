package ps.heap;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class FrequencySort {
    public static void main(String[] args) {
        int arr[] = {2, 5, 2, 8, 5, 6, 8, 8};
        Map<Integer,Integer> map = new HashMap<>();
        for(int i=0; i<arr.length; i++){
            map.put(arr[i],map.getOrDefault(arr[i],0)+1);
        }
        PriorityQueue<Map.Entry<Integer,Integer>> pq = new PriorityQueue<>((a,b)->b.getValue()-a.getValue());
        for(Map.Entry<Integer,Integer> e: map.entrySet()){
            pq.offer(e);
        }
        while(!pq.isEmpty()){
            Map.Entry<Integer,Integer> e=pq.poll();
            int count = e.getValue();
            while(count>0){
                System.out.println(e.getKey());
                count--;
            }

        }
    }
}
