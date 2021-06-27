package ps.dp.mcm;

import java.util.Arrays;

public class EggDroppingProblem {

    static int [][] mem;
    public static void main(String[] args) {
        int f=10, e=3;
        mem=new int[e+1][f+1];
        EggDroppingProblem edp=new EggDroppingProblem();

        System.out.println(edp.getMinAttempt(3, 10));

        for(int [] m:mem){
            Arrays.fill(m,-1);
        }
        int minAttempt= edp.getMinAttemptMemoization(e,f);
        System.out.println("minAttempt: "+ minAttempt);
        int minAttempt2=edp.getMinAttemptMemoization2(e,f);
        System.out.println("minAttempt: "+ minAttempt2);



    }

    private int getMinAttempt(int e, int f) {
        if(e==1){
            return f;
        }
        if(f==0 || f==1)
            return f;
        int min=Integer.MAX_VALUE;
        for(int k=1; k<=f; k++){
            int tmp=1+Math.max(getMinAttemptMemoization(e-1, k-1),getMinAttemptMemoization(e, f-k));
            min=Math.min(min,tmp);
        }
        return min;
    }

    private  int getMinAttemptMemoization(int e, int f) {
        if(e==1){
            return f;
        }
        if(f==0 || f==1)
            return f;
        if(mem[e][f]!=-1)
            return mem[e][f];
        int min=Integer.MAX_VALUE;
        for(int k=1; k<=f; k++){
            int tmp=1+Math.max(getMinAttemptMemoization(e-1, k-1),getMinAttemptMemoization(e, f-k));
            min=Math.min(min,tmp);
        }
        return mem[e][f]=min;
    }

    private  int getMinAttemptMemoization2(int e, int f) {
        if(e==1){
            return f;
        }
        if(f==0 || f==1)
            return f;
        int min=Integer.MAX_VALUE;
        for(int k=1; k<=f; k++){
            int broken=0;
            int notBroken=0;
            if(mem[e-1][k-1]==-1){
                broken=getMinAttemptMemoization2(e-1, k-1);
                mem[e-1][k-1]=broken;
            }else{
                broken=mem[e-1][k-1];
            }
            if(mem[e][f-k]==-1){
                notBroken=getMinAttemptMemoization2(e,f-k);
                mem[e][f-k]=notBroken;
            }else {
                notBroken=mem[e][f-k];
            }

            int tmp=1+Math.max(broken,notBroken);
            min=Math.min(min,tmp);
        }
        return min;
    }
}
