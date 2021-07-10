package ps.heap;

import java.util.Collections;
import java.util.PriorityQueue;

public class KthLargestNumber {
    public static void main(String[] args) {
        int arr[] = {7, 10, 4, 3, 20, 15};
        int k = 3;
        System.out.println(findKthLargest(arr,k));
    }

    private static int findKthLargest(int[] arr, int k) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>();
        for(int i=0; i<arr.length; i++){
            maxHeap.offer(arr[i]);
            if(maxHeap.size()>k){
                maxHeap.poll();
            }

        }
        return maxHeap.peek();

    }
}
