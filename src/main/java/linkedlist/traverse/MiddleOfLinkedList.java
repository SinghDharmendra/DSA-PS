package linkedlist.traverse;


class Node{
    int data;
    Node next;
    Node(){}
    Node(int data){
        this.data=data;
        this.next=null;
    }
}


public class MiddleOfLinkedList {
    public static void main(String[] args) {
        Node head=new Node(1);
        Node current=head;

        for(int i=2;i<5 ;i++){
            current.next=new Node(i);
            current=current.next;
        }

        Node middle=findMiddle(head);
        System.out.println("middle: "+middle.data);
        
    }

    private static Node findMiddle(Node head) {

        Node fast,slow;
        fast=head;
        slow=head;

        while(fast.next!=null&&fast.next.next!=null){
            fast=fast.next.next;
            slow=slow.next;
        }
        System.out.println(slow.data);
        System.out.println(fast==null?"null":fast.data);
        return slow;
    }
}
