package recusion;

public class KthSymbolInGrammer {
    public static void main(String[] args) {
        int N=4, k=5;
        int val=findKthSymbol(N,k);
        System.out.println(val);
        KthSymbolInGrammer kthSymbolInGrammer=new KthSymbolInGrammer();

    }

    private static int findKthSymbol(int n, int k) {
        if(n==1 && k==1)
            return 0;
        int mid = (int)Math.pow(2,n-1)/2;
        System.out.println("mid"+mid);
        if(k <= mid){
            return findKthSymbol(n-1,k);
        }else {
            //return (findKthSymbol(n-1,k-mid)==0?1:0);
            return (findKthSymbol(n-1,k-mid)^1);
        }

    }
    public int kthGrammar(int n, int k) {

        if(n==1 && k==1)
            return 0;

        int mid = (int) Math.pow(2,n-1)/2;
        if(k<=mid){
            return kthGrammar(n-1, k);
        }

        else
            return ( kthGrammar(n-1,k-mid))^1 ;
    }
}