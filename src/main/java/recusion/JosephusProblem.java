package recusion;

import java.util.ArrayList;
import java.util.List;

/**
 * Josephus Problem | Game of Death in a circle | Execution in Circle
 */

public class JosephusProblem {
    static int ans=-1;
    public static void main(String[] args) {
        int n=40,k=7;
        int index=0;

        List<Integer> list=new ArrayList<Integer>();

        for(int i=1; i<=n; i++){
            list.add(i);
        }
        solve(list,index,k-1);
        System.out.println("Person who got saved : "+ans);
    }

    private static void solve(List<Integer> list, int index,int k) {
        if(list.size()==1){
            ans=list.get(0);
            return;
        }
         index=(index+k)%list.size();
        list.remove(index);
        solve(list,index,k);

    }
}
