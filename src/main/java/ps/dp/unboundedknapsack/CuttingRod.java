package ps.dp.unboundedknapsack;

public class CuttingRod {
    public static void main(String args[])
    {
        int arr[] = new int[] {1, 5, 8, 9, 10, 17, 17, 20};
        int size = arr.length;
        System.out.println("Maximum Obtainable Value is " +
                cutRod(arr, size));
    }

    private static int cutRod(int[] prices, int size) {
        int [][] t = new int[prices.length+1][size+1];

        for(int j=1; j<size+1; j++)
            t[0][j]=0;
        for (int i=0; i<prices.length+1; i++){
            t[i][0]=0;
        }

        for(int i=1; i< t.length; i++){
            for(int j=1; j<t[0].length; j++){
                if(i+1<=j)
                    t[i][j]=Math.max(t[i-1][j],prices[i]+t[i][j-i-1]);
                else
                    t[i][j]=t[i-1][j];
            }
        }
        return t[prices.length][size];
    }
}
