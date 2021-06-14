package tree.bt.checkandprint;

import tree.Node;

public class BinaryTree {
    public static void main(String[] args)
    {

        Node root = new Node(17);
        root.left = new Node(8);
        root.right = new Node(2);
        root.left.left = new Node(3);
        root.left.right = new Node(5);
        root.right.right = new Node(2);
        if (isSumProperty(root) != 0)
            System.out.println("The given tree satisfies children"
                    + " sum property");
        else
            System.out.println("The given tree does not satisfy children"
                    + " sum property");
    }

    private static int isSumProperty(Node node) {

        if(node==null ||(node.left==null && node.right==null))
            return 1;
        int leftData=0;
        int rightData=0;


        if(node.left!=null)
            leftData=node.left.data;
        if(node.right!=null)
            rightData=node.right.data;

        if(node.data==(leftData+rightData)&& isSumProperty(node.left)!=0 &&
        isSumProperty(node.right)!=0)
            return 1;
        else
        return 0;
    }
}
