package tree.bt.checkandprint;

import tree.Node;

public class BinaryTreeIsSumTree {
    public static void main (String[] args)
    {
       Node root=new Node(26);
       root.left=new Node(10);
       root.right=new Node(3);
       root.left.left=new Node(4);
       root.left.right=new Node(6);
       root.right.right=new Node(3);
        if(isSumTree(root) != 0)
        {
            System.out.println("The given tree is a SumTree");
        }
        else
        {
            System.out.println("The given tree is not a SumTree");
        }
    }

    private static int isSumTree(Node root) {
        if(root==null|| (root.left==null && root.right==null))
            return 1;
        int l=sum(root.left);
        int r=sum(root.right);

        if( (root.data==(l+r)) && isSumTree(root.left)==1&&isSumTree(root.left)==1)
            return 1;
        return 0;

    }

    private static int sum(Node node) {
        if(node==null)
            return 0;
        return sum(node.left) + sum(node.right)+node.data;
    }
}
