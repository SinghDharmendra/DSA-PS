package tree.bt.checkandprint;

import tree.Node;

import java.util.LinkedList;
import java.util.Queue;

public class CheckIfAllLeavesAreAtSameLevel {
    public static void main(String[] args) {
        // Let us create the tree as shown in the example

        Node root = new Node(12);
        root.left = new Node(5);
        root.left.left = new Node(3);
        root.left.right = new Node(9);
        root.left.left.left = new Node(1);
        root.left.right.left = new Node(1);
        if (check(root))
            System.out.println("Leaves are at same level");
        else
            System.out.println("Leaves are not at same level");
    }

    private static boolean check(Node root) {
        int level=Integer.MAX_VALUE;

        Queue<Node> q=new LinkedList<>();
        System.out.println("In Level order traversal of binary tree is ");

        q.add(root);
        int curLevel=0;

        while(!q.isEmpty()){
            curLevel++;
            int size=q.size();
            for(int i=0; i<size; i++){
                Node pop=q.poll();
                //System.out.print(pop.data+" ");
                if(pop.left!=null){
                    q.add(pop.left);
                    if(pop.left.left!=null && pop.left.right!=null){
                        if(level==Integer.MAX_VALUE){
                            level=curLevel;
                        }else if(level!=curLevel){
                            return false;
                        }
                    }
                }

                if(pop.right!=null){
                    q.add(pop.right);
                    if(pop.right.left!=null && pop.right.right!=null){
                        if(level==Integer.MAX_VALUE){
                            level=curLevel;
                        }else if(level!=curLevel){
                            return false;
                        }
                    }
                }

            }



        }
        return true;
    }
}
