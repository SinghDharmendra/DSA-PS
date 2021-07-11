package ps.slidingwindow.vsd;

import java.util.HashMap;
import java.util.Map;

public class LongestSubStringWithKUniqueChar {
    public static void main(String[] args) {
        String in ="aabbcc";
        int k=2;
        int maxLen = findMaxLengthSubString(in,k);
        System.out.println("LongestSubStringWithKUniqueChar :"+maxLen);
    }

    private static int findMaxLengthSubString(String str, int k) {
        Map<Character,Integer> map = new HashMap<>();

        int i=0, j=0,max=0;
        while(j<str.length()){
            char c = str.charAt(j);
            map.put(c,map.getOrDefault(c,0)+1);
            if(map.size()==k){
                max=Math.max(max,j-i+1);
                j++;
            }else if(map.size()>k){
                while (map.size()>k){
                    if(map.get(str.charAt(i))>1){
                        map.put(str.charAt(i),map.get(str.charAt(i))-1);
                    }else {
                        map.remove(str.charAt(i));
                    }
                    i++;

                }
                j++;

            }else{
                j++;
            }
        }
        return max;

    }
}
