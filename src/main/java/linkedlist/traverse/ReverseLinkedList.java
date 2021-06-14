package linkedlist.traverse;

public class ReverseLinkedList {
    public static void main(String[] args) {
        Node head = new Node(1);
        Node current = head;

        for (int i = 2; i < 5; i++) {
            current.next = new Node(i);
            current = current.next;
        }
        System.out.println("before");
        traverseList(head);

        Node reverse = reverse(head);
        //traverseList(head);

        System.out.println("after");

        traverseList(reverse);
       // System.out.println("middle: " + reverse.data);
    }


    public static Node reverse(Node head) {
        Node current=head,next=null,prev=null;

        while(current!=null){
            next=current.next;
            current.next=prev;
            prev=current;
            current=next;


        }
        return prev;
    }
    public static void traverseList(Node head){
        Node current=head;

        while(current!=null){
            System.out.println(current.data);
            current=current.next;
        }

    }


}
