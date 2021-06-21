package recusion;

import java.util.Stack;

public class ReverseStack {
    public static void main(String[] args) {
        Stack<Integer> st = new Stack<>();
        st.push(1);
        st.push(5);
        st.push(2);
        st.push(11);
        st.push(4);
        reverse(st);
        System.out.println(st);
    }

    private static void reverse(Stack<Integer> st) {
        if(st.size()<1)
            return;
        int tmp=st.pop();
        reverse(st);
        insertAtBegin(st,tmp);
    }

    private static void insertAtBegin(Stack<Integer> st, int tmp) {
        if(st.isEmpty()){
            st.push(tmp);
            return;
        }
        int val=st.pop();
        insertAtBegin(st,tmp);
        st.push(val);
    }
}
