package tree.traverse;

import tree.Node;

import java.util.Stack;

public class IterativeTraversal {
    public static void main(String args[])
    {
       

       Node root = new Node(10);
       root.left = new Node(20);
       root.right = new Node(30);
       root.left.left = new Node(40);
       root.left.left.left = new Node(70);
       root.left.right = new Node(50);
       root.right.left = new Node(60);
       root.left.left.right = new Node(80);
       IterativeTraversal it=new IterativeTraversal();

        // PreOrder Traversal
        //Iterative way
        it.preOrderTraversal(root);
        /**
         * Inoreder iterative traversal
         */
        it.inOrderTraversal(root);
        /**
         * Post Order iterative traversal
         */
        it.postOrderTraversal(root);
    }

    private void postOrderTraversal(Node root) {
        if(root == null){
            return;
        }
        Stack<Node> st=new Stack<>();
        Node current=root;
        while(current!=null || !st.isEmpty()){
            while(current!=null){
                st.push(current);
                current=current.left;
            }

        }

    }

    public void inOrderTraversal(Node node){
        if(node==null)
            return;
        Stack<Node> st = new Stack<>();
        Node current=node;
        while(!st.isEmpty() || current!=null){
            while(current!=null){
                st.push(current);
                current=current.left;
            }
            current = st.pop();
            System.out.println(current.data);
            current=current.right;
        }
    }
    public void preOrderTraversal(Node node){
        if(node==null)
            return;
        Stack<Node> st=new Stack<>();
        Node current=node;
        while(node!=null || !st.isEmpty()){
            while(current!=null){
                System.out.println(current.data);
                if(current.right!=null)
                    st.push(current.right);
                current=current.left;
            }
            if(!st.isEmpty()){
                current=st.pop();
            }
        }
    }
}
