package ps.bs;

import java.util.Arrays;

public class FindElementinRowAndColumnWiseSortedArray {
    public static void main(String[] args) {
        int mat[][] = { {10, 20, 30, 40},
                {15, 25, 35, 45},
                {27, 29, 37, 48},
                {32, 33, 39, 50}};
        int x = 29;
        int m= mat.length;
        int n=(m>0)?mat[0].length:0;
        int [] foundAt=findElement(mat,m,n,x);
        System.out.println("found at :"+ Arrays.toString(foundAt));

    }

    private static int[] findElement(int[][] mat, int m, int n, int ele) {
        int i=0, j=n-1;
        while(i>=0 && i<m && j>=0 && j<n){
            if(mat[i][j]==ele){
                return new int[]{i,j};
            }else if(mat[i][j]>ele){
                j--;
            }else{
                i++;
            }
        }
        return new int[]{-1,-1};
    }
}
