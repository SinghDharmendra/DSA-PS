package ps.dp.lcs;

import java.util.Arrays;

public class LongestCommonSubsequence {
    static int mem[][];
    public static void main(String[] args)
    {
        LongestCommonSubsequence lcs = new LongestCommonSubsequence();
        String s1 = "AGGTAB";
        String s2 = "GXTXAYB";

        char[] X=s1.toCharArray();
        char[] Y=s2.toCharArray();
        int m = X.length;
        int n = Y.length;

        System.out.println("Length of LCS is" + " " +
                lcs.lcs( X, Y, m, n ) );
        System.out.println("Length of LCS is" + " " +
                lcs.lcsRec( X, Y, m, n ) );
        mem=new int[m+1][n+1];
        for(int [] me: mem){
        Arrays.fill(me,-1);
        }
        System.out.println("Length of LCS is" + " " +
            lcs.lcsRecMemoization( X, Y, m, n ) );

    }

    private int lcsRecMemoization(char[] x, char[] y, int m, int n) {
        if(m==0 || n==0)
            return 0;

        if(mem[m][n]!=-1)
            return mem[m][n];

        if(x[m-1]==y[n-1]){
            return mem[m][n]=1+lcsRec(x,y,m-1,n-1);
        }else{
            return mem[m][n]=Math.max(lcsRec(x,y,m,n-1),lcsRec(x,y,m-1,n));
        }
    }

    private int lcsRec(char[] x, char[] y, int m, int n) {
        if(m==0 || n==0)
            return 0;
        if(x[m-1]==y[n-1]){
            return 1+lcsRec(x,y,m-1,n-1);
        }else{
            return Math.max(lcsRec(x,y,m,n-1),lcsRec(x,y,m-1,n));
        }
    }

    private int lcs(char[] x, char[] y, int m, int n) {
        int t[][]=new int[m+1][n+1];
        for(int j=0; j<n+1; j++){
            t[0][j]=0;
        }

        for(int i=0; i<m+1; i++){
            t[i][0]=0;
        }

        for (int i = 1; i<m+1; i++){
            for(int j = 1;j<n+1; j++){
                if(x[i-1]==y[j-1]){
                    t[i][j]=1+t[i-1][j-1];
                }else{
                    t[i][j]=Math.max(t[i-1][j],t[i][j-1]);
                }
            }
        }
        return t[m][n];
    }
}
