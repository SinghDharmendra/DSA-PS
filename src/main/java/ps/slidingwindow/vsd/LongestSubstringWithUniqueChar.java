package ps.slidingwindow.vsd;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithUniqueChar {
    public static void main(String[] args) {
        String str="GEEKSFORGEEKS";
        int max=getMaxLnegth(str);
        System.out.println("LongestSubstringWithUniqueChar :"+max);
    }

    private static int getMaxLnegth(String str) {
        Map<Character,Integer> map = new HashMap<>();
        int i=0, j=0,max=0;
        while (j<str.length()){
            char c= str.charAt(j);
            if(map.containsKey(c)){
                while(map.containsKey(c)){
                    char ct = str.charAt(i);
                    map.remove(ct);
                            i++;
                }
                map.put(c,1);
                j++;


            }else{
                map.put(c,1);
                max=Math.max(max,j-i+1);
                j++;
            }
        }
        return max;
    }
}
