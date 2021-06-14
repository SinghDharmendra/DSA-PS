/*
package stack;

import java.util.Stack;

public class infixToPostfix {
    public static void main(String[] args)
    {
        String exp = "a+b*(c^d-e)^(f+g*h)-i";
        System.out.println(infixToPostfix(exp));
    }
    static String infixToPostfix(String exp){

        String result="";
        Stack<Character> st=new Stack<>();
        for(int i=0; i<exp.length(); i++){
            char c=exp.charAt(i);

            if(Character.isLetterOrDigit(c)){
                result+=c;
            }else if(c=='('){
                st
            }
        }

    }

    int prec(char c){
        switch (c){
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;

            case '^':
                return 3;

            default: return -1;

        }
    }
}
*/
