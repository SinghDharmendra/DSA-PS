package ps.dp.unboundedknapsack;

public class CoinChange1MaxNumberOfWays {
    public static void main(String args[])
    {
        int arr[] = {1, 2, 3};
        int m = arr.length;
        int n = 4;
        System.out.println(countWays(arr, m, n));
    }

    private static int countWays(int[] coin, int n, int total) {

        int [][] t=new int[coin.length+1][total+1];
        for(int j = 0; j<total+1; j++){
            t[0][j]=0;
        }
        for(int i = 0; i < coin.length+1; i++){
            t[i][0]=1;
        }

        for(int i=1; i<coin.length+1; i++){
            for(int j =0 ; j < total+1; j++){
                if(coin[i-1]<=j){
                    t[i][j]=t[i-1][j]+t[i][j-coin[i-1]];
                }else{
                    t[i][j]=t[i-1][j];
                }
            }
        }
        return t[coin.length][total];

    }
}
