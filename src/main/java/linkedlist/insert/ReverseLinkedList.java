package linkedlist.insert;


public class ReverseLinkedList {
    public static void main(String[] args)
    {
       
       Node head= new Node(85);
       head.next = new Node(15);
       head.next.next = new Node(4);
       head.next.next.next = new Node(20);

        System.out.println("Given Linked list");
        printList(head);
        head = reverse(head);
        System.out.println("");
        System.out.println("Reversed linked list ");
        printList(head);
    }

    private static Node reverse(Node head) {

        Node current=head,prev=null,next=null;
        while(current!=null){
            next=current.next;
            current.next=prev;
            prev=current;
            current=next;
        }

        return prev;
    }

    static void printList(Node node)
    {
        while (node != null) {
            System.out.print(node.data + " ");
            node = node.next;
        }
    }

}
