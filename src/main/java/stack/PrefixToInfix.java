package stack;

import java.util.Stack;

public class PrefixToInfix {
    public static void main(String[] args)
    {
        String exp = "*-A/BC-/AKL";
        System.out.println("Infix : " + convert(exp));
    }
    static boolean isOperator(char in){
        switch (in){
            case '+':
            case '-':
            case '*':
            case '/':
            return true;
            default:return false;

        }
    }
    static String convert(String exp){
        String res="";
        Stack<String> st=new Stack<>();

        for(int i=exp.length()-1; i>=0; i--){
            char c=exp.charAt(i);
            if(isOperator(c)){
                String op1=st.pop();
                String op2=st.pop();
                String tmp=("("+op1+""+c+""+op2+")");
                st.push(tmp);


            }else{
                st.push(c+"");
            }
        }
        return st.pop() ;
    }
}
