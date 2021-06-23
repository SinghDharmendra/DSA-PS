package recusion;

public class PrintNbitBinaryNumberHavingMoreOnceThenZero {
    public static void main(String[] args) {
        int n=5;
        solve("",0,0,n);
    }

    private static void solve(String out, int one, int zero, int n) {
        if(n==0){
            System.out.println(out);
            return;
        }
        solve(out+"1",one+1,zero,n-1);
        if(zero<one){
            solve(out+"0",one,zero+1,n-1);
        }
    }
}
