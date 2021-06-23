package recusion;

public class PermutationOfString {

    static int count=0;
    public static void main(String[] args) {
        String in="ABCD";
        printAll(in,"");
        System.out.println("Total:"+count);
    }

    private static void printAll(String in, String out) {
        if(in.length()==0){
            System.out.println(out);
            count++;
        }

        for(int i=0; i<in.length(); i++){
            char c =in.charAt(i);
            String newIn=in.substring(0,i)+in.substring(i+1);
            //System.out.println("in:"+newIn+",out:"+(out+c));
            printAll(newIn,out+c);

        }
    }
}
