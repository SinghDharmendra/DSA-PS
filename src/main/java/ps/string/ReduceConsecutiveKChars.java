package ps.string;

import javafx.util.Pair;

import java.util.Stack;

public class ReduceConsecutiveKChars {
    public static void main(String[] args)
    {
        int k = 2;
        String st = "geeksforgeeks";
        String ans = reduced_String(k, st);
        System.out.println(ans);
    }
    public static String reduced_String(int k, String s)
    {
        Stack<Pair<Character,Integer>> st=new Stack<>();

        for(int i = 0; i < s.length(); i++){
            char c =  s.charAt(i);
            if(st.isEmpty() || st.peek().getKey()!=c){
                st.push(new Pair<>(c,1));
            }else if(st.peek().getKey()==c){
                Pair<Character,Integer> p=st.pop();
                int newCount=p.getValue()+1;
                if(newCount!=k){
                    st.push(new Pair<>(c,newCount));
                }
            }
        }

        String result = new String("");
       while(!st.isEmpty()){
           Pair<Character,Integer> popped=st.pop();
           int count=popped.getValue();
           while(count>0){
              result=popped.getKey()+result;
               count--;
           }
       }
    return result;
    }
}




