package ps.dp.lcs;

public class NumberOfInsertionDeletionToMakeAStringPalindrome {
    /**
     * This problem relates to LPS->LCS
     * No of Insertion =No of Deletion = str.length() - LPS
     * LPS= LCS(str,reverse(str))
     * @param args
     */
    public static void main(String[] args) {
        String in ="bbbab";
        int iMin= minInsertionToConvertIntoPalindrome(in);
        int dMin= minDeletionToConvertIntoPalindrome(in);
        System.out.println(iMin);
        System.out.println(dMin);

    }

    private static int minDeletionToConvertIntoPalindrome(String in) {
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
        return m-t[m][n];
    }

    private static int minInsertionToConvertIntoPalindrome(String in) {
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
        return m-t[m][n];
    }
}
