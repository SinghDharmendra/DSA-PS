package ps.dp.knapsack01;

public class SubSetSumProblem {
    public static void main(String args[])
    {
        int set[] = { 3, 34, 4, 12, 8, 10 };
        int sum = 9;
        int n = set.length;
        if (isSubsetSum(set, n, sum) == true)
            System.out.println("Found a subset"
                    + " with given sum");
        else
            System.out.println("No subset with"
                    + " given sum");
    }

    private static boolean isSubsetSum(int[] arr, int n, int W) {
        boolean t [][] = new boolean[n+1][W+1];
        //init
        for(int j=1; j<W+1; j++){
            t[0][j]=false;
        }
        for(int i=0; i<n+1; i++){
            t[i][0]=true;
        }

        for(int i=1; i < n+1; i++){
            for(int j=1; j<W+1; j++){
                if(arr[i-1]<=j){
                    t[i][j]=t[i-1][j-arr[i-1]] || t[i-1][j];
                }else{
                    t[i][j]= t[i-1][j];
                }
            }
        }
        return t[n][W];
    }
}
