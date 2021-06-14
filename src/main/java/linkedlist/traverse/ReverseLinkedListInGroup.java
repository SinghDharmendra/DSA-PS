package linkedlist.traverse;

public class ReverseLinkedListInGroup {
    public static void main(String[] args) {
        Node head=new Node(1);
        Node current=head;

        for(int i=2;i<10 ;i++){
            current.next=new Node(i);
            current=current.next;
        }
        int k=3;

        Node reverseInGroup=reverseInGroup(head,k);
        ReverseLinkedList.traverseList(reverseInGroup);
    }

    private static Node reverseInGroup(Node head, int k) {
        int count=0;

        Node prev=null,next=null,current=head;
        while(count<k && current!=null){
            next=current.next;
            current.next=prev;
            prev=current;
            current=next;
            count++;
        }

        if(next!=null){
            head.next=reverseInGroup(next,k);
        }
        return prev;
    }
}
