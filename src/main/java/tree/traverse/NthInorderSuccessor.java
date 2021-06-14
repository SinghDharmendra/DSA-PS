package tree.traverse;

import tree.Node;

public class NthInorderSuccessor {
    static int count=0;
    public static void main(String[] args) {
        Node root = new Node(10);
        root.left = new Node(20);
        root.right = new Node(30);
        root.left.left = new Node(40);
        root.left.right = new Node(50);

        int n = 5;

        NthInorder(root, n);
    }

    private static void NthInorder(Node root, int n) {
        if(root==null)
            return;
        if(count<=n){
            NthInorder(root.left,n);
            count++;
            if(count==n)
                System.out.println(root.data);

            NthInorder(root.right,n);

        }



    }
}
