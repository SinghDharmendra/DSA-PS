package linkedlist.delete;

import java.util.HashSet;
import java.util.Set;

public class SegregateEvenAndOddNodesInALinkedList {
    public static void main(String[] args)
    {
        /* The constructed linked list is:
         10->12->11->11->12->11->10*/
        Node start = new Node(10);
        start.next = new Node(12);
        start.next.next = new Node(11);
        start.next.next.next = new Node(13);
        start.next.next.next.next = new Node(15);
        start.next.next.next.next.next = new Node(16);
        start.next.next.next.next.next.next = new Node(18);

        System.out.println("Linked list before removing duplicates :");
        printList(start);

        Node head=seggregateEvenOdd(start);

        System.out.println("\nLinked list after removing duplicates :");
        printList(start);
    }


    private static Node seggregateEvenOdd(Node head) {
        Node evenStart=null,evenEnd=null,oddStart=null,oddEnd=null;

        Node current=head;

        while(current!=null){
            int val=current.data;
            if(val%2==0){
                if(evenStart==null){
                    evenStart=current;
                    evenEnd=evenStart;
                }else{
                    evenEnd.next=current;
                    evenEnd=evenEnd.next;
                }
            }else{
                if(oddStart==null){
                    oddStart=current;
                    oddEnd=oddStart;

                }else{
                    oddEnd.next=current;
                    oddEnd=oddEnd.next;
                }
            }
            current=current.next;
        }

        if(evenStart==null || oddStart==null)
            return head;

        evenEnd.next=oddStart;
        oddEnd.next=null;
        head=evenEnd;
        return head;

    }



    static void printList(Node head)
    {
        while (head != null)
        {
            System.out.print(head.data + " ");
            head = head.next;
        }
    }

}
