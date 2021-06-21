package subset;

public class SubSetProblem {
    public static void main(String[] args) {
        String in="ab";
        String out="";
        solve(in,out);
    }

    private static void solve(String in, String out) {
        if(in.length()==0){
            System.out.println(out);
            return;
        }
        solve(in.substring(1),out);
        solve(in.substring(1),out+in.charAt(0));
    }
}
