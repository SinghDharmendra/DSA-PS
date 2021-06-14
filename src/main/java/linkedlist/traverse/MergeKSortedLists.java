package linkedlist.traverse;

import java.util.PriorityQueue;

public class MergeKSortedLists {
    public static void main(String args[])
    {
        int k = 3; // Number of linked lists
        int n = 4; // Number of elements in each list

        // an array of pointers storing the head nodes
        // of the linked lists
        System.out.println("dats");
        Node arr[] = new Node[k];

        arr[0] = new Node(1);
        arr[0].next = new Node(3);
        arr[0].next.next = new Node(5);
        arr[0].next.next.next = new Node(7);

        arr[1] = new Node(2);
        arr[1].next = new Node(4);
        arr[1].next.next = new Node(6);
        arr[1].next.next.next = new Node(8);

        arr[2] = new Node(0);
        arr[2].next = new Node(9);
        arr[2].next.next = new Node(10);
        arr[2].next.next.next = new Node(11);

        // Merge all lists
        Node head = mergeKSortedLists(arr, k);
        printList(head);
    }

    public static void printList(Node head)
    {
        while (head != null) {
            System.out.print(head.data + " ");
            head = head.next;
        }
    }

    public static Node mergeKSortedLists(
            Node arr[], int k){
        PriorityQueue<Node> pq=new PriorityQueue<Node>((a,b)->(a.data-b.data));

        for(Node node:arr){
            pq.add(node);
        }

        Node dummy=new Node(-1);
        Node current=dummy;
        while(!pq.isEmpty()){

                    Node out=pq.poll();
                    if(out.next!=null){
                        pq.add(out.next);
                    }
            current.next=out;
            current=current.next;
        }
        return dummy.next;
    }

}
