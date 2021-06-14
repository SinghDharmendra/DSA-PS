package tree.traverse;

import tree.Node;

import java.util.LinkedList;
import java.util.Queue;

public class LevelOrderTraversal {
    public static void main(String[] args) {
     
        Node root= new Node(1);
        root.left= new Node(2);
        root.right= new Node(3);
        root.left.left= new Node(4);
        root.left.right= new Node(5);


        System.out.println("Level order traversal of binary tree is ");
                printLevelOrder(root);
    }

    private static void printLevelOrder(Node root) {
        Queue<Node> q=new LinkedList<>();
        System.out.println("In Level order traversal of binary tree is ");

        q.add(root);

        while(!q.isEmpty()){
            int size=q.size();
            for(int i=0; i<size; i++){
                Node pop=q.poll();
                System.out.print(pop.data+" ");
                if(pop.left!=null){
                    q.add(pop.left);
                }

                if(pop.right!=null){
                    q.add(pop.right);
                }
            }
            System.out.println();
        }
    }
}
