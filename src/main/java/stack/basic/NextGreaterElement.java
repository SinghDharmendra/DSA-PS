package stack.basic;

import java.util.Arrays;
import java.util.Stack;

public class NextGreaterElement {
    public static void main(String[] args) {
        int N = 5;
        long arr[] = {6, 8, 0, 1, 3};

        // NLR
        long right[] = nextLargerElementFromRight(arr, N);
        System.out.println(Arrays.toString(right));

        // NLL
        long left[] = nextLargerElementFromLeft(arr, N);
        System.out.println(Arrays.toString(left));
    }

    public static long[] nextLargerElementFromRight(long[] arr, int n) {
        Stack<Long> st = new Stack<Long>();
        int len = arr.length;
        long[] result = new long[len];

        result[len - 1] = -1;
        st.push(arr[len - 1]);
        for (int i = len - 2; i >= 0; i--) {
            long num = arr[i];

            while (!st.isEmpty() && st.peek() < num) {
                st.pop();
            }
            if (st.isEmpty()) {
                result[i] = -1;
            } else {
                result[i] = st.peek();
            }
            st.push(num);
        }
        return result;

    }

    public static long[] nextLargerElementFromLeft(long[] arr, int n) {
        Stack<Long> st = new Stack<Long>();
        int len = arr.length;
        long[] result = new long[len];

        result[0] = -1;
        st.push(arr[len - 1]);
        for (int i = 1; i < len; i++) {
            long num = arr[i];

            while (!st.isEmpty() && st.peek() < num) {
                st.pop();
            }
            if (st.isEmpty()) {
                result[i] = -1;
            } else {
                result[i] = st.peek();
            }
            st.push(num);
        }
        return result;

    }
}
