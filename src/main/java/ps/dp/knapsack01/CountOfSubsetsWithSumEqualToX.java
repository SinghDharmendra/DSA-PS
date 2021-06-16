package ps.dp.knapsack01;

public class CountOfSubsetsWithSumEqualToX {
    public static void main(String []args)
    {
        int arr[] = {5,5,5,5,4,4,4,4,3,3,3,3};
        int n = arr.length;
        int x = 12;

        System.out.println(findCnt(arr, x, n));
    }

    public static int findCnt(int[] arr, int W, int n) {
        int [][] t = new int[n+1][W+1];

        for(int j=1; j<W+1; j++){
            t[0][j]=0;
        }
        for(int i=0; i<n+1; i++){
            t[i][0]=1;
        }

        for(int i=1; i < n+1; i++){
            for(int j=1; j<W+1; j++){
                if(arr[i-1]<=j){
                    t[i][j]=t[i-1][j-arr[i-1]] + t[i-1][j];
                }else{
                    t[i][j]= t[i-1][j];
                }
            }
        }
        return t[n][W];
    }

}
