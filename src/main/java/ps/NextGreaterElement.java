package ps;

import java.sql.SQLOutput;
import java.util.Arrays;
import java.util.Stack;

public class NextGreaterElement {
    public static void main(String[] args) {
        int arr[] = { 11, 13, 21, 3 };

        int [] nge=evalNGE(arr);

        System.out.println(Arrays.toString(nge));
    }

    private static int[] evalNGE(int[] arr) {
        int [] nge=new int[arr.length];
        Stack<Integer> stack=new Stack<>();

        for(int i = arr.length -1; i>=0; i--){
            if(!stack.isEmpty()){
                while(!stack.isEmpty()&& stack.peek()<arr[i]){
                    stack.pop();
                }
            }

            nge[i]=(stack.isEmpty())?-1:stack.peek();
            stack.push(arr[i]);

        }
        return nge;
    }
}
