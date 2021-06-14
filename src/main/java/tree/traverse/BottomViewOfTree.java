package tree.traverse;

import tree.Node;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class BottomViewOfTree {
    public static void main(String[] args)
    {
        Node root = new Node(20);
        root.left = new Node(8);
        root.right = new Node(22);
        root.left.left = new Node(5);
        root.left.right = new Node(3);
        root.right.left = new Node(4);
        root.right.right = new Node(25);
        root.left.right.left = new Node(10);
        root.left.right.right = new Node(14);

        System.out.println("Bottom view of the given binary tree:");
        bottomView(root);
    }

    private static void bottomView(Node node) {
        if(node == null)
            return;
        Map<Integer,Integer> hdist = new TreeMap<>();
        traverseRec(node,0,hdist);

        for(Map.Entry<Integer,Integer> e : hdist.entrySet() ){
            System.out.print(e.getValue()+" ");
        }


    }

    private static void traverseRec(Node node, int dist, Map<Integer, Integer> hdist) {
        hdist.put(dist,     node.data);
        if(node.left!=null){
            traverseRec(node.left,dist-1,hdist);
        }
        if(node.right!=null){
            traverseRec(node.right,dist+1,hdist);
        }
    }
}
