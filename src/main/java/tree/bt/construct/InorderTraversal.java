package tree.bt.construct;

import tree.Node;

public class InorderTraversal {
    public static void main(String[] args) {
        Node root=new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        System.out.println("inorder");
        inorder(root);
        System.out.println("\npostorder");
        postorder(root);
        System.out.println("\npreorder");
        preorder(root);



    }

    private static void preorder(Node root) {
        if(root==null)
            return;
        System.out.print(root.data+" ");
        preorder(root.left);
        preorder(root.right);


    }

    private static void postorder(Node root) {
        if(root==null)
            return;
        postorder(root.left);

        postorder(root.right);
        System.out.print(root.data+" ");
    }

    private static void inorder(Node root) {
        if(root==null)
            return;
        inorder(root.left);
        System.out.print(root.data+" ");
        inorder(root.right);
    }
}
