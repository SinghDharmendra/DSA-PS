package tree.bt.construct;

import tree.Node;

public class Tree {
    Node root;
    public void inOrder(Node root)
    {
        if (root != null) {
            inOrder(root.left);
            System.out.print(root.data + " ");
            inOrder(root.right);
        }
    }

    // Driver program to test above function
    public static void main(String args[])
    {
        Tree t2 = new Tree();
        int arr[] = { 1, 2, 3, 4, 5, 6, 6, 6, 6 };
        t2.root = t2.insertLevelOrder(arr, t2.root, 0);
        t2.inOrder(t2.root);
    }

    private Node insertLevelOrder(int[] arr, Node root, int i) {
        if(i<arr.length){
            root=new Node(arr[i]);
            root.left=insertLevelOrder(arr,root.left,2*i+1);
            root.right=insertLevelOrder(arr,root.right,2*i+2);
        }
        return root;
    }
}
