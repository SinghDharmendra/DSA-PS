package stack.basic;

import java.util.Arrays;
import java.util.Stack;

/**
 * Next Smaller to left
 * Also considers poplation of NSL index;
 */


public class NSL {
    public static void main(String[] args) {
        int N = 5;
        int arr[] ={6, 8, 0, 1, 3};
        int pseudoIndex=-1;

        // NLR
        int  right []= nextSmallerElementFromLeft(arr,N,pseudoIndex);
        System.out.println(Arrays.toString(right));
    }
    public static int[] nextSmallerElementFromLeft(int[] arr, int n,int pseudoIndex) {
        Stack<Pair> st = new Stack<>();
        int result [] = new int [n];
        int resultIndex [] = new int [n];

        for(int i=0; i<n; i++){
            if(st.isEmpty()){
                result[i]=pseudoIndex;
                resultIndex [i]=pseudoIndex;
            }else if(!st.isEmpty() && st.peek().num<=arr[i]){
                result[i]=st.peek().num;
                resultIndex[i]=st.peek().index;
            }else if(!st.isEmpty() && st.peek().num>arr[i]){
                while(!st.isEmpty() && st.peek().num>arr[i]){
                    st.pop();
                }
                if(st.isEmpty()){
                    result[i]=pseudoIndex;
                    resultIndex[i]=pseudoIndex;
                }else{
                    result[i]=st.peek().num;
                    resultIndex[i]=st.peek().index;
                }
            }
            st.push(new Pair(arr[i],i));
        }

        System.out.println(Arrays.toString(result));
        return resultIndex;

    }
}
