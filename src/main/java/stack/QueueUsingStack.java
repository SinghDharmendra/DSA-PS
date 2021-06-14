package stack;

import java.util.Stack;

public class QueueUsingStack {
    Stack<Integer> st1=new Stack<>();
    Stack<Integer> st2=new Stack<>();

    void enQueue(int x){
        while(!st1.isEmpty()){
            st2.push(st1.pop());
        }
        st1.push(x);
        while(!st2.isEmpty()){
            st1.push(st2.pop());
        }

    }
    int deQueue(){
        if(st1.isEmpty()){
            System.out.printf("Underflow");
            return -1;
        }
        int data=st1.peek();
        st1.pop();
        return data;
    }

    public static void main(String[] args) {
        QueueUsingStack qus=new QueueUsingStack();

        qus.enQueue(1);
        qus.enQueue(2);
        qus.enQueue(3);

        System.out.printf("date popped: "+qus.st1.pop());
        System.out.printf("date popped: "+qus.st1.pop());
        System.out.printf("date popped: "+qus.st1.pop());



    }
}
