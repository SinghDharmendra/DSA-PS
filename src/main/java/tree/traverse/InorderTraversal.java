package tree.traverse;

import tree.Node;

import java.util.Queue;
import java.util.Stack;

public class InorderTraversal {
    public static void main(String[] args) {

        Node root = new Node(10);
        root.left = new Node(8);
        root.right = new Node(2);
        root.left.left = new Node(3);
        root.left.right = new Node(5);
        root.right.left = new Node(2);
        iterativeInorder(root);
    }

    private static void iterativeInorder(Node root) {
        if(root==null)
            return;

        Stack<Node> st=new Stack<>();
        Node cur=root;

        while(!st.isEmpty()|| cur!=null){
            while(cur!=null){
                st.push(cur);
                cur=cur.left;
            }
            cur=st.pop();
            cur=cur.right;
        }
    }
}
