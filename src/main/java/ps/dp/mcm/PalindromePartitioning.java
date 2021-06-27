package ps.dp.mcm;

import java.util.Arrays;

public class PalindromePartitioning {
    int [][] mem;

    public static void main(String[] args) {
        PalindromePartitioning palindromePartitioning = new PalindromePartitioning();
        //palindromePartitioning.solveRec("nitik",0,4);
        System.out.println("Min number of Partition "+    palindromePartitioning.solveRec("nitik",0,4));
        System.out.println("Min number of Partition "+    palindromePartitioning.minCut("nitik"));
    }
    public int minCut(String A) {
        int n=A.length();
        mem=new int[n+1][n+1];
        for(int [] m : mem){
            Arrays.fill(m,-1);
        }

        System.out.println("Min number of partition at k :"+solveRec(A,0,n-1));
        return solve(A,0,n-1);
    }

    private int solveRec(String s, int i, int j) {
        if(i>=j)
            return 0;
        if(isPalindrome(s,i,j))
            return 0;
        int min=Integer.MAX_VALUE;

        for(int k=i; k<j; k++){
            int tmp=solveRec(s,i,k)+solveRec(s,k+1,j)+1;// 1 Partition at idx k
            if(min>tmp){
                min=tmp;
            }
        }
        return min;
    }

    int solve(String A,int i, int j){
        if(i>=j)
            return 0;
        if(isPalindrome(A,i,j)){
            return 0;
        }
        if(mem[i][j]!=-1){
            return mem[i][j];
        }
        int min=Integer.MAX_VALUE;

        for(int k=i; k<j; k++){
            int left=0;
            if(mem[i][k]==-1){
                left=solve(A,i,k);
                mem[i][k]=left;

            }else{
                left =mem[i][k];
            }

            int right=0;
            if(mem[k+1][j]==-1){
                right=solve(A,k+1,j);
                mem[k+1][j]=right;

            }else{
                right=mem[k+1][j];
            }
            int tmp=left+right+1;
            mem[i][j]=tmp;
            min=Math.min(min,tmp);
        }
        return mem[i][j]=min;
    }

    boolean isPalindrome(String in, int s, int e){{
        if(s>e || in.length()<2)
            return true;

        while(e>s){
            if(in.charAt(s)==in.charAt(e)){
                s++;e--;
            }else{
                return false;
            }
        }
        return true;
    }

    }

}
