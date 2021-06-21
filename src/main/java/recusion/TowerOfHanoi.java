package recusion;

public class TowerOfHanoi {
    static int totalMove=0;
    public static void main(String[] args) {
        int n=4, s=1, h=2, d=3;
        solve(s,d,h,n);
        System.out.println("Total number of move : "+totalMove);

    }

    private static void solve(int s, int d, int h, int n) {
        if(n==1){
            System.out.printf("Moving plate %d th from %d to %d",n,s,d);
            totalMove++;
            System.out.println();
            return;
        }
        solve(s,h,d,n-1);
        System.out.printf("Moving plate %d th from %d to %d",n,s,d);
        totalMove++;
        System.out.println();
        solve(h,d,s,n-1);

    }
}
