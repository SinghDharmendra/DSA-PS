package ps.slidingwindow.fsd;

import java.util.HashMap;
import java.util.Map;

public class CountOccurrencesOfAnagram {
    public static void main(String[] args) {
        String txt = "aabaabaa";

        String pat = "aaba";
        int oc=findOccurrences(txt,pat);
        System.out.println("Count: "+oc);
    }

    private static int findOccurrences(String txt, String pat) {
        Map<Character,Integer> patf= new HashMap<>();
        Map<Character,Integer> map= new HashMap<>();

        for(int i=0;i<pat.length(); i++){
            char c = pat.charAt(i);
            patf.put(c,patf.getOrDefault(c,0)+1);
        }
        int cnt=0;
        int j=0, i=0;
        while(j<txt.length()){
            char c = txt.charAt(j);
            if(!patf.containsKey(c)){
                map.clear();
                j++;
                i=j;
            }else{
                map.put(c,map.getOrDefault(c,0)+1);
                if(j-i+1<pat.length()){
                    j++;
                }else if(j-i+1==pat.length()){
                    if(map.equals(patf)){
                        cnt++;
                    }
                    if(map.get(txt.charAt(i))>1){
                        map.put(txt.charAt(i),map.get(txt.charAt(i))-1);
                    }else {
                        map.remove(txt.charAt(i));
                    }
                    i++;
                    j++;
                }
            }

        }
        return cnt;
    }
}
