package stack.basic;

import java.util.Arrays;
import java.util.Stack;

/**
 * Nearest greater from right
 */
public class NGR {
    public static void main(String args[]) {
        int arr[] = {11, 13, 21, 3};
        int n = arr.length;
        nextSmallerElementFromRight(arr, n, -1);
    }

    public static int[] nextSmallerElementFromRight(int[] arr, int n, int pseudoIndex) {
        Stack<Pair> st = new Stack<>();
        int result[] = new int[n];
        int resultIndex[] = new int[n];

        for (int i = n - 1; i >= 0; i--) {
            if (st.isEmpty()) {
                result[i] = pseudoIndex;
                resultIndex[i] = pseudoIndex;
            } else if (!st.isEmpty() && st.peek().num > arr[i]) {
                result[i] = st.peek().num;
                resultIndex[i] = st.peek().index;
            } else if (!st.isEmpty() && st.peek().num <= arr[i]) {
                while (!st.isEmpty() && st.peek().num <= arr[i]) {
                    st.pop();
                }
                if (st.isEmpty()) {
                    result[i] = pseudoIndex;
                    resultIndex[i] = pseudoIndex;
                } else {
                    result[i] = st.peek().num;
                    resultIndex[i] = st.peek().index;
                }
            }
            st.push(new Pair(arr[i], i));
        }

        System.out.println("NSR" + Arrays.toString(result));
        return resultIndex;

    }
}
