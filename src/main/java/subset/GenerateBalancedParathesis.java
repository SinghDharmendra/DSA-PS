package subset;

public class GenerateBalancedParathesis {
    public static void main(String[] args) {
        int n=3;

        generateAllBalancedPrathesis("",0,0,n);
    }

    private static void generateAllBalancedPrathesis(String s, int open, int close, int n) {
        if(s.length()==2*n){
            System.out.println(s);
            return;
        }
        if(open<n){
            generateAllBalancedPrathesis(s+"(",open+1,close,n);
        }
        if(close<open){
            generateAllBalancedPrathesis(s+")",open,close+1,n);
        }
    }
}
