package ps.dp.lcs;

public class PrintLCS {
    public static void main(String[] args) {
        String s1 = "AGGTAB";
        String s2 = "GXTXAYB";

        char[] X=s1.toCharArray();
        char[] Y=s2.toCharArray();
        int m = X.length;
        int n = Y.length;

        System.out.println(" LCS is" + " " +
               lcs( X, Y, m, n ) );
    }

    private static String lcs(char[] x, char[] y, int m, int n) {
        int [][] t = new int [m+1][n+1];
        for(int j = 1; j < n+1; j++){
            t[0][j]=0;
        }
        for(int i = 0; i < m+1; i++){
            t[i][0]=0;
        }
        for(int i = 1; i < m+1; i++){
            for(int j = 1; j < n+1; j++){
                if(x[i-1]==y[n-1]){
                    t[i][j]=1+t[i-1][j-1];
                }else{
                    t[i][j]=Math.max(t[i-1][j] , t[i][j-1]);
                }
            }
        }

        // print LCS
        String result="";
        int i=m,j=n;

        while(i>0 &&  j>0){
            if(x[i-1]==y[j-1]){
                result=x[i-1]+result;
                i--;
                j--;
            }else if(t[i-1][j]>t[i][j-1]){
                i--;
            }else{
                j--;
            }
        }
        return result;
    }
}
