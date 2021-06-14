package linkedlist.delete;


import java.util.HashSet;
import java.util.Set;

class Node{
    int data;
    Node next;
    Node(){}
    Node(int data){
        this.data=data;
        this.next=null;
    }
}

public class RemoveDuplicatesFromAnUnsortedLinkedList {




    public static void main(String[] args)
    {
        /* The constructed linked list is:
         10->12->11->11->12->11->10*/
        Node start = new Node(10);
        start.next = new Node(12);
        start.next.next = new Node(11);
        start.next.next.next = new Node(11);
        start.next.next.next.next = new Node(12);
        start.next.next.next.next.next = new Node(11);
        start.next.next.next.next.next.next = new Node(10);

        System.out.println("Linked list before removing duplicates :");
        printList(start);

        removeDuplicate(start);

        System.out.println("\nLinked list after removing duplicates :");
        printList(start);
    }

    private static void removeDuplicate(Node head) {

        Set<Integer> set =new HashSet<>();

        Node current=head;
        Node prev=null;

        while(current!=null){
            int data=current.data;
            if(set.contains(data)){
                prev.next=current.next;
            }else{
                set.add(data);
                prev=current;

            }

            current=current.next;

        }
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
