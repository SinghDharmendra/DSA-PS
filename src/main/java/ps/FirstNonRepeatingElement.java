package ps;

import java.util.LinkedHashMap;
import java.util.Map;

public class FirstNonRepeatingElement {
    public static void main(String[] args) {
        int arr[] = { 9, 4, 9, 6, 7, 4 };
        int n = arr.length;
        firstNonRepeating(arr, n);
    }

    private static void firstNonRepeating(int[] input, int n) {
        Map<Integer,Integer> freqMap=new LinkedHashMap<>();

        for(int in: input){
            freqMap.put(in,freqMap.getOrDefault(in,0)+1);
        }

        for(Map.Entry<Integer,Integer> e: freqMap.entrySet()){
            if(e.getValue()==1){
                System.out.println(e.getKey());
            }

        }

    }
}
