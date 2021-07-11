package ps.slidingwindow.vsd;

import java.util.HashMap;
import java.util.Map;

public class SmallestSubArrayToHaveAllCharOfGivenString {
    public static void main(String[] args) {
        String s = "ADOBECODEBANC", t = "ABC";
        //String s = "A", t = "A";
        int min = findMinLength(s,t);
        System.out.println("SmallestSubArrayToHaveAllCharOfGivenString : "+min);
    }

    private static int findMinLength(String s, String t) {
        Map<Character,Integer> tmap = new HashMap<>();
        for(int i=0; i<t.length(); i++){
            char c =t.charAt(i);
            tmap.put(c,tmap.getOrDefault(c,0)+1);
        }
        Map<Character,Integer> sMap= new HashMap<>(tmap);
        int cnt = tmap.size();
        int i=0, j=0, min=Integer.MAX_VALUE;
        while(j<s.length()){
            char c = s.charAt(j);
            if(sMap.containsKey(c)){
                sMap.put(c,sMap.get(c)-1);
                if(sMap.get(c)==0)
                    cnt--;
            }
            if(cnt==0){
                while (cnt==0){
                    min=Math.min(min,j-i+1);
                    if(sMap.containsKey(s.charAt(i))){
                        sMap.put(s.charAt(i),sMap.get(s.charAt(i))+1);
                        if(sMap.get(s.charAt(i))>0){
                            cnt++;
                        }
                    }
                    i++;
                }
            }
            j++;
        }
        return min;
    }
}
