package ps.dp.knapsack01;

import java.util.Arrays;

public class KnapsackRecursive {
    static int [][]mem;

    static int knapSackRec(int wt[], int[] val, int W, int n){
        if(W==0 || n==0)
            return 0;
        if(wt[n-1]<=W){
            return Math.max(val[n-1]+knapSackRec(wt,val,W-wt[n-1],n-1),knapSackRec(wt,val,W,n-1));
        }else{
            return knapSackRec(wt,val,W,n-1);
        }
    }

    public static void main(String args[])
    {
        int val[] = new int[] { 60, 100, 120 };
        int wt[] = new int[] { 10, 20, 30 };
        int W = 50;
        int n = val.length;
        System.out.println(knapSackRec( wt, val,W, n));
        mem=new int[n+1][W+1];
        for(int []row : mem)
        Arrays.fill(row,-1);
        System.out.println(knapSackRecMemoization( wt, val,W, n));
        System.out.println(KnapsackTopDownDP(wt,val,W,n));
    }

    private static int KnapsackTopDownDP(int[] wt, int[] val, int W, int n) {
        int [][] t = new int[n+1][W+1];
        for(int i=0; i<n+1; i++){
            for(int j=0; j<W+1; j++){
                if(i==0 || j==0){
                    t[i][j]=0;
                }
            }
        }

        for(int i=1; i<n+1; i++){
            for(int j=1; j<W+1; j++){
                if(wt[i-1]<=j){
                    t[i][j]=Math.max(val[i-1]+t[i-1][j-wt[i-1]],t[i-1][j]);
                }else{
                    t[i][j]=t[i-1][j];
                }
            }
        }
        return t[n][W];
    }

    private static int knapSackRecMemoization(int[] wt, int[] val, int W, int n) {
        if(n==0 || W==0)
            return 0;
        if(mem[n][W]!=-1)
            return mem[n][W];
        if(wt[n-1]<=W){
            return mem[n][W]=Math.max(val[n-1]+knapSackRecMemoization(wt,val,W-wt[n-1],n-1),knapSackRecMemoization(wt,val,W,n-1));
        }else{
            return mem[n][W]=knapSackRecMemoization(wt,val,W,n-1);
        }

    }
}
