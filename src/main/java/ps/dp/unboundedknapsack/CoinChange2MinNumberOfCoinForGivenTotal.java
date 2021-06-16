package ps.dp.unboundedknapsack;

public class CoinChange2MinNumberOfCoinForGivenTotal {
    public static void main (String[] args)
    {
        int coins[] = {9, 6, 5, 1};
        int n = coins.length;
        int total = 11;
        System.out.println ( "Minimum coins required is "
                + minCoins(coins, n, total));
    }

    private static int minCoins(int[] coins, int n, int total) {

        int [][] t = new int[coins.length+1][total+1];
        int maxValue=Integer.MAX_VALUE-1;
        for(int j=0; j<total+1; j++){
            t[0][j]=maxValue;
        }
        for(int i=1; i<coins.length+1; i++){
            t[i][0]=0;
        }
        for(int j=1; j<total+1; j++){
            if(j%coins[0]==0)
                t[1][j]=(j/coins[0]);
            else
                t[1][j]=maxValue;
        }

        for(int i=2; i<coins.length+1; i++){
            for(int j=1; j<total+1; j++){
                if(coins[i-1]<=j){
                    t[i][j]=Math.min(t[i-1][j],1+t[i][j-coins[i-1]]);
                }else{
                    t[i][j]=t[i-1][j];
                }
            }
        }
        return t[n][total];
    }
}
