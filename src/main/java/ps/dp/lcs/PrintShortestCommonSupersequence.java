package ps.dp.lcs;

public class PrintShortestCommonSupersequence {
    public static void main(String[] args) {
        String X = "AGGTAB",  Y = "GXTXAYB";
        printSCS(X,Y,X.length(),Y.length());
    }

    private static void printSCS(String str1, String str2, int m, int n) {
        //Build LCS matrix
        char [] x=str1.toCharArray();
        char [] y = str2.toCharArray();

        int t[][] = new int [m+1][n+1];
        for(int j=0; j < n+1; j++){
            t[0][j]=0;
        }
        for(int i=0; i<m+1; i++){
            t[i][0]=0;
        }
        for(int i = 1; i < m+1; i++){
            for(int j = 1; j < n+1; j++){
                if(x[i-1]==y[j-1]){
                    t[i][j]=1+t[i-1][j-1];
                }else{
                    t[i][j] = Math.max(t[i][j-1],t[i-1][j]);
                }
            }
        }

        // print SCS
        int i=m,j=n;
        String result="";

        while(i>0 && j>0){
            if(x[i-1]==y[j-1]){
                result=x[i-1]+result;
                i--;
                j--;
            }else if(t[i-1][j] > t[i][j-1]){
                result=x[i-1]+result;;
                i--;
            }else{
                result=y[j-1]+result;
                j--;
            }
        }

        while(i>0){
            result=x[i-1]+result;
            i--;
        }
        while(j>0){
            result=y[j-1]+result;
            j--;
        }
        System.out.println("Length of SCS : "+(m+n-t[m][n]));
        System.out.println("SCS : "+result);

    }
}
