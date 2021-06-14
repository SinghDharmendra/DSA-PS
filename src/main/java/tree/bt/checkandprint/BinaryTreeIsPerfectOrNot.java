package tree.bt.checkandprint;

import tree.Node;

public class BinaryTreeIsPerfectOrNot {
    public static void main(String[] args) {
        Node root = null;
        root = new Node(10);
        root.left = new Node(20);
        root.right = new Node(30);

        root.left.left = new Node(40);
        root.left.right = new Node(50);
        root.right.left = new Node(60);
        root.right.right = new Node(70);

        if (isPerfect(root) == true)
            System.out.println("Yes");
        else {
            System.out.println("No");
        }
    }

    private static boolean isPerfect(Node root) {
        int depth=depth(root);
        return checkCBT(root,depth,0);
    }

    private static boolean checkCBT(Node root, int depth, int level) {
        if(root==null)
            return true;
        if(root.left==null && root.right==null)
            return (level+1==depth);
        if(root.left==null || root.right==null)
            return false;

        return checkCBT(root.left,depth,level+1)&&checkCBT(root.right,depth,level+1);

    }

    private static int depth(Node node) {
        if(node==null)
            return 0;
        int d=0;
        while(node!=null){
            node=node.left;
            d++;
        }

        return d;
    }
}
