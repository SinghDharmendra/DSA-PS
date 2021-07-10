package ps.heap;

import java.util.Arrays;
import java.util.PriorityQueue;

import static jdk.nashorn.internal.objects.NativeArray.sort;

public class SortKSortedArray {
    public static void main(String[] args) {
        int arr[] = {6, 5, 3, 2, 8, 10, 9};
        int k = 3;
        sortKSorted(arr,k);
        System.out.println("Sorted Array"+ Arrays.toString(arr));
    }

    private static void sortKSorted(int[] arr, int k) {
        PriorityQueue<Integer> pq =new PriorityQueue<>();
        int idx=0;
        for(int i=0; i<arr.length; i++){
            pq.offer(arr[i]);
            if(pq.size()>k){
                arr[idx++]=pq.poll();
            }
        }
        while(!pq.isEmpty()){
            arr[idx++]=pq.poll();
        }

    }
}
