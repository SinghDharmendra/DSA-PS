package ps.dp;

public class EqualSumPartitionProblem {
    public static void main(String[] args)
    {
        int arr[] = { 3, 1, 1, 2, 2, 1 };
        int n = arr.length;
        if (findPartition(arr, n) == true)
            System.out.println(
                    "Can be divided into two subsets of equal sum");
        else
            System.out.println(
                    "Can not be divided into two subsets of equal sum");
    }

    private static boolean findPartition(int[] arr, int n) {
        int sum=0;
        for(int ar: arr){
            sum+=ar;
        }
        if(sum%2!=0)
            return false;
        else
            return subSetSumProblem(arr,sum/2,n);
    }

    private static boolean subSetSumProblem(int[] arr, int W, int n) {
        boolean t[][] = new boolean[n+1][W+1];
        for(int j=1; j<W+1; j++){
            t[0][j]=false;
        }

        for(int i=0; i<n+1; i++){
            t[i][0]=true;
        }

        for(int i = 1; i<n+1; i++){
            for(int j = 1; j < W+1; j++){
                if(arr[i-1]<=j){
                    t[i][j]=t[i-1][j-arr[i-1]] || t[i-1][j];
                }else {
                    t[i][j]= t[i-1][j];
                }
            }
        }
        return t[n][W];
    }
}
