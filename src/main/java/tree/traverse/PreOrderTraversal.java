package tree.traverse;

import tree.Node;

import java.util.Stack;

public class PreOrderTraversal {
    public static void main(String[] args) {
       
       Node root = new Node(10);
       root.left = new Node(8);
       root.right = new Node(2);
       root.left.left = new Node(3);
       root.left.right = new Node(5);
       root.right.left = new Node(2);
        iterativePreorder(root);
    }

    private static void iterativePreorder(Node root) {
        if (root==null)
            return;
        Stack<Node> st=new Stack<>();
        st.push(root);

        while (!st.isEmpty()){
            Node popped=st.pop();
            System.out.print(popped.data+" ");
            if(popped.right!=null)
                st.push(popped.right);
            if(popped.left!=null)
                st.push(popped.left);

        }

    }
}
