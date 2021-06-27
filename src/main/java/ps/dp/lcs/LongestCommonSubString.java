package ps.dp.lcs;

import java.util.Arrays;

public class LongestCommonSubString {
    static int mem[][];

    public static void main(String[] args)
    {
        LongestCommonSubString lcs = new LongestCommonSubString();
        String s1 = "babad";
        String s2 = "dabab";

        char[] X=s1.toCharArray();
        char[] Y=s2.toCharArray();
        int m = X.length;
        int n = Y.length;

        System.out.println("Length of LCS is" + " " +
                lcs.lcs( X, Y, m, n ) );

    }



    private int lcs(char[] x, char[] y, int m, int n) {
        int t[][]=new int[m+1][n+1];
        for(int j=1; j<n+1; j++){
            t[0][j]=0;
        }

        for(int i=0; i<m+1; i++){
            t[i][0]=0;
        }

        int maxLength=Integer.MIN_VALUE;
        int endIdx=-1;

        for (int i = 1; i<m+1; i++){
            for(int j = 1;j<n+1; j++){
                if(x[i-1]==y[j-1]){
                    t[i][j]=1+t[i-1][j-1];

                    if(maxLength<t[i][j] && isPalindrome(y,j-t[i][j],j-1)) {
                        endIdx=j;
                        maxLength=t[i][j];
                    }
                }else{
                    t[i][j]=0;
                }

            }
        }
        for(int tmp[] : t){
            System.out.println(Arrays.toString(tmp));
        }
        System.out.println("endIdx: "+endIdx);
        System.out.println(y.toString());
        System.out.println("LCString : "+(new String(y)).substring(endIdx-maxLength,endIdx));
        return maxLength;
    }

    private boolean isPalindrome(char[] y, int l, int r) {
        while(l<r){
            if(y[l]==y[r]){
                l++;
                r--;
            }else{
                return false;
            }

        }
        return true;
    }
}
