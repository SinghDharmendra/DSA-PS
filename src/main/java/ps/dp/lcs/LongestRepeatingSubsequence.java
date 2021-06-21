package ps.dp.lcs;

import java.util.Arrays;

public class LongestRepeatingSubsequence {
    public static void main(String[] args) {
        String str = "AABEBCDD";
        System.out.println(longestRepeatedSubSeq(str));
    }

    private static int longestRepeatedSubSeq(String str) {
        char x[]=str.toCharArray();
        char y[]=str.toCharArray();
        int m=str.length(),n=str.length();
        int t[][] = new int [m+1][n+1];
        for(int j=0; j < n+1; j++){
            t[0][j]=0;
        }
        for(int i=0; i<m+1; i++){
            t[i][0]=0;
        }
        for(int i = 1; i < m+1; i++){
            for(int j = 1; j < n+1; j++){
                if(x[i-1]==y[j-1] && i!=j){
                    t[i][j]=1+t[i-1][j-1];
                }else{
                    t[i][j] = Math.max(t[i][j-1],t[i-1][j]);
                }
            }
        }

        for(int t1[] : t){
            System.out.println(Arrays.toString(t1));
        }
        int i=m,j=n;
        String result="";

        while (i>0 && j>0){
            if(t[i][j]==t[i-1][j-1]+1){
               result=x[i-1]+result;
               i--;
               j--;
            }else if(t[i][j]==t[i-1][j]){

                i--;
            }else{

                j--;
            }
        }
        System.out.println(result);

        return t[m][n];
    }
}
