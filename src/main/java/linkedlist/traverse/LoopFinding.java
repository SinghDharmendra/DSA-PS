package linkedlist.traverse;

import java.util.HashSet;
import java.util.Set;

public class LoopFinding {
    public static void main(String[] args) {
        Node head=new Node(1);
        Node current=head;

        Node last=null;

        for(int i=2;i<10;i++){
            current.next=new Node(i);
            last=current;
            current=current.next;
        }
        //last.next=head;

        boolean found=findLoopByHash(head);
        System.out.println("middle: "+found);

    }

    private static boolean findLoopByHash(Node head) {
        Set<Node> set=new HashSet<Node>();

        Node current=head;
        boolean isFound=false;

        while(current!=null){
            if(set.contains(current)){
                isFound= true;
                break;
            }
            set.add(current);

            current=current.next;
        }

        return isFound;
    }
}
