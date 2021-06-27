package ps.dp.mcm;

import java.util.Arrays;

public class MatrixChainMultiplication {
    static int [][] mem;
    public static void main(String args[])
    {
        int arr[] = new int[] { 1, 2, 3, 4, 3 };
        int n = arr.length;

        System.out.println(
                "Minimum number of multiplications is "
                        + mcm(arr, 1, n - 1));

        mem=new int[n+1][n+1];
        for(int [] m: mem){
            Arrays.fill(m,-1);
        }
        System.out.println(
                "Minimum number of multiplications memoization is "
                        + mcmWithMemoization(arr, 1, n - 1));

    }

    private static int mcm(int[] arr, int i, int j) {
        if(i >= j)
            return 0;
        int min=Integer.MAX_VALUE;

        for(int k = i; k < j; k++){
            int tmp=mcm(arr,i,k)+mcm(arr,k+1,j)+arr[i-1]*arr[k]*arr[j];
            min=Math.min(tmp,min);
        }
        return min;
    }
    private static int mcmWithMemoization(int[] arr, int i, int j) {
        if(i >= j)
            return 0;

        int min=Integer.MAX_VALUE;
        if(mem[i][j]!=-1){
            return mem[i][j];
        }

        for(int k = i; k < j; k++){
            int tmp=mcm(arr,i,k)+mcm(arr,k+1,j)+arr[i-1]*arr[k]*arr[j];
            min=Math.min(tmp,min);
        }
        return mem[i][j]=min;
    }
}
