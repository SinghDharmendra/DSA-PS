package ps.dp.lcs;

public class LongestPalindromeSubsequence {
    public static void main(String[] args) {
        /**
         * This problem is based out of LCS
         */

        String in ="bbbab";
        int lpsLength=lps(in);
        System.out.println("lpsLength : "+lpsLength);
    }

    private static int lps(String in) {
        char x[] = in.toCharArray();
        char y[] = (new StringBuilder(in).reverse().toString()).toCharArray();
        int m=x.length;
        int n=y.length;
        int [][] t = new int[m+1][n+1];

        //init which is zero

        for(int i = 1; i < m+1; i++){
            for(int j = 1; j < n+1; j++){
                if(x[i-1]==y[j-1]){
                    t[i][j] = 1 +t[i-1][j-1];
                }else{
                    t[i][j] = Math.max(t[i-1][j], t[i][j-1]);
                }
            }
        }
        return t[m][n];

    }
}
