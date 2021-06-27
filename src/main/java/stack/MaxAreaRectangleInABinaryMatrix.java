package stack;

import java.util.Arrays;

public class MaxAreaRectangleInABinaryMatrix {
    public static void main(String[] args)
    {
        int R = 4;
        int C = 4;

        int A[][] = {
                { 0, 1, 1, 0 },
                { 1, 1, 1, 1 },
                { 1, 1, 1, 1 },
                { 1, 1, 0, 0 },
        };
        System.out.print("Area of maximum rectangle is "
                + maxRectangle(R, C, A));
    }

    private static int maxRectangle(int r, int c, int[][] mat) {
        int [] auxArr=new int[c];
        for(int j=0; j<c; j++){
            auxArr[j]=mat[0][j];
        }
        int maxArea=MaximumAreaHistogram.getMaxArea(auxArr,c);
        System.out.println("maxArea"+maxArea);
        System.out.println("aux"+ Arrays.toString(auxArr));
        for(int i=1; i<r; i++){
            for(int j=0; j<c; j++){
                if(mat[i][j]==0){
                    auxArr[j]=0;
                }else{
                    auxArr[j]=  auxArr[j]+1;
                }
            }

            int area=MaximumAreaHistogram.getMaxArea(auxArr,c);
            maxArea=Math.max(maxArea,area);
            System.out.println("maxArea"+maxArea);
            System.out.println("aux"+ Arrays.toString(auxArr));
        }
        return maxArea;
    }
}
