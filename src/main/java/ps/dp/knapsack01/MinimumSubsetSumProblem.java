package ps.dp.knapsack01;

import java.util.ArrayList;
import java.util.List;

public class MinimumSubsetSumProblem {
    public static void main(String[] args) {
        int arr[] = {3, 1, 4, 2, 2, 1};
        int n = arr.length;
        System.out.println("The minimum difference between 2 sets is "
                + findMin(arr, n));

    }

    private static int findMin(int[] arr, int n) {
        int sum = 0;
        for (int ar : arr) {
            sum += ar;
        }

        int[] subsetSums = subSetSum(arr, sum, n);
        int minDiff = Integer.MAX_VALUE;
        for(int subSetSum: subsetSums){
            minDiff=Math.min(sum-2*subSetSum,minDiff);
        }
        return minDiff;
    }

    private static int[] subSetSum(int[] arr, int sum, int n) {
        boolean t[][] = new boolean[n + 1][sum + 1];

        for (int j = 1; j < sum + 1; j++) {
            t[0][j] = false;

        }
        for (int i = 0; i < n + 1; i++) {
            t[i][0] = true;

        }

        for(int i=1; i<n+1; i++){
            for(int j=1; j<sum+1; j++){
                if(arr[i-1]<=j){
                    t[i][j]=t[i-1][j-arr[i-1]]|| t[i-1][j];
                }
                else{
                    t[i][j]= t[i-1][j];
                }
            }
        }
        List<Integer>  subSetExists=new ArrayList<>();

        for(int j = sum/2; j>0; j--){
            if(t[n][j]==true){
                subSetExists.add(j);
            }
        }
        return subSetExists.stream().mapToInt(Integer::intValue).toArray();


    }

}
