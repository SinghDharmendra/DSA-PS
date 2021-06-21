package ps.dp.lcs;

public class MInNumberOfInsertDeletionToCovertAStringIntoAnother {
    public static void main(String[] args) {
        String str1 = new String("heap");
        String str2 = new String("pea");

        // Function Call
        System.out.println(printMinDelAndInsert(str1, str2));

    }

    private static int printMinDelAndInsert(String str1, String str2) {
        char [] X=str1.toCharArray();
        char [] Y=str2.toCharArray();
        int m=str1.length();
        int n=str2.length();

        int t[][]= new int [m+1][n+1];

        for(int i=0; i<m+1; i++){
            t[i][0]=0;
        }
        for(int j = 1; j < n+1; j++){
            t[0][j]=0;
        }

        for(int i = 1; i < m+1; i++){
            for(int j = 1; j < n+1; j++){
                if(X[i-1]==Y[j-1]){
                    t[i][j] = 1 + t[i-1][j-1];
                }else{
                    t[i][j] = Math.max( t[i-1][j],t[i][j-1]);
                }
            }
        }

        return m+n-2*t[m][n];


    }
}
/**
 * TC : O(m*n)
 * SC : O(m*n)
 */