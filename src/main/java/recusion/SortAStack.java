package recusion;

import java.util.Stack;

public class SortAStack {
    public static void main(String[] args) {
        Stack<Integer> st = new Stack<>();
        st.push(1);
        st.push(5);
        st.push(2);
        st.push(11);
        st.push(4);
        sort(st);
        System.out.println(st);
    }
    static void  sort( Stack<Integer> st) {
        if(st.size()<=1 )
            return;
       int tmp=st.pop();
        sort(st);
       insert(st,tmp);


    }

    private static void insert(Stack<Integer> st, int tmp) {

        if(st.size()==0 || st.peek()<=tmp)
        {
            st.push(tmp);
            return;
        }
        int val=st.pop();
        insert(st,tmp);
        st.push(val);
    }
}
