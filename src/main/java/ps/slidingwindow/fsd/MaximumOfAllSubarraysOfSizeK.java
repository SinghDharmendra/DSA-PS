package ps.slidingwindow.fsd;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class MaximumOfAllSubarraysOfSizeK {
    public static void main(String[] args) {
        int arr[] = {1, 3, -1, -3, 5, 3, 6, 7};

        int k= 3;
        List<Integer>  out =findMaxOfSubArray(arr,k);
        System.out.println("MaximumOfAllSubarraysOfSizeK:"+out);
    }

    private static  List<Integer>  findMaxOfSubArray(int[] arr, int k) {
        List<Integer> res = new ArrayList<>();
        LinkedList<Integer> sub = new LinkedList<>();
        int i=0 , j=0;
        while(j<arr.length){
            while (!sub.isEmpty() && sub.getLast()<arr[j]){
                sub.removeLast();
            }
            sub.addLast(arr[j]);
            if(j-i+1<k){
                j++;
            }else if(j-i+1==k){
                res.add(sub.getFirst());
                if(arr[i]==sub.getFirst()){
                    sub.removeFirst();
                }
                i++;
                j++;
            }
        }
        return res;
    }
}
