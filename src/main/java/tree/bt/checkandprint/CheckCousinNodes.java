package tree.bt.checkandprint;

import tree.Node;

public class CheckCousinNodes {
    public static void main(String args[])
    {
        
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.left.right.right = new Node(15);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        root.right.left.right = new Node(8);

        Node Node1, Node2;
        Node1 = root.right.left;
        Node2 = root.right.right;
        if (isCousin(root, Node1, Node2))
            System.out.println("Yes");
        else
            System.out.println("No");
    }

    private static boolean isCousin(Node root, Node a, Node b) {
        return (level(root,a,1)==level(root,b,1))&&(!sibling(root,a,b));
    }

    private static boolean sibling(Node root, Node a, Node b) {
        if(root==null)
            return false;

        return (root.left==a && root.right==b)||
                (root.right==a && root.left==b)||
                sibling(root.left,a,b)||
                sibling(root.right,a,b);

    }

    private static int level(Node node, Node a, int lev) {
        if(node==null)
            return 0;
        if(node==a)
            return lev;
        int l=level(node.left,a,lev+1);
        if(l!=0)
            return l;
        return level(node.right,a,lev+1);

    }

}
